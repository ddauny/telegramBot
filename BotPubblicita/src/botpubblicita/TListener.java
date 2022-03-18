/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramapi.*;

/**
 *
 * @author iania_daniele
 */
public class TListener extends Thread {

    botMethods b;
    String s;
    ArrayList<Message> messages = new ArrayList<Message>();
    int update_id = 0;

    public TListener(botMethods b, String s) {
        this.b = b;
        this.s = s;
    }

    public void run() {
        while (true) {
            try {
                messages = b.getUpdates(s);
                if (messages.size() - 1 >= 0) {
                    if (messages.get(messages.size() - 1).update_id != update_id)//se il nuovo id è diverso da quello vecchio
                    {//c'è un nuovo messaggio
                        update_id = messages.get(messages.size() - 1).update_id;
                        try{
                        Analizza.analizza(messages.get(messages.size() - 1));
                        }catch(Exception e){                          
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
