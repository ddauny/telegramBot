/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegramapi;

/**
 *
 * @author dani2
 */
public class Chat {
    public int id;
    public String first_name;
    public String username;
    public String type;

    public Chat(int id, String first_name, String username, String type) {
        this.id = id;
        this.first_name = first_name;
        this.username = username;
        this.type = type;
    }
    
    public Chat() {
    }  
}
