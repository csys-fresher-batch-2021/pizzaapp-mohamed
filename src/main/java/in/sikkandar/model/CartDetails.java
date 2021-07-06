package in.sikkandar.model;

public class CartDetails {

	public CartDetails() {
	}

	private Integer id;
	private User user;
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartDetails [id=" + id + ", user=" + user + ", product=" + product + "]";
	}
}
