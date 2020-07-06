package S19Databases.l340_344;

import S19Databases.l340_344.model.Artist;
import S19Databases.l340_344.model.Datasource;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        datasource.connect();

        List<Artist> artists = datasource.queryArtist(2);

        for (Artist a: artists) {
            System.out.println(a);
        }
        datasource.close();

    }
}
