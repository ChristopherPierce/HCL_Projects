package com.web.store.music_store.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlbumGenre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String artist;	
	private String price;	
	private Date release_date;	
	private String genre_name;
	
	public AlbumGenre() {
		super();
	}
	
	public AlbumGenre(String name, String artist, String price, Date release_date, String genre_name) {
		super();
		this.name = name;
		this.artist = artist;
		this.price = price;
		this.release_date = release_date;
		this.genre_name = genre_name;
	}

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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", artist=" + artist + ", price=" + price + ", release_date="
				+ release_date + ", genre_name=" + genre_name + "]";
	}
	
	
	
	
}