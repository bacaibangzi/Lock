<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
	xmlns:w="urn:schemas-microsoft-com:office:word"
	xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="text/html; charset=gb2312">
<title>云平台使用基本教程四(微信点餐)</title>
<!--[if gte mso 9]><xml><w:WordDocument><w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel><w:DisplayHorizontalDrawingGridEvery>0</w:DisplayHorizontalDrawingGridEvery><w:DisplayVerticalDrawingGridEvery>2</w:DisplayVerticalDrawingGridEvery><w:DocumentKind>DocumentNotSpecified</w:DocumentKind><w:DrawingGridVerticalSpacing>7.8 磅</w:DrawingGridVerticalSpacing><w:View>Web</w:View><w:Compatibility><w:DontGrowAutofit/><w:BalanceSingleByteDoubleByteWidth/><w:DoNotExpandShiftReturn/><w:UseFELayout/></w:Compatibility><w:Zoom>0</w:Zoom></w:WordDocument></xml><![endif]-->
<!--[if gte mso 9]><xml><w:LatentStyles DefLockedState="false"  DefUnhideWhenUsed="true"  DefSemiHidden="true"  DefQFormat="false"  DefPriority="99"  LatentStyleCount="260" >
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Normal" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="heading 9" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index 9" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toc 9" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Normal Indent" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="footnote text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="annotation text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="header" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="footer" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="index heading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="caption" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="table of figures" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="envelope address" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="envelope return" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="footnote reference" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="annotation reference" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="line number" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="page number" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="endnote reference" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="endnote text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="table of authorities" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="macro" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="toa heading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Bullet" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Number" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Bullet 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Bullet 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Bullet 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Bullet 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Number 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Number 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Number 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Number 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Title" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Closing" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Signature" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  UnhideWhenUsed="false"  Name="Default Paragraph Font" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text Indent" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Continue" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Continue 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Continue 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Continue 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="List Continue 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Message Header" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Subtitle" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Salutation" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Date" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text First Indent" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text First Indent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Note Heading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text Indent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Body Text Indent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Block Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Hyperlink" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="FollowedHyperlink" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Strong" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Emphasis" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Document Map" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Plain Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="E-mail Signature" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Normal (Web)" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Acronym" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Address" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Cite" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Code" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Definition" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Keyboard" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Preformatted" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Sample" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Typewriter" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="HTML Variable" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  UnhideWhenUsed="false"  Name="Normal Table" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="annotation subject" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="No List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Simple 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Simple 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Simple 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Classic 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Classic 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Classic 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Classic 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Colorful 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Colorful 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Colorful 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Columns 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Columns 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Columns 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Columns 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Columns 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table List 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table 3D effects 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table 3D effects 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table 3D effects 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Contemporary" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Elegant" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Professional" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Subtle 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Subtle 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Web 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Web 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Web 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Balloon Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Grid" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Table Theme" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3 Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid Accent 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3 Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid Accent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3 Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid Accent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3 Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid Accent 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3 Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid Accent 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="60"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Shading Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="61"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light List Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="62"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Light Grid Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="63"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 1 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="64"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Shading 2 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="65"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 1 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="66"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium List 2 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="67"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 1 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="68"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 2 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="69"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Medium Grid 3 Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="70"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Dark List Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="71"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Shading Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="72"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful List Accent 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="73"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Colorful Grid Accent 6" ></w:LsdException>
</w:LatentStyles></xml><![endif]-->
<style>
@font-face {
	font-family: "Times New Roman";
}

@font-face {
	font-family: "宋体";
}

@font-face {
	font-family: "Wingdings";
}

@font-face {
	font-family: "Microsoft YaHei UI";
}

@
list l0:level1 {
	mso-level-number-format: chinese-counting;
	mso-level-suffix: none;
	mso-level-text: "%1、";
	mso-level-tab-stop: none;
	mso-level-number-position: left;
	margin-left: 0.0000pt;
	text-indent: 0.0000pt;
	font-family: 'Times New Roman';
}

@
list l1:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 39.0000pt;
	mso-level-number-position: left;
	margin-left: 39.0000pt;
	text-indent: -18.0000pt;
	font-family: 'Times New Roman';
}

@
list l2:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 81.0000pt;
	mso-level-number-position: left;
	margin-left: 81.0000pt;
	text-indent: -18.0000pt;
	font-family: Wingdings;
}

@
list l3:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 18.0000pt;
	mso-level-number-position: left;
	margin-left: 18.0000pt;
	text-indent: -18.0000pt;
	font-family: 'Times New Roman';
}

@
list l4:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 18.0000pt;
	mso-level-number-position: left;
	margin-left: 18.0000pt;
	text-indent: -18.0000pt;
	font-family: Wingdings;
}

@
list l5:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 60.0000pt;
	mso-level-number-position: left;
	margin-left: 60.0000pt;
	text-indent: -18.0000pt;
	font-family: Wingdings;
}

@
list l6:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 60.0000pt;
	mso-level-number-position: left;
	margin-left: 60.0000pt;
	text-indent: -18.0000pt;
	font-family: 'Times New Roman';
}

@
list l7:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 39.0000pt;
	mso-level-number-position: left;
	margin-left: 39.0000pt;
	text-indent: -18.0000pt;
	font-family: Wingdings;
}

@
list l8:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 102.0000pt;
	mso-level-number-position: left;
	margin-left: 102.0000pt;
	text-indent: -18.0000pt;
	font-family: Wingdings;
}

@
list l9:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 81.0000pt;
	mso-level-number-position: left;
	margin-left: 81.0000pt;
	text-indent: -18.0000pt;
	font-family: 'Times New Roman';
}

@
list l10:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 102.0000pt;
	mso-level-number-position: left;
	margin-left: 102.0000pt;
	text-indent: -18.0000pt;
	font-family: 'Times New Roman';
}

p.MsoNormal {
	mso-style-name: 正文;
	mso-style-parent: "";
	margin: 0pt;
	margin-bottom: .0001pt;
	mso-pagination: none;
	text-align: justify;
	text-justify: inter-ideograph;
	font-family: 'Times New Roman';
	font-size: 10.5000pt;
	mso-font-kerning: 1.0000pt;
}

span.10 {
	font-family: 'Times New Roman';
}

p.MsoHeader {
	mso-style-name: 页眉;
	margin: 0pt;
	margin-bottom: .0001pt;
	border-bottom: 0.7500pt solid windowtext;
	mso-border-bottom-alt: 0.7500pt solid windowtext;
	padding: 0pt 0pt 1pt 0pt;
	layout-grid-mode: char;
	mso-pagination: none;
	text-align: center;
	font-family: 'Times New Roman';
	font-size: 9.0000pt;
	mso-font-kerning: 1.0000pt;
}

p.MsoFooter {
	mso-style-name: 页脚;
	margin: 0pt;
	margin-bottom: .0001pt;
	layout-grid-mode: char;
	mso-pagination: none;
	text-align: left;
	font-family: 'Times New Roman';
	font-size: 9.0000pt;
	mso-font-kerning: 1.0000pt;
}

span.msoIns {
	mso-style-type: export-only;
	mso-style-name: "";
	text-decoration: underline;
	text-underline: single;
	color: blue;
}

span.msoDel {
	mso-style-type: export-only;
	mso-style-name: "";
	text-decoration: line-through;
	color: red;
}

table.MsoNormalTable {
	mso-style-name: 普通表格;
	mso-style-parent: "";
	mso-style-noshow: yes;
	mso-tstyle-rowband-size: 0;
	mso-tstyle-colband-size: 0;
	mso-padding-alt: 0.0000pt 5.4000pt 0.0000pt 5.4000pt;
	mso-para-margin: 0pt;
	mso-para-margin-bottom: .0001pt;
	mso-pagination: widow-orphan;
	font-family: 'Times New Roman';
	font-size: 10.0000pt;
	mso-ansi-language: #0400;
	mso-fareast-language: #0400;
	mso-bidi-language: #0400;
}

@page {
	mso-page-border-surround-header: no;
	mso-page-border-surround-footer: no;
}

@page Section0 {
	margin-top: 72.0000pt;
	margin-bottom: 72.0000pt;
	margin-left: 90.0000pt;
	margin-right: 90.0000pt;
	size: 595.3000pt 841.9000pt;
	layout-grid: 15.6000pt;
}

div.Section0 {
	page: Section0;
}
</style>
</head>
<body style="tab-interval: 21pt; text-justify-trim: punctuation;">
	<!--StartFragment-->
	<div class="Section0" style="layout-grid: 15.6000pt;">
		<p class=MsoNormal
			style="margin-left: 84.0000pt; text-indent: 21.0000pt; mso-pagination: widow-orphan;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">云平台使用基本教程</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">四</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">微信点餐</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>一、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">绑定微信</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(一).</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">云平台设置(连锁模式)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">从我们的业务人员处获取账户登陆云平台。点击&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">微信业务</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#8221;&#8212;&#8212;&#62;&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">微信</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">门店管理&#8221;，选择组织机构树中</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">餐饮连锁</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">节点，点击&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">修改</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#8221;按钮进入</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">门店信息</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">编辑页面，</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">勾选开启连锁并填写基本信息</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(尤其是原始ID、APPID和APPSECRET要正确填写，且一个微信服务号只能绑定一次)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="299"
				src="<%=basePath%>common/images/help/helpWeChatOrder178.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">用绑定的微信服务号登陆微信公众平台，进入开发者中心，点击&#8220;修改配置&#8221;按钮进入开发者中心配置编辑页面，填入<font
				face="Times New Roman">URL:http://yun.yqspos.com/CateSystem/weiXinCY</font><font
				face="宋体">和</font><font face="Times New Roman">Token:wwwscposcom</font><font
				face="宋体">并随机生成</font><font face="Times New Roman">EncodingAESKey</font><font
				face="宋体">提交即可。然后回到开发者中心，在接口权限表中选择&#8220;网页授权获取用户基本信息&#8221;填入授权回调页&#8220;</font></span><span
				style="mso-spacerun: 'yes'; font-family: 'Microsoft YaHei UI'; color: rgb(0, 0, 0); font-size: 9.0000pt; mso-font-kerning: 1.0000pt;">www.yqspos.com</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#8221;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="299"
				src="<%=basePath%>common/images/help/helpWeChatOrder378.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">回到云平台点击&#8220;微信业务&#8221;&#8212;&#8212;<font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;微信菜单设置&#8221;，选择刚才绑定微信服务号的&#8220;优美味&#8221;餐饮连锁，可以选择导入模板菜单或者自定义微信菜单，此处我们导入模板菜单。导入成功后点击生成微信菜单。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="300"
				src="<%=basePath%>common/images/help/helpWeChatOrder474.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">回到&#8220;微信门店管理&#8221;点击&#8220;优美味&#8221;餐饮连锁旗下的&#8220;优美味河西店&#8221;门店进行门店信息编辑，&#8220;是否显示&#8221;项选择&#8220;显示&#8221;并填入其他基本信息保存<font
				face="Times New Roman">(</font><font face="宋体">由于它的上级组织机构&#8220;优美味&#8221;餐饮连锁已经绑定微信且开启连锁，所以此处不需要填写微信选项</font><font
				face="Times New Roman">)</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="299"
				src="<%=basePath%>common/images/help/helpWeChatOrder591.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">二</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">).</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">云平台设置(单店模式)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">点击&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">微信业务</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#8221;&#8212;&#8212;&#62;&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">微信</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">门店管理&#8221;，选择组织机构树中</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#8220;优美味迈皋桥店&#8221;餐饮单店</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">节点，点击&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">修改</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#8221;按钮进入</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">门店信息</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">编辑页面，</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">勾选显示并填写基本信息</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">微信公众平台设置同上。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(尤其是原始ID、APPID和APPSECRET要正确填写，且一个微信服务号只能绑定一次)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="297"
				src="<%=basePath%>common/images/help/helpWeChatOrder744.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>二、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">绑定终端并上传菜品</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">(</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">一</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">).</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">绑定终端</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">登陆终端机后台，点击&#8220;系统设置&#8221;&#8212;&#8212;<font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;云同步&#8221;&#8212;&#8212;</font><font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;云同步数据设置&#8221;进入云同步数据设置界面，填入账号密码和刚才添加的&#8220;优美味河西店&#8221;的组织机构码，验证保存，保存成功后上传基础资料。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="415"
				src="<%=basePath%>common/images/help/helpWeChatOrder859.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">(</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">二</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">).</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">菜品上架已经查看微信效果</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">回到云平台点击&#8220;微信业务&#8221;&#8212;&#8212;<font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;菜品管理&#8221;，选择刚才的&#8220;优美味河西店&#8221;将所有菜品上架。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="299"
				src="<%=basePath%>common/images/help/helpWeChatOrder927.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">选责菜品类型，点击&#8220;批量传图&#8221;上传菜品图片<font
				face="Times New Roman">(</font><font face="宋体">图片要以菜品编码命名</font><font
				face="Times New Roman">)</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="552" height="291"
				src="<%=basePath%>common/images/help/helpWeChatOrder964.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">关注你绑定的微信号，进入微信号即可看到你生成的微信菜单，并可以进行点菜</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="166" height="295"
				src="<%=basePath%>common/images/help/helpWeChatOrder1003.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="166" height="295"
				src="<%=basePath%>common/images/help/helpWeChatOrder1005.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="166" height="295"
				src="<%=basePath%>common/images/help/helpWeChatOrder1007.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>三、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">终端处理订单</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">1</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">).</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">接受订单</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">登陆终端前台，点击&#8220;微信功能&#8221;&#8212;&#8212;&#62;&#8220;微信外卖&#8221;即可查询到网络外卖订单，选择相应订单点击&#8220;下单&#8221;并确认</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="413"
				src="<%=basePath%>common/images/help/helpWeChatOrder1080.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">1</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">).</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">拒绝订单</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">登陆终端前台，点击&#8220;微信功能&#8221;&#8212;&#8212;&#62;&#8220;微信外卖&#8221;即可查询到网络外卖订单，选择相应订单点击&#8220;拒绝&#8221;并填入拒绝理由，确认即可。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="410"
				src="<%=basePath%>common/images/help/helpWeChatOrder1157.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
	</div>
	<!--EndFragment-->
	<script language="javascript" type="text/javascript">
    	document.body.style.backgroundColor="white";
   	</script>
</body>
</html>