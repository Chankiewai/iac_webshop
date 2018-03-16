package nl.hu.iac.webshop.model;

public class ServiceProvider {
	private static WebshopService webshopService = new WebshopService();
	private static WebshopServiceKlanten webshopServiceKlanten = new WebshopServiceKlanten();
	
	public static WebshopService getWebshopService() {
		return webshopService;
	}
	public static WebshopServiceKlanten getWebshopServiceKlanten() {
		return webshopServiceKlanten;
	}
}