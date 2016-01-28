package eu.isdc.bsp.model;

public class Account {

	private Integer id;
	private String number;
	private String name;
	private String creditCard;
	
	public Account(String number, String name) {
		this.number = number;
		this.name = name;
		this.id = 0;
		this.creditCard = "Not set";
		//this.id = new Random(Rand(1000000));
		//this.creditCard = String.toString(new Random(Rand(1000000)));
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setNumber() {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}

	public void setName() {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setCreditCard() {
		this.creditCard = creditCard;
	}
	
	public String getCreditCard() {
		return creditCard;
	}
	
}