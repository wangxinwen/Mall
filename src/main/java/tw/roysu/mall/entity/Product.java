package tw.roysu.mall.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商品
 */
@Entity
public class Product implements Serializable {
    
    /**
     * 於建構子初始化
     */
    public Product() {
        categoryId = 0;
        name = "";
        price = 0;
        off = 100;
        quantity = 0;
        imgUrl = "";
    }
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品編號
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * 所屬商品類別ID
     */
    private int categoryId;
    
    /**
     * 名稱
     */
    private String name;
    
    /**
     * 定價
     */
    private int price;
    
    /**
     * 折扣<br><br>
     * 
     * 原價為100, 八五折為85
     */
    private int off;
    
    /**
     * 數量
     */
    private int quantity;
    
    /**
     * 圖片網址
     */
    private String imgUrl;
    
    /**
     * 商品介紹
     */
    private String detail;
    
    /**
     * 取得實際售價(打折後的價錢)
     * 
     * @return 打折後的價格
     */
    public int getActualPrice() {
        return (int) Math.round(this.price * this.off / 100.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOff() {
        return off;
    }

    public void setOff(int off) {
        this.off = off;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
