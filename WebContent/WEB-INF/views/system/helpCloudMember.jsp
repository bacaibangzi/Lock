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
<title></title>
<!--[if gte mso 9]><xml><w:WordDocument><w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel><w:DisplayHorizontalDrawingGridEvery>0</w:DisplayHorizontalDrawingGridEvery><w:DisplayVerticalDrawingGridEvery>2</w:DisplayVerticalDrawingGridEvery><w:DocumentKind>DocumentNotSpecified</w:DocumentKind><w:DrawingGridVerticalSpacing>7.8 磅</w:DrawingGridVerticalSpacing><w:PunctuationKerning></w:PunctuationKerning><w:View>Web</w:View><w:Compatibility><w:DontGrowAutofit/><w:BalanceSingleByteDoubleByteWidth/><w:DoNotExpandShiftReturn/><w:UseFELayout/></w:Compatibility><w:Zoom>0</w:Zoom></w:WordDocument></xml><![endif]-->
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">云平台使用基本教程三(连锁模式.云会员)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>一、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">建立连锁</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(一).建立连锁商户</span><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">从我们的业务人员处获取账户登陆云平台。点击&#8220;商户管理&#8221;&#8212;&#8212;&#62;&#8220;商户门店管理&#8221;，选择组织机构树中经销商节点，点击&#8220;新增&#8221;按钮进入连锁商户编辑页面，在&#8220;机构类型&#8221;中选择&#8220;餐饮连锁&#8221;填入其他基本信息并保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="293"
				src="<%=basePath%>common/images/help/helpCloudMember142.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">(<font
				face="宋体">二</font><font face="Times New Roman">).</font><font
				face="宋体">分配连锁商户用户账号</font></span><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">点击&#8220;商户管理&#8221;&#8212;&#8212;<font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;商户用户管理&#8221;，选择刚才新建的&#8220;次食代&#8221;餐饮连锁，点击&#8220;新增&#8221;按钮进入商户用户账号编辑页面，填入基本信息并保存。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="296"
				src="<%=basePath%>common/images/help/helpCloudMember232.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">保存成功后，勾选刚刚新建的账户，点击&#8220;审核&#8221;按钮完成账号审核。右击该账户选择&#8220;分配账户服务&#8221;，进入账户服务分配页面。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="296"
				src="<%=basePath%>common/images/help/helpCloudMember293.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">勾选相应商户服务项并保存商户服务即可。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295"
				src="<%=basePath%>common/images/help/helpCloudMember315.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">(<font
				face="宋体">三</font><font face="Times New Roman">).</font><font
				face="宋体">建立总店</font></span><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">1<font
				face="宋体">．切换刚刚分配的商户用户账户&#8220;</font><font face="Times New Roman">jstj-CSD</font><font
				face="宋体">&#8221;登陆云平台。点击&#8220;我的账户&#8221;&#8212;&#8212;</font><font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;门店员工管理&#8221;，右击刚才分配的账户&#8220;</font><font
				face="Times New Roman">jstj-CSD</font><font face="宋体">&#8221;选择&#8220;分配门店权限&#8221;。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="296"
				src="<%=basePath%>common/images/help/helpCloudMember411.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">在填出的门店列表框中勾选刚才新建的&#8220;次食代&#8221;餐饮连锁机构，并保存用户门店权限。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295"
				src="<%=basePath%>common/images/help/helpCloudMember453.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">2.&nbsp;<font
				face="宋体">点击&#8220;我的账户&#8221;&#8212;&#8212;</font><font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;店铺信息管理&#8221;，选择组织机构树中刚才新建的&#8220;次食代&#8221;餐饮连锁，点击&#8220;新增&#8221;按钮进入店铺信息编辑页面，在&#8220;机构类型&#8221;中选择&#8220;总店&#8221;，填入其他基本信息并保存。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">(<font
				face="宋体">云会员的使用必须要建立连锁，并且在连锁机构下设立总店且只能设立一家总店</font><font
				face="Times New Roman">)</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="296"
				src="<%=basePath%>common/images/help/helpCloudMember587.png"><span
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
				style='mso-list: Ignore;'>二、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">建立连锁云会员</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(一).新增连锁会员类型&nbsp;</span><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">点击&#8220;会员管理&#8221;&#8212;&#8212;&#62;&#8220;连锁会员类型&#8221;，选择组织机构树中刚才新建的&#8220;次食代新街口店&#8221;，点击&#8220;新增连锁会员类型&#8221;进入连锁会员类型编辑页面填入基本信息并保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="294"
				src="<%=basePath%>common/images/help/helpCloudMember693.png"><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(二).新增连锁会员</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">1.&nbsp;点击&#8220;会员管理&#8221;&#8212;&#8212;&#62;&#8220;连锁会员信息&#8221;&nbsp;，选择组织机构树中&#8220;次食代新街口店&#8221;，点击&#8220;新增&#8221;按钮弹出会员信息编辑页面，填入基本信息，&#8220;会员类型&#8221;选择刚才新建的&#8220;白金卡&#8221;并保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">【会员编号和卡面卡号保持一致】</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="297"
				src="<%=basePath%>common/images/help/helpCloudMember816.png"><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">2.&nbsp;会员新增成功后，勾选新增的会员&#8220;南京大佬&#8221;点击&#8220;发卡&#8221;并确认。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295"
				src="<%=basePath%>common/images/help/helpCloudMember855.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">3.&nbsp;勾选刚才新增的账号，点击&#8220;充值&#8221;按钮进入充值界面。填入充值金额，点击读卡并录入需要充值的卡号并确定。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="294"
				src="<%=basePath%>common/images/help/helpCloudMember912.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">然后输入充值金额点击&#8220;充值&#8221;并确认。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295"
				src="<%=basePath%>common/images/help/helpCloudMember933.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; text-indent: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">4.<font
				face="宋体">点击&#8220;会员管理&#8221;&#8212;&#8212;</font><font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;连锁会员参数设置&#8221;</font><font
				face="Times New Roman">,</font><font face="宋体">选择组织机构树中&#8220;次食代新街口店&#8221;，卡类型选择&#8220;磁卡&#8221;</font><font
				face="Times New Roman">(</font><font face="宋体">目前支持磁卡</font><font
				face="Times New Roman">)</font><font face="宋体">，勾选&#8220;可手动输入会员号&#8221;并保存。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; text-indent: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="294"
				src="<%=basePath%>common/images/help/helpCloudMember1013.png"><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">线下使用连锁云会员消费</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(一).&nbsp;终端机配置(餐饮二和安卓)</span><span
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">登陆终端机后台，点击&#8220;系统设置&#8221;&#8212;&#8212;&#62;&#8220;云同步&#8221;&#8212;&#8212;&#8220;云同步数据设置&#8221;进入云同步数据设置页面，填入刚才建立的连锁账户&#8220;jstj-CSD&#8221;和密码以及门店编码。并勾选&#8220;使用云会员&#8221;和&#8220;启动云端&#8221;即可。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; color: rgb(255, 0, 0); font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(只要属于同一餐饮连锁机构下所有的餐饮连锁门店都可使用总店中的连锁云会员)</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="387"
				src="<%=basePath%>common/images/help/helpCloudMember1186.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(二).&nbsp;使用连锁云会员</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">终端机后台中点击&#8220;前台销售&#8221;&#8212;&#8212;&#62;&#8220;前台营业&#8221;。选好菜品后点击&#8220;结算&#8221;&#8212;&#8212;&#62;&#8220;会员卡&#8221;&#8212;&#8212;&#62;&#8220;读卡&#8221;&#8212;&#8212;&#62;&#8220;云会员&#8221;,然后填入刚才云端新建并发卡的卡号&#8220;20150827&#8221;。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="415"
				src="<%=basePath%>common/images/help/helpCloudMember1291.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">确认后输入密码并确定</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="414"
				src="<%=basePath%>common/images/help/helpCloudMember1304.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">然后即可读出连锁云会员，再点击&#8220;确定&#8221;&#8212;&#8212;<font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;买单&#8221;即可完成付款。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="413"
				src="<%=basePath%>common/images/help/helpCloudMember1340.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="415"
				src="<%=basePath%>common/images/help/helpCloudMember1342.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">(<font
				face="宋体">三</font><font face="Times New Roman">).&nbsp;</font><font
				face="宋体">云端查看云会员消费信息</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
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
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">登陆&#8220;<font
				face="Times New Roman">jstj-CSD</font><font face="宋体">&#8221;账号，点击&#8220;会员管理&#8221;&#8212;&#8212;</font><font
				face="Times New Roman">&#62;</font><font face="宋体">&#8220;连锁会员账号信息&#8221;，选择组织机构树中的&#8220;次食代新街口店&#8221;，右击会员&#8220;南京大佬&#8221;选择&#8220;查看会员消费流水信息&#8221;，即可查看连锁会员充值消费信息。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="287"
				src="<%=basePath%>common/images/help/helpCloudMember1462.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">总结：</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">1.<font
				face="宋体">建立线上连锁店&nbsp;&nbsp;</font><font face="Times New Roman">2.</font><font
				face="宋体">建立连锁云会员&nbsp;&nbsp;</font><font face="Times New Roman">3.</font><font
				face="宋体">线下使用连锁云会员消费</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
	</div>
	<!--EndFragment-->
	<script language="javascript" type="text/javascript">
    	document.body.style.backgroundColor="white";
   	</script>
</body>
</html>