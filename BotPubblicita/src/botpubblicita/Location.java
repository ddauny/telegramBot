/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

/**
 *
 * @author iania_daniele
 */
public class Location {

    public double lat, lon;

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String toString() {
        return "latitude: " + lat + ", longitude: " + lon;
    }
}
