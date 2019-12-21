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
@WebServlet("/Game")
public class Game extends HttpServlet {
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
//			Statement statement3 = conn.createStatement();

			//��״ͼ
			String sql = "select type,`limit`,continuetime from gametable";
//			//����ͼ
			String sql2 = "select type,date,count(date),sum(hp),`limit` from gametable group by date";
//			//ɢ��ͼ
//			String sql3 = "select medium,type,sum(viewnum),sum(finsh) from map group by medium,type";			
//			//��ȡ����ʾ���
			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);
//			ResultSet rs3 = statement3.executeQuery(sql3);
			//sql1
			JsonArray typejson = new JsonArray();//����
			JsonArray limitjson = new JsonArray();//���ޱ��
			JsonArray timejson = new JsonArray();//����ʱ��


			//sql2
			JsonArray type2json = new JsonArray();
			JsonArray datejson = new JsonArray();//����
			JsonArray cdatejson = new JsonArray();//��¼��
			JsonArray hpjson = new JsonArray();//��������ֵ
			JsonArray limit2json = new JsonArray();//��������ֵ

			
			JsonObject jsonObject = new JsonObject();//json�ļ�
			
			
			while(rs.next()) {
				typejson.add(rs.getString(1));//��һ��sql��佫���ʵ������ݷ���
				limitjson.add(rs.getString(2));
				timejson.add(rs.getString(3));

			}
			
			while(rs2.next()) {
				type2json.add(rs2.getString(1));
				datejson.add(rs2.getString(2));
				cdatejson.add(rs2.getInt(3));
				hpjson.add(rs2.getInt(4));
				limit2json.add(rs2.getString(5));
			}
//sql1
			jsonObject.add("type",typejson);
			jsonObject.add("limit",limitjson);
			jsonObject.add("time",timejson);

//sql2
			jsonObject.add("type2", type2json);
			jsonObject.add("date",datejson);
			jsonObject.add("cdate",cdatejson);
			jsonObject.add("hp",hpjson);
			jsonObject.add("limit2", limit2json);

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
