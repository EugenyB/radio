import java.util.Objects;

public class Song extends Part {

    private String singer;
    private String title;

    public Song(String singer, String title, int length) {
        super(length);
        this.singer = singer;
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (!Objects.equals(singer, song.singer)) return false;
        return Objects.equals(title, song.title);
    }

    @Override
    public String toString() {
        return "Song{" +
                "singer='" + singer + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        int result = singer != null ? singer.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
