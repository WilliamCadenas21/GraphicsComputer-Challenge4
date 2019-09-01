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
public class Matrix4x4 {

    public double[][] matrix;

    public Matrix4x4() {
        this.matrix = new double[4][4];
    }

    public Matrix4x4(double[][] matrix) {
        this.matrix = matrix;
    }
    
    public Matrix4x4(Matrix4x4 m) {
        this.matrix = m.matrix;
    }

    /**
     * multiply a matrix 4x4 with a vector3
     *
     * @param m an instance of the class Matrix3x3
     * @param p an instance of the class Point3
     * @return
     */
    public static Point4 times(Matrix4x4 m, Point4 p) {
        Point4 r = new Point4();
        double sum;
        for (int i = 0; i < 4; i++) {
            sum = 0;
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        sum = sum + m.matrix[i][j] * p.x;
                        break;
                    case 1:
                        sum = sum + m.matrix[i][j] * p.y;
                        break;
                    case 2:
                        sum = sum + m.matrix[i][j] * p.z;
                        break;
                    case 3:
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
                    r.z = sum;
                    break;
                case 3:
                    r.w = sum;
                    break;
            }
        }
        return r;
    }

    /**
     * multiply two matrix 4x4
     *
     * @param m Matrix right
     * @param n Matrix left
     * @return
     */
    public static Matrix4x4 times(Matrix4x4 m, Matrix4x4 n) {
        Matrix4x4 r = new Matrix4x4();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                r.matrix[i][j] = dotProduct(m, n, i, j);
            }
        }
        return r;
    }

    /**
     * this function was created for help to operate the dot product operation
     *
     * @param m Matrix right
     * @param n Matrix left
     * @param i pivot point in matrix right
     * @param j pivot point in matrix left
     * @return
     */
    public static double dotProduct(Matrix4x4 m, Matrix4x4 n, int i, int j) {
        double escalar = 0;
        for (int k = 0; k < 4; k++) {
            escalar = escalar + m.matrix[i][k] * n.matrix[k][j];
        }
        return escalar;
    }
}
