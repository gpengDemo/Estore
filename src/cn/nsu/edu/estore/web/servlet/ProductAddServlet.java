package cn.nsu.edu.estore.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.nsu.edu.estore.domain.Product;
import cn.nsu.edu.estore.exception.RegistException;
import cn.nsu.edu.estore.service.ProductService;
import cn.nsu.edu.estore.utils.Projectpath;
import cn.nsu.edu.estore.utils.UploadPic;

/**
 * Servlet implementation class Text
 */
@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = new HashMap<String, String[]>();// 用于封装所有请求参数

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        //判断提交上来的数据是否是上传表单的数据
        if(!ServletFileUpload.isMultipartContent(request)){
            return;
        }
        try {
            List<FileItem> list = upload.parseRequest(request);

            for(FileItem item : list){
                if(item.isFormField()){
                    map.put(item.getFieldName(),
                            new String[] { item.getString("utf-8") }); // 封装其它数据

                }else {
                    String filename = item.getName();
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    UploadPic.savePic(item,filename);

                    map.put("imgurl", new String[] {filename});
                    File directory = new File("");// 参数为空
                    String proRootPath = directory.getCanonicalPath();
                    System.out.println(proRootPath);
                }

            }
            //将所得信息赋给Product对象
            Product product = new Product();
            //调用service中添加方法
            ProductService service = new ProductService();

            try {
                BeanUtils.populate(product, map);
                System.out.println(product.getImgurl());

                service.add(product);

                request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);

                return;
            } catch (SQLException e) {
                e.printStackTrace();
                request.getSession().setAttribute("add.message", e.getMessage());
                request.getRequestDispatcher("/add_product.jsp").forward(request,
                        response);
                return;

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    private boolean isPicture(String fileName) {
        String[] exts = {"jpg","bmp","png","jpeg","gif"};
        String ext = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        for (int i = 0; i < exts.length; i++) {
            if (ext.toLowerCase().equals(exts[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
