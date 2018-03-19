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

import nl.hu.iac.webshop.model.Aanbieding;
import nl.hu.iac.webshop.model.Product;
import nl.hu.iac.webshop.model.ServiceProvider;
import nl.hu.iac.webshop.model.WebshopService;
import nl.hu.iac.webshop.persistence.AanbiedingDAO;
import nl.hu.iac.webshop.persistence.CategorieDAO;
import nl.hu.iac.webshop.persistence.ProductDAO;


@Path("/aanbieding")
public class AanbiedingResource {
	AanbiedingDAO aanbiedingDAO = new AanbiedingDAO();
	
	@GET
	@Produces("application/json")
	public String getAanbiedingen(@PathParam("code") int id) {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Aanbieding a : service.getAllAanbiedingen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("aanbieding_id", a.getAanbiedingId());
			job.add("van_datum", a.getVanDatum() + "");
			job.add("tot_datum", a.getTotDatum() + "");
			job.add("aanbieding_prijs", a.getAanbiedingPrijs());
			job.add("product_id", a.getProduct().getProductId());
			job.add("product_naam", a.getProduct().getProductNaam());
			job.add("product_omschrijving", a.getProduct().getProductOmschrijving());
			job.add("product_prijs", a.getProduct().getProductPrijs());
			job.add("product_plaatje", a.getProduct().getProductPlaatje());
			job.add("aanbieding_verschil", a.getProduct().getProductPrijs() - a.getAanbiedingPrijs());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getAanbiedingenForFrontPage(@PathParam("code") int id) {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		int i = 0;

		for (Aanbieding a : service.getAllAanbiedingen()) {
			if (i < id) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("aanbieding_id", a.getAanbiedingId());
				job.add("van_datum", a.getVanDatum() + "");
				job.add("tot_datum", a.getTotDatum() + "");
				job.add("aanbieding_prijs", a.getAanbiedingPrijs());
				job.add("product_id", a.getProduct().getProductId());
				job.add("product_naam", a.getProduct().getProductNaam());
				job.add("product_omschrijving", a.getProduct().getProductOmschrijving());
				job.add("product_prijs", a.getProduct().getProductPrijs());
				job.add("product_plaatje", a.getProduct().getProductPlaatje());
				job.add("aanbieding_verschil", a.getProduct().getProductPrijs() - a.getAanbiedingPrijs());
				jab.add(job);
				id += 1;
			} else {
				break;
			}
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}