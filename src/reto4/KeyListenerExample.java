package reto4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import matematico.*;

/**
 *
 * @author helmuthtrefftz
 */
public class KeyListenerExample extends JPanel implements KeyListener {

    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;

    static Point3[] pointsVec = new Point3[20];
    static Edge[] edgesVec = new Edge[20];

    static boolean DEBUG = true;

    public KeyListenerExample() {
        // El panel, por defecto no es "focusable". 
        // Hay que incluir estas líneas para que el panel pueda
        // agregarse como KeyListsener.
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        // size es el tamaÃ±o de la ventana.
        Dimension size = getSize();
        // Insets son los bordes y los tÃ­tulos de la ventana.
        Insets insets = getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        g.drawLine(0, h / 2, w, h / 2);// eje x
        g.drawLine(w / 2, 0, w / 2, h);// eje y

        show(edgesVec);
        for (int i = 0; i < edgesVec.length; i++) {
            System.out.println("dibujando");
            Edge e = edgesVec[i];
            Point3 p1 = e.p1;
            Point3 p2 = e.p2;
            int xr1 = w / 2 + (int) p1.x;
            int xr2 = w / 2 + (int) p2.x;
            int yr1 = h / 2 - (int) p1.y;
            int yr2 = h / 2 - (int) p2.y;

            g.drawLine(xr1, yr1, xr2, yr2);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();

        switch (tecla) {

            //Moving
            case KeyEvent.VK_D: {
                double[][] aux = {{1, 0, 10}, {0, 1, 0}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            case KeyEvent.VK_A: {
                double[][] aux = {{1, 0, -10}, {0, 1, 0}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            case KeyEvent.VK_W: {
                double[][] aux = {{1, 0, 0}, {0, 1, 10}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            case KeyEvent.VK_S: {
                double[][] aux = {{1, 0, 0}, {0, 1, -10}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            // Resizing
            case KeyEvent.VK_Q: {
                double[][] aux = {{0.9, 0, 0}, {0, 0.9, 0}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            case KeyEvent.VK_E: {
                double[][] aux = {{1.1, 0, 0}, {0, 1.1, 0}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            // Resizing
            case KeyEvent.VK_X: {
                double[][] aux = {{0.9, 0, 0}, {0, 0.9, 0}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }
            case KeyEvent.VK_C: {
                double[][] aux = {{1.1, 0, 0}, {0, 1.1, 0}, {0, 0, 1}};
                Matrix3x3 mt = new Matrix3x3(aux);
                move(mt);
                break;
            }

            default:
                break;
        }

        if (DEBUG) {
            System.out.println("Aplicando una transformación");
        }

        repaint();
    }

    public static void move(Matrix3x3 mt) {
        for (int i = 0; i < edgesVec.length; i++) {
            Point3 aux1 = edgesVec[i].p1;
            Point3 aux2 = edgesVec[i].p2;

            aux1 = Matrix3x3.times(mt, aux1);
            aux2 = Matrix3x3.times(mt, aux2);

            edgesVec[i].p1 = aux1;
            edgesVec[i].p2 = aux2;
        }
    }

    public static void readFile() throws IOException {
        // We need to provide file path as the parameter: 
        // double backquote is to avoid compiler interpret words 
        // like \test as \t (ie. as a escape sequence) 
        File file = new File("C:\\Users\\will\\Documents\\casita2d.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int indice = 0;
        int numberOfPoints = 0;
        int numberOfEdges;

        while ((st = br.readLine()) != null) {
            if (indice == 0) {
                numberOfPoints = Integer.parseInt(st);
                pointsVec = new Point3[numberOfPoints];
            } else if (indice <= numberOfPoints) {
                String[] stVec = st.split(" ");
                Double x = Double.parseDouble(stVec[0]);
                Double y = Double.parseDouble(stVec[1]);
                Point3 p = new Point3(x, y, 1);
                pointsVec[indice - 1] = p;
            } else if (indice == 1 + numberOfPoints) {
                numberOfEdges = Integer.parseInt(st);
                edgesVec = new Edge[numberOfEdges];
            } else if (indice >= 2 + numberOfPoints) {
                String[] stVec = st.split(" ");
                edgesVec[indice - 2 - numberOfPoints] = new Edge(pointsVec[Integer.parseInt(stVec[0])], pointsVec[Integer.parseInt(stVec[1])]);
            }
            indice++;
        }
    }

    public static void show(Point3[] vec) {
        for (Point3 p : vec) {
            System.out.println("x:" + p.x + " y:" + p.y + " w;" + p.w);
        }
    }

    public static void show(Edge[] vec) {
        int i = 0;
        for (Edge edge : vec) {
            Point3 p1 = edge.p1;
            Point3 p2 = edge.p2;
            System.out.println("edgeNumber" + i++);
            System.out.println("point1:" + p1.x + "," + p1.y + " point:" + p2.x + "," + p2.y);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * In the main method, the frame and panels are created. And the
     * KeyListeners are added.
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        if (DEBUG) {
            System.out.println("Comenzando el programa...");
        }
        if (DEBUG) {
            System.out.println("Leyendo el archivo");
        }
        readFile();

        KeyListenerExample kle = new KeyListenerExample();

        // Create a new Frame
        JFrame frame = new JFrame("Ejemplo KeyListener");
        // Upon closing the frame, the application ends
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add a panel called DibujarCasita3D
        frame.add(kle);
        // Asignarle tamaño
        frame.setSize(KeyListenerExample.FRAME_WIDTH, KeyListenerExample.FRAME_HEIGHT);
        // Put the frame in the middle of the window
        frame.setLocationRelativeTo(null);
        // Show the frame
        frame.setVisible(true);
    }
}
