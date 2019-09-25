package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 符合springdatakpa的dao接口规范
 *      JpaRepository<操作的实体类,实体类主键属性类型>
 *          * 封装了基本CRUD操作
 *      JpaSpecificationExecutor<操作的实体类类型>
 *          * 封装了复杂擦查询（分页查询）
 *
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {

    /**
     * jpql
     * @param custName
     * @return
     */
    @Query(value = "from Customer where custName = ?")
    public Customer findJpql(String custName);

    /**
     * 多个占位符
     *      默认情况下占位符要和参数位置一致
     *      可以指定占位符参数的位置
     *              ? 索引的方式，指定此占位的取值来源
     * @param name
     * @param id
     * @return
     */
    @Query(value = "from Customer where custName = ?2 and custId = ?1")
    public Customer findCustNameAndId(Long id,String name);
}
