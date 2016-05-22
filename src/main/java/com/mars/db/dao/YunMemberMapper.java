package com.mars.db.dao;

import com.mars.db.bean.YunMember;

public interface YunMemberMapper {
    int deleteByPrimaryKey(Integer memberSeq);

    int insert(YunMember record);

    int insertSelective(YunMember record);

    YunMember selectByPrimaryKey(Integer memberSeq);
    
    YunMember selectByOpenId(String weixinOpenid);

    int updateByPrimaryKeySelective(YunMember record);

    int updateByPrimaryKey(YunMember record);
}