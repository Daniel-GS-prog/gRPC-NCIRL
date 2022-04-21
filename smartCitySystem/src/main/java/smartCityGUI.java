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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import cityInService.IntMessage;
import cityInService.StringMessage;
import cityInService.cityInServiceGrpc;
import cityInService.cityInServiceGrpc.cityInServiceBlockingStub;
import currentTraffic.StringM;
import currentTraffic.StringMOrBuilder;
import currentTraffic.currentTrafficGrpc;
import currentTraffic.currentTrafficGrpc.currentTrafficBlockingStub;
import currentTraffic.currentTrafficGrpc.currentTrafficStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import obstacles.Message;
import obstacles.obstaclesGrpc;
import obstacles.obstaclesGrpc.obstaclesStub;

import java.awt.EventQueue;

public class smartCityGUI {
	
	private static cityInServiceBlockingStub cityInServicebStub;
	private static currentTrafficBlockingStub currentTrafficbStub;
	private static currentTrafficStub asyncStub;
	private static obstaclesStub ObsasyncStub;
	
	private JFrame frame;
	private JTextArea textResponse ;
	private JTextArea txtResponse;
	private JTextArea currentTrafficResponse;
	private JTextArea TrafficInCityResponse;
	private JTextArea ObstaclesResponse;
	
	// Launching application: 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			//Override the run method of runnable
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
	
	// Create all stubs needed, pass the channel to the stub
	 cityInServicebStub = cityInServiceGrpc.newBlockingStub(newChannel);
	 currentTrafficbStub = currentTrafficGrpc.newBlockingStub(newChannel);
	 asyncStub = currentTrafficGrpc.newStub(newChannel);
	 ObsasyncStub = obstaclesGrpc.newStub(newChannel);
	
	initialize();
	
	}
	
	
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Smart city gRPC");
		
		// Dimensions:
		frame.setBounds(100, 100, 1400, 500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Box layout:
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(bl);
		
		
		
		// ----------- Implementation of rpc "City in Service" ------------------ //
		
		// Create JPanel:
		JPanel panel_cityInService = new JPanel();
		frame.getContentPane().add(panel_cityInService);
		
		panel_cityInService.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		// New Label for panel_cityInService:
		JLabel cityInServiceLabel = new JLabel("Check if a city is in the service ");
		
		panel_cityInService.add(cityInServiceLabel);
		
		
		// Input text Box:
		JTextField textCity = new JTextField();
		panel_cityInService.add(textCity);
		
		textCity.setColumns(10);
		
		// Button to send request:
		JButton submit = new JButton("Check city");
		
		// Listening for Input:
		submit.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// Clearing JTextArea:
				textResponse.setText("");
				
				String city = textCity.getText();
				
				StringMessage cString = StringMessage.newBuilder().setCity(city).build();
				
				// Getting message back from the server:
				StringMessage response = cityInServicebStub.cityInService(cString);
				
			
				//Populate JTextArea:
				textResponse.append(response.getCity());
				
			}
			
		});
		
		panel_cityInService.add(submit);
		
		textResponse = new JTextArea(2, 45);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneCity = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_cityInService.add(scrollPaneCity);
		
		
		// ----------- End Implementation of rpc "City in Service" ------------------ //
		
		
		
		// ----------- Implementation of rpc TemperatureInCity ------------------ //
		
		// Create JPanel:
		
		JPanel panel_temperatureInCity = new JPanel();
		frame.getContentPane().add(panel_temperatureInCity);
		panel_temperatureInCity.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		// New Label for panel_cityInService:
		JLabel temperatureInCityLabel = new JLabel("Check the temperature in a city: ");
		
		panel_temperatureInCity.add(temperatureInCityLabel);
		
		// Input text Box:
		JTextField txtCity = new JTextField();
		panel_temperatureInCity.add(txtCity);
		txtCity.setColumns(10);
		
		// Button to send request:
		JButton temperatureButton = new JButton("Check temperature");
		
		
		// Listening for Input:
		temperatureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// Clearing JTextArea:
				txtResponse.setText("");
				
				String city = txtCity.getText();
				
				StringMessage cString = StringMessage.newBuilder().setCity(city).build();
				
				// Getting message back from the server:
				IntMessage response = cityInServicebStub.temperatureInCity(cString);
				
				String str1 = String.valueOf(response.getTemperature());
				
				
				// Displaying message in GUI:
				txtResponse.append("The temperature in " + city + " is: " + str1 + " degrees celsius.");
				
				
			}
				
		});
		
		// Adding button to the panel
		panel_temperatureInCity.add(temperatureButton);
		
		txtResponse = new JTextArea(2, 45);
		txtResponse .setLineWrap(true);
		txtResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneTemperature = new JScrollPane(txtResponse);
		
		
		panel_temperatureInCity.add(scrollPaneTemperature);
		
		
		// ----------- End of Implementation of rpc TemperatureInCity ------------------ //
		
		
		// ----------- Implementation of rpc Current Traffic ------------------ //
		
		// Create JPanel:
		
		JPanel panel_currentTraffic = new JPanel();
		frame.getContentPane().add(panel_currentTraffic);
		panel_currentTraffic.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		// New Label for panel_currentTraffic:
		JLabel trafficInCityCentreLabel = new JLabel("Check traffic city center: ");
		panel_currentTraffic.add(trafficInCityCentreLabel);
		
		// Input text Box:
		JTextField txtTraffic = new JTextField();
		panel_currentTraffic.add(txtTraffic);
		txtTraffic.setColumns(10);
		
		// Button to send request:
		JButton trafficButton = new JButton("Check traffic");
		
		// Listening for Input:
		trafficButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// Clearing JText area:
				currentTrafficResponse.setText("");
				
				String city = txtTraffic.getText();
				
				currentTraffic.StringMessage cString = currentTraffic.StringMessage.newBuilder().setCity(city).build();
				
				
				// Creating Iterator to pass stream messages from server:
    			Iterator<currentTraffic.StringMessage> responses = currentTrafficbStub.currentTraffic(cString);
    			
    			// Assigning and printing responses from server in GUI:
				while (responses.hasNext()) {
					
					currentTraffic.StringMessage individualResponse = responses.next();
					currentTrafficResponse.append(individualResponse.getCity());
					currentTrafficResponse.append(" ");
					
				}
				
			}

		});
		
		// Adding button to the panel
		panel_currentTraffic.add(trafficButton);
		
		currentTrafficResponse = new JTextArea(2, 45);
		currentTrafficResponse .setLineWrap(true);
		currentTrafficResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneCurrentTraffic = new JScrollPane(currentTrafficResponse);
		
		panel_currentTraffic.add(scrollPaneCurrentTraffic);
		
		// ----------- End of Implementation of rpc Current Traffic ------------------ //
		
		
		
		// ----------- Implementation of rpc Traffic In City ------------------ //
		
		// Create JPanel:
		
		JPanel panel_TrafficInCity = new JPanel();
		frame.getContentPane().add(panel_TrafficInCity);
		panel_TrafficInCity.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		// New Label for panel_currentTraffic:
		JLabel trafficInCityLabel = new JLabel("Check traffic in city: ");
		panel_TrafficInCity.add(trafficInCityLabel);
		
		// Input text Boxes:
		JTextField txtTrafficInCity1 = new JTextField();
		JTextField txtTrafficInCity2 = new JTextField();
		JTextField txtTrafficInCity3 = new JTextField();
		
		panel_TrafficInCity.add(txtTrafficInCity1);
		panel_TrafficInCity.add(txtTrafficInCity2);
		panel_TrafficInCity.add(txtTrafficInCity3);
		
		txtTrafficInCity1.setColumns(10);
		txtTrafficInCity2.setColumns(10);
		txtTrafficInCity3.setColumns(10);
		
		// Button to send request:
		JButton trafficCityButton = new JButton("traffic 3 streets");
		
		// Listening for Input:
		trafficCityButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StreamObserver<StringM> responseObserver = new StreamObserver<StringM>() {

					@Override
					public void onNext(StringM value) {
						// TODO Auto-generated method stub
						
						// clearing TextArea:
						TrafficInCityResponse.setText("");
						
						// Displaying message in GUI
						TrafficInCityResponse.append(value.getCity1());				}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						
					}};
					
					StreamObserver<StringM> requestObserver = asyncStub.trafficInCity(responseObserver);
				
					
					String city1 = txtTrafficInCity1.getText();
					requestObserver.onNext(StringM.newBuilder().setCity1(city1).build());
					
					String city2 = txtTrafficInCity2.getText();
					requestObserver.onNext(StringM.newBuilder().setCity1(city2).build());
					
					String city3 = txtTrafficInCity3.getText();
					requestObserver.onNext(StringM.newBuilder().setCity1(city3).build());
					
					requestObserver.onCompleted();
					
					// Sending client to sleep:
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			
		});	
		
		// Adding button to the panel
		panel_TrafficInCity.add(trafficCityButton);
		
		TrafficInCityResponse = new JTextArea(2, 45);
		TrafficInCityResponse .setLineWrap(true);
		TrafficInCityResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneTraffic = new JScrollPane(TrafficInCityResponse);
		
		panel_TrafficInCity.add(scrollPaneTraffic);
		
		
		// ----------- End of Implementation of rpc Traffic In City ------------------ //
		
		
		
		
		
		// ----------- Implementation of rpc obstacles ------------------ //
		
		
		// Create JPanel:
		
		JPanel panel_obstacles = new JPanel();
		frame.getContentPane().add(panel_obstacles);
		panel_obstacles.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		// New Label for panel_currentTraffic:
		JLabel obstaclesLabel = new JLabel("Obstacles in city: ");
		panel_obstacles.add(obstaclesLabel);
		
		// Input text Boxes:
		JTextField txtObstacles1 = new JTextField();
		JTextField txtObstacles2 = new JTextField();
		JTextField txtObstacles3 = new JTextField();
		
		panel_obstacles.add(txtObstacles1);
		panel_obstacles.add(txtObstacles2);
		panel_obstacles.add(txtObstacles3);
		
		txtObstacles1.setColumns(10);
		txtObstacles2.setColumns(10);
		txtObstacles3.setColumns(10);
		
		// Button to send request:
		JButton ObstaclesCityButton = new JButton("Obstacles 3 streets");
		
		
		// Listening for Input:
		ObstaclesCityButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				StreamObserver<Message> responseObserver = new StreamObserver<Message>() {

					@Override
					public void onNext(Message value) {
						// TODO Auto-generated method stub
						
						// Displaying message in GUI
						ObstaclesResponse.append(value.getStreets());
						
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						
					}};
					
				StreamObserver<Message> requestObserver = ObsasyncStub.obstaclesInRoad(responseObserver);
				
				String city1 = txtObstacles1.getText();
				requestObserver.onNext(Message.newBuilder().setStreets(city1).build());
				
				String city2 = txtObstacles2.getText();
				requestObserver.onNext(Message.newBuilder().setStreets(city2).build());
				
				String city3 = txtObstacles3.getText();
				requestObserver.onNext(Message.newBuilder().setStreets(city3).build());
				
				requestObserver.onCompleted();
				
				// clearing TextArea:
				ObstaclesResponse.setText("");
				
				
				// Sending client to sleep:
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}});
		
		// Adding button to the panel
		panel_obstacles.add(ObstaclesCityButton);
		
		ObstaclesResponse = new JTextArea(2, 45);
		ObstaclesResponse.setLineWrap(true);
		ObstaclesResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneObstacles = new JScrollPane(ObstaclesResponse);
		
		panel_obstacles.add(scrollPaneObstacles);
		
		
		// ----------- End of Implementation of rpc obstacles ------------------ //
		
		
		
		
}}
