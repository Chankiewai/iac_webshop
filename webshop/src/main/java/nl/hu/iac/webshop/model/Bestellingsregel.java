package nl.hu.iac.webshop.model;

public class Bestellingsregel {
	private int bestellingsregel_id;
	private int product_id;
	private int aantal;
	private double totaal_prijs;
	
	public Bestellingsregel(int bestellingsregel_id, int product_id, int aantal, double totaal_prijs){
		this.bestellingsregel_id = bestellingsregel_id;
		this.product_id = product_id;
		this.aantal = aantal;
		this.totaal_prijs = totaal_prijs;
	}

	public int getBestellingsregelId() {
		return bestellingsregel_id;
	}

	public void setBestellingsregelId(int bestellingsregel_id) {
		this.bestellingsregel_id = bestellingsregel_id;
	}

	public int getProductId() {
		return product_id;
	}

	public void setProductId(int product_id) {
		this.product_id = product_id;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public double getTotaalPrijs() {
		return totaal_prijs;
	}

	public void setTotaalPrijs(double totaal_prijs) {
		this.totaal_prijs = totaal_prijs;
	}
}
