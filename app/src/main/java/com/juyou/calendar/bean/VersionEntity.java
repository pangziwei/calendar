package com.juyou.calendar.bean;

/**
 * 版本更新
 */
public class VersionEntity {
    /**
     * code : 200
     * data : {"editionId":4,"link":"http://www.ailaila.com/ceshi/diz/app","osType":1,"type":0,"version":"1.1","content":"bug修复，新增1功能，新增2功能"}
     * json : {"code":200,"msg":"OK","data":{"editionId":4,"type":0,"version":"1.1","link":"http://www.ailaila.com/ceshi/diz/app","content":"bug修复，新增1功能，新增2功能","osType":1}}
     * msg : OK
     * ok : false
     */
    /**
     * editionId : 4 //版本id
     * link : http://www.ailaila.com/ceshi/diz/app //版本链接地址-爱来啦-https://download.ailaila.com/apk/love_1.0.6.apk
     * osType : 1//版本系统类型
     * type : 0//更新类型 0-普通更新 1-强制更新
     * version : 1.1  //版本号
     * content : bug修复，新增1功能，新增2功能//版本更新说明
     */

    private int editionId;
    private String link;
    private int osType;
    private int type;
    private String version;
    private String content;
    private String createTime;
//    private String minVersion;

    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getOsType() {
        return osType;
    }

    public void setOsType(int osType) {
        this.osType = osType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

//    public String getMinVersion() {
//        return minVersion;
//    }
//
//    public void setMinVersion(String minVersion) {
//        this.minVersion = minVersion;
//    }
//    /**
//     * createTime : 1567693979000
//     * desc : 111
//     * downUrl : 111
//     * force : 1
//     * id : 23
//     * status : 0
//     * type : ANDROID
//     * userId : 1
//     * version : 2.51
//     */
//
//    private long createTime;
//    private String desc;
//    private String downUrl;
//    //是否强制弹窗升级 1是 0普通
//    private int force;
//    private int id;
//    private int status;
//    private String type;
//    private int userId;
//    private String version;
//
//    public long getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(long createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public String getDownUrl() {
//        return downUrl;
//    }
//
//    public void setDownUrl(String downUrl) {
//        this.downUrl = downUrl;
//    }
//
//    public int getForce() {
//        return force;
//    }
//
//    public void setForce(int force) {
//        this.force = force;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
}
