package com.amayr.aoc2015.d3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.AOCTest;
import util.JUnitAOCTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

final class Day3Test extends JUnitAOCTest {

    @AOCTest(year = "2015", day = "3", isExample = "true", taskNr = "1", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given1Source")
    void given1(String input, int expected) {
        var day3 = new Day3();

        assertThat(day3.task1(List.of(input))).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "3", isExample = "false", taskNr = "1", includeFile = "true")
    @Test
    void task1(List<String> input) {
        var day3 = new Day3();

        assertThat(day3.task1(input)).isEqualTo(2572);
    }

    @AOCTest(year = "2015", day = "3", isExample = "true", taskNr = "2", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given2Source")
    void given2(String input, int expected) {
        var day3 = new Day3();

        assertThat(day3.task2(List.of(input))).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "3", isExample = "false", taskNr = "2", includeFile = "true")
    @Test
    void given2(List<String> lines) {
        var day3 = new Day3();

        assertThat(day3.task2(lines)).isEqualTo(2631);
    }

    private static Stream<Arguments> given1Source() {
        return Stream.of(
                Arguments.of(">", 2),
                Arguments.of("^>v<", 4),
                Arguments.of("^v^v^v^v^v", 2)
        );
    }

    private static Stream<Arguments> given2Source() {
        return Stream.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11)
        );
    }
}