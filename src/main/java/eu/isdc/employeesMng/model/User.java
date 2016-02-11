package eu.isdc.employeesMng.model;

public class User {

	private Integer id;
	private String userNumber;
	private String userFullName;
	private String email;
	private String city;
	private String password;
	private String notes;
	private Integer age;
	private String address;
	private String creditCardNumber;
	
	public User() {

	}

	public User(

			int id,
			String userNumber,
			String userFullName,
			String email,
			String city,
			String password,
			String notes,
			int age,
			String address,
			String creditCardNumber) {
		
		this.id = id;
		this.userNumber = userNumber;
		this.userFullName = userFullName;
		this.email = email;
		this.city = city;
		this.password = password;
		this.notes = notes;
		this.age = age;
		this.address = address;
		this.creditCardNumber = creditCardNumber;

	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	
	public String getUserNumber() {
		return userNumber;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	public String getUserFullName() {
		return userFullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

}

//CREATE TABLE users (
//		
//		id INT NOT NULL AUTO_INCREMENT,
//		user_number varchar(9), 
//		user_full_name VARCHAR(50) NOT NULL,
//		email VARCHAR(80) NOT NULL,
//	    city VARCHAR(30) NULL,
//		password CHAR(41) NOT NULL,
//	    notes TEXT NULL,
//		age INT(3),
//	    address VARCHAR(80) NOT NULL,
//		credit_card_number varchar(16), 
//
//		PRIMARY KEY (id),
//		UNIQUE (email),
//		UNIQUE (user_number)
//		
//	) ENGINE=INNODB;
//
//
//
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '473648793', 'Ion Marcu', 'ion.mnarcu@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '1758493096423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '474646593', 'Marius Marcu', 'marius.marcu@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '3758443095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '473615593', 'Ion Budisteanu', 'ion.budisteanu@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '5758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '173648193', 'Marcela Anca', 'marcela.anca@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '6758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '273648193', 'Barbu Delavrancea', 'barbu.delavrancea@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '7758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '773648293', 'Alina Plugaru', 'alina.plugaru@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '3758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '273642393', 'Marian Voda', 'marian.voda@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '9758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '873648393', 'Paula Mirescu', 'paula.mirescu@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '2758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '973648493', 'Anca Blagiu', 'anca.blagiu@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '4758493095423189');
//	insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//		values (NULL, '373628593', 'Ionut Sigmirean', 'ionut.sigmirean@email.com', 'Mures', 'parolamea', 'Este agile', 24, 'Strada bulevard', '1758493095423189');

//insert into users (id, user_number, user_full_name, email, city, password, notes, age, address, credit_card_number) 
//values (NULL, '123456789', 'Riga Cripton', 'riga.cripton@email.com', 'city', 'passat', 'no ten', 99, 'Strada de strada', '1234567890123456');
//		