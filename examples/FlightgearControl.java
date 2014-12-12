

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;

import org.apache.log4j.BasicConfigurator;

import com.matigakis.fgcontrol.FGControl;

public class FlightgearControl extends JFrame{
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
		
		setVisible(true);
	}
	
	protected void pause(){
		fgControl.pause();
	}
	
	private void reset(){
		fgControl.reset();
	}
	
	public static void main(String[] args) throws Exception{
		BasicConfigurator.configure();
		
		InetSocketAddress address = new InetSocketAddress("localhost", 10503);
		
		final FGControl fgControl = new FGControl(address);
		
		fgControl.connect();
		
		FlightgearControl app = new FlightgearControl(fgControl);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				fgControl.disconnect();
			}
		});
	}
}
