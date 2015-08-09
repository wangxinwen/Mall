package tw.roysu.mall.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.multipart.MultipartFile;

import tw.roysu.mall.constant.AppConstant;
import tw.roysu.mall.dao.IProductDao;
import tw.roysu.mall.entity.Product;
import tw.roysu.mall.service.IProductService;
import tw.roysu.mall.utils.FileUtils;

@Service
public class ProductService extends BaseService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public void create(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getProductList(int page) {
        return productDao.findList(getBegin(page), AppConstant.ADMIN_PRODUCT_LIST_PAGE_SIZE);
    }

    /**
     * 計算後台商品列表查詢開始筆數
     * 
     * @param page
     *        現在頁數
     * @return 查詢開始值
     */
    private int getBegin(int page) {
        return (page - 1) * AppConstant.ADMIN_PRODUCT_LIST_PAGE_SIZE;
    }

    @Override
    public void addProductImg(int productId, MultipartFile img) {
        TransactionStatus status = super.getTransactionStatus();

        // 組合檔案名稱與路徑
        String filename = productId + FileUtils.getFileExtension(img.getOriginalFilename());
        String fileNameAndPath = AppConstant.IMG_PRODUCT_PATH + filename;
        
        try {
            // 新增商品圖片
            saveFile(img.getInputStream(), fileNameAndPath);

            // 儲存商品圖片網址
            String imgUrl = AppConstant.IMG_PRODUCT_URL + filename;
            Product product = productDao.findById(productId);
            product.setImgUrl(imgUrl);
            productDao.update(product);

            super.getTransactionManager().commit(status);
        } catch (IOException e) {
            super.getTransactionManager().rollback(status);
            e.printStackTrace();
        }
    }

    /**
     * 儲存檔案
     * 
     * @param inputStream
     *        輸入串流
     * @param filePathAndName
     *        檔案位置與檔案名稱
     * @throws IOException
     */
    private void saveFile(InputStream inputStream, String filePathAndName) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePathAndName);
        byte[] buffer = new byte[1024 * 1024];
        int byteread = 0;
        while ((byteread = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, byteread);
            fos.flush();
        }
        fos.close();
        inputStream.close();
    }

    @Override
    public List<Product> getListByCategory(int categoryId, int page) {
        return productDao.findListByCategoryId(categoryId, getBegin(page), AppConstant.ADMIN_PRODUCT_LIST_PAGE_SIZE);
    }

}
