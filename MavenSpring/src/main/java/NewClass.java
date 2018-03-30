
import com.argusoft.mavenspring.bean.Att;
import com.argusoft.mavenspring.bean.Dept;
import com.argusoft.mavenspring.bean.Emp;
import com.argusoft.mavenspring.bean.Report;
import com.argusoft.mavenspring.dao.AttDao;
import com.argusoft.mavenspring.dao.DeptDao;
import com.argusoft.mavenspring.dao.EmpDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author naimish
 */
public class NewClass {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        EmpDao dao = (EmpDao) ctx.getBean("edao");
        dao.insert(new Emp(108, "Amit", 35000,"ba"));
    }
}
