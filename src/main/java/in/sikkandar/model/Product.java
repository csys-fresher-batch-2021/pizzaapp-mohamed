package in.sikkandar.model;

public class Product {
	private Integer id;
	private String name;
	private String price;

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ",price=" + price + "]";
	}

	public Product(Integer id, String name, String price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;

	}

	public Integer getid() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getprice() {
		return price;
	}

}
