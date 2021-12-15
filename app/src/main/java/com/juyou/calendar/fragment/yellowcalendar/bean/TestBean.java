package com.juyou.calendar.fragment.yellowcalendar.bean;

import java.util.List;

/**
 * @author 聚友互动
 * @datetime 2021-12-14 11:15
 * @detail :
 */
public class TestBean {

    /**
     * code : 200
     * data : {"caishen":"正南","pzbj":"癸不词讼理弱敌强 亥不嫁娶不利新郎","yanggs":"东南","fs":"东北","cs":"冲蛇煞西 正冲丁巳","yings":"正东","jsyq":["神在","王日","生气","益后","天后","阴德","时阳","驿马","明堂"],"scyj":"","xsyj":["专日","重日","地火","月厌","四穷","六蛇","大会"],"zs":"明堂(黄道日)","xs":"东南","jgfx":"一白太乙水星(吉)","ts":"占房床外东南","nywx":["[年]城墙土","[月]洞下水","[日]大海水"]}
     * json : {"code":"200","msg":"请求成功","data":{"zs":"明堂(黄道日)","pzbj":"癸不词讼理弱敌强 亥不嫁娶不利新郎","ts":"占房床外东南","cs":"冲蛇煞西 正冲丁巳","nywx":["[年]城墙土","[月]洞下水","[日]大海水"],"scyj":"","yanggs":"东南","yings":"正东","xs":"东南","fs":"东北","caishen":"正南","jsyq":["神在","王日","生气","益后","天后","阴德","时阳","驿马","明堂"],"xsyj":["专日","重日","地火","月厌","四穷","六蛇","大会"],"jgfx":"一白太乙水星(吉)"}}
     * msg : 请求成功
     * ok : false
     */

    private String code;
    private DataBean data;
    private String json;
    private String msg;
    private boolean ok;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public static class DataBean {
        /**
         * caishen : 正南
         * pzbj : 癸不词讼理弱敌强 亥不嫁娶不利新郎
         * yanggs : 东南
         * fs : 东北
         * cs : 冲蛇煞西 正冲丁巳
         * yings : 正东
         * jsyq : ["神在","王日","生气","益后","天后","阴德","时阳","驿马","明堂"]
         * scyj :
         * xsyj : ["专日","重日","地火","月厌","四穷","六蛇","大会"]
         * zs : 明堂(黄道日)
         * xs : 东南
         * jgfx : 一白太乙水星(吉)
         * ts : 占房床外东南
         * nywx : ["[年]城墙土","[月]洞下水","[日]大海水"]
         */

        private String caishen;
        private String pzbj;
        private String yanggs;
        private String fs;
        private String cs;
        private String yings;
        private String scyj;
        private String zs;
        private String xs;
        private String jgfx;
        private String ts;
        private List<String> jsyq;
        private List<String> xsyj;
        private List<String> nywx;

        public String getCaishen() {
            return caishen;
        }

        public void setCaishen(String caishen) {
            this.caishen = caishen;
        }

        public String getPzbj() {
            return pzbj;
        }

        public void setPzbj(String pzbj) {
            this.pzbj = pzbj;
        }

        public String getYanggs() {
            return yanggs;
        }

        public void setYanggs(String yanggs) {
            this.yanggs = yanggs;
        }

        public String getFs() {
            return fs;
        }

        public void setFs(String fs) {
            this.fs = fs;
        }

        public String getCs() {
            return cs;
        }

        public void setCs(String cs) {
            this.cs = cs;
        }

        public String getYings() {
            return yings;
        }

        public void setYings(String yings) {
            this.yings = yings;
        }

        public String getScyj() {
            return scyj;
        }

        public void setScyj(String scyj) {
            this.scyj = scyj;
        }

        public String getZs() {
            return zs;
        }

        public void setZs(String zs) {
            this.zs = zs;
        }

        public String getXs() {
            return xs;
        }

        public void setXs(String xs) {
            this.xs = xs;
        }

        public String getJgfx() {
            return jgfx;
        }

        public void setJgfx(String jgfx) {
            this.jgfx = jgfx;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public List<String> getJsyq() {
            return jsyq;
        }

        public void setJsyq(List<String> jsyq) {
            this.jsyq = jsyq;
        }

        public List<String> getXsyj() {
            return xsyj;
        }

        public void setXsyj(List<String> xsyj) {
            this.xsyj = xsyj;
        }

        public List<String> getNywx() {
            return nywx;
        }

        public void setNywx(List<String> nywx) {
            this.nywx = nywx;
        }
    }
}
