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
import nl.hu.iac.webshop.model.WebshopService;
import nl.hu.iac.webshop.persistence.AdresDAO;


@Path("/adres")
public class AdresResource {
	AdresDAO dao = new AdresDAO();
	@GET
	@Produces("application/json")
	public String getAdressen() {
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Adres a : service.getAllAdressen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("adres_id", a.getAdresId());
			job.add("huisnummer", a.getHuisnummer());
			job.add("plaats", a.getPlaats());
			job.add("postcode", a.getPostcode());
			job.add("straat", a.getStraat());

		}
		JsonArray array = jab.build();
		return array.toString();
	}


}
