package model;
import java.io.*;

public class UsersData
{
	private String path = "src/users.txt";
	private FileReader fr;
	private BufferedReader bufferRead;

	public void newUser(String nomeUtente, String password, boolean author, String dataNascita) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		String scrivi = "\n"+nomeUtente + "/" + password + "/" + ((author) ? "a" : "g") + "/" + dataNascita + " div";
		out.write(scrivi);
		out.close();
	}
	
	public boolean getUserEsistente(String nomeUtente, String password, boolean isAuthor) throws IOException {
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);
		String riga;
		boolean res = false;
		riga = bufferRead.readLine();
		if(riga == null)
			return false;
		else{
			while(!riga.isEmpty())
			{	
				String[] login = riga.split("/");
				String username = login[0];
				String passw = login[1];
				String author = login[2].split(" ")[0];
				
				if(username.equals(nomeUtente) && passw.equals(password))
				{
					if(isAuthor && author.equals("a")) {
						res = true; break;
					}else if(!isAuthor && author.equals("g")){
						res = true; break;
					}else
						res = false;
							
				}else
					res = false;
				
				riga = bufferRead.readLine();
				if(riga == null)
					return false;
			}
		}
		
		fr.close();
		bufferRead.close();
		
		return res;
	}

	public String[] getAllAuthors() throws IOException {
		
		String[] s  = new String[1]; //valore iniziale
		String temp = "";
		int cnt = 0;
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);
		
		String riga;
		riga = bufferRead.readLine();
		
		if(riga == null)
			return s;
		else{
			while(!riga.isEmpty())
			{
				if(riga.split("/")[2].equals("a")) {
					String username = riga.split("/")[0];
					temp += username + "/";
					cnt++;
				}
				riga = bufferRead.readLine();
				
				if(riga == null)
					break;
			}
		}
		
		s = new String[cnt+1]; //metto la nuova dimensione a s per evitare errori con null o spazi vuoti
		
		for(int i=0; i<cnt; i++) {
			s[i] = temp.split("/")[i];
		}
		s[s.length-1] = " -- ";
		return s;
		
	}
	
	public String getBirthdate(String nomeUtente, String password) throws IOException {
		
		String s = "";
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);
		String riga;
		riga = bufferRead.readLine();
		
		while(!riga.isEmpty())
		{	
			String[] login = riga.split("/");
			String username = login[0];
			String passw = login[1];
			
			if(username.equals(nomeUtente) && passw.equals(password)){
				s = login[3].split("-")[2].split(" ")[0];
			}
			
			riga = bufferRead.readLine();
			if(riga == null)
				break;
		}

		
		return s;
	}
	
}