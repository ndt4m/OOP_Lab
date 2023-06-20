package hust.soict.cybersec.test.cart;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;

public class CartTest 
{
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD object and add them to the Cart
        Media dvd1 = new DigitalVideoDisc("The Lion King", 
                                                  "Animation", 
                                                  "Roger Allers", 
                                                    87, 
                                                      19.95f);

        Media dvd2 = new DigitalVideoDisc("Star Wars", 
                                                  "Science Fiction", 
                                                  "Geogre Lucas", 
                                                    87, 
                                                      24.45f);

        Media dvd3 = new DigitalVideoDisc("Aladin", 
                                                  "Animation", 
                                                      18.99f);

        cart.addMedia(dvd1, dvd2, dvd3);

        // Test the print method
        cart.print();

        cart.searchById(1);
        cart.searchById(3);
        cart.searchById(4);
        cart.searchByTitle("Aladin");
        cart.searchByTitle("One Piece");
    }
}
