package tests;

import automationframeworkexample.utils.retry.AutomationRetry;
import org.testng.annotations.Test;

@Test
public class BaseFunctionalityTests extends TestBase {


    @Test(retryAnalyzer = AutomationRetry.class, dataProvider = "testDataProvider")
    public void verifyGetAllBooks(Integer bookId) {
        System.out.println(bookId);
    }


}
