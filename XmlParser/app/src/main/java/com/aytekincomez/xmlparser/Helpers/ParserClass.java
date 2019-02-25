package com.aytekincomez.xmlparser.Helpers;

import com.aytekincomez.xmlparser.Model.Kurs;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ParserClass extends DefaultHandler{

    public ArrayList<Kurs> kurslar = new ArrayList<>();

    String geciciAd = "";
    int geciciSaatSayisi = 0;
    String geciciEgitmen = "";
    int geciciKontenjan = 0;

    private String gecici;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(localName.equalsIgnoreCase("ad")){
            gecici = "";
        }else if(localName.equalsIgnoreCase("saatSayisi")){
            gecici = "";
        }else if(localName.equalsIgnoreCase("egitmen")){
            gecici = "";
        }else if(localName.equalsIgnoreCase("kontenjan")){
            gecici = "";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(localName.equalsIgnoreCase("ad")){
            geciciAd = gecici;
        }else if(localName.equalsIgnoreCase("saatSayisi")){
            geciciSaatSayisi = Integer.parseInt(gecici);
        }else if(localName.equalsIgnoreCase("egitmen")){
            geciciEgitmen = gecici;
        }else if(localName.equalsIgnoreCase("kontenjan")){
            geciciKontenjan = Integer.parseInt(gecici);
        }
        gecici = "";
        if(localName.equals("kurs")){
            kurslar.add(new Kurs(geciciAd, geciciSaatSayisi, geciciEgitmen, geciciKontenjan));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        gecici += new String(ch, start, length);
    }
}
