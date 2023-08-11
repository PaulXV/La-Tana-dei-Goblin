package model;

public enum Premio {
	
	NESSUNO,
	PRIMO_POSTO,
	SECONDO_POSTO,
	TERZO_POSTO,
	GIOCO_DEFINITIVO,
	GIOCO_DELL_ANNO;
	
	Premio premio;
	
	public Premio getIterazione() {return premio;}
	public void setIterazione(Premio pr) {
		if(premio!=null) {
			premio=pr;
		}else {
			new Exception("Iterazione è null"); 
		}
	}
	
}