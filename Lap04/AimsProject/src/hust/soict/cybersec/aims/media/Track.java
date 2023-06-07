package hust.soict.cybersec.aims.media;

public class Track implements Playable
{
    private String title;
    private int length;

    public Track()
    {

    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString()
    {
        return "Track - " + "[" +  this.getTitle() + "] - [" + this.getLength() + "]";
    }

    public void play()
    {
        System.out.println(this.toString());
    }
}
