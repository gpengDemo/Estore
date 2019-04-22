package cn.nsu.edu.estore.service;

import java.sql.SQLException;
import java.util.List;

import cn.nsu.edu.estore.dao.ProductDaoImp;
import cn.nsu.edu.estore.domain.PageBean;
import cn.nsu.edu.estore.domain.Product;
import cn.nsu.edu.estore.exception.RegistException;

public class ProductService {
    ProductDaoImp dao = new ProductDaoImp();

    //添加商品
    public void add(Product product) throws SQLException  {
        dao.addProduct(product);
    }

    //查询所有商品信息
    public List<Product> findAll() throws SQLException {
        return dao.findAll();
    }

    //通过id查找唯一商品
    public Product findById(int id) throws SQLException {
        return dao.findById(id);
    }

    //修改产品信息
    public void update(Product product) throws SQLException {
        dao.update(product);
    }

    //按条件查询
    public List<Product> simpleSelect(String field, String msg) throws SQLException {
        return dao.simpleSelect(field, msg);
    }

    //分页查询
    public PageBean findByPage(int pageNum, int currentPage) {
        PageBean pb = new PageBean();
        try {
            List<Product> pro = dao.findByPage(pageNum, currentPage);

            // 查询总条数:
            int totalCount = dao.findAllCount();

            // 得到总页数
            int totalPage = (int) Math.ceil(totalCount * 1.0 / currentPage);

            pb.setTotalCount(totalCount); // 封装总条数
            pb.setTotalPage(totalPage);// 封装总页数
            pb.setPro(pro);// 封装当前页数据.
            pb.setCurrentPage(currentPage); // 封装每页条数
            pb.setPageNum(pageNum);// 封装当前页码

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pb;
    }

    //得到所有页码
    public int findAllCount() throws SQLException {
        return dao.findAllCount();
    }

    //删除单个数据
    public void delete(int id) throws SQLException {
        dao.delById(id);
    }

    //删除选中数据
    public void delSelect(int[] id) throws SQLException {
        dao.delSelect(id);
    }

    //根据所传值得到在该分类的商品
    public List<Product> findByCode(String code) throws SQLException {
        return dao.findByCode(code);
    }

    public PageBean findByPageByCode(int pageNum, int currentPage, String code) {
        PageBean pb = new PageBean();
        try {
            List<Product> pro = dao.findByPageByCode(pageNum, currentPage, code);

            // 查询总条数:
            int totalCount = dao.findCountByCode(code);

            // 得到总页数
            int totalPage = (int) Math.ceil(totalCount * 1.0 / currentPage);

            pb.setTotalCount(totalCount); // 封装总条数
            pb.setTotalPage(totalPage);// 封装总页数
            pb.setPro(pro);// 封装当前页数据.
            pb.setCurrentPage(currentPage); // 封装每页条数
            pb.setPageNum(pageNum);// 封装当前页码

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return pb;
    }

}
