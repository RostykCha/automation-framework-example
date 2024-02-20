package automationframeworkexample.clients;

import automationframeworkexample.clients.dto.BookDto;
import automationframeworkexample.utils.wrappers.RestAuthorizationWrapper;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static automationframeworkexample.utils.wrappers.RestAuthorizationWrapper.AUTH_HEADER_NAME;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BookServiceClient {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    @Value("${service.endpoint}")
    protected String serviceEndpoint;
    @Autowired
    RestAuthorizationWrapper authorizationWrapper;

    private static List<BookDto> parseReadBooksResponse(HttpResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<BookDto> books = mapper.readValue(response.body().toString(), new TypeReference<List<BookDto>>() {
            });
            return books;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(String.format("Exception while Parsing ReadBooksResponse: \"%s\", \"%s\"", response, e));
        }
    }

    public List<BookDto> readBooks() {
        String readEndpoint = serviceEndpoint + "books";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(readEndpoint))
                .header(AUTH_HEADER_NAME, authorizationWrapper.getAuthorizationHeader())
                .build();

        try {
            HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<BookDto> parsedResponse = parseReadBooksResponse(response);
            return parsedResponse;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(String.format("Exception while GET read Books: \"%s\"", e));
        }

    }


}
