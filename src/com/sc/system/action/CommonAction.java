package com.sc.system.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.framework.base.action.BaseAction;
import com.sc.util.ImageUtil;


@Controller
@RequestMapping("/common")
public class CommonAction extends BaseAction {

	
	/*
	 * 上传用户图片
	 */
	@RequestMapping(value = "/uploadFileByImg.htm", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public void uploadFileByImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// 构建图片保存的目录
		String pathDir = "upload/apps";
		// 得到图片保存目录的真实路径
		String PATH_FOLDER = request.getSession().getServletContext().getRealPath(pathDir);
		// 构建图片临时保存的目录
		String tempPathDir = "tempUpload/apps";
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
			String picUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/apps/" + saveName;
			
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
			
			
			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName));
			item.getOutputStream().close();
			
			//ImageUtil.scale2(PATH_FOLDER+"\\"+saveName,PATH_FOLDER+"\\_"+saveName,320,320,false);
			//String picUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/apps/_" + saveName;

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
