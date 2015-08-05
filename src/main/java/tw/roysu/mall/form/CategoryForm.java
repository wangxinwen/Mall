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
     * 驗證表單<br><br>
     * 
     * 新增父與子類別共用{@link CategoryForm}, parentId的預設為0,<br> 
     * 新增父類別不必檢查parentId, 新增子類別則要,<br>
     * 目前採取的方式為：<br>
     * 在新增子類別時, 在HTML的表單將parentId的預設值改為-1,<br>
     * 所以{@link CategoryForm}執行validate()時,<br>
     * parentId的檢查方式為驗證是否小於0,<br>
     * 如此才能即不影響父類別的新增, 亦能檢查到子類別有無選擇parentId
     * 
     * @return 通過回傳true, 不通過回傳false
     */
    public boolean validate() {
        super.clearErrMsgList();
        // 檢查父類別ID
        if (parentId < 0) {
            super.addErrMsg("父類別要選擇哦！");
        }
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
