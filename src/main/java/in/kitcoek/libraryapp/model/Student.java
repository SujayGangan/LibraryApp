package in.kitcoek.libraryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int prn;
    private String name;
    private String department;
}
