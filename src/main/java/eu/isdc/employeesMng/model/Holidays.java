package eu.isdc.employeesMng.model;

import java.sql.Date;

public class Holidays {

	private Integer id;
	private Integer userId;
	private Date fromDate;
	private Date toDate;
	private Integer daysTaken;
	private String notes;
	
	public Holidays() {

	}

	public Holidays(

			Integer id,
			Integer userId,
			Date fromDate,
			Date toDate,
			Integer daysTaken,
			String notes) {
		
		this.id = id;
		this.userId = userId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.daysTaken = daysTaken;
		this.notes = notes;

	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public Date getFromDate() {
		return fromDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public Date getToDate() {
		return toDate;
	}

	public void setDaysTaken(Integer daysTaken) {
		this.daysTaken = daysTaken;
	}
	
	public Integer getDaysTaken() {
		return daysTaken;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getNotes() {
		return notes;
	}

}

//CREATE TABLE holidays (
//		
//		id INT NOT NULL AUTO_INCREMENT,
//		user_id INT NOT NULL,
//
//		form_date DATE NOT NULL,
//		to_date DATE NOT NULL,
//		days_taken INT(3) NOT NULL,
//
//	    notes TEXT NULL,
//
//		PRIMARY KEY (id),
//		FOREIGN KEY (user_id) REFERENCES users(id)
//		
//) ENGINE=INNODB;
//
