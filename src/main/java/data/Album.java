package data;

import java.io.Serializable;
import java.util.Date;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Album implements Serializable {
    private int id;

    private  String artist;

    private String name;

    private int releaseDate;

    private double sales;

    private String genre;

}
