package util;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class JUnitAOCTest {
    private static final int TOTAL_WIDTH = 50;
    private static final String DELIMITER = "~";

    private final StopWatch stopWatch = StopWatch.create();

    @BeforeEach
    void setUp(TestInfo testInfo) {
        printHeader(getAnnotation(testInfo));
        stopWatch.start();
    }

    @AfterEach
    void tearDown() {
        stopWatch.stop();

        printFooter(stopWatch.getTime());
        stopWatch.reset();
    }

    private AOCTest getAnnotation(TestInfo testInfo) {
        var m = testInfo.getTestMethod().orElseThrow(() -> new IllegalStateException("No test method found!"));

        AOCTest annotation = m.getAnnotation(AOCTest.class);

        if (annotation == null) {
            throw new IllegalStateException("No AOCFile annotation found on method: " + m.getName());
        }

        return annotation;
    }

    private void printHeader(AOCTest annotation) {
        String title = " AOC day " + annotation.day() + ", task: " + annotation.taskNr() + (annotation.isExample().equals("true") ? " (example) " : " ");
        int pad = (TOTAL_WIDTH - title.length()) / 2;
        int padRight = TOTAL_WIDTH - title.length() - pad;

        System.out.println(DELIMITER.repeat(TOTAL_WIDTH));
        String header = DELIMITER.repeat(pad) + title + DELIMITER.repeat(padRight);
        System.out.println(header);
        System.out.println(DELIMITER.repeat(TOTAL_WIDTH));

    }

    private void printFooter(long runtimeMs) {
        System.out.println("\n-\nDONE!\nTime: " + runtimeMs + " ms\n");
    }
}