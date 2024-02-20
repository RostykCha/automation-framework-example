package automationframeworkexample.clients.dto;

import lombok.Data;

@Data
public class BookDto {
    private int id;
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private double price;
}
