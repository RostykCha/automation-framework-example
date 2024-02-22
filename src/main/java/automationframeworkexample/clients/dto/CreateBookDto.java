package automationframeworkexample.clients.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import lombok.Builder;
import lombok.Data;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@Data
public class CreateBookDto {
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private double price;

    // Private constructor to prevent direct instantiation
    private CreateBookDto() {}

    // Getter and setter methods for each field

    public String toJson() {
        // Jackson ObjectMapper for JSON conversion
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // Convert object to JSON
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // Builder class for CreateBookDto
    public static class CreateBookDtoBuilder {
        private String name;
        private String author;
        private String publication;
        private String category;
        private int pages;
        private double price;

        public CreateBookDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CreateBookDtoBuilder author(String author) {
            this.author = author;
            return this;
        }

        public CreateBookDtoBuilder publication(String publication) {
            this.publication = publication;
            return this;
        }

        public CreateBookDtoBuilder category(String category) {
            this.category = category;
            return this;
        }

        public CreateBookDtoBuilder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public CreateBookDtoBuilder price(double price) {
            this.price = price;
            return this;
        }

        public CreateBookDto build() {
            CreateBookDto bookDto = new CreateBookDto();
            bookDto.name = this.name;
            bookDto.author = this.author;
            bookDto.publication = this.publication;
            bookDto.category = this.category;
            bookDto.pages = this.pages;
            bookDto.price = this.price;
            return bookDto;
        }
    }
}
