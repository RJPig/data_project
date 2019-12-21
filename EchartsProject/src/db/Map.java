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
			Statement statement3 = conn.createStatement();

			//制作地图sql语句
			String sql = "select province,sum(viewnum) from map group by province";
			//制作序列分析视图分析sql语句
			String sql2 = "select date,A,B,C,D,E from abcde order by date asc";
			//散点图
			String sql3 = "select medium,type,sum(viewnum),sum(finsh) from map group by medium,type";			
			//获取并显示结果
			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);
			ResultSet rs3 = statement3.executeQuery(sql3);
			//sql1
			JsonArray provincejson = new JsonArray();//省份
			JsonArray viewnumjson = new JsonArray();//访问量/根据省
			//sql2
			JsonArray datejson = new JsonArray();//日期
			JsonArray a = new JsonArray();//媒介a
			JsonArray b = new JsonArray();//媒介b
			JsonArray c = new JsonArray();//媒介c
			JsonArray d = new JsonArray();//媒介d
			JsonArray e = new JsonArray();//媒介e
			//sql3
			JsonArray typejson = new JsonArray();//类型
			JsonArray mediumjson = new JsonArray();//媒介
			JsonArray typeviewnum = new JsonArray();//访问量/根据类型
			JsonArray finshjson=new JsonArray();//完成量
			
			JsonObject jsonObject = new JsonObject();//json文件
			
			
			while(rs.next()) {
				provincejson.add(rs.getString(1));//第一条sql语句将访问到的数据放入
				viewnumjson.add(rs.getInt(2));
			}
			
			
			while(rs2.next()) {
				datejson.add(rs2.getString(1));//第二条sql语句-日期
				a.add(rs2.getString(2));//媒介A
				b.add(rs2.getString(3));//媒介B
				c.add(rs2.getString(4));//媒介C
				d.add(rs2.getString(5));//媒介D
				e.add(rs2.getString(6));//媒介E

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
