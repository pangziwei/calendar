package com.juyou.calendar.bean;

/**
 * @author 聚友互动
 * @datetime 2021-12-03 09:54
 * @detail :从qq第三方登录需要传的数据
 */
public class LoginToApiBean {

    /**
     * way : qq
     * token : {"ret":0,"openid":"E77415331D262FCC997CD0E8FA499A8B","access_token":"7D491E37EE084E78D0DFB27068C0A3CC","pay_token":"3A39BDF28C18F7DDBCD443FF285361CE","expires_in":7776000,"pf":"desktop_m_qq-10000144-android-2002-","pfkey":"94ab2b0a20f102cf7b57a59807452f5e","msg":"","login_cost":201,"query_authority_cost":0,"authority_cost":0,"expires_time":1645063370959}
     * user : {"ret":0,"msg":"","is_lost":0,"nickname":"🌙","gender":"男","gender_type":2,"province":"","city":"","year":"2006","constellation":"","figureurl":"http://qzapp.qlogo.cn/qzapp/101979917/E77415331D262FCC997CD0E8FA499A8B/30","figureurl_1":"http://qzapp.qlogo.cn/qzapp/101979917/E77415331D262FCC997CD0E8FA499A8B/50","figureurl_2":"http://qzapp.qlogo.cn/qzapp/101979917/E77415331D262FCC997CD0E8FA499A8B/100","figureurl_qq_1":"http://thirdqq.qlogo.cn/g?b=oidb&k=ic9wm94dZmCQMFFtV1ia1x3A&s=40&t=1630076756","figureurl_qq_2":"http://thirdqq.qlogo.cn/g?b=oidb&k=ic9wm94dZmCQMFFtV1ia1x3A&s=100&t=1630076756","figureurl_qq":"http://thirdqq.qlogo.cn/g?b=oidb&k=ic9wm94dZmCQMFFtV1ia1x3A&s=640&t=1630076756","figureurl_type":"1","is_yellow_vip":"0","vip":"0","yellow_vip_level":"0","level":"0","is_yellow_year_vip":"0"}
     * open : {"client_id":"101979917","openid":"E77415331D262FCC997CD0E8FA499A8B","unionid":"UID_BA54A9FD21937C808399D2992B1F300A"}
     */

    private String way;
    private String token;
    private String user;
    private String open;

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public static class TokenBean {
        /**
         * ret : 0
         * openid : E77415331D262FCC997CD0E8FA499A8B
         * access_token : 7D491E37EE084E78D0DFB27068C0A3CC
         * pay_token : 3A39BDF28C18F7DDBCD443FF285361CE
         * expires_in : 7776000
         * pf : desktop_m_qq-10000144-android-2002-
         * pfkey : 94ab2b0a20f102cf7b57a59807452f5e
         * msg :
         * login_cost : 201
         * query_authority_cost : 0
         * authority_cost : 0
         * expires_time : 1645063370959
         */

        private int ret;
        private String openid;
        private String access_token;
        private String pay_token;
        private int expires_in;
        private String pf;
        private String pfkey;
        private String msg;
        private int login_cost;
        private int query_authority_cost;
        private int authority_cost;
        private long expires_time;

        public int getRet() {
            return ret;
        }

        public void setRet(int ret) {
            this.ret = ret;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getPay_token() {
            return pay_token;
        }

        public void setPay_token(String pay_token) {
            this.pay_token = pay_token;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public String getPf() {
            return pf;
        }

        public void setPf(String pf) {
            this.pf = pf;
        }

        public String getPfkey() {
            return pfkey;
        }

        public void setPfkey(String pfkey) {
            this.pfkey = pfkey;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getLogin_cost() {
            return login_cost;
        }

        public void setLogin_cost(int login_cost) {
            this.login_cost = login_cost;
        }

        public int getQuery_authority_cost() {
            return query_authority_cost;
        }

        public void setQuery_authority_cost(int query_authority_cost) {
            this.query_authority_cost = query_authority_cost;
        }

        public int getAuthority_cost() {
            return authority_cost;
        }

        public void setAuthority_cost(int authority_cost) {
            this.authority_cost = authority_cost;
        }

        public long getExpires_time() {
            return expires_time;
        }

        public void setExpires_time(long expires_time) {
            this.expires_time = expires_time;
        }
    }

    public static class UserBean {
        /**
         * ret : 0
         * msg :
         * is_lost : 0
         * nickname : 🌙
         * gender : 男
         * gender_type : 2
         * province :
         * city :
         * year : 2006
         * constellation :
         * figureurl : http://qzapp.qlogo.cn/qzapp/101979917/E77415331D262FCC997CD0E8FA499A8B/30
         * figureurl_1 : http://qzapp.qlogo.cn/qzapp/101979917/E77415331D262FCC997CD0E8FA499A8B/50
         * figureurl_2 : http://qzapp.qlogo.cn/qzapp/101979917/E77415331D262FCC997CD0E8FA499A8B/100
         * figureurl_qq_1 : http://thirdqq.qlogo.cn/g?b=oidb&k=ic9wm94dZmCQMFFtV1ia1x3A&s=40&t=1630076756
         * figureurl_qq_2 : http://thirdqq.qlogo.cn/g?b=oidb&k=ic9wm94dZmCQMFFtV1ia1x3A&s=100&t=1630076756
         * figureurl_qq : http://thirdqq.qlogo.cn/g?b=oidb&k=ic9wm94dZmCQMFFtV1ia1x3A&s=640&t=1630076756
         * figureurl_type : 1
         * is_yellow_vip : 0
         * vip : 0
         * yellow_vip_level : 0
         * level : 0
         * is_yellow_year_vip : 0
         */

        private int ret;
        private String msg;
        private int is_lost;
        private String nickname;
        private String gender;
        private int gender_type;
        private String province;
        private String city;
        private String year;
        private String constellation;
        private String figureurl;
        private String figureurl_1;
        private String figureurl_2;
        private String figureurl_qq_1;
        private String figureurl_qq_2;
        private String figureurl_qq;
        private String figureurl_type;
        private String is_yellow_vip;
        private String vip;
        private String yellow_vip_level;
        private String level;
        private String is_yellow_year_vip;

        public int getRet() {
            return ret;
        }

        public void setRet(int ret) {
            this.ret = ret;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getIs_lost() {
            return is_lost;
        }

        public void setIs_lost(int is_lost) {
            this.is_lost = is_lost;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getGender_type() {
            return gender_type;
        }

        public void setGender_type(int gender_type) {
            this.gender_type = gender_type;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getFigureurl() {
            return figureurl;
        }

        public void setFigureurl(String figureurl) {
            this.figureurl = figureurl;
        }

        public String getFigureurl_1() {
            return figureurl_1;
        }

        public void setFigureurl_1(String figureurl_1) {
            this.figureurl_1 = figureurl_1;
        }

        public String getFigureurl_2() {
            return figureurl_2;
        }

        public void setFigureurl_2(String figureurl_2) {
            this.figureurl_2 = figureurl_2;
        }

        public String getFigureurl_qq_1() {
            return figureurl_qq_1;
        }

        public void setFigureurl_qq_1(String figureurl_qq_1) {
            this.figureurl_qq_1 = figureurl_qq_1;
        }

        public String getFigureurl_qq_2() {
            return figureurl_qq_2;
        }

        public void setFigureurl_qq_2(String figureurl_qq_2) {
            this.figureurl_qq_2 = figureurl_qq_2;
        }

        public String getFigureurl_qq() {
            return figureurl_qq;
        }

        public void setFigureurl_qq(String figureurl_qq) {
            this.figureurl_qq = figureurl_qq;
        }

        public String getFigureurl_type() {
            return figureurl_type;
        }

        public void setFigureurl_type(String figureurl_type) {
            this.figureurl_type = figureurl_type;
        }

        public String getIs_yellow_vip() {
            return is_yellow_vip;
        }

        public void setIs_yellow_vip(String is_yellow_vip) {
            this.is_yellow_vip = is_yellow_vip;
        }

        public String getVip() {
            return vip;
        }

        public void setVip(String vip) {
            this.vip = vip;
        }

        public String getYellow_vip_level() {
            return yellow_vip_level;
        }

        public void setYellow_vip_level(String yellow_vip_level) {
            this.yellow_vip_level = yellow_vip_level;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getIs_yellow_year_vip() {
            return is_yellow_year_vip;
        }

        public void setIs_yellow_year_vip(String is_yellow_year_vip) {
            this.is_yellow_year_vip = is_yellow_year_vip;
        }
    }

    public static class OpenBean {
        /**
         * client_id : 101979917
         * openid : E77415331D262FCC997CD0E8FA499A8B
         * unionid : UID_BA54A9FD21937C808399D2992B1F300A
         */

        private String client_id;
        private String openid;
        private String unionid;

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }
    }
}
