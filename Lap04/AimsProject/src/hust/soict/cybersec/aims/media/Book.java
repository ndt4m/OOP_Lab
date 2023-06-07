package hust.soict.cybersec.aims.media;
import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media
{
    private List<String> authors = new ArrayList<String>();

    public Book()
    {
        super();
    }

    public void addAuthor(String authorName)
    {
        if (this.authors.contains(authorName))
        {
            System.out.println("The author has already in the list");
        }
        else
        {
            this.authors.add(authorName);
            System.out.println("The author has successfully added to the list");
        }
    }

    public void removeAuthor(String authorName)
    {
        if (!this.authors.contains(authorName))
        {
            System.out.println("There is'nt an author with the name " + authorName + " in the author List");
        }
        else
        {
            this.authors.remove(authorName);
            System.out.println("The author " + authorName + "has been removed successfully");
        }
    }

    
}
