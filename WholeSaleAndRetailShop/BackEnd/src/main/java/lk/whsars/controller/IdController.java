package lk.whsars.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/IdContoller")
public class IdController {
//    public static String getLastID(String tableName, String colName) throws SQLException, ClassNotFoundException {
//        String sql = "select " + colName + " from " + tableName + " order by 1 desc limit 1";
//        Connection conn = DBConnection.getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            return rst.getString(1);
//        }
//        return null;
//    }
}

