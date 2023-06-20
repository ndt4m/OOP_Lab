package hust.soict.cybersec.test.store;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.media.Media;

public class StoreTest 
{
    public static void main(String[] args) 
    {
        Store mediaStore = new Store();

        // Create media to add to store
        Media media1 = new DigitalVideoDisc("The Lion King", 
                                                  "Animation", 
                                                  "Roger Allers", 
                                                    87, 
                                                      19.95f);

        Media media2 = new DigitalVideoDisc("Star Wars", 
                                                  "Science Fiction", 
                                                  "Geogre Lucas", 
                                                    87, 
                                                      24.45f);

        Media media3 = new DigitalVideoDisc("Aladin", 
                                                  "Animation", 
                                                      18.99f);

        Media media4 = new DigitalVideoDisc("Harry Potter", 
                                                      "Magical",
                                                          18.99f);

        // add medias to store
        mediaStore.addMedia(media1, media2, media3, media4);
        mediaStore.removeMedia(media3);
                                    
    }
}
