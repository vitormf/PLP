package loo1.plp.orientadaObjetos1.unitTests;

import loo1.plp.expressions2.expression.Id;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private static class TestRun {
        Id testId;
        boolean success;
        Exception exception;

        TestRun(Id testId, boolean success, Exception exception) {
            this.testId = testId;
            this.success = success;
            this.exception = exception;
        }
    }

    private static TestRunner instance = new TestRunner();

    private List<TestRun> testRuns = new ArrayList<>();

    public static void addSuccess(Id testId) {
        instance.testRuns.add(new TestRun(testId, true, null));
    }

    public static void addFailure(Id testId, Exception exception) {
        instance.testRuns.add(new TestRun(testId, false, exception));
    }


    public static String report() {
        StringBuilder builder = new StringBuilder();

        for (TestRun testRun : instance.testRuns) {
            String name = testRun.testId.toString();
            if (testRun.success) {
                builder.append(String.format("\n%s: sucesso", name));
            } else {
                String excMessage = testRun.exception != null ? testRun.exception.getMessage() : "";
                builder.append(String.format("\n%s: FALHOU - %s", name, excMessage));
            }
        }

        return builder.toString();
    }

    public static void clear() {
        instance.testRuns.clear();
    }
}