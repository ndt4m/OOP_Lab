package hust.soict.cybersec.aims.screen;

import java.awt.Frame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuBarController 
{
    @FXML
    void addBookPressed(ActionEvent event) 
    {
        for (Frame frame : Frame.getFrames()) 
        {
            frame.setVisible(frame.getTitle().equals("Add Book To Store"));
        }
    }

    @FXML
    void addCDPressed(ActionEvent event) 
    {
        for (Frame frame : Frame.getFrames()) 
        {
            frame.setVisible(frame.getTitle().equals("Add CD To Store"));
        }
    }

    @FXML
    void addDVDPressed(ActionEvent event) 
    {
        for (Frame frame : Frame.getFrames()) 
        {
            frame.setVisible(frame.getTitle().equals("Add DVD To Store"));
        }
    }

    
    @FXML
    void viewStorePressed(ActionEvent event) 
    {
        for (Frame frame : Frame.getFrames()) 
        {
            frame.setVisible(frame.getTitle().equals("Store"));
        }
    }
}
