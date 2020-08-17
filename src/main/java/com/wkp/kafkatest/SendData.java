package com.wkp.kafkatest;

import com.kuaishou.flink.core.kafka.KafkaClusterSource;
import com.kuaishou.flink.core.utils.FlinkProducerUtils;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;

import java.util.Properties;

/**
 * @Description DESC
 * @Date 2020/8/14 12:16 下午
 * @Created by wangkunpeng
 */
public class SendData {

    private static StreamExecutionEnvironment getStreamExecutionEnvironment(int checkpointInterval, int checkpointTimeout) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setRestartStrategy(RestartStrategies.fixedDelayRestart(RESTART_ATTEMPTS, DELAY_BETWEEN_ATTEMPTS));
        env.enableCheckpointing(checkpointInterval);
        env.getCheckpointConfig().setFailOnCheckpointingErrors(false);
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
        env.getCheckpointConfig().setCheckpointTimeout(checkpointTimeout);
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(MIN_PAUSE_CHECKPOINT_INTERVAL);
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(MAX_CONCURRENT_CHECKPOINTS);
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);
        env.getConfig().enableForceAvro();
        return env;
    }

    public static void main(String[] args) {

        String sendTopicName = "staging-lf-log1-ad_qa_online_check";
        KafkaClusterSource producerKafkaCluster = KafkaClusterSource.valueOf(" bjfk-staging1");
        Properties producerProperties = FlinkProducerUtils.getProducerProperties(producerKafkaCluster);
        producerProperties.setProperty("bootstrap.servers", producerKafkaCluster.getBrokersAsString());
        producerProperties.setProperty("retries", "500");
        producerProperties.setProperty("request.timeout.ms", "60000");
        FlinkKafkaProducer010 producer = new FlinkKafkaProducer010(sendTopicName, new SimpleStringSchema(), producerProperties);


        ParameterTool commandParams = ParameterTool.fromArgs(args);
        int checkpointInterval = commandParams.getInt("checkpointInterval", 10 * 100 ());
        int checkpointTimeout = commandParams.getInt("checkpointTimeout", 30 * 1000);
        StreamExecutionEnvironment streamEnv = getStreamExecutionEnvironment(checkpointInterval, checkpointTimeout);
        streamEnv.getConfig().setGlobalJobParameters(commandParams);

        DataStream<String> inputStream = streamEnv.addSource(logSource.setStartFromEarliest());

        while (true) {
            producer.invoke();
        }
    }
}
