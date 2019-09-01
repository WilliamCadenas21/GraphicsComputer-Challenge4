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
public class Matrix3x3 {

    public double[][] matrix;

    public Matrix3x3() {
        this.matrix = new double[3][3];
    }

    public Matrix3x3(double[][] matrix) {
        this.matrix = matrix;
    }
    
    public Matrix3x3(Matrix3x3 m) {
        this.matrix = m.matrix;
    }

    /**
     * multiply a matrix 3x3 with a vector3
     * @param m an instance of the class Matrix3x3
     * @param p an instance of the class Point3
     * @return
     */
    public static Point3 times(Matrix3x3 m, Point3 p) {
        Point3 r = new Point3();
        double sum;
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        sum = sum + m.matrix[i][j] * p.x;
                        break;
                    case 1:
                        sum = sum + m.matrix[i][j] * p.y;
                        break;
                    case 2:
                        sum = sum + m.matrix[i][j] * p.w;
                        break;
                }
            }
            switch (i) {
                case 0:
                    r.x = sum;
                    break;
                case 1:
                    r.y = sum;
                    break;
                case 2:
                    r.w = sum;
                    break;
            }
        }
        return r;
    }
    
    /**
     * multiply two matrix 3x3
     * @param m Matrix right 
     * @param n Matrix left
     * @return 
     */
    public static Matrix3x3 times(Matrix3x3 m, Matrix3x3 n){
        Matrix3x3 r = new Matrix3x3();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                r.matrix[i][j] = dotProduct(m,n,i,j);
            }
        }
        return r;
    }
    
    /**
     * this function was created for help to operate the dot product operation 
     * @param m Matrix right
     * @param n Matrix left
     * @param i pivot point in matrix right
     * @param j pivot point in matrix left
     * @return 
     */
    public static double dotProduct(Matrix3x3 m, Matrix3x3 n, int i,int j){
        double escalar = 0; 
        for (int k = 0; k < 3; k++) {
            escalar = escalar + m.matrix[i][k]*n.matrix[k][j];
        }
        return escalar;
    }
}
