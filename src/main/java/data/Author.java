package data;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Author implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
}
