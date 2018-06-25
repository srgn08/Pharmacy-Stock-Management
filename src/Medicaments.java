
public class Medicaments {
	/**
	 * there are 5 variables 
	 * create getter, setter and constructor
	 */
	
	private String medicament_name;
	private String social_security;
	private String effective_date;
	private String expiry_date;
	private double price;
	public String getMedicament_name() {
		return medicament_name;
	}
	public void setMedicament_name(String medicament_name) {
		this.medicament_name = medicament_name;
	}
	public String getSocial_security() {
		return social_security;
	}
	public void setSocial_security(String social_security) {
		this.social_security = social_security;
	}
	public String getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Medicaments(String medicament_name, String social_security,
			String effective_date, String expiry_date, double price) {
		this.medicament_name = medicament_name;
		this.social_security = social_security;
		this.effective_date = effective_date;
		this.expiry_date = expiry_date;
		this.price = price;
	}
	public Medicaments() {
	}
		
}
