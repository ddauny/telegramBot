/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegramapi;

/**
 *
 * @author dani2
 */
public class Message {
    public From from;
    public Chat chat;
    public int update_id;
    public int message_id;
    public int date;
    public String text;

    public Message(From from, Chat chat, int update_id, int message_id, int date, String text) {
        this.from = from;
        this.chat = chat;
        this.update_id = update_id;
        this.message_id = message_id;
        this.date = date;
        this.text = text;
    }
 
    public Message() {
    }
}
