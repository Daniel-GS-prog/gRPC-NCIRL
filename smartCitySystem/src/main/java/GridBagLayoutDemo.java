import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class GridBagLayoutDemo extends JFrame{
	
	public GridBagLayoutDemo() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		this.setSize(1200,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Smart City");
		this.setLocationRelativeTo(null);
		this.setLayout(layout);
		
		//  // ----------- Implementation of rpc "City in Service" ------------------ //
		JLabel cityInServiceLabel = new JLabel("Check if a city is in the service ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(cityInServiceLabel, gbc);
		
		JTextField textCity = new JTextField();
		textCity.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(textCity, gbc);
		
		JButton submit = new JButton("Check city");
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(submit, gbc);
		
		JTextArea textResponse = new JTextArea(2, 45);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneCity = new JScrollPane(textResponse);
		gbc.gridx = 3;
		gbc.gridy = 0;
		this.add(scrollPaneCity, gbc);
		
		// ----------- end Implementation of rpc "City in Service" ------------------ //
		
		
		// ----------- Implementation of rpc TemperatureInCity ------------------ //
		JLabel label1 = new JLabel("-------------------------");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(label1, gbc);
		
		JLabel temperatureInCityLabel = new JLabel("Check the temperature in a city: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(temperatureInCityLabel, gbc);
		
		JTextField TemptxtCity = new JTextField();
		TemptxtCity.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(TemptxtCity, gbc);
		
		JButton Tempsubmit = new JButton("Check temperature");
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(Tempsubmit, gbc);
		
		JTextArea TemptextResponse = new JTextArea(2, 45);
		TemptextResponse .setLineWrap(true);
		TemptextResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneTempCity = new JScrollPane(TemptextResponse);
		gbc.gridx = 3;
		gbc.gridy = 2;
		this.add(scrollPaneTempCity, gbc);
		
		// ----------- end Implementation of rpc TemperatureInCity ------------------ //
		
		
		// ----------- Implementation of rpc Current Traffic ------------------ //
		
		JLabel label = new JLabel("-------------------------");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(label, gbc);
		
		JLabel trafficInCityCentreLabel = new JLabel("Traffic in center: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(trafficInCityCentreLabel, gbc);
		
		JTextField TrafficTxtCity = new JTextField();
		TrafficTxtCity.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(TrafficTxtCity, gbc);
		
		JButton TrafficSubmit = new JButton("Traffic in center");
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(TrafficSubmit, gbc);
		
		JTextArea TraffictextResponse = new JTextArea(2, 45);
		TraffictextResponse .setLineWrap(true);
		TraffictextResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneTrafficCity = new JScrollPane(TraffictextResponse);
		gbc.gridx = 3;
		gbc.gridy = 4;
		this.add(scrollPaneTrafficCity, gbc);
		
		// ----------- End of Implementation of rpc Current Traffic ------------------ //
		
		
		// ----------- Implementation of rpc Traffic In City ------------------ //
		
		JLabel label2 = new JLabel("-------------------------");
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(label2, gbc);
		
		JLabel trafficInCityLabel = new JLabel("Check traffic in 3 streets: ");
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(trafficInCityLabel, gbc);
		
		
		JLabel trafficInCityLabel1 = new JLabel("First street: ");
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(trafficInCityLabel1, gbc);
		
		JTextField txtTrafficInCity1 = new JTextField();
		txtTrafficInCity1.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.add(txtTrafficInCity1, gbc);
		
		JLabel trafficInCityLabel2 = new JLabel("Second street: ");
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(trafficInCityLabel2, gbc);
		
		JTextField txtTrafficInCity2 = new JTextField();
		txtTrafficInCity2.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 8;
		this.add(txtTrafficInCity2, gbc);
		
		JLabel trafficInCityLabel3 = new JLabel("Third street: ");
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(trafficInCityLabel3, gbc);
		
		JTextField txtTrafficInCity3 = new JTextField();
		txtTrafficInCity3.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 9;
		this.add(txtTrafficInCity3, gbc);
		
		JButton TrafficCitySubmit = new JButton("Traffic in streets");
		gbc.gridx = 2;
		gbc.gridy = 8;
		this.add(TrafficCitySubmit, gbc);
		
		JTextArea TrafficCitytextResponse = new JTextArea(2, 45);
		TrafficCitytextResponse .setLineWrap(true);
		TrafficCitytextResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneTrafficCity1 = new JScrollPane(TrafficCitytextResponse);
		gbc.gridx = 3;
		gbc.gridy = 8;
		this.add(scrollPaneTrafficCity1, gbc);
		
		// ----------- ENd of Implementation of rpc Traffic In City ------------------ //
		
		
		// ----------- Implementation of rpc obstacles ------------------ //
		
		JLabel label3 = new JLabel("-------------------------");
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(label3, gbc);
		
		JLabel obstaclesLabel = new JLabel("Check for obstacles: ");
		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(obstaclesLabel, gbc);
		
		JLabel obstaclesLabel1 = new JLabel("First street: ");
		gbc.gridx = 0;
		gbc.gridy = 12;
		this.add(obstaclesLabel1, gbc);

		JTextField txtObstacles1 = new JTextField();
		txtObstacles1.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 12;
		this.add(txtObstacles1, gbc);
		
		JLabel obstaclesLabel2 = new JLabel("Second street: ");
		gbc.gridx = 0;
		gbc.gridy = 13;
		this.add(obstaclesLabel2, gbc);
		
		JTextField txtObstacles2 = new JTextField();
		txtObstacles2.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 13;
		this.add(txtObstacles2, gbc);
		
		JLabel obstaclesLabel3 = new JLabel("Third street: ");
		gbc.gridx = 0;
		gbc.gridy = 14;
		this.add(obstaclesLabel3, gbc);
		
		JTextField txtObstacles3 = new JTextField();
		txtObstacles3.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 14;
		this.add(txtObstacles3, gbc);
		
		JButton ObstaclesCityButton = new JButton("Traffic in streets");
		gbc.gridx = 2;
		gbc.gridy = 13;
		this.add(ObstaclesCityButton, gbc);
		
		JTextArea ObstaclesResponse = new JTextArea(2, 45);
		ObstaclesResponse .setLineWrap(true);
		ObstaclesResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPaneObstacles = new JScrollPane(ObstaclesResponse);
		gbc.gridx = 3;
		gbc.gridy = 13;
		this.add(scrollPaneObstacles, gbc);
		
//		// ----------- End of Implementation of rpc obstacles ------------------ //
//		
//		
		this.setVisible(true);
		
	}

}
