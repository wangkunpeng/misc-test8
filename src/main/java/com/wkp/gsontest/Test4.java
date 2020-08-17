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

public class Test3 {

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

        Map result = new HashMap();

        Map<String, List<CompareResult>> map = new HashMap();
        List<CompareResult> resList = new LinkedList<CompareResult>();
        CompareResult res1 = new CompareResult("1", "1", "1", "1", 1, false);
        resList.add(res1);
        CompareResult res2 = new CompareResult("2", "2", "2", "2", 2, false);
        resList.add(res2);
        map.put("res_1", resList);

        result.put("caseInfo", "{}");
        result.put("compareResult", map);


        Gson gson = new GsonBuilder().create();
        String jsonStr = gson.toJson(result);
        System.out.println(jsonStr);


        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonStr);

        System.out.println(jsonElement.getAsJsonObject().get("caseInfo").getAsJsonPrimitive());
        System.out.println(parser.parse(jsonElement.getAsJsonObject().get("caseInfo").getAsString()));
        System.out.println(jsonElement.getAsJsonObject().get("compareResult").getAsJsonObject().get("res_1").getAsJsonArray().get(0));


        JsonParser parser1 = new JsonParser();
        JsonElement element2 = parser1.parse(jsonStr);
        System.out.println(element2);

    }
}
