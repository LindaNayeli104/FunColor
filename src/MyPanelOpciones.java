import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyPanelOpciones extends JPanel implements ActionListener{
	
	private JButton btnCentro,
					btnEsquina,
					btnAtras;
	

	private JLabel lbPos,
				   lbOpciones;
	
	private JRadioButton rbtnCentro,
						rbtnEsquina;
	
	//private MyVentanaMenu fm;
	
	public MyPanelOpciones(){
		super();
		//this.fm = fm;
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.PINK);
		this.setLayout(null);
		
		
		this.lbOpciones = new JLabel("Opciones");
		this.lbOpciones.setOpaque(true);
		this.lbOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbOpciones.setFont(new Font("arial", Font.PLAIN, 50));
		this.lbOpciones.setBounds(350,25,300,60);
		
		
		this.lbPos = new JLabel("Elige d�nde comenzar");
		this.lbPos.setOpaque(true);
		this.lbPos.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbPos.setFont(new Font("arial", Font.PLAIN, 50));
		this.lbPos.setBounds(250,155,500,55);
		
		this.rbtnCentro =new JRadioButton("Centro",false);
		this.rbtnCentro.setFont(new Font("arial", Font.PLAIN, 50));
		this.rbtnCentro.setBounds(500,240,210,50);
		
		this.rbtnEsquina  = new JRadioButton("Esquina",false);
		this.rbtnEsquina.setFont(new Font("arial", Font.PLAIN, 50));
		this.rbtnEsquina.setBounds(290,240,210,50);
		
		ButtonGroup grupoR = new ButtonGroup();
		grupoR.add(this.rbtnEsquina);
		grupoR.add(this.rbtnCentro);
		
		this.btnAtras=new JButton("Atr�s");
		this.btnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnAtras.setFont(new Font("arial", Font.PLAIN, 50));
		this.btnAtras.setBounds(400,340,200,50);
		this.btnAtras.setBackground(Color.RED);
		this.btnAtras.addActionListener(this);
		
		this.add(this.lbOpciones);
		this.add(this.lbPos);
		this.add(this.rbtnEsquina);
		this.add(this.rbtnCentro);
		this.add(this.btnAtras);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAtras) {
			MyVentanaMenu fm = new MyVentanaMenu();
			fm.setVisible(true);
			this.setVisible(false);
		}
		
	}



}