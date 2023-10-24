package com.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "MOVIES")
public class Movie {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
  @Column(name = "RANK")
	private long rank;
	
  @Column(name = "TITLE")
	private String title;
	
  @Column(name = "TYPE")
	private String type;
	
  @Column(name = "RUNNING_TIME")
	private String runningTime;
	
  @Column(name = "RATING")
	private String rating;
	
  @Column(name = "YEAR")
	private int year;

	public Movie() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}