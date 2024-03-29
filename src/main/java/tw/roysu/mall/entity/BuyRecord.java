package tw.roysu.mall.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 購買記錄
 */
@Entity
public class BuyRecord implements Serializable {
    
    public BuyRecord() {
        
    }
    
    /**
     * 於建構子初始化
     * 
     * @param userId
     *        會員編號
     * @param orderId
     *        訂單編號
     * @param productId
     *        商品編號
     */
    public BuyRecord(int userId, int orderId, int productId) {
        this.userId = userId;
        this.orderId = orderId;
        this.productId = productId;
    }
    
    private static final long serialVersionUID = 1L;
    
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * 會員編號
     */
    private int userId;
    
    /**
     * 訂單編號
     */
    private int orderId;
    
    /**
     * 商品編號
     */
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
