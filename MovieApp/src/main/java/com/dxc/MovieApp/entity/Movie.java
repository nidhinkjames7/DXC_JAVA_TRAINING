package com.dxc.MovieApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movieinfo")
public class Movie 
{
	
	@Column(name = "mid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "mname", nullable = true, length = 255)
	private String name;

	@Column(name = "mrating", nullable = true, length = 255)
	private String rating;

	@Column(name = "mcategory", nullable = true, length = 255)
	private String category;

	@Column(name = "mtype", nullable = true, length = 255)
	private String type;
	
	@Column (name="mduration", nullable = true, length=255)
	private String duration;

	public Movie(Integer id, String name, String rating, String category, String type, String duration) 
	{
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.category = category;
		this.type = type;
		this.duration = duration;
	}
	
	public Movie()
	{
		super();
		
	}
	
	public String toString() {
		return "Movie\n{\nid: " + id + "\nname: " + name + "\nrating: " + rating +
				"\ncategory: " + category + "\ntype: "+ type + "\nduration:"+duration+"\n}";
	}

}
