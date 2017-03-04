package Training.Customer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
    private String body;
    private String author;
    private int numberOfLines;

    public Comment() {}

    public Comment(String body, String author, int numberOfLines) {
        this.body = body;
        this.author = author;
        this.numberOfLines = numberOfLines;
    }
    @XmlElement
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @XmlElement
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    @Override
    public String toString() {
        return "Comment: " + body + ";the author: " + author + ";number of lines: " + numberOfLines + "\n";
    }
}



