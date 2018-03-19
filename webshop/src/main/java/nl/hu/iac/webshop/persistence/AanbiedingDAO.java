package nl.hu.iac.webshop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import nl.hu.iac.webshop.model.Product;
import nl.hu.iac.webshop.model.Aanbieding;

public class AanbiedingDAO extends BaseDAO {
	private ProductDAO productDAO = new ProductDAO();
	private List<Aanbieding> selectAanbiedingen(String query) {
		List<Aanbieding> results = new ArrayList<Aanbieding>();
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int aanbieding_id = dbResultSet.getInt("aanbieding_id");
				String van_datum_String = dbResultSet.getString("van_datum");
		        LocalDate van_datum = LocalDate.parse(van_datum_String);
				String tot_datum_String = dbResultSet.getString("tot_datum");	
				LocalDate tot_datum = LocalDate.parse(tot_datum_String);
				double aanbieding_prijs = dbResultSet.getDouble("aanbieding_prijs");
				int product_id = dbResultSet.getInt("product_id");
				
				Product product = productDAO.findById(product_id);
				
				Aanbieding newAanbieding = new Aanbieding(aanbieding_id, aanbieding_prijs, van_datum, tot_datum);			
				
				newAanbieding.setProduct(product);
				
				results.add(newAanbieding);
			}
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public List<Aanbieding> findAll() {
		return selectAanbiedingen("select aanbieding_id, van_datum, tot_datum, aanbieding_prijs, product_id from aanbieding");
	}
	
	public Aanbieding findById(int code){
		return selectAanbiedingen("select aanbieding_id, van_datum, tot_datum, aanbieding_prijs, product_id from aanbieding where aanbieding_id = " + code).get(0);
	}
}