package nl.hu.iac.webshop.model;

public class Categorie {
	private int categorie_id;
	private String categorie_naam;
	private String categorie_omschrijving;
	private String categorie_plaatje;
	
	public Categorie(int categorie_id, String categorie_naam, String categorie_omschrijving, String categorie_plaatje){
		this.categorie_id = categorie_id;
		this.categorie_naam = categorie_naam;
		this.categorie_omschrijving = categorie_omschrijving;
		this.categorie_plaatje = categorie_plaatje;
	}

	public int getCategorieId() {
		return categorie_id;
	}

	public void setCategorieId(int categorie_id) {
		this.categorie_id = categorie_id;
	}

	public String getCategorieNaam() {
		return categorie_naam;
	}

	public void setCategorieNaam(String categorie_naam) {
		this.categorie_naam = categorie_naam;
	}

	public String getCategorieOmschrijving() {
		return categorie_omschrijving;
	}

	public void setCategorieOmschrijving(String categorie_omschrijving) {
		this.categorie_omschrijving = categorie_omschrijving;
	}

	public String getCategoriePlaatje() {
		return categorie_plaatje;
	}

	public void setCategoriePlaatje(String categorie_plaatje) {
		this.categorie_plaatje = categorie_plaatje;
	}
}
