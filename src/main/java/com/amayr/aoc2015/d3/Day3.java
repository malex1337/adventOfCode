package com.amayr.aoc2015.d3;

import com.amayr.aoc2015.util.Position;

import java.util.HashMap;
import java.util.List;

public final class Day3 {
    public int task1(List<String> lines) {
        var initialPosition = new Position();

        var visited = new HashMap<Position, Integer>();

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
        var initialPositionS = new Position();
        var initialPositionR = new Position();

        var visited = new HashMap<Position, Integer>();
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

    private Position move(char direction, Position position) {
        return switch (direction) {
            case '^' -> position.add(Position.UP);
            case 'v' -> position.add(Position.DOWN);
            case '<' -> position.add(Position.LEFT);
            case '>' -> position.add(Position.RIGHT);
            default -> position;
        };
    }
}