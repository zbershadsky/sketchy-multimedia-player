package com.paziy.sketchy.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class Parser<Type extends Parseable> extends DefaultHandler {
    private String wrapperTag;
    private List<Type> records;
    private Type record;
    private String value;
    private ParseableFactory<Type> factory;

    public Parser(ParseableFactory<Type> factory, String wrapperTag) {
        this.factory = factory;
        this.wrapperTag = wrapperTag;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        value = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals(wrapperTag)) {
            records.add(record);
        } else {
            record.setField(qName, value);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        records = new LinkedList<Type>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals(wrapperTag)) {
            record = factory.create();
        }
    }

    public List<Type> parse(InputStream is) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(is, this, "");
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return records;
    }
}
