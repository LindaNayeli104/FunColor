import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.*;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;

public class MyPanelDibujo extends JPanel implements Runnable, MouseListener, MouseMotionListener {
	private Backtracking btk;
	private JLabel gano;
	private JLabel[][] cuadros;

	Hashtable<Integer, Integer> ht = new Hashtable<>();

	public MyPanelDibujo(){
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(new Dimension(1000, 800));
		this.btk = new Backtracking();
		this.btk.crearTablero();
		this.setLayout(new GridLayout(14,14));
		this.cuadros=new JLabel[14][14];
		JLabel cuadro;

		ht.put(1, 0);
		ht.put(2, 0);
		ht.put(3, 0);
		ht.put(4, 0);
		ht.put(5, 0);
		ht.put(6, 0);
		ht.put(7, 0);
		ht.put(8, 0);
		ht.put(9, 0);
		ht.put(10,0);


		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				cuadro = new JLabel();
				this.cuadros[i][j]=cuadro;
				cuadro.setOpaque(true);
				if(color == 1){
					cuadro.setBackground(Color.decode("#ff2700"));

				}else if(color == 2){
					cuadro.setBackground(Color.decode("#a32ce8"));

				}else if(color == 3){
					cuadro.setBackground(Color.decode("#ffa700"));

				}else if(color == 4){
					cuadro.setBackground(Color.decode("#63ff00"));

				}else if(color == 5){
					cuadro.setBackground(Color.decode("#3ea3ff"));

				}else if(color == 6){
					cuadro.setBackground(Color.decode("#eaff41"));

				}
				this.add(cuadro);
			}
		}

	}

	//Getters y Setters

	public int getPuntos(){
		return this.btk.getPuntos();
	}

	public int getMovimientos(){
		return this.btk.getMovimientos();
	}

	public int getNivel(){
		return this.btk.getNivel();
	}

	public void setNivel(int nivel){
		this.btk.setNivel(nivel);
	}
	//Actualiza Tablero Centros
	public void pintarCentros(int nuevoColor){
		this.btk.pintaTableroCentro(this.btk.matriz, nuevoColor);
		this.btk.setMovimientos(this.btk.getMovimientos()-1);
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				if(color == 1){
					this.cuadros[i][j].setBackground(Color.decode("#ff2700"));

				}else if(color == 2){
					this.cuadros[i][j].setBackground(Color.decode("#a32ce8"));

				}else if(color == 3){
					this.cuadros[i][j].setBackground(Color.decode("#ffa700"));

				}else if(color == 4){
					this.cuadros[i][j].setBackground(Color.decode("#63ff00"));

				}else if(color == 5){
					this.cuadros[i][j].setBackground(Color.decode("#3ea3ff"));

				}else if(color == 6){
					this.cuadros[i][j].setBackground(Color.decode("#eaff41"));

				}
			}
		}
		this.repaint();
		this.btk.imprimeTablero();
		System.out.println();
	}

	public void pintarEsquinas(int nuevoColor){
		this.btk.pintaTableroEsquina(this.btk.matriz, nuevoColor);
		this.btk.setMovimientos(this.btk.getMovimientos()-1);
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				if(color == 1){
					this.cuadros[i][j].setBackground(Color.decode("#ff2700"));

				}else if(color == 2){
					this.cuadros[i][j].setBackground(Color.decode("#a32ce8"));

				}else if(color == 3){
					this.cuadros[i][j].setBackground(Color.decode("#ffa700"));

				}else if(color == 4){
					this.cuadros[i][j].setBackground(Color.decode("#63ff00"));

				}else if(color == 5){
					this.cuadros[i][j].setBackground(Color.decode("#3ea3ff"));

				}else if(color == 6){
					this.cuadros[i][j].setBackground(Color.decode("#eaff41"));

				}
			}
		}
		this.repaint();
		this.btk.imprimeTablero();
		System.out.println();
	}

	//Ganador
	public void ganador(){
		if (this.btk.ganar()){
			System.out.println("ERES UN GANADOR");
			//this.pintaColores();
			this.btk.setMovimientos(50 - (this.getNivel()* 10));
			this.setNivel(this.getNivel() + 1);

		}
	}

	//Perdedor
	public void perdedor(){//this.btk.getPuntos()
		if(this.btk.getMovimientos() == 0){ 
			System.out.println("-ERES UN PERDEDOR");
			int score = ht.get(1);
			int aux = 0;
			int pos = 10;
			boolean bandera = false;
			for (int i = 1; i < 11; i++) {
				if(this.btk.getPuntos() < score) {
					score = ht.get(i+1);
				}else {
					ht.put(i, this.btk.getPuntos());
					pos = i;
					bandera = true;
					break;
				}
			}
			if(bandera) {
				for (int j = pos+1 ; j < 11; j++) {
					aux = ht.get(j);
					ht.put(j, score);
					score = aux;
					
				}
			}

			for (int i = 1; i < 11; i++) {
				System.out.println(i + "=" + ht.get(i));
			}

		}



	// mOuse listener
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {

	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {


	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {


	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {


	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {


	}


	//Mouse Motion listener
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {

	}


	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}