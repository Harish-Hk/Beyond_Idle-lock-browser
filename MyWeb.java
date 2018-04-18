package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class MyWeb extends JFrame implements WindowFocusListener {
	
	private JPanel contentPane;
	int counter;
    Boolean isIt = false;
    Timer timer;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		
//		int x=(int) screenSize.getWidth();
//		int y=(int) screenSize.getHeight();

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWeb frame = new MyWeb();
				    ImageIcon img = new ImageIcon("C:\\Users\\bhara\\eclipse-workspace\\logo.png");
					frame.setIconImage(img.getImage());
					frame.setTitle("Beyond");
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//frame.setUndecorated(true);
					//frame.setSize(x,y);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		final JFrame frame = new JFrame("Welcome to Beyond");
        SignUp signDlg = new SignUp(frame);
        signDlg.setSize(400, 300);
//        frame.setLayout(new FlowLayout());
        signDlg.setVisible(true);
		
        if(signDlg.isSucceeded()){
            frame.setVisible(false);   		
        } 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public MyWeb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		final JWebBrowser browser= new JWebBrowser();
		browser.navigate("http://www.google.com");
		panel.add(browser, BorderLayout.CENTER);
		addWindowFocusListener(this);

	}

@Override
public void windowGainedFocus(WindowEvent arg0) {
	 timer.cancel();     
}

@Override
public void windowLostFocus(WindowEvent arg0) {
	timer = new Timer(); //new timer
    counter = SignUp.getTime(); //setting the counter to 10 sec
    TimerTask task = new TimerTask() {         
        public void run() {                
            counter --;
            System.out.println(counter);
            if (counter == -1){
                // call lock dialog box
            	final JFrame frame = new JFrame("Login");
                LoginDialog logDlg = new LoginDialog(frame);
                logDlg.setSize(400, 300);
                logDlg.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                logDlg.setVisible(true);
            }
        }
    };
    timer.scheduleAtFixedRate(task, 1000, 1000); // =  timer.scheduleAtFixedRate(task, delay, period);
}

}//GEN-LAST:event_btnStartMouseClicked

