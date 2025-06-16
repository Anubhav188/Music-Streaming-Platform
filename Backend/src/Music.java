package model;

public class Music {
    private Long trackId;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private String path;

    public Music(Long trackId, String title, String artist, String album, String genre, String path) {
        this.trackId = trackId;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.path = path;
    }

    // Getters and setters
    public Long getTrackId() { return trackId; }
    public void setTrackId(Long trackId) { this.trackId = trackId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
}
