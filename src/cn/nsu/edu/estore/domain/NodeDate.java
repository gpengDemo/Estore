package cn.nsu.edu.estore.domain;

public class NodeDate {
    private String code;
    private String name;
    private String fathercode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathercode() {
        return fathercode;
    }

    public void setFathercode(String fathercode) {
        this.fathercode = fathercode;
    }

    @Override
    public String toString() {
        return "NodeDate [code=" + code + ", name=" + name + ", fathercode=" + fathercode + "]";
    }


}
