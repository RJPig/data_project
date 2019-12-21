package db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 * Servlet implementation class Good
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	//声明对象
	Connection conn;
	//驱动程序名
	String driver="com.mysql.jdbc.Driver";
	//URL指向访问的数据库
	String url = "jdbc:mysql://localhost:3306/demo";
	//Mysql用户名
	String user = "root";
	//mysql密码
	String password = "";
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");//编码
		PrintWriter out=response.getWriter();
		try {
			//加载驱动
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) {
				System.out.println("连接成功!正在获取信息!");
			}
			//执行sql语句
			Statement statement = conn.createStatement();
			Statement statement2 = conn.createStatement();


			//制作散点图
			String sql = "select age,orderdate,sale from ordertable";
			String sql2 = "select city,ordertype,sum(profit) from ordertable group by ordertype,city";

			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);

//sql1			
			JsonArray orderdatejson = new JsonArray();//订单日期
			JsonArray salejson = new JsonArray();//销售额
			JsonArray agejson = new JsonArray();//年龄段

//sql2

			JsonArray cityjson = new JsonArray();
			JsonArray ordertypejson = new JsonArray();
			JsonArray profitjson = new JsonArray();
			
			JsonObject jsonObject = new JsonObject();//json文件
			
//sql1			
			while(rs.next()) {
				agejson.add(rs.getString(1));//第一条sql语句将访问到的数据放入
				orderdatejson.add(rs.getString(2));
				salejson.add(rs.getInt(3));
			}
			
//sql2
			while(rs2.next()) {
				cityjson.add(rs2.getString(1));
				ordertypejson.add(rs2.getString(2));
				profitjson.add(rs2.getInt(3));

			}

			jsonObject.add("age",agejson);
			jsonObject.add("date",orderdatejson);
			jsonObject.add("sale",salejson);


			jsonObject.add("city",cityjson);
			jsonObject.add("ordertype",ordertypejson);
			jsonObject.add("profit", profitjson);
			out.print(jsonObject);
			
		}catch(ClassNotFoundException e) {
			System.out.println("数据库驱动类出现异常!");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("数据库获取信息成功!");
		}
		
	}

}
