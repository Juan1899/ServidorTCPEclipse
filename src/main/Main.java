package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}

	
	
	public void settings() {
		size(500,500); 
	}
	
	public void setup() {
		
		// Este elemento nos permite esperar una conexi�n. 
		
		new Thread(
				
				() -> {
					
						try {
						ServerSocket server = new ServerSocket(5000);
						
						// Esta linea me permite aceptar la conexi�n entrante. 
						System.out.println("Esperando...");
						
						Socket socket = server.accept();
						System.out.println("Conexi�n aceptada");
						
						InputStream is =  socket.getInputStream();
						
			           
			            InputStreamReader isr = new InputStreamReader(is);

			          
			            BufferedReader reader = new BufferedReader(isr);
			            
			            while(true) {
			            
			            String line = reader.readLine(); 
			            System.out.println(line);
			            
			            switch(line) {
			            
			            
			            case "UP":
			            	
			            	y-=5;
			            	break; 
			            }
			            
			           
			            }
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
				
				}
				
				
				).start(); 
		
		
	}
	
	int x = 250, y = 250;
	public void draw() {
		
		background(0);
		
		fill(255,100,100);
		ellipse(x,y,50,50); 
	}
}
