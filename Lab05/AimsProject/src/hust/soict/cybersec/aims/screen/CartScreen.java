package hust.soict.cybersec.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Track;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen extends Application
{
    private static Cart cart = new Cart();

    @Override
    public void start(Stage stage)
    {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("C:\\Users\\HP\\Downloads\\OOP_Lab\\Lab05\\AimsProject\\src\\hust\\soict\\cybersec\\aims\\screen\\cart.fxml"));
            CartScreenController controller = new CartScreenController(cart);
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("cart");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    // public CartScreen(Cart cart)
    // {
    //     super();
    //     this.cart = cart;

    //     JFXPanel fxPanel = new JFXPanel();
    //     this.add(fxPanel);

    //     this.setTitle("Cart");
    //     this.setVisible(true);
    //     Platform.runLater(new Runnable() {
    //         @Override
    //         public void run()
    //         {
    //             //System.out.println("dfasfsdf");
    //             try {
    //                 FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
    //                 CartScreenController controller = new CartScreenController(cart);
    //                 loader.setController(controller);
    //                 Parent root = loader.load();
    //                 fxPanel.setScene(new Scene(root));
    //                 fxPanel.setVisible(true);
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    // }

    public static void main(String[] args) 
    {
       
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track("PART1", 12);
        Track track2 = new Track("Part2", 21);
        tracks.add(track1);
        tracks.add(track2);

        Media cd = new CompactDisc(1, "hello world", "hard movie", 29.3f, 32, "NDT", "Jhon", tracks);

        List<String> authors = new ArrayList<>();
        authors.add("Tam");
        authors.add("Tammmmm");
        Media book1 = new Book(2, "Learn Java", "Programming", 20f, authors);
        Book book2 = new Book(4,"Life of Pi", "Adventure fiction", 18.10f);

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
        
                                                      
        CartScreen.cart.addMedia(cd);                                            
        CartScreen.cart.addMedia(dvd1);
        CartScreen.cart.addMedia(dvd2);
        CartScreen.cart.addMedia(dvd3);
        CartScreen.cart.addMedia(book1);
        CartScreen.cart.addMedia(book2);
        launch(args);
    }
}
