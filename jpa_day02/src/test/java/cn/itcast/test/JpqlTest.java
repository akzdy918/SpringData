package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;


    @Test
    public void testFindJPQL(){
        Customer customer = customerDao.findJpql("传智播客");
        System.out.println(customer);
    }

    @Test
    public void testFindCustNameAndId(){
        Customer customer = customerDao.findCustNameAndId(3l,"传智播客");
        System.out.println(customer);
    }

}