package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public abstract class Media 
{
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost)
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media()
    {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title) 
    {
		return this.getTitle().equals(title);
	}

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Media)
        {
            Media media = (Media) obj;
            if (media.title.equals(this.title))
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) 
    {
        List<Media> mediae = new ArrayList<Media>();

        // create some media here
        // for example: cd, dvd, book
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track("PART1", 12);
        Track track2 = new Track("Part2", 21);
        tracks.add(track1);
        tracks.add(track2);

        Media cd = new CompactDisc(1, "hello world", "hard movie", 29.3f, 32, "NDT", "Jhon", tracks);

        List<String> authors = new ArrayList<>();
        authors.add("Tam");
        authors.add("Tammmmm");
        Media book = new Book(2, "Learn Java", "Programming", 20f, authors);

        Media dvd = new DigitalVideoDisc("The Lion King", 
                                                  "Animation", 
                                                  "Roger Allers", 
                                                    87, 
                                                      19.95f);

        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for (Media m: mediae)
        {
            System.out.println(m.toString());
        }
    }
}
