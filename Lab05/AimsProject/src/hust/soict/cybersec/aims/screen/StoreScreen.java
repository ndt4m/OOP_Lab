package hust.soict.cybersec.aims.screen;

import java.util.ArrayList;
import java.util.List;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Track;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.cybersec.aims.store.Store;

public class StoreScreen extends JFrame
{
    private static Store store = new Store();
    protected static Cart cart = new Cart();

    JPanel createNorth()
    {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar()
    {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Updata Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;

    }

    JPanel createHeader()
    {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter()
    {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++)
        {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen()
    {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
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
        StoreScreen.store.addMedia(cd);                                            
        StoreScreen.store.addMedia(dvd1);
        StoreScreen.store.addMedia(dvd2);
        StoreScreen.store.addMedia(dvd3);
        StoreScreen.store.addMedia(book1);
        StoreScreen.store.addMedia(book2);


        new StoreScreen();
    }
}
