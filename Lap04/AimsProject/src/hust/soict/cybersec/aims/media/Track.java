package hust.soict.cybersec.aims.media;

public class Track implements Playable
{
    private String title;
    private int length;

    public Track()
    {

    }

    public Track(String title, int length)
    {
        this.length = length;
        this.title = title;
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

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Track)
        {
            Track track = (Track) obj;
            if (track.title.equals(this.title) && track.length == this.length)
            {
                return true;
            }
        }

        return false;
    }
}
