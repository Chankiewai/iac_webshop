package nl.hu.iac.webshop.model;

public class ServiceProvider {
	private static WebshopService webshopService = new WebshopService();

	
	public static WebshopService getWebshopService() {
		return webshopService;
	}
}