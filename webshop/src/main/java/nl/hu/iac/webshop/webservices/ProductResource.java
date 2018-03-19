package nl.hu.iac.webshop.webservices;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nl.hu.iac.webshop.model.Product;
import nl.hu.iac.webshop.model.ServiceProvider;
import nl.hu.iac.webshop.model.WebshopService;
import nl.hu.iac.webshop.persistence.CategorieDAO;
import nl.hu.iac.webshop.persistence.ProductDAO;


@Path("/product")
public class ProductResource {
	ProductDAO productDAO = new ProductDAO();
	CategorieDAO categorieDAO = new CategorieDAO();
	
	@GET
	@Produces("application/json")
	public String getProducten() {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Product p : service.getAllProducten()) {
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
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getProduct(@PathParam("code") int id) { //specifiek een product opzoeken
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		try {
			Product p = service.getProductById(id);
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
		} catch (Exception e) {
			System.out.println("Het product met id " + id + " kon niet opgevraagd worden!");
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/categorie/{code}")
	@Produces("application/json")
	public String getProductenFromCategorie(@PathParam("code") int id) {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		try {
			for (Product p : service.getAllProducten()) {
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
			}
		} catch (Exception e) {
			System.out.println("Het product met id " + id + " kon niet opgevraagd worden!");
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@Produces("application/json")
	public void createProduct(@FormParam("naam") String naam,
								 @FormParam("omschrijving") String omschrijving,
								 @FormParam("prijs") double prijs,
								 @FormParam("plaatje") String plaatje) {
		Product newProduct = new Product(naam, omschrijving, prijs, plaatje);

		productDAO.productToevoegen(newProduct);
	}
	
	@PUT
	@Path("{product_id}")
	public void updateLid(@PathParam("product_id") int product_id,
								@FormParam("product_naam") String product_naam,
								@FormParam("product_omschrijving") String product_omschrijving,
								@FormParam("product_prijs") double product_prijs,
								@FormParam("product_plaatje") String product_plaatje,
								@FormParam("categorie_id") int categorie_id) {
		Product updateProduct = new Product(product_id, product_naam, product_omschrijving, product_prijs, product_plaatje, categorie_id);
		productDAO.updateProduct(updateProduct);
	}
}