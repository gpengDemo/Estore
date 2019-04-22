package cn.nsu.edu.estore.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookieByName(Cookie[] cs, String name) {
        if (cs == null || cs.length == 0) {
            return null;
        }
        for (Cookie c : cs) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }


}
