package com.jh.user.util;

import java.util.Random;

public class Uuid {

    public static String characters = "0123456789";
    public static String randomNum1(int factor){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < factor; i++) {
            // nextInt(10) = [0, 10)
            sb.append(characters.charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
