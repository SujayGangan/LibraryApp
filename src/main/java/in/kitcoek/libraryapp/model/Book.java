package in.kitcoek.libraryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int isbn;
    private String title;
    private String author;
    private int publishYear;
}
