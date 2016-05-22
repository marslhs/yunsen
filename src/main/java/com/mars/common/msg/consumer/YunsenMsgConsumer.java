package com.mars.common.msg.consumer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.sword.wechat4j.WechatSupport;

import com.mars.db.service.IYunMemberService;


public class YunsenMsgConsumer extends WechatSupport {

    @Resource
    private IYunMemberService yunMemberService = null;
    
    public YunsenMsgConsumer(HttpServletRequest request) {
        super(request);
    }

    @Override
    protected void onText() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onImage() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onVoice() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onVideo() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onShortVideo() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onLocation() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onLink() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onUnknown() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void click() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void subscribe() {
        String fromUser = wechatRequest.getFromUserName();
        yunMemberService.addYunMember(fromUser);
    }

    @Override
    protected void unSubscribe() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void scan() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void location() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void view() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void templateMsgCallback() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void scanCodePush() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void scanCodeWaitMsg() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void picSysPhoto() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void picPhotoOrAlbum() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void picWeixin() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void locationSelect() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void kfCreateSession() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void kfCloseSession() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void kfSwitchSession() {
        // TODO Auto-generated method stub

    }

}
