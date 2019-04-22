package cn.nsu.edu.estore.utils;

public class Projectpath {

    static String path = System.getProperty("user.dir");

    public  static String getPath() {
        return path;
    }

}
