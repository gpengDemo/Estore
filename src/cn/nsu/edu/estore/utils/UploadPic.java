package cn.nsu.edu.estore.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.IOUtils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class UploadPic {

    private static String path = "c:\\upload";

    //上传图片
    public static void savePic(FileItem item, String filename) throws IOException {
        //创建文件上传路
        File file = new File(path);

        //判断路径是否存在
        if (!file.exists())
            file.mkdirs();

        //获取item中的上传文件的输入流
        InputStream in = item.getInputStream();
        //创建一个文件输出流
        FileOutputStream out = new FileOutputStream(path + "\\" + filename);
        //创建一个缓冲区
        byte buffer[] = new byte[1024];
        //判断输入流中的数据是否已经读完的标识
        int len = 0;
        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
        while((len=in.read(buffer))>0){
            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
            out.write(buffer, 0, len);
        }
        in.close();
        //关闭输出流
        out.close();
        //删除处理文件上传时生成的临时文件
        item.delete();

    }

    public String getPath() {
        return path;
    }

}
