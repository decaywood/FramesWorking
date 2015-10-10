package utils;

import data.DataAnalizer;
import data.TreeElement;
import views.generalComponents.JTreePanel;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mamamiyear
 * @date 15-10-8
 */

public class ReceiveInstruction extends Thread {

    int qPort = 0;
    String qIpAddress = "";
    InetAddress qAddress = null;
    MulticastSocket socket = null;
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public ReceiveInstruction(String ipAddress, int port) {

        super("receive instruction");
        qPort = port;
        qIpAddress = ipAddress;
        try {

            qAddress = InetAddress.getByName(qIpAddress);
            socket = new MulticastSocket(port);
            this.start();

        } catch (Exception e) {
            System.out.println("未能成功指定接收地址或创建套接字");
        }
    }


    @Override
    public void run() {
        System.out.println("指令接收线程启动");
        while (true) {

            byte[] datas = new byte[40960];
            DatagramPacket packet = new DatagramPacket(datas, datas.length, qAddress, qPort);
            try {
                socket.receive(packet);
                System.out.println("接收到指令"+new String(packet.getData()));
                String message = new String(packet.getData(), 0, packet.getLength());
                singleThreadExecutor.submit(new ProcessTask(message));

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

        }

    }

    public void dispose() {
        socket.close();
        singleThreadExecutor.shutdown();
    }

    private static class ProcessTask implements Runnable {

        private final String data;
        public ProcessTask(String string) {
            this.data = string;
        }

        @Override
        public void run() {
            TreeElement root = new DataAnalizer().readSource(data);
            ColleagueManager manager = ColleagueManager.Holder.MANAGER;
            manager.setData(JTreePanel.class.getName(), root);
        }


    }
}
