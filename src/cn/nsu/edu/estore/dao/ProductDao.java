package cn.nsu.edu.estore.dao;

import java.sql.SQLException;
import java.util.List;

import cn.nsu.edu.estore.domain.NodeDate;
import cn.nsu.edu.estore.domain.Product;

public interface ProductDao {
    //商品添加
    public void addProduct(Product product) throws SQLException;

    //删除单个商品信息
    public int delById(int id) throws SQLException;

    //批量删除勾选的客户信息
    public void delSelect(int[] id) throws SQLException;

    //查询所有商品信息
    public List<Product> findAll() throws SQLException;

    //通过id查找唯一商品  编辑商品信息
    public Product findById(int id) throws SQLException;
    public void update(Product p) throws SQLException;

    //按条件查询
    public List<Product> simpleSelect(String field, String msg) throws SQLException;

    //分页查询
    public List<Product> findByPage(int pageNum, int currentPage) throws SQLException;

    //得到所有页码
    public int findAllCount() throws SQLException;

    //得到所属分类的页码
    public int findCountByCode(String code) throws SQLException;

    //根据所传值得到在该分类的商品
    public List<Product> findByCode(String code) throws SQLException;

}
