package com.mars.db.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mars.db.bean.YunMember;
import com.mars.db.dao.YunMemberMapper;
import com.mars.db.service.IYunMemberService;

@Service("yunMemberService")  
public class YunMemberServiceImpl implements IYunMemberService {

    @Resource  
    private YunMemberMapper yumMemberDAO; 
    
    
    public YunMember getUserById(int userId) {  
        return this.yumMemberDAO.selectByPrimaryKey(userId);
    }
}
