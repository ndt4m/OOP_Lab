package hust.soict.cybersec.aims.media;

public class DigitalVideoDisc extends Disc implements Playable
{
    private static int nbDigitalVideoDiscs = 0;

    public String getDirector()
    {
        return super.getDirector();   
    }

    public DigitalVideoDisc()
    {
        DigitalVideoDisc.nbDigitalVideoDiscs += 1;
        super.setId(DigitalVideoDisc.nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title)
    {
        this();
        super.setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost)
    {
        this();
        super.setCategory(category);
        super.setCost(cost);
        super.setTitle(title);
    }

    public DigitalVideoDisc(String tilte, String category, String director, float cost)
    {
        this();
        super.setTitle(tilte);
        super.setCategory(category);
        super.setDirector(director);;
        super.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost)
    {
        this();
        super.setTitle(title);
        super.setCategory(category);
        super.setDirector(director);;
        super.setDirector(director);;
        super.setCost(cost);
    }

    public void setTitle(String title)
    {
        super.setTitle(title);
    }

    @Override
    public String toString()
    {
        return "DVD - " + "[" + super.getTitle() + "] - [" + super.getDirector() + "] - [" + super.getLength() + "]: " + super.getCost() + "$\n";
    }

    public void play()
    {
        System.out.println("DigitalVideo " + this.toString());
    }
}
