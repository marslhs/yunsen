package com.mars.db.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mars.db.bean.YunProduct;
import com.mars.db.dao.YunProductMapper;
import com.mars.db.service.IYunProductService;

@Service("yunProductService")  
public class YunProductServiceImpl implements IYunProductService {

    @Resource  
    private YunProductMapper yumProductDAO; 
    
    List<YunProduct> products = null;
    
    public List<YunProduct> getAllProduct() {  
        if(products == null || products.isEmpty()){
            synchronized (this) {
                products = this.yumProductDAO.selectAllProducts();
            }
        }
        return products;
    }
}
