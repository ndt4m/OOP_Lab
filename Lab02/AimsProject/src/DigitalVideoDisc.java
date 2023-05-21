

public class DigitalVideoDisc 
{
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

    DigitalVideoDisc()
    {

    }

    DigitalVideoDisc(String title)
    {
        this.title = title;
    }

    DigitalVideoDisc(String title, String category, float cost)
    {
        this.category = category;
        this.cost = cost;
        this.title = title;
    }

    DigitalVideoDisc(String tilte, String category, String director, float cost)
    {
        this.title = tilte;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    DigitalVideoDisc(String title, String category, String director, int length, float cost)
    {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }


}
