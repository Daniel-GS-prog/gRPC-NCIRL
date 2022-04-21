import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cityInService.StringMessage;
import cityInService.cityInServiceGrpc;
import cityInService.cityInServiceGrpc.cityInServiceBlockingStub;
import currentTraffic.currentTrafficGrpc;
import currentTraffic.currentTrafficGrpc.currentTrafficBlockingStub;
import currentTraffic.currentTrafficGrpc.currentTrafficStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import obstacles.obstaclesGrpc;
import obstacles.obstaclesGrpc.obstaclesStub;

public class TestApp extends JFrame{
	
	
	public static void main (String[] args) {
		
		GridBagLayoutDemo gbl = new GridBagLayoutDemo();
		
	}
	
}
