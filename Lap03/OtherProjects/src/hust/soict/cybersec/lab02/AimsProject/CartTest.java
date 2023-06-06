package hust.soict.cybersec.lab02.AimsProject;
public class CartTest 
{
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD object and add them to the Cart
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

        cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);

        // Test the print method
        cart.print();

        cart.searchById(1);
        cart.searchById(3);
        cart.searchById(4);
        cart.searchByTitle("Aladin");
        cart.searchByTitle("One Piece");
    }
}
