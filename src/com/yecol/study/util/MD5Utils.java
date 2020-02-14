package com.yecol.study.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author yecol
 *
 */
public class MD5Utils {
	
	public static void main(String[] args) {
		String md=stringToMD5("123456");
		System.out.println(md);
	}
	
	private static final String salt="wenber";
	
	public static String stringToMD5(String plainText) {
		plainText=plainText+salt;
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
