package hust.soict.cybersec.aims.screen;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddDVDToStoreController extends MenuBarController
{
    private Store store;
    
    public AddDVDToStoreController(Store store)
    {
        this.store = store;
    }


    @FXML
    private TextField categoryField;

    @FXML
    private TextField costField;

    @FXML
    private TextField directorField;

    @FXML
    private TextField lengthField;

    @FXML
    private TextField titleField;

    @FXML
    void btnOKPressed(ActionEvent event) 
    {
        JFrame jFrame = new JFrame();
        for (Frame frame : Frame.getFrames()) 
        {
            if (frame.getTitle().equals("Add DVD To Store")) 
            {
                jFrame = (JFrame) frame;
                break;
            }
        }
        
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost;
        int length;
        String director = directorField.getText();
        try {
            cost = Float.parseFloat(costField.getText());
            length = Integer.parseInt(lengthField.getText());
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
            
            JOptionPane.showMessageDialog(
                jFrame,
                "The DVD has been added successfully!",
                "Adding Alert",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                jFrame,
                "Please enter a valid number!",
                "Adding error",
                JOptionPane.ERROR_MESSAGE);
        }

        categoryField.clear();
        costField.clear();
        directorField.clear();
        lengthField.clear();
        titleField.clear();
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
