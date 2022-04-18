import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cityInService.StringMessage;
import cityInService.cityInServiceGrpc;
import cityInService.cityInServiceGrpc.cityInServiceBlockingStub;
import currentTraffic.currentTrafficGrpc.currentTrafficBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.awt.EventQueue;

public class smartCityGUI {
	
	private static cityInServiceBlockingStub cityInServicebStub;
	
	private JFrame frame;
	private JTextArea textResponse ;
	
	
	// Launching application: 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//overide the run method of runnable
			public void run() {
				try {
					smartCityGUI window = new smartCityGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create application:
	public smartCityGUI() {
	
	int port = 50051;
	String host = "localhost";
	
	// Creating Channel:
	ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
	// Create a stub, pass the channel to the stub
	 cityInServicebStub = cityInServiceGrpc.newBlockingStub(newChannel);
	
	initialize();
	
	}
	
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Smart city gRPC");
		
		// Dimensions:
		frame.setBounds(100, 100, 1000, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Box layout:
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(bl);
		
		
		// ----------- Implementation of first service "City in Service" ------------------ //
		
		// Create JPanel:
		JPanel panel_cityInService = new JPanel();
		frame.getContentPane().add(panel_cityInService);
		
		panel_cityInService.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		// New Label for panel_cityInService:
		JLabel cityInServiceLabel = new JLabel("City In Service ");
		
		panel_cityInService.add(cityInServiceLabel);
		
		
		// Input text Box:
		JTextField textCity = new JTextField();
		panel_cityInService.add(textCity);
		
		textCity.setColumns(10);
		
		// Button to send request:
		JButton submit = new JButton("Submit");
		
		// Listening for Input:
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String city = textCity.getText();
				
				StringMessage cString = StringMessage.newBuilder().setCity(city).build();
				
				// Getting message back from the server:
				StringMessage response = cityInServicebStub.cityInService(cString);
				
				// Printing response:
				//System.out.println(response.getCity());
				
				//Populate JTextArea:
				textResponse.append(response.getCity());
				
			}
			
		});
		
		panel_cityInService.add(submit);
		
		textResponse = new JTextArea(2, 45);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_cityInService.add(scrollPane);
		
		// ----------- End Implementation of first service "City in Service" ------------------ //
		
		
		
	}
}
