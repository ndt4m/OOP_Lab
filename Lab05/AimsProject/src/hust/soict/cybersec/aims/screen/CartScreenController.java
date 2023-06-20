package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartScreenController(Cart cart)
    {
        super();
        this.cart = cart;
    }

    // public CartScreenController()
    // {

    // }

    @FXML
    private void initialize()
    {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());
    }

}
