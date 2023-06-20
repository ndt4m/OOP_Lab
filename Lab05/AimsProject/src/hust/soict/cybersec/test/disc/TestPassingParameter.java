package hust.soict.cybersec.test.disc;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;

public class TestPassingParameter 
{
    public static void main(String[] args) 
    {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title:" + jungleDVD.getTitle());  
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title:" + jungleDVD.getTitle()); 
    }

    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2)
    {
        DigitalVideoDisc tmp = new DigitalVideoDisc(o1.getTitle());
        o1.setTitle(o2.getTitle());
        o2.setTitle(tmp.getTitle());
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title)
    {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

}
