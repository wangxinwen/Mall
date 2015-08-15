package tw.roysu.mall.dao.impl;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.IBuyRecordDao;
import tw.roysu.mall.entity.BuyRecord;

@Repository
public class BuyRecordDao extends BaseDao<BuyRecord>implements IBuyRecordDao {
    
    public BuyRecordDao() {
        super(BuyRecord.class);
    }

}
