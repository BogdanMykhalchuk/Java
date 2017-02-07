package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
//	    List<Comment> commentList = new ArrayList<>();
//        Comment comment1 = new Comment("Error", "Bogdan", 2);
//        commentList.add(comment1);
//        Comment comment2 = new Comment("Error2", "Kolia", 3);
//        commentList.add(comment2);
//        Comment comment3 = new Comment("Error3", "Kolia", 1);
//        commentList.add(comment3);
//        Book book1 = new Book("Book 1", "Mark Twen", 250, commentList);
//        System.out.println(book1);
//        try {
//            File xml = new File("D:\\XML.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//            marshaller.marshal(book1, xml);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        try {
            File xml = new File("D:\\XML.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Book book = (Book) unmarshaller.unmarshal(xml);
            System.out.println(book);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
