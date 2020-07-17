package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import Util.DBUtil;
import com.mysql.jdbc.Connection;

public class Userdao {
    public boolean isExistEmail(String email) {
        String sql = "select * from tb_user where user_email = ?";
        Connection conn = (Connection) DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet result = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            result = pstmt.executeQuery();

            if(result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void save(String email, String password) {
        String sql = "insert into tb_user(user_email,user_pwd,user_registdate) values(?,?,?)";
        Connection conn = (Connection) DBUtil.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }

    }

    public int login(String email, String password) {
        int userID = 0;
        Connection conn = (Connection) DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select user_id from tb_user where user_email = ? and user_pwd = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            System.out.print("1");
            if(rs.next()){
                System.out.print("6");
                userID = rs.getInt("user_id");
                System.out.print("2");
                System.out.print(userID);
            } else {
                System.out.print("3");
            };
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.print("4");
        }finally {
            DBUtil.closeJDBC(rs, pstmt, conn);
        }
        System.out.print("5");
        return userID;

    }
}
