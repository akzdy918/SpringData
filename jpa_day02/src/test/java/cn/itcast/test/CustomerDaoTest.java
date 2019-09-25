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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne(){
        Customer customer = customerDao.findOne(3l);
        System.out.println(customer);
    }

    /**
     * save:更新或则保存
     *         根据传递的对象是否存在主键id,
     *         如果没有id属性，保存
     *         存在id属性，根据id查询数据，跟新数据
     */
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("黑马程序员");
        customer.setCustLevel("vip");
        customer.setCustIndustry("it教育");
        customerDao.save(customer);
    }

    // 更新
    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setCustId(3l);
        customer.setCustName("传智播客");
        customerDao.save(customer);
    }
    // 删除
    @Test
    public void testDelete(){
        customerDao.delete(2l);
    }
    // 查询所有
    @Test
    public void testFindAll(){
        List<Customer> list = customerDao.findAll();
        System.out.println(list);
    }
    // 统计总数
    @Test
    public void testCount(){
        long count = customerDao.count();
        System.out.println(count);
    }
    // 某数据是否存在
    @Test
    public void testExists(){
        boolean exists = customerDao.exists(4l);
        System.out.println(exists
        );
    }


    /**
     * 延迟加载
     */
    @Test
    @Transactional
    public void testGetOne(){
        Customer customer = customerDao.getOne(1l);
        System.out.println(customer);
    }


}