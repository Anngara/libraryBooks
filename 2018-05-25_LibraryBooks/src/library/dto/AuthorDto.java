package library.dto;

import library.entities.Author;

public class AuthorDto {
	public String name;
	public String country;
	
	
	
	public AuthorDto() {
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	public AuthorDto(String name, String country) {
		this.name = name;
		this.country = country;
	}
	@Override
	public String toString() {
		return "AuthorDto [name=" + name + ", country=" + country + "]";
	}
	
	public Author getAuthor () {
		return new Author (name, country);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
