package nl.hu.iac.webshop.model;

public class Klant {
	private int klant_id;
	private String naam;
	private Adres adres; 
	
	public Klant(int klant_id, String naam){
		this.klant_id = klant_id;
		this.naam = naam;
	}

	public int getKlantId() {
		return klant_id;
	}

	public void setKlantId(int klant_id) {
		this.klant_id = klant_id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
}
