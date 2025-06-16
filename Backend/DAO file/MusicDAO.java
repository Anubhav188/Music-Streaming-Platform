package dao;

import model.Music;
import java.util.List;

public interface MusicDAO {
    List<Music> getAllTracks();
    Music getTrackById(Long id);
    boolean uploadTrack(Music music);
    boolean deleteTrack(Long id);
}
