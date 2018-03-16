package nl.hu.iac.webshop.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.hu.iac.webshop.model.Adres;
import nl.hu.iac.webshop.model.ServiceProvider;
import nl.hu.iac.webshop.model.WebshopServiceKlanten;
import nl.hu.iac.webshop.persistence.AdresDAO;


@Path("/adres")
public class AdresResource {
	AdresDAO dao = new AdresDAO();
	@GET
	@Produces("application/json")
	public String getAdressen() {
		WebshopServiceKlanten service = ServiceProvider.getWebshopServiceKlanten();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Adres a : service.getAllAdressen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("product_id", a.getAdresId());
			job.add("product_naam", a.getHuisnummer());
			job.add("product_omschrijving", a.getPlaats());
			job.add("product_prijs", a.getPostcode());
			job.add("product_plaatje", a.getStraat());

		}
		JsonArray array = jab.build();
		return array.toString();
	}


}
