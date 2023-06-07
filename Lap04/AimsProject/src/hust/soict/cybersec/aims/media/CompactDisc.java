package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable
{
    private String artist;

    private List<Track> tracks = new ArrayList<Track>();


    public CompactDisc()
    {
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track)
    {
        if (tracks.contains(track))
        {
            System.out.println("the track " + track.getTitle() + " has already in the track list");
        }
        else
        {
            this.tracks.add(track);
            System.out.println("The track " + track.getTitle() + " has been added to the track list successfully");
        }
    }

    public int getLength()
    {
        int sum = 0;
        for (Track track : this.tracks)
        {
            sum += track.getLength();
        }
        return sum;
    }

    @Override
    public String toString()
    {
        return "DVD - " + "[" + super.getTitle() + "] - [" + this.getArtist() + "] - ["+ super.getDirector() + "] - [" + super.getLength() + "]: [" + super.getCost() + "]$";
    }

    public void play()
    {
        System.out.println("Compact " + this.toString());
        for (Track track : this.tracks)
        {
            track.play();
        }
    }
}
