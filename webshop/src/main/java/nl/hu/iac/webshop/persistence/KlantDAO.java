package nl.hu.iac.webshop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.iac.webshop.model.Adres;
import nl.hu.iac.webshop.model.Klant;

public class KlantDAO extends BaseDAO {
	private AdresDAO adresdao = new AdresDAO();
	private List<Klant> selectKlant(String query) {
		List<Klant> results = new ArrayList<Klant>();
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int klant_id = stmt.executeQuery(query).getInt("klant_id");
				String naam = stmt.executeQuery(query).getString("naam");
				Klant newKlant = new Klant(klant_id, naam);
				Adres adres = adresdao.findByAdres_id(dbResultSet.getInt("adres_id"));
				newKlant.setAdres(adres);
				results.add(newKlant);
			}
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public Klant save(Klant Klant) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO Klant VALUES (" + Klant.getKlantId() + ", '" + Klant.getNaam() + "', '" + Klant.getAdres() + "')");
			System.out.println("Klant is toegevoegd!");

		} catch (SQLException sqle) { sqle.printStackTrace(); System.out.println("Er is iets mis gegaan!"); }
		return Klant;
	}
	
	public List<Klant> findAll() {
		return selectKlant("SELECT klant_id, naam, adres FROM klant");
	}
	
	public Klant findByKlant_id(String klant){
		return selectKlant("SELECT klant_id, naam, adres FROM klant where klant_id = " + klant).get(0);
	}

	
	public Klant updateKlant(Klant Klant) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			String query = "UPDATE Klant SET naam = '"+ Klant.getNaam() +"', adres = '" + Klant.getAdres() + "' WHERE code = '" + Klant.getKlantId();
			//2de query?
			stmt.executeQuery(query);
			
			System.out.println(Klant.getKlantId());
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return Klant;
	}

	public Klant deleteByCode(Klant Klant) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			String query = "DELETE FROM Klant where klant_id = "+ Klant.getKlantId();
			//2de query? 
			stmt.executeQuery(query);
			
			System.out.println(Klant.getKlantId());
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return Klant;
	}	
}