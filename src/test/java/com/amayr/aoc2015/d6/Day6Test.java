package com.amayr.aoc2015.d6;

import org.junit.jupiter.api.Test;
import util.AOCTest;
import util.JUnitAOCTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class Day6Test extends JUnitAOCTest {
    @AOCTest(year = "2015", day = "6", isExample = "true", taskNr = "1", includeFile = "false")
    @Test
    void given1() {
        var day6 = new Day6();

        assertThat(day6.task1(
                List.of(
                        "turn on 0,0 through 999,999",
                        "toggle 0,0 through 999,0",
                        "turn off 499,499 through 500,500")
        )).isEqualTo(998996);
    }

    @AOCTest(year = "2015", day = "6", isExample = "false", taskNr = "1", includeFile = "true")
    @Test
    void task1(List<String> lines) {
        var day6 = new Day6();

        assertThat(day6.task1(lines)).isEqualTo(543903);
    }

    @AOCTest(year = "2015", day = "6", isExample = "true", taskNr = "2", includeFile = "false")
    @Test
    void given2() {
        var day6 = new Day6();

        assertThat(day6.task2(
                List.of(
                        "turn on 0,0 through 0,0",
                        "toggle 0,0 through 999,999")
        )).isEqualTo(2000001);
    }

    @AOCTest(year = "2015", day = "6", isExample = "false", taskNr = "2", includeFile = "true")
    @Test
    void task2(List<String> lines) {
        var day6 = new Day6();

        assertThat(day6.task2(lines)).isEqualTo(14687245);
    }

}