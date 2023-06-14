package hust.soict.cybersec.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Track;

public class Aims 
{
    private static Scanner sc = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void StoreItems()
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
        store.addMedia(cd);                                            
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);


        cart.addMedia(cd);                                            
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(book2);
    }

    public static void showMenu() 
    {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        System.out.print("Your choise is: ");
        int choice = sc.nextInt();
        while (choice != 0)
        {


            if(choice == 1)
            { //View store

                for (int i = 0; i < store.getItemsInStore().size(); i++)
                {
                    System.out.println((i + 1) + ". " + store.getItemsInStore().get(i).getTitle());
                }
                storeMenu();
                chooseOptionStoreMenu();
                break;

            } 
            else if (choice ==2)
            { //Update store

                viewUpdateStore();
                break;

            }
            else if(choice == 3)
            { //See current cart

                cartMenu();
                currentCart();
                break;
            } 
            else
            {

                System.out.println("Choose number again .....");
                choice = sc.nextInt();
            }
        }
    }

    
    public static void storeMenu() 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void chooseOptionStoreMenu()
    {
        while (true) 
        {
        System.out.print("Your choice is: ");
        int choice = sc.nextInt();
            // See a media’s details
            if (choice == 1) 
            {
                System.out.print("Enter the title of media: ");
                sc.nextLine();
                String title = sc.nextLine();
                List<Media> medias = store.searchByTitle(title);
                if(medias.size() == 0)
                {
                    System.out.println("Media is not found");
                }
                else
                {
                    for(int i = 0; i < medias.size(); i++)
                    {
                        System.out.println((i + 1) + ". " + medias.get(i).toString());
                    }
                    mediaDetailsMenu();
                    chooseOptionMediaDetailMenu(medias);
                }
            } 
            else if (choice == 2)
            { //Add a media to cart
                System.out.print("Enter the title of the media: ");
                sc.nextLine();
                String title = sc.nextLine();
                List<Media> medias = store.searchByTitle(title); // search by title
                if (medias.size() != 0) 
                {
                    for (Media media : medias)
                    {
                        cart.addMedia(media); // add item into cart
                    }
                    System.out.println("Number of items on cart: " + cart.getItemsOrdered().size());
                } 
                else
                {
                    System.out.println("Media not found.");
                }
               
            } 
            else if(choice == 3)
            { //Play a media
                System.out.print("Enter the title of the media: ");
                sc.nextLine();
                String title = sc.nextLine();
                List<Media> medias = store.searchByTitle(title); // search by title
                if (medias.size() != 0) 
                {
                    for (Media media : medias) 
                    {
                        if (media instanceof Playable)
                        {
                            System.out.println("Play " + media.getTitle());
                            ((Playable) media).play();
                        }
                        else
                        {
                            System.out.println("Can not play " + media.getTitle());
                        }
                    }
                } 
                else
                {
                    System.out.println("Media not found.");
                }

            } 
            else if (choice == 4)
            { //See current cart

                currentCart();
            } 
            else if (choice == 0)
            { //Back

                showMenu();
                break;
            }
            else
            {
                System.out.println("Invalid value. Please choose a number: 0-1-2-3-4");
            }
        }
    }

    public static void mediaDetailsMenu() 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void chooseOptionMediaDetailMenu(List<Media> medias)
    {

        while(true)
        {
            System.out.print("Your choice is: ");
            int choice = sc.nextInt();
            sc.nextLine(); // ignore newline

            if (choice == 0)
            {
                storeMenu();
                chooseOptionStoreMenu();
                break;
            }

            else if (choice == 1)
            {
                // Add to cart
                // System.out.print("Enter the title of the media: ");
                // sc.nextLine();
                // String title = sc.nextLine();
                // List<Media> medias = store.searchByTitle(title); // search by title
                if (medias.size() != 0) 
                {
                    for (Media media : medias) 
                    {
                        cart.addMedia(media); // add item into cart
                        System.out.println("Added " + media.getTitle() + " to cart.");
                    }
                } 
                else 
                {
                    System.out.println("Media not found.");
                }
                // break;
            }
            else if (choice == 2)
            {
                // System.out.print("Enter the title of the media: ");
                // String title = sc.nextLine();
                // List<Media> medias = store.searchByTitle(title); // search by title
                if (medias.size() != 0) 
                {
                    for (Media media : medias) 
                    {
                        if (media instanceof Playable)
                        {
                            System.out.println("Play " + media.getTitle());
                            ((Playable) media).play();
                        }
                        else
                        {
                            System.out.println("Can not play " + media.getTitle());
                        }
                    }
                } 
                else
                {
                    System.out.println("Media not found.");
                }
                // break;
            }
            else
            {
                System.out.println("Invalid value\n");
            }
            mediaDetailsMenu();
        }
    }
    
    public static void updateStore() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

    }

    public static void viewUpdateStore()
    {
        int choice;
        while(true)
        {
            updateStore();
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1)
            {  //add a media to store
                addStore();
            } 
            else if (choice == 2)
            { //remove a media to store
                removeStore();
            } 
            else if (choice == 0)
            {
                showMenu();
                break;
            } 
            else
            {
                System.out.println("Invalid value.\n");
            }
        }
    }

    public static void addStore()
    {
        System.out.print("Which type (Book,CD,DVD): ");
        String type = sc.nextLine();

        System.out.print("Enter the id of media: ");
        int id = sc.nextInt();

        System.out.print("Enter the title of the media: ");
        String title = sc.nextLine();

        System.out.print("Enter the cost of the media: ");
        float cost = sc.nextFloat();
        sc.nextLine();

        System.out.print("Enter category of the media: ");
        String category = sc.nextLine();

        if(type.equals("Book"))
        {
            store.addMedia(new Book(id, title, category, cost));
        } 
        else if(type.equals("Cd"))
        {
            System.out.print("Enter director of the Cd: ");
            String director = sc.nextLine();
            System.out.print("Enter artist of the Cd: ");
            String artist = sc.nextLine();
            System.out.print("Enter number of track of Cd: ");
            int count = sc.nextInt();
            System.out.print("Enter length of the Cd: ");
            int length = sc.nextInt();
            List<Track> tracks = new ArrayList<>();
            for (int i = 1; i <= count; i++)
            {
                System.out.println("Track " + i +": ");
                System.out.print("Enter title of track: ");
                String title_track = sc.nextLine();
                System.out.print("Length of track: ");
                int length_track = sc.nextInt();
                tracks.add(new Track(title_track, length_track));
            }

            store.addMedia(new CompactDisc(id, title, category, cost, length, director, artist, tracks));
        } 
        else if(type.equals("DVD"))
        {
            System.out.print("Enter director of the DVD: ");
            String director = sc.nextLine();
            System.out.print("Enter length of the DVD: ");
            int length = sc.nextInt();
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        }

    }

    public static void removeStore()
    {
        for(Media media : store.getItemsInStore())
        {
            System.out.println("[+] " + media.getTitle());
        }
        System.out.print("Enter the title of the media you want to remove: ");
        String title = sc.nextLine();
        store.removeMedia(store.searchByTitle(title));
        System.out.println("The medias has been removed");

    }

    public static void cartMenu() 
    {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void currentCart()
    {   
        System.out.println("The list of medias in the current cart");
        for (Media m: cart.getItemsOrdered())
        {
            System.out.println("[+] " + m.getTitle());
        }

        while (true)
        {
            cartMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // ignore newline
            if(choice == 1)
            { //Filter medias in cart

                filterMedia();
            }
            else if (choice ==2)
            { //Sort medias in cart

                sortMedia();
            }
            else if (choice ==3)
            { //Remove media from cart

            }
            else if (choice ==4)
            { //Play a media

            }
            else if (choice ==5)
            { //Place order

                placeOrder();
            }
            else if (choice ==0)
            { //Back

                showMenu();
                break;
            }
            else
            {
                System.out.println("Invalid value.\n");
            }
        }
    }

    public static void filterMedia()
    {
        while (true)
        {
            System.out.println("1. Filter by id");
            System.out.println("2. Filter by title");
            System.out.println("0. Back");
            System.out.print("Your choice is: ");
            int option = sc.nextInt();

            if (option == 1) 
            {
                // Ask the user for an id to filter the medias in the cart
                System.out.print("Please enter an id: ");
                int id = sc.nextInt();

                // Filter the medias in the cart by the specified id
                List<Media> filteredMedias = new ArrayList<>();
                for (Media media : cart.getItemsOrdered()) 
                {
                    if (media.getId() == id) 
                    {
                        filteredMedias.add(media);
                    }
                }

                if(filteredMedias.isEmpty())
                {
                    System.out.println("Media not found.");
                }

                // Display the filtered medias to the user
                for (Media media : filteredMedias) 
                {
                    System.out.println(media.getTitle() + " (" + media.getCategory() + "): $" + media.getCost());
                }
            } 
            else if (option == 2) 
            {
                sc.nextLine();
                // Ask the user for a title to filter the medias in the cart
                System.out.print("Please enter a title: ");
                String title = sc.nextLine();

                // Filter the medias in the cart by the specified title
                List<Media> filteredMedias = new ArrayList<>();
                for (Media media : cart.getItemsOrdered()) 
                {
                    if (media.getTitle().equals(title)) 
                    {
                        filteredMedias.add(media);
                    }
                }

                if(filteredMedias.isEmpty())
                {
                    System.out.println("Media not found.");
                }

                // Display the filtered medias to the user
                for (Media media : filteredMedias) 
                {
                    System.out.println(media.getTitle() + " (" + media.getCategory() + "): $" + media.getCost());
                }

            }
            else if(option == 0)
            {
                currentCart();
                break;
            }
            else 
            {
                System.out.println("Invalid option selected. Please try again.");
            }
        }
    }

    public static void sortMedia()
    {
        System.out.println("Sort medias in cart by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");

        int choice = sc.nextInt();
        sc.nextLine(); // consume the newline character

        if (choice == 1) 
        {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
            System.out.println("Medias sorted by title.");
            for (Media m : cart.getItemsOrdered())
            {
                System.out.println(m.toString());
            }

        } 
        else if (choice == 2) 
        {
            Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_COST_TITLE);
            System.out.println("Medias sorted by cost.");
            for (Media m : cart.getItemsOrdered())
            {
                System.out.println(m.toString());
            }

        } 
        else 
        {
            System.out.println("Invalid choice.");
        }
    }

    public static void placeOrder()
    {
        System.out.println(cart.getItemsOrdered().toString());
        System.out.println("An order has been created. Thank you for shopping with us!");
        cart.removeAll();
    }

    public static void main(String[] args) 
    {

        StoreItems();
        showMenu();
    }
}
