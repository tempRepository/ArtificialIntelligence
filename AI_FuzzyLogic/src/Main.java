import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;


public class Main {

    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        ArrayList<Student> students=XmlLoader.loadXml("examples.xml");
        System.out.println("Students marks");
        System.out.println("Id Electronics ComputerScience Mathematics English German Name");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        
        
        
        System.out.println("\n\nMembership Function Values");
        System.out.println("Id Electronics ComputerScience Mathematics English German Name");
        for (Student student : students) {
            System.out.println(student.toStringMF());
        }
        
        System.out.println("\n\nMF Min");
        for (Student student : students) {
            System.out.println(student.getId()+" "+student.getName()+" "+student.membershipFunctionMin());
        }
        
        Student bestChoice=Collections.max(students);
        System.out.println("\n\nThe best choice Id:"+bestChoice.getId()+" Name: "+bestChoice.getName());
        
    }

}
