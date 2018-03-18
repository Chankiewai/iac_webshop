package nl.hu.iac.webshop.model;

import java.util.List;

import nl.hu.iac.webshop.persistence.AdresDAO;
import nl.hu.iac.webshop.persistence.CategorieDAO;
import nl.hu.iac.webshop.persistence.KlantDAO;
import nl.hu.iac.webshop.persistence.ProductDAO;

public class WebshopService {
	private ProductDAO productDAO = new ProductDAO();
	private CategorieDAO categorieDAO = new CategorieDAO();
	private AdresDAO adresDAO = new AdresDAO();
	private KlantDAO klantDAO = new KlantDAO();
	
	public List<Product> getAllProducten() {
		return productDAO.findAll();
	}
	
	public List<Categorie> getAllCategorie() {
		return categorieDAO.findAll();
	}
	
	public Categorie getCategorieById(int categorie_id) {
		Categorie result = null;	
		for (Categorie categorie : categorieDAO.findAll()) {
			if (categorie.getCategorieId() == categorie_id) {
				result = categorie;
				break;
			}
		}		
		return result;
	}
	
	public Product getProductById(int product_id) {
		Product result = null;	
		for (Product product : productDAO.findAll()) {
			if (product.getProductId() == product_id) {
				result = product;
				break;
			}
		}		
		return result;
	}
	
	public List<Adres> getAllAdressen() {
		return adresDAO.findAll();
	}

	
	public Adres getAdresById(int adres_id) {
		Adres result = null;	
		for (Adres adres : adresDAO.findAll()) {
			if (adres.getAdresId() == adres_id) {
				result = adres;
				break;
			}
		}		
		return result;
	}
	
	public List<Klant> getAllKlanten() {
		return klantDAO.findAll();
	}

	
	public Klant getKlantById(int klant_id) {
		Klant result = null;	
		for (Klant klant : klantDAO.findAll()) {
			if (klant.getKlantId() == klant_id) {
				result = klant;
				break;
			}
		}		
		return result;
	}
}