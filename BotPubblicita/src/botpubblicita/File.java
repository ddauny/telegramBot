/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botpubblicita;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani2
 */
public class File {

    private static FileWriter fw;// = new FileWriter();
    private static FileReader fr;
    private static String fileName = "utenti.csv";

    public File() {

    }

    public static void write(String text) throws IOException {
        fw = new FileWriter(fileName);
        fw.write(text);
        fw.close();
    }

    public static void update(String[] text, int k) throws IOException {
        fw = new FileWriter(fileName);
        String s = "";
        for (int i = 0; i < text.length; i++) {
            if(i != k)
                s += text[0] + ";" +  text[1] + ";" + text[2] + "\n";
        }
        fw.write(s);
        fw.close();
    }

    public static String[] read(String nickname) {
        String v[] = new String[3];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                v[i] = line;
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public static int find(String nickname) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                //line = br.readLine();
                if (line.split(";")[0].equals(nickname)) {//se trovo già l'utente
                    return i;
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
