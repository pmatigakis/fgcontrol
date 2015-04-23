

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;

import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.SimulatorControl;
import com.matigakis.fgcontrol.SimulatorControlConnectionException;
import com.matigakis.fgcontrol.console.ConsoleClient;
import com.matigakis.fgcontrol.console.TelnetConsoleClient;
import com.matigakis.fgcontrol.console.ConsoleClientEventListener;

public class SimulatorControlExample extends JFrame{
	private static final long serialVersionUID = 1L;
	
	protected SimulatorControl simulatorControl;
	
	public SimulatorControlExample(SimulatorControl simulatorControl){
		super("Flightgear control example");
		
		this.simulatorControl = simulatorControl;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JButton pauseButton = new JButton("Pause/unpause");

		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pause();
			}
		});
		
		add(pauseButton);
		
		JButton resetButton = new JButton("Reset");
		
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		add(resetButton);
		
		pack();
		setResizable(false);
	}
	
	public void run(){
		setVisible(true);
	}
	
	protected void pause(){
		simulatorControl.pause();
	}
	
	private void reset(){
		simulatorControl.reset();
	}
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		InetSocketAddress address = new InetSocketAddress("localhost", 10503);
		
		ConsoleClient consoleClient = new TelnetConsoleClient(address);
		
		consoleClient.addConsoleClientEventListener(new ConsoleClientEventListener() {
			@Override
			public void disconnectedFromConsole(ConsoleClient consoleClient) {
				System.out.println("Disconnected from flightgear's console");
			}
			
			@Override
			public void connectedToConsole(ConsoleClient consoleClient) {
				System.out.println("Connected to flightgear's console");
			}
		});
		
		final SimulatorControl fgControl = new SimulatorControl(consoleClient);
		
		try{
			fgControl.connect();
		}catch(SimulatorControlConnectionException e){
			JOptionPane.showMessageDialog(null, "Failed to connect to Flightgear's console", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		SimulatorControlExample app = new SimulatorControlExample(fgControl);
		
		app.run();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				fgControl.disconnect();
			}
		});
	}
}
