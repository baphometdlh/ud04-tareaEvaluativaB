package entidades;

import jakarta.persistence.*;

@Embeddable
public class Address {
	
	//Atributos
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipCode;
	
	//Constructores
	public Address() {
		
	}
	
	public Address(String addressLine1, String addressLine2, String city, String zipCode) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipCode = zipCode;
	}	
	
	//ToString
	
	//getters y setters
	@Column (name="address_line_1")
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	@Column (name="address_line_2")
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="zip_code")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
