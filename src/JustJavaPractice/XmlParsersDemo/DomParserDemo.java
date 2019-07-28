package justJavaPractice.XmlParsersDemo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DomParserDemo {

  private static File xmlFile = new File("sample.xml");
  private static Document xmlDocument;

  private static NodeList nodeList;

  /**
   * @param args
   */
  public static void main(String[] args) {

    try {
      initialize();
	  String rootElement = "bean";
      loadXMLFile(rootElement);
      printLoadedXML(nodeList);
      removeElementAttributesByName("class");
      removeChildElementsByName("");
      printLoadedXML(nodeList);
      updateModifiedXML();

    }
    catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {}
  }

  private static void initialize()
      throws SAXException, IOException, ParserConfigurationException {

    DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuildFactory.newDocumentBuilder();
    xmlDocument = docBuilder.parse(xmlFile);
    xmlDocument.getDocumentElement().normalize();
  }

  private static void loadXMLFile(String rootElementName) {
    nodeList = xmlDocument.getElementsByTagName(rootElementName);
  }

  private static void printLoadedXML(NodeList nodeList) {
    if (nodeList == null) {
      return;
    }

    for (int i = 0; i < nodeList.getLength(); i++ ) {
      Node element = nodeList.item(i);
      if (!element.getNodeName().contains("#")) {
        System.out.print(element.getNodeName() + " ");
      }
      NamedNodeMap attributes = element.getAttributes();
      if (attributes != null) {
        for (int j = 0; j < attributes.getLength(); j++ ) {
          if (!attributes.item(j).toString().contains("#")) {
            System.out.print(attributes.item(j) + " ");
          }
        }
      }
      NodeList childElements = element.getChildNodes();
      printLoadedXML(childElements);
      System.out.println();
    }

  }

  private static void removeChildElementsByName(String argChildElementName) {

    boolean removeAllChildElements = false;
    if (argChildElementName == null || argChildElementName.equals("")) {
      removeAllChildElements = true;
    }

    for (int i = 0; i < nodeList.getLength(); i++ ) {
      Node element = nodeList.item(i);
      NodeList childElements = element.getChildNodes();
      for (int j = 0; j < childElements.getLength(); j++ ) {
        Node innerElement = childElements.item(j);
        if (removeAllChildElements && !innerElement.toString().contains("#")) {
          element.removeChild(innerElement);
        }
        else if (argChildElementName.equalsIgnoreCase(innerElement.getNodeName())) {
          element.removeChild(innerElement);
        }
      }
    } // End of for loop
  }

  private static void removeElementAttributesByName(String argAttributeName) {

    for (int i = 0; i < nodeList.getLength(); i++ ) {
      Node element = nodeList.item(i);
      NamedNodeMap attributes = element.getAttributes();
      for (int j = 0; j < attributes.getLength(); j++ ) {
        attributes.removeNamedItem(argAttributeName);
      }
    } // End of for loop

  }

  private static void updateModifiedXML()
      throws SAXException, IOException, ParserConfigurationException, TransformerException {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(xmlDocument);
    StreamResult result = new StreamResult(xmlFile);
    transformer.transform(source, result);
  }

}
