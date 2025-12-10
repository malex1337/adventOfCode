package com.amayr.aoc2015.d5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.AOCTest;
import util.JUnitAOCTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

final class Day5Test extends JUnitAOCTest {
    @AOCTest(year = "2015", day = "5", isExample = "true", taskNr = "1", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given1Source")
    void given1(String input, int expected) {
        var day5 = new Day5();

        assertThat(day5.task1(List.of(input))).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "5", isExample = "faöse", taskNr = "1", includeFile = "true")
    @Test
    void task1(List<String> lines) {
        var day5 = new Day5();

        assertThat(day5.task1(lines)).isEqualTo(238);
    }

    @AOCTest(year = "2015", day = "5", isExample = "true", taskNr = "2", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given2Source")
    void given2(String input, int expected) {
        var day5 = new Day5();

        assertThat(day5.task2(List.of(input))).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "5", isExample = "false", taskNr = "2", includeFile = "true")
    @Test
    void task2(List<String> lines) {
        var day5 = new Day5();

        assertThat(day5.task2(lines)).isEqualTo(69);
    }

    private static Stream<Arguments> given1Source() {
        return Stream.of(
                Arguments.of("ugknbfddgicrmopn", 1),
                Arguments.of("aaa", 1),
                Arguments.of("jchzalrnumimnmhp", 0),
                Arguments.of("haegwjzuvuyypxyu", 0),
                Arguments.of("dvszwmarrgswjxmb", 0)
        );
    }

    private static Stream<Arguments> given2Source() {
        return Stream.of(
                Arguments.of("qjhvhtzxzqqjkmpb", 1),
                Arguments.of("xxyxx", 1),
                Arguments.of("uurcxstgmygtbstg", 0),
                Arguments.of("ieodomkazucvgmuy", 0)
        );
    }
}