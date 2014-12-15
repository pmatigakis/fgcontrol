

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;

import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.FGControl;
import com.matigakis.fgcontrol.console.ConsoleConnectionException;

public class FlightgearControl extends JFrame{
	private static final long serialVersionUID = 1L;
	
	protected FGControl fgControl;
	
	public FlightgearControl(FGControl fgControl){
		super("Flightgear control example");
		
		this.fgControl = fgControl;
		
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
		fgControl.pause();
	}
	
	private void reset(){
		fgControl.reset();
	}
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		InetSocketAddress address = new InetSocketAddress("localhost", 10503);
		
		final FGControl fgControl = new FGControl(address);
		
		try{
			fgControl.connect();
		}catch(ConsoleConnectionException e){
			JOptionPane.showMessageDialog(null, "Failed to connect to Flightgear's console", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		FlightgearControl app = new FlightgearControl(fgControl);
		
		app.run();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				fgControl.disconnect();
			}
		});
	}
}
