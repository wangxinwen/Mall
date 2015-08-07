package tw.roysu.mall.form;

import org.apache.commons.lang3.StringUtils;

import tw.roysu.mall.entity.Product;

/**
 * 新增商品表單
 */
public class ProductForm extends BaseForm {
    
    /**
     * 於建構子初始化
     */
    public ProductForm() {
        this.categoryId = 0;
        this.name = "";
        this.price = 0;
        this.off = 100;
        this.detail = "";
    }
    
    /**
     * 父類別ID
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
     * 商品介紹
     */
    private String detail;

    /**
     * 驗證表單<br><br>
     * 
     * @return 通過回傳true, 不通過回傳false
     */
    public boolean validate() {
        super.clearErrMsgList();
        // 檢查所屬類別ID
        if (this.categoryId < 0) {
            super.addErrMsg("商品要選擇所屬類別哦！");
        }
        // 檢查名稱
        if (StringUtils.isBlank(this.name)) {
            super.addErrMsg("名稱不能空著哦！");
        }
        // 檢查定價
        if (this.price < 0) {
            super.addErrMsg("定價不能為負數哦！");
        }
        // 檢查折扣
        if (this.off < 10 || this.off > 100) {
            super.addErrMsg("折扣只能介於一折(10)至未打折(100)哦！！");
        }
        // 檢查商品介紹
        if (StringUtils.isBlank(this.detail)) {
            super.addErrMsg("商品介紹不能空著哦！");
        }
        return super.validateResult();
    }

    /**
     * 將{@link ProductForm}轉為{@link Product}
     * 
     * @return {@link Product}
     */
    public Product toProduct() {
        Product product = new Product();
        product.setCategoryId(this.categoryId);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setOff(this.off);
        product.setDetail(this.detail);
        return product;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
