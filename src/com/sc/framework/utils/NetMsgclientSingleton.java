package com.sc.framework.utils;

import java.io.IOException;

import com.linkage.netmsg.NetMsgclient;
import com.linkage.netmsg.server.AnswerBean;
import com.linkage.netmsg.server.ReceiveMsg;
import com.linkage.netmsg.server.ReturnMsgBean;
import com.linkage.netmsg.server.UpMsgBean;

public class NetMsgclientSingleton {

	private static NetMsgclientSingleton msgclientSingleton = null;
	static NetMsgclient client = new NetMsgclient();
	public static final String mode = "【商朝时代】您的商朝摇钱数验证码为：X 。";

	private NetMsgclientSingleton() {

	}

	public static NetMsgclientSingleton getInstance() {

		if (msgclientSingleton == null || client == null) {
			msgclientSingleton = new NetMsgclientSingleton();

		}
		ReceiveMsg receiveMsg = new ReceiveMsgEx();

		client = client.initParameters("202.102.41.101", 9005, "025C00338909",
				"651024", receiveMsg);
		try {
			client.anthenMsg(client);
			System.out.println("init");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgclientSingleton;
	}

	public static NetMsgclient getClient() {

		return client;
	}

	public static void main(String args[]){
		NetMsgclientSingleton msgclientSingleton  =NetMsgclientSingleton.getInstance();
		NetMsgclient msgclient = msgclientSingleton.getClient();
		String code = "654321";
		msgclient.sendMsg(msgclient, 1, "13913915857", NetMsgclientSingleton.mode.replaceAll("X", code)
			, 1);

		msgclient.closeConn();
	}
}




class ReceiveMsgEx extends ReceiveMsg {
	@Override
	public void getAnswer(AnswerBean answerBean) {
		System.out.println("getAnswer");
		super.getAnswer(answerBean);

	}

	@Override
	public void getReturnMsg(ReturnMsgBean returnMsgBean) {
		super.getReturnMsg(returnMsgBean);

		super.getReturnMsg(returnMsgBean);

		String sequenceId = returnMsgBean.getSequenceId();

		/* 短信的msgId */
		String msgId = returnMsgBean.getMsgId();

		/* 发送号码 */
		String sendNum = returnMsgBean.getSendNum();

		/* 接收号码 */
		String receiveNum = returnMsgBean.getReceiveNum();

		/* 短信提交时间 */
		String submitTime = returnMsgBean.getSubmitTime();

		/* 短信下发时间 */
		String sendTime = returnMsgBean.getSendTime();

		/* 短信状态 */
		String msgStatus = returnMsgBean.getMsgStatus();

		/* 短信错误代码 */
		int msgErrStatus = returnMsgBean.getMsgErrStatus();

		// 此处加入接收短信回执的处理代码

	}

	@Override
	public void getUpMsg(UpMsgBean pMsgBean) {
		super.getUpMsg(pMsgBean);
		System.out.println("getUpMsg");
	}
}