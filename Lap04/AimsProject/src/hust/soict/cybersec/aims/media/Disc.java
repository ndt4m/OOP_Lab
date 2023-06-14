package hust.soict.cybersec.aims.media;

public class Disc extends Media
{
    private int length;
    private String director;

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Disc()
    {
        super();
    }

    public Disc(int id, String title, String category, float cost, int length, String director)
    {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

}
