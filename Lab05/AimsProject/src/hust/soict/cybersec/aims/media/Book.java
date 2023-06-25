package hust.soict.cybersec.aims.media;
import java.util.ArrayList;

import java.util.List;

public class Book extends Media
{
    private List<String> authors = new ArrayList<String>();

    public Book()
    {
        super();
    }

    public Book(int id, String title, String category, float cost, List<String> authors)
    {  
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(String title, String category, float cost)
    {
        super(title, category, cost);
    }
    
    public Book(String title, String category, float cost, List<String> authors)
    {
        super(title, category, cost);
        this.authors = authors;
    }
    
    public Book(int id, String title, String category, float cost)
    {  
        super(id, title, category, cost);
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

    @Override 
    public String toString()
    {
        StringBuilder s = new StringBuilder("Book - " + "[" + super.getTitle() + "] - [" + super.getCategory() + "]: " + super.getCost() + "$\n");
        s.append("List of authors: \n");
        if (this.authors.size() == 0)
        {
            s.append("The Authors of this book are unknown\n");
            return s.toString();
        }

        for (int i = 0; i < this.authors.size(); i++)
        {
            s.append((i + 1) + ". " + this.authors.get(i) + "\n");
        }

        return s.toString();
    }
}
