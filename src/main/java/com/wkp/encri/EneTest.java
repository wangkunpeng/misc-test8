package com.wkp.encri;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * @Description DESC
 * @Date 2020/8/26 11:27 上午
 * @Created by wangkunpeng
 */
public class EneTest {

    //String keyStr = "aeskey-fromksbiz";
    public static Cipher getAESCipher(String keyStr) throws Exception {
        Key key = new SecretKeySpec(keyStr.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(0.0 == 0);

        String keyStr = "aeskey-fromksbiz";
        Cipher cipher = getAESCipher("aeskey-fromksbiz");

        byte[] encResult = cipher.doFinal("原文".getBytes());
        System.out.println(new String(encResult));

        Key key = new SecretKeySpec(keyStr.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        System.out.println(new String(cipher.doFinal(encResult)));

    }
}
