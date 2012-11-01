package com.paziy.sketchy.audio.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.paziy.sketchy.audio.model.Audio;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AudioRecordsParser extends DefaultHandler {
	private static final String TAG_AUDIO = "audio";
	private static final String TAG_AID = "aid";
	private static final String TAG_OWNER_ID = "owner_id";
	private static final String TAG_ARTIST = "artist";
	private static final String TAG_TITLE = "title";
	private static final String TAG_DURATION = "duration";
	private static final String TAG_URL = "url";
	private static final String TAG_LYRICS_ID = "lyrics_id";
	private static final String TAG_ALBUM = "album";
	
	private List<Audio> records;
	private Audio audio;
	private String value;
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		value = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals(TAG_AID)) {
			audio.setAid(value);
		} else if (qName.equals(TAG_OWNER_ID)) {
			audio.setOwnerId(value);
		} else if (qName.equals(TAG_ARTIST)) {
			audio.setArtist(value);
		} else if (qName.equals(TAG_TITLE)) {
			audio.setTitle(value);
		} else if (qName.equals(TAG_DURATION)) {
			audio.setDuration(value);
		} else if (qName.equals(TAG_URL)) {
			audio.setUrl(value);
		} else if (qName.equals(TAG_LYRICS_ID)) {
			audio.setLyricsId(value);
		} else if (qName.equals(TAG_ALBUM)) {
			audio.setAlbum(value);
		} else if (qName.equals(TAG_AUDIO)) {
			records.add(audio);
		}
	}

	@Override
	public void startDocument() throws SAXException {
		records = new LinkedList<Audio>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals(TAG_AUDIO)) {
			audio = new Audio();
		}
	}

	public List<Audio> parse(InputStream is) {
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
