package net.strive.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpRecv {
	private static DatagramPacket packet;   
	  
    public static void main(String[] args) {   
        try {   
            DatagramSocket ds = new DatagramSocket(9999);   
            byte[] buf = new byte[1024];   
            DatagramPacket packet = new DatagramPacket(buf, buf.length);   
            ds.receive(packet);   
            String strRecv = new String(packet.getData(), 0, packet.getLength())   
                    + " from "  
                    + packet.getAddress().getHostAddress()   
                    + ":"  
                    + packet.getPort();   
            System.out.println(strRecv);   
            ds.close();   
  
        } catch (SocketException e) {   
            e.printStackTrace();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
}
