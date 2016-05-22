package com.mars.db.service;

import com.mars.db.bean.YunMember;


public interface IYunMemberService {

    YunMember getUserById(int userId);
    
    YunMember getUserByOpenId(String openId);
    
    void addYunMember(String openId);
}
