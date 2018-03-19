package nl.hu.iac.webshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.iac.webshop.model.Adres;
import nl.hu.iac.webshop.model.Klant;

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
	public Adres save(Adres adres, Klant klant) {//String straat, int huisnummer, String postcode, String plaats
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			String query = "INSERT INTO adres(straat, huisnummer, postcode, plaats) VALUES ('" + adres.getStraat() + "', " + adres.getHuisnummer() + ", '" + adres.getPostcode() + "' ,'" + adres.getPlaats() + "')";
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int getadres_id = rs.getInt("adres_id");
				stmt.executeUpdate("INSERT INTO klant(naam, adres_id) VALUES ('" + klant.getNaam() + "', " + getadres_id + ")");
			}
			
			System.out.println("Adres is toegevoegd!");
			/*PreparedStatement ps = con.prepareStatement("INSERT INTO Adres(adres_id, straat, huisnummer, postcode, plaats) VALUES (adres_seq.nextval,?,?,?,?)");
			ps.setString(1, straat);
			ps.setInt(2, huisnummer);
			ps.setString(3, postcode);
			ps.setString(4, plaats);
			
			ps.executeQuery();*/

		} catch (SQLException sqle) { sqle.printStackTrace(); System.out.println("Adres is niet toegevoegd!"); }
		return adres;
	}

	public List<Adres> findAll() {
		return selectAdres("SELECT adres_id, straat, huisnummer, postcode, plaats FROM Adres");
	}
	
	public Adres findByAdres_id(int i){
		return selectAdres("SELECT adres_id, straat, huisnummer, postcode, plaats FROM Adres where adres_id = " + i).get(0);
	}

	
	public Adres updateAdres(String straat, int huisnummer, String postcode, String plaats, int adres_id) {
		try (Connection con = super.getConnection()){
			PreparedStatement ps = con.prepareStatement("UPDATE Adres SET huisnummer = ?, plaats = ?, postcode = ?, straat = ? WHERE adres_id = ?");
			/*String query = "UPDATE Adres SET huisnummer = "+ Adres.getHuisnummer() +", plaats = '" + Adres.getPlaats() + "', postcode = '"+ Adres.getPostcode() +"', straat = '" + Adres.getStraat() + "' WHERE adres_id = " + Adres.getAdresId();
			stmt.executeQuery(query);*/
			ps.setString(1, straat);
			ps.setInt(2, huisnummer);
			ps.setString(3, postcode);
			ps.setString(4, plaats);
			ps.setInt(5, adres_id);
			
			ps.executeQuery();
			System.out.println("adres is geupdated!");
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return null;
	}

	public Adres deleteByCode(int adres_id) {
		try (Connection con = super.getConnection()){
			PreparedStatement ps = con.prepareStatement("DELETE FROM Adres where adres_id = ?");
			ps.setInt(1, adres_id);
					
			ps.executeQuery();
			
			System.out.println("adres is verwijderd!");
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return null;
	}	
}