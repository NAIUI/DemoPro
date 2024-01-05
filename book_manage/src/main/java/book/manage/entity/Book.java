package book.manage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    int bid;
    String desc;
    String price;

    public Book(String desc, String price) {
        this.desc = desc;
        this.price = price;
    }
}
