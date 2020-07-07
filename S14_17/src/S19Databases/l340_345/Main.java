package S19Databases.l340_345;

import S19Databases.l340_345.model.Artist;
import S19Databases.l340_345.model.Datasource;
import S19Databases.l340_345.model.SongArtist;

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

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        for(SongArtist songArtist: songArtists){
            System.out.println(songArtist);
        }

        datasource.querySongsMetadata();
        datasource.close();



    }
}
