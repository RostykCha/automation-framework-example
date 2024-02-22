package automationframeworkexample.utils.wrappers;

import io.qameta.allure.Step;

public class LoggerWrapper {

    @Step("INFO: {message}")
    public static void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    @Step("ERROR: {message}")
    public static void logError(String message) {
        System.out.println("ERROR: " + message);
    }

}
