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

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks)
    {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist)
    {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
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
        StringBuilder s = new StringBuilder("CD - " + "[" + super.getTitle() + "] - [" + this.getArtist() + "] - ["+ super.getDirector() + "] - [" + super.getLength() + "]: " + super.getCost() + "$\n");
        s.append("List of Track: \n");
        if (this.tracks.size() == 0)
        {
            s.append("There is no track for this CD\n");
            return s.toString();
        }

        for (int i = 0; i < this.tracks.size(); i++)
        {
            s.append("  -" + tracks.get(i).toString() + "\n");
        }
        return s.toString();
    }

    public void play()
    {
        System.out.println(this.toString());
        for (Track track : this.tracks)
        {
            track.play();
        }
    }
}
