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
<title>1).登录微信公众平台，点击开发者中心</title>
<!--[if gte mso 9]><xml><w:WordDocument><w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel><w:DisplayHorizontalDrawingGridEvery>0</w:DisplayHorizontalDrawingGridEvery><w:DisplayVerticalDrawingGridEvery>2</w:DisplayVerticalDrawingGridEvery><w:DocumentKind>DocumentNotSpecified</w:DocumentKind><w:DrawingGridVerticalSpacing>7.8 磅</w:DrawingGridVerticalSpacing><w:View>Web</w:View><w:Compatibility><w:DontGrowAutofit/><w:BalanceSingleByteDoubleByteWidth/><w:DoNotExpandShiftReturn/><w:UseFELayout/></w:Compatibility><w:Zoom>0</w:Zoom></w:WordDocument></xml><![endif]-->
<!--[if gte mso 9]><xml><w:LatentStyles DefLockedState="false"  DefUnhideWhenUsed="true"  DefSemiHidden="true"  DefQFormat="false"  DefPriority="99"  LatentStyleCount="260" >
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  Name="Normal" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="heading 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  QFormat="true"  Name="heading 9" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index 9" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="39"  SemiHidden="false"  Name="toc 9" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Normal Indent" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="footnote text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="annotation text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  Name="header" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  Name="footer" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="index heading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="35"  SemiHidden="false"  QFormat="true"  Name="caption" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="table of figures" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="envelope address" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="envelope return" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="footnote reference" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="annotation reference" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="line number" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="page number" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="endnote reference" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="endnote text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="table of authorities" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="macro" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="toa heading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Bullet" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Number" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Bullet 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Bullet 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Bullet 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Bullet 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Number 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Number 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Number 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Number 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="10"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Title" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Closing" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Signature" ></w:LsdException>
<w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  Name="Default Paragraph Font" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text Indent" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Continue" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Continue 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Continue 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Continue 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="List Continue 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Message Header" ></w:LsdException>
<w:LsdException Locked="false"  Priority="11"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Subtitle" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Salutation" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Date" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text First Indent" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text First Indent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Note Heading" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text Indent 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Body Text Indent 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Block Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Hyperlink" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="FollowedHyperlink" ></w:LsdException>
<w:LsdException Locked="false"  Priority="22"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Strong" ></w:LsdException>
<w:LsdException Locked="false"  Priority="20"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Emphasis" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Document Map" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Plain Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="E-mail Signature" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Normal (Web)" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Acronym" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Address" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Cite" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Code" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Definition" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Keyboard" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Preformatted" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Sample" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Typewriter" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="HTML Variable" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Normal Table" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="annotation subject" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="No List" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Simple 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Simple 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Simple 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Classic 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Classic 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Classic 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Classic 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Colorful 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Colorful 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Colorful 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Columns 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Columns 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Columns 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Columns 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Columns 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 4" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 5" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 6" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 7" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table List 8" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table 3D effects 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table 3D effects 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table 3D effects 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Contemporary" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Elegant" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Professional" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Subtle 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Subtle 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Web 1" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Web 2" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Web 3" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Balloon Text" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Grid" ></w:LsdException>
<w:LsdException Locked="false"  Priority="99"  SemiHidden="false"  Name="Table Theme" ></w:LsdException>
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
	mso-level-number-format: chinese-counting;
	mso-level-suffix: none;
	mso-level-text: "(%1)";
	mso-level-tab-stop: none;
	mso-level-number-position: left;
	margin-left: 0.0000pt;
	text-indent: 0.0000pt;
	font-family: 'Times New Roman';
}

@
list l2:level1 {
	mso-level-number-format: chinese-counting;
	mso-level-suffix: none;
	mso-level-text: "(%1)";
	mso-level-tab-stop: none;
	mso-level-number-position: left;
	margin-left: 0.0000pt;
	text-indent: 0.0000pt;
	font-family: 'Times New Roman';
}

@
list l3:level1 {
	mso-level-number-format: chinese-counting;
	mso-level-suffix: none;
	mso-level-text: "(%1)";
	mso-level-tab-stop: none;
	mso-level-number-position: left;
	margin-left: 0.0000pt;
	text-indent: 0.0000pt;
	font-family: 'Times New Roman';
}

@
list l4:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: none;
	mso-level-text: "%1、";
	mso-level-tab-stop: none;
	mso-level-number-position: left;
	margin-left: 0.0000pt;
	text-indent: 0.0000pt;
	font-family: 'Times New Roman';
}

@
list l5:level1 {
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
list l6:level1 {
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
list l7:level1 {
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
list l8:level1 {
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
list l9:level1 {
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
list l10:level1 {
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
list l11:level1 {
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
list l12:level1 {
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
list l13:level1 {
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
list l14:level1 {
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
	mso-fareast-font-family: 宋体;
	font-size: 10.5000pt;
	mso-font-kerning: 1.0000pt;
}

span.10 {
	font-family: 'Times New Roman';
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
			style="margin-left: 147.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: justify; text-justify: inter-ideograph;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">基本操作</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-weight: bold; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>一、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">登录</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">打开云平台网址www.yqspos.com，输入经销商账号密码登录云平台。</span><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">
				&#1607;&#1567;</span><img width="553" height="295"
				src="<%=basePath%>common/images/help/help56.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>二、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">经销商管理</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l1 level1 lfo2;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>(一)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">.</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">经销商机构维护</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#9;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">点击经销商机构维护，选择组织机构树经销商节点（经销商机构维护中只有经销商节点方可进行机构的新增和删除操作）。经销商机构维护下只能新增经销商机构。</span><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295" src="<%=basePath%>common/images/help/help152.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l1 level1 lfo2;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>(二)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">.</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">经销商信息维护</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">点击经销商信息维护，选择组织机构树经销商节点（经销商信息维护中只有经销商节点方可进行经销商管理账号的新增和删除操作）。点击新增按钮填入基本信息提交，勾选新增的经销商账号点击审核按钮完成审核。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295" src="<%=basePath%>common/images/help/help261.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">新增账户审核后，右击新增账户选择&#8220;分配经销商服务&#8221;，勾选&#8220;经销商下级分销管理&#8221;和&#8220;门店管理权限&#8221;，点击保存经销商服务，完成经销商账户分配。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="298" src="<%=basePath%>common/images/help/help335.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>三、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">商户管理</span><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l2 level1 lfo3;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>(一)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">.商户门店管理</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">点击&#8220;商户管理&#8221;选择商户门店管理，选择组织机构树经销商节点</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">（商户门店管理中只有经销商节点方可进行商户门店机构的新增和删除操作）</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="294" src="<%=basePath%>common/images/help/help418.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">点击新增按钮进入商户门店新增界面，经销商节点下可新建四中餐饮门店机构，即&#8220;餐饮连锁&#8221;、&#8220;超市连锁&#8221;、&#8220;餐饮单店&#8221;和&#8220;超市单店&#8221;。选择需要新建的商户门店机构类型填写基本信息保存即可。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="294" src="<%=basePath%>common/images/help/help512.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l2 level1 lfo3;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>(二)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">.商户用户管理</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">点击&#8220;商户管理&#8221;选择商户用户管理，选择组织机构树连锁或单店机构节点</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">（商户用户管理中只有这些节点方可进行商户门店机构的新增和删除操作），点击新增按钮进入新增用户界面，填入基本信息提交。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="296" src="<%=basePath%>common/images/help/help617.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">勾选新增的商户用户点击&#8220;审核&#8221;按钮，并右击该用户选择&#8220;分配商户服务&#8221;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">江四个商户服务全部勾选并保存，完成商户用户帐号分配。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295" src="<%=basePath%>common/images/help/help682.png"><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>四、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">我的账户</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">(一).门店员工管理</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">用商户用户帐号登录平台，点击&#8220;我的账户&#8221;，单击门店员工管理，选择组织机构树节点,点击&#8220;新增&#8221;按钮填入基本信息，点击保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295" src="<%=basePath%>common/images/help/help766.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">勾选新增的员工账号，点击&#8220;审核&#8221;，并且右击选择&#8220;分配员工权限&#8221;和&#8220;分配门店权限&#8221;，勾选相应权限保存即可，员工账号分配完毕。&nbsp;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">&#1607;&#1670;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="297" src="<%=basePath%>common/images/help/help834.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>五、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">建立连锁</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l3 level1 lfo4;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>(一)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">.用经销商账户登录云平台，点击&#8220;商户管理&#8221;选择商户门店管理，点击组织机构树经销商节点。点击&#8220;新增&#8221;按钮，机构类型选择&#8220;餐饮连锁&#8221;，填入基本信息保存。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="295" src="<%=basePath%>common/images/help/help918.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l3 level1 lfo4;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><span
				style='mso-list: Ignore;'>(二)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">.<font
				face="宋体">选择商户用户管理，选择机构树中新建的&#8220;麦德基&#8221;餐饮连锁，点击新增按钮进入商户用户新增界面，填入必要信息点击保存。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="296" src="<%=basePath%>common/images/help/help979.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">勾选刚才新增的商户用户账号&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">jstj-CY</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#8221;，点击审核并右键单击选择&#8220;分配商户服务&#8221;，全部勾选保存即可。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="554" height="297" src="<%=basePath%>common/images/help/help1036.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l3 level1 lfo4;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><span
				style='mso-list: Ignore;'>(三)</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">、切换刚刚新增的&#8220;<font
				face="Times New Roman">jstj-CY</font><font face="宋体">&#8221;商户用户帐号登录云平台，点击&#8220;我的账户&#8221;选择店铺信息管理，选择组织机构树刚才建立的&#8220;麦德基&#8221;餐饮连锁机构，点击新增进入店铺新增页面，填入基本信息，选择机构类型，有&#8220;总店&#8221;、&#8220;连锁&#8221;和&#8220;加盟&#8221;三种。</font></span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<img width="553" height="294" src="<%=basePath%>common/images/help/help1155.png"><span
				style="mso-spacerun: 'yes'; font-family: 'Times New Roman'; mso-fareast-font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#8220;麦德基河西店&#8221;新增后，点击门店员工管理，选择组织机构树&#8220;麦德基&#8221;餐饮连锁机构，右击&#8220;</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">jstj-CY</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">&#8221;用户选择&#8220;分配员工权限&#8221;和&#8220;分配门店权限&#8221;勾选相应信息保存即可。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">连锁总结：</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 42.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l4 level1 lfo5;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><span
				style='mso-list: Ignore;'>1、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">经销商从商朝时代获取分配的经销商</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 42.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l4 level1 lfo5;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><span
				style='mso-list: Ignore;'>2、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">登录经销商账号进入商户管理的商户门店管理建立连锁机构</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 42.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l4 level1 lfo5;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><span
				style='mso-list: Ignore;'>3、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">在商户管理商户用户管理给新建的的连锁机构建立用户账号并分配商户服务</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 42.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left; mso-list: l4 level1 lfo5;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><span
				style='mso-list: Ignore;'>4、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">用新建的商户账户登录在&#8220;我的账户&#8221;中的&#8220;店铺信息管理&#8221;，在刚才建立的连锁机构下建立连锁单位并分配员工管理账号即可完成连锁</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 63.0000pt; mso-para-margin-left: 0.0000gd; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">总之，就像是一个大树，商朝时代就像是树根，经销商是树干，可以再往下发展树干、树枝以及树叶，从而形成一个完整的生态系统。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=MsoNormal
			style="mso-pagination: widow-orphan; text-align: left; mso-list: l0 level1 lfo1;">
			<![if !supportLists]>
			<span
				style="font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><span
				style='mso-list: Ignore;'>六、</span></span>
			<![endif]>
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;">云端上传下载</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 12.0000pt; mso-font-kerning: 0.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;">在终端机器&#8220;云服务&#8221;界面填入账号密码及对应组织机构码通过校验即可上传下载基础资料和流水数据，其中流水数据只能上传不可下载。上传成功即可用对应账户登录云平台在&#8220;餐饮商户中心&#8221;和&#8220;运营分析&#8221;查看上传数据。</span><span
				style="mso-spacerun: 'yes'; font-family: 宋体; font-size: 10.5000pt; mso-font-kerning: 1.0000pt;"><o:p></o:p></span>
		</p>
		<p class=MsoNormal
			style="margin-left: 21.0000pt; mso-para-margin-left: 0.0000gd; text-indent: 21.0000pt; mso-char-indent-count: 0.0000; mso-pagination: widow-orphan; text-align: left;">
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