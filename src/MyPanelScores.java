import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;

import javax.swing.*;

public class MyPanelScores extends JPanel implements ActionListener{
	
	private JButton btnAtras;
	private JLabel lbTitulo,
	lbRank,
	lbRank1,
	lbRank2,
	lbRank3,
	lbRank4,
	lbRank5,
	lbRank6,
	lbRank7,
	lbRank8,
	lbRank9,
	lbRank10,
	lbScore,
	lbScore1,
	lbScore2,
	lbScore3,
	lbScore4,
	lbScore5,
	lbScore6,
	lbScore7,
	lbScore8,
	lbScore9,
	lbScore10,
	lbName,
	lbName1,
	lbName2,
	lbName3,
	lbName4,
	lbName5,
	lbName6,
	lbName7,
	lbName8,
	lbName9,
	lbName10;
	
	
	private JLabel[] arregloLbRank = new JLabel[30];
	//private JLabel[] arregloLbScore = new JLabel[10];
	//private JLabel[] arregloLbName = new JLabel[10];
	
	//Hashtable<Integer, Integer> ht = new Hashtable<>();
	
	
	public MyPanelScores(){
		super();
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.PINK);
		this.setLayout(null);
		
		
		this.lbTitulo = new JLabel("Puntuaciones más altas");
		this.lbTitulo.setOpaque(true);
		this.lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTitulo.setFont(new Font("arial", Font.PLAIN, 50));
		this.lbTitulo.setBounds(200,50,600,60);
	
//-----------------------------------------------------------------------------------------
		this.lbRank = new JLabel("RANK");                                       //--
		this.lbRank.setOpaque(true);
		this.lbRank.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank.setFont(new Font("arial", Font.PLAIN, 30));
		this.lbRank.setBounds(175,135,120,60);

		this.lbRank1 = new JLabel("1ST");
		this.lbRank1.setOpaque(true);
		this.lbRank1.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank1.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank1.setBounds(175,210,120,30);


		this.lbRank2 = new JLabel("2ND");
		this.lbRank2.setOpaque(true);
		this.lbRank2.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank2.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank2.setBounds(175,250,120,30);


		this.lbRank3 = new JLabel("3RD");
		this.lbRank3.setOpaque(true);
		this.lbRank3.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank3.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank3.setBounds(175,290,120,30);


		this.lbRank4 = new JLabel("4TH");
		this.lbRank4.setOpaque(true);
		this.lbRank4.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank4.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank4.setBounds(175,330,120,30);


		this.lbRank5 = new JLabel("5TH");
		this.lbRank5.setOpaque(true);
		this.lbRank5.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank5.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank5.setBounds(175,370,120,30);

		this.lbRank6 = new JLabel("6TH");
		this.lbRank6.setOpaque(true);
		this.lbRank6.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank6.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank6.setBounds(175,410,120,30);


		this.lbRank7 = new JLabel("7TH");
		this.lbRank7.setOpaque(true);
		this.lbRank7.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank7.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank7.setBounds(175,450,120,30);


		this.lbRank8 = new JLabel("8TH");
		this.lbRank8.setOpaque(true);
		this.lbRank8.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank8.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank8.setBounds(175,490,120,30);


		this.lbRank9 = new JLabel("9TH");
		this.lbRank9.setOpaque(true);
		this.lbRank9.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank9.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank9.setBounds(175,530,120,30);

		this.lbRank10 = new JLabel("10TH");
		this.lbRank10.setOpaque(true);
		this.lbRank10.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbRank10.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbRank10.setBounds(175,570,120,30);

		this.lbScore = new JLabel("SCORE");                              
		this.lbScore.setOpaque(true);
		this.lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore.setFont(new Font("arial", Font.PLAIN, 30));
		this.lbScore.setBounds(450,135,120,60);                          //--

		this.lbScore1 = new JLabel("9000"); //Integer.toString(ht.get(1))
		this.lbScore1.setOpaque(true);
		this.lbScore1.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore1.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore1.setBounds(450,210,120,30);

		this.lbScore2 = new JLabel("8000");
		this.lbScore2.setOpaque(true);
		this.lbScore2.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore2.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore2.setBounds(450,250,120,30);

		this.lbScore3 = new JLabel("7000");
		this.lbScore3.setOpaque(true);
		this.lbScore3.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore3.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore3.setBounds(450,290,120,30);

		this.lbScore4 = new JLabel("6000");
		this.lbScore4.setOpaque(true);
		this.lbScore4.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore4.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore4.setBounds(450,330,120,30);

		this.lbScore5 = new JLabel("5000");
		this.lbScore5.setOpaque(true);
		this.lbScore5.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore5.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore5.setBounds(450,370,120,30);

		this.lbScore6 = new JLabel("4000");
		this.lbScore6.setOpaque(true);
		this.lbScore6.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore6.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore6.setBounds(450,410,120,30);

		this.lbScore7 = new JLabel("3000");
		this.lbScore7.setOpaque(true);
		this.lbScore7.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore7.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore7.setBounds(450,450,120,30);

		this.lbScore8 = new JLabel("2000");
		this.lbScore8.setOpaque(true);
		this.lbScore8.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore8.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore8.setBounds(450,490,120,30);

		this.lbScore9 = new JLabel("1000");
		this.lbScore9.setOpaque(true);
		this.lbScore9.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore9.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore9.setBounds(450,530,120,30);

		this.lbScore10 = new JLabel("500");
		this.lbScore10.setOpaque(true);
		this.lbScore10.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore10.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore10.setBounds(450,570,120,30);

		this.lbName = new JLabel("NAME");
		this.lbName.setOpaque(true);
		this.lbName.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName.setFont(new Font("arial", Font.PLAIN, 30));
		this.lbName.setBounds(725,135,120,60);                              //--

		this.lbName1 = new JLabel("OSCAR");
		this.lbName1.setOpaque(true);
		this.lbName1.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName1.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName1.setBounds(725,210,120,30);

		this.lbName2 = new JLabel("ALMA");
		this.lbName2.setOpaque(true);
		this.lbName2.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName2.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName2.setBounds(725,250,120,30);

		this.lbName3 = new JLabel("RICK");
		this.lbName3.setOpaque(true);
		this.lbName3.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName3.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName3.setBounds(725,290,120,30);

		this.lbName4 = new JLabel("RAUL");
		this.lbName4.setOpaque(true);
		this.lbName4.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName4.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName4.setBounds(725,330,120,30);

		this.lbName5 = new JLabel("MONSE");
		this.lbName5.setOpaque(true);
		this.lbName5.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName5.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName5.setBounds(725,370,120,30);

		this.lbName6 = new JLabel("PINKY");
		this.lbName6.setOpaque(true);
		this.lbName6.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName6.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName6.setBounds(725,410,120,30);

		this.lbName7 = new JLabel("VALEN");
		this.lbName7.setOpaque(true);
		this.lbName7.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName7.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName7.setBounds(725,450,120,30);

		this.lbName8 = new JLabel("CANDY");
		this.lbName8.setOpaque(true);
		this.lbName8.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName8.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName8.setBounds(725,490,120,30);

		this.lbName9 = new JLabel("MARIA");
		this.lbName9.setOpaque(true);
		this.lbName9.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName9.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName9.setBounds(725,530,120,30);

		this.lbName10 = new JLabel("OSCAF");
		this.lbName10.setOpaque(true);
		this.lbName10.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbName10.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbName10.setBounds(725,570,120,30);

		//-----------------------------------------------------------------------------------------

		this.btnAtras=new JButton("Atrás");
		this.btnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnAtras.setFont(new Font("arial", Font.PLAIN, 50));
		this.btnAtras.setBounds(400,660,200,50);
		this.btnAtras.setBackground(Color.RED);
		this.btnAtras.addActionListener(this);

		this.add(this.lbTitulo);
		
		this.add(this.lbRank);
		this.add(this.lbRank1);
		this.add(this.lbRank2);
		this.add(this.lbRank3);
		this.add(this.lbRank4);
		this.add(this.lbRank5);
		this.add(this.lbRank6);
		this.add(this.lbRank7);
		this.add(this.lbRank8);
		this.add(this.lbRank9);
		this.add(this.lbRank10);
		
		this.add(this.lbScore);
		this.add(this.lbScore1);
		this.add(this.lbScore2);
		this.add(this.lbScore3);
		this.add(this.lbScore4);
		this.add(this.lbScore5);
		this.add(this.lbScore6);
		this.add(this.lbScore7);
		this.add(this.lbScore8);
		this.add(this.lbScore9);
		this.add(this.lbScore10);
		
		this.add(this.lbName);
		this.add(this.lbName1);
		this.add(this.lbName2);
		this.add(this.lbName3);
		this.add(this.lbName4);
		this.add(this.lbName5);
		this.add(this.lbName6);
		this.add(this.lbName7);
		this.add(this.lbName8);
		this.add(this.lbName9);
		this.add(this.lbName10);
		
		this.add(this.btnAtras);
//-----------------------------------------------------------------------------------------
	
		
		
		
		
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




