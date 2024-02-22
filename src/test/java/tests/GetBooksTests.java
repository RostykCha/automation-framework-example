package tests;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.utils.retry.AutomationRetry;
import automationframeworkexample.utils.wrappers.TestCaseDocumentationId;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static automationframeworkexample.clients.BookServiceClientVerify.verifyBookData;
import static automationframeworkexample.utils.wrappers.LoggerWrapper.logError;

@Test
public class GetBooksTests extends TestBase {

    @Test(retryAnalyzer = AutomationRetry.class, dataProvider = "testDataProvider")
    @TestCaseDocumentationId(testCaseId = "35359")
    public void verifyGetOneBook_T35359(Integer bookId) {
        BookDto oneBook = bookServiceClient.readABook(bookId).get();

        List<Error> failedVerificationsList = verifyBookData(oneBook);

        if (!failedVerificationsList.isEmpty()) {
            logError(Arrays.toString(failedVerificationsList.toArray()));
            Assertions.fail("Test Fails if Some of books failed verification");
        }
    }


    @Test(retryAnalyzer = AutomationRetry.class)
    @TestCaseDocumentationId(testCaseId = "35353")
    public void verifyGetAllBooks_T35353() {
        List<BookDto> bookList = bookServiceClient.readAllBooks();
        List<Error> failedVerificationsList = verifyBookData(bookList);

        if (!failedVerificationsList.isEmpty()) {
            logError(Arrays.toString(failedVerificationsList.toArray()));
            Assertions.fail("Test Fails if Some of books failed verification");
        }
    }




}
