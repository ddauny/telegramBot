/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import telegramapi.*;
/**
 *
 * @author iania_daniele
 */
public class Analizza {
    static Message message;
    static ArrayList<Location> locations;
    
    public Analizza( ) {
        
    }
    
    public static void analizza(Message m) throws UnsupportedEncodingException, MalformedURLException, ParserConfigurationException, SAXException, IOException{
        message = m;
        String text = message.text;
        String[] t = text.split(" ");
        switch(t[0]){
            case "/citta":
                String url = "https://nominatim.openstreetmap.org/search?q=";
                String path = URLEncoder.encode(getLocation(t, 1), "UTF-8");
                url += path + "&format=xml&addressdetails=1";
                URL fileUrl = new URL(url);
                System.out.println(url);
                locations = XMLParser.parseDocument(url);
                Location location = locations.get(0);//prendo la prima città per convenzione
                System.out.println(location.toString());
                int i = File.find(message.chat.id);
                if(i == -1)//se l'utente non era già registrato
                {
                    System.out.println("thread");
                    File.append(message.chat.id + ";" + location.lat + ";" + location.lon + "\n");
                } else {
                    //l'utente era già registrato
                    System.out.println("updating");
                    File.update(message.chat.id + ";" + location.lat + ";" + location.lon + "\n", i);
                }   
                break;
        }      
    }
    
    public static String getLocation(String[] v, int k){
        String s = "";
        for(int i = k; i < v.length; i++){
            s += v[i];
            s += " ";
        }
        return s;
    }
}
