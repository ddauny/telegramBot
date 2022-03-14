/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import telegramapi.*;
/**
 *
 * @author iania_daniele
 */
public class Analizza {
    static Message message;

    public Analizza( ) {
        
    }
    
    public static void analizza(Message m) throws UnsupportedEncodingException, MalformedURLException{
        message = m;
        String text = message.text;
        String[] t = text.split(" ");
        switch(t[0]){
            case "/citta":
                String url = "https://nominatim.openstreetmap.org/search?q=";
                String path = URLEncoder.encode(getLocation(t), "UTF-8");
                URL fileUrl = new URL(url + path);
                System.out.println(url + path);
                break;
        }
        
        
    }
    
    private static String getLocation(String[] v){
        String s = "";
        for(int i = 1; i < v.length; i++){
            s += v[i];
            s += " ";
        }
        return s;
    }
}
