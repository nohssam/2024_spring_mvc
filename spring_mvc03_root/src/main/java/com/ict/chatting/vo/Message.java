package com.ict.chatting.vo;

public class Message implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7057981510274684605L;
    private String textMessage; // 메시지 내용
    private String sender; // 보낸 회원 아이디
    private String receiver; // 받는 회원 아이디
    private String connectYN;	// 대기 중 여부
    
	public Message() {
		super();
	}

	public Message(String textMessage, String sender, String receiver, String connectYN) {
		super();
		this.textMessage = textMessage;
		this.sender = sender;
		this.receiver = receiver;
		this.connectYN = connectYN;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getConnectYN() {
		return connectYN;
	}

	public void setConnectYN(String connectYN) {
		this.connectYN = connectYN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Message [textMessage=" + textMessage + ", sender=" + sender + ", receiver=" + receiver + ", connectYN="
				+ connectYN + "]";
	}

	
	
	
}