package hust.soict.cybersec.test.store;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.store.Store;

public class StoreTest 
{
    public static void main(String[] args) 
    {
        Store dvdStore = new Store();

        // Create dvd to add to store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                                                  "Animation", 
                                                  "Roger Allers", 
                                                    87, 
                                                      19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                                                  "Science Fiction", 
                                                  "Geogre Lucas", 
                                                    87, 
                                                      24.45f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                                                  "Animation", 
                                                      18.99f);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter", 
                                                      "Magical",
                                                          18.99f);

        // add dvds to store
        dvdStore.addDVD(dvd1, dvd2, dvd3, dvd4);
        dvdStore.removeDVD(dvd3);
                                    
    }
}
