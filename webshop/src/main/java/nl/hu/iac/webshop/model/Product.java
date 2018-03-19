package nl.hu.iac.webshop.model;

public class Product {
	private int product_id;
	private String product_naam;
	private String product_omschrijving;
	private double product_prijs;
	private String product_plaatje;
	private Categorie categorie;
	
	public Product(String product_naam, String product_omschrijving, double product_prijs, String product_plaatje){
		this.product_naam = product_naam;
		this.product_omschrijving = product_omschrijving;
		this.product_prijs = product_prijs;
		this.product_plaatje = product_plaatje;		
	}
	
	public Product(int product_id, String product_naam, String product_omschrijving, double product_prijs, String product_plaatje){
		this.product_id = product_id;
		this.product_naam = product_naam;
		this.product_omschrijving = product_omschrijving;
		this.product_prijs = product_prijs;
		this.product_plaatje = product_plaatje;
		
	}

	public Product(int product_id, String product_naam, String product_omschrijving, double product_prijs, String product_plaatje, int categorie_id){
		this.product_id = product_id;
		this.product_naam = product_naam;
		this.product_omschrijving = product_omschrijving;
		this.product_prijs = product_prijs;
		this.product_plaatje = product_plaatje;
	}
	
	public int getProductId() {
		return product_id;
	}

	public void setProductId(int product_id) {
		this.product_id = product_id;
	}

	public String getProductNaam() {
		return product_naam;
	}

	public void setProductNaam(String product_naam) {
		this.product_naam = product_naam;
	}

	public String getProductOmschrijving() {
		return product_omschrijving;
	}

	public void setProductOmschrijving(String product_omschrijving) {
		this.product_omschrijving = product_omschrijving;
	}

	public double getProductPrijs() {
		return product_prijs;
	}

	public void setProductPrijs(double product_prijs) {
		this.product_prijs = product_prijs;
	}

	public String getProductPlaatje() {
		return product_plaatje;
	}

	public void setProductPlaatje(String product_plaatje) {
		this.product_plaatje = product_plaatje;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
