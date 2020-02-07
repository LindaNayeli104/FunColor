//Linda Nayeli Abundis Lopez A01636416
//Oscar Fernandez Moreno 	 A07013362


import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.text.*;
import javax.imageio.*;
import javax.sound.sampled.*;
import javax.swing.*;


public class MyVentana implements ActionListener{
	JFrame ventana;
	JPanel menu,ins,dibujo,controles,score,gameOver;
	private Backtracking btk;
	private JLabel[][] cuadros;
	private JButton btnRojo,
	btnMorado,
	btnNaranja,
	btnVerde,
	btnAzul,
	btnAmarillo,
	btnMenu,
	btnAtras,
	btnJuegoNuevo,
	btnComojugar,
	btnScores,
	btnAtrasScore,
	btnName;
	private JLabel lbNivel,
	lbNivelNum,
	lbScore,
	lbScoreNum,
	lbTurno,
	lbTurnoNum,
	lbTiempo,
	lbTiempoNum,
	lbTitulo,
	lbTexto;

	private JTextField tfName;

	private JLabel lbTituloScore,
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
	lbScore0,
	lbScore1 = new JLabel("0"),
	lbScore2 = new JLabel("0"),
	lbScore3 = new JLabel("0"),
	lbScore4 = new JLabel("0"),
	lbScore5 = new JLabel("0"),
	lbScore6 = new JLabel("0"),
	lbScore7 = new JLabel("0"),
	lbScore8 = new JLabel("0"),
	lbScore9 = new JLabel("0"),
	lbScore10 = new JLabel("0"),
	lbName,
	lbName1 = new JLabel("-"),
	lbName2 = new JLabel("-"),
	lbName3 = new JLabel("-"),
	lbName4 = new JLabel("-"),
	lbName5 = new JLabel("-"),
	lbName6 = new JLabel("-"),
	lbName7 = new JLabel("-"),
	lbName8 = new JLabel("-"),
	lbName9 = new JLabel("-"),
	lbName10 = new JLabel("-"),
	lbingresa,
	lbPuntajeFinal;

	private JRadioButton rbtnCentro = new JRadioButton(),
			rbtnEsquina = new JRadioButton();
	private byte milisegundos = 0;
	private byte segundos = 0;
	private short minutos = 10;
	private DecimalFormat formatoTiempo;
	private Timer timer;

	private String nombreJugador = "";
	private MyHeap heap = new MyHeap();
	private MyNodoHeap aux;
	private FileWriter fw = null;
	private BufferedWriter bw = null;
	private String[][] aux_before_file = new String[10][2];
	private Audio audio = new Audio();
	private AudioClip fondo = audio.getAudio("extra/fondo.wav");
	private AudioClip botton = audio.getAudio("extra/button.wav");
	private AudioClip color = audio.getAudio("extra/color.wav");
	private AudioClip cambio = audio.getAudio("extra/cambio.wav");
	private AudioClip perder = audio.getAudio("extra/perder.wav");
	private Image imgFondo, imgScore, imgOver, imgIns;
	public URL urlFondo, urlScore, urlOver, urlIns;
	

	//Frame Ventana___________________________________________________________________________________________________________________________________________________________
	public void crearVentana(){
		this.ventana = new JFrame("Fun Colors");
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.ventana.setSize(1000, 800);
		this.crearMenu();
		this.ventana.add(menu); 
		this.ventana.setLocationRelativeTo(null);
		this.ventana.setResizable(false);
		this.ventana.setVisible(true);
		this.fondo.loop();
	}



	//Panel Menu_______________________________________________________________________________________________________________________________________________________________
	public void crearMenu(){
		this.urlFondo = this.getClass().getResource("extra/fondo.jpg");
		imgFondo = new ImageIcon(urlFondo).getImage();
		this.menu = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(imgFondo,0,0,getWidth(), getHeight(),this);
				}
		};
		this.menu.setPreferredSize(new Dimension(1000,800));
		
		this.menu.setLayout(null);
		this.btnJuegoNuevo=new JButton("Juego Nuevo");
		this.btnJuegoNuevo.setBounds(350,500,300,60);
		this.btnJuegoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnJuegoNuevo.setFont(new Font("Helvetica", Font.PLAIN, 30));
		this.btnJuegoNuevo.addActionListener(this);

		this.btnComojugar=new JButton("Cómo Jugar");
		this.btnComojugar.setBounds(350,580,300,60);
		this.btnComojugar.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnComojugar.setFont(new Font("Helvetica", Font.PLAIN, 30));
		this.btnComojugar.addActionListener(this);

		this.btnScores=new JButton("Puntuaciones");
		this.btnScores.setBounds(350,660,300,60);
		this.btnScores.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnScores.setFont(new Font("Helvetica", Font.PLAIN, 30));
		this.btnScores.addActionListener(this);

		this.menu.add(this.btnJuegoNuevo);
		this.menu.add(this.btnComojugar);
		this.menu.add(this.btnScores);
		this.menu.setVisible(true);
	}


	//Panel Instrucciones___________________________________________________________________________________________________________________________________________________-
	public void crearIns(){
		this.urlIns = this.getClass().getResource("extra/como.jpg");
		this.imgIns = new ImageIcon(urlIns).getImage();
		this.ins = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(imgIns,0,0,getWidth(), getHeight(),this);
				}
		};
		this.ins.setPreferredSize(new Dimension(1000, 800));
		this.ins.setBackground(Color.decode("#80d5fc"));
		this.ins.setLayout(null);

		this.lbTitulo = new JLabel("Cómo jugar");
		this.lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTitulo.setFont(new Font("Helvetica", Font.PLAIN, 60));
		this.lbTitulo.setBounds(275,80,450,70);

		String texto = "<html><body>¡Un color es sufuciente! <br>  <br>Su objetivo es ordenar la<br> pantalla, dejando"
				+ " solo un color. <br>  <br>Expanda \"su idea\" a los píxeles vecinos, eligiendo el color"
				+ " de los píxeles que se capturarán.</body></html>";
		this.lbTexto = new JLabel(texto);

		this.lbTexto.setFont(new Font("Helvetica", Font.PLAIN, 40));
		this.lbTexto.setBounds(100,95,800,590);

		this.btnAtras=new JButton("Atrás");
		this.btnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnAtras.setFont(new Font("Helvetica", Font.PLAIN, 30));
		this.btnAtras.setBounds(400,695,200,50);
		this.btnAtras.addActionListener(this);

		this.ins.add(this.lbTitulo);
		this.ins.add(this.lbTexto);
		this.ins.add(this.btnAtras);
		this.ins.setVisible(false);
	}

	//Panel Dibujo __________________________________________________________________________________________________________________________________________
	public void crearDibujo(){
		this.dibujo = new JPanel();
		this.dibujo.setPreferredSize(new Dimension(1000, 800));
		this.btk = new Backtracking();
		this.btk.crearTablero();
		this.dibujo.setLayout(new GridLayout(14,14));
		this.cuadros=new JLabel[14][14];
		JLabel cuadro;
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
				this.dibujo.add(cuadro);
			}
		}
		this.dibujo.setVisible(false);
	}

	//Pinta Centros
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
		this.dibujo.repaint();
		this.ganador();

	}

	public void paintComponent(Graphics g) {


	}
	//Pinta Esquinas
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

		this.ganador();
	}

	//Pinta siguiente nivel
	public void siguienteNivel(){
		this.btk.crearTablero();
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
				this.cambio.play();
			}
		}
		this.dibujo.repaint();
		this.btk.imprimeTablero();
		System.out.println();
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

	//Ganador
	public void ganador(){
		if (this.btk.ganar()){
			this.siguienteNivel();
			if(this.getNivel() <= 3){
				this.btk.setMovimientos(50 - (this.getNivel()* 10));
			}else{
				this.btk.setMovimientos(20);
			}
			this.setNivel(this.getNivel() + 1);
		}

		if(this.getMovimientos() == 0){
			this.perdedor();
		}

	}

	//Perdedor
	public void perdedor(){
		this.dibujo.setVisible(false);
		this.controles.setVisible(false);
		this.crearGameOver();
		this.ventana.add(gameOver);
		this.gameOver.setVisible(true);
		this.perder.play();
	}


	//Panel Controles_______________________________________________________________________________________________________________________________________________________________
	public void crearControles(){
		this.controles = new JPanel();
		this.controles.setBackground(Color.WHITE);
		this.controles.setLayout(null);
		this.controles.setPreferredSize(new Dimension(240,800));
		//Boton Rojo
		this.btnRojo=new JButton();
		this.btnRojo.setOpaque(true);
		this.btnRojo.setBorderPainted(false);
		this.btnRojo.setBackground(Color.RED);
		this.btnRojo.setBounds(15,15,60,60);
		this.btnRojo.addActionListener(this);

		//Boton Morado
		this.btnMorado =new JButton();
		this.btnMorado.setOpaque(true);
		this.btnMorado.setBorderPainted(false);
		this.btnMorado.setBounds(90,15,60,60);
		this.btnMorado.setBackground(Color.decode("#a32ce8"));
		this.btnMorado.addActionListener(this);

		//Boton Rosa
		this.btnNaranja=new JButton();
		this.btnNaranja.setOpaque(true);
		this.btnNaranja.setBorderPainted(false);
		this.btnNaranja.setBounds(165,15,60,60);
		this.btnNaranja.setBackground(Color.decode("#ffa700"));
		this.btnNaranja.addActionListener(this);

		//Boton Verde
		this.btnVerde=new JButton();
		this.btnVerde.setOpaque(true);
		this.btnVerde.setBorderPainted(false);
		this.btnVerde.setBounds(15,90,60,60);
		this.btnVerde.setBackground(Color.decode("#63ff00"));
		this.btnVerde.addActionListener(this);

		//Boton Azul
		this.btnAzul=new JButton();
		this.btnAzul.setOpaque(true);
		this.btnAzul.setBorderPainted(false);
		this.btnAzul.setBounds(90,90,60,60);
		this.btnAzul.setBackground(Color.decode("#3ea3ff"));
		this.btnAzul.addActionListener(this);

		//Boton Amarillo
		this.btnAmarillo=new JButton();
		this.btnAmarillo.setOpaque(true);
		this.btnAmarillo.setBorderPainted(false);
		this.btnAmarillo.setBounds(165,90,60,60);
		this.btnAmarillo.setBackground(Color.decode("#eaff41"));
		this.btnAmarillo.addActionListener(this);

		//Niveles
		this.lbNivel = new JLabel("Nivel");
		this.lbNivel.setOpaque(true);
		this.lbNivel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbNivel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbNivel.setBounds(70,220,100,50);

		this.lbNivelNum = new JLabel("1");
		this.lbNivelNum.setOpaque(true);
		this.lbNivelNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbNivelNum.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbNivelNum.setBounds(70,290,100,50);

		//Score
		this.lbScore = new JLabel("Score");
		this.lbScore.setOpaque(true);
		this.lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbScore.setBounds(70,360,100,50);

		this.lbScoreNum = new JLabel("0");
		this.lbScoreNum.setOpaque(true);
		this.lbScoreNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScoreNum.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbScoreNum.setBounds(70,430,100,50);

		//Movimientos
		this.lbTurno = new JLabel("Turnos");
		this.lbTurno.setOpaque(true);
		this.lbTurno.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTurno.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbTurno.setBounds(70,500,100,50);

		this.lbTurnoNum = new JLabel(""+ this.getMovimientos());
		this.lbTurnoNum.setOpaque(true);
		this.lbTurnoNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTurnoNum.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbTurnoNum.setBounds(70,570,100,50);

		//Tiempo
		this.lbTiempo = new JLabel("Tiempo");
		this.lbTiempo.setOpaque(true);
		this.lbTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTiempo.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbTiempo.setBounds(70,640,100,50);

		this.lbTiempoNum = new JLabel();
		this.lbTiempoNum.setOpaque(true);
		this.lbTiempoNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTiempoNum.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.lbTiempoNum.setBounds(70,710,100,50);
		this.formatoTiempo = new DecimalFormat("00");

		//Boton Menu
		this.btnMenu=new JButton("<");
		this.btnMenu.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnMenu.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.btnMenu.setBounds(10,710,50,50);
		this.btnMenu.addActionListener(this);

		//Esquina o Centro
		this.rbtnCentro =new JRadioButton("Centro");
		this.rbtnCentro.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.rbtnCentro.setBounds(130,160,100,50);

		this.rbtnEsquina  = new JRadioButton("Esquina",true);
		this.rbtnEsquina.setFont(new Font("Helvetica", Font.PLAIN, 20));
		this.rbtnEsquina.setBounds(20,160,100,50);

		ButtonGroup grupoR = new ButtonGroup();
		grupoR.add(this.rbtnEsquina);
		grupoR.add(this.rbtnCentro);
		this.timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (milisegundos > 0) {
					milisegundos--;
				} else {
					if (segundos == 0 && minutos == 0) {
						timer.stop();
						perdedor();
					} else if (segundos > 0) {
						segundos--;
						milisegundos = 99;
					} else if (minutos > 0) {
						minutos--;
						segundos = 59;
						milisegundos = 99;
					}
				}
				lbTiempoNum.setText(formatoTiempo.format(minutos) + ":"+ formatoTiempo.format(segundos) + "."+ formatoTiempo.format(milisegundos));
			}
		});


		this.lbTiempoNum.setText(formatoTiempo.format(minutos) + ":"+ formatoTiempo.format(segundos) + "."+ formatoTiempo.format(milisegundos));


		//Add 
		controles.add(this.btnRojo);
		controles.add(this.btnMorado);
		controles.add(this.btnNaranja);
		controles.add(this.btnVerde);
		controles.add(this.btnAzul);
		controles.add(this.btnAmarillo);

		controles.add(this.lbNivel);
		controles.add(this.lbNivelNum);
		controles.add(this.lbScore);
		controles.add(this.lbScoreNum);
		controles.add(this.lbTurno);
		controles.add(this.lbTurnoNum);
		controles.add(this.lbTiempo);
		controles.add(this.lbTiempoNum);
		controles.add(this.btnMenu);
		controles.add(this.rbtnEsquina);
		controles.add(this.rbtnCentro);
		this.controles.setVisible(false);
	}


	//My Panel Score___________________________________________________________________________________________________________________________________________________
		public void crearScore(){
			this.urlScore = this.getClass().getResource("extra/score.jpg");
			this.imgScore = new ImageIcon(urlScore).getImage();
			this.score = new JPanel(){
					public void paintComponent(Graphics g){
						g.drawImage(imgScore,0,0,getWidth(), getHeight(),this);
					}
			};
			this.menu.setPreferredSize(new Dimension(1000,800));
			this.score.setLayout(null);
			this.score.setPreferredSize(new Dimension(1000, 800));

			this.lbTituloScore = new JLabel("Puntuaciones más altas");
			this.lbTituloScore.setForeground(Color.WHITE);
			this.lbTituloScore.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbTituloScore.setFont(new Font("arial", Font.PLAIN, 50));
			this.lbTituloScore.setBounds(200,50,600,60);

			this.lbRank = new JLabel("RANK"); 
			this.lbRank.setForeground(Color.WHITE);
			this.lbRank.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank.setFont(new Font("arial", Font.PLAIN, 30));
			this.lbRank.setBounds(175,135,120,60);

			this.lbRank1 = new JLabel("1ST");
			this.lbRank1.setForeground(Color.red);
			this.lbRank1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank1.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank1.setBounds(175,210,120,30);


			this.lbRank2 = new JLabel("2ND");
			this.lbRank2.setForeground(Color.ORANGE);
			this.lbRank2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank2.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank2.setBounds(175,250,120,30);

			this.lbRank3 = new JLabel("3RD");
			this.lbRank3.setForeground(Color.YELLOW);
			this.lbRank3.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank3.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank3.setBounds(175,290,120,30);

			this.lbRank4 = new JLabel("4TH");
			this.lbRank4.setForeground(Color.GREEN);
			this.lbRank4.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank4.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank4.setBounds(175,330,120,30);

			this.lbRank5 = new JLabel("5TH");
			this.lbRank5.setForeground(Color.decode("#006400"));
			this.lbRank5.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank5.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank5.setBounds(175,370,120,30);

			this.lbRank6 = new JLabel("6TH");
			this.lbRank6.setForeground(Color.CYAN);
			this.lbRank6.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank6.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank6.setBounds(175,410,120,30);


			this.lbRank7 = new JLabel("7TH");
			this.lbRank7.setForeground(Color.decode("#4169e1"));
			this.lbRank7.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank7.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank7.setBounds(175,450,120,30);


			this.lbRank8 = new JLabel("8TH");
			this.lbRank8.setForeground(Color.decode("#0000FF"));
			this.lbRank8.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank8.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank8.setBounds(175,490,120,30);

			this.lbRank9 = new JLabel("9TH");
			this.lbRank9.setForeground(Color.decode("#0000CD"));
			this.lbRank9.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank9.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank9.setBounds(175,530,120,30);

			this.lbRank10 = new JLabel("10TH");
			this.lbRank10.setForeground(Color.MAGENTA);
			this.lbRank10.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbRank10.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbRank10.setBounds(175,570,120,30);

			this.lbScore0 = new JLabel("SCORE");                              
			this.lbScore0.setForeground(Color.WHITE);
			this.lbScore0.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore0.setFont(new Font("arial", Font.PLAIN, 30));
			this.lbScore0.setBounds(450,135,120,60);                         

			this.lbScore1.setForeground(Color.red);
			this.lbScore1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore1.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore1.setBounds(450,210,120,30);

			this.lbName1.setForeground(Color.red);
			this.lbName1.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName1.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName1.setBounds(725,210,120,30);

			this.lbScore2.setForeground(Color.ORANGE);
			this.lbScore2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore2.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore2.setBounds(450,250,120,30);

			this.lbName2.setForeground(Color.ORANGE);
			this.lbName2.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName2.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName2.setBounds(725,250,120,30);

			this.lbScore3.setForeground(Color.YELLOW);
			this.lbScore3.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore3.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore3.setBounds(450,290,120,30);

			this.lbName3.setForeground(Color.YELLOW);
			this.lbName3.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName3.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName3.setBounds(725,290,120,30);

			this.lbScore4.setForeground(Color.GREEN);
			this.lbScore4.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore4.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore4.setBounds(450,330,120,30);

			this.lbName4.setForeground(Color.GREEN);
			this.lbName4.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName4.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName4.setBounds(725,330,120,30);
	 
			this.lbScore5.setForeground(Color.decode("#006400"));
			this.lbScore5.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore5.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore5.setBounds(450,370,120,30);

			this.lbName5.setForeground(Color.decode("#006400"));
			this.lbName5.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName5.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName5.setBounds(725,370,120,30);

			this.lbScore6.setForeground(Color.CYAN);
			this.lbScore6.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore6.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore6.setBounds(450,410,120,30);

			this.lbName6.setForeground(Color.CYAN);
			this.lbName6.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName6.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName6.setBounds(725,410,120,30);

			this.lbScore7.setForeground(Color.decode("#4169e1"));
			this.lbScore7.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore7.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore7.setBounds(450,450,120,30);

			this.lbName7.setForeground(Color.decode("#4169e1"));
			this.lbName7.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName7.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName7.setBounds(725,450,120,30);

			this.lbScore8.setForeground(Color.decode("#0000FF"));
			this.lbScore8.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore8.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore8.setBounds(450,490,120,30);

			this.lbName8.setForeground(Color.decode("#0000FF"));
			this.lbName8.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName8.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName8.setBounds(725,490,120,30);


			this.lbScore9.setForeground(Color.decode("#0000CD"));
			this.lbScore9.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore9.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore9.setBounds(450,530,120,30);


			this.lbName9.setForeground(Color.decode("#0000CD"));
			this.lbName9.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName9.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName9.setBounds(725,530,120,30);

			this.lbScore10.setForeground(Color.MAGENTA);
			this.lbScore10.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbScore10.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbScore10.setBounds(450,570,120,30);

			this.lbName10.setForeground(Color.MAGENTA);
			this.lbName10.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName10.setFont(new Font("arial", Font.PLAIN, 20));
			this.lbName10.setBounds(725,570,120,30);



			this.lbName = new JLabel("NAME");
			this.lbName.setForeground(Color.WHITE);
			this.lbName.setHorizontalAlignment(SwingConstants.CENTER);
			this.lbName.setFont(new Font("arial", Font.PLAIN, 30));
			this.lbName.setBounds(725,135,120,60);                              

			this.btnAtrasScore=new JButton("Atrás");
			this.btnAtrasScore.setHorizontalAlignment(SwingConstants.CENTER);
			this.btnAtrasScore.setFont(new Font("arial", Font.PLAIN, 30));
			this.btnAtrasScore.setBounds(400,660,200,50);
			this.btnAtrasScore.addActionListener(this);

			this.score.add(this.lbTituloScore);
			this.score.add(this.lbRank);
			this.score.add(this.lbRank1);
			this.score.add(this.lbRank2);
			this.score.add(this.lbRank3);
			this.score.add(this.lbRank4);
			this.score.add(this.lbRank5);
			this.score.add(this.lbRank6);
			this.score.add(this.lbRank7);
			this.score.add(this.lbRank8);
			this.score.add(this.lbRank9);
			this.score.add(this.lbRank10);

			this.score.add(this.lbScore0);
			this.score.add(this.lbScore1);
			this.score.add(this.lbScore2);
			this.score.add(this.lbScore3);
			this.score.add(this.lbScore4);
			this.score.add(this.lbScore5);
			this.score.add(this.lbScore6);
			this.score.add(this.lbScore7);
			this.score.add(this.lbScore8);
			this.score.add(this.lbScore9);
			this.score.add(this.lbScore10);

			this.score.add(this.lbName);
			this.score.add(this.lbName1);
			this.score.add(this.lbName2);
			this.score.add(this.lbName3);
			this.score.add(this.lbName4);
			this.score.add(this.lbName5);
			this.score.add(this.lbName6);
			this.score.add(this.lbName7);
			this.score.add(this.lbName8);
			this.score.add(this.lbName9);
			this.score.add(this.lbName10);
			this.score.add(this.btnAtrasScore);
			this.score.setVisible(false);
		}


		public void leerArchivo() {
			try {	
				File newFile = new File("Datos.txt");
				FileReader fr = new FileReader(newFile);   
				BufferedReader br = new BufferedReader(fr);
				String[] auxArray = new String[2];

				for(int i=0; i<11; i++) {
					String linea = br.readLine();
					if(linea !=null) {
						auxArray = linea.split(",");
						//System.out.println("Leer " + auxArray[0] + "," + auxArray[1]);
						MyNodoHeap nodo = new MyNodoHeap(Integer.parseInt(auxArray[0]), auxArray[1]);
						this.heap.push(nodo);
					}
					

			}
		}catch(Exception err){
		}
	}

		public void escribirEnArchivo() {
			try {
				this.fw = new FileWriter("Datos.txt");
				this.bw = new BufferedWriter(fw);
				for (int i = 0; i < 10; i++) {
					//System.out.println("Escribir "+this.aux_before_file[i][0] +"," + this.aux_before_file[i][1] );
					bw.write(this.aux_before_file[i][0] +"," + this.aux_before_file[i][1] );
					bw.write("\n");
				}
			}catch(Exception err){
			}
		}

		//SetScores
		public void setScoresLoser(){
			MyNodoHeap nodo = new MyNodoHeap(this.btk.getPuntos(), this.nombreJugador);
			this.heap.push(nodo);
			this.leerArchivo();
		}
		public void setScores() {
			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName1.setText(this.aux.name);
				this.lbScore1.setText(Integer.toString(this.aux.score));
				aux_before_file[0][0] = Integer.toString(this.aux.score);
				aux_before_file[0][1] = this.aux.name;

			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName2.setText(this.aux.name);
				this.lbScore2.setText(Integer.toString(this.aux.score));
				aux_before_file[1][0] = Integer.toString(this.aux.score);
				aux_before_file[1][1] = this.aux.name;

			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName3.setText(aux.name);
				this.lbScore3.setText(Integer.toString(aux.score));
				aux_before_file[2][0] = Integer.toString(aux.score);
				aux_before_file[2][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName4.setText(aux.name);
				this.lbScore4.setText(Integer.toString(aux.score));
				aux_before_file[3][0] = Integer.toString(aux.score);
				aux_before_file[3][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName5.setText(aux.name);
				this.lbScore5.setText(Integer.toString(aux.score));
				aux_before_file[4][0] = Integer.toString(aux.score);
				aux_before_file[4][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName6.setText(aux.name);
				this.lbScore6.setText(Integer.toString(aux.score));
				aux_before_file[5][0] = Integer.toString(aux.score);
				aux_before_file[5][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName7.setText(aux.name);
				this.lbScore7.setText(Integer.toString(aux.score));
				aux_before_file[6][0] = Integer.toString(aux.score);
				aux_before_file[6][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName8.setText(aux.name);
				this.lbScore8.setText(Integer.toString(aux.score));
				aux_before_file[7][0] = Integer.toString(aux.score);
				aux_before_file[7][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName9.setText(aux.name);
				this.lbScore9.setText(Integer.toString(aux.score));
				aux_before_file[8][0] = Integer.toString(aux.score);
				aux_before_file[8][1] = aux.name;
			}

			this.aux = heap.pop();
			if(this.aux != null) {
				this.lbName10.setText(aux.name);
				this.lbScore10.setText(Integer.toString(aux.score));
				aux_before_file[9][0] = Integer.toString(aux.score);
				aux_before_file[9][1] = aux.name;
			}
			this.escribirEnArchivo();
			try {
				bw.close();
				fw.close();
			}catch(IOException e) {

			}
		}



	//My Panel Game Over____________________________________________________________________________________________________________________________________________________

	public void crearGameOver(){
		this.urlOver = this.getClass().getResource("extra/over.png");
		this.imgOver = new ImageIcon(urlOver).getImage();
		this.gameOver = new JPanel(){
				public void paintComponent(Graphics g){
					g.drawImage(imgOver,0,0,getWidth(), getHeight(),this);
				}
		};
		this.gameOver.setLayout(null);
		this.gameOver.setPreferredSize(new Dimension(1000, 800));
		this.gameOver.setBackground(Color.decode("#80d5fc"));

		this.lbingresa = new JLabel("Ingrese un nombre");
		this.lbingresa.setForeground(Color.WHITE);
		this.lbingresa.setFont(new Font("Helvetica", Font.PLAIN, 30));
		this.lbingresa.setBounds(390,500,600,60);

		this.tfName = new JTextField();
		this.tfName.setBounds(410,570,110,50);

		this.btnName=new JButton("¡Listo!");
		this.btnName.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnName.setFont(new Font("Helvetica", Font.PLAIN, 15));
		this.btnName.setBounds(530,570,90,50);
		this.btnName.addActionListener(this);

		this.lbPuntajeFinal = new JLabel(this.btk.getPuntos() + " puntos");
		this.lbPuntajeFinal.setForeground(Color.WHITE);
		this.lbPuntajeFinal.setFont(new Font("Helvetica", Font.PLAIN, 50));
		this.lbPuntajeFinal.setBounds(380,650,600,60);

		this.gameOver.add(btnName);
		this.gameOver.add(tfName);
		this.gameOver.add(lbingresa);
		this.gameOver.add(lbPuntajeFinal);
		this.gameOver.setVisible(false);

	}
	//Main ______________________________________________________________________________________________________________________________________________________________
	public static void main(String[] args) {
		MyVentana v = new MyVentana();
		v.crearVentana();
	}

	//Action Listener _____________________________________________________________________________________________________________________________________________________________
	public void actionPerformed(ActionEvent e) {

		//Menu
		if(e.getSource() == this.btnMenu){
			this.dibujo.setVisible(false);
			this.botton.play();
			this.controles.setVisible(false);
			this.menu.setVisible(true);
			this.timer.stop();
			this.milisegundos = 0;
			this.segundos = 0;
			this.minutos = 10;
			this.lbTiempoNum.setText(formatoTiempo.format(minutos) + ":"+ formatoTiempo.format(segundos) + "."+ formatoTiempo.format(milisegundos));
		}

		//Como jugar
		if(e.getSource() == this.btnComojugar){
			this.menu.setVisible(false);
			this.botton.play();
			this.crearIns();
			ventana.add(this.ins);
			this.ins.setVisible(true);
		}

		//Boton atras de como jugar
		if(e.getSource() == this.btnAtras){
			this.ins.setVisible(false);
			this.botton.play();
			this.menu.setVisible(true);
		}

		//Score
		if(e.getSource() == this.btnScores){
			this.botton.play();
			this.menu.setVisible(false);
			this.leerArchivo();
			this.setScores();
			this.crearScore();
			this.ventana.add(this.score);
			this.score.setVisible(true);
		}

		//Score
		if(e.getSource() == this.btnAtrasScore){

			this.menu.setVisible(true);
			this.botton.play();
			this.score.setVisible(false);
		}

		//Juego nuevo
		if(e.getSource() == this.btnJuegoNuevo){
			this.botton.play();
			this.menu.setVisible(false);
			this.crearDibujo();
			this.crearControles();
			this.ventana.add(dibujo);
			this.ventana.add(controles, BorderLayout.WEST);
			this.dibujo.setVisible(true);
			this.controles.setVisible(true);
		}

		//Game Over
		if(e.getSource() == this.btnName){
			this.botton.play();
			this.gameOver.setVisible(false);
			this.nombreJugador = this.tfName.getText();
			this.setScoresLoser();
			this.setScores();
			this.crearScore();
			this.ventana.add(this.score);
			this.score.setVisible(true);
			this.timer.stop();
			this.milisegundos = 0;
			this.segundos = 0;
			this.minutos = 10;
			this.lbTiempoNum.setText(formatoTiempo.format(minutos) + ":"+ formatoTiempo.format(segundos) + "."+ formatoTiempo.format(milisegundos));
		
		}


		if(this.rbtnCentro.isSelected()){
			if(e.getSource() == this.btnRojo){
				this.color.play();
				this.pintarCentros(1);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
			if(e.getSource() == this.btnMorado){
				this.color.play();
				this.pintarCentros(2);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnNaranja){
				this.color.play();
				this.pintarCentros(3);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnVerde){
				this.color.play();
				this.pintarCentros(4);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAzul){
				this.color.play();
				this.pintarCentros(5);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAmarillo){
				this.color.play();
				this.pintarCentros(6);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
		}else{
			if(e.getSource() == this.btnRojo){
				this.pintarEsquinas(1);
				this.color.play();
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
			if(e.getSource() == this.btnMorado){
				this.pintarEsquinas(2);
				this.color.play();
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnNaranja){
				this.pintarEsquinas(3);
				this.color.play();
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnVerde){
				this.pintarEsquinas(4);
				this.color.play();
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAzul){
				this.pintarEsquinas(5);
				this.color.play();
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAmarillo){
				this.pintarEsquinas(6);
				this.color.play();
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
		}
	}
}

