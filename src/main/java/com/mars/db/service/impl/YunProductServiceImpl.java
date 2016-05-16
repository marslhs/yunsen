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
    
    
    public List<YunProduct> getAllProduct() {  
        return this.yumProductDAO.selectAllProducts();
    }
}
