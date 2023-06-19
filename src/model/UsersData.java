package model;

import java.io.*;

public class UsersData
{
	private String path = "src/users.txt";
	private FileWriter fw;
	private BufferedWriter bufferWrite;
	private FileReader fr;
	private BufferedReader bufferRead;
	private int numeroUtenti = 2;

	public void newUser(String nomeUtente, String password, boolean author) throws IOException {
		numeroUtenti++;
		fw = new FileWriter(path);
		bufferWrite = new BufferedWriter(fw);
		
		String scrivi = numeroUtenti + " " + nomeUtente + " " + password + " " + ((author) ? "a" : "g");
	
		fw.write(scrivi);
		fw.append('\n');
		//bufferWrite.write(scrivi);
		//bufferWrite.newLine();
		
		bufferWrite.close();
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
		
		return res;
	}

	public boolean isUserLogged(String username, String password1, boolean author) {
		// TODO: creare un ciclo come in getUserEsistente per controllare che non esista già lo user
		//se esiste gia ritorna false e sarà impossibile fare il singIn
		return false;
	}
}