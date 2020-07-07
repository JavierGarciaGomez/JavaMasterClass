package S19Databases.l348_352;

import S19Databases.l348_352.model.Artist;
import S19Databases.l348_352.model.Datasource;
import S19Databases.l348_352.model.SongArtist;

import java.util.List;
import java.util.Scanner;

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

        //347
        songArtists = datasource.querySongInfoView("Go Your Own Way");
        for(SongArtist songArtist: songArtists){
            System.out.println(songArtist);
        }

        // 348
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();

        songArtists = datasource.querySongInfoView(title);
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }
        //352
        System.out.println("***************352***************");
        datasource.insertSong("Touch of Grey", "Grateful Dead", "In the Dark", 1);
        datasource.disconnect();


    }
}
