package automationframeworkexample.clients;

import automationframeworkexample.clients.dto.BookDto;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static automationframeworkexample.utils.wrappers.LoggerWrapper.logInfo;

public class BookServiceClientVerify {

    public static List<Error> verifyBookData(List<BookDto> bookList) {
        List<Error> failedVerificationsList = new ArrayList<>();

        for (BookDto bookDto : bookList) {
            logInfo(String.format("\n Verification for: \"%s\"", bookDto));
            try {
                logInfo(String.format("Verify Book \"%s\" actual author: \"%s\"", bookDto.getName(), bookDto.getAuthor()));
                Assertions.assertFalse(bookDto.getAuthor().isBlank(), String.format("Verify Book \"%s\" actual author: \"%s\"", bookDto.getName(), bookDto.getAuthor()));

                logInfo(String.format("Verify Book \"%s\" actual category: \"%s\"", bookDto.getName(), bookDto.getCategory()));
                Assertions.assertFalse(bookDto.getCategory().isBlank(), String.format("Verify Book \"%s\" actual category: \"%s\"", bookDto.getName(), bookDto.getCategory()));

                logInfo(String.format("Verify Book \"%s\" actual pages: \"%s\"", bookDto.getName(), bookDto.getPages()));
                Assertions.assertTrue(bookDto.getPages() > 0, String.format("Verify Book \"%s\" actual pages: \"%s\"", bookDto.getName(), bookDto.getPages()));

                logInfo(String.format("Verify Book \"%s\" actual price: \"%s\"", bookDto.getName(), bookDto.getPrice()));
                Assertions.assertTrue(bookDto.getPrice() > 0, String.format("Verify Book \"%s\" actual price: \"%s\"", bookDto.getName(), bookDto.getPrice()));
            } catch (Error error) {
                failedVerificationsList.add(error);
            }
        }

        return failedVerificationsList;
    }

    public static List<Error> verifyBookData(BookDto... dtos) {
        return verifyBookData(List.of(dtos));
    }

}
