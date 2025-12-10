package com.amayr.aoc2015.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class Day2 {
    private final Pattern pattern = Pattern.compile("(\\d*)x(\\d*)x(\\d*)");

    public int task1(List<String> lines) {
        var totalPaper = 0;

        for (String line : lines) {
            var matcher = pattern.matcher(line);
            matcher.find();
            int l = Integer.parseInt(matcher.group(1));
            int w = Integer.parseInt(matcher.group(2));
            int h = Integer.parseInt(matcher.group(3));

            int area1 = l * w;
            int area2 = w * h;
            int area3 = h * l;

            int extraPaper = Math.min(area1, Math.min(area2, area3));

            totalPaper += 2 * area1 + 2 * area2 + 2 * area3 + extraPaper;
        }

        return totalPaper;
    }

    public int task2(List<String> lines) {
        var totalRibbons = 0;

        for (String line : lines) {
            var matcher = pattern.matcher(line);
            matcher.find();
            int l = Integer.parseInt(matcher.group(1));
            int w = Integer.parseInt(matcher.group(2));
            int h = Integer.parseInt(matcher.group(3));

            var list = new ArrayList<>(Arrays.asList(l, w, h));
            Collections.sort(list);

            totalRibbons += 2 * list.getFirst() + 2 * list.get(1) + l * w * h;
        }
        return totalRibbons;
    }
}