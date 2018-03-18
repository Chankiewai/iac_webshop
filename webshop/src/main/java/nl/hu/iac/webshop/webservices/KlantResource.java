package nl.hu.iac.webshop.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.hu.iac.webshop.model.Klant;
import nl.hu.iac.webshop.model.ServiceProvider;
import nl.hu.iac.webshop.model.WebshopService;
import nl.hu.iac.webshop.persistence.KlantDAO;


@Path("/klant")
public class KlantResource {
	KlantDAO dao = new KlantDAO();
	@GET
	@Produces("application/json")
	public String getKlanten() {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Klant k : service.getAllKlanten()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("klant_id", k.getKlantId());
			job.add("naam", k.getNaam());
			job.add("adres_id", (JsonValue) k.getAdres());


		}
		JsonArray array = jab.build();
		return array.toString();
	}


}
