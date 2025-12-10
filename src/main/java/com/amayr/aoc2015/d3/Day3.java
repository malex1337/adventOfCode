package com.amayr.aoc2015.d3;

import com.amayr.aoc2015.util.Pos;

import java.util.HashMap;
import java.util.List;

public final class Day3 {
    public int task1(List<String> lines) {
        var initialPosition = new Pos();

        var visited = new HashMap<Pos, Integer>();

        for (String line : lines) {
            visited.clear();
            visited.put(initialPosition, 1);

            for (int i = 0; i < line.length(); i++) {
                char direction = line.charAt(i);
                initialPosition = move(direction, initialPosition);
                visited.compute(initialPosition, (key, val) -> (val == null) ? 1 : val + 1);
            }
        }

        return visited.size();
    }

    public int task2(List<String> lines) {
        var initialPositionS = new Pos();
        var initialPositionR = new Pos();

        var visited = new HashMap<Pos, Integer>();
        visited.put(initialPositionS, 1);
        visited.put(initialPositionR, 1);

        for (String line : lines) {
            for (int i = 0; i < line.length(); i += 2) {
                char directionS = line.charAt(i);
                char directionR = line.charAt(i + 1);

                initialPositionS = move(directionS, initialPositionS);
                initialPositionR = move(directionR, initialPositionR);
                visited.compute(initialPositionS, (key, val) -> (val == null) ? 1 : val + 1);
                visited.compute(initialPositionR, (key, val) -> (val == null) ? 1 : val + 1);
            }
        }

        return visited.size();
    }

    private Pos move(char direction, Pos pos) {
        return switch (direction) {
            case '^' -> pos.add(Pos.UP);
            case 'v' -> pos.add(Pos.DOWN);
            case '<' -> pos.add(Pos.LEFT);
            case '>' -> pos.add(Pos.RIGHT);
            default -> pos;
        };
    }
}