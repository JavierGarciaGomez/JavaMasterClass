package S19Databases.l346_347;

import S19Databases.l346_347.model.Artist;
import S19Databases.l346_347.model.Datasource;
import S19Databases.l346_347.model.SongArtist;

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

        datasource.querySongsMetadata(); // 345
        System.out.println("THE COUNT IS "+datasource.getCountMinMax(Datasource.TABLE_SONGS)); // 346
        datasource.createViewForSongArtists();

        songArtists = datasource.querySongInfoView("Go Your Own Way");
        for(SongArtist songArtist: songArtists){
            System.out.println(songArtist);
        }

        datasource.close();




    }
}
