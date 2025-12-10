package com.amayr.aoc2015.d6;

import com.amayr.aoc2015.util.Pos;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public final class Day6 {
    private final Pattern pattern = Pattern.compile("(turn on|turn off|toggle) (\\d*),(\\d*) through (\\d*),(\\d*)");
    private final boolean[][] grid = new boolean[1000][1000];
    private final int[][] grid2 = new int[1000][1000];

    public int task1(List<String> lines) {
        for (String line : lines) {
            var matcher = pattern.matcher(line);
            matcher.find();

            String command = matcher.group(1);
            var from = new Pos(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
            var to = new Pos(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));


            UnaryOperator<Boolean> func;
            switch (command) {
                case "turn on" -> func = b -> true;
                case "turn off" -> func = b -> false;
                case "toggle" -> func = b -> !b;
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }

            for (int i = from.y(); i <= to.y(); i++) {
                for (int j = from.x(); j <= to.x(); j++) {
                    grid[i][j] = func.apply(grid[i][j]);
                }
            }
        }

        var on = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j]) {
                    on++;
                }
            }
        }
        return on;
    }

    public int task2(List<String> lines) {
        for (String line : lines) {
            var matcher = pattern.matcher(line);
            matcher.find();

            String command = matcher.group(1);
            var from = new Pos(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
            var to = new Pos(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));

            UnaryOperator<Integer> func;
            switch (command) {
                case "turn on" -> func = b -> b + 1;
                case "turn off" -> func = b -> Math.max(b - 1, 0);
                case "toggle" -> func = b -> b + 2;
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }

            for (int i = from.y(); i <= to.y(); i++) {
                for (int j = from.x(); j <= to.x(); j++) {
                    grid2[i][j] = func.apply(grid2[i][j]);
                }
            }
        }

        var brightness = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                brightness += grid2[i][j];
            }
        }
        return brightness;
    }
}