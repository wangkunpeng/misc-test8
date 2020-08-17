package com.wkp.fasterxmltest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class FasterxmlTest extends Application {

    public static class Linkman implements Serializable {
        public int id;
        public String name;

        public Linkman() {
        }

        @JsonCreator
        // 构造函数或者工厂方法有多个参数时，参数必须使用JsonProperty或JacksonInject注解。
        public Linkman(@JsonProperty("linkman_name") String name, @JsonProperty("linkman_id") int id) {
            this.name = name;
            this.id = id;
        }

        @JsonCreator
        // 构造函数或者工厂方法只有一个参数时，可以不加JsonProperty或JacksonInject注解。
        public Linkman(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Linkman{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        String json = "{\"linkman_name\":\"chushiyan\"}";
        ObjectMapper mapper = new ObjectMapper();
        Linkman linkman = mapper
                .readerFor(Linkman.class)
                .readValue(json);
        System.out.println(linkman);
    }
}
