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
@WebServlet("/Web")
public class Web extends HttpServlet {
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
			Statement statement3 = conn.createStatement();

			//������ͼ
			String sql = "select type,date,visit from webtable group by type,date order by date";
//			//ɢ��ͼ
			String sql2 = "select type,page,(sum(time)/sum(people)),sum(visit),sum(people) from webtable group by type";
//			//��״ͼ
			String sql3 = "select type,page,sum(visit),sum(`exit`),sum(time) from webtable group by type,page order by sum(visit) DESC";			
//			//��ȡ����ʾ���
			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);
			ResultSet rs3 = statement3.executeQuery(sql3);
			//sql1
			JsonArray typejson = new JsonArray();//��վ���
			JsonArray datejson = new JsonArray();//����
			JsonArray visitjson = new JsonArray();//����ʱ��


			//sql2
			JsonArray type2json = new JsonArray();//��վ���
			JsonArray timejson = new JsonArray();//���ʱ��
			JsonArray pagejson = new JsonArray();//ҳ��
			JsonArray visit2json = new JsonArray();//��ҳ������
			JsonArray peoplejson = new JsonArray();//��������

			//sql3
			JsonArray type3json = new JsonArray();//��վ���
			JsonArray page3json = new JsonArray();//ҳ��
			JsonArray visit3json = new JsonArray();//��ҳ������
			JsonArray exitjson = new JsonArray();//�˳���
			JsonArray time3json = new JsonArray();//���ʱ��
			
			JsonObject jsonObject = new JsonObject();//json�ļ�
			
			
			while(rs.next()) {
				typejson.add(rs.getString(1));//��һ��sql��佫���ʵ������ݷ���
				datejson.add(rs.getString(2));
				visitjson.add(rs.getInt(3));

			}
			
			while(rs2.next()) {
				type2json.add(rs2.getString(1));
				pagejson.add(rs2.getString(2));
				timejson.add(rs2.getFloat(3));
				visit2json.add(rs2.getInt(4));
				peoplejson.add(rs2.getInt(5));

			}
			
			while(rs3.next()) {
				type3json.add(rs3.getString(1));
				page3json.add(rs3.getString(2));
				visit3json.add(rs3.getFloat(3));
				exitjson.add(rs3.getInt(4));
				time3json.add(rs3.getInt(5));

			}
//sql1
			jsonObject.add("type",typejson);
			jsonObject.add("date",datejson);
			jsonObject.add("visit",visitjson);

//sql2
			jsonObject.add("type2",type2json);
			jsonObject.add("page", pagejson);
			jsonObject.add("time",timejson);
			jsonObject.add("visit2",visit2json);
			jsonObject.add("people",peoplejson);

//sql3
			
			jsonObject.add("type3",type3json);
			jsonObject.add("page3", page3json);
			jsonObject.add("visit3",visit3json);
			jsonObject.add("exit",exitjson);
			jsonObject.add("time3",time3json);
			out.print(jsonObject);
//			conn.close();
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
