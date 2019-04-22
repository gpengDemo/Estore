package cn.nsu.edu.estore.domain;


/**
 * 订单中一项
 */
public class OrderItem {
    private String order_id; // 订单号
    private String product_id; // 商品号
    private int buynum; // 购买数量

    // 添加product的名称和单价
    private String name;
    private double price;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String orderId) {
        order_id = orderId;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String productId) {
        product_id = productId;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
