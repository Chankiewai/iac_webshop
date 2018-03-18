package nl.hu.iac.webshop.model;

import java.time.LocalDate;

public class Aanbieding {
	private int aanbieding_id;
	private double aanbieding_prijs;
	private LocalDate van_datum;
	private LocalDate tot_datum;
	private Product product;
	
	public Aanbieding(int aanbieding_id, double aanbieding_prijs, LocalDate van_datum, LocalDate tot_datum){
		this.aanbieding_id = aanbieding_id;
		this.aanbieding_prijs = aanbieding_prijs;
		this.van_datum = van_datum;
		this.tot_datum = tot_datum;
	}

	public int getAanbiedingId() {
		return aanbieding_id;
	}

	public void setAanbiedingId(int aanbieding_id) {
		this.aanbieding_id = aanbieding_id;
	}

	public double getAanbiedingPrijs() {
		return aanbieding_prijs;
	}

	public void setAanbiedingPrijs(double aanbieding_prijs) {
		this.aanbieding_prijs = aanbieding_prijs;
	}

	public LocalDate getVanDatum() {
		return van_datum;
	}

	public void setVanDatum(LocalDate van_datum) {
		this.van_datum = van_datum;
	}

	public LocalDate getTotDatum() {
		return tot_datum;
	}

	public void setTotDatum(LocalDate tot_datum) {
		this.tot_datum = tot_datum;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
