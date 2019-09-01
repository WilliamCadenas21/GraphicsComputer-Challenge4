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
public class Point3 {
    public double x;
    public double y;
    public double w;

    public Point3(double x, double y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public Point3() {
    }
    
    public Point3(Point3 r) {
        this.x = r.x;
        this.y = r.y;
        this.w = r.w;
    }
}
