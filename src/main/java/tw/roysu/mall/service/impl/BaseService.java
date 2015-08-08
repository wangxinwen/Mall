package tw.roysu.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Service基礎建設
 */
@Service
public class BaseService {

    @Autowired
    private HibernateTransactionManager transactionManager;

    /**
     * 取得交易狀態
     * 
     * @return {@link TransactionStatus}
     */
    public TransactionStatus getTransactionStatus() {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return transactionManager.getTransaction(definition);
    }

    /**
     * 取得交易管理器
     * 
     * @return {@link HibernateTransactionManager}
     */
    public HibernateTransactionManager getTransactionManager() {
        return transactionManager;
    }

}
