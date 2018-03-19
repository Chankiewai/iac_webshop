package nl.hu.iac.webshop.webservices;

import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nl.hu.iac.webshop.model.Categorie;
import nl.hu.iac.webshop.model.Product;
import nl.hu.iac.webshop.model.ServiceProvider;
import nl.hu.iac.webshop.model.WebshopService;
import nl.hu.iac.webshop.persistence.CategorieDAO;


@Path("/categorie")
public class CategorieResource {
	CategorieDAO categorieDAO = new CategorieDAO();
	
	@GET
	@Produces("application/json")
	public String getCategorie() {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Categorie c : service.getAllCategorie()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("categorie_id", c.getCategorieId());
			job.add("categorie_naam", c.getCategorieNaam());
			job.add("categorie_omschrijving", c.getCategorieOmschrijving());
			job.add("categorie_plaatje", c.getCategoriePlaatje());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getCategorieProducten(@PathParam("code") int id) {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		try {
			Product p = service.getProductById(id);
			if (p.getCategorie().getCategorieId() == id) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("product_id", p.getProductId());
				job.add("product_naam", p.getProductNaam());
				job.add("product_omschrijving", p.getProductOmschrijving());
				job.add("product_prijs", p.getProductPrijs());
				job.add("product_plaatje", p.getProductPlaatje());
				job.add("categorie_id", p.getCategorie().getCategorieId());
				job.add("categorie_naam", p.getCategorie().getCategorieNaam());
				job.add("categorie_omschrijving", p.getCategorie().getCategorieOmschrijving());
				job.add("categorie_plaatje", p.getCategorie().getCategoriePlaatje());
				jab.add(job);
			}
		} catch (Exception e) {
			System.out.println("Het product met id " + id + " kon niet opgevraagd worden!");
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
}