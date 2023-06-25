package hust.soict.cybersec.aims.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Track;
import hust.soict.cybersec.aims.store.Store;

public class CartScreen extends JFrame 
{
    private Cart cart;

    private Store store;

    public CartScreen(Cart cart, Store store) 
    {
        super();

        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
       
        Platform.runLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                try {
                    FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("cart.fxml")
                    );
                    CartScreenController controller = new CartScreenController(cart, store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) 
    {
        Store store = new Store();
        Cart cart = new Cart();
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track("PART1", 12);
        Track track2 = new Track("Part2", 22);
        tracks.add(track1);
        tracks.add(track2);

        Media cd = new CompactDisc(1, "hello world", "hard movie", 29.3f, 32, "NDT", "Jhon", tracks);

        List<String> authors = new ArrayList<>();
        authors.add("Tam");
        authors.add("Tammmmm");
        Media book1 = new Book(2, "Learn Java", "Programming", 20f, authors);
        Book book2 = new Book(4,"The Amazing World of Gumball", "Adventure fiction", 18.10f);

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
        
        Media book3 = new Book("test", "fiction", 68.7f);

        store.addMedia(cd);                                            
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        cart.addMedia(cd);                                            
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(book2);
        new CartScreen(cart, store);
        new StoreScreen(store, cart);
        new AddBookToStoreScreen(store);
        new AddCompactDiscToStoreScreen(store);
        new AddDigitalVideoDiscToStoreScreen(store);
    }
}
