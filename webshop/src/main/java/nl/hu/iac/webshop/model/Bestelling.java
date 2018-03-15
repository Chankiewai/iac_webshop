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

	public int getBestellingId() {
		return bestelling_id;
	}

	public void setBestellingId(int bestelling_id) {
		this.bestelling_id = bestelling_id;
	}

	public Adres getAdresId() {
		return adres_id;
	}

	public void setAdresId(Adres adres_id) {
		this.adres_id = adres_id;
	}

	public Bestellingsregel getBestellingsregel_id() {
		return bestellingsregel_id;
	}

	public void setBestellingsregel_id(Bestellingsregel bestellingsregel_id) {
		this.bestellingsregel_id = bestellingsregel_id;
	}
}
