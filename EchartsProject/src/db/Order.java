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
	//��������
	Connection conn;
	//����������
	String driver="com.mysql.jdbc.Driver";
	//URLָ����ʵ����ݿ�
	String url = "jdbc:mysql://localhost:3306/demo";
	//Mysql�û���
	String user = "root";
	//mysql����
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
		response.setCharacterEncoding("utf-8");//����
		PrintWriter out=response.getWriter();
		try {
			//��������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) {
				System.out.println("���ӳɹ�!���ڻ�ȡ��Ϣ!");
			}
			//ִ��sql���
			Statement statement = conn.createStatement();
			Statement statement2 = conn.createStatement();


			//����ɢ��ͼ
			String sql = "select age,orderdate,sale from ordertable";
			String sql2 = "select city,ordertype,sum(profit) from ordertable group by ordertype,city";

			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);

//sql1			
			JsonArray orderdatejson = new JsonArray();//��������
			JsonArray salejson = new JsonArray();//���۶�
			JsonArray agejson = new JsonArray();//�����

//sql2

			JsonArray cityjson = new JsonArray();
			JsonArray ordertypejson = new JsonArray();
			JsonArray profitjson = new JsonArray();
			
			JsonObject jsonObject = new JsonObject();//json�ļ�
			
//sql1			
			while(rs.next()) {
				agejson.add(rs.getString(1));//��һ��sql��佫���ʵ������ݷ���
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
			System.out.println("���ݿ�����������쳣!");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("���ݿ��ȡ��Ϣ�ɹ�!");
		}
		
	}

}
