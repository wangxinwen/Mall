package tw.roysu.mall.form;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import tw.roysu.mall.entity.Order;

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

    /**
     * 將{@link BuyForm}轉為{@link Order}
     * 
     * @param userId
     *        會員編號
     * @param totalPayment
     *        總金額
     * @return {@link Order}
     */
    public Order toOrder(int userId, int totalPayment) {
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPayment(totalPayment);
        order.setMethod(this.method);
        order.setAddress(this.address);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return order;
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
