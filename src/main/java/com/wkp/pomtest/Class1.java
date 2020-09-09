package com.wkp.pomtest;

import com.google.gson.Gson;
import com.kuaishou.framework.util.ObjectMapperUtils;
import org.apache.flink.table.expressions.In;


/**
 * @Description DESC
 * @Date 2020/8/18 9:43 下午
 * @Created by wangkunpeng
 */
public class Class1 {

    static class Inener1 {
        String name;
        int id;
    }

    public static void main(String[] args) {

        Inener1 inener1 = new Inener1();
        inener1.id = 0;
        inener1.name = "";

        Gson gson = new Gson();
        System.out.println(gson.toJson(inener1));
        //ObjectMapperUtils.toJSON(inener1);
        //System.out.println(ObjectMapperUtils.toJSON(inener1));

//        AdAndromedaClueClient clueClient = AndromedaClientSafeBuilder.getBuilder(
//                new ClientConfigDesc(AdAndromedaBizTypeEnum.AD_LP)
//        ).getConfClueClient();



    }
}
