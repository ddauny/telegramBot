/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botpubblicita;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void append(String text) throws IOException {
        fw = new FileWriter(fileName, true);
        fw.append(text);
        fw.close();
    }

    public static void update(String text, int k) throws IOException {
        ArrayList<String> utenti = read();
        String s[] = new String[3];
        String out = "";
        fw = new FileWriter(fileName);
        //System.out.println(v.length);
        for (int i = 0; i < utenti.size(); i++) {
            if (i != k) {
                s = utenti.get(i).split(";");
                out += s[0] + ";" + s[1] + ";" + s[2] + "\n";
            }
        }
        out += text;
        fw.write(out);
        fw.close();
    }

    public static ArrayList<String> read() {
        ArrayList<String> utenti = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                utenti.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utenti;
    }

    public static int find(int id) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                //line = br.readLine();
                //System.out.println("reading");
                if (Integer.parseInt(line.split(";")[0]) == id) {//se trovo già l'utente
                    //System.out.println(i);
                    return i;
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("-1");
        return -1;
    }
}
