package cn.nsu.edu.estore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.nsu.edu.estore.domain.NodeDate;
import cn.nsu.edu.estore.domain.Product;
import cn.nsu.edu.estore.utils.DataSourceUtils;

public class ProductDaoImp implements ProductDao {
    //商品添加
    public void addProduct(Product product) throws SQLException {
        String sql = "insert into products values(null,?,?,?,?,?,?,?)";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        runner.update(sql, product.getName(), product.getPrice(),product.getPnum(),
                product.getC3code(), product.getImgurl(), product.getDescription(), product.getColor());
    }

    //查询所有商品信息
    public List<Product> findAll() throws SQLException {
        String sql = "select * from products ";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class));
    }

    //通过id查找唯一商品
    public Product findById(int id) throws SQLException {
        String sql = "select * from products where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new   BeanHandler<Product>(Product.class), id);
    }

    //编辑商品信息
    public void update(Product p) throws SQLException {
        String sql = "update products set name=?,price=?,pnum=?,c3code=?,"
                + "imgurl=?,description=?,color=? where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, p.getName(), p.getPrice(), p.getPnum(), p.getC3code(),
                p.getImgurl(), p.getDescription(), p.getColor(), p.getId());
    }

    //按条件查询
    /*field为字段名称、msg为为字段值*/
    public List<Product> simpleSelect(String field, String msg) throws SQLException {
        String sql = "select * from products where " + field + " like ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class), "%" + msg + "%");
    }

    //分页查询
    /*pageNum为页码，currentPage为每页条数*/
    public List<Product> findByPage(int pageNum, int currentPage) throws SQLException {
        String sql = "select * from products limit ?,?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class),
                (pageNum - 1) * currentPage, currentPage);
    }

    //得到所有页码
    public int findAllCount() throws SQLException {
        String sql = "select count(*) from products";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        long count = (long) runner.query(sql, new ScalarHandler());
        return (int) count;
    }

    //得到所属分类的页码
    public int findCountByCode(String code) throws SQLException {
        String sql = "select count(*) from products where substring(c3code,1,"+code.length()+")"+"=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        long count = (long) runner.query(sql, new ScalarHandler(), code);
        return (int) count;
    }

    //删除单个商品信息
    public int delById(int id) throws SQLException {
        String sql = "delete from products where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int i =	runner.update(sql, id);
        return i;
    }

    //批量删除商品信息
    public void delSelect(int[] id) throws SQLException {
        String sql = "delete from products where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Object[][] ids = new Object[id.length][1];
        for (int i = 0; i < id.length; i++) {
            ids[i][0] = id[i];//一维数组变成 二维数组batch方法的执行
        }

        runner.batch(sql, ids);
    }

    //根据所传值得到在该分类的商品
    public List<Product> findByCode(String code) throws SQLException {
        String sql = "select * from products where substring(c3code,1,"+code.length()+")"+"=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class), code);
    }

    public List<Product> findByPageByCode(int pageNum, int currentPage, String code) throws SQLException {
        String sql = "select * from products where substring(c3code,1,"+code.length()+")"+"=? limit ?,?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class), code,
                (pageNum - 1) * currentPage, currentPage);
    }


}
