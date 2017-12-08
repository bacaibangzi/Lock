package com.sc.framework.security.util;

public class AccountConstants
{
    /**
     * 有效状态
     */
    public static final Integer ACCOUNT_ORG_EFFECT_ACTIVE        = 1;
    /**
     * 无效状态
     */
    public static final Integer ACCOUNT_ORG_EFFECT_UNACTIVE      = 0;
    /**
     * 当前可用状态账户
     */
    public static final Integer ACCOUNT_ACTIVE                   = 9;

    /**
     * 账户停用状态
     */
    public static final Integer ACCOUNT_STOP                     = 2;
    /**
     * 账户注销状态（即：删除状态）
     */
    public static final Integer ACCOUNT_UNACTIVE                 = 1;
    /**
     * 账户职位表数据有效状态
     */
    public static final Integer ACCOUNT_POSITION_FLAG_ACTIVE     = 1;
    /**
     * 账户职表数据位失效状态
     */
    public static final Integer ACCOUNT_POSITION_FLAG_UNACTIVE   = 0;
    /**
     * 编辑路径
     */
    public static final String  ACCOUNT_EDIT_URL                 = "/account/accountToEdit.action?id=";
    /**
     * 删除操作对应路径
     */
    public static final String  ACCOUNT_DELETE_URL               = "<a href=\"javascript:deleteOne('%id%')\">删除</a>";
    /**
     * 设置角色操作对应路径
     */
    public static final String  ACCOUNT_SETROLE_URL              = "<a href=\"javascript:openOneRoleTree('%id%')\">设置角色</a>";
    public static final String  ACCOUNT_SETPOSITION_URL          = "<a href=\"javascript:openOnePositionTree('%id%')\">设置职位</a>";
    /**
     * 用户删除错误信息
     */
    public static final String  ACCOUNT_LOG_DELETE_ERROR         = "用户删除失败";
    /**
     * 密码重置错误信息
     */
    public static final String  ACCOUNT_LOG_CHANGEPASSWORD_ERROR = "密码重置失败";
    /**
     * 账户停用
     */
    public static final String  ACCOUNT_LOGIN_UNACTIVE_ERROR     = "00010001";
    /**
     * 仅能从手机登录
     */
    public static final String  ACCOUNT_LOGIN_ONLYPHOHNE_ERROR   = "00010002";
    /**
     * 仅能从WEB登录
     */
    public static final String  ACCOUNT_LOGIN_ONLYWEB_ERROR      = "00010003";

    /**
     * 账户不存在
     */
    public static final String  ACCOUNT_NOT_EXSIT                = "00010004";

    /**
     * 账户名或密码错误
     */
    public static final String  ACCOUNT_LOGIN_AUTH_ERROR         = "00010005";

    /**
     * 账户名未审核
     */
    public static final String  ACCOUNT_NOT_SH         			 = "00010006";

    /**
     * 账户名停用
     */
    public static final String  ACCOUNT_NOT_SY         			 = "00010007";

    /**
     * 登录失败次数过多指定时间内限制登录
     */
    public static final String  ACCOUNT_LOGIN_ERROR_FOBIDDEN     = "00010008";

    /**
     * 登录失败SIM卡非指定运营商
     */
    public static final String  ACCOUNT_LOGIN_ERROR_SIMERROR     = "00010009";

    public static final String  ACCOUNT_DB_ERROR                 = "00010010";

    /**
     * 账户没有挂接员工异常
     */
    public static final String  ACCOUNT_ACCOUNT_EMP_EXCEPTION    = "00010011";

    /**
     * 登录账户所关联员工所在机构数据异常
     */
    public static final String  ACCOUNT_EMP_ORG_EXCEPTION        = "00010012";

    /**
     * 密码安全启用状态
     */
    public static final String  ACCOUNT_PASSWORD_SAFE            = "1";

    /**
     * 账户名未审核
     */
    public static final String  ACCOUNT_TIME_OUT         		 = "00010014";

}
