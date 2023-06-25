package hust.soict.cybersec.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.cybersec.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBookToStoreScreen extends JFrame 
{
    private Store store;
    
    public AddBookToStoreScreen(Store store)
    {
        super();

        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book To Store");
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
                        getClass().getResource("addBook.fxml")
                    );
                    AddBookToStoreController controller = new AddBookToStoreController(store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
