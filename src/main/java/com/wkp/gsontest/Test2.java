package com.wkp.gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test2 {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class CompareResult {
        String task_check_id;
        String paramName;
        String originValue;
        String value;
        int diffType;
        boolean compareResult;
    }

    public static void main(String[] args) {

        Map<String, List<CompareResult>> map = new HashMap();

        List<CompareResult> resList = new LinkedList<CompareResult>();


        CompareResult res1 = new CompareResult("1", "1", "1", "1", 1, false);
        resList.add(res1);
        CompareResult res2 = new CompareResult("2", "2", "2", "2", 2, false);
        resList.add(res2);

        map.put("res_1", resList);

        Gson gson = new GsonBuilder().create();
        String jsonStr = gson.toJson(map);
        Map mapObj = gson.fromJson(jsonStr, Map.class);

        Object object = ((List) mapObj.get("res_1")).get(0);
        System.out.println(object);

        Gson gson1 = new GsonBuilder().create();
        CompareResult result = gson1.fromJson(object.toString(), CompareResult.class);
        System.out.println("result " + result);

        JsonParser parser = new JsonParser();
        //System.out.println(((CompareResult) ((List) mapObj.get("res_1")).get(1)).getOriginValue());
        System.out.println(jsonStr);


        JsonParser parser1 = new JsonParser();
        JsonElement element2 = parser1.parse(jsonStr);
        System.out.println(element2);

        System.out.println(element2.getAsJsonObject().get("1"));

        System.out.println(element2.getAsJsonObject().get("1"));
        System.out.println(element2.getAsJsonObject().get("res_1").getAsJsonArray().get(0).getAsJsonObject().get("task_check_id"));
        //System.out.println(element2.getAsJsonObject().get("res_1").getAsJsonArray().get(0).ge);

        /***
         *
         */
        // JsonElement element1 = gson.toJsonTree(jsonStr);
        // System.out.println(element1);
    }
}
