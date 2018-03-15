package nl.hu.iac.webshop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.iac.webshop.model.Adres;

public class AdresDAO extends BaseDAO {
	private List<Adres> selectAdres(String query) {
		List<Adres> results = new ArrayList<Adres>();
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int adres_id = stmt.executeQuery(query).getInt("adres_id");
				String straat = stmt.executeQuery(query).getString("straat");
				int huisnummer = stmt.executeQuery(query).getInt("huisnummer");
				String postcode = stmt.executeQuery(query).getString("postcode");
				String plaats = stmt.executeQuery(query).getString("plaats");
				Adres newAdres = new Adres(adres_id, straat, huisnummer, postcode, plaats);
				results.add(newAdres);
			}
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	//create
	public Adres save(Adres Adres) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO Adres VALUES ('" + Adres.getPostcode() + "', '" + Adres.getAdresId() + "', '" + Adres.getHuisnummer() + "', '" + Adres.getStraat() + "', " + Adres.getPlaats() + "')");
			System.out.println("Adres is toegevoegd!");

		} catch (SQLException sqle) { sqle.printStackTrace(); System.out.println("Er is iets mis gegaan!"); }
		return Adres;
	}

	public List<Adres> findAll() {
		return selectAdres("SELECT adres_id, straat, huisnummer, postcode, plaats FROM Adres");
	}
	
	public Adres findByAdres_id(int i){
		return selectAdres("SELECT adres_id, straat, huisnummer, postcode, plaats FROM Adres where adres_id = " + i).get(0);
	}

	
	public Adres updateAdres(Adres Adres) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			String query = "UPDATE Adres SET huisnummer = "+ Adres.getHuisnummer() +", plaats = '" + Adres.getPlaats() + "', postcode = '"+ Adres.getPostcode() +"', straat = '" + Adres.getStraat() + "' WHERE adres_id = " + Adres.getAdresId();
			stmt.executeQuery(query);
			
			System.out.println(Adres.getAdresId());
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return Adres;
	}

	public Adres deleteByCode(Adres Adres) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			String query = "DELETE FROM Adres where adres_id = "+ Adres.getAdresId();
			stmt.executeQuery(query);
			
			System.out.println(Adres.getAdresId());
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return Adres;
	}	
}