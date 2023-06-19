package model;

import java.io.*;

public class UsersData
{
	private String path = "src/users.txt";
	private FileWriter fw;
	private BufferedWriter bufferWrite;
	private FileReader fr;
	private BufferedReader bufferRead;
	private int numeroUtenti = 0;

	public void newUser(String nomeUtente, String password, boolean author) throws IOException {
		numeroUtenti++;
		fw = new FileWriter(path);
		bufferWrite = new BufferedWriter(fw);
		
		String scrivi = numeroUtenti + " " + nomeUtente + " " + password + " " + ((author) ? "a" : "g");
	
		bufferWrite.write(scrivi);
		
		bufferWrite.close();
	}
	
	public boolean getUserEsistente(String nomeUtente, String password, boolean author) throws IOException {
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);;
		String riga;
		boolean res = false;
		
		for(int i=0; i<numeroUtenti; i++) {
			riga = bufferRead.readLine();
			char fineRiga = riga.charAt(riga.length()-1);
			System.out.println(fineRiga);
			
			if(author) {
				if(fineRiga == 'a')
				{
					String username = riga.split(" ")[1];
					String passw = riga.split(" ")[2];
					
					if(username.equals(nomeUtente) && passw.equals(password))
						res = true;
					else
						res = false;
				}
			}else
				res = false;
		}
		
		return res;
	}
}