package tw.roysu.mall.form;

import org.apache.commons.lang3.StringUtils;

import tw.roysu.mall.entity.Category;

/**
 * 新增商品類別表單
 */
public class CategoryForm extends BaseForm {
    
    /**
     * 於建構子初始化
     */
    public CategoryForm() {
        this.parentId = 0;
        this.name = "";
    }
    
    /**
     * 父類別ID
     */
    private int parentId;
    
    /**
     * 名稱
     */
    private String name;

    /**
     * 驗證表單
     * 
     * @return 通過回傳true, 不通過回傳false
     */
    public boolean validate() {
        super.clearErrMsgList();
        // 檢查名稱
        if (StringUtils.isBlank(this.name)) {
            super.addErrMsg("名稱不能空著哦！");
        }
        return super.validateResult();
    }

    /**
     * 將{@link CategoryForm}轉為{@link Category}
     * 
     * @return {@link Category}
     */
    public Category toCategory() {
        Category category = new Category();
        category.setParentId(this.parentId);
        category.setName(this.name);
        return category;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
