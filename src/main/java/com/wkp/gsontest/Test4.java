package com.wkp.gsontest;

import com.google.gson.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.*;

public class Test4 {

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
        Random random = new Random();

        for (int index = 0; index < 200; index++) {
            //System.out.println(random.nextInt(10));
            System.out.println(random.nextInt(100));
        }


        Test4 test4 = new Test4();
        JsonObject result = new JsonObject();
        result.addProperty("field1", "123");
        result.addProperty("field1", "123");
        System.out.println(result);

        result.addProperty("field1", "456");
        //JsonElement element =  new JSo
        //result.add
        System.out.println(result);
    }
}
