
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naimish
 */
public class test {
 
    
    private static InputStream is;
    private static Properties p;
    public test() {
        
    }
   
    
    public static void main(String[] args) throws IOException {
            test t = new test(); 
            is = t.getClass().getResourceAsStream("my.properties");
            p = new Properties();
             System.out.println(is);
            p.load(is);
            String name = p.getProperty("pass");
            System.out.println(name);
    }
   
}
