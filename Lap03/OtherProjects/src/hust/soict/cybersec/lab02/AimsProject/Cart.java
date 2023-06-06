package hust.soict.cybersec.lab02.AimsProject;
import java.util.ArrayList;

public class Cart 
{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
    
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered < Cart.MAX_NUMBERS_ORDERED)
        {
            this.itemsOrdered.add(disc);
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
        else
        {
            System.out.println("The cart is almost full");
        }
    }

    /*The other version of "addDigitalVideoDisc(DigitalVideoDisc... dvdList)"*/
    // public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
    // {
    //     if (dvdList.length == 0)
    //     {
    //         System.out.println("The dvdList is empty");
    //     }
        
    //     for (DigitalVideoDisc dvd : dvdList)
    //     {
    //         if (qtyOrdered < Cart.MAX_NUMBERS_ORDERED)
    //         {
    //             addDigitalVideoDisc(dvd);
    //         }
    //         else
    //         {
    //             addDigitalVideoDisc(dvd);
    //             break;
    //         }
    //     }
    // }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList)
    {
        if (dvdList.length == 0)
        {
            System.out.println("The dvdList is empty");
            return;
        }
        
        for (DigitalVideoDisc dvd : dvdList)
        {
            if (qtyOrdered < Cart.MAX_NUMBERS_ORDERED)
            {
                addDigitalVideoDisc(dvd);
            }
            else
            {
                addDigitalVideoDisc(dvd);
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
    {
        addDigitalVideoDisc(dvd1);
        if (qtyOrdered < Cart.MAX_NUMBERS_ORDERED)
        {
            addDigitalVideoDisc(dvd2);
        }
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered == 0)
        {
            System.out.println("The cart is empty. There's nothing to remove");
            return;
        }
        this.itemsOrdered.remove(disc);
        qtyOrdered -= 1;
        System.out.println("the disc has been removed");

    }


    public float totalCost()
    {
        float totalCost = 0;
        for (DigitalVideoDisc disc : this.itemsOrdered)
        {
            totalCost += disc.getCost();
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
        for (DigitalVideoDisc dvd : itemsOrdered)
        {
            if (dvd.getId() == id)
            {
                System.out.println(dvd.toString());
                return;
            }
        }

        System.out.println("There is no DVD with the id: " + id);
        System.out.println("You can try to enter another id");
    }

    public void searchByTitle(String title) {
        for (DigitalVideoDisc dvd : itemsOrdered)
        {
            if (dvd.isMatch(title))
            {
                System.out.println(dvd.toString());
                return;
            }
        }
        System.out.println("There is no DVD with the title: " + title);
        System.out.println("You can try to enter another title");
	}
}
