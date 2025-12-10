package com.amayr.aoc2015.d5;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public final class Day5 {
    private final List<String> forbidden = List.of("ab", "cd", "pq", "xy");
    private final List<String> vowels = List.of("a", "e", "i", "o", "u");
    // one letter appearing twice

    public int task1(List<String> lines) {
        int niceStrings = 0;

        for (String line : lines) {
            boolean allowed = true;

            for (String f : forbidden) {
                if (line.contains(f)) {
                    allowed = false;
                    break;
                }
            }

            if (!allowed) {
                continue;
            }

            int vowelCount = 0;
            for (String v : vowels) {
                vowelCount += StringUtils.countMatches(line, v);
                if (vowelCount >= 3) {
                    break;
                }
            }
            if (vowelCount < 3) {
                continue;
            }

            boolean containsDoubles = false;
            for (int i = 0; i < line.length() - 1 && !containsDoubles; i++) {
                if (line.charAt(i) == line.charAt(i + 1)) {
                    containsDoubles = true;
                }
            }

            if (containsDoubles) {
                niceStrings++;
            }
        }


        return niceStrings;
    }

    public int task2(List<String> lines) {
        int niceStrings = 0;

        for (String line : lines) {
            // 2 letters appearing twice without overlapping, xyxy or aabcdefgaa
            var pairFound = false;
            for (int i = 0; i < line.length() - 1 && !pairFound; i++) {
                String pair = line.substring(i, i + 2);
                if (line.indexOf(pair, i + 2) != -1) {
                    pairFound = true;
                }
            }

            // 1 letter repeating at least once with exactly one letter between them
            var specialFound = false;
            for (int i = 0; i < line.length() - 2 && !specialFound; i++) {
                var current = line.charAt(i);
                var nextNext = line.charAt(i + 2);

                if (current == nextNext) {
                    specialFound = true;
                }
            }

            if (pairFound && specialFound) {
                niceStrings++;
            }
        }

        return niceStrings;
    }
}