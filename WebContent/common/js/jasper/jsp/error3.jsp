<%-- 
    Document   : empty
    Created on : 2009-10-12, 14:14:32
    Author     : zhangzl
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>报表生成错误</title>
        <style type="text/css">
            *{
                padding:0;
                margin:0;
                font-size:12px;
             }
             
             .style1{
                font-size:12px; 
                overflow:auto;width:100%; 
                height: 95%;
                LEFT: 0px; 
                word-break: break-all;
                WORD-WRAP: break-word; 
                text-align: left;
             }
             
             .style2{
                background: url(../images/errpage/errmsg9.jpg) no-repeat center; 
                padding-top:10px; 
                padding-left:10px;
             }
        </style>
    </head>
    <body scroll="no">  
         <table width="100%" style="margin:0 auto;" cellpadding="0" align="center" cellspacing="0" border="0"> 
        <tr><td align="center">
          <table id="tbl" style="margin-top:50px;" width="80%" cellpadding="0" cellspacing="0" border="0">
            <tr>
                <td height="25" width="7" background="../images/errpage/errmsg1.jpg"></td>
                <td id="tbl_td" align="left" background="../images/errpage/errmsg2.jpg" style="font-size:12px;">系统提示信息</td>
                <td height="25" width="7" background="../images/errpage/errmsg3.jpg"></td>
            </tr>
            <tr>
                <td height="230" width="7" background="../images/errpage/errmsg4.jpg"></td>
                <td class="style2" valign="top">
                    <table width="95%">
                        <tr>
                            <td width="37" valign="top">
                                <img src="../images/errpage/errmsg10.jpg" />
                            </td>
                            <td style="overflow:hidden; padding-top:13px;" valign="top" align="left">
                                <span class="style1">&nbsp;生成报表有误，请稍后重试！</span>
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="7" background="../images/errpage/errmsg5.jpg"></td>
            </tr>
            <tr>
                <td height="7" width="7" background="../images/errpage/errmsg6.jpg"></td>
                <td height="7" background="../images/errpage/errmsg7.jpg"></td>
                <td height="7" width="7" background="../images/errpage/errmsg8.jpg"></td>
            </tr>
          </table>
        </td></tr>
    </table>
    </body>
</html>
