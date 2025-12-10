package com.amayr.aoc2015.d4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.AOCTest;
import util.JUnitAOCTest;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

final class Day4Test extends JUnitAOCTest {

    @AOCTest(year = "2015", day = "4", isExample = "true", taskNr = "1", includeFile = "false")
    @ParameterizedTest
    @MethodSource("given1Source")
    void given1(String input, int expected) throws NoSuchAlgorithmException {
        var day4 = new Day4();

        assertThat(day4.task1(List.of(input))).isEqualTo(expected);
    }

    @AOCTest(year = "2015", day = "4", isExample = "false", taskNr = "1", includeFile = "false")
    @Test
    void task1() throws NoSuchAlgorithmException {
        var day4 = new Day4();

        assertThat(day4.task1(List.of("iwrupvqb"))).isEqualTo(346386L);
    }

    @AOCTest(year = "2015", day = "4", isExample = "false", taskNr = "2", includeFile = "false")
    @Test
    void task2() throws NoSuchAlgorithmException {
        var day4 = new Day4();

        assertThat(day4.task2(List.of("iwrupvqb"))).isEqualTo(9958218L);
    }

    private static Stream<Arguments> given1Source() {
        return Stream.of(
                Arguments.of("abcdef", 609043),
                Arguments.of("pqrstuv", 1048970)
        );
    }
}