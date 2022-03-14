/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import telegramapi.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani2
 */
public class BotPubblicita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final String baseUrl = "https://api.telegram.org/bot";
        final String token = "5024404474:AAFdg91NpLQAHZvMeM1SRpJFsyKzhFmh1Y8/";

        botMethods b = new botMethods();
        
      //  b.sendMessage(661819829, "bro");
        TListener listener = new TListener(b,"https://api.telegram.org/bot5024404474:AAFdg91NpLQAHZvMeM1SRpJFsyKzhFmh1Y8/getUpdates");
        listener.start();
        try {
            listener.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BotPubblicita.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.getUpdates("https://api.telegram.org/bot5024404474:AAFdg91NpLQAHZvMeM1SRpJFsyKzhFmh1Y8/getUpdates");
    }

}
