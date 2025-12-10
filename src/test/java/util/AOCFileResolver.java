package util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;


public class AOCFileResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Method method = extensionContext.getTestMethod().orElse(null);

        if (method != null) {
            AOCTest annotation = method.getAnnotation(AOCTest.class);

            return annotation != null
                    && Boolean.parseBoolean(annotation.includeFile())
                    && List.class.equals(parameterContext.getParameter().getType());
        }

        return false;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Method method = extensionContext.getTestMethod().orElseThrow();
        AOCTest annotation = method.getAnnotation(AOCTest.class);

        if (!Boolean.parseBoolean(annotation.includeFile())) {
            return null;
        }

        InputStream is = this.getClass().getClassLoader().getResourceAsStream(buildFilePath(annotation));

        if (is == null) {
            throw new IllegalArgumentException("File not found: " + buildFilePath(annotation));
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String buildFilePath(AOCTest annotation) {
        return "aoc" + annotation.year() + "/d" + annotation.day() + "/"
                + (annotation.isExample().equals("true") ? "given" : "task") + annotation.taskNr();
    }
}