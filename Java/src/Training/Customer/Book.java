package Training.Customer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Book")
public class Book {
    
    private String title;
    private String author;
    private int numberPages;
    private List<Comment> comments;

    public Book() {
    }

    public Book(String title, String author, int numberPages, List<Comment> comments) {
        this.title = title;
        this.author = author;
        this.numberPages = numberPages;
        this.comments = comments;
    }

    @XmlElement
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlAttribute
    public int getNumberPages() {
        return this.numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    @XmlElementWrapper(name = "comments")
    @XmlElement(name = "comment")
    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return String.format("Name of the book is: %s;\nthe author of the book is: %s;\nthe number of pages is: %d;\ncomments are: %s",
            title, author, numberPages, comments);
    }
}
