package tests;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.utils.retry.AutomationRetry;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class BaseFunctionalityTests extends TestBase {


    @Test(retryAnalyzer = AutomationRetry.class)
    public void verifyGetAllBooks() {
        List<BookDto> bookList = bookServiceClient.readBooks();
        System.out.println(bookList);
    }


}
