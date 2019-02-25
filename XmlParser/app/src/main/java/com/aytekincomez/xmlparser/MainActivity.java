package com.aytekincomez.xmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aytekincomez.xmlparser.Adapter.MyAdapter;
import com.aytekincomez.xmlparser.Helpers.ParserClass;
import com.aytekincomez.xmlparser.Model.Kurs;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Kurs> kurslar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.liste);
        kurslar = new ArrayList<>();
        verileriDoldur();
    }

    private void verileriDoldur() {
        try{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();
            ParserClass pc = new ParserClass();
            xmlReader.setContentHandler(pc);

            InputStream is = getAssets().open("kurslar.xml");
            xmlReader.parse(new InputSource(is));

            MyAdapter myAdapter = new MyAdapter(this, pc.kurslar);
            listView.setAdapter(myAdapter);

        }catch (Exception e){

        }
    }
}
