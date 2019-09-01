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
public class EcParSegReg {
    double x1,x2,y1,y2;

    public EcParSegReg(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public EcParSegReg() {
    }
    
    public static double[] solve(EcParSegReg ecua1, EcParSegReg ecua2){
        double[] vectorU = new double[2];
        double dx1 = (ecua1.x2 -ecua1.x1);
        double dy1 = (ecua1.y2 -ecua1.y1);
        double dx2 = (ecua2.x2 -ecua2.x1);
        double dy2 = (ecua2.y2 -ecua2.y1);
        
        double u1 = (ecua2.y1-ecua1.y1+(ecua1.x1-ecua2.x1)*(dy2/dx2))/((dx2-dx1*dy2)/dx2);
        double u2 = (ecua1.x1-ecua2.x1+u1*dx1)/dx2;
        
        System.out.println("u1:"+u1);
        System.out.println("u2:"+u2);
        
        vectorU[0]=u1;
        vectorU[1]=u2;
        
        return vectorU;
    }
}
