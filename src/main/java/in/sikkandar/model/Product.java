package in.sikkandar.model;

public class Product {
	private Integer id;
	private String name;
	
	
	
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	
	

}
