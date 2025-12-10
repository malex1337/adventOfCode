package com.amayr.aoc2015.d1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.AOCTest;
import util.JUnitAOCTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


final class Day1Test extends JUnitAOCTest {

    @AOCTest(year = "2015", day = "1", isExample = "true", taskNr = "1", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given1Source")
    void given1(String input, int expected) {
        var day1 = new Day1();

        assertThat(day1.task1(input)).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "1", isExample = "false", taskNr = "1", includeFile = "true")
    @Test
    void task1(List<String> lines) {
        var day1 = new Day1();

        var result = day1.task1(lines.getFirst());

        assertThat(result).isEqualTo(138);
    }

    @AOCTest(year = "2015", day = "1", isExample = "true", taskNr = "2", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given2Source")
    void given2(String input, int expected) {
        var day1 = new Day1();

        assertThat(day1.task2(input)).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "1", isExample = "false", taskNr = "2", includeFile = "true")
    @Test
    void task2(List<String> lines) {
        var day1 = new Day1();

        var result = day1.task2(lines.getFirst());

        assertThat(result).isEqualTo(1771);
    }

    private static Stream<Arguments> given1Source() {
        return Stream.of(
                Arguments.of("(())", 0),
                Arguments.of("(((", 3),
                Arguments.of("(()(()(", 3),
                Arguments.of("))(((((", 3),
                Arguments.of("())", -1),
                Arguments.of("))(", -1),
                Arguments.of(")))", -3),
                Arguments.of(")())())", -3)
        );
    }

    private static Stream<Arguments> given2Source() {
        return Stream.of(
                Arguments.of(")", 1),
                Arguments.of("()())", 5)
        );
    }
}