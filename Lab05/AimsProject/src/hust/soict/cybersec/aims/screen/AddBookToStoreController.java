package hust.soict.cybersec.aims.screen;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddBookToStoreController extends MenuBarController 
{
    private Store store;

    public AddBookToStoreController(Store store)
    {
        this.store = store;
    }

    @FXML
    private TextField categoryField;

    @FXML
    private TextField costField;

    @FXML
    private TextField titleField;

    @FXML
    void btnOKPressed(ActionEvent event) 
    {
        JFrame jFrame = new JFrame();
        for (Frame frame : Frame.getFrames()) 
        {
            if (frame.getTitle().equals("Add Book To Store")) 
            {
                jFrame = (JFrame) frame;
                break;
            }
        }

        String title = titleField.getText();
        String category = categoryField.getText();
        Float cost;
        try {
            cost = Float.parseFloat(costField.getText());
            store.addMedia(new Book(title, category, cost));
            
            JOptionPane.showMessageDialog(
                jFrame,
                "The Book has been added successfully!",
                "Adding Alert",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                jFrame,
                "Please enter a valid number!",
                "Adding error",
                JOptionPane.ERROR_MESSAGE);
        }

        titleField.clear();
        categoryField.clear();
        costField.clear();
    }

     @FXML
    void viewCartPressed(ActionEvent event) 
    {
        for (Frame frame : Frame.getFrames()) 
        {
            frame.setVisible(frame.getTitle().equals("Cart"));
        }
    }
}