package tw.roysu.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.roysu.mall.dao.IBuyRecordDao;
import tw.roysu.mall.entity.BuyRecord;
import tw.roysu.mall.entity.Product;
import tw.roysu.mall.service.IBuyRecordService;

@Service
public class BuyRecordService extends BaseService implements IBuyRecordService {
    
    @Autowired
    private IBuyRecordDao buyRecordDao;

    @Override
    public void saveByOrder(int userId, int orderId, List<Product> productList) {
        productList.forEach(product -> {
            BuyRecord buyRecord = new BuyRecord(userId, orderId, product.getId());
            buyRecordDao.save(buyRecord);
        });
    }

}
