package util;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(AOCFileResolver.class)
public @interface AOCTest {
    String year();

    String day();

    String isExample();

    String taskNr();

    String includeFile();
}