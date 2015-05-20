package com.bea.xml.stream.samples;

import com.porkosoftware.ews.xml.stream.XMLInputFactory;
import com.porkosoftware.ews.xml.stream.XMLOutputFactory;
import com.porkosoftware.ews.xml.stream.XMLEventReader;
import com.porkosoftware.ews.xml.stream.XMLEventWriter;
import java.io.FileReader;

/**
 * @author Copyright (c) 2002 by BEA Systems. All Rights Reserved.
 */

public class EventWrite {

  private static String filename = null;
  
  private static void printUsage() {
    System.out.println("usage: java com.bea.xml.stream.samples.EventWrite <xmlfile>");
  }

  public static void main(String[] args) throws Exception {
    try { 
      filename = args[0];
    } catch (ArrayIndexOutOfBoundsException aioobe){
      printUsage();
      System.exit(0);
    }

    System.setProperty("XMLInputFactory",
                       "com.bea.xml.stream.MXParserFactory");
    System.setProperty("XMLOutputFactory",
                       "com.bea.xml.stream.XMLOutputFactoryBase");
    System.setProperty("XMLEventFactory",
                       "com.bea.xml.stream.EventFactory");
    
    XMLInputFactory xmlif = XMLInputFactory.newInstance();
    XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
    xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,
                      Boolean.TRUE);


    XMLEventReader xmlr = xmlif.createXMLEventReader(new FileReader(filename));
    XMLEventWriter xmlw = xmlof.createXMLEventWriter(System.out);
    
    xmlw.add(xmlr);
    xmlw.flush();
  }
}




