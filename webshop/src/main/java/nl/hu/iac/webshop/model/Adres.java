package nl.hu.iac.webshop.model;

public class Adres {
	private int adres_id;
	private String straat;
	private int huisnummer;
	private String postcode;
	private String plaats;
	
	public Adres(int adres_id, String straat, int huisnummer, String postcode, String plaats){
		this.adres_id = adres_id;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.plaats = plaats;
	}

	public int getAdresId() {
		return adres_id;
	}

	public void setAdresId(int adres_id) {
		this.adres_id = adres_id;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
}
