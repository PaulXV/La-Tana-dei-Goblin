package model;
import java.io.*;
import gui.*;

public class GamesDatas
{
	private String path = "src/games.txt";
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader bufferRead;
	private int numeroGiochi = 0;

	public void newGame(MyLabel giocoDaAggiungere) throws IOException {
		numeroGiochi++;
		fw = new FileWriter(path);
		
		String scrivi = numeroGiochi + ")" + giocoDaAggiungere.toString();
		
		fw.write(scrivi);
			
		fw.close();
	}
	
	public String[] getAllGames() throws IOException {
		
		String[] s = new String[numeroGiochi];
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);;
		String riga;
		
		for(int i=0; i<numeroGiochi-1; i++)
		{
			riga = bufferRead.readLine();
			s[i] = riga;
		}
		
		return s;
		
	}
	
}