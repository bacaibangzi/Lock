<%-- 
    Document   : print
    Created on : 2009-9-30, 16:04:32
    Author     : edwang
    修改记录     ：2009-10-21 zhangzl 
                   将传过来的参数拼装成GET URL的形式
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    /**
     *将传过来的参数拼装成GET URL的形式
     */
    java.util.Enumeration e = request.getParameterNames();
    java.lang.StringBuffer sb = new java.lang.StringBuffer();
    sb.append("../servlets/jrreport?");
    String pName = null;
    String pValue = null;
    while(e.hasMoreElements()){
        pName = (String)e.nextElement();
        if("user".equals(pName)){
            continue;
        }
        pValue = request.getParameter(pName).replaceAll(" ","+").replaceAll("\\'","\\\\'");
        sb.append(pName);
        sb.append("=");
        sb.append(pValue);
        sb.append("&");
        
    }
    String raq = request.getParameter("raq");
    String userIdList = request.getParameter("userIdList");
    String ctx = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>打印</title>
        
        <script language="javascript">
            /*
             * 主要区域高度自适应
             */
            function resize(){
                if(document.getElementById("applet")){
                    document.getElementById("applet").style.height = (windowHeight()-10) + "px";
                }
            }
            
            /*
             * 获得当前窗口高度
             */
            function windowHeight(){
                var de = document.documentElement;
                return self.innerHeight || ( de && de.clientHeight) || document.body.clientHeight;
            }
            
        </script>
    </head>
    <body scroll="no" onload="resize()" onresize="resize()" style="margin: 0 0 0 0;scroll: no ;">
        <SCRIPT LANGUAGE="JavaScript"><!--
            var _info = navigator.userAgent; 
            var _ns = false; 
            var _ns6 = false;
            var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
        //--></SCRIPT>
            <COMMENT>
                <SCRIPT LANGUAGE="JavaScript1.1"><!--
                var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
                var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
        //--></SCRIPT>
            </COMMENT>
        
        <SCRIPT LANGUAGE="JavaScript"><!--
            if (_ie == true) document.writeln('<APPLET id="applet" CODE = "EmbeddedViewerApplet.class" CODEBASE = "<%= ctx + "/applets"%>" ARCHIVE = "jfreechart.jar,jcommon-1.0.15.jar,commons-digester.jar,jasperreports-3.6.0-applet.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "100%" HEIGHT = "100%"><PARAM NAME = "REPORT_URL" VALUE ="<%=sb.toString() %>"/></APPLET>');
            else {document.writeln('<EMBED id="applet" type="application/x-java-applet;version=1.1.2" CODE = "EmbeddedViewerApplet.class" CODEBASE = "<%= ctx + "/applets"%>" ARCHIVE = "jfreechart.jar,jcommon-1.0.15.jar,commons-digester.jar,jasperreports-3.6.0-applet.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "100%" HEIGHT = "100%" REPORT_URL = "<%=sb.toString() %>" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.1.2/plugin-install.html"></EMBED>')};
        //--></SCRIPT>
        
        <div></div>
        <!--
        <APPLET CODE = "EmbeddedViewerApplet.class" CODEBASE = "applets" ARCHIVE = "jasperreports-3.6.0-applet.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "600" HEIGHT = "400">
        <PARAM NAME = "REPORT_URL" VALUE ="../servlets/jasperprint">
        
        
        </APPLET>
        -->
        <!--"END_CONVERTED_APPLET"-->
    </body>
</html>
