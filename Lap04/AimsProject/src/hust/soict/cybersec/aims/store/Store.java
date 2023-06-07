package hust.soict.cybersec.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
public class Store 
{
    private List<DigitalVideoDisc> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<DigitalVideoDisc>();
    }

    public void addDVD(DigitalVideoDisc... dvdList) 
    {
        if (dvdList.length == 0)
        {
            System.out.println("The dvd List is empty");
            return;
        }
        
        for (DigitalVideoDisc dvd : dvdList)
        {
            this.itemsInStore.add(dvd);
        }
        System.out.println("DVDs have added successfully");
    }

    public void removeDVD(DigitalVideoDisc... dvdList) 
    {
        if (dvdList.length == 0)
        {
            System.out.println("The dvd List is empty");
            return;
        }

        for (DigitalVideoDisc dvd : dvdList)
        {
            this.itemsInStore.remove(dvd);
        }
        System.out.println("DVDs have removed successfully");
    }
}
