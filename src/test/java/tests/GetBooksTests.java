package tests;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.utils.retry.AutomationRetry;
import automationframeworkexample.utils.wrappers.TestCaseDocumentationId;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class GetBooksTests extends TestBase {


    @Test(retryAnalyzer = AutomationRetry.class)
    @TestCaseDocumentationId(testCaseId = "35353")
    public void verifyGetAllBooks_T35353() {


        List<BookDto> bookList = bookServiceClient.readAllBooks();

    }

    @Test(retryAnalyzer = AutomationRetry.class)
    @TestCaseDocumentationId(testCaseId = "35359")
    public void verifyGetOneBook_T35359() {
        BookDto oneBook = bookServiceClient.readABook(574).get();
        System.out.println(oneBook);
    }


}
