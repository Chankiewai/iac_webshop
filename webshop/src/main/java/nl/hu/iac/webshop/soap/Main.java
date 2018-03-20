package nl.hu.iac.webshop.soap;

import nl.hu.iac.webshop.soap.acceptgiro.service.Acceptgiro;
import nl.hu.iac.webshop.soap.acceptgiro.service.AcceptgiroServiceImpl;
import nl.hu.iac.webshop.soap.acceptgiro.service.AcceptgiroServiceImplService;

public class Main {
    public static void main(String[] args) {
    	AcceptgiroServiceImpl webservice = new AcceptgiroServiceImplService().getAcceptgiroServiceImplPort();
    	Acceptgiro acceptgiro = webservice.doAcceptgiro("Marc", "Daltonlaan 200, Utrecht", 99.99);
    	System.out.println("acceptgiro id: "+ acceptgiro.getId());
    	System.out.println("klantnaam: "+ acceptgiro.getKlantnaam());
    	System.out.println("klantadres: "+ acceptgiro.getKlantadres());
    	System.out.println("acceptgiro bedrag: "+ acceptgiro.getBedrag());
    	System.out.println("acceptgiro uniek getal: "+ acceptgiro.getUniekGetal());
    }
}