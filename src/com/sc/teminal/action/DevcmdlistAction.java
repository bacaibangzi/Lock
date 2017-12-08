package com.sc.teminal.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.dbutil.DBConn;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.DevUserCard;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.DevUserCardService;
import com.sc.system.service.UserInfoService;
import com.sc.teminal.pojo.DevLog;
import com.sc.teminal.pojo.Devcmdlist;
import com.sc.teminal.pojo.Devnamelistinfo;
import com.sc.teminal.pojo.Terminalinfo;
import com.sc.teminal.pojo.VhuisYanc;
import com.sc.teminal.service.CmdlogService;
import com.sc.teminal.service.DevDoorTeminalService;
import com.sc.teminal.service.DevLogService;
import com.sc.teminal.service.DevcmdlistService;
import com.sc.teminal.service.DevnamelistinfoService;
import com.sc.teminal.service.TerminalinfoService;
import com.sc.teminal.service.VhuisYancService;
import com.sc.util.CommonUtil;
import com.sc.util.DateUtil;
import com.sc.util.ExecQuartz;

@Controller
@RequestMapping("/devcmdlist")
public class DevcmdlistAction extends BaseAction{
	@Autowired
	DevcmdlistService devcmdlistService;

	@Autowired
	TerminalinfoService terminalinfoService;
	
	@Autowired
	DevnamelistinfoService devnamelistinfoService;
	
	@Autowired
	DevDoorTeminalService devDoorTeminalService;
	
	@Autowired
	DevUserCardService devUserCardService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	CmdlogService cmdlogService;
	
	@Autowired
	DevLogService devLogService;
	
	@Autowired
	VhuisYancService vhuisYancService;

	/**
	 *  页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/devcmdlistMain";
	}

	/**
	 * 加载短信日志信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<Devcmdlist> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Devcmdlist> list = devcmdlistService.queryDevcmdlistsForPage(vo, page);
		super.readerPage2Json(list, response);

	}
	
	// 
	@RequestMapping(value = "/qc1.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean qc1(@ModelAttribute ConditionVO vo) throws Exception{

		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);

		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(49);
		devcmdlist.setCmdNumber(49);
		devcmdlist.setCmdContent("1111");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		return true;
	}
	// 
	@RequestMapping(value = "/qc2.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean qc2(@ModelAttribute ConditionVO vo) throws Exception{
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);

		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(49);
		devcmdlist.setCmdNumber(49);
		devcmdlist.setCmdContent("2222");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		return true;
	}
	// 
	@RequestMapping(value = "/qc3.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean qc3(@ModelAttribute ConditionVO vo) throws Exception{
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);

		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(49);
		devcmdlist.setCmdNumber(49);
		devcmdlist.setCmdContent("3333");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		return true;
	}
	// 
	@RequestMapping(value = "/qc4.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean qc4(@ModelAttribute ConditionVO vo) throws Exception{
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);

		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(49);
		devcmdlist.setCmdNumber(49);
		devcmdlist.setCmdContent("4444");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		return true;
	}
	// 
	@RequestMapping(value = "/qc5.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean qc5(@ModelAttribute ConditionVO vo) throws Exception{
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);

		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(49);
		devcmdlist.setCmdNumber(49);
		devcmdlist.setCmdContent("5555");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		return true;
	}

	
	// 远程开门
	@RequestMapping(value = "/yuanCkm.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> yuanCkm(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		
		System.out.println("==================>"+terminalinfo.getControllerId());
		
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("0100000000000000");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[远程开门]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	// 立即关门
	@RequestMapping(value = "/lijgm.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> lijgm(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("0200000000000000");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[立即关门]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	
	// 远程常开
	@RequestMapping(value = "/yuanCck.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String>  yuanCck(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("0300000000000000");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[远程常开]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	// 远程封锁 
	@RequestMapping(value = "/yuanCfs.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> yuanCfs(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("04222255556666AA");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[远程封锁]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	// 远程解封
	@RequestMapping(value = "/yuanCjf.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> yuanCjf(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("0500000000000000");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[远程解封]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	// 全部删除
	@RequestMapping(value = "/quanBsc.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> quanBsc(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(15);
		devcmdlist.setCmdContent("");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[全部删除]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	// 远程关闭
	@RequestMapping(value = "/yuanCgb.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean yuanCgb(@ModelAttribute ConditionVO vo) throws Exception{
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(19);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("0300000000000000");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		return true;
	}
	
	// 延时关闭
	@RequestMapping(value = "/yanSgb.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean yanSgb(@ModelAttribute ConditionVO vo) throws Exception{
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(19);
		devcmdlist.setCmdNumber(19);
		devcmdlist.setCmdContent("0300000000000000");
		//devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date date = sdf.parse(vo.getDateStr1());  
		    
		ExecQuartz.execMap.put(date, devcmdlist);
		return true;
	}
	
	
	// 测试
	@RequestMapping(value = "/cs.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> cs(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		Terminalinfo  terminalinfo = terminalinfoService.getTerminalinfoById(vo);
		Devcmdlist devcmdlist = new Devcmdlist();
		devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
		devcmdlist.setControllerId(terminalinfo.getControllerId());
		devcmdlist.setTerminalId(terminalinfo.getTerminalId());
		devcmdlist.setCmdType(0);
		devcmdlist.setCmdNumber(109);
		devcmdlist.setCmdContent("");
		devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
		map.put("cmd", "已结向终端:"+terminalinfo.getTerminalName()+"发送[测试]指令正在等待执行,指令编号:"+devcmdlist.getDevCmdId());
		map.put("id", devcmdlist.getDevCmdId().toString());
		return map;
	}
	
	
	// 回收
	@RequestMapping(value = "/hs.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean hs(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		String ids[] =  vo.getCode().split(",");
		for(String id : ids){
			vo.setEntityId(id);
			
			VhuisYanc vhuisYanc = vhuisYancService.getVhuisYancById(vo);
			
			//System.out.println("**********************>>>"+vhuisYanc); 
			
			Devnamelistinfo devnamelistinfo = devnamelistinfoService.getDevnamelistinfoById(vo);
			devnamelistinfo.setUpdateType(3);
			devnamelistinfo.setSyncState(0);
			devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);

			// 插入日志
			cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "回收");
			
			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = vhuisYanc.getUiName()+"("+vhuisYanc.getUiNum()+"),回收卡号"+devnamelistinfo.getCardNo();
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);			
		}
		
		return true;
	}
	
	// 延期
	@RequestMapping(value = "/yq.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean yq(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{		
		String date = vo.getDateStr2().substring(2, 4)+vo.getDateStr2().substring(5, 7)+vo.getDateStr2().substring(8, 10)+vo.getDateStr2().substring(11, 13)+vo.getDateStr2().substring(14, 16);
		String ids[] =  vo.getCode().split(",");
		for(String id : ids){
			vo.setEntityId(id);

			VhuisYanc vhuisYanc = vhuisYancService.getVhuisYancById(vo);
			Devnamelistinfo devnamelistinfo = devnamelistinfoService.getDevnamelistinfoById(vo);
			String content = devnamelistinfo.getContent();
			// 0cb1622a18040921060000000000000000
			// d6381e2c1808271150 00000000000000   180 14
			//content = content.substring(0,8)+date+content.substring(18);	
			//content = content.substring(0,18) +"FF"+content.substring(20);
			
			
			
			Terminalinfo terminalinfo =terminalinfoService.getTerminalinfoById(devnamelistinfo.getTerminalId().toString());
			String devModel = terminalinfo.getDevModel();
			String devType = terminalinfo.getDevType().toString();
			System.out.println(">>>>>>>>>>>> devModel:"+devModel);
			
			
			devnamelistinfo.setContent(DevcmdlistAction.yanqi(content, vo.getDateStr2(), devType, devModel));
			devnamelistinfo.setEditTime(new Date());
			if(devnamelistinfo.getSyncState()==1) {
				devnamelistinfo.setUpdateType(2);
				devnamelistinfo.setSyncState(0);
			}
			//devnamelistinfo.setSyncState(0);
			
			devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
			
			// 插入日志
			cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "延期");
			
			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = vhuisYanc.getUiName()+"("+vhuisYanc.getUiNum()+"),卡号"+devnamelistinfo.getCardNo()+",延期到:"+vo.getDateStr2();
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);					
		}
		
		return true;
	}
	
	
	//DevUserCard devUserCard = devUserCardService.getDevUserCardById(vo);
	public boolean checkUserCard(@ModelAttribute ConditionVO vo,HttpServletRequest request)  throws Exception{
		
		return true;
	}
	
	// 发卡
	@RequestMapping(value = "/fak.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean fak(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		//System.out.println("-->>>"+vo.getDateStr2().substring(2, 4)+vo.getDateStr2().substring(5, 7)+vo.getDateStr2().substring(8, 10)+vo.getDateStr2().substring(11, 13)+vo.getDateStr2().substring(14, 16));
		//System.out.println("-->>> code :"+vo.getCode());
		//System.out.println("-->>> code2 :"+vo.getCode2());
		 
		
		String date = vo.getDateStr2().substring(2, 4)+vo.getDateStr2().substring(5, 7)+vo.getDateStr2().substring(8, 10)+vo.getDateStr2().substring(11, 13)+vo.getDateStr2().substring(14, 16);
		String khs[] =  vo.getCode().split(",");
		String zds[] = vo.getCode2().split(",");
		for(String kh : khs)
		for(String zd : zds){
			
			//String khStr = getKhh(kh);
			//System.out.println("============> kh1:"+kh +","+khStr);
			Devnamelistinfo devnamelistinfo = new Devnamelistinfo(); 
			
			// 根据zd 去查找终端id
			vo.setEntityId(zd);
			Integer tsn = devDoorTeminalService.getTeminalIDById(zd);
			Terminalinfo terminalinfo =terminalinfoService.getTerminalinfoById(tsn.toString());
			//Integer tsn = terminalinfo.getTemplateId();
			String devModel = terminalinfo.getDevModel();
			String devType = terminalinfo.getDevType().toString();
			 
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> kh:"+ kh);
			
			devnamelistinfo.setTerminalId(tsn);
			devnamelistinfo.setEditTime(new Date());
			devnamelistinfo.setSyncState(0);
			devnamelistinfo.setCardNo(kh);
			//devnamelistinfo.setContent("B3A04EAC180102120000000000000000");
			//devnamelistinfo.setContent(khStr+date+vo.getNum()+"000000000000");
			devnamelistinfo.setContent(DevcmdlistAction.getKhh(kh, devType, devModel, DateUtil.getCurrentDATEStart(), vo.getDateStr2(), vo.getNum()));
			devnamelistinfo.setUpdateType(1);
			
			// 判断是否存在
			Devnamelistinfo devnamelistinfo1 = devnamelistinfoService.getByTerminalIDCardNo(tsn.toString(), devnamelistinfo.getCardNo());
			if(devnamelistinfo1!=null){
				if(devnamelistinfo1.getSyncState()==0) {
					devnamelistinfo.setUpdateType(1);
				}else {
					devnamelistinfo.setUpdateType(2);
				}
			}
			
			
			
			
			// 先删除再插入
			devnamelistinfoService.deleteByTerminalIDCardNo(tsn.toString(), devnamelistinfo.getCardNo());
			String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
			
			
			//String maxId = devnamelistinfoService.getMaxVersion("");
			devnamelistinfo.setNameListId(Integer.parseInt(maxId));
			// 插入日志
			cmdlogService.insertLog(maxId, "发卡");
			
			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = "卡号:"+kh+"发卡,有效期至:"+vo.getDateStr2();
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);

		}
		
		return true;
	}
	
	// 挂失 就是回收，挂失之前要把这个卡能开的门，还有有效期等给记下来，然后进行回收。 解挂的时候，按之前的记录进行下发到门
	@RequestMapping(value = "/guas.htm", method = RequestMethod.POST)
	@ResponseBody
	public String guas(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		 
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+ vo.getEntityId());
		DevUserCard devUserCard = devUserCardService.getDevUserCardById(vo);
		
		if(devUserCard.getFlag().equals("0")) {
			return "00";
		}
		
		vo.setEntityId(devUserCard.getUserId()+"");
		UserInfo userInfo = userInfoService.getUserInfoById(vo);
		 
		List<Devnamelistinfo> list = devnamelistinfoService.queryByCardNo(devUserCard.getCardNum());
		
		if(list==null||list.size()==0) {
			return "false";
		}
		

		devnamelistinfoService.deleteLogByCardNo(devUserCard.getCardNum());
		// 先记下来
		for(Devnamelistinfo devnamelistinfo : list){
			// 再回收
			devnamelistinfo.setUpdateType(3);
			devnamelistinfo.setEditTime(new Date());
			devnamelistinfo.setSyncState(0);
			devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
			
			// 将数据插入日志
			devnamelistinfoService.insertlog(devnamelistinfo);
			

			try {
				// 插入日志
				cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "挂失");
			} catch (Exception e) {
			}
			
			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = userInfo.getUiName()+"("+devUserCard.getCardNum()+") 挂失卡号:"+devnamelistinfo.getCardNo();
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);		 
			
		}

		// 修改用户卡状态
		devUserCard.setFlag("0");
		devUserCardService.updateFlag("0", devUserCard.getUserId()+"", devUserCard.getCardNum());
		return "true";
	}
	
	// 解挂
	@RequestMapping(value = "/jieg.htm", method = RequestMethod.POST)
	@ResponseBody
	public String jieg(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{

		DevUserCard devUserCard = devUserCardService.getDevUserCardById(vo);
		
		if(devUserCard.getFlag().equals("1")) {
			return "00";
		}

		vo.setEntityId(devUserCard.getUserId()+"");
		UserInfo userInfo = userInfoService.getUserInfoById(vo);
		
		List<Devnamelistinfo> list = devnamelistinfoService.queryLog(devUserCard.getCardNum());
		// 重新下发
		for(Devnamelistinfo devnamelistinfo : list){
			devnamelistinfo.setUpdateType(1);
			devnamelistinfo.setSyncState(0);
			devnamelistinfo.setEditTime(new Date());
			
			/*
			Devnamelistinfo dlinfo = devnamelistinfoService.getByTerminalIDCardNo(""+devnamelistinfo.getTerminalId(), devnamelistinfo.getCardNo());
			// 存在就更新
			if(dlinfo!=null) {
				dlinfo.setUpdateType(1);
				dlinfo.setSyncState(0);
				dlinfo.setEditTime(new Date());
				devnamelistinfoService.updateDevnamelistinfoInfo(dlinfo);

				// 插入日志
				cmdlogService.insertLog(dlinfo.getNameListId()+"", "解挂");
			}
			// 没有就插入
			else {
				devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
				// 插入日志
				String maxId = devnamelistinfoService.getMaxVersion("");
				cmdlogService.insertLog(maxId+"", "解挂");
			}*/
			devnamelistinfoService.deleteByTerminalIDCardNo(""+devnamelistinfo.getTerminalId(), devnamelistinfo.getCardNo());
			String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
			// 插入日志
			//String maxId = devnamelistinfoService.getMaxVersion("");
			cmdlogService.insertLog(maxId+"", "解挂");
			

			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = userInfo.getUiName()+"("+devUserCard.getCardNum()+")  解挂卡号:"+devnamelistinfo.getCardNo();
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);				
						
			
		}
		// 删除日志
		devnamelistinfoService.deleteLogByCardNo(devUserCard.getCardNum());
		

		// 修改用户卡状态
		devUserCard.setFlag("1");
		devUserCardService.updateFlag("1", devUserCard.getUserId()+"", devUserCard.getCardNum());

		

		return "true";
	}
	
	// 换卡
	@RequestMapping(value = "/huank.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean huank(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		DevUserCard devUserCard = devUserCardService.getDevUserCardById(vo);

		vo.setEntityId(devUserCard.getUserId()+"");
		UserInfo userInfo = userInfoService.getUserInfoById(vo);
		
		List<Devnamelistinfo> list = devnamelistinfoService.query(devUserCard.getCardNum());
		String kh = vo.getCode();
		//String khStr = getKhh(kh);
		for(Devnamelistinfo devnamelistinfo : list){
			// 新发删除指令
			devnamelistinfo.setSyncState(0);
			devnamelistinfo.setUpdateType(3);
			devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
			
			String content = devnamelistinfo.getContent(); 
			//content = content.substring(khStr.length());
			
			Terminalinfo terminalinfo =terminalinfoService.getTerminalinfoById(devnamelistinfo.getTerminalId().toString());
			String devModel = terminalinfo.getDevModel();
			String devType = terminalinfo.getDevType().toString();
			
			devnamelistinfo.setContent(DevcmdlistAction.huank(content, devnamelistinfo.getCardNo(), kh, devType, devModel));
			devnamelistinfo.setUpdateType(1);
			devnamelistinfo.setSyncState(0);
			devnamelistinfo.setEditTime(new Date());
			
			// 指令表需要重新下达
			//devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId().toString(), devnamelistinfo.getCardNo()); // 先删除旧卡
			devnamelistinfo.setCardNo(kh);
			String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo); // 插入新卡

			// 插入日志
			//String maxId = devnamelistinfoService.getMaxVersion("");
			cmdlogService.insertLog(maxId, "换卡");
			
			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = userInfo.getUiName()+"("+devUserCard.getCardNum()+")  换卡:"+devnamelistinfo.getCardNo()+"->"+kh;
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);				
		}
		// 用户对应卡表对应表需要修改
		devUserCard.setCardNum(kh);
		devUserCardService.saveOrUpdateDevUserCardInfo(devUserCard);
		
		return true;
	}
	
	// 部门发卡
	@RequestMapping(value = "/bumfak.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean bumfak(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		
		String orgCodes[] = vo.getCode().split(",");
		for(String orgCode : orgCodes){
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("uiOrgCode", orgCode);
			List<UserInfo> userList = userInfoService.query(conditionMap);
	
			String zds[] = vo.getCode2().split(",");
			String date = vo.getDateStr2().substring(2, 4)+vo.getDateStr2().substring(5, 7)+vo.getDateStr2().substring(8, 10)+vo.getDateStr2().substring(11, 13)+vo.getDateStr2().substring(14, 16);
			System.out.println(">>>>>>>>>>>>> date2 :"+vo.getDateStr2()+",  date:"+date);
			
			for(UserInfo userInfo : userList){
				// 获取对应的卡
				List<DevUserCard>  devUserCardList = devUserCardService.queryDevUserCardsByUser(userInfo.getUiId()+"");
				for(DevUserCard devUserCard : devUserCardList){
					
					if(devUserCard.getFlag().equals("1")) // 只操作正常状态
					for(String zd : zds){
						//String khStr = getKhh(devUserCard.getCardNum());
						Devnamelistinfo devnamelistinfo = new Devnamelistinfo();
						
						
						// 根据zd 去查找终端id
						vo.setEntityId(zd);
						Integer tsn = devDoorTeminalService.getTeminalIDById(zd);
						
						Terminalinfo terminalinfo =terminalinfoService.getTerminalinfoById(tsn.toString()); 
						String devModel = terminalinfo.getDevModel();
						String devType = terminalinfo.getDevType().toString();
						
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tsn);
						
						devnamelistinfo.setTerminalId(tsn);
						devnamelistinfo.setEditTime(new Date());
						devnamelistinfo.setSyncState(0);
						devnamelistinfo.setCardNo(devUserCard.getCardNum());
						//devnamelistinfo.setContent("B3A04EAC180102120000000000000000");
						//devnamelistinfo.setContent(khStr+date+vo.getNum()+"000000000000");
						devnamelistinfo.setContent(DevcmdlistAction.getKhh(devUserCard.getCardNum(), devType, devModel, DateUtil.getCurrentDATEStart(), vo.getDateStr2(), vo.getNum()));
						devnamelistinfo.setUpdateType(1);
						
						// 判断是否存在
						Devnamelistinfo devnamelistinfo1 = devnamelistinfoService.getByTerminalIDCardNo(tsn.toString(), devnamelistinfo.getCardNo());
						if(devnamelistinfo1!=null){
							devnamelistinfo.setUpdateType(2);
						}
						
						// 先删除再插入
						devnamelistinfoService.deleteByTerminalIDCardNo(tsn.toString(), devnamelistinfo.getCardNo());
						String maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
						
						
						// 日志
						String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
						String ip = CommonUtil.getRemoteHost(request);
						String context = userInfo.getUiName()+"("+devUserCard.getCardNum()+") 部门发卡卡号:"+devnamelistinfo.getCardNo()+", 有效期:"+vo.getDateStr2() ;
						DevLog devLog = new DevLog();
						devLog.setContext(context);
						devLog.setUser(userName);
						devLog.setIp(ip);
						devLog.setDate(new Date());
						devLogService.saveOrUpdateDevInfo(devLog);	
						

						//String maxId = devnamelistinfoService.getMaxVersion("");
						// 插入日志
						cmdlogService.insertLog(maxId+"", "部门发卡");
					}
				}
			}
		}
		return true;
	}
	
	// 重新发卡
	@RequestMapping(value = "/chongxfak.htm", method = RequestMethod.POST) 
	@ResponseBody
	public boolean chongxfak(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		String ids[] = vo.getCode().split(",");
		for(String id : ids){
			vo.setEntityId(id);
			Devnamelistinfo devnamelistinfo = devnamelistinfoService.getDevnamelistinfoById(vo);
			
			VhuisYanc vhuisYanc = vhuisYancService.getVhuisYancById(vo);
			
			String maxId = "";
			if(devnamelistinfo.getSyncState()==0) {
				// 先删除再插入
				devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId()+"", devnamelistinfo.getCardNo());
				
				devnamelistinfo.setUpdateType(devnamelistinfo.getUpdateType());
				devnamelistinfo.setSyncState(0);
				devnamelistinfo.setEditTime(new Date());
				maxId = devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
			}else {
				// 先删除再插入
				devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId()+"", devnamelistinfo.getCardNo());
				
				devnamelistinfo.setUpdateType(2);
				devnamelistinfo.setSyncState(0);
				devnamelistinfo.setEditTime(new Date());
				maxId =devnamelistinfoService.saveOrUpdateDevnamelistinfoInfo(devnamelistinfo);
			}
			
			
			// 日志
			String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
			String ip = CommonUtil.getRemoteHost(request);
			String context = vhuisYanc.getUiName()+"("+vhuisYanc.getUiNum()+") 重新发卡卡号:"+devnamelistinfo.getCardNo() ;
			DevLog devLog = new DevLog();
			devLog.setContext(context);
			devLog.setUser(userName);
			devLog.setIp(ip);
			devLog.setDate(new Date());
			devLogService.saveOrUpdateDevInfo(devLog);	
			


			//String maxId = devnamelistinfoService.getMaxVersion("");
			// 插入日志
			cmdlogService.insertLog(maxId+"", "重新发卡");
		}
		
		return true;
	}
	
	// 重新授权
	@RequestMapping(value = "/cf.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean cf(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		//String ids[] = vo.getCode().split(",");
		//for(String id : ids){
		System.out.println("---------> vo.getCode():"+vo.getCode());
			// 先获取门
			//int tid = devDoorTeminalService.getTeminalIDById(vo.getCode());

			vo.setEntityId(vo.getCode());
			List<Devnamelistinfo> devnamelistinfoList = devnamelistinfoService.queryDevnamelistinfosByCondition(vo);
			
			System.out.println("->重新授权 . devnamelistinfoList.size():"+devnamelistinfoList.size());
			
			for(Devnamelistinfo devnamelistinfo : devnamelistinfoList){
				// 先删除再插入
				//devnamelistinfoService.deleteByTerminalIDCardNo(devnamelistinfo.getTerminalId()+"", devnamelistinfo.getCardNo());
				
				if(devnamelistinfo.getSyncState()==1) {
					devnamelistinfo.setUpdateType(1);
					devnamelistinfo.setSyncState(0);
					devnamelistinfo.setEditTime(new Date());
					devnamelistinfo.setUpdateType(2);
					devnamelistinfoService.updateDevnamelistinfoInfo(devnamelistinfo);
				
				}
				
				vo.setEntityId(devnamelistinfo.getTerminalId()+"");
				Terminalinfo terminalinfo = terminalinfoService.getTerminalinfoById(devnamelistinfo.getTerminalId()+"");
				// 插入日志
				cmdlogService.insertLog(devnamelistinfo.getNameListId()+"", "重新授权");
				
				// 日志
				String userName = ((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserName();
				String ip = CommonUtil.getRemoteHost(request);
				String context = terminalinfo.getControllerName()+"("+terminalinfo.getTerminalName()+")重新授权卡号:"+devnamelistinfo.getCardNo() ;
				DevLog devLog = new DevLog();
				devLog.setContext(context);
				devLog.setUser(userName);
				devLog.setIp(ip);
				devLog.setDate(new Date());
				devLogService.saveOrUpdateDevInfo(devLog);	
			}
		//}
		
		return true;
	}
	
	/**
	 * 
	 * @param kh  卡号
	 * @param devType 设备类型
	 * @param devModel 设备型号
	 * @param yxksrq 起始日期
	 * @param yxjzrq 结束日期
	 * @param sffs 反锁 1=反锁，0=不反锁
	 * @return
	 * @throws Exception
	 */
	public static String getKhh(String kh,String devType,String devModel,String yxksrq,String yxjzrq,String sffs) throws Exception{
		// 卡类型
		Properties properties = new Properties();  
		InputStream inStream = DBConn.class.getClassLoader()  
		        .getResourceAsStream("jdbc.properties");  
		properties.load(inStream);
		int cardType = Integer.parseInt(properties.getProperty("cardType"));
		
		String date = yxjzrq.substring(2, 4)+yxjzrq.substring(5, 7)+yxjzrq.substring(8, 10)+yxjzrq.substring(11, 13)+yxjzrq.substring(14, 16); // 有效结束日志
		String date1 = yxksrq.substring(2, 4)+yxksrq.substring(5, 7)+yxksrq.substring(8, 10)+yxksrq.substring(11, 13)+yxksrq.substring(14, 16); // 有效开始日期
		String context = "";
		String _kh = getKhh(kh); // 卡号
		if("22".equals(devType)){ // 电子锁
			if("42".equals(devModel)){
				context = _kh + date + ("0".equals(sffs)?"00":"01")+"000000000000";
			}else if("43".equals(devModel)){
				if(cardType==1){
					context = "01"+_kh+"00000000";
				}else if(cardType==2){
					context = "02"+_kh+"00000000";
				}else if(cardType==3){
					
					Long int32 = new Long( kh.trim());
					String hex = Long.toHexString(int32);
					hex ="0000000000000000"+hex;
					hex = hex.substring(hex.length()-16);
					
					context = "03"+hex;
				}
				context = context+"00000000"+date1+date+("0".equals(sffs)?"FE":"FF")+"000000000000";
				
				context = context+hjy(context);
				
			}else if("45".equals(devModel)){
				context = _kh + date + ("0".equals(sffs)?"FE":"FF")+"000000000000";
			}
		}else{
			throw new Exception("不支持该设备类型");
		}
		
		return context;
		
	}
	
	/**
	 * 换卡
	 * @param context
	 * @param oldStr
	 * @param newKh
	 * @param devType
	 * @param devModel
	 * @return
	 * @throws Exception
	 */
	public static String huank(String context,String oldStr,String newKh,String devType,String devModel) throws Exception{
		/*
		String _context = "";
		if(cardType==3){
			Long newint32 = new Long( newKh.trim());
			String newhex = Long.toHexString(newint32);
			newhex ="0000000000000000"+newhex;
			newhex = newhex.substring(newhex.length()-16);
			

			Long oldint32 = new Long( oldStr.trim());
			String oldhex = Long.toHexString(oldint32);
			oldhex ="0000000000000000"+oldhex;
			oldhex = newhex.substring(oldhex.length()-16);
			
			_context = context.replace(oldhex, newhex);
			_context = context.substring(0, 60) + hjy(context.substring(0, 60));
			
		}else {
			String newhex =  getKhh1(newKh);
			String oldhex =  getKhh1(oldStr);

			_context = context.replace(oldhex, newhex);
		}
		*/
		// 卡类型
		Properties properties = new Properties();  
		InputStream inStream = DBConn.class.getClassLoader()  
				        .getResourceAsStream("jdbc.properties");  
		properties.load(inStream);
		int cardType = Integer.parseInt(properties.getProperty("cardType"));
		
		System.out.println("1:"+context +", oldStr:"+oldStr+",newKh:"+newKh);
		
		System.out.println("================> devType:"+devType);
		String _context = "";
		
		context = context.toLowerCase();
		
		if("22".equals(devType)){ // 电子锁
			if("42".equals(devModel)){
				String newhex =  getKhh(newKh).toLowerCase();
				String oldhex =  getKhh(oldStr).toLowerCase();

				System.out.println("================> newhex:"+newhex +", oldhex:"+oldhex);
				_context = context.replaceAll(oldhex, newhex);

				System.out.println("================> _context:"+_context);
			}else if("43".equals(devModel)){
				if(cardType==1){
					String newhex =  (getKhh(newKh)+"00000000").toLowerCase();
					String oldhex =  (getKhh(oldStr)+"00000000").toLowerCase();
					_context = context.replaceAll(oldhex, newhex);
					
				}else if(cardType==2){
					String newhex =  (getKhh(newKh)+"00000000").toLowerCase();
					String oldhex =  (getKhh(oldStr)+"00000000").toLowerCase();
					_context = context.replaceAll(oldhex, newhex);
				}else if(cardType==3){
					Long newint32 = new Long( newKh.trim());
					String newhex = Long.toHexString(newint32);
					newhex ="0000000000000000"+newhex;
					newhex = newhex.substring(newhex.length()-16).toLowerCase();
					

					Long oldint32 = new Long( oldStr.trim());
					String oldhex = Long.toHexString(oldint32);
					oldhex ="0000000000000000"+oldhex;
					oldhex = newhex.substring(oldhex.length()-16).toLowerCase();
					
					_context = context.replaceAll(oldhex, newhex);
					
				} 

				_context = _context.substring(0, 60) + hjy(_context.substring(0, 60));
				
			}else if("45".equals(devModel)){
				String newhex =  getKhh(newKh);
				String oldhex =  getKhh(oldStr);
				_context = context.replaceAll(oldhex, newhex);
			}
		}else{
			throw new Exception("不支持该设备类型");
		}

		System.out.println("2:"+_context);
		return _context;
		
	}
	
	/**
	 * 延期
	 * @param context
	 * @param yxjzrq
	 * @param devType
	 * @param devModel
	 * @return
	 * @throws Exception
	 */
	public static String yanqi(String context,String yxjzrq,String devType,String devModel) throws Exception{
		String _context = "";
		String date = yxjzrq.substring(2, 4)+yxjzrq.substring(5, 7)+yxjzrq.substring(8, 10)+yxjzrq.substring(11, 13)+yxjzrq.substring(14, 16); // 有效结束日志
		if("22".equals(devType)){ // 电子锁
			System.out.println(devModel+"->"+("43".equals(devModel)));
			if("43".equals(devModel)){
				System.out.println("----------------1:"+context);
				_context = context.substring(0,36)+date+ context.substring(46,60);

				System.out.println("----------------2:"+_context);
				_context = _context+hjy(_context);
				System.out.println("----------------3:"+_context);
				
			}else {
				_context = context.substring(0,8)+date+ context.substring(18);
			}
		}else{
			throw new Exception("不支持该设备类型");
		}
		
		return _context;
		
	}
	
	
	public static String getKhh (String str){

		Long int32 = new Long( str.trim());
		//System.out.println("->"+Long.toHexString(int32));
		String hex = Long.toHexString(int32);
		hex ="00000000"+hex;
		
		hex = hex.substring(hex.length()-8);
		
		System.out.println("-> hex:"+hex);
		/**/
		String tkh = "";
		
		//String tkh = hex;
		
		System.out.println("->"+tkh);
		
		try {
			Properties properties = new Properties();  
			InputStream inStream = DBConn.class.getClassLoader()  
			        .getResourceAsStream("jdbc.properties");  
			properties.load(inStream);
			
			int cardidOrder = Integer.parseInt(properties.getProperty("cardidOrder"));  
			if(cardidOrder==1){ // 不反
				tkh = hex;
			}else{
				while(true){    // 反
					if(hex.length()>2){
						tkh = hex.substring(0,2)+tkh;
						hex = hex.substring(2,hex.length());
					}else if(hex.length()==2){
						tkh = hex.substring(0,2)+tkh;
						break;
					}else{
						tkh = "0"+hex.substring(0,1)+tkh;
						break;
					}
				}
				//tkh = hex;
			}
			
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return tkh;
	}
	
	
	public static String hjy(String str){
		int count = 0;
		for(int i=0;i<str.length();i=i+2){
			String st = str.substring(i, i+2);
			count +=Integer.parseInt(st,16);
			System.out.println(st+"->"+Integer.parseInt(st,16));
		}
		
		System.out.println("count:"+count);
		
		String hex = Integer.toHexString(count);
		System.out.println("hex:"+hex);

		hex = "0000"+hex;
		hex = hex.substring(hex.length()-4);
		
		hex = hex.substring(2)+hex.substring(0, 2);
		
		return hex;
	}
	
	public static void main(String args[]){
		String str = "2650446513";
		String hex = getKhh(str);
		System.out.println("->"+hex);
		System.out.println("->"+Long.parseLong(hex, 16));
		
	}
}
