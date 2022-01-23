package top.liuup.springdemo.dao;

import com.alibaba.fastjson.JSON;
import top.liuup.springdemo.pojo.Brand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;


public class Database {
    private final String url = "jdbc:mysql://localhost:3306/temp";
    private final String user = "admin";
    private final String password = "123698745leo";


    public String queryDataById(int id) throws Exception{

        Connection conn = DriverManager.getConnection(url, user, password);


        String sql = "select * from tb_brand where id = ?;";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        Brand brand = null;

        if(rs.next()) {
            brand = new Brand(rs.getInt("id"), rs.getString("brand_name"),
                    rs.getString("company_name"), rs.getInt("ordered"),
                    rs.getString("description"), rs.getInt("status"));

        }


//        System.out.println(brand);

        rs.close();
        pstmt.close();
        conn.close();

        return JSON.toJSONString(brand);
    }

}
