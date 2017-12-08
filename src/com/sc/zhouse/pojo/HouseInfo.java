
package com.sc.zhouse.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.base.pojo.CubeBaseEntity;
import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class HouseInfo  extends CubeBaseEntity implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///date formats
	public static final String FORMAT_FA_BU_SHI_JIAN = "yyyy-MM-dd HH:mm:ss";
	
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
	private java.lang.String diZhi;
	private java.lang.Double lon;
	private java.lang.Double lat;
	private java.util.Date faBuShiJian;
	private java.lang.Integer shenHe;
	private java.lang.String shen;
	private java.lang.String shi;
	private java.lang.String quYu;
	private java.lang.String xiaoQu;
	private String xiaoQuMingCheng;
	private java.lang.Integer userId;
	private String userName;
	private String img1Path ="";
	private String img2Path ="";
	private String img3Path ="";
	private String img4Path ="";
	private String img5Path ="";
	private String img6Path ="";
	private String img7Path ="";
	private String img8Path ="";
	private String img9Path ="";
	private String img10Path ="";
	private String zuJin;
	private String lianXiRen;
	private String lianXiDianHua;
	private String shenHeStr;
	
	///columns END

	public HouseInfo(){
	}

	public HouseInfo(
		java.lang.Integer sn
	){
		this.sn = sn;
	}

	public String getShenHeStr() {
		return shenHeStr;
	}

	public void setShenHeStr(String shenHeStr) {
		this.shenHeStr = shenHeStr;
	}

	public java.lang.String getHuXing1() {
		return huXing1;
	}

	public void setHuXing1(java.lang.String huXing1) {
		this.huXing1 = huXing1;
	}

	public java.lang.String getHuXing2() {
		return huXing2;
	}

	public void setHuXing2(java.lang.String huXing2) {
		this.huXing2 = huXing2;
	}

	public java.lang.String getHuXing3() {
		return huXing3;
	}

	public void setHuXing3(java.lang.String huXing3) {
		this.huXing3 = huXing3;
	}

	public String getXiaoQuMingCheng() {
		return xiaoQuMingCheng;
	}

	public void setXiaoQuMingCheng(String xiaoQuMingCheng) {
		this.xiaoQuMingCheng = xiaoQuMingCheng;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		this.idStr = String.valueOf(value);
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
		if(value==0){
			this.shenHeStr = "未审核";
		}else if(value==1){
			this.shenHeStr = "通过";
		}
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
	public void setUserId(java.lang.Integer value)
    {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId()
    {
		return this.userId;
	}

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImg1Path() {
		return img1Path;
	}

	public void setImg1Path(String img1Path) {
		this.img1Path = img1Path;
	}

	public String getImg2Path() {
		return img2Path;
	}

	public void setImg2Path(String img2Path) {
		this.img2Path = img2Path;
	}

	public String getImg3Path() {
		return img3Path;
	}

	public void setImg3Path(String img3Path) {
		this.img3Path = img3Path;
	}

	public String getImg4Path() {
		return img4Path;
	}

	public void setImg4Path(String img4Path) {
		this.img4Path = img4Path;
	}

	public String getZuJin() {
		return zuJin;
	}

	public void setZuJin(String zuJin) {
		this.zuJin = zuJin;
	}

	public String getLianXiRen() {
		return lianXiRen;
	}

	public void setLianXiRen(String lianXiRen) {
		this.lianXiRen = lianXiRen;
	}

	public String getLianXiDianHua() {
		return lianXiDianHua;
	}

	public void setLianXiDianHua(String lianXiDianHua) {
		this.lianXiDianHua = lianXiDianHua;
	}

	public String getImg5Path() {
		return img5Path;
	}

	public void setImg5Path(String img5Path) {
		this.img5Path = img5Path;
	}

	public String getImg6Path() {
		return img6Path;
	}

	public void setImg6Path(String img6Path) {
		this.img6Path = img6Path;
	}

	public String getImg7Path() {
		return img7Path;
	}

	public void setImg7Path(String img7Path) {
		this.img7Path = img7Path;
	}

	public String getImg8Path() {
		return img8Path;
	}

	public void setImg8Path(String img8Path) {
		this.img8Path = img8Path;
	}

	public String getImg9Path() {
		return img9Path;
	}

	public void setImg9Path(String img9Path) {
		this.img9Path = img9Path;
	}

	public String getImg10Path() {
		return img10Path;
	}

	public void setImg10Path(String img10Path) {
		this.img10Path = img10Path;
	}

	/**
     * @brief   功能: 将HouseInfo对象数据进行串化
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
			.append("ChaoXiang",getChaoXiang())
			.append("ZhuangXiu",getZhuangXiu())
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
			.append("DiZhi",getDiZhi())
			.append("Lon",getLon())
			.append("Lat",getLat())
			.append("FaBuShiJian",getFaBuShiJian())
			.append("ShenHe",getShenHe())
			.append("Shen",getShen())
			.append("Shi",getShi())
			.append("QuYu",getQuYu())
			.append("XiaoQu",getXiaoQu())
			.append("UserId",getUserId())
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
			.append(getSn())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个HouseInfo对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof HouseInfo == false) return false;
		if(this == obj) return true;
		HouseInfo other = (HouseInfo)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

