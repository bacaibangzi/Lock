package com.sc.system.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.interfaces.IMerchantUser;
import com.sc.system.pojo.Data;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.DataService;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.UserInfoService;
import com.sc.system.service.UserInforMessageService;  

@Controller
@RequestMapping("/yonghu")
public class YongHuAction extends BaseAction {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	OrgInfoService orgInfoService;
	@Autowired
	IMerchantUser IMerchantUser;	
	@Autowired
	DataService dataService;
	@Autowired
	UserInforMessageService userInforMessageService;
	
	@InitBinder   
    public void initBinder(WebDataBinder binder) {   
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
        dateFormat.setLenient(true);   
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }

	/**
	 * 系统用户主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(@ModelAttribute ConditionVO vo, HttpServletRequest request) {
		request.setAttribute("shMap", SessionConstants.user_sh);
		request.setAttribute("typeMap", SessionConstants.user_type);
		
		return "system/yonghuFrame";
	}

	/**
	 * 系统用户树状Tree结构
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		// 加载系统用户tree 图片路径
		String path = "../application/images/icon/org_start.png";
		List<OrgInfo> list = orgInfoService.queryOrgInfosByCondition(vo);
		List<Map<String, Object>> nodeList = getOrgTreeNode(list, path, vo.getOrgCode());
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "system/yonghuLeftTree";
	}

	/**
	 * 系统用户列表界面
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo, HttpServletRequest request) {
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh);
		return "system/yonghuCenter";
	}

	/**
	 * 系统用户列表加载
	 * 
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo, @ModelAttribute Page<UserInfo> page, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		List<Data> dataList = dataService.queryDatasByKeys("USER");
		SessionConstants.user_type.clear();
		for(Data data : dataList){
			SessionConstants.user_type.put(data.getSn(), data.getName());
		}
		
		request.setAttribute("shMap", SessionConstants.user_sh);
		request.setAttribute("typeMap", SessionConstants.user_type);
		
		
		super.setPageInfo(page);
		vo.setCode("0");
		Page<UserInfo> list = userInfoService.queryUserInfosForPage1(vo, page);
		
		for(UserInfo user : list.getResult()){
			try {
				user.setBm(orgInfoService.findMengdByOrgCode(user.getUiOrgCode()).getOiName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		super.readerPage2Json(list, response);

	}

	/**
	 * 系统用户编辑页面
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo, @ModelAttribute("form") UserInfo UserInfo, Map<String, Object> map, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		map.put("sexMap", SessionConstants.user_sex); 
		
		
		List<Data> dataList = dataService.queryDatasByKeys("USER");
		Map<String,String> typeMap = new HashMap<String,String>();
		for(Data data : dataList){
			typeMap.put(data.getSn()+"", data.getName());
		}
		map.put("typeMap", typeMap);
		if (vo.getEntityId() != null) {
			BeanUtils.copyProperties(userInfoService.getUserInfoById1(vo), UserInfo);
			
			System.out.println("->> utype:"+UserInfo.getUiType()); 
		}
		return "system/yonghuEidt";
	}

	//管理员
	@RequestMapping(value = "/guanliyuan.htm", method = RequestMethod.GET)
	public String guanliyuan(@ModelAttribute ConditionVO vo, @ModelAttribute("form") UserInfo UserInfo, Map<String, Object> map, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		map.put("sexMap", SessionConstants.user_sex); 
		map.put("typeMap", SessionConstants.user_type);
		if (vo.getEntityId() != null) {
			BeanUtils.copyProperties(userInfoService.getUserInfoById1(vo), UserInfo);
		}
		return "system/yonghuGuanliyuan";
	}
	
	/**
	 * 系统用户查看界面
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo, @ModelAttribute("form") UserInfo UserInfo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(userInfoService.getUserInfoById(vo), UserInfo);
		return "system/yonghuDetail";
	}

	/**
	 * 系统用户保存
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo, @ModelAttribute("form") UserInfo userInfo, Map<String, Object> map, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		map.put("sexMap", SessionConstants.user_sex);
		request.setAttribute("shMap", SessionConstants.user_sh);
		request.setAttribute("typeMap", SessionConstants.user_type);
		// 新增情况下设置上一级的组织编码
		if (userInfo.getUiOrgCode() == null || userInfo.getUiOrgCode().intern() == "") {
			userInfo.setUiOrgCode(vo.getOrgCode());
		}
		try {
			userInfo.setUiImg("0");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userInfo.getUiVipLevelTime());
			userInfoService.saveOrUpdateUserInfoInfo1(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DuplicateKeyException) {
				vo.setErrMsg("登录名不能重复！");
				return "system/yonghuEidt";
			}
		}
		return "system/yonghuCenter";
	}

	
	@RequestMapping(value = "/saveGly.htm", method = RequestMethod.POST)
	public String saveGly(@ModelAttribute ConditionVO vo, @ModelAttribute("form") UserInfo userInfo, Map<String, Object> map, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		map.put("sexMap", SessionConstants.user_sex);
		request.setAttribute("shMap", SessionConstants.user_sh);
		request.setAttribute("typeMap", SessionConstants.user_type);
		// 新增情况下设置上一级的组织编码
		if (userInfo.getUiOrgCode() == null || userInfo.getUiOrgCode().intern() == "") {
			userInfo.setUiOrgCode(vo.getOrgCode());
		}
		try {
			// 判断是否重复
			Map<String, Object> conditionMap = new HashMap<String,Object>();
			conditionMap.put("uiLoginName", userInfo.getUiLoginName());
			conditionMap.put("flag", userInfo.getUiId());
			//conditionMap.put("uiId", userInfo.getUiId());
			List<UserInfo> list = userInfoService.query(conditionMap);
			if(list.size()>0){
				vo.setErrMsg("登录名不能重复！");
				return "system/yonghuGuanliyuan";
			}
			
			userInfoService.saveGly(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DuplicateKeyException) {
				vo.setErrMsg("登录名不能重复！");
				return "system/yonghuEidt";
			}
		}
		return "system/yonghuCenter";
	}
	
	
	
	/**
	 * 系统用户删除
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@ModelAttribute ConditionVO vo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh);
		request.setAttribute("typeMap", SessionConstants.user_type);
		try {
			return userInfoService.deleteUserInfoById(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 用户审核
	 * 
	 * @param ConditionVO
	 * @return
	 */
	@RequestMapping(value = "/sh.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean sh(@ModelAttribute ConditionVO vo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh);
		request.setAttribute("typeMap", SessionConstants.user_type);
		userInfoService.shUserInfoById(vo);
		// return "system/userCenter";
		return true;
	}
	
	/*
	 * 上传用户图片
	 */
	@RequestMapping(value = "/uploadFileByImg.htm", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public void uploadFileByImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// 构建图片保存的目录
		String pathDir = "upload/images";
		// 得到图片保存目录的真实路径
		String PATH_FOLDER = request.getSession().getServletContext().getRealPath(pathDir);
		// 构建图片临时保存的目录
		String tempPathDir = "tempUpload/images";
		// 文件临时存放位置
		String TEMP_FOLDER = request.getSession().getServletContext().getRealPath(tempPathDir);
		// 根据真实路径创建目录
		File pathSaveFile = new File(PATH_FOLDER);
		if (!pathSaveFile.exists()) {
			pathSaveFile.mkdirs();
		}
		// 根据临时路径创建目录
		File tempPathSaveFile = new File(TEMP_FOLDER);
		if (!tempPathSaveFile.exists()) {
			tempPathSaveFile.mkdirs();
		}
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 提交上来的信息都在这个list里面,可以上传多个文件
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(new ServletRequestContext(request));
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			// 获取文件名
			String filename = getUploadFileName(item);
			// 保存后的文件名
			String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
			// 保存后图片的浏览器访问路径
			String picUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/images/" + saveName;

			/*
			// 把路径保存到USERINFO下,并解决转换中文乱码
			String loginUserName = new String(request.getParameter("userName").getBytes("iso-8859-1"), "utf-8");
			if (loginUserName != null) {
				//UserInfo user = IMerchantUser.getSystemUserByLoginName(loginUserName);
				UserInfo user = IMerchantUser.getSystemUserByUIName(loginUserName);
				user.setUiImg("upload/images/" + saveName);
				userInfoService.updateUserInfo(user);
				AccountInfo info = (AccountInfo)request.getSession().getAttribute("accountInfo");
				if(info!=null){
					info.setUserImg(user.getUiImg());
					request.getSession().setAttribute("accountInfo", info);
				}
			}*/

			/**/
			System.out.println("------------------------------------------>");
			System.out.println("------------------------------------------>");
			System.out.println("存放目录:" + PATH_FOLDER);
			System.out.println("临时目录:" + TEMP_FOLDER);
			System.out.println("上传的文件名:" + filename);
			System.out.println("保存后的文件名:" + saveName);
			System.out.println("浏览器访问路径:" + picUrl);
			System.out.println("------------------------------------------>");
			System.out.println("------------------------------------------>");

			/*
			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName));
			
			
			

			// 通过response把imageUrl传到前台
			PrintWriter writer = response.getWriter();

			writer.print("{");
			writer.print("msg:\"文件大小:" + item.getSize() + ",文件名:" + filename + "\"");
			writer.print(",picUrl:\"" + picUrl + "\"");
			writer.print("}");

			writer.close();
			*/
			
			String orgCode = request.getParameter("orgCode");

			try {  
                Workbook wb = new HSSFWorkbook(item.getInputStream());  
                Sheet sheet = wb.getSheetAt(0);  
                for( int i = 1; i <= sheet.getLastRowNum(); i++ ){  
                    Row row = sheet.getRow(i);  
                    
                    //System.out.println("------> "+row.getCell(0).getStringCellValue());

                    String  xh="",  xm="", xb="", sj="", yx="", dz="", nj="", rq ="";
                    
                    if(row.getCell(0)!=null){
                    	row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        xh =  row.getCell(0).getStringCellValue();
                    }
                    if(row.getCell(1)!=null){
                    	row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    	xm =  row.getCell(1).getStringCellValue();
                    }
                    if(row.getCell(2)!=null){
                    	row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    	xb =  row.getCell(2).getStringCellValue();
                    }
                    if(row.getCell(3)!=null){
                    	row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    	sj =  row.getCell(3).getStringCellValue();
                    }
                    if(row.getCell(4)!=null){
                    	row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        yx =  row.getCell(4).getStringCellValue();
                    }
                    if(row.getCell(5)!=null){
                    	row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                        dz =  row.getCell(5).getStringCellValue();
                    }
                    if(row.getCell(6)!=null){
                    	row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                    	nj =  row.getCell(6).getStringCellValue();
                    }
                    if(row.getCell(7)!=null){
                    	row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                    	rq =  row.getCell(7).getStringCellValue();
                    }
                	
                    
                    if(xh!=null&&!"".equals(xh)){
                    	UserInfo userInfo = userInfoService.getByUINUm(xh);
                    	if(userInfo==null){
                    		userInfo = new UserInfo();
                    	}
                    	userInfo.setUiNum(xh);
                    	userInfo.setUiName(xm);
                    	userInfo.setUiSex("男".equals(xb)?1L:0L);
                    	userInfo.setUiMobile(sj);
                    	userInfo.setUiEmail(yx);
                    	userInfo.setUiAddress(dz);
                    	userInfo.setUiVipLevelName(nj);
                    	//userInfo.setUiFindPasswordTime(rq);
                    	userInfo.setUiOrgCode(orgCode);
                    	
                    	try {
							userInfoService.saveOrUpdateUserInfoInfo(userInfo);
						} catch (Exception e) {
							e.printStackTrace();
						}
                    }
                    
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            } 

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private FileItem getUploadFileItem(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if (!fileItem.isFormField()) {
				return fileItem;
			}
		}
		return null;
	}

	private String getUploadFileName(FileItem item) {
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);

		return filename;
	}
	
	public List<Map<String, Object>> getOrgTreeNode(List<OrgInfo> orgList,
			String path, String org) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (OrgInfo area : list) {
			map = new HashMap<String, Object>();
			map.put("id", area.getOiCode());
			map.put("checkAble", "false");
			map.put("text", area.getOiName());
			map.put("value", area.getOiCode());
			map.put("showcheck", "");
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			// map.put("pid", area.getOiCode());// 父节点，取前4位
			map.put("ChildNodes", new ArrayList());
			map.put("code", area.getOiCode());
			map.put("type", area.getOiType());
			//map.put("imgPath", path);
			if("0000".equals(area.getOiCode())){
				map.put("imgPath", "../application/images/org/top.png");
			}else if("0".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/gs.png");
			}else if("1".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/ag.png");
			}else if("2".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/dis.png");
			}
			
			if (org.equals(area.getOiCode())) {
				map.put("pid", "-1");
			} else {
				map.put("pid", area.getOiCode().substring(0,  area.getOiCode().length()-4));
			}

			nodeList.add(map);
		}
		return nodeList;
	}

	@RequestMapping(value = "/uploadFileByImg2.htm", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	    public void uploadExcel(@RequestParam("file") MultipartFile file){  
	                //这里只处理文件名包括“用户”的文件，模板使用下载模板  
	            try {  
	                Workbook wb = new HSSFWorkbook(file.getInputStream());  
	                Sheet sheet = wb.getSheetAt(0);  
	                for( int i = 1; i <= sheet.getLastRowNum(); i++ ){  
	                    Row row = sheet.getRow(i);  
	                    System.out.println("------> "+row.getCell(0).getStringCellValue());
	                }  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	    } 
	
	
	
	@RequestMapping(value = "/download.htm", method = RequestMethod.GET)
	public void download(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
        response.setContentType("text/html;charset=UTF-8");   
        BufferedInputStream in = null;  
        BufferedOutputStream out = null;  
        request.setCharacterEncoding("UTF-8");  
        String rootpath = request.getSession().getServletContext().getRealPath(  
                "/");  
        String fileName = "template.xls";  
        try {  
            File f = new File(rootpath + "template/" + fileName);  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
              response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
            response.setHeader("Content-Length",String.valueOf(f.length()));  
            in = new BufferedInputStream(new FileInputStream(f));  
            out = new BufferedOutputStream(response.getOutputStream());  
            byte[] data = new byte[1024];  
            int len = 0;  
            while (-1 != (len=in.read(data, 0, data.length))) {  
                out.write(data, 0, len);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (in != null) {  
                in.close();  
            }  
            if (out != null) {  
                out.close();  
            }  
        }   
    }
	
	
	// 同步数据
	@RequestMapping(value = "/syn.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean syn(@ModelAttribute ConditionVO vo,HttpServletRequest request){
		try {
			userInforMessageService.syn(request);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
