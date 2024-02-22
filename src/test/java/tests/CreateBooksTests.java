package tests;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.clients.dto.CreateBookDto;
import automationframeworkexample.utils.retry.AutomationRetry;
import automationframeworkexample.utils.wrappers.TestCaseDocumentationId;
import org.testng.annotations.Test;

import java.util.Optional;

import static automationframeworkexample.utils.wrappers.TestDataRandomizer.getRandomIntData;
import static automationframeworkexample.utils.wrappers.TestDataRandomizer.getRandomStringData;

public class CreateBooksTests extends TestBase {


    @Test(retryAnalyzer = AutomationRetry.class)
    @TestCaseDocumentationId(testCaseId = "473")
    public void verifyCreateABook_T473() {
        CreateBookDto expectedBook = new CreateBookDto.CreateBookDtoBuilder()
                .name("name" + getRandomStringData(6))
                .author("author" + getRandomStringData(6))
                .publication("Publisher" + getRandomStringData(6))
                .category("Category" + getRandomStringData(6))
                .pages(getRandomIntData(3))
                .price(getRandomIntData(3))
                .build();

        Optional<BookDto> actualBook = bookServiceClient.createABook(expectedBook);
        System.out.println(actualBook.get());
    }

}
