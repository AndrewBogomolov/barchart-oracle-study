package com.sun.deploy.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class AdvancedPanel extends JPanel
{
  JTree tree;

  public AdvancedPanel()
  {
    initComponents();
  }

  public void reset()
  {
    removeAll();
    initComponents();
  }

  public void initComponents()
  {
    setLayout(new BorderLayout());
    setBorder(new EmptyBorder(new Insets(10, 5, 5, 5)));
    JScrollPane localJScrollPane = new JScrollPane();
    localJScrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    this.tree = createJTreeFromXML();
    localJScrollPane.setViewportView(this.tree);
    add(localJScrollPane, "Center");
  }

  public JTree createJTreeFromXML()
  {
    try
    {
      SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
      SAXParser localSAXParser = localSAXParserFactory.newSAXParser();
      XMLDocumentHandler localXMLDocumentHandler = new XMLDocumentHandler();
      ClassLoader localClassLoader = getClass().getClassLoader();
      if (localClassLoader == null)
        localSAXParser.parse(ClassLoader.getSystemResourceAsStream("com/sun/deploy/panel/settings.xml"), localXMLDocumentHandler);
      else
        localSAXParser.parse(localClassLoader.getResourceAsStream("com/sun/deploy/panel/settings.xml"), localXMLDocumentHandler);
      JTree localJTree = localXMLDocumentHandler.getJTree();
      PropertyTreeModel localPropertyTreeModel = (PropertyTreeModel)localJTree.getModel();
      addAdvancedPropertiesListeners(localPropertyTreeModel);
      return localJTree;
    }
    catch (FactoryConfigurationError localFactoryConfigurationError)
    {
      localFactoryConfigurationError.printStackTrace();
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
    }
    catch (SAXException localSAXException)
    {
      localSAXException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }

  private static void addAdvancedPropertiesListeners(PropertyTreeModel paramPropertyTreeModel)
  {
    paramPropertyTreeModel.addTreeModelListener(new AdvancedProperties.NewPluginOptionListener());
  }
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.panel.AdvancedPanel
 * JD-Core Version:    0.6.2
 */