package controller;

import com.google.gson.Gson;
import model.Music;
import service.MusicService;
import spark.Spark;

import java.util.List;

public class MusicController {
    private final MusicService musicService = new MusicService();
    private final Gson gson = new Gson();

    public MusicController() {
        Spark.get("/api/music", (req, res) -> {
            res.type("application/json");
            List<Music> tracks = musicService.getAllTracks();
            return gson.toJson(tracks);
        });

        Spark.post("/api/music/upload", (req, res) -> {
            res.type("application/json");
            Music music = gson.fromJson(req.body(), Music.class);
            return gson.toJson(musicService.uploadTrack(music));
        });

        Spark.delete("/api/music/:id", (req, res) -> {
            res.type("application/json");
            Long id = Long.valueOf(req.params(":id"));
            return gson.toJson(musicService.deleteTrack(id));
        });
    }
}
