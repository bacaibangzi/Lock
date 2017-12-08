package com.sc.framework.session.util;

import java.util.HashMap;
import java.util.Map;

import com.sc.framework.enums.CardStateEnum;
import com.sc.framework.enums.CardTypes;
import com.sc.framework.enums.DttChLowModeEnum;
import com.sc.framework.enums.DttChServiceModeEnum;
import com.sc.framework.enums.ICReaderWriter;
import com.sc.framework.enums.IntegralRange;
import com.sc.framework.enums.InventoryType;
import com.sc.framework.enums.IsRounding;
import com.sc.framework.enums.Isintegral;
import com.sc.framework.enums.MemberStateEnum;
import com.sc.framework.enums.MemberTypes;
import com.sc.framework.enums.OrgTypeEnum;
import com.sc.framework.enums.PreferentialWay;
import com.sc.framework.enums.Pricekind;
import com.sc.framework.enums.ReaderWriterPort;
import com.sc.framework.enums.ReportTcqkTypeEnum;
import com.sc.framework.enums.ReportTypeEnum;
import com.sc.framework.enums.ReportXiaofphtjTypeEnum;
import com.sc.framework.enums.ReportYinysrTypeEnum;
import com.sc.framework.enums.RiyzTypeEnum;
import com.sc.framework.enums.TcEnum;
import com.sc.framework.enums.UserTypeEnum;
import com.sc.framework.enums.WeixinMenuTypeEnum;
import com.sc.framework.enums.WinXiQueueEnum;

public class SessionConstants {

	public static final String app_login_error_key = "icube_app_errorMap";
	
	public static final Map<Long,String> user_sex = new HashMap<Long,String>();
	public static final Map<Long,String> menu_level = new HashMap<Long,String>();
	public static final Map<Long,String> user_sh = new HashMap<Long,String>();
	public static final Map<Long,String> user_type = new HashMap<Long,String>();
	public static final Map<Long,String> num_type = new HashMap<Long,String>();
	
	
	public static final Map<Long,String> dtt_ch_low_mode = new HashMap<Long,String>();
	public static final Map<Long,String> dtt_ch_service_mode = new HashMap<Long,String>();
	public static final Map<Long,String> tc_mode = new HashMap<Long,String>();
	
	public static final Map<String,String> member_types = new HashMap<String,String>();
	public static final Map<String,String> preferential_way = new HashMap<String,String>();
	public static final Map<String,String> is_integral = new HashMap<String,String>();
	public static final Map<String,String> is_rounding = new HashMap<String,String>();
	public static final Map<Long,String> integral_range = new HashMap<Long,String>();
	
	public static final Map<String,String> card_types = new HashMap<String,String>();
	public static final Map<String,String> IC_reader_writer = new HashMap<String,String>();
	public static final Map<String,String> reader_writer_port = new HashMap<String,String>();
	
	public static final Map<Long,String> report_type = new HashMap<Long,String>();
	public static final Map<Long,String> report_yinysr_typey = new HashMap<Long,String>();
	public static final Map<Long,String> report_tcqk_typey = new HashMap<Long,String>();
	public static final Map<Long,String> report_xfphtj_typey = new HashMap<Long,String>();
	public static final Map<String,String> report_riyz_type = new HashMap<String,String>();
	
	public static final Map<Long,String> service_Mode = new HashMap<Long, String>();
	public static final Map<String,String> card_state = new HashMap<String, String>();
	public static final Map<Long,String> member_state = new HashMap<Long, String>();

	public static final Map<Long,String> weixin_menu_type = new HashMap<Long,String>();
	
	public static final Map<Long,String> weixin_queue_type = new HashMap<Long,String>();
	
	public static final Map<Long,String> org_type = new HashMap<Long,String>();
	
	public static final Map<String,String> inventory_type = new HashMap<String, String>();
	
	public static final Map<String,String> ch_pricekind = new HashMap<String, String>();
	
	static{
		// sex
		/*
		user_sex.put(0L, "woman");
		user_sex.put(1L, "male");
		*/
		user_sex.put(0L, "女");
		user_sex.put(1L, "男");
		// level
		
		// sh
		/*
		user_sh.put(-1L, "All");
		user_sh.put(0L, "Unaudited");
		user_sh.put(1L, "Audited");
		user_sh.put(9L, "Disable"); 
		*/
		user_sh.put(-1L, "全部");
		//user_sh.put(0L, "未审核");
		user_sh.put(1L, "启用");
		user_sh.put(9L, "禁用"); 
		
		//num_type
		num_type.put(2L, "小数");
		num_type.put(1L, "整数");
		
		// 低消方式
		for(DttChLowModeEnum e : DttChLowModeEnum.values()){
			dtt_ch_low_mode.put(e.id(), e.value());
		}
		
		// 服务模式
		for(DttChServiceModeEnum e : DttChServiceModeEnum.values()){
			dtt_ch_service_mode.put(e.id(), e.value());
		}
		
		// 比例提成，定额提成
		for(TcEnum e : TcEnum.values()){
			tc_mode.put(e.id(), e.value());
		}
		
		//会员种类
		for(MemberTypes e : MemberTypes.values()){
			member_types.put(e.id(), e.value());
		} 
		
		//优惠方式
		for(PreferentialWay e : PreferentialWay.values()){
			preferential_way.put(e.id(), e.value());
		}
		
		//是否积分
		for(Isintegral e : Isintegral.values()){
			is_integral.put(e.id(), e.value());
		}
		
		//是否取整
		for(IsRounding e : IsRounding.values()){
			is_rounding.put(e.id(), e.value());
		}
		
		//消费积分范围
		for(IntegralRange e : IntegralRange.values()){
			integral_range.put(e.id(), e.value());
		}
		
		//卡类型
		for(CardTypes e : CardTypes.values()){
			card_types.put(e.id(), e.value());
		}
		
		//卡读写器
		for(ICReaderWriter e : ICReaderWriter.values()){
			IC_reader_writer.put(e.id(), e.value());
		}
		
		//IC卡读写器端口
		for(ReaderWriterPort e : ReaderWriterPort.values()){
			reader_writer_port.put(e.id(), e.value());
		}
		
		// 报表类型
		for(ReportTypeEnum e: ReportTypeEnum.values()){
			report_type.put(e.id(), e.value());
		}
		
		// 
		for(ReportYinysrTypeEnum e: ReportYinysrTypeEnum.values()){
			report_yinysr_typey.put(e.id(), e.value());
		}

		// 
		for(ReportTcqkTypeEnum e: ReportTcqkTypeEnum.values()){
			report_tcqk_typey.put(e.id(), e.value());
		}
		// 
		for(ReportXiaofphtjTypeEnum e: ReportXiaofphtjTypeEnum.values()){
			report_xfphtj_typey.put(e.id(), e.value());
		}
		// 
		for(RiyzTypeEnum e: RiyzTypeEnum.values()){
			report_riyz_type.put(e.id(), e.value());
		}
		//服务模式
		for(DttChServiceModeEnum e: DttChServiceModeEnum.values()){
			service_Mode.put(e.id(), e.value());
		}
		//持卡状态
		for(CardStateEnum e: CardStateEnum.values()){
			card_state.put(e.id(), e.value());
		}
		//会员状态
		for(MemberStateEnum e: MemberStateEnum.values()){
			member_state.put(e.id(), e.value());
		}
		
		// 微信菜单
		for(WeixinMenuTypeEnum e: WeixinMenuTypeEnum.values()){
			weixin_menu_type.put(e.id(), e.value());
		}
		
		// 微信排号状态 
		for(WinXiQueueEnum e: WinXiQueueEnum.values()){
			weixin_queue_type.put(e.id(), e.value());
		}
		
		// 组织机构状态
		for(OrgTypeEnum e: OrgTypeEnum.values()){
			org_type.put(e.id(), e.value());
		}
		
		// 出库类型
		for(InventoryType e:InventoryType.values()){
			inventory_type.put(e.id(), e.value());
		}
		
		// 会员类型
		for(Pricekind e:Pricekind.values()){
			ch_pricekind.put(e.id(), e.value());
		}
		for(UserTypeEnum e:UserTypeEnum.values()){
			user_type.put(e.id(), e.value());
		}
	}
	
}
