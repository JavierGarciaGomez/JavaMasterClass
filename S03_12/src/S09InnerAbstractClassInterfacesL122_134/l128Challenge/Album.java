package S09InnerAbstractClassInterfacesL122_134.l128Challenge;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    // Innerclass
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        // Se instancia en el constructor la clase interna
        this.songList = new SongList();
    }

    // Método para agregar a la clase interna SongList
    public boolean addSong(String title, double duration) {
        return this.songList.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        // find a song in the songlist by its tracknumber
        Song checkedSong = this.songList.getSong(trackNumber);
        // If is not found, it add it
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        // If not found return false.
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    // Method to add to playlist by title
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songList.getSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    // Innerclass con un arraylist
    private class SongList {
        private ArrayList<Song> songs;

        //Constructor
        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        // Add the song to the songList
        public boolean add(Song song) {
            // If is included doesn't add it
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        // find by title
        private Song getSong(String title) {
            for(Song checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        // find by track
        public Song getSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index > 0) && (index<songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }
}
