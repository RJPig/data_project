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

			//矩形树图
			String sql = "select type,date,visit from webtable group by type,date order by date";
//			//散点图
			String sql2 = "select type,page,(sum(time)/sum(people)),sum(visit),sum(people) from webtable group by type";
//			//柱状图
			String sql3 = "select type,page,sum(visit),sum(`exit`),sum(time) from webtable group by type,page order by sum(visit) DESC";			
//			//获取并显示结果
			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);
			ResultSet rs3 = statement3.executeQuery(sql3);
			//sql1
			JsonArray typejson = new JsonArray();//网站版块
			JsonArray datejson = new JsonArray();//日期
			JsonArray visitjson = new JsonArray();//持续时间


			//sql2
			JsonArray type2json = new JsonArray();//网站版块
			JsonArray timejson = new JsonArray();//浏览时长
			JsonArray pagejson = new JsonArray();//页面
			JsonArray visit2json = new JsonArray();//网页访问量
			JsonArray peoplejson = new JsonArray();//访问人数

			//sql3
			JsonArray type3json = new JsonArray();//网站版块
			JsonArray page3json = new JsonArray();//页面
			JsonArray visit3json = new JsonArray();//网页访问量
			JsonArray exitjson = new JsonArray();//退出数
			JsonArray time3json = new JsonArray();//浏览时长
			
			JsonObject jsonObject = new JsonObject();//json文件
			
			
			while(rs.next()) {
				typejson.add(rs.getString(1));//第一条sql语句将访问到的数据放入
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
