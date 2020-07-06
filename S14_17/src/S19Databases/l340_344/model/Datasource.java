package S19Databases.l340_344.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\javie\\Dropbox\\" +
            "JGG\\Estudios\\Code\\Java\\MasterClass\\S14_17\\" + DB_NAME;
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;


    private Connection connection;

    public boolean connect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("CONNECTED");
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public boolean close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("DISCONNECTED");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
            return false;
        }
    }


    public List<Artist> queryArtist(int sortOrder) {
        StringBuilder stringBuilder = new StringBuilder("SELECT *FROM ");
        stringBuilder.append(TABLE_ARTISTS);

        if (sortOrder != ORDER_BY_NONE) {
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(COLUMN_ALBUM_NAME);
            stringBuilder.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) stringBuilder.append(" DESC");
            else stringBuilder.append(" ASC");
        }
        try (Statement statement = this.connection.createStatement();
             ResultSet resultset = statement.executeQuery(stringBuilder.toString());
        ) {
            List<Artist> queryArtist = new ArrayList<>();
            while (resultset.next()) {
                int id = resultset.getInt(INDEX_ARTIST_ID);
                String name = resultset.getString(INDEX_ARTIST_NAME);
                queryArtist.add(new Artist(id, name));
            }
            return queryArtist;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}