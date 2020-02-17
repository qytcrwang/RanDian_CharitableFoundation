package com.hisense.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA256Util {

    /**
    * 利用java原生的摘要实现SHA256加密
    * @param message 需要加密的报文
    * @return SHA256加密后的密文串
     */
    public static String getSHA256Code2(String message){
         MessageDigest messageDigest;
         String encodeStr = "";
         try {
              messageDigest = MessageDigest.getInstance("SHA-256");
              messageDigest.update(message.getBytes("UTF-8"));
              encodeStr = byte2Hex(messageDigest.digest());
         } catch (NoSuchAlgorithmException e) {
              e.printStackTrace();
         } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
         }
         return encodeStr;
    }

    /**
     * 将byte转为16进制
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0; i<bytes.length; i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /**
     * SHA256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String SHA256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byte2Hex(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     * SHA256_HMAC加密
     * @param message 消息
     * @return 加密后字符串
     */
    public static String getSHA256Code(String message) {
        String hash = "";
        String secret = "dragon买了台i72700k+rtx2060学习机";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byte2Hex(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }
    public static void main(String[] args) {
    	System.out.println(getSHA256Code2(getSHA256Code2("Huawei@123")+"wojiubuyongzhongwen"));
		System.out.println(getSHA256Code2("Huawei@123"));
	}
}
