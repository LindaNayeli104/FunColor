import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyVentana extends JFrame{

	public MyVentana(){
		super("PIXELATED");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 800);

		MyPanelMenu pm = new MyPanelMenu();		
		this.add(pm);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true); 

	}


	public static void main(String[] args) {
		MyVentana mv = new MyVentana();

	}
}
