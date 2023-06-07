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


}
