package com.amayr.aoc2015.d1;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public final class Day1 {

    public int task1(String line) {
        var chars = line.toCharArray();

        var grouped = IntStream.range(0, line.length())
                .mapToObj(i -> chars[i])
                .collect(groupingBy(c -> c));


        var up = grouped.get('(') == null ? 0 : grouped.get('(').size();
        var down = grouped.get(')') == null ? 0 : grouped.get(')').size();

        return up - down;

    }

    public int task2(String line) {
        var chars = line.toCharArray();

        var currFloor = 0;
        var idx = 0;

        for (int i = 0; i < chars.length && currFloor != -1; i++) {
            if (chars[i] == '(') {
                currFloor++;
            } else {
                currFloor--;
            }
            idx = i;
        }

        return idx + 1;
    }

}