/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematico;

/**
 *
 * @author will
 */
public class Point4 {
    public double x;
    public double y;
    public double z;
    public double w;

    public Point4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Point4() {
    }
    
    public Point4(Point4 r) {
        this.x = r.x;
        this.y = r.y;
        this.z = r.z;
        this.w = r.w;
    }
    
    
}
