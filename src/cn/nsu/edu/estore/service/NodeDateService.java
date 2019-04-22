package cn.nsu.edu.estore.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.nsu.edu.estore.dao.NodeDateDao;
import cn.nsu.edu.estore.domain.NodeDate;

public class NodeDateService {
    NodeDateDao dao = new NodeDateDao();

    //获取目录名称
    public List<NodeDate> getCName(int level) throws SQLException {
        return dao.getCName(level);
    }

    public List<HashMap<String, Object>> getNextName(String code) throws SQLException {
        List<HashMap<String, Object>> name = new ArrayList<>();
        for (int i = 0; i < dao.getNextName(code).size(); i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", dao.getNextName(code).get(i).getCode());
            map.put("name", dao.getNextName(code).get(i).getName());
            name.add(map);
        }
        return name;
    }

    public NodeDate getNodeDate(String name) throws SQLException {
        return dao.getNoeDate(name);
    }

}
