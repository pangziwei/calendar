package com.juyou.calendar.bean;

/**
 * @author 聚友互动
 * @datetime 2021-12-03 13:03
 * @detail :请求QQ接口传回的数据
 */
public class LoginbackBean {

    /**
     * code : 200
     * data : {"nickname":"%E8%81%9A%E5%8F%8B","avatar":"http://thirdqq.qlogo.cn/g?b=oidb&k=MUvykL68pcOM0E3iagxyQBQ&s=640&t=1638495269","uuid":"88B49FA0-E7CF-92C4-7988-CA322D608A91","token":"7b4682a3d284e55cabda7912f4d3d4c4"}
     * json : {"code":"200","msg":"请求成功","data":{"uuid":"88B49FA0-E7CF-92C4-7988-CA322D608A91","token":"7b4682a3d284e55cabda7912f4d3d4c4","nickname":"%E8%81%9A%E5%8F%8B","avatar":"http:\/\/thirdqq.qlogo.cn\/g?b=oidb&k=MUvykL68pcOM0E3iagxyQBQ&s=640&t=1638495269"}}
     * msg : 请求成功
     * ok : false
     */

//    private String code;
//    private DataBean data;
//    private String json;
//    private String msg;
//    private boolean ok;

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public String getJson() {
//        return json;
//    }
//
//    public void setJson(String json) {
//        this.json = json;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public boolean isOk() {
//        return ok;
//    }
//
//    public void setOk(boolean ok) {
//        this.ok = ok;
//    }
//
//    public static class DataBean {
        /**
         * nickname : %E8%81%9A%E5%8F%8B
         * avatar : http://thirdqq.qlogo.cn/g?b=oidb&k=MUvykL68pcOM0E3iagxyQBQ&s=640&t=1638495269
         * uuid : 88B49FA0-E7CF-92C4-7988-CA322D608A91
         * token : 7b4682a3d284e55cabda7912f4d3d4c4
         */

        private String nickname;
        private String avatar;
        private String uuid;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
//    }
}
