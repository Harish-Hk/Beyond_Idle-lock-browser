package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JSpinner;
//import javax.swing.SpinnerNumberModel;
 
public class LoginDialog extends JDialog {
 
 //   private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
//    private JButton btnCancel;
    private boolean succeeded;
	  static public String uname;
	  static String upass;

 
    public LoginDialog(Frame parent) {
        super(parent, "Please login to continue", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        Font font= new Font("SansSerif", Font.BOLD, 15);
        
        lbUsername = new JLabel("Welcome back " +getUsername());
        cs.ipady = 10; 
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 3;
        panel.add(lbUsername, cs);
        lbUsername.setFont(font);
        lbUsername.setHorizontalAlignment(JLabel.CENTER);
        
 
//        tfUsername = new JTextField(20);
//        cs.ipady = 10; 
//        cs.gridx = 1;
//        cs.gridy = 0;
//        cs.gridwidth = 2;
//        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.ipady = 10; 
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);     
 
        pfPassword = new JPasswordField(20);
        cs.ipady = 10;
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
                               
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("Login");
        setSize(300, 600);  

 
        btnLogin.setEnabled(false);
        
        pfPassword.getDocument().addDocumentListener(new DocumentListener() {
  		  public void changedUpdate(DocumentEvent e) {
  		    changed();
  		  }
  		  public void removeUpdate(DocumentEvent e) {
  		    changed();
  		  }
  		  public void insertUpdate(DocumentEvent e) {
  		    changed();
  		  }

  		  public void changed() {
  		     if (pfPassword.getText().equals("")){
  		       btnLogin.setEnabled(false);
  		     }
  		     else {
  		       btnLogin.setEnabled(true);
  		    }

  		  }
  		});
        
        btnLogin.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e) {
                if (authenticate(getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
        //            tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
 
                }
            }
        });     
        
        JPanel bp = new JPanel();
        bp.add(btnLogin);            	
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
	public static boolean signUp(String username, String password) {
		uname = username;
		upass = password;
		return true;
	}
	
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals(uname) && password.equals(upass)) {
            return true;
        }
        return false;
    }

 
    public String getUsername() {
       return uname;
	}
 
    public String getPassword() {
        return upass;
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
}