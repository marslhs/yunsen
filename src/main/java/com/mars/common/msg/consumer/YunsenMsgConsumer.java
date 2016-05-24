package com.mars.common.msg.consumer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.sword.wechat4j.WechatSupport;

import com.mars.db.service.IYunMemberService;

public class YunsenMsgConsumer extends WechatSupport {

    private IYunMemberService yunMemberService = null;

    
    public void setYunMemberService(IYunMemberService yunMemberService) {
        this.yunMemberService = yunMemberService;
    }

    public YunsenMsgConsumer(HttpServletRequest request) {
        super(request);
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        yunMemberService = (IYunMemberService)wac.getBean("yunMemberService");
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
        this.yunMemberService.addYunMember(fromUser);
    }

    @Override
    protected void unSubscribe() {
        String fromUser = wechatRequest.getFromUserName();
        this.yunMemberService.unsubscribe(fromUser);

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
