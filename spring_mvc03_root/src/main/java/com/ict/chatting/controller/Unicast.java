package com.ict.chatting.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;


@ServerEndpoint("/chat")
public class Unicast {

	private static Set<Session> clients
	 = Collections.synchronizedSet(
			 new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session session){

		System.out.println(session);

		clients.add(session);
	}
	
	@OnMessage
	 public void onMessage(
			 String msg, Session session) throws IOException{

		
		System.out.println(msg);

		
		synchronized(clients){

			for(Session client : clients){
				

				if(!client.equals(session)){
					

					client.getBasicRemote()
					.sendText(msg);
				}
			}
		}
	}
	@OnError
	public void onError(Throwable e){

		
		e.printStackTrace();
	}
	@OnClose
	public void onClose(Session session){
		clients.remove(session);
	}
	
}


















