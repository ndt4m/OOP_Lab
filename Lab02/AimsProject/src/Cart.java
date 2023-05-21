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



}
