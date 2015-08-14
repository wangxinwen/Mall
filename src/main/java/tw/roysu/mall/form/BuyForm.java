package tw.roysu.mall.form;

import org.apache.commons.lang3.StringUtils;

/**
 * 購買商品表單
 */
public class BuyForm extends BaseForm {
    
    /**
     * 付款方式
     */
    private int method;
    
    /**
     * 寄送地址
     */
    private String address;

    /**
     * 驗證表單
     * 
     * @return 通過回傳true, 不通過回傳false
     */
    public boolean validate() {
        super.clearErrMsgList();
        // 檢查付款方式
        if (method < 0) {
            super.addErrMsg("請選擇付款方式哦！");
        }
        // 檢查寄送地址
        if (StringUtils.isBlank(this.address)) {
            super.addErrMsg("地址不能空著哦！");
        }
        return super.validateResult();
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
