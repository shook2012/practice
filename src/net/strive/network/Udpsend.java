package net.strive.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Udpsend {
	public static void main(String[] args) {   
		  
        try {   
            DatagramSocket ds = new DatagramSocket();   
            String str = "hello";   
            DatagramPacket dp = new DatagramPacket(str.getBytes(), str   
                    .getBytes().length, InetAddress   
                    .getByName("192.168.203.95"), 9999);   
            ds.send(dp);   
            ds.close();   
        } catch (SocketException e) {   
            // TODO Auto-generated catch block   
            e.printStackTrace();   
        } catch (UnknownHostException e) {   
            // TODO Auto-generated catch block   
            e.printStackTrace();   
        } catch (IOException e) {   
            // TODO Auto-generated catch block   
            e.printStackTrace();   
        }   
    }   
}
