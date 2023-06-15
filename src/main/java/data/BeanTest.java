package data;

import data.Author;

import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        Album album1 = new Album();
        album1.setId(1);
        album1.setName("Thriller");
        album1.setArtist("Michael Jackson");
        album1.setReleaseDate(1995);
        album1.setGenre("pop");
        album1.setSales(3.5);

        System.out.println(album1);

        ArrayList<Quote> quotes = new ArrayList<>();


        Author Duke = new Author(1, "Duke", "Nukem");
        Quote bubbleGum = new Quote(1, "I'm here to kick a** and chew bubble gum...  and i'm all out of bubble gum", Duke);
        System.out.println(bubbleGum.getAuthor());


        System.out.println(quotes);
    }
}
