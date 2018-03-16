package nl.hu.iac.webshop.model;

import java.util.List;

import nl.hu.iac.webshop.persistence.AdresDAO;


public class WebshopServiceKlanten {
	private AdresDAO adao = new AdresDAO();
	
	public List<Adres> getAllAdressen() {
		return adao.findAll();
	}

	
	public Adres getAdresById(int adres_id) {
		Adres result = null;	
		for (Adres adres : adao.findAll()) {
			if (adres.getAdresId() == adres_id) {
				result = adres;
				break;
			}
		}		
		return result;
	}
	
}