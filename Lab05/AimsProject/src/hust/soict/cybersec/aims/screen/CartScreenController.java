package hust.soict.cybersec.aims.screen;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionListener;

public class CartScreenController extends MenuBarController
{
    private Cart cart;

    private Store store;

    @FXML
    private Label totalCostLabel;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button placeOrderBtn;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart, Store store) 
    {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() 
    {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("Cost")
        );

        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) 
                    {
                        if (newValue != null) 
                        {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );


        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                showFilteredMedia(newValue);
            }
        });

        updateTotalCost();
        tblMedia.getItems().addListener(new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> change) 
                    {
                        updateTotalCost();
                    }
                }
        );
    }

    @FXML
    void btnRemovePressed(ActionEvent e) 
    {   
        JFrame jFrame = new JFrame();
        for (Frame frame : Frame.getFrames()) 
        {
            if (frame.getTitle().equals("Cart")) 
            {
                jFrame = (JFrame) frame;
                break;
            }
        }

        if (cart.getItemsOrdered().size() <= 0)
        {
            
            JOptionPane.showMessageDialog(
                jFrame,
                "The cart is currently empty!",
                "Removing error",
                JOptionPane.INFORMATION_MESSAGE);
        }

        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) 
    {
        JFrame jFrame = new JFrame();
        for (Frame frame : Frame.getFrames()) 
        {
            if (frame.getTitle().equals("Cart")) 
            {
                jFrame = (JFrame) frame;
                break;
            }
        }

        Media selectedMedia = tblMedia.getSelectionModel().selectedItemProperty().get();

        try {
            ((Playable) selectedMedia).play();

            JDialog playDialog = new JDialog(jFrame, "Play Media", true);
            playDialog.setLayout(new BorderLayout());

            StringBuilder s = new StringBuilder();
            s.append(selectedMedia.toString());
            

            JTextArea textArea = new JTextArea(s.toString(), 5, 20);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            
            playDialog.add(scrollPane, BorderLayout.CENTER);
            
            JButton btnExit = new JButton("Exit");
            btnExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    playDialog.setVisible(false);
                }
            });
            
            playDialog.add(btnExit, BorderLayout.SOUTH);
            playDialog.setSize(300, 200);
            playDialog.setLocationRelativeTo(jFrame);
            playDialog.setVisible(true);
        } catch (PlayerException e) {
            JOptionPane.showMessageDialog(
                    jFrame,
                    e.getMessage(),
                    "media length is smaller than 0!",
                    JOptionPane.ERROR_MESSAGE
            );
            //e.printStackTrace();
        }
    }

    @FXML
    void placeOrderBtnPressed(ActionEvent event) 
    {
        JFrame jFrame = new JFrame();
        for (Frame frame : Frame.getFrames()) 
        {
            if (frame.getTitle().equals("Cart")) 
            {
                jFrame = (JFrame) frame;
                break;
            }
        }

        if (cart.getItemsOrdered().size() > 0)
        {
            cart.removeAll();

            JOptionPane.showMessageDialog(
                jFrame,
                "Place order successfully!",
                "Place Order Error",
                JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(
                jFrame,
                "The cart is currently empty!",
                "Place Order Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }


    void updateButtonBar(Media media) 
    {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    void showFilteredMedia(String filterValue) {
        cart.filterCart(filterValue, radioBtnFilterId.isSelected());
    }

    void updateTotalCost() 
    {
        Platform.runLater(new Runnable() {
                    @Override
                    public void run() 
                    {
                        totalCostLabel.setText(String.format("%.2f", cart.totalCost()) + "$");
                    }
                }
        );
    }
}
