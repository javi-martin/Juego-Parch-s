package es.studium.Parchis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Tablero extends Frame implements WindowListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	
	// Declarar el objeto Image
	Image imagen, imagen2;
	// Declarar el objeto Toolkit para manejo de imágenes
	Toolkit herramienta;
	
	int turno = 1; // 0 Rojas, 1 Verder, 2 Amarillo, 3 Azul
	
	int[] celdas = new int[68]; // Celdas del tablero
	String[] posiciones = new String[68];	
	int[] posicionesRojas = new int[4]; // -1, -1, -1, -1 --> -1, -1, 3, 56
	String[] posicionesCeldasRojas = new String[8];
	int[] posicionesAzules = {-1,-1,-1,-1};
	String[] posicionesCeldasAzules = new String[8];
	int[] posicionesVerdes = {-1,-1,-1,-1};;
	String[] posicionesCeldasVerdes = new String[8];
	int[] posicionesAmarillas = new int[4];
	String[] posicionesCeldasAmarillas = new String[8];
	
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las coordenadas del Dado
	int dadoX=840, dadoY=110;
	
	// Las coordenadas donde mover fichas
	int posX, posY;
	int posVerdeX, posVerdeY;
	
	String resultadoDado = "";//Resultado del tirada de dados
	String queTurno = "";
	
	int auxAzul = -1;//Auxiliar para subir tabla de posicionesCeldasColor
	int auxVerde = -1;	
	
	
	public Tablero() 
	{
		posiciones[0] = "457,758";
		posiciones[1] = "457,724";
		posiciones[2] = "457,686";
		posiciones[3] = "457,652";
		posiciones[4] = "457,619";
		posiciones[5] = "457,583";
		posiciones[6] = "457,550";
		posiciones[7] = "457,514";
		posiciones[8] = "480,478";
		posiciones[9] = "517,492";
		posiciones[10] = "550,492";
		posiciones[11] = "584,492";
		posiciones[12] = "620,492";
		posiciones[13] = "653,492";
		posiciones[14] = "689,492";
		posiciones[15] = "724,492";
		posiciones[16] = "724,410";
		posiciones[17] = "724,330";
		posiciones[18] = "687,330";
		posiciones[19] = "653,330";
		posiciones[20] = "618,330";
		posiciones[21] = "586,330";
		posiciones[22] = "549,330";
		posiciones[23] = "515,330";
		posiciones[24] = "480,330";		
		posiciones[25] = "457,304";
		posiciones[26] = "457,271";
		posiciones[27] = "457,235";
		posiciones[28] = "457,202";
		posiciones[29] = "457,169";
		posiciones[30] = "457,136";
		posiciones[31] = "457,103";
		posiciones[32] = "457,70";
		posiciones[33] = "377,63";
		posiciones[34] = "296,63";
		posiciones[35] = "296,100";
		posiciones[36] = "296,134";
		posiciones[37] = "296,167";
		posiciones[38] = "296,202";
		posiciones[39] = "296,238";
		posiciones[40] = "296,272";
		posiciones[41] = "296,307";
		posiciones[42] = "270,330";
		posiciones[43] = "237,330";
		posiciones[44] = "203,330";
		posiciones[45] = "167,330";
		posiciones[46] = "133,330";
		posiciones[47] = "98,330";
		posiciones[48] = "64,330";
		posiciones[49] = "28,330";
		posiciones[50] = "28,410";
		posiciones[51] = "28,490";
		posiciones[52] = "64,490";
		posiciones[53] = "98,490";
		posiciones[54] = "133,490";
		posiciones[55] = "166,490";
		posiciones[56] = "203,490";
		posiciones[57] = "237,490";
		posiciones[58] = "270,490";
		posiciones[59] = "296,515";
		posiciones[60] = "296,551";
		posiciones[61] = "296,585";
		posiciones[62] = "296,619";
		posiciones[63] = "296,655";
		posiciones[64] = "296,690";
		posiciones[65] = "296,722";
		posiciones[66] = "296,760";
		posiciones[67] = "377,760";
		
		posicionesCeldasRojas[0] = "377,96";
		posicionesCeldasRojas[1] = "377,132";
		posicionesCeldasRojas[2] = "377,168";
		posicionesCeldasRojas[3] = "377,202";
		posicionesCeldasRojas[4] = "377,238";
		posicionesCeldasRojas[5] = "377,269";
		posicionesCeldasRojas[6] = "377,307";
		posicionesCeldasRojas[7] = "377,356";
		
		posicionesCeldasAzules[0] = "686,410";
		posicionesCeldasAzules[1] = "653,410";
		posicionesCeldasAzules[2] = "620,410";
		posicionesCeldasAzules[3] = "584,410";
		posicionesCeldasAzules[4] = "548,410";
		posicionesCeldasAzules[5] = "514,410";
		posicionesCeldasAzules[6] = "479,410";
		posicionesCeldasAzules[7] = "424,410";
		
		posicionesCeldasVerdes[0] = "64,410";
		posicionesCeldasVerdes[1] = "97,410";
		posicionesCeldasVerdes[2] = "131,410";
		posicionesCeldasVerdes[3] = "166,410";
		posicionesCeldasVerdes[4] = "202,410";
		posicionesCeldasVerdes[5] = "235,410";
		posicionesCeldasVerdes[6] = "271,410";
		posicionesCeldasVerdes[7] = "327,410";
		
		posicionesCeldasAmarillas[0] = "377,725";
		posicionesCeldasAmarillas[1] = "377,689";
		posicionesCeldasAmarillas[2] = "377,654";
		posicionesCeldasAmarillas[3] = "377,618";
		posicionesCeldasAmarillas[4] = "377,584";
		posicionesCeldasAmarillas[5] = "377,550";
		posicionesCeldasAmarillas[6] = "377,514";
		posicionesCeldasAmarillas[7] = "377,458";
		
		String pocicionInicialAzul = "619,163";
		String inicialAzul [] = pocicionInicialAzul.split(",");
		posX = Integer.parseInt(inicialAzul[0]);
		posY = Integer.parseInt(inicialAzul[1]);
		
		String pocicionInicialVerde = "136,659";
		String inicialVerde [] = pocicionInicialVerde.split(",");
		posVerdeX = Integer.parseInt(inicialVerde[0]);
		posVerdeY = Integer.parseInt(inicialVerde[1]);		
		
		setTitle("Tablero");	
		setSize(1250,800);
		setResizable(true);
		addWindowListener(this);
		
		addMouseListener(this);//Para obtener coordenadas
		
		// Establecer el método de trabajo con imágenes
		herramienta = getToolkit();
		// Especificar la ruta de la imagen	
		// Si ponemos ruta OJO con los \\
		imagen = herramienta.getImage("Parchis2.jpg");
		imagen2 = herramienta.getImage("dado.jpg");		
		setVisible(true);	
	}
	
	public void paint(Graphics g)
	{
		
		// Dibujar la imagen
		g.drawImage(imagen,10,45,this);
		g.drawImage(imagen2,830,100,this);
		
		//Dibujar resultado tirar dados
		Font font = new Font("Agency FB", Font.BOLD, 80);
		g.setFont(font);
		Color colorin = new Color(234,23,43);
		g.setColor(colorin);		
		g.drawString(resultadoDado, 865, 300);
		
		
		Font font2 = new Font("Agency FB", Font.BOLD, 35);
		g.setFont(font2);
		g.drawString(queTurno, 750, 400);
		queTurno = quienToca();
				
		
		// Recorrer posicionesAzules y dibujar
		// posicoinesAzules[0] = 14
		if(posicionesAzules[0]!=-1)
		{			
			if(posicionesAzules[0]!=20 && posicionesAzules[0]!=19 && posicionesAzules[0]!=18 && posicionesAzules[0]!=17 && auxAzul==-1) 
			{					
				int az = posicionesAzules[0];
				// Dibujar un oval en posiciones[14]--> "689,492"
				String coordenadasAzul = posiciones[az];
				// Split
				String moverAzul[] = coordenadasAzul.split(",");
				posX = Integer.parseInt(moverAzul[0]);
				posY = Integer.parseInt(moverAzul[1]);				
			}
			else if(auxAzul==-2) 
			{
				int az = posicionesAzules[0];
				// Dibujar un oval en posiciones[14]--> "689,492"
				String coordenadasAzul = posiciones[az];
				// Split
				String moverAzul[] = coordenadasAzul.split(",");
				posX = Integer.parseInt(moverAzul[0]);
				posY = Integer.parseInt(moverAzul[1]);
				auxAzul = -3;
			}
			else if(auxAzul==-4) 
			{
				int az = posicionesAzules[0];
				// Dibujar un oval en posiciones[14]--> "689,492"
				String coordenadasAzul = posiciones[az];
				// Split
				String moverAzul[] = coordenadasAzul.split(",");
				posX = Integer.parseInt(moverAzul[0]);
				posY = Integer.parseInt(moverAzul[1]);
				auxAzul = -3;
			}
			else 
			{
				if(auxAzul==-3 || auxAzul==-1) 
				{
					auxAzul = posicionesAzules[0]-17;
					posicionesAzules[0] = auxAzul;
					// Dibujar un oval en posiciones[14]--> "689,492"
					String coordenadasAzul = posicionesCeldasAzules[auxAzul];
					// Split
					String moverAzul[] = coordenadasAzul.split(",");
					posX = Integer.parseInt(moverAzul[0]);
					posY = Integer.parseInt(moverAzul[1]);
				}
				else 
				{
					auxAzul = posicionesAzules[0];					
					// Dibujar un oval en posiciones[14]--> "689,492"
					String coordenadasAzul = posicionesCeldasAzules[auxAzul];
					// Split
					String moverAzul[] = coordenadasAzul.split(",");
					posX = Integer.parseInt(moverAzul[0]);
					posY = Integer.parseInt(moverAzul[1]);
				}				
			}			
		}
		
		//Dibujar Fichas
		//drawOval(int x1, int y1, int w, int h)
		//fillOval(int x1, int y1, int w, int h)
		Color colorAzul=new Color(0, 255, 255);
		g.setColor(colorAzul);
		g.fillOval(posX-15, posY-15,30, 30);
		
		// Recorrer posicionesVerdes y dibujar
		// posicoinesAzules[0] = 14
		if(posicionesVerdes[0]!=-1)
		{			
			if(posicionesVerdes[0]!=51 && posicionesVerdes[0]!=52 && posicionesVerdes[0]!=53 && posicionesVerdes[0]!=54 && auxVerde==-1) 
			{					
				int az = posicionesVerdes[0];
				// Dibujar un oval en posiciones[14]--> "689,492"
				String coordenadasAzul = posiciones[az];
				// Split
				String moverAzul[] = coordenadasAzul.split(",");
				posVerdeX = Integer.parseInt(moverAzul[0]);
				posVerdeY = Integer.parseInt(moverAzul[1]);						
			}
			else if(auxVerde==-2) 
			{
				int az = posicionesVerdes[0];
				// Dibujar un oval en posiciones[14]--> "689,492"
				String coordenadasAzul = posiciones[az];
				// Split
				String moverAzul[] = coordenadasAzul.split(",");
				posVerdeX = Integer.parseInt(moverAzul[0]);
				posVerdeY = Integer.parseInt(moverAzul[1]);
				auxVerde = -3;						
			}
			else if(auxVerde==-4) 
			{
				int az = posicionesVerdes[0];
				// Dibujar un oval en posiciones[14]--> "689,492"
				String coordenadasAzul = posiciones[az];
				// Split
				String moverAzul[] = coordenadasAzul.split(",");
				posVerdeX = Integer.parseInt(moverAzul[0]);
				posVerdeY = Integer.parseInt(moverAzul[1]);
				auxVerde = -3;						
			}
			else 
			{
				if(auxVerde==-3 || auxVerde==-1) 
				{
					auxVerde = posicionesVerdes[0]-51;
					posicionesVerdes[0] = auxVerde;
					// Dibujar un oval en posiciones[14]--> "689,492"
					String coordenadasAzul = posicionesCeldasVerdes[auxVerde];
					// Split
					String moverAzul[] = coordenadasAzul.split(",");
					posVerdeX = Integer.parseInt(moverAzul[0]);
					posVerdeY = Integer.parseInt(moverAzul[1]);							
				}				
				else 
				{
					auxVerde = posicionesVerdes[0];					
					// Dibujar un oval en posiciones[14]--> "689,492"
					String coordenadasAzul = posicionesCeldasVerdes[auxVerde];
					// Split
					String moverAzul[] = coordenadasAzul.split(",");
					posVerdeX = Integer.parseInt(moverAzul[0]);
					posVerdeY = Integer.parseInt(moverAzul[1]);							
				}						
			}					
		}
		//drawOval(int x1, int y1, int w, int h)
		//fillOval(int x1, int y1, int w, int h)
		g.setColor(Color.green);
		g.fillOval(posVerdeX-15, posVerdeY-15,30, 30);
	}	
	

	public void windowActivated(WindowEvent we) {}
	public void windowClosed(WindowEvent we) {}
	public void windowClosing(WindowEvent we)
	{
		setVisible(false);
		Modelo modelo = new Modelo();		
		Vista vista = new Vista();
		new Controlador(modelo, vista);
	}
	public void windowDeactivated(WindowEvent we) {}
	public void windowDeiconified(WindowEvent we) {}
	public void windowIconified(WindowEvent we) {}
	public void windowOpened(WindowEvent we) {}
	
	public void mouseClicked(MouseEvent me)
	{		
		// Obtenemos las coordenadas del lugar donde se ha pulsado con el ratón
		pulX = me.getX();
		pulY = me.getY();
		
		// Comprobamos si las coordenadas del ratón están entre las del cuadrado
		if((dadoX<=pulX)&&(pulX<=dadoX+78)&&(dadoY<=pulY)&&(pulY<=dadoY+75))
		{
			resultadoDado = tirarDados()+"";
			
			// Turno de quién
			switch(turno)
			{
			case 0: // Turno rojas
				// Movimiento de las rojas
				for(int i = 0; i<4;i++)
				{
					if(posicionesRojas[i]==-1)
					{
						if(resultadoDado.equals("5"))
						{
							// Permito mover
						}
						else
						{
							// Pasa turno
						}
					}
					else
					{
						// Mover a posicionesRojas[i]+resultadoDado
						// Puedo comer
						// No puedo pasar. Hay un puente
					}
				}
				//turno = 1;
				break;
			case 1: // Turno verdes
				// Movimiento de las verdes
				//for(int i = 0; i<4;i++)
				//{
					if(posicionesVerdes[0]==-1)
					{
						if(resultadoDado.equals("5"))
						{
							// Permito mover
							posicionesVerdes[0]=55;
						}
						else
						{
							// Pasa turno
							turno = 3;
						}
					}
					else
					{
						if(auxVerde==-1 || auxVerde==-3)
						{
							// Mover a posicionesVerdes[i]+resultadoDado
							posicionesVerdes[0] = posicionesVerdes[0]+Integer.parseInt(resultadoDado);
							if(posicionesVerdes[0]>=68) 
							{
								posicionesVerdes[0] = (posicionesVerdes[0]-68);
							}
							if(posicionesVerdes[0]==50) 
							{
								auxVerde=-2;
							}
							if(posicionesVerdes[0]==50) 
							{
								auxVerde=-4;
							}
						}						
						else 
						{
							
								if(posicionesVerdes[0]+Integer.parseInt(resultadoDado)<=7) 
								{
									posicionesVerdes[0] = posicionesVerdes[0]+Integer.parseInt(resultadoDado);
									
									if(posicionesVerdes[0]==7) 
									{
										queTurno = "Jugador Verde ha Ganado!!!";
										System.out.println("Jugador Verde ha Ganado!!!");
									}
								}
								
								else 
								{
									posicionesVerdes[0] = posicionesVerdes[0]-Integer.parseInt(resultadoDado)+Integer.parseInt(resultadoDado);
								}							
						}
						
						// Puedo comer
						// No puedo pasar. Hay un puente
						
					}									
				//}					
				//turno = 0;
				turno = 3;
				break;
			case 2: // Turno amarillas
				//turno = 3;
				break;
			case 3: // Turno azules
				// Movimiento de las azules
				//for(int i = 0; i<4;i++)
				//{
					if(posicionesAzules[0]==-1)
					{
						if(resultadoDado.equals("5"))
						{
							// Permito mover
							posicionesAzules[0]=21;
							
						}
						else
						{
							// Pasa turno
							turno=1;
						}
					}
					else
					{
						if(auxAzul==-1 || auxAzul==-3)
						{
							// Mover a posicionesRojas[i]+resultadoDado
							posicionesAzules[0] = posicionesAzules[0]+Integer.parseInt(resultadoDado);
							if(posicionesAzules[0]>=68) 
							{
								posicionesAzules[0] = (posicionesAzules[0]-68);
							}
							if(posicionesAzules[0]==16) 
							{
								auxAzul=-2;
							}
							if(posicionesAzules[0]==15) 
							{
								auxAzul=-4;
							}		
						}						
						else 
						{
							
								if(posicionesAzules[0]+Integer.parseInt(resultadoDado)<=7) 
								{
									posicionesAzules[0] = posicionesAzules[0]+Integer.parseInt(resultadoDado);
									
									if(posicionesAzules[0]==7) 
									{
										queTurno = "Jugador Azul ha Ganado!!!";
										System.out.println("Jugador Azul ha Ganado!!!");
									}
								}
								
								else 
								{
									posicionesAzules[0] = posicionesAzules[0]-Integer.parseInt(resultadoDado)+Integer.parseInt(resultadoDado);
								}
															
						}
						
						// Puedo comer
						// No puedo pasar. Hay un puente
						
					}										
				//}					
				//turno = 0;
				turno=1;
				break;			
			}
		}
		else 
		{
			posX = me.getX();
			posY = me.getY();
			
		}
		repaint();
		
		System.out.println("Coordenadas: "+pulX+","+pulY);			
		
	}
	public void mouseEntered(MouseEvent arg0) {}	
	public void mouseExited(MouseEvent e) {}	
	public void mousePressed(MouseEvent e) {}	
	public void mouseReleased(MouseEvent e) {}
	
	public int tirarDados()
	{
	    return (int)(Math.random() * 6) + 1;
	}
	
	public String quienToca() 
	{		
		String quien="";
		if(turno==0) 
		{
			quien = "Turno Fichas Rojas";
		}
		if(turno==1) 
		{
			quien = "Turno Fichas Verdes";
		}
		if(turno==2) 
		{
			quien = "Turno Fichas Amarillo";
		}
		if(turno==3) 
		{
			quien = "Turno Fichas Azul";
		}
		return quien;
	}
	
	
}
