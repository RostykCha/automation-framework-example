package tests;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.clients.dto.CreateBookDto;
import automationframeworkexample.utils.retry.AutomationRetry;
import automationframeworkexample.utils.wrappers.LoggerWrapper;
import automationframeworkexample.utils.wrappers.TestCaseDocumentationId;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static automationframeworkexample.clients.BookServiceClientVerify.verifyBookData;
import static automationframeworkexample.utils.wrappers.LoggerWrapper.logError;
import static automationframeworkexample.utils.wrappers.TestDataRandomizer.getRandomIntData;
import static automationframeworkexample.utils.wrappers.TestDataRandomizer.getRandomStringData;

public class CreateBooksTests extends TestBase {


    @Test(retryAnalyzer = AutomationRetry.class, dataProvider = "testCreateDataProvider")
    @TestCaseDocumentationId(testCaseId = "473")
    public void verifyCreateABook_T473(String publisher) {
        CreateBookDto expectedBook = new CreateBookDto.CreateBookDtoBuilder()
                .name("name" + getRandomStringData(6))
                .author("author" + getRandomStringData(6))
                .publication(publisher)
                .category("Category" + getRandomStringData(6))
                .pages(getRandomIntData(3))
                .price(getRandomIntData(3))
                .build();

        BookDto actualBook = bookServiceClient.createABook(expectedBook).get();

        LoggerWrapper.logInfo("Verify that created book exists");
        bookServiceClient.readABook(actualBook.getId());

        LoggerWrapper.logInfo("Verify that created book is correct");
        List<Error> failedVerificationsList = verifyBookData(actualBook);

        if (!failedVerificationsList.isEmpty()) {
            logError(Arrays.toString(failedVerificationsList.toArray()));
            Assertions.fail("Test Fails if Some of books failed verification");
        }
    }

}
