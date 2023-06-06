package hust.soict.cybersec.lab02.AimsProject;


public class DigitalVideoDisc 
{
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle()
    {
        return this.title;
    }

    public String getCategory()
    {
        return this.category;
    }

    public String getDirector()
    {
        return this.director;   
    }

    public int getLength()
    {
        return this.length;
    }

    public float getCost()
    {
        return this.cost;
    }

    public int getId()
    {
        return this.id;
    }

    public DigitalVideoDisc()
    {
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title)
    {
        this();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost)
    {
        this();
        this.category = category;
        this.cost = cost;
        this.title = title;
    }

    public DigitalVideoDisc(String tilte, String category, String director, float cost)
    {
        this();
        this.title = tilte;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost)
    {
        this();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isMatch(String title) 
    {
		return this.getTitle().equals(title);
	}

    @Override
    public String toString()
    {
        return "DVD - " + "[" + this.title + "] - [" + this.director + "] - [" + this.length + "]: [" + this.cost + "]$";
    }
}
