package S19Databases.l340_344;

import S19Databases.l340_344.model.Artist;
import S19Databases.l340_344.model.Datasource;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        datasource.connect();

        List<Artist> artists = datasource.queryArtist(Datasource.ORDER_BY_ASC);
        for (Artist a: artists) {
            System.out.println(a);
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_ASC);
        for(String album:albumsForArtist){
            System.out.println(album);
        }
        datasource.close();



    }
}
