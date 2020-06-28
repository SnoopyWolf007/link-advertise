package org.link.advertise.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/28 18:05
 */
public class Md5Util {

    private Md5Util() {
    }

    public static String md5(String str) {
        String md5Val = null;
        char[] hexDigist = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            //16个字节的长整数
            byte[] datas = md.digest();

            char[] strArr = new char[2 * 16];
            int k = 0;

            for (int i = 0; i < 16; i++) {
                byte b = datas[i];
                //高4位
                strArr[k++] = hexDigist[b >>> 4 & 0xf];
                //低4位
                strArr[k++] = hexDigist[b & 0xf];
            }
            md5Val = new String(strArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Val;
    }
}
