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
 
public class SignUp extends JDialog {
 
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnSignUp;
    private JButton btnCancel;
    private boolean succeeded;
    
    private static JNumberTextField Time;
    private JLabel lbTime;
   // private JLabel sec;

 
    public SignUp(Frame parent) {
        super(parent, "Welcome to Beyond", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        lbUsername = new JLabel("Username: ");
        cs.ipady = 10; 
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.ipady = 10; 
        cs.gridx = 2;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.ipady = 10; 
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.ipady = 10;
        cs.gridx = 2;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        
        lbTime = new JLabel("Time(in sec): ");
        cs.ipady = 10; 
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panel.add(lbTime, cs);
        
        /*Time = new SpinnerNumberModel(0, 0, 30, 1);
        JSpinner spinner = new JSpinner(Time);
        JOptionPane.showMessageDialog(null, spinner);*/
        
        Time = new JNumberTextField();
        cs.ipady = 10; 
        cs.gridx = 2;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panel.add(Time, cs);
        
//        lbTime = new JLabel("sec ");
//        cs.ipady = 10; 
//        cs.gridx = 2;
//        cs.gridy = 3;
//        cs.gridwidth = 1;
//        panel.add(lbTime, cs);
                
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnSignUp = new JButton("SignUp");
 
        btnSignUp.setEnabled(false);
        
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
  		       btnSignUp.setEnabled(false);
  		     }
  		     else {
  		       btnSignUp.setEnabled(true);
  		    }

  		  }
  		});


        btnSignUp.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	                
            	LoginDialog.signUp(getUsername(), getPassword());
                EventQueue.invokeLater(new Runnable() {
        			 public void run() {
        				try {
        					parent.setVisible(false);
//                			MyWeb frame = new MyWeb();
//        					frame.setVisible(true);
//        					JOptionPane.showMessageDialog(frame,
//                                    "\nCurrent value:" +
//                                    		tfUsername.getText().trim() +
//                                    "\nPrevious value:" +
//                                    new String(pfPassword.getPassword()) +
//                                    "\nNext value:" +
//                                    new String(Time.getText())
//                                    );
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			 }
        		   });
            } 
        });
        btnCancel = new JButton("No Thanks");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					parent.setVisible(false);
//                			MyWeb frame = new MyWeb();
//        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
                
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnSignUp);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public static int getTime() {
    	int time=Integer.parseInt(Time.getText());
        return time;
    }
    
    public boolean isSucceeded() {
        return succeeded;
    }
}