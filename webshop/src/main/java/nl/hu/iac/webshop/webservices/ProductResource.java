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

import nl.hu.ipass.vvu.model.Adres;
import nl.hu.ipass.vvu.model.Lid;
import nl.hu.ipass.vvu.model.ServiceProvider;
import nl.hu.ipass.vvu.model.VvuService;
import nl.hu.ipass.vvu.persistence.AdresDAO;
import nl.hu.ipass.vvu.persistence.LidDAO;
import nl.hu.ipass.vvu.persistence.TeamDAO;


@Path("/leden")
public class LidResource {
	LidDAO lidDAO = new LidDAO();
	AdresDAO adresDAO = new AdresDAO();
	TeamDAO teamDAO = new TeamDAO();
	
	@GET
	@Path("{lid_id}")
	@Produces("application/json")
	public String getLidInfo(@PathParam("lid_id") int lid_id) {
		VvuService service = ServiceProvider.getVvuService();
		Lid l = service.getLidById(lid_id);

		JsonObjectBuilder job = Json.createObjectBuilder();

		job.add("lid_id", l.getLidId());
		job.add("voornaam", l.getVoornaam());
		job.add("tussenvoegsel", l.getTussenvoegsel());
		job.add("achternaam", l.getAchternaam());
		job.add("email", l.getEmail());
		job.add("geboortedatum", l.getGeboortedatum() + "");
		job.add("telefoonnummer", l.getTelefoonnummer());
		job.add("straat", l.getAdres().getStraat());
		job.add("huisnummer", l.getAdres().getHuisnummer());
		job.add("postcode", l.getAdres().getPostcode());
		job.add("plaats", l.getAdres().getPlaats());
		job.add("team_id", l.getTeam().getTeamId());
		job.add("teamcode", l.getTeam().getTeamcode());

		return job.build().toString();
	}
	
	@GET
	@Produces("application/json")
	public String getLeden() {
		VvuService service = ServiceProvider.getVvuService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Lid l : service.getAllLeden()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("lid_id", l.getLidId());
			job.add("voornaam", l.getVoornaam());
			job.add("tussenvoegsel", l.getTussenvoegsel());
			job.add("achternaam", l.getAchternaam());
			job.add("email", l.getEmail());
			job.add("geboortedatum", l.getGeboortedatum() + "");
			job.add("telefoonnummer", l.getTelefoonnummer());
			job.add("straat", l.getAdres().getStraat());
			job.add("huisnummer", l.getAdres().getHuisnummer());
			job.add("postcode", l.getAdres().getPostcode());
			job.add("plaats", l.getAdres().getPlaats());
			job.add("team_id", l.getTeam().getTeamId());
			job.add("teamcode", l.getTeam().getTeamcode());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/geen")
	@Produces("application/json")
	public String getLedenMetGeenTeam() {
		VvuService service = ServiceProvider.getVvuService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Lid l : service.getAllNoTeam()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("lid_id", l.getLidId());
			job.add("voornaam", l.getVoornaam());
			job.add("tussenvoegsel", l.getTussenvoegsel());
			job.add("achternaam", l.getAchternaam());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@PUT
	@Path("{lid_id}")
	public String updateLid(@PathParam("lid_id") int lid_id,
								@FormParam("voornaam") String voornaam,
								@FormParam("tussenvoegsel") String tussenvoegsel,
								@FormParam("achternaam") String achternaam,
								@FormParam("email") String email,
								@FormParam("geboortedatum") String geboortedatumString,
								@FormParam("telefoonnummer") String telefoonnummer,
								@FormParam("straat") String straat,
								@FormParam("huisnummer") int huisnummer,
								@FormParam("postcode") String postcode,
								@FormParam("plaats") String plaats) {
		LocalDate geboortedatum = LocalDate.parse(geboortedatumString);
		VvuService service = ServiceProvider.getVvuService();
		Lid currentLid = service.getLidById(lid_id);
		Lid updateLid = new Lid(lid_id,voornaam,tussenvoegsel,achternaam,email,geboortedatum,telefoonnummer);
		Adres updateAdres = new Adres(currentLid.getAdres().getAdresId(), straat, huisnummer, postcode, plaats);
		lidDAO.updateLid(updateLid, updateAdres);
		return "success";
	}
	
	@DELETE
	@Path("{lid_id}")
	public String deleteLid(@PathParam("lid_id") int lid_id) {
		VvuService service = ServiceProvider.getVvuService();
		Lid currentLid = service.getLidById(lid_id);
		int adres_id = currentLid.getAdres().getAdresId();
		lidDAO.deleteById(currentLid, adres_id);
		return "success";		
	}
	
	@PUT
	@Path("{lid_id}/{team_id}")
	public String updateLidTeam(@PathParam("lid_id") int lid_id,
								@PathParam("team_id") int team_id) {
		VvuService service = ServiceProvider.getVvuService();
		Lid currentLid = service.getLidById(lid_id);
		Lid updateLid = new Lid(lid_id,currentLid.getVoornaam(),currentLid.getTussenvoegsel(),currentLid.getAchternaam(),currentLid.getEmail(),currentLid.getGeboortedatum(),currentLid.getTelefoonnummer());
		lidDAO.updateLidTeam(updateLid, team_id);
		return "success";
	}
	
	
}