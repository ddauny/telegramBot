/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegramapi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.*;

/**
 *
 * @author dani2
 */
public class botMethods {

    public ArrayList<Message> getUpdates(String jsonS) throws IOException {
//        Chat chat;
//        Message mex;
//        From from;        
//        ArrayList<Message> messageList = new ArrayList<Message>();
        URL fileUrl = new URL(jsonS);
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        String jsonString = content;
        JSONObject obj = new JSONObject(jsonString);
        JSONArray v = obj.getJSONArray("result");
        
        JSONObject o;//, m, f, c;
        for (int i = 0; i < v.length(); i++) {
            o = v.getJSONObject(i);
            
            //o.getString("nome");
            //o.getJSONArray("nome");
//            o.getJSONObject("message");
        }
          return new ArrayList<Message>();
    }

    public static void sendMessage(int idDestinatario, String testo) throws MalformedURLException, IOException {
        String url = "https://api.telegram.org/bot5024404474:AAFdg91NpLQAHZvMeM1SRpJFsyKzhFmh1Y8/sendMessage?";
        String path = "chat_id=" + idDestinatario + "&text=" + URLEncoder.encode(testo, "UTF-8");
        URL fileUrl = new URL(url + path);
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        inRemote.close();
    }

    public String leggi(String url) throws FileNotFoundException, IOException {
        URL fileUrl = new URL(url);
        Scanner inRemote = new Scanner(fileUrl.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();
        return content;
    }
}
