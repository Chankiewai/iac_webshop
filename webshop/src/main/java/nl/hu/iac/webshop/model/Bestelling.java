package nl.hu.iac.webshop.model;

public class Bestelling {
	private int bestelling_id;
	private Adres adres_id;
	private Bestellingsregel bestellingsregel_id;
	
	public Bestelling(int bestelling_id, Adres adres_id, Bestellingsregel bestellingsregel_id){
		this.bestelling_id = bestelling_id;
		this.adres_id = adres_id;
		this.bestellingsregel_id = bestellingsregel_id;
	}
}
