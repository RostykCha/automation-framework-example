package automationframeworkexample.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BookServiceClient {

    @Value("service.endpoint")
    private String serviceEndpoint;


    public void readBooks() {
        String readEndpoint = "http://77.102.250.113:17354/api/v1/books\n";
    }


}
