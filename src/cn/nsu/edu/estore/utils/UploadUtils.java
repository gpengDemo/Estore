package cn.nsu.edu.estore.utils;

import java.util.UUID;

public class UploadUtils {
    /**
     * 截取真实文件名
     *
     * @param fileName
     * @return
     */
    public static String subFileName(String fileName) {
        // 查找最后一个 \出现位置
        int index = fileName.lastIndexOf("\\");
        if (index == -1) {
            return fileName;
        }
        return fileName.substring(index + 1);
    }

    // 获得随机UUID文件名
    public static String generateRandonFileName(String fileName) {
        // 获得扩展名
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }

    // 获得hashcode生成二级目录
    public static String generateRandomDir(String uuidFileName) {
        int hashCode = uuidFileName.hashCode();
        // 一级目录
        int d1 = hashCode & 0xf;
        // 二级目录
        int d2 = (hashCode >> 4) & 0xf;
        return "/" + d1 + "/" + d2;
    }
}
