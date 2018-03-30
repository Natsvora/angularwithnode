
import com.shooping.db.ConnectionProvider;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {

        Connection con = ConnectionProvider.getCon();
        FileInputStream fin;
        PreparedStatement ps = con.prepareStatement("UPDATE products SET photo = ? WHERE productID = ?");
        for (int i = 100; i <= 111; i++) {
            fin = new FileInputStream("/home/naimish/Downloads/OnlineKart-master/OnlineKart/WebContent/images/small/" + i + ".jpg");
            ps.setBinaryStream(1, fin, fin.available());
            ps.setInt(2, i);
            int i1 = ps.executeUpdate();
            System.out.println(i1 + " records affected");
        }
        con.close();  
    }
}
