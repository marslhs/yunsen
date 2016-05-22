package com.mars.common.global.constant;


public class MemberConst {
    public static enum Status{
        Subscribe((byte) 0), Unsubscribe((byte) 1);
        private byte code = 0;
        private Status(byte code){
            this.code = code;
        }
        
        public byte getCode(){
            return code;
        }
    }

}
