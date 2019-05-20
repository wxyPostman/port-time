package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBUtil {
	// 驱动名子
	// private final static String driverName = "com.mysql.jdbc.Driver";
	// // 数据库连接地址
	// private final static String url =
	// "jdbc:mysql://localhost:3306/zjweu?useUnicode=true&chanacterEncoding=utf8&useSSL=false";
	// // 数据用户名
	// private final static String username = "root";
	// private final static String password = "123456";

	private static String driverName;
	// 数据库连接地址
	private static String url;
	// 数据用户名
	private static String username;
	private static String password;

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		driverName = resourceBundle.getString("driverName");
		url = resourceBundle.getString("url");
		username = resourceBundle.getString("username");
		password = resourceBundle.getString("password");
	}

	// 更新数据库操作->insert/update/delete
	public int update(String sql, Object... params) {
		int r = 0;
		try {
			getConnection();
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				// 不定参数是被当成数组使用
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);

				}
			}
			r = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
		return r;
	}

	public CachedRowSet query(String sql, Object... params) {
		CachedRowSet cachedRowSet = null;
		try {

			getConnection();

			// 工厂类
			RowSetFactory factory = RowSetProvider.newFactory();
			cachedRowSet = factory.createCachedRowSet();

			// 通过免ai语句生成预编译的操作语句
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数
			if (params != null) {
				// 不定参数是被当成数组使用
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);

				}
			}
			// 设置参数（参数位置，参数值）
			resultSet = preparedStatement.executeQuery();

			cachedRowSet.populate(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cachedRowSet;
	}

	public CachedRowSet queryByPage(String sql, int currentPage, int pageSize, Object... params) {
		getConnection();
		CachedRowSet cachedRowSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i + 1, params[i]);

				}
			}

			resultSet = preparedStatement.executeQuery();
			RowSetFactory factory = RowSetProvider.newFactory();
			cachedRowSet = factory.createCachedRowSet();
			if (pageSize < 1)
				pageSize = 1;
			if (currentPage < 1)
				currentPage = 1;
			cachedRowSet.setPageSize(pageSize);
			cachedRowSet.populate(resultSet, (currentPage - 1) * pageSize + 1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cachedRowSet;
	}

	public void close() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block e•printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		// 不要使用单例
		// Connection资源是最宝贵的，一般来说会占用大多数的操作时间，所以Connection—定要关闭回收。
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			// 事务处理
			// connection.setAutoCommit(false);
			// connection.commit();
			// connection.rollback();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
