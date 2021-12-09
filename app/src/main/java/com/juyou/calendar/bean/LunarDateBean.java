package com.juyou.calendar.bean;

import java.util.List;

/**
 * @author 聚友互动
 * @datetime 2021-12-08 10:17
 * @detail :请求接口获取的农历禁忌什么的数据
 */
public class LunarDateBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"id":"8","nian":"1900","yue":"1","ri":"8","nl_yue":"腊月","nl_ri":"初八","gz_nian":"己亥","gz_yue":"丁丑","gz_ri":"辛巳","wx_nian":"平地木","wx_yue":"涧下水","wx_ri":"白腊金","shengxiao":"猪","jieqi":"小寒","jieqi_pass":"3","next_jieqi":"大寒","jieqi_next":"12","xingzuo":"摩羯座","jj":"冬","week_1":"1","week_2":"周一","week_3":"星期一","jiaqi":"0","jieri":["腊八节"],"yi":["结婚","祭祀","祈福","求嗣","动土","会亲友","起基","造仓","纳畜","牧养","作厕","进人口"],"ji":["掘井","安葬","栽种","出行","作灶","开业","搬家","安门"],"xingxiu":"昴宿（昴日鸡）"}
     */


    /**
     * id : 8
     * nian : 1900
     * yue : 1
     * ri : 8
     * nl_yue : 腊月
     * nl_ri : 初八
     * gz_nian : 己亥
     * gz_yue : 丁丑
     * gz_ri : 辛巳
     * wx_nian : 平地木
     * wx_yue : 涧下水
     * wx_ri : 白腊金
     * shengxiao : 猪
     * jieqi : 小寒
     * jieqi_pass : 3
     * next_jieqi : 大寒
     * jieqi_next : 12
     * xingzuo : 摩羯座
     * jj : 冬
     * week_1 : 1
     * week_2 : 周一
     * week_3 : 星期一
     * jiaqi : 0
     * jieri : ["腊八节"]
     * yi : ["结婚","祭祀","祈福","求嗣","动土","会亲友","起基","造仓","纳畜","牧养","作厕","进人口"]
     * ji : ["掘井","安葬","栽种","出行","作灶","开业","搬家","安门"]
     * xingxiu : 昴宿（昴日鸡）
     */

    private String id;
    private String nian;
    private String yue;
    private String ri;
    private String nl_yue;
    private String nl_ri;
    private String gz_nian;
    private String gz_yue;
    private String gz_ri;
    private String wx_nian;
    private String wx_yue;
    private String wx_ri;
    private String shengxiao;
    private String jieqi;
    private String jieqi_pass;
    private String next_jieqi;
    private String jieqi_next;
    private String xingzuo;
    private String jj;
    private String week_1;
    private String week_2;
    private String week_3;
    private String jiaqi;
    private String xingxiu;
    private List<String> jieri;
    private List<String> yi;
    private List<String> ji;

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

    public String getYue() {
        return yue;
    }

    public void setYue(String yue) {
        this.yue = yue;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getNl_yue() {
        return nl_yue;
    }

    public void setNl_yue(String nl_yue) {
        this.nl_yue = nl_yue;
    }

    public String getNl_ri() {
        return nl_ri;
    }

    public void setNl_ri(String nl_ri) {
        this.nl_ri = nl_ri;
    }

    public String getGz_nian() {
        return gz_nian;
    }

    public void setGz_nian(String gz_nian) {
        this.gz_nian = gz_nian;
    }

    public String getGz_yue() {
        return gz_yue;
    }

    public void setGz_yue(String gz_yue) {
        this.gz_yue = gz_yue;
    }

    public String getGz_ri() {
        return gz_ri;
    }

    public void setGz_ri(String gz_ri) {
        this.gz_ri = gz_ri;
    }

    public String getWx_nian() {
        return wx_nian;
    }

    public void setWx_nian(String wx_nian) {
        this.wx_nian = wx_nian;
    }

    public String getWx_yue() {
        return wx_yue;
    }

    public void setWx_yue(String wx_yue) {
        this.wx_yue = wx_yue;
    }

    public String getWx_ri() {
        return wx_ri;
    }

    public void setWx_ri(String wx_ri) {
        this.wx_ri = wx_ri;
    }

    public String getShengxiao() {
        return shengxiao;
    }

    public void setShengxiao(String shengxiao) {
        this.shengxiao = shengxiao;
    }

    public String getJieqi() {
        return jieqi;
    }

    public void setJieqi(String jieqi) {
        this.jieqi = jieqi;
    }

    public String getJieqi_pass() {
        return jieqi_pass;
    }

    public void setJieqi_pass(String jieqi_pass) {
        this.jieqi_pass = jieqi_pass;
    }

    public String getNext_jieqi() {
        return next_jieqi;
    }

    public void setNext_jieqi(String next_jieqi) {
        this.next_jieqi = next_jieqi;
    }

    public String getJieqi_next() {
        return jieqi_next;
    }

    public void setJieqi_next(String jieqi_next) {
        this.jieqi_next = jieqi_next;
    }

    public String getXingzuo() {
        return xingzuo;
    }

    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }

    public String getWeek_1() {
        return week_1;
    }

    public void setWeek_1(String week_1) {
        this.week_1 = week_1;
    }

    public String getWeek_2() {
        return week_2;
    }

    public void setWeek_2(String week_2) {
        this.week_2 = week_2;
    }

    public String getWeek_3() {
        return week_3;
    }

    public void setWeek_3(String week_3) {
        this.week_3 = week_3;
    }

    public String getJiaqi() {
        return jiaqi;
    }

    public void setJiaqi(String jiaqi) {
        this.jiaqi = jiaqi;
    }

    public String getXingxiu() {
        return xingxiu;
    }

    public void setXingxiu(String xingxiu) {
        this.xingxiu = xingxiu;
    }

    public List<String> getJieri() {
        return jieri;
    }

    public void setJieri(List<String> jieri) {
        this.jieri = jieri;
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

    @Override
    public String toString() {
        return "LunarDateBean{" +
                "id='" + id + '\'' +
                ", nian='" + nian + '\'' +
                ", yue='" + yue + '\'' +
                ", ri='" + ri + '\'' +
                ", nl_yue='" + nl_yue + '\'' +
                ", nl_ri='" + nl_ri + '\'' +
                ", gz_nian='" + gz_nian + '\'' +
                ", gz_yue='" + gz_yue + '\'' +
                ", gz_ri='" + gz_ri + '\'' +
                ", wx_nian='" + wx_nian + '\'' +
                ", wx_yue='" + wx_yue + '\'' +
                ", wx_ri='" + wx_ri + '\'' +
                ", shengxiao='" + shengxiao + '\'' +
                ", jieqi='" + jieqi + '\'' +
                ", jieqi_pass='" + jieqi_pass + '\'' +
                ", next_jieqi='" + next_jieqi + '\'' +
                ", jieqi_next='" + jieqi_next + '\'' +
                ", xingzuo='" + xingzuo + '\'' +
                ", jj='" + jj + '\'' +
                ", week_1='" + week_1 + '\'' +
                ", week_2='" + week_2 + '\'' +
                ", week_3='" + week_3 + '\'' +
                ", jiaqi='" + jiaqi + '\'' +
                ", xingxiu='" + xingxiu + '\'' +
                ", jieri=" + jieri +
                ", yi=" + yi +
                ", ji=" + ji +
                '}';
    }
}
