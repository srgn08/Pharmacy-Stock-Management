
public class Prescription {
	/**
	 * there are 3 variables
	 * create getter, setter and constructor
	 */

	private String name;
	private String social_security;
	private String date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSocial_security() {
		return social_security;
	}
	public void setSocial_security(String social_security) {
		this.social_security = social_security;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * The constructor of prescription
	 * @param name
	 * @param social_security
	 * @param date
	 */
	public Prescription(String name, String social_security, String date) {
		this.name = name;
		this.social_security = social_security;
		this.date = date;
		
	}
	
	public Prescription() {
	}
		
}
