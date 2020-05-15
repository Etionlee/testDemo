package com.jrx.utils;

/**
 * Created by yxy on 2017/6/3.
 */
public interface Constants
{

    String PARAM_PAGE = "page";
    String PARAM_SIZE = "size";
    String ROWKEY = "rowkey";
    String STARTROW = "start_row";

    String APPID = "$appId";
    String EVENTID = "$eventId";
    String TIME = "$time";
    String MODE = "$mode";
    String PARAM_STARTTIME = "start_time";
    String PARAM_ENDTIME = "end_time";
    String UUID = "$uuid";
    String UUIDLENGTH = "uuidLength";

    String SERVICECODE = "serviceCode";
    String VERSION = "version";

    String EXP_SERVICECODE = "{serviceCode}";
    String EXP_VERSION = "{version}";

    String V2 = "v2";
    String V3 = "v3";

    String GB2312 = "GB2312";
    String GBK = "GBK";
    String UTF8 = "UTF-8";

    String CODE = "code";
    String DATA = "data";

    String FILE_PARAMS_MAP = "fileParams";

    String CHANNELCODE = "channelCode";
    String FEEDDATE = "feedDate";

    /**
     * hbase数据参数配置
     */

    public static String SN_RHZX_TABLE = "sn_rhzx"; // 遂宁人行征信数据表

    public static String COMM_FAMILY = "info";

    /**
     * 交易标志
     */
    public static String EXT_KEY = "extSuccess";

    /**
     * 交易标志内容 成功
     */
    public static boolean EXT_SUCCESS = true;

    public static String RH_FAIL = "1";

    public static String RH_KEY = "code";

    /** 返回请求方本系统错误信息的标志 */
    public static String ERR_CODE = "errCode";
    public static String ERR_INFO = "errInfo";

    public static String RH_TABLENAMEEN = "tableNameEN";
    public static String RH_TABLENAME = "tableName";
    public static String RH_COLUMNSEN = "columnsEN";
    public static String RH_COLUMNS = "columns";
    public static String RH_ROWS = "rows";
    public static String RH_RH = "rh_";
    public static String RH_REPORTSHOWS = "报告说明";
    public static String RH_WOBUZHIDAO001 = "附属信息类型001";
    public static String RH_WOBUZHIDAO002 = "附属信息类型002";
    public static String RH_WOBUZHIDAO003 = "附属信息类型003";
    public static String RH_WOBUZHIDAO = "附属信息类型";

    public static String RH_ORIGINALMMESSAGETABLE = "rh_originalmmessage";// 原始报文key

    public static String RH_HTMLORIGINALMMESSAGE = "htmlOriginalMmessage";// html原始报文key

    /** 接口 */
    public static String API_CERT_NO = "certNo";
    public static String API_CERT_TYPE = "certType";

    public static String API_NAME = "name";
    public static String API_MOBILE = "mobile";

    /** 人行 */
    public static String RH_FILE = "fileString";
    public static String RH_RESON = "reson";
    public static String RH_DATE = "date";
    public static String RH_MAC = "mac";

    public static String RH_QCERTTYPE_CODE = "0";

    public static String RH_QNAME = "QName";
    public static String RH_QCERTCODE = "QCertCode";
    public static String RH_QCERTTYPE = "QCertType";
    public static String RH_QRESON = "QReson";
    public static String RH_INPUTDATE = "inputDate";
    public static String RH_MACADDRESS = "macAddress";

    /** 银联智慧 */
    public static String UPS_IDENTITYCARD = "identityCard";
    public static String UPS_IDENTITYTYPE = "identityType";
    public static String UPS_ACCOUNT = "account";
    public static String UPS_ORDERID = "orderId";
    public static String UPS_CARD = "card";
    public static String UPS_INDEX = "index";
    public static String UPS_INDEX_ALL = "all";

    /** 芝麻信用 */
    /** 协议授权样例代码 */
    public static String ZM_TEST = "test";
    public static String ZM_API = "api";
    public static String ZM_APPPC = "apppc";
    public static String ZM_ZMOP = "zmop";
    public static String ZM_CHANNEL = "channel";
    public static String ZM_PLATFORM = "platform";
    public static String ZM_TRANSACTION_ID = "transactionId";
    public static String ZM_CONTRACT_FLAG = "contractFlag";
    public static String ZM_PRODUCT_CODE = "productCode";
    public static String ZM_IDENTITYTYPE = "identityType";
    public static String ZM_MOBILE_NO = "mobileNo";
    public static String ZM_AUTH_CODE = "auth_code";// 协议授权
    public static String ZM_CHANNELTYPE = "channelType";
    public static String ZM_STATE = "state";
    public static String ZM_BANKCARD = "bankCard";

    public static String ZM_IDENTITYTYPE_CODE = "2"; //
    public static String ZM_AUTH_CODE_CODE = "M_P_OPEN_ALIPAY";// 协议授权
    public static String ZM_CERT_TYPE_CODE = "IDENTITY_CARD";
    /** 芝麻返回数据处理：评分 */
    public static String ZM_SCORE = "zm_score";
    public static String ZM_SCORE_ORIGINAL = "zm_score_original";
    /** 芝麻返回数据处理：学历 */
    public static String ZM_EDUCATION_DEGREE = "education_degree";
    public static String ZM_EDUCATION_DEGREE_YS = "zm_education_degree_ys";
    public static String ZM_NINE = "9";
    /** 芝麻返回数据处理：元素 */
    public static String ZM_VARS = "vars";
    /** 返回数据处理：OPENID */

    /** 芝麻返回数据处理：反欺诈 */
    public static String ZM_PARAM = "params";
    public static String ZM_IVS_DETAIL_ONE = "ivs_detail";
    public static String ZM_IVS_DETAIL_TWO = "ivsDetail";
    public static String ZM_IVS_DETAIL_CODE = "code";
    public static String ZM_IVS_DETAIL_DESCRIPTION = "description";
    /** 芝麻返回数据处理：关注名单 */

    public static String ZM_WAT_DETAILS_KEY = "zm_wat_details";
    public static String ZM_WATCH_DETAILS = "details";
    public static String ZM_WATCH_EXTEND_INFO = "extend_info";
    public static String ZM_WATCH_KEY = "key";
    public static String ZM_WATCH_VALUE = "value";
    /** 芝麻回传 */
    public static String ZM_RECORDS = "records";

    /** 批量数据反馈服务 */
    public static String ZM_FB_FILE_TYPE = "fileType";
    public static String ZM_FB_FILE_CHARSET = "fileCharset";
    public static String ZM_FB_RECORDS = "records";
    public static String ZM_FB_COLUMNS = "columns";
    public static String ZM_FB_PRIMARY_KEY_COLUMNS = "primaryKeyColumns";
    public static String ZM_FB_TYPEID = "typeId";
    public static String ZM_FB_FILE = "file";

    public static String ZM_FB_FILE_NAME = "fileName";

    public static String ZM_FB_FILE_TYPE_CODE = "json_data";

    /** 百融 */
    /**
     * 百融返回数据标志
     */
    public static String BR_KEY = "code";
    public static String BR_REP_CODE = "00";// 成功码
    public static String BR_PACK_CODE = "00";// 成功码
    public static String BR_SOLO_CODE = "600000";// 成功码

    public static String BR_TOKEN_ID = "tokenid";// 登录接口校验id
    public static String BR_APINAME = "apiName";// 接口名称
    public static String BR_REQDATA = "reqData";// 接口请求体key
    public static String BR_SWIFT_NUMBER = "swift_number"; // 流水号
    public static String BR_ID = "id"; // 身份证号
    public static String BR_CELL = "cell"; // 手机号（打包调用支持最多5个手机号，建议第一个填常用手机号）
    public static String BR_NAME = "name"; // 姓名
    public static String BR_BANK_ID = "bank_id"; // 银行卡号
    public static String BR_MEAL = "meal";
    public static String BR_MAIL = "mail"; // 邮箱, 可选

    /** 鹏元 */

    public static String PY_KEY = "status"; //
    public static String PY_REP_CODE = "1"; //
    public static String PY_RETURNVALUE = "returnValue"; //
    public static String PY_CISREPORT = "cisReport";

    public static String PY_ESTIMATERESULT = "estimateResult";
    public static String PY_QUERYCONDITIONS = "queryConditions";
    public static String PY_LASTEDUCATIONINFO = "lastEducationInfo";

    public static String PY_QUERY_TYPE = "queryType";
    public static String PY_QUERY_CONDITIONS = "conditions";
    public static String PY_QUERY_CONDITION = "condition";

    public static String PY_ITEM = "item";
    public static String PY_NAME = "name";
    public static String PY_VALUE = "value";
    public static String PY_CERTNO = "documentNo";
    public static String PY_PHONE = "phone";
    public static String PY_QUERYREASONID = "queryReasonID";
    public static String PY_SUBREPORTIDS = "subreportIDs";
    public static String PY_REFID = "refID";
    public static String PY_PERSONANTISPOOFINGDESCINFO = "personAntiSpoofingDescInfo";
    public static String PY_PERSONRISKINFO = "personRiskInfo";
    public static String PY_MICRONEARLYTHREEYEARSOVERDUEINFO = "microNearlyThreeYearsOverdueInfo";
    public static String PY_PERSONANTISPOOFINGINFO = "personAntiSpoofingInfo";
    public static String PY_HISTORYSIMPLEQUERYINFO = "historySimpleQueryInfo";
    public static String PY_ECONNOISSERURINFO = "econnoisserurInfo";
    public static String PY_FRAUDRISKINFO = "fraudRiskInfo";

    public static String PY_QUERY_TYPE_CODE_25220 = "25220"; // 25220个人偿债能力分析_主机对主机查询
    public static String PY_QUERY_TYPE_CODE_25134 = "25134"; // 最高学历信息查询
    public static String PY_QUERY_TYPE_CODE_25136 = "25136"; // 最高学历信息查询（子报告11117查询类型）
    public static String PY_QUERY_TYPE_CODE_25196 = "25196"; // 鹏元手机三要素验证
    /** 鹏元个人反欺诈分析 */
    public static String PY_QUERY_TYPE_CODE_25212 = "25212";
    /** 鹏元收费子报告: 个人反欺诈分析 */
    public static String PY_SUBREPORTID_96042 = "96042";
    public static String PY_SUBREPORTID_13612 = "13612"; // 收费子报告: 13612手机三要素验证
    public static String PY_SUBREPORTID_14009 = "14009"; // 收费子报告: 14009个人偿债能力分析
    public static String PY_SUBREPORTID_11110 = "11110"; // 收费子报告: 11110最高学历查询
    public static String PY_SUBREPORTID_11117 = "11117"; // 收费子报告: 11110最高学历查询
    public static String PY_QUERYREASONID_101 = "101"; // <!--查询原因：贷款审批 101 、贷后管理 102 、贷款催收 103-->
    public static String PY_QUERYREASONID_102 = "102";
    public static String PY_QUERYREASONID_103 = "103";

    public static String PY_TREATRESULT_1 = "1"; // 查得
    public static String PY_TREATRESULT_2 = "2"; // 未查得
    public static String PY_TREATRESULT_3 = "3"; // 其他

    // 14009（个人偿债能力分析）
    // 14007（个人偿债能力分析）

    /** 数聚魔盒 */

    // https://api.shujumohe.com/octopus/task.unify.create/v3?partner_code=合作方标 识&partner_key=合作方密钥
    // https://api.shujumohe.com/octopus/pbccrc.unify.acquire/v3?partner_code=合作 方标识&partner_key=合作方密钥
    // https://api.shujumohe.com/octopus/task.unify.retry/v3?partner_code=合作方标识 &partner_key=合作方密钥
    // https://api.shujumohe.com/octopus/task.unify.query/v3?partner_code=合作方标 识&partner_key=合作方密钥

    // https://api.shujumohe.com/octopus/task.unify.channel/v3?partner_code=合作方标识 &partner_key=合作方密钥
    // https://api.shujumohe.com/octopus/task.unify.field/v3?partner_code=合作方标识 &partner_key=合作方密钥
    // https://api.shujumohe.com/octopus/wxyj.unify.acquire/v3?partner_code=合作方标识 &partner_key=合作方密钥
    public static String MH_SERVICE_TASK_UNIFY_CREATE = "task.unify.create";
    public static String MH_SERVICE_PBCCRC_UNIFY_ACQUIRE = "pbccrc.unify.acquire"; // 登录验证-个人信用报告
    public static String MH_SERVICE_WXYJ_UNIFY_ACQUIRE = "wxyj.unify.acquire"; // 登录验证-社保公积金
    public static String MH_SERVICE_TASK_UNIFY_RETRY = "task.unify.retry"; // 重试验证码
    public static String MH_SERVICE_TASK_UNIFY_QUERY = "task.unify.query"; // 查询任务结果
    public static String MH_SERVICE_TASK_UNIFY_CHANNEL = "task.unify.channel"; // 查询城市列表
    public static String MH_SERVICE_TASK_UNIFY_FIELD = "task.unify.field"; // 查询登录要素
    public static String MH_SERVICE_REPORT_TASK_QUERY = "report.task.query"; // 个人报告查询

    public static String MH_PARTNER_CODE = "partner_code";
    public static String MH_PARTNER_KEY = "partner_key";

    public static String MH_EXP_PARTNER_CODE = "{partner_code}";
    public static String MH_EXP_PARTNER_KEY = "{partner_key}";

    /** 联通 */
    public static String LT_TELNO = "telNo";
    public static String LT_IDCARD = "idcard";
    public static String LT_STATUS = "status";
    public static String LT_CODE = "code";
    public static String LT_ERRORDESC = "errorDesc";
    public static String LT_SENDTELNO = "sendTelNo";
    public static String LT_USERNAME = "userName";
    public static String LT_CERTTYPE = "certType";
    public static String LT_CERTCODE = "certCode";
    public static String LT_LONGITUDE = "longitude";
    public static String LT_LATITUDE = "latitude";
    public static String LT_MONTH = "month";
    public static String LT_CHECKTELNO = "checkTelNo";

    /** 智慧足迹 */
    public static String ZHZJ_TELNO = "telNo";
    public static String ZHZJ_NAME = "name";
    public static String ZHZJ_CERTTYPE = "certType";
    public static String ZHZJ_ID = "id";

    /** 同盾数据 */
    public static String TD_NAME = "name";
    public static String TD_ID_NUMBER = "id_number";
    public static String TD_CARD_NUMBER = "card_number";
    public static String TD_QQ = "qq";
    public static String TD_EMAIL = "email";
    public static String TD_MOBILE = "mobile";
    public static String TD_SUCCESS = "success";
    public static String TD_REASON_DESC = "reason_desc";
    public static int TD_COUNTS = 5; // 如未成功生成报告，调用接口次数
    public static int TD_SLEEPTIME = 3000; // 调用接口之间间隔时间
    public static String TD_REPORT_ID = "report_id";
    public static String TD_FINAL_SCORE = "final_score";
    public static String TD_FINAL_DECISION = "final_decision";
    public static String TD_REPORT_TIME = "report_time";
    public static String TD_APPLICATION_ID = "application_id";
    public static String TD_APPLY_TIME = "apply_time";
    public static String TD_ADDRESS_DETECT = "address_detect"; // 同盾地址信息字段
    public static String TD_BANK_CARD_ADDRESS = "bank_card_address";
    public static String TD_MOBILE_ADDRESS = "mobile_address";
    public static String TD_ID_CARD_ADDRESS = "id_card_address";
    public static String TD_RISK_ITEMS = "risk_items";
    public static String TD_ITEM_ID = "item_id";
    public static String TD_RISK_LEVEL = "risk_level";
    public static String TD_ITEM_NAME = "item_name";
    public static String TD_ITEM_DETAIL = "item_detail";
    public static String TD_NAMELIST_HIT_DETAILS = "namelist_hit_details";
    public static String TD_HIT_TYPE_DISPLAYNAME = "hit_type_displayname";
    public static String TD_COURT_DETAILS = "court_details";
    public static String TD_FRAUD_TYPE = "fraud_type";
    public static String TD_FILING_TIME = "filing_time";
    public static String TD_DISCREDIT_DETAIL = "discredit_detail";
    public static String TD_SITUATION = "situation";
    public static String TD_DESCRIPTION = "description";
    public static String TD_FUZZY_DETAIL_HITS = "fuzzy_detail_hits";
    public static String TD_OVERDUE_DETAILS = "overdue_details";
    public static String TD_OVERDUE_AMOUNT_RANGE = "overdue_amount_range";
    public static String TD_OVERDUE_DAY_RANGE = "overdue_day_range";
    public static String TD_OVERDUE_COUNT = "overdue_count";
    public static String TD_OVERDUE_TIME = "overdue_time";

    /** 优啦 */
    public static String YL_APPID = "appId";
    public static String YL_USERNAME = "username";
    public static String YL_PASSWORD = "password";
    public static String YL_SCRECT = "screct";
    public static String YL_NAME = "name";
    public static String YL_MOBILE = "mobile";
    public static String YL_IDCARDNUM = "idcardnum";
    public static String YL_STATUS = "status";
    public static String YL_CODE = "code";
    public static String YL_MESSAGE = "message";
    public static String YL_LIST = "list";
    public static String YL_OBJ = "obj";
    public static String YL_OBJ_PHONE = "obj_phone";
    public static String YL_OBJ_PHONETOTALS = "obj_phoneTotals";

    /** ESB */
    public static String ESB_USERID = "userId";
    public static String ESB_IDENTNO = "identNo";
    public static String ESB_MOBILE = "mobile";
    public static String ESB_CUSTOMERNAME = "customerName";

}
