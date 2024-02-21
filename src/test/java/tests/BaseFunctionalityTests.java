package tests;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.utils.retry.AutomationRetry;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class BaseFunctionalityTests extends TestBase {


    @Test(retryAnalyzer = AutomationRetry.class)
    public void verifyGetAllBooks() {
        List<BookDto> bookList = bookServiceClient.readAllBooks();
        System.out.println(bookList);
    }

    @Test(retryAnalyzer = AutomationRetry.class)
    public void verifyGetOneBook() {
        BookDto oneBook = bookServiceClient.readABook(574).get();
        System.out.println(oneBook);
    }


}
