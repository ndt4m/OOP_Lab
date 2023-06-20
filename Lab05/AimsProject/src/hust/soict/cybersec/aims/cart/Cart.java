package hust.soict.cybersec.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.cybersec.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart 
{
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media)
    {
        this.itemsOrdered.add(media);

        System.out.println("The media has been added");
    }

    /*The other version of "addMedia(Media... mediaList)"*/
    // public void addMedia(Media [] mediaList)
    // {
    //     if (mediaList.length == 0)
    //     {
    //         System.out.println("The mediaList is empty");
    //     }
        
    //     for (Media media : mediaList)
    //     {
    //         if (qtyOrdered < Cart.MAX_NUMBERS_ORDERED)
    //         {
    //             addMedia(media);
    //         }
    //         else
    //         {
    //             addMedia(media);
    //             break;
    //         }
    //     }
    // }

    public void addMedia(Media... mediaList)
    {
        if (mediaList.length == 0)
        {
            System.out.println("The mediaList is empty");
            return;
        }
        
        for (Media media : mediaList)
        {
                addMedia(media);
        }
    }
    

    public void addMedia(Media media1,Media media2)
    {
        addMedia(media1);
        addMedia(media2);
        
    }


    public void removeMedia(Media media)
    {
        if (this.getItemsOrdered().size() == 0)
        {
            System.out.println("The cart is empty. There's nothing to remove");
            return;
        }
        this.itemsOrdered.remove(media);
        System.out.println("the media has been removed");

    }


    public void removeAll()
    {
        this.getItemsOrdered().clear();
    }

    public float totalCost()
    {
        float totalCost = 0;
        for (Media media : this.itemsOrdered)
        {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    
    public void print()
    {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++)
        {   
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id)
    {
        for (Media media : itemsOrdered)
        {
            if (media.getId() == id)
            {
                System.out.println(media.toString());
                return;
            }
        }

        System.out.println("There is no media with the id: " + id);
        System.out.println("You can try to enter another id");
    }

    public void searchByTitle(String title) {
        for (Media media : itemsOrdered)
        {
            if (media.isMatch(title))
            {
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("There is no media with the title: " + title);
        System.out.println("You can try to enter another title");
	}
}
