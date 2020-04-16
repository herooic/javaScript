package com.yedam.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();		
		String address = ia.getHostAddress();
		String hosrname = ia.getHostName();
		System.out.println("address"+ address);
		
		InetAddress[] ias = InetAddress.getAllByName("www.naver.com");
		for(InetAddress adr : ias) {
			System.out.println(adr.getHostAddress());
			
		}
	}
}
