package com.zyy.mowa.utils;

import java.util.Random;

public class RandomCodeUtil {

//  设置字符
    public static final char[] chars="1234567890QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();

//  设置随机数
    public static Random random = new Random();

//  获取4位随机数
    public static String getRandomCode(){
        StringBuffer buffer = new StringBuffer();
        int index;   //获取随机chars下标
        for(int i=0;i<4;i++){
            index = random.nextInt(chars.length);  //获取随机chars下标
            buffer.append(chars[index]);
        }
        return buffer.toString();
    }

}
