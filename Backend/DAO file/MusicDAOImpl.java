package dao;

import model.Music;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDAOImpl implements MusicDAO {

    @Override
    public List<Music> getAllTracks() {
        List<Music> tracks = new ArrayList<>();
        String query = "SELECT * FROM music";

        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Music track = new Music(
                        rs.getLong("track_id"),
                        rs.getString("title"),
                        rs.getString("artist"),
                        rs.getString("album"),
                        rs.getString("genre"),
                        rs.getString("path")
                );
                tracks.add(track);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    @Override
    public Music getTrackById(Long id) {
        String query = "SELECT * FROM music WHERE track_id = ?";
        Music track = null;

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                track = new Music(
                        rs.getLong("track_id"),
                        rs.getString("title"),
                        rs.getString("artist"),
                        rs.getString("album"),
                        rs.getString("genre"),
                        rs.getString("path")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return track;
    }

    @Override
    public boolean uploadTrack(Music music) {
        String query = "INSERT INTO music (title, artist, album, genre, path) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, music.getTitle());
            stmt.setString(2, music.getArtist());
            stmt.setString(3, music.getAlbum());
            stmt.setString(4, music.getGenre());
            stmt.setString(5, music.getPath());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrack(Long id) {
        String query = "DELETE FROM music WHERE track_id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
