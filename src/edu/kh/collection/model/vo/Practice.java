package edu.kh.collection.model.vo;

public class Practice {
	
	private String name;
	private String author;
	private String price;
	private String publishingHouse;
	//private boolean fav; 즐겨찾기 
	
	public Practice() {}
	
	
	
	public Practice(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}



	public Practice(String name, String author, String price, String publishingHouse) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.publishingHouse = publishingHouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	@Override
	public String toString() {
		return name + "  " + author + "  " + price + "원  " + publishingHouse;
	}
	
	public String favorite() {
		return name + "  " + author;
	}



	public Practice removeAll(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
