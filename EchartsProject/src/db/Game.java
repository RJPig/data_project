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
//			Statement statement3 = conn.createStatement();

			//柱状图
			String sql = "select type,`limit`,continuetime from gametable";
//			//趋势图
			String sql2 = "select type,date,count(date),sum(hp),`limit` from gametable group by date";
//			//散点图
//			String sql3 = "select medium,type,sum(viewnum),sum(finsh) from map group by medium,type";			
//			//获取并显示结果
			ResultSet rs = statement.executeQuery(sql);
			ResultSet rs2 = statement2.executeQuery(sql2);
//			ResultSet rs3 = statement3.executeQuery(sql3);
			//sql1
			JsonArray typejson = new JsonArray();//类型
			JsonArray limitjson = new JsonArray();//界限标记
			JsonArray timejson = new JsonArray();//持续时间


			//sql2
			JsonArray type2json = new JsonArray();
			JsonArray datejson = new JsonArray();//日期
			JsonArray cdatejson = new JsonArray();//记录数
			JsonArray hpjson = new JsonArray();//生命消耗值
			JsonArray limit2json = new JsonArray();//生命消耗值

			
			JsonObject jsonObject = new JsonObject();//json文件
			
			
			while(rs.next()) {
				typejson.add(rs.getString(1));//第一条sql语句将访问到的数据放入
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
