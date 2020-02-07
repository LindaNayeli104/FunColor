import java.awt.Dimension;
    import javax.swing.*;
    public class Yo extends JFrame {
      public static void main(String[] args) {
          JFrame frame = new JFrame("main");
           frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
          frame.add(new JLabel(new ImageIcon("fondo.jpeg")));
          frame. setSize(1000, 700);
    frame.setVisible(true);
      }
    }