package com.amayr.aoc2015.d2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.AOCTest;
import util.JUnitAOCTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class Day2Test extends JUnitAOCTest {

    @AOCTest(year = "2015", day = "2", isExample = "true", taskNr = "1", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given1Source")
    void given1(String input, int expected) {
        var day2 = new Day2();

        assertEquals(day2.task1(List.of(input)), expected);
    }

    @AOCTest(year = "2015", day = "2", isExample = "false", taskNr = "1", includeFile = "true")
    @Test
    void task1(List<String> lines) {
        var day2 = new Day2();

        var result = day2.task1(lines);

        assertThat(result).isEqualTo(1588178);
    }

    @AOCTest(year = "2015", day = "2", isExample = "true", taskNr = "2", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given2Source")
    void given2(String input, int expected) {
        var day2 = new Day2();

        assertEquals(day2.task2(List.of(input)), expected);
    }

    @AOCTest(year = "2015", day = "2", isExample = "false", taskNr = "2", includeFile = "true")
    @Test
    void task2(List<String> lines) {
        var day2 = new Day2();

        var result = day2.task2(lines);

        assertThat(result).isEqualTo(3783758);
    }

    private static Stream<Arguments> given1Source() {
        return Stream.of(
                Arguments.of("2x3x4", 58),
                Arguments.of("1x1x10", 43)
        );
    }

    private static Stream<Arguments> given2Source() {
        return Stream.of(
                Arguments.of("2x3x4", 34),
                Arguments.of("1x1x10", 14)
        );
    }
}