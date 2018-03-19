package nl.hu.iac.webshop.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
			job.add("straat", k.getAdres().getStraat());
			job.add("huisnummer", k.getAdres().getHuisnummer());
			job.add("postcode", k.getAdres().getPostcode());
			job.add("plaats", k.getAdres().getPlaats());
			jab.add(job);


		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getKlantId(@PathParam("code") int id) { //specifiek een klant opzoeken
		WebshopService service = ServiceProvider.getWebshopService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		try {
			Klant k = service.getKlantById(id);
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("klant_id", k.getKlantId());
			job.add("naam", k.getNaam());
			job.add("straat", k.getAdres().getStraat());
			job.add("huisnummer", k.getAdres().getHuisnummer());
			job.add("postcode", k.getAdres().getPostcode());
			job.add("plaats", k.getAdres().getPlaats());
			jab.add(job);
		} catch (Exception e) {
			System.out.println("De klant met id " + id + " kon niet opgevraagd worden!");
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@Produces("application/json")
	public void createKlant(@FormParam("naam") String naam,
								 @FormParam("straat") String straat,
								 @FormParam("huisnummer") int huisnummer,
								 @FormParam("postcode") String postcode,
								 @FormParam("plaats") String plaats) {
		

		dao.save(naam, straat, huisnummer, postcode, plaats);
	}


}
