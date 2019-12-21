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
@WebServlet("/Map")
public class Map extends HttpServlet {
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

			//������ͼsql���
			String sql = "select province,sum(viewnum) from map group by province";
			//�������з�����ͼ����sql���
			String sql2 = "select date,A,B,C,D,E from abcde order by date asc";
			//ɢ��ͼ
			String sql3 = "select medium,type,sum(viewnum),sum(finsh) from map group by medium,type";			
			//��ȡ����ʾ���
			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);
			ResultSet rs3 = statement3.executeQuery(sql3);
			//sql1
			JsonArray provincejson = new JsonArray();//ʡ��
			JsonArray viewnumjson = new JsonArray();//������/����ʡ
			//sql2
			JsonArray datejson = new JsonArray();//����
			JsonArray a = new JsonArray();//ý��a
			JsonArray b = new JsonArray();//ý��b
			JsonArray c = new JsonArray();//ý��c
			JsonArray d = new JsonArray();//ý��d
			JsonArray e = new JsonArray();//ý��e
			//sql3
			JsonArray typejson = new JsonArray();//����
			JsonArray mediumjson = new JsonArray();//ý��
			JsonArray typeviewnum = new JsonArray();//������/��������
			JsonArray finshjson=new JsonArray();//�����
			
			JsonObject jsonObject = new JsonObject();//json�ļ�
			
			
			while(rs.next()) {
				provincejson.add(rs.getString(1));//��һ��sql��佫���ʵ������ݷ���
				viewnumjson.add(rs.getInt(2));
			}
			
			
			while(rs2.next()) {
				datejson.add(rs2.getString(1));//�ڶ���sql���-����
				a.add(rs2.getString(2));//ý��A
				b.add(rs2.getString(3));//ý��B
				c.add(rs2.getString(4));//ý��C
				d.add(rs2.getString(5));//ý��D
				e.add(rs2.getString(6));//ý��E

			}
			
			
			while(rs3.next()) {
				mediumjson.add(rs3.getString(1));
				typejson.add(rs3.getString(2));
				typeviewnum.add(rs3.getInt(3));
				finshjson.add(rs3.getInt(4));
			}
			
			//sql1
			jsonObject.add("province",provincejson);
			jsonObject.add("viewnum",viewnumjson);
			//sql2
			jsonObject.add("date",datejson);
			jsonObject.add("mediuma",a);
			jsonObject.add("mediumb",b);
			jsonObject.add("mediumc",c);
			jsonObject.add("mediumd",d);
			jsonObject.add("mediume",e);
			//sql3
			jsonObject.add("allmedium", mediumjson);
			jsonObject.add("type", typejson);
			jsonObject.add("typeviewnum",typeviewnum);
			jsonObject.add("finsh",finshjson);

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
