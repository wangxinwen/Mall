package tw.roysu.mall.dao;

import java.util.List;

import tw.roysu.mall.entity.BuyRecord;

/**
 * 購買記錄Dao
 */
public interface IBuyRecordDao extends IBaseDao<BuyRecord> {
    
    /**
     * 根據訂單編號查詢購買記錄
     * 
     * @param orderId
     *        訂單編號
     * @return
     */
    public List<BuyRecord> findListByOrderId(int orderId);

}
