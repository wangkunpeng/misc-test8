package com.wkp.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Test1 {

    public static void main(String[] args) {
        long nl = 0;
        System.out.println(nl);
        Student student = new Student();
        //student.setId(0L);
        student.setName("jike");

        Gson gson = new GsonBuilder().create();
        String gsonStr = gson.toJson(student);

        System.out.println(gsonStr);

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(gsonStr);
        System.out.println(jsonElement.getAsJsonObject());
        //System.out.println(jsonElement.getAsString());
        System.out.println(jsonElement.getAsJsonObject().get("name"));
        //System.out.println(jsonElement.getAsJsonPrimitive());


    }
}
