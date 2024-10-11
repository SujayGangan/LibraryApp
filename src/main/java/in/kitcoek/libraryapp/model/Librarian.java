package in.kitcoek.libraryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    private int id;
    private String name;
    private int salary;
}
