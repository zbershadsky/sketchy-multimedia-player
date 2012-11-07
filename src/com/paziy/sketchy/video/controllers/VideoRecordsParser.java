package com.paziy.sketchy.video.controllers;

import com.paziy.sketchy.audio.model.Audio;
import com.paziy.sketchy.video.model.Video;
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

public class VideoRecordsParser extends DefaultHandler {
	private static final String TAG_VIDEO = "video";
	private static final String TAG_VID = "vid";
	private static final String TAG_OWNER_ID = "owner_id";
	private static final String TAG_TITLE = "title";
    private static final String TAG_DESCRIPTION = "description";
	private static final String TAG_DURATION = "duration";
	private static final String TAG_LINK = "link";
	private static final String TAG_IMAGE = "image";
	private static final String TAG_DATE = "date";
    private static final String TAG_PLAYER = "player";
	
	private List<Video> records;
	private Video video;
	private String value;
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		value = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals(TAG_VID)) {
            video.setVid(value);
        } else if (qName.equals(TAG_OWNER_ID)) {
            video.setOwner_id(value);
        } else if (qName.equals(TAG_TITLE)) {
            video.setTitle(value);
        } else if (qName.equals(TAG_DESCRIPTION)) {
            video.setDescription(value);
        } else if (qName.equals(TAG_DURATION)) {
            video.setDuration(value);
        } else if (qName.equals(TAG_LINK)) {
            video.setLink(value);
        } else if (qName.equals(TAG_IMAGE)) {
            video.setImage(value);
        } else if (qName.equals(TAG_DATE)) {
            video.setDate(value);
        } else if (qName.equals(TAG_PLAYER)) {
            video.setPlayer(value);
        } else if (qName.equals(TAG_VIDEO)) {
            records.add(video);
        }
	}

	@Override
	public void startDocument() throws SAXException {
		records = new LinkedList<Video>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals(TAG_VIDEO)) {
			video = new Video();
		}
	}

	public List<Video> parse(InputStream is) {
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
