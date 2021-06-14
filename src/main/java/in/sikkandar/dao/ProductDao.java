package in.sikkandar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sikkandar.exception.DBException;
import in.sikkandar.model.Product;
import in.sikkandar.util.ConnectionUtil;

public class ProductDao {
	private ProductDao() {

	}

	public static void addProduct(Product product) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();

			String sql = "insert into addproduct(productid,productname,productprice) values(?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setInt(1, product.getId());
			pst.setString(2, product.getName());
			pst.setFloat(3, product.getPrice());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add Product");
		} finally {
			ConnectionUtil.close(connection, pst);

		}

	}

	public static void deleteProduct(int productId, String productName) {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "DELETE FROM addproduct WHERE productId= ? and productName= ? ;";

			// Execute Query
			pst = connection.prepareStatement(sql);

			pst.setInt(1, productId);
			pst.setString(2, productName);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to delete Product");
		} finally {

			ConnectionUtil.close(connection, pst);
		}

	}

	public static List<Product> getProduct() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		List<Product> products = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select * from addproduct";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				Product product = new Product();

				int productId = result.getInt("productId");
				String productName = result.getString("productName");
				float productPrice = result.getFloat("productPrice");

				product.setId(productId);
				product.setName(productName);
				product.setPrice(productPrice);

				products.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Show List");
		} finally {
			ConnectionUtil.close(connection, pst);

		}
		return products;
	}

}
