package com.amayr.aoc2015.util;

public record Pos(
        int x,
        int y
) {
    public static final Pos UP = new Pos(0, 1);
    public static final Pos DOWN = new Pos(0, -1);
    public static final Pos LEFT = new Pos(-1, 0);
    public static final Pos RIGHT = new Pos(1, 0);

    public Pos() {
        this(0, 0);
    }

    public Pos add(Pos pos) {
        return new Pos(this.x + pos.x, this.y + pos.y);
    }
}