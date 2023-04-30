package utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtils {

    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateRandomString(int count) {
        StringBuilder builder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int maxRandomInt = ALPHA_NUMERIC_STRING.length();
        for (int i = 0; i < count; i++) {
            int randomIndex = secureRandom.nextInt(maxRandomInt);
            builder.append(ALPHA_NUMERIC_STRING.charAt(randomIndex));
        }
        return builder.toString();
    }

    public static String generateRandomNumber(int count) {
        StringBuilder builder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int randomIndex = secureRandom.nextInt(10);
            builder.append(randomIndex);
        }
        return builder.toString();
    }
}
