package model;

import javax.persistence.*;

@Entity
public class Tower {
	
	@Id
	private int id;
	private String name;
	private Double height;
	private int sides;
	
	@ManyToOne
	@JoinColumn(name="siteId")
	private Site site;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	public Tower(int id, String name, Double height, int sides, Site site) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
	}
	public Tower() {
		super();
	}
	
	
	

}
