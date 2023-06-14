package hust.soict.cybersec.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.cybersec.aims.media.Media;
public class Store 
{
    private List<Media> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<Media>();
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public List<Media> searchByTitle(String title)
    {
        List<Media> res = new ArrayList<>();
        for (Media m: itemsInStore)
        {
            if (m.getTitle().equals(title))
            {
                res.add(m);
            }
        }
        return res;
    }
    public void addMedia(Media... mediaList) 
    {
        if (mediaList.length == 0)
        {
            System.out.println("The media List is empty");
            return;
        }
        
        for (Media media : mediaList)
        {
            this.itemsInStore.add(media);
        }
        System.out.println("Medias have added successfully");
    }

    public void removeMedia(Media... mediaList) 
    {
        if (mediaList.length == 0)
        {
            System.out.println("The media List is empty");
            return;
        }

        for (Media media : mediaList)
        {
            this.itemsInStore.remove(media);
        }
        System.out.println("Medias have removed successfully");
    }

    public void removeMedia(List<Media> mediaList) 
    {
        if (mediaList.size() == 0)
        {
            System.out.println("The media List is empty");
            return;
        }

        for (Media media : mediaList)
        {
            this.itemsInStore.remove(media);
        }
        System.out.println("Medias have removed successfully");
    }
}
