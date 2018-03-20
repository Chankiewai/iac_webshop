
package nl.hu.iac.webshop.soap.acceptgiro.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the acceptgiro.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DoAcceptgiro_QNAME = new QName("http://service.acceptgiro/", "doAcceptgiro");
    private final static QName _DoAcceptgiroResponse_QNAME = new QName("http://service.acceptgiro/", "doAcceptgiroResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: acceptgiro.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoAcceptgiro }
     * 
     */
    public DoAcceptgiro createDoAcceptgiro() {
        return new DoAcceptgiro();
    }

    /**
     * Create an instance of {@link DoAcceptgiroResponse }
     * 
     */
    public DoAcceptgiroResponse createDoAcceptgiroResponse() {
        return new DoAcceptgiroResponse();
    }

    /**
     * Create an instance of {@link Acceptgiro }
     * 
     */
    public Acceptgiro createAcceptgiro() {
        return new Acceptgiro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoAcceptgiro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.acceptgiro/", name = "doAcceptgiro")
    public JAXBElement<DoAcceptgiro> createDoAcceptgiro(DoAcceptgiro value) {
        return new JAXBElement<DoAcceptgiro>(_DoAcceptgiro_QNAME, DoAcceptgiro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoAcceptgiroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.acceptgiro/", name = "doAcceptgiroResponse")
    public JAXBElement<DoAcceptgiroResponse> createDoAcceptgiroResponse(DoAcceptgiroResponse value) {
        return new JAXBElement<DoAcceptgiroResponse>(_DoAcceptgiroResponse_QNAME, DoAcceptgiroResponse.class, null, value);
    }

}
