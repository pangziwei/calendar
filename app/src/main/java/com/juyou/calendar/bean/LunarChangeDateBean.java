package com.juyou.calendar.bean;

import java.util.List;

/**
 * @author 聚友互动
 * @datetime 2021-12-09 14:17
 * @detail :
 */
public class LunarChangeDateBean {

    /**
     * code : 200
     * data : {"jj":"冬","next_jieqi":"大寒","yue":"1","gz_nian":"庚子","yi":["祈福","结婚","作灶","招赘","纳婿","经络","祭祀","求嗣","穿井","栽种","捕捉"],"wx_ri":"沙中土","nl_ri":"廿六","jieqi":"小寒","gz_yue":"己丑","id":"44204","nian":"2021","nl_yue":"冬月","jiaqi":"1","jieqi_pass":"5","gz_ri":"丁巳","week_3":"星期六","week_2":"周六","week_1":"6","xingxiu":"南方柳土獐-凶","shengxiao":"鼠","wx_yue":"霹雷火","ri":"9","jieqi_next":"11","jieri":"","xingzuo":"摩羯座","wx_nian":"壁上土","ji":["盖屋","上梁","开业","立券","纳财","出货","入殓","移柩","破土","启鑽","安葬","纳畜","订婚","修造","搬家","安门","安床","竖柱","置产","行丧","出行","移徙","分居","开仓"]}
     * json : {"code":"200","msg":"请求成功","data":{"id":"44204","nian":"2021","yue":"1","ri":"9","nl_yue":"\u51ac\u6708","nl_ri":"\u5eff\u516d","gz_nian":"\u5e9a\u5b50","gz_yue":"\u5df1\u4e11","gz_ri":"\u4e01\u5df3","wx_nian":"\u58c1\u4e0a\u571f","wx_yue":"\u9739\u96f7\u706b","wx_ri":"\u6c99\u4e2d\u571f","shengxiao":"\u9f20","jieqi":"\u5c0f\u5bd2","jieqi_pass":"5","next_jieqi":"\u5927\u5bd2","jieqi_next":"11","xingzuo":"\u6469\u7faf\u5ea7","jj":"\u51ac","week_1":"6","week_2":"\u5468\u516d","week_3":"\u661f\u671f\u516d","jiaqi":"1","jieri":"","yi":["祈福","结婚","作灶","招赘","纳婿","经络","祭祀","求嗣","穿井","栽种","捕捉"],"ji":["盖屋","上梁","开业","立券","纳财","出货","入殓","移柩","破土","启鑽","安葬","纳畜","订婚","修造","搬家","安门","安床","竖柱","置产","行丧","出行","移徙","分居","开仓"],"xingxiu":"\u5357\u65b9\u67f3\u571f\u7350-\u51f6"}}
     * msg : 请求成功
     * ok : false
     */


        /**
         * jj : 冬
         * next_jieqi : 大寒
         * yue : 1
         * gz_nian : 庚子
         * yi : ["祈福","结婚","作灶","招赘","纳婿","经络","祭祀","求嗣","穿井","栽种","捕捉"]
         * wx_ri : 沙中土
         * nl_ri : 廿六
         * jieqi : 小寒
         * gz_yue : 己丑
         * id : 44204
         * nian : 2021
         * nl_yue : 冬月
         * jiaqi : 1
         * jieqi_pass : 5
         * gz_ri : 丁巳
         * week_3 : 星期六
         * week_2 : 周六
         * week_1 : 6
         * xingxiu : 南方柳土獐-凶
         * shengxiao : 鼠
         * wx_yue : 霹雷火
         * ri : 9
         * jieqi_next : 11
         * jieri :
         * xingzuo : 摩羯座
         * wx_nian : 壁上土
         * ji : ["盖屋","上梁","开业","立券","纳财","出货","入殓","移柩","破土","启鑽","安葬","纳畜","订婚","修造","搬家","安门","安床","竖柱","置产","行丧","出行","移徙","分居","开仓"]
         */

        private String jj;
        private String next_jieqi;
        private String yue;
        private String gz_nian;
        private String wx_ri;
        private String nl_ri;
        private String jieqi;
        private String gz_yue;
        private String id;
        private String nian;
        private String nl_yue;
        private String jiaqi;
        private String jieqi_pass;
        private String gz_ri;
        private String week_3;
        private String week_2;
        private String week_1;
        private String xingxiu;
        private String shengxiao;
        private String wx_yue;
        private String ri;
        private String jieqi_next;
        private String jieri;
        private String xingzuo;
        private String wx_nian;
        private List<String> yi;
        private List<String> ji;

        public String getJj() {
            return jj;
        }

        public void setJj(String jj) {
            this.jj = jj;
        }

        public String getNext_jieqi() {
            return next_jieqi;
        }

        public void setNext_jieqi(String next_jieqi) {
            this.next_jieqi = next_jieqi;
        }

        public String getYue() {
            return yue;
        }

        public void setYue(String yue) {
            this.yue = yue;
        }

        public String getGz_nian() {
            return gz_nian;
        }

        public void setGz_nian(String gz_nian) {
            this.gz_nian = gz_nian;
        }

        public String getWx_ri() {
            return wx_ri;
        }

        public void setWx_ri(String wx_ri) {
            this.wx_ri = wx_ri;
        }

        public String getNl_ri() {
            return nl_ri;
        }

        public void setNl_ri(String nl_ri) {
            this.nl_ri = nl_ri;
        }

        public String getJieqi() {
            return jieqi;
        }

        public void setJieqi(String jieqi) {
            this.jieqi = jieqi;
        }

        public String getGz_yue() {
            return gz_yue;
        }

        public void setGz_yue(String gz_yue) {
            this.gz_yue = gz_yue;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNian() {
            return nian;
        }

        public void setNian(String nian) {
            this.nian = nian;
        }

        public String getNl_yue() {
            return nl_yue;
        }

        public void setNl_yue(String nl_yue) {
            this.nl_yue = nl_yue;
        }

        public String getJiaqi() {
            return jiaqi;
        }

        public void setJiaqi(String jiaqi) {
            this.jiaqi = jiaqi;
        }

        public String getJieqi_pass() {
            return jieqi_pass;
        }

        public void setJieqi_pass(String jieqi_pass) {
            this.jieqi_pass = jieqi_pass;
        }

        public String getGz_ri() {
            return gz_ri;
        }

        public void setGz_ri(String gz_ri) {
            this.gz_ri = gz_ri;
        }

        public String getWeek_3() {
            return week_3;
        }

        public void setWeek_3(String week_3) {
            this.week_3 = week_3;
        }

        public String getWeek_2() {
            return week_2;
        }

        public void setWeek_2(String week_2) {
            this.week_2 = week_2;
        }

        public String getWeek_1() {
            return week_1;
        }

        public void setWeek_1(String week_1) {
            this.week_1 = week_1;
        }

        public String getXingxiu() {
            return xingxiu;
        }

        public void setXingxiu(String xingxiu) {
            this.xingxiu = xingxiu;
        }

        public String getShengxiao() {
            return shengxiao;
        }

        public void setShengxiao(String shengxiao) {
            this.shengxiao = shengxiao;
        }

        public String getWx_yue() {
            return wx_yue;
        }

        public void setWx_yue(String wx_yue) {
            this.wx_yue = wx_yue;
        }

        public String getRi() {
            return ri;
        }

        public void setRi(String ri) {
            this.ri = ri;
        }

        public String getJieqi_next() {
            return jieqi_next;
        }

        public void setJieqi_next(String jieqi_next) {
            this.jieqi_next = jieqi_next;
        }

        public String getJieri() {
            return jieri;
        }

        public void setJieri(String jieri) {
            this.jieri = jieri;
        }

        public String getXingzuo() {
            return xingzuo;
        }

        public void setXingzuo(String xingzuo) {
            this.xingzuo = xingzuo;
        }

        public String getWx_nian() {
            return wx_nian;
        }

        public void setWx_nian(String wx_nian) {
            this.wx_nian = wx_nian;
        }

        public List<String> getYi() {
            return yi;
        }

        public void setYi(List<String> yi) {
            this.yi = yi;
        }

        public List<String> getJi() {
            return ji;
        }

        public void setJi(List<String> ji) {
            this.ji = ji;
        }
}
