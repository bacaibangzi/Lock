package com.sc.system.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.interfaces.IMerchantUser;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.RoleInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserRole;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.RoleInfoService;
import com.sc.system.service.UserInfoService;
import com.sc.system.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class SystemUserAction extends BaseAction {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	OrgInfoService orgInfoService;
	@Autowired
	IMerchantUser IMerchantUser;
	@Autowired
	RoleInfoService roleInfoService;
	@Autowired
	UserRoleService userRoleService;

	/**
	 * 系统用户主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(@ModelAttribute ConditionVO vo, HttpServletRequest request) {
		request.setAttribute("shMap", SessionConstants.user_sh);
		return "system/userCenter";
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
		//
		List<Map<String, Object>> mdList = getMdTreeNode(list, path, vo.getOrgCode());
		request.setAttribute("mdList", new Gson().toJson(mdList));

		return "system/userLeftTree";
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
		return "system/userCenter";
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
		request.setAttribute("shMap", SessionConstants.user_sh);
		super.setPageInfo(page);
		vo.setCode("1");
		Page<UserInfo> list = userInfoService.queryUserInfosForPage(vo, page);
		
		/*
		for(UserInfo userInfo : list.getResult()){
			vo.setId(userInfo.getUiId());
			List<UserRole> userRoleList = userRoleService.queryUserRoleByCondition(vo);
			Long roleId = userRoleList.get(0).getRiId();
			vo.setEntityId(roleId+"");
			RoleInfo roleInfo = roleInfoService.getRoleInfoById(vo);
			userInfo.setUiNum(roleInfo.getRiName());
		}*/
		
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
		if (vo.getEntityId() != null) {
			BeanUtils.copyProperties(userInfoService.getUserInfoById(vo), UserInfo);
		}
		return "system/userEidt";
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
		return "system/userDetail";
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
		// 新增情况下设置上一级的组织编码
		if (userInfo.getUiOrgCode() == null || userInfo.getUiOrgCode().intern() == "") {
			//userInfo.setUiOrgCode(vo.getOrgCode());
			userInfo.setUiOrgCode("0000");
		}
		try {
			userInfo.setUiImg("1");
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				vo.setErrMsg("登录名不能重复！");
				return "system/userEidt";
			}
		}
		return "system/userCenter";
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

			/*System.out.println("------------------------------------------>");
			System.out.println("------------------------------------------>");
			System.out.println("存放目录:" + PATH_FOLDER);
			System.out.println("临时目录:" + TEMP_FOLDER);
			System.out.println("上传的文件名:" + filename);
			System.out.println("保存后的文件名:" + saveName);
			System.out.println("浏览器访问路径:" + picUrl);
			System.out.println("------------------------------------------>");
			System.out.println("------------------------------------------>");*/

			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName));

			// 通过response把imageUrl传到前台
			PrintWriter writer = response.getWriter();

			writer.print("{");
			writer.print("msg:\"文件大小:" + item.getSize() + ",文件名:" + filename + "\"");
			writer.print(",picUrl:\"" + picUrl + "\"");
			writer.print("}");

			writer.close();

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

}
