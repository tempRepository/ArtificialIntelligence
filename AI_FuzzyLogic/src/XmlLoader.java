import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlLoader {
    public static ArrayList<Student> loadXml(String name)
            throws ParserConfigurationException, SAXException, IOException,
            XPathExpressionException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory
                .newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(name);
        XPath xpath = XPathFactory.newInstance().newXPath();
        // XPath Query for showing all nodes value
        XPathExpression expr = xpath.compile("//student");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        ArrayList<Student> examples = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            int id = new Integer(nodes.item(i).getAttributes()
                    .getNamedItem("id").getNodeValue());
            float electronics = new Float(nodes.item(i).getAttributes()
                    .getNamedItem("electronics").getNodeValue());
            float computerScience = new Float(nodes.item(i).getAttributes()
                    .getNamedItem("computerScience").getNodeValue());
            float mathematics = new Float(nodes.item(i).getAttributes()
                    .getNamedItem("mathematics").getNodeValue());
            float english = new Float(nodes.item(i).getAttributes()
                    .getNamedItem("english").getNodeValue());
            float german = new Float(nodes.item(i).getAttributes()
                    .getNamedItem("german").getNodeValue());
            String studentName = new String(nodes.item(i).getAttributes()
                    .getNamedItem("name").getNodeValue());
            Student temp = new Student();
            temp.setComputerScience(computerScience);
            temp.setElectronics(electronics);
            temp.setEnglish(english);
            temp.setGerman(german);
            temp.setId(id);
            temp.setMathematics(mathematics);
            temp.setName(studentName);
            examples.add(temp);

        }
        return examples;
    }
}
