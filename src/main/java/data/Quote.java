package data;

import java.io.Serializable;

import data.Author;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Quote implements Serializable {
    private int id;
    private String content;
    private Author author;
}
