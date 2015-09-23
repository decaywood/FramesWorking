package utils;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class DataSender {

	private static final int packetSize = 40960;
	private static final int sleepTime = 20;

	public static void send(String data){
		send("192.168.1.255", 10000, data);
	}


	public static void send(String iaddress, int port, String data){
		
		try {
			InetAddress address = InetAddress.getByName(iaddress);
			MulticastSocket socket = new MulticastSocket(port);
			socket.setTimeToLive(1);
			byte[] bytes = data.getBytes();

			byte[][] tmpData;
			if(bytes.length > packetSize){
				System.out.println("指令需拆分发送.");
				if(bytes.length % packetSize == 0)
					tmpData = new byte[bytes.length/packetSize][packetSize];
				else
					tmpData = new byte[bytes.length/packetSize + 1][packetSize];
				for(int i=0; i< tmpData.length; i++){
					int index = 0;
					for(int j=i*packetSize; j<Math.min((i + 1) * packetSize, bytes.length); j++){
						tmpData[i][index] = bytes[j];
						index++;
					}
				}
			}else{
				System.out.println("指令仅需一次发送.");
				tmpData = new byte[1][bytes.length];
				tmpData[0] = bytes;
			}
			
			System.out.println("开始发送，发送端口："+port+"\n发送内容如下：");
			for (byte[] aTmpData : tmpData) {
				DatagramPacket packet = new DatagramPacket(aTmpData, aTmpData.length, address, port);
				socket.send(packet);
				System.out.println(new String(aTmpData));
				Thread.sleep(sleepTime);
			}
			System.out.println("发送完成！");
			System.out.println("指令总长度:" + bytes.length + "字节.");
			System.out.println("分包大小:" + packetSize + "字节.");
			System.out.println("共发送了" + tmpData.length + "个包.");

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	


}
