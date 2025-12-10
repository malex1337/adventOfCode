package com.amayr.aoc2015.util;

public record Position(
        int x,
        int y
) {
    public static final Position UP = new Position(0, 1);
    public static final Position DOWN = new Position(0, -1);
    public static final Position LEFT = new Position(-1, 0);
    public static final Position RIGHT = new Position(1, 0);

    public Position() {
        this(0, 0);
    }

    public Position add(Position position) {
        return new Position(this.x + position.x, this.y + position.y);
    }
}