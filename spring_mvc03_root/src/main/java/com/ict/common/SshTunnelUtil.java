package com.ict.common;


import com.jcraft.jsch.*;

// 하이드 실행 시키면 의미없는 파일 삭제 해도 된다.
public class SshTunnelUtil {
	/*
    public static void setupSshTunnel(
    		String sshHost, 
    		int sshPort, 
    		String sshUser, 
    		String privateKeyPath, 
            String dbHost, 
            int dbPort, 
            String dbUser, 
            String dbPassword, 
            int localPort) throws JSchException {
        JSch jsch = new JSch();
        jsch.addIdentity(privateKeyPath);

        Session session = jsch.getSession(sshUser, sshHost, sshPort);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        session.setPortForwardingL(localPort, dbHost, dbPort);
    }
     */    
   	
    public static void setupSshTunnel() throws JSchException {
    	
    	JSch jsch = new JSch();
    	jsch.addIdentity("F:\\nohssam\\LinuxStudy\\test.ppk");
    	
    	Session session = jsch.getSession("ubuntu", "138.2.116.2", 22);
    	session.setConfig("StrictHostKeyChecking", "no");
    	session.connect();
    	session.setPortForwardingL(3307, "127.0.0.1", 3306);
    }
}