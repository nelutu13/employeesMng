package eu.isdc.employeesMng.model;

public class User {

	private Integer id;
	private String number;
	private String name;
	private String age;
	private String language;
	private String creditCard;
	
	public User(String number, String name) {
		this.number = number;
		this.name = name;
		this.id = 0;
		this.creditCard = "Not set";
		this.age = "Not set";
		this.language = "Not set";
		//this.id = new Random(Rand(1000000));
		//this.creditCard = String.toString(new Random(Rand(1000000)));
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getCreditCard() {
		return creditCard;
	}

}