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
public class Vector4 {

    public double x;
    public double y;
    public double z;

    public Vector4(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector4() {
    }
    
    public Vector4(Vector4 r) {
        this.x = r.x;
        this.y = r.y;
        this.z = r.z;
    }

    public static Vector4 crossProduct(Vector4 u, Vector4 v) {
        Vector4 r = new Vector4();
        r.x = u.x * v.z - u.z * v.y;
        r.y = u.x * v.z - u.z * v.x;
        r.z = u.x * v.y - u.y * v.x;
        return r;
    }

    public static double dotProduct(Vector4 u, Vector4 v) {
        double r;
        r = u.x * v.x + u.y * v.y + u.z * v.z;
        return r;
    }

    public double magnitud() {
        double r;
        r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return r;
    }

    public void normalize() {
        double m = magnitud();
        x = x / m;
        y = y / m;
        z = z / m;
    }


}
