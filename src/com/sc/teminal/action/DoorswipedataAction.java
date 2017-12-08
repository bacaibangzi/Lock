package com.sc.teminal.action;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.pojo.Doorswipedata;
import com.sc.teminal.service.DoorswipedataService;
import com.sc.util.ExportExcel;

@Controller
@RequestMapping("/doorswipedata")
public class DoorswipedataAction extends BaseAction{

	@Autowired
	DoorswipedataService doorswipedataService;

	/**
	 * 短信日志页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(HttpServletRequest request,  
            HttpServletResponse response) {
		Map<String,String> typeMap = new HashMap<String,String>();
		typeMap.put("1", "正常刷卡");
		typeMap.put("2", "非法卡");
		typeMap.put("3", "钥匙开门");
		typeMap.put("4", "远程开门");
		typeMap.put("5", "远程常开");
		typeMap.put("6", "远程闭门");
		typeMap.put("7", "反锁");
		typeMap.put("8", "非反锁");
		typeMap.put("9", "闭门");
		typeMap.put("10", "假锁");
		typeMap.put("11", "卡格式错误");
		typeMap.put("12", "授权卡");
		typeMap.put("13", "名单卡");
		typeMap.put("252", "配置卡");
		request.setAttribute("typeMap", typeMap);
		return "teminal/doorswipedataMain";
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
			@ModelAttribute Page<Doorswipedata> page,HttpServletRequest request, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		String dateStr11 = request.getParameter("dateStr11");
		String dateStr22 = request.getParameter("dateStr22");
		String sbmc = request.getParameter("sbmc");
		String sjlx = request.getParameter("sjlx");
		String kh = request.getParameter("kh");
		String xh = request.getParameter("xh");
		String yhxm = request.getParameter("yhxm");
		String dateStr1 = request.getParameter("dateStr1");
		String dateStr2 = request.getParameter("dateStr2");
		
		
		Page<Doorswipedata> list = doorswipedataService.queryDoorswipedatasForPage(vo, page,dateStr11,dateStr22,sbmc,sjlx,kh,xh,yhxm,dateStr1,dateStr2);
		super.readerPage2Json(list, response);

	}
	
	
	@RequestMapping(value = "/download.htm", method = RequestMethod.GET)
	public void download(@ModelAttribute ConditionVO vo,HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
        
		List<Doorswipedata> doorswipedataList = doorswipedataService.queryDoorswipedatasByCondition(vo);
  
		String fileName = "事情日志.xls";  
        fileName = new String(fileName.getBytes("GBK"), "iso8859-1");  
        response.reset();  
        response.setHeader("Content-Disposition", "attachment;filename="  
                + fileName);// 指定下载的文件名  
        response.setContentType("application/vnd.ms-excel");  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        OutputStream output = response.getOutputStream();  
        BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);  
  
        // 定义单元格报头  
        String worksheetTitle = "事情日志";  
  
        HSSFWorkbook wb = new HSSFWorkbook();  
  
        // 创建单元格样式  
        HSSFCellStyle cellStyleTitle = wb.createCellStyle();  
        // 指定单元格居中对齐  
        cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 指定单元格垂直居中对齐  
        cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        // 指定当单元格内容显示不下时自动换行  
        cellStyleTitle.setWrapText(true);  
        // ------------------------------------------------------------------  
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        // 指定单元格居中对齐  
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 指定单元格垂直居中对齐  
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        // 指定当单元格内容显示不下时自动换行  
        cellStyle.setWrapText(true);  
        // ------------------------------------------------------------------  
        // 设置单元格字体  
        HSSFFont font = wb.createFont();  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 200);  
        cellStyleTitle.setFont(font);  
  
        // 工作表名  
        String id = "编号";  
        String name = "用户名称";  
        String age = "工号/学号";  
        String address = "卡号";  
        String tel = "刷卡时间";  
        String sex = "记录类型";  
        String sex1 = "交易流水号";  
  
        HSSFSheet sheet = wb.createSheet();  
        ExportExcel exportExcel = new ExportExcel(wb, sheet);  
        // 创建报表头部  
        exportExcel.createNormalHead(worksheetTitle, 6);  
        // 定义第一行  
        HSSFRow row1 = sheet.createRow(1);  
        HSSFCell cell1 = row1.createCell(0);  
  
        //第一行第一列  
          
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(id));  
        //第一行第er列  
        cell1 = row1.createCell(1);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(name));  
  
        //第一行第san列  
        cell1 = row1.createCell(2);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(age));  
  
        //第一行第si列  
        cell1 = row1.createCell(3);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(address));  
  
        //第一行第wu列  
        cell1 = row1.createCell(4);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(tel));  
  
        //第一行第liu列  
        cell1 = row1.createCell(5);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(sex));  
  
        //第一行第qi列  
        cell1 = row1.createCell(6);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(sex));  
  
        //第一行第qi列  
        cell1 = row1.createCell(7);  
        cell1.setCellStyle(cellStyleTitle);  
        cell1.setCellValue(new HSSFRichTextString(sex1));  
  
          
        //定义第二行  
        HSSFRow row = sheet.createRow(2);  
        HSSFCell cell = row.createCell(1);  
        Doorswipedata doorswipedata = new Doorswipedata();  
        for (int i = 0; i < doorswipedataList.size(); i++) {  
        	doorswipedata = doorswipedataList.get(i);  
            row = sheet.createRow(i + 2);  
  
            cell = row.createCell(0);  
            cell.setCellStyle(cellStyle);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getId() + ""));  
              
            cell = row.createCell(1);  
            cell.setCellStyle(cellStyle);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getUiName()));  
              
            cell = row.createCell(2);  
            cell.setCellStyle(cellStyle);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getUiNum() + ""));  
              
            cell = row.createCell(3);  
            cell.setCellStyle(cellStyle);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getCardNo() + ""));  
              
            cell = row.createCell(4);  
            cell.setCellStyle(cellStyle);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getSwipeTimeString()));  
              
            cell = row.createCell(5);  
            cell.setCellStyle(cellStyle);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getSwipeTypeStr()));  
              
            cell = row.createCell(6);  
            cell.setCellValue(new HSSFRichTextString(doorswipedata.getTradeSerialNo()+""));  
            cell.setCellStyle(cellStyle);  
            
	        cell = row.createCell(7);  
	        cell.setCellValue(new HSSFRichTextString(doorswipedata.getGatherTimeString()));  
	        cell.setCellStyle(cellStyle); 
              
        }  
        try {  
            bufferedOutPut.flush();  
            wb.write(bufferedOutPut);  
            bufferedOutPut.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("Output   is   closed ");  
        } finally {  
        	doorswipedataList.clear();  
        }  
		
    }
}
