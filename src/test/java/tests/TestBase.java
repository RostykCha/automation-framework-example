package tests;

import automationframeworkexample.FrameworkSpringConfiguration;
import automationframeworkexample.clients.BookServiceClient;
import automationframeworkexample.utils.retry.AutomationListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@SpringBootTest(classes = FrameworkSpringConfiguration.class)
@Listeners(AutomationListenerAdapter.class)
public class TestBase extends AbstractTestNGSpringContextTests {
    public static final Integer BOOK_ID_LENGTH = 3;

    @Autowired
    BookServiceClient bookServiceClient;

    @DataProvider(name = "testDataProvider", parallel = true)
    public Object[][] testDataProvider() {
        return new Object[][]{{574}, {524}, {525}, {529}, {534}};
    }

    @DataProvider(name = "testCreateDataProvider", parallel = true)
    public Object[][] testCreateDataProvider() {
        return new Object[][]{{"Hola"}, {"Bobby"}, {"Lords"}, {"Nana"}, {"Bonny"}};
    }


}
