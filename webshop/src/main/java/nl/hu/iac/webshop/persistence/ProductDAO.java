package nl.hu.iac.webshop.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.iac.webshop.model.Categorie;
import nl.hu.iac.webshop.model.Product;

public class ProductDAO extends BaseDAO {
	
	private CategorieDAO categorieDAO = new CategorieDAO();
	private List<Product> selectProducts(String query) {
		List<Product> results = new ArrayList<Product>();
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				int product_id = dbResultSet.getInt("product_id");
				String product_naam = dbResultSet.getString("product_naam");
				String product_omschrijving = dbResultSet.getString("product_omschrijving");
				double product_prijs = dbResultSet.getDouble("product_prijs");
				String product_plaatje = dbResultSet.getString("product_plaatje");
				
				int categorie_id = dbResultSet.getInt("categorie_id");
		        Categorie categorie = categorieDAO.findById(categorie_id);
		        
				Product newProduct = new Product(product_id, product_naam, product_omschrijving, product_prijs, product_plaatje);
				
				newProduct.setCategorie(categorie);
				results.add(newProduct);
			}
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return results;
	}
	
	public List<Product> findAll() {
		return selectProducts("SELECT product_id, product_naam, product_omschrijving, product_prijs, product_plaatje, categorie_id FROM product");
	}
	
	public Product findById(int code){
		return selectProducts("SELECT product_id, product_naam, product_omschrijving, product_prijs, product_plaatje, categorie_id FROM product where product_id = " + code).get(0);
	}
	
	public Product updateProduct(Product p) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			
			String updateProduct = "UPDATE product SET product_id = " + p.getProductId() + ", product_omschrijving = '" + p.getProductOmschrijving() + "', product_prijs = " + p.getProductPrijs() + ", product_plaatje = '" + p.getProductPlaatje() + "', categorie_id = " + p.getCategorie().getCategorieId() + " WHERE product_id = " + p.getProductId() + "";
			stmt.executeUpdate(updateProduct);
			
		} catch (SQLException sqle) { sqle.printStackTrace(); }
		return p;
	}
	
	public Product productToevoegen(Product product) {
		try (Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			String query = "INSERT INTO product(product_naam, product_omschrijving, product_prijs, product_plaatje, categorie_id) VALUES ('" + product.getProductNaam() + "', '" + product.getProductOmschrijving() + "', " + product.getProductPrijs() + " ,'" + product.getProductPlaatje() + "', 1)";
			stmt.executeUpdate(query);
			
			System.out.println("Product is toegevoegd!");

		} catch (SQLException sqle) { sqle.printStackTrace(); System.out.println("Er is iets mis gegaan!"); }
		return product;
	}
}