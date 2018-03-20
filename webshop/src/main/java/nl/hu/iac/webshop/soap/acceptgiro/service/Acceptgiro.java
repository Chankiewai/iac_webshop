
package nl.hu.iac.webshop.soap.acceptgiro.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acceptgiro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acceptgiro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bedrag" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="klantadres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="klantnaam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uniek_getal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acceptgiro", propOrder = {
    "bedrag",
    "id",
    "klantadres",
    "klantnaam",
    "uniekGetal"
})
public class Acceptgiro {

    protected double bedrag;
    protected int id;
    protected String klantadres;
    protected String klantnaam;
    @XmlElement(name = "uniek_getal")
    protected int uniekGetal;

    /**
     * Gets the value of the bedrag property.
     * 
     */
    public double getBedrag() {
        return bedrag;
    }

    /**
     * Sets the value of the bedrag property.
     * 
     */
    public void setBedrag(double value) {
        this.bedrag = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the klantadres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlantadres() {
        return klantadres;
    }

    /**
     * Sets the value of the klantadres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlantadres(String value) {
        this.klantadres = value;
    }

    /**
     * Gets the value of the klantnaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlantnaam() {
        return klantnaam;
    }

    /**
     * Sets the value of the klantnaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlantnaam(String value) {
        this.klantnaam = value;
    }

    /**
     * Gets the value of the uniekGetal property.
     * 
     */
    public int getUniekGetal() {
        return uniekGetal;
    }

    /**
     * Sets the value of the uniekGetal property.
     * 
     */
    public void setUniekGetal(int value) {
        this.uniekGetal = value;
    }

}
