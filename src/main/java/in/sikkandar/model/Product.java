package in.sikkandar.model;

public class Product {
	private String id;
	private String name;
	private String price;

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ",price=" + price + "]";
	}

	public Product(String id, String name, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;

	}

	
	public String getName() {
		return name;
	}

	public String getprice() {
		return price;
	}

}
