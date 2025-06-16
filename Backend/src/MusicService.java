package service;

import dao.MusicDAO;
import dao.MusicDAOImpl;
import model.Music;
import java.util.List;

public class MusicService {
    private final MusicDAO musicDAO = new MusicDAOImpl();

    public List<Music> getAllTracks() {
        return musicDAO.getAllTracks();
    }

    public Music getTrackById(Long id) {
        return musicDAO.getTrackById(id);
    }

    public boolean uploadTrack(Music music) {
        return musicDAO.uploadTrack(music);
    }

    public boolean deleteTrack(Long id) {
        return musicDAO.deleteTrack(id);
    }
}
