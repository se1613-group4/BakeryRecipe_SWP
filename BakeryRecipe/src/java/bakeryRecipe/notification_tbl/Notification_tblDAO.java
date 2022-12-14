package bakeryRecipe.notification_tbl;

import bakeryRecipe.utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LamVo
 */
public class Notification_tblDAO implements Serializable{



    public ArrayList<Notification_tblDTO> getListNoti(int usId) throws SQLException {
       ArrayList<Notification_tblDTO> ls = null;
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "select * from notification_tbl where user_id=?";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, usId);
                //4. execute query
                rs = stm.executeQuery();
                //5 process result
                while (rs.next()) {
                  if(ls == null){
                      ls = new ArrayList<Notification_tblDTO>();
                  }
                  ls.add(new Notification_tblDTO(rs.getInt("noti_id"),rs.getInt("user_id"),rs.getString("detail"),rs.getDate("created_date")));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
          return ls ;
    }
    public int setNoti(int usId,String sms) throws SQLException {
        int rslt = 0;
        Connection connection = null;
        PreparedStatement stm = null;
        
        try {
            //1. make connection
            connection = DBConnection.getConnection();
            if (connection != null) {
                //2. create sql string
                String sql = "INSERT INTO `bakery_recipe`.`notification_tbl` (`user_id`, `detail`, `created_date`) VALUES (?, ?, curdate()); ";
                //3. create statement obj
                stm = connection.prepareStatement(sql); // tao ra obj rong
                stm.setInt(1, usId);
                stm.setString(2, sms);
                //4. execute query
                rslt = stm.executeUpdate();
                //5 process result
              
            }
        } finally {
           
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
       return rslt;
    }
}
