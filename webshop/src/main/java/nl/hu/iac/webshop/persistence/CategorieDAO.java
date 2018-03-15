package nl.hu.iac.webshop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.iac.webshop.model.Categorie;

public class CategorieDAO extends BaseDAO {
	private List<Categorie> selectCategories(String query) {
		List<Categorie> results = new ArrayList<Categorie>();
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
	
			while (dbResultSet.next()) {
				int categorie_id = dbResultSet.getInt("categorie_id");
				String categorie_naam = dbResultSet.getString("categorie_naam");
				String categorie_omschrijving = dbResultSet.getString("categorie_omschrijving");
				String categorie_plaatje = dbResultSet.getString("categorie_plaatje");
		        
				Categorie newCategorie = new Categorie(categorie_id, categorie_naam, categorie_omschrijving, categorie_plaatje);

				results.add(newCategorie);
			}
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public List<Categorie> findAll() {
		return selectCategories("SELECT categorie_id, categorie_naam, categorie_omschrijving, categorie_plaatje FROM Categorie");
	}
	
	public Categorie findById(int code){
		return selectCategories("SELECT categorie_id, categorie_naam, categorie_omschrijving, categorie_plaatje FROM Categorie where categorie_id = " + code).get(0);
	}
}