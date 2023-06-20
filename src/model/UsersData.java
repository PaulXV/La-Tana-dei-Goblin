package model;

import java.io.*;
import java.nio.file.*;

public class UsersData
{
	private String path = "src/users.txt";
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader bufferRead;
	private int numeroUtenti = 6;

	public void newUser(String nomeUtente, String password, boolean author) throws IOException {
		numeroUtenti++;
		fw = new FileWriter(path);
		
		String scrivi = numeroUtenti + " " + nomeUtente + " " + password + " " + ((author) ? "a" : "g");
		
		fw.write(scrivi);
			
		fw.close();
	}
	
	public boolean getUserEsistente(String nomeUtente, String password) throws IOException {
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);;
		String riga;
		boolean res = false;
		
		for(int i=0; i<numeroUtenti; i++) {
			riga = bufferRead.readLine();

			String username = riga.split(" ")[1];
			String passw = riga.split(" ")[2];
			
			if(username.equals(nomeUtente) && passw.equals(password))
			{
				res = true; break;
			}else
				res = false;
		}
		
		fr.close();
		bufferRead.close();
		
		return res;
	}

	public boolean isUserLogged(String username, String password1, boolean author) throws IOException {
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);;
		String riga;
		boolean res = false;
		
		for(int i=0; i<numeroUtenti; i++) {
			riga = bufferRead.readLine();

			String nome = riga.split(" ")[1];
			String passw = riga.split(" ")[2];
			
			if(nome.equals(username) && passw.equals(password1))
			{
				res = false; break;
			}else
				res = true;
		}
		
		fr.close();
		bufferRead.close();
		
		return res;
	}
	
	public String[] getAllUsers() throws IOException {
		
		String[] s = new String[numeroUtenti];
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);;
		String riga;
		
		for(int i=0; i<numeroUtenti-1; i++)
		{
			riga = bufferRead.readLine();

			String username = riga.split(" ")[1];
			s[i] = username;
		}
		
		return s;
		
	}
	
}