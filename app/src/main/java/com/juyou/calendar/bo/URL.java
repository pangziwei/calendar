package com.juyou.calendar.bo;

/**
 * Created by ThinkPad on 2017/5/15.
 */

public class URL {

    public static final String HOST = Api.BaseUrl;

    /**
     * 阿里云参数获取地址
     */
    public static final String ALIYUN_OSS = HOST + "common/alioss/distribute_token";

    //帮助中心问题列表
    public static final String USD_PROBLEM_LIST = HOST + "set/helpCenter";
    //账户余额冻结详情
    public static final String USER_FREEZE_INFO = HOST + "wallet/freeAmountInfo";
    //校验支付密码
    public static final String USER_CHECK_PAY_PWD = HOST + "user/checkPayPwd";
    //個人信息
    public static final String USD_INFO = HOST + "user/userInfo";
    //个人认证信息
    public static final String USD_AUTH_INFO = HOST + "user/authInfo";
    //实名认证
    public static final String USD_AUTH = HOST + "user/authId";
    //我的总业绩
    public static final String USD_ACHIEVEMENT = HOST + "userNode/achievement";
    //登录
    public static final String USD_LOGIN = HOST + "user/login";
    //忘记登录密码
    public static final String USER_FORGET_PASSWORD = HOST + "user/forgetPwd";
    //退出登录
    public static final String USD_LOGOUT = HOST + "user/login_out";
    //登录
    public static final String USD_REGISTER = HOST + "user/register";
    //修改支付密码
    public static final String USER_RESET_PASSWORD = HOST + "user/updatePaymentPwd";
    //获取机器验证码图片
    public static final String USD_GET_CODE_PICTURE = HOST + "check/getCode";
    //获取机器验证码图片
    public static final String USD_GET_CODE_PICTURES = HOST + "check/getCodes";
    //校验机器验证码图片
    public static final String USD_CHECK_CODE = HOST + "check/checkCode";
    //校验机器验证码图片
    public static final String USD_CHECK_CODES = HOST + "check/checkCodes";
    //获取用户分享邀请二维码的奖励额度
    public static final String USD_SHARE_DATA = HOST + "invitaion/getQrCode";
    //短信发送
    public static final String USD_SEND_CODE = HOST + "sms/send";
    //短信校验
    public static final String USD_CHECK_MOBILE_CODE = HOST + "check/mobile/checkCode";
    //更换手机号
    public static final String USD_CHANGE_MOBILE = HOST + "user/changeMobile";
    //修改头像
    public static final String USD_UPDATE_AVATAR = HOST + "user/updateAvatar";
    //邀请统计，邀请人数，邀请金额
    public static final String USER_STATISTICS = HOST + "invitaion/statistice";
    //我的邀请奖励-直推 (邀请明细 )
    public static final String USER_QUERY_DIRECT_LIST = HOST + "invitaion/queryDirectList";
    //我的邀请奖励-直推+一代 (邀请明细 )
    public static final String USER_QUERY_ALL_DIRECT_LIST = HOST + "invitaion/list";
    //平台邀请轮播
    public static final String USER_QUERY_INVITAION_LIST = HOST + "invitaion/queryInvitaionList";

    //统计我邀请的人数、已开通节点的人数、成为节点的人数
    public static final String NODE_STATISTICS = HOST + "userNodeApply/statisticsV2";
    //我的节点-邀请列表
    public static final String NODE_APPLY_LIST = HOST + "userNodeApply/listV2";
    //添加节点备注
    public static final String NODE_UPDATE_REMARK = HOST + "userNodeApply/updateRemark";
    //节点列表
    public static final String NODE_LIST = HOST + "node/list";
    //提币规则说明
    public static final String NODE_RULE = HOST + "wallet/raiseInfo";
    //节点升级
    public static final String NODE_UPGRADE = HOST + "userNodeApply/nodeUpgrade";
    //检测用户是否是节点用户
    public static final String NODE_CHECK = HOST + "userNode/check";
    //给直推用户开通节点权限
    public static final String NODE_OPEN_NODE_FOR_MYTEAM = HOST + "userNodeApply/nodeAuthority";
    //申请成为商家
    public static final String NODE_APPLY_MERCHANT = HOST + "merchant/applyMerchant";
    //商家管理
    public static final String NODE_MERCHANT_LIST = HOST + "merchant/merchantList";
    //厂商列表
    public static final String NODE_FACTORY_LIST = HOST + "supply/supplyList";
    //申请成为商家
    public static final String NODE_APPLY_FACTORY = HOST + "supply/applySupply";
    //自己的商户详情
    public static final String NODE_MERCHANT_INFO = HOST + "merchant/myselfInfo";
    //自己接受商家邀请进行再次确认
    public static final String NODE_MERCHANT_APPLY = HOST + "merchant/applyConfirmMerchant";
    //自己的厂商详情
    public static final String NODE_FACTORY_INFO = HOST + "supply/myselfInfo";
    //自己接受厂家邀请进行再次确认
    public static final String NODE_FACTORY_APPLY = HOST + "supply/applyConfirmSupply";
    //子账户转币
    public static final String NODE_TAKE_SON_WALLET = HOST + "wallet/takeSonWallet";
    //子钱包信息
    public static final String NODE_SON_WALLET_INFO = HOST + "userProfitWallet/info";
    //子账户资金明细
    public static final String NODE_SON_WALLET_LIST = HOST + "wallet/sonWalletList";
    //子账户商家业务记录
    public static final String NODE_BUS_WALLET_LIST = HOST + "wallet/busWalletList";
    //账户余额资金明细详情
    public static final String NODE_WALLET_LIST_INFO = HOST + "wallet/walletListInfo";
    //节点-邀请奖励明细列表
    public static final String NODE_QUERY_INVITATION_LIST = HOST + "node/queryInvitationList";
    //用户未读消息总个数
    public static final String USER_UN_READ = HOST + "message/unreadCount";
    //钱包地址列表
    public static final String USER_WALLET_ADDRESS_LIST = HOST + "address/addressList";
    //钱包地址解绑
    public static final String USER_WALLET_ADDRESS_DEL = HOST + "address/delAddress";
    //商家退出
    public static final String USER_MERCHANT_OUT = HOST + "merchant/quitMerchant";
    //子钱包退出的保证金
    public static final String USER_WALLET_OUT = HOST + "wallet/outAmount";
    //查询当前登录人的节点基本信息
    public static final String USER_NODE_INFO = HOST + "userNode/getUserNodeUserInfo";
    //提币前置校验
    public static final String USER_WALLET_CHECK_TOCASH = HOST + "cash/checkTocash";
    //申请提币
    public static final String USER_WALLET_ADD_TOCASH = HOST + "cash/addCash";
    //提币记录【主账户】
    public static final String USER_WALLET_TOCASH_LIST = HOST + "cash/tocashList";
    //接收消息设置
    public static final String USER_SET_PUSH = HOST + "set/setPush";

    //向谁表达历史记录
    public static final String USER_HISTORY_USER_LIST = HOST + "love/historyUser";
    //爱的语词
    public static final String USER_LOVE_MESSAGE_LIST = HOST + "love/loveMsg";
    //更多爱（爱的分组）
    public static final String USER_MORE_LOVE_LIST = HOST + "love/moreLoveList";
    //爱情详情
    public static final String LOVE_LOVE_DETAIL = HOST + "love/loveInfo";
    //某某于某某的爱的足迹
    public static final String LOVE_LOVE_LIST = HOST + "love/loveList";
    //收到爱情表达消息列表
    public static final String LOVE_MESSAGE_LIST = HOST + "love/messageList";
    //与某某的水晶详情
    public static final String LOVE_DEFAUL_TRYSTAL_INFO = HOST + "love/defaultrystal";
    //更多水晶
    public static final String LOVE_MORE_TRYSTAL_INFO = HOST + "love/moreCrystal";
    //某某于某某的爱的足迹图像和时间
    public static final String LOVE_TOP_LOVE = HOST + "love/topLove";

    //消息统计个数【消息首页】
    public static final String URL_HOME_ACOUNT = HOST + "message/messageCount";
    //系统消息、收到表达列表
    public static final String URL_MESSAGE_LIST = HOST + "message/messageList";
    //系统公告、丘比特快讯
    public static final String URL_NOTICE_LIST = HOST + "notice/noticeList";
    //主页消息监听数据
    public static final String URL_MESSAGE_HOME = HOST + "message/noticeMain";
    //标记成已读消息
    public static final String URL_MESSAGE_SET_READ = HOST + "message/readMessage";
    //表达详情
    public static final String URL_LOVE_MESSAGE_INFO = HOST + "message/noticeInfo";
    //消息详情
    public static final String URL_SYSTEM_NOTICE_INFO = HOST + "notice/noticeInfo";

    //生态城市合伙人-释放、锁仓总额
    public static final String USER_LOCKED_RELEASE_INFO = HOST + "userEcologyPartnerLog/queryInfo2";
    //生态城市合伙人-释放记录
    public static final String USER_LOCKED_RELEASE_LIST = HOST + "userEcologyPartnerLog/queryList2";
    //爱情天使规则
    public static final String USER_SHARE_RULE = HOST + "invitaion/refreshQrCode";

    //检查版本更新
    public static final String USD_UPDATE = HOST + "edition/get";

}
