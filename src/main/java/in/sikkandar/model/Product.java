package in.sikkandar.model;

/**
 * product variables in private
 * 
 * @author moha2636
 *
 */
public class Product {
	private Integer id;
	private String name;
	private Float price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product(Integer id, String name, Float price) {
		super();

		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
		// Default Constructor
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * set a to-string
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}