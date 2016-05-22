package com.mars.db.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.sword.wechat4j.token.TokenProxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mars.common.control.global.constant.GlobalConst;
import com.mars.common.control.utils.HttpInvoker;
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
    
    public YunMember getUserByOpenId(String openId) {  
        return this.yumMemberDAO.selectByOpenId(openId);
    }
    
    public void addYunMember(String openId){
        String url =String.format(GlobalConst.GET_USER_INFO_URL, TokenProxy.accessToken(), openId);
        String result = HttpInvoker.get(url);
        JSONObject resultJson = JSON.parseObject(result);
        
        YunMember member = new YunMember();
        member.setLastViewDate(new Date());
        member.setName(resultJson.getString("nickname"));
        member.setSex(resultJson.getByte("sex"));
        member.setWeixinOpenid(openId);
        member.setModifiedDate(new Date());
        this.yumMemberDAO.insert(member);
    }
}
