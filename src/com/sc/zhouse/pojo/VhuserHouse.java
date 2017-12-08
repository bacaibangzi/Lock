package com.sc.zhouse.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class VhuserHouse implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///date formats
	public static final String FORMAT_FA_BU_SHI_JIAN = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd hh:mm";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String biaoTi;
	private java.lang.String fangShi;
	private java.lang.String jianZhuMianJi;
	private java.lang.String huXing1;
	private java.lang.String huXing2;
	private java.lang.String huXing3;
	private java.lang.String chaoXiang;
	private java.lang.String zhuangXiu;
	private java.lang.String zuJin;
	private java.lang.String ptChuang;
	private java.lang.String ptKuangDai;
	private java.lang.String ptDianShi;
	private java.lang.String ptXiYiJi;
	private java.lang.String ptNuanQi;
	private java.lang.String ptKongTiao;
	private java.lang.String ptBinXiang;
	private java.lang.String ptReShuiQi;
	private java.lang.String fangWuMiaoShu;
	private java.lang.String xiaoQuMiaoShu;
	private java.lang.String lianXiRen;
	private java.lang.String lianXiDianHua;
	private java.lang.String diZhi;
	private java.lang.Double lon;
	private java.lang.Double lat;
	private java.util.Date faBuShiJian;
	private java.lang.Integer shenHe;
	private java.lang.String shen;
	private java.lang.String shi;
	private java.lang.String quYu;
	private java.lang.String xiaoQu;
	private java.lang.String xiaoQuMingCheng;
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.lang.String img1Path;
	private java.lang.String img2Path;
	private java.lang.String img3Path;
	private java.lang.String img4Path;
	private java.lang.Integer type;
	private java.lang.String uiLoginName;
	private java.lang.String uiMobile;
	private java.util.Date date;
	private String param1;
	private String uhSn;
	private java.lang.Integer userId1;
	///columns END

	public VhuserHouse(){
	}

	public java.lang.Integer getUserId1() {
		return userId1;
	}

	public void setUserId1(java.lang.Integer userId1) {
		this.userId1 = userId1;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
	}
	
	public String getUhSn() {
		return uhSn;
	}

	public void setUhSn(String uhSn) {
		this.uhSn = uhSn;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getDateString()
    {
		return DateConvertUtils.format(getDate(), FORMAT_DATE);
	}
	public void setDateString(String value)
    {
		setDate(DateConvertUtils.parse(value, FORMAT_DATE,java.util.Date.class));
	}
	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setBiaoTi(java.lang.String value)
    {
		this.biaoTi = value;
	}
	
	public java.lang.String getBiaoTi()
    {
		return this.biaoTi;
	}
	public void setFangShi(java.lang.String value)
    {
		this.fangShi = value;
	}
	
	public java.lang.String getFangShi()
    {
		return this.fangShi;
	}
	public void setJianZhuMianJi(java.lang.String value)
    {
		this.jianZhuMianJi = value;
	}
	
	public java.lang.String getJianZhuMianJi()
    {
		return this.jianZhuMianJi;
	}
	public void setHuXing1(java.lang.String value)
    {
		this.huXing1 = value;
	}
	
	public java.lang.String getHuXing1()
    {
		return this.huXing1;
	}
	public void setHuXing2(java.lang.String value)
    {
		this.huXing2 = value;
	}
	
	public java.lang.String getHuXing2()
    {
		return this.huXing2;
	}
	public void setHuXing3(java.lang.String value)
    {
		this.huXing3 = value;
	}
	
	public java.lang.String getHuXing3()
    {
		return this.huXing3;
	}
	public void setChaoXiang(java.lang.String value)
    {
		this.chaoXiang = value;
	}
	
	public java.lang.String getChaoXiang()
    {
		return this.chaoXiang;
	}
	public void setZhuangXiu(java.lang.String value)
    {
		this.zhuangXiu = value;
	}
	
	public java.lang.String getZhuangXiu()
    {
		return this.zhuangXiu;
	}
	public void setZuJin(java.lang.String value)
    {
		this.zuJin = value;
	}
	
	public java.lang.String getZuJin()
    {
		return this.zuJin;
	}
	public void setPtChuang(java.lang.String value)
    {
		this.ptChuang = value;
	}
	
	public java.lang.String getPtChuang()
    {
		return this.ptChuang;
	}
	public void setPtKuangDai(java.lang.String value)
    {
		this.ptKuangDai = value;
	}
	
	public java.lang.String getPtKuangDai()
    {
		return this.ptKuangDai;
	}
	public void setPtDianShi(java.lang.String value)
    {
		this.ptDianShi = value;
	}
	
	public java.lang.String getPtDianShi()
    {
		return this.ptDianShi;
	}
	public void setPtXiYiJi(java.lang.String value)
    {
		this.ptXiYiJi = value;
	}
	
	public java.lang.String getPtXiYiJi()
    {
		return this.ptXiYiJi;
	}
	public void setPtNuanQi(java.lang.String value)
    {
		this.ptNuanQi = value;
	}
	
	public java.lang.String getPtNuanQi()
    {
		return this.ptNuanQi;
	}
	public void setPtKongTiao(java.lang.String value)
    {
		this.ptKongTiao = value;
	}
	
	public java.lang.String getPtKongTiao()
    {
		return this.ptKongTiao;
	}
	public void setPtBinXiang(java.lang.String value)
    {
		this.ptBinXiang = value;
	}
	
	public java.lang.String getPtBinXiang()
    {
		return this.ptBinXiang;
	}
	public void setPtReShuiQi(java.lang.String value)
    {
		this.ptReShuiQi = value;
	}
	
	public java.lang.String getPtReShuiQi()
    {
		return this.ptReShuiQi;
	}
	public void setFangWuMiaoShu(java.lang.String value)
    {
		this.fangWuMiaoShu = value;
	}
	
	public java.lang.String getFangWuMiaoShu()
    {
		return this.fangWuMiaoShu;
	}
	public void setXiaoQuMiaoShu(java.lang.String value)
    {
		this.xiaoQuMiaoShu = value;
	}
	
	public java.lang.String getXiaoQuMiaoShu()
    {
		return this.xiaoQuMiaoShu;
	}
	public void setLianXiRen(java.lang.String value)
    {
		this.lianXiRen = value;
	}
	
	public java.lang.String getLianXiRen()
    {
		return this.lianXiRen;
	}
	public void setLianXiDianHua(java.lang.String value)
    {
		this.lianXiDianHua = value;
	}
	
	public java.lang.String getLianXiDianHua()
    {
		return this.lianXiDianHua;
	}
	public void setDiZhi(java.lang.String value)
    {
		this.diZhi = value;
	}
	
	public java.lang.String getDiZhi()
    {
		return this.diZhi;
	}
	public void setLon(java.lang.Double value)
    {
		this.lon = value;
	}
	
	public java.lang.Double getLon()
    {
		return this.lon;
	}
	public void setLat(java.lang.Double value)
    {
		this.lat = value;
	}
	
	public java.lang.Double getLat()
    {
		return this.lat;
	}
	public String getFaBuShiJianString()
    {
		return DateConvertUtils.format(getFaBuShiJian(), FORMAT_FA_BU_SHI_JIAN);
	}
	public void setFaBuShiJianString(String value)
    {
		setFaBuShiJian(DateConvertUtils.parse(value, FORMAT_FA_BU_SHI_JIAN,java.util.Date.class));
	}
	
	public void setFaBuShiJian(java.util.Date value)
    {
		this.faBuShiJian = value;
	}
	
	public java.util.Date getFaBuShiJian()
    {
		return this.faBuShiJian;
	}
	public void setShenHe(java.lang.Integer value)
    {
		this.shenHe = value;
	}
	
	public java.lang.Integer getShenHe()
    {
		return this.shenHe;
	}
	public void setShen(java.lang.String value)
    {
		this.shen = value;
	}
	
	public java.lang.String getShen()
    {
		return this.shen;
	}
	public void setShi(java.lang.String value)
    {
		this.shi = value;
	}
	
	public java.lang.String getShi()
    {
		return this.shi;
	}
	public void setQuYu(java.lang.String value)
    {
		this.quYu = value;
	}
	
	public java.lang.String getQuYu()
    {
		return this.quYu;
	}
	public void setXiaoQu(java.lang.String value)
    {
		this.xiaoQu = value;
	}
	
	public java.lang.String getXiaoQu()
    {
		return this.xiaoQu;
	}
	public void setXiaoQuMingCheng(java.lang.String value)
    {
		this.xiaoQuMingCheng = value;
	}
	
	public java.lang.String getXiaoQuMingCheng()
    {
		return this.xiaoQuMingCheng;
	}
	public void setUserId(java.lang.Integer value)
    {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId()
    {
		return this.userId;
	}
	public void setUserName(java.lang.String value)
    {
		this.userName = value;
	}
	
	public java.lang.String getUserName()
    {
		return this.userName;
	}
	public void setImg1Path(java.lang.String value)
    {
		this.img1Path = value;
	}
	
	public java.lang.String getImg1Path()
    {
		return this.img1Path;
	}
	public void setImg2Path(java.lang.String value)
    {
		this.img2Path = value;
	}
	
	public java.lang.String getImg2Path()
    {
		return this.img2Path;
	}
	public void setImg3Path(java.lang.String value)
    {
		this.img3Path = value;
	}
	
	public java.lang.String getImg3Path()
    {
		return this.img3Path;
	}
	public void setImg4Path(java.lang.String value)
    {
		this.img4Path = value;
	}
	
	public java.lang.String getImg4Path()
    {
		return this.img4Path;
	}
	public void setType(java.lang.Integer value)
    {
		this.type = value;
	}
	
	public java.lang.Integer getType()
    {
		return this.type;
	}
	public void setUiLoginName(java.lang.String value)
    {
		this.uiLoginName = value;
	}
	
	public java.lang.String getUiLoginName()
    {
		return this.uiLoginName;
	}
	public void setUiMobile(java.lang.String value)
    {
		this.uiMobile = value;
	}
	
	public java.lang.String getUiMobile()
    {
		return this.uiMobile;
	}

    /**
     * @brief   功能: 将VhuserHouse对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("BiaoTi",getBiaoTi())
			.append("FangShi",getFangShi())
			.append("JianZhuMianJi",getJianZhuMianJi())
			.append("HuXing1",getHuXing1())
			.append("HuXing2",getHuXing2())
			.append("HuXing3",getHuXing3())
			.append("ChaoXiang",getChaoXiang())
			.append("ZhuangXiu",getZhuangXiu())
			.append("ZuJin",getZuJin())
			.append("PtChuang",getPtChuang())
			.append("PtKuangDai",getPtKuangDai())
			.append("PtDianShi",getPtDianShi())
			.append("PtXiYiJi",getPtXiYiJi())
			.append("PtNuanQi",getPtNuanQi())
			.append("PtKongTiao",getPtKongTiao())
			.append("PtBinXiang",getPtBinXiang())
			.append("PtReShuiQi",getPtReShuiQi())
			.append("FangWuMiaoShu",getFangWuMiaoShu())
			.append("XiaoQuMiaoShu",getXiaoQuMiaoShu())
			.append("LianXiRen",getLianXiRen())
			.append("LianXiDianHua",getLianXiDianHua())
			.append("DiZhi",getDiZhi())
			.append("Lon",getLon())
			.append("Lat",getLat())
			.append("FaBuShiJian",getFaBuShiJian())
			.append("ShenHe",getShenHe())
			.append("Shen",getShen())
			.append("Shi",getShi())
			.append("QuYu",getQuYu())
			.append("XiaoQu",getXiaoQu())
			.append("XiaoQuMingCheng",getXiaoQuMingCheng())
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("Img1Path",getImg1Path())
			.append("Img2Path",getImg2Path())
			.append("Img3Path",getImg3Path())
			.append("Img4Path",getImg4Path())
			.append("Type",getType())
			.append("UiLoginName",getUiLoginName())
			.append("UiMobile",getUiMobile())
			.toString();
	}
	
    /**
     * @brief   功能: 
     * @param   
     * @return  
     */
	public int hashCode()
    {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个VhuserHouse对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof VhuserHouse == false) return false;
		if(this == obj) return true;
		VhuserHouse other = (VhuserHouse)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

