package com.amayr.aoc2015.d4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class Day4 {

    public long task1(List<String> lines) throws NoSuchAlgorithmException {
        return findNumber(lines.getFirst(), "00000");
    }

    public long task2(List<String> lines) throws NoSuchAlgorithmException {
       return findNumber(lines.getFirst(), "000000");
    }

    private long findNumber(String line, String startsWith) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        long number = 0;

        while (true) {
            String key = String.format("%s%d", line, number);
            byte[] digest = md.digest(key.getBytes());
            if (bytesToHexString(digest).startsWith(startsWith)) {
                break;
            }
            number++;
        }

        return number;
    }

    private static String bytesToHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }
}