package evoting;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
	
	public class AdminUI {
	 JFrame adminFrame = new JFrame();
	 JPanel adminWelcomePanel = new JPanel();
	 JPanel adminFunPanel = new JPanel();
	 Admin admin = new Admin();
	 boolean endElection;
	
	 //Admin Welcome Panel GUI
	 JLabel adminWelcomePanelLabel = new JLabel("Admin Login.");
	 JLabel adminIDLabel = new JLabel("Enter Admin ID");
	 JLabel adminPassLabel = new JLabel("Enter Admin Password");
	 JTextField adminIDTextBox = new JTextField();
	 //JTextField adminPassTextBox = new JTextField();
	 JButton adminLoginButton = new JButton("LOGIN");
	 JButton homeButton = new JButton("HOME");
	
	
	 //Admin Function Panel GUI
	 JLabel adminFunPanelLabel = new JLabel("Welcome, Admin");
	 JLabel electionStarted = new JLabel("Election Has Started");
	 JButton adminLogoutButton = new JButton("LOGOUT");
	 JButton adminUnofficialTallyButton = new JButton("UNOFFICIAL TALLY");
	 JButton adminOfficialTallyButton = new JButton("OFFICIAL TALLY");
	 JButton endElectionButton = new JButton("END ELECTION AND GET OFFICIAL TALLY");
	 JButton startElectionButton = new JButton("START ELECTION");
	 JButton back = new JButton("BACK");

	 JButton adminRecountButton = new JButton("RECOUNT");
	 JPasswordField passwordField = new JPasswordField(10);
	 
	 VotingDatabase db = new VotingDatabase();
	
	
	
	
	 public AdminUI() {
	
	  adminLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	  adminLogoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	  homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
	  adminWelcomePanel.setLayout(new BoxLayout(adminWelcomePanel, BoxLayout.Y_AXIS));
	  adminWelcomePanel.add(adminWelcomePanelLabel);
	  adminWelcomePanel.add(adminIDLabel);
	  adminWelcomePanel.add(adminIDTextBox);
	  adminWelcomePanel.add(adminPassLabel);
	  adminWelcomePanel.add(passwordField);
	  adminWelcomePanel.add(adminLoginButton);
	  adminWelcomePanel.add(homeButton);
	  adminWelcomePanel.setPreferredSize(new Dimension(1000, 400));
	
	  adminFrame.getContentPane().add(adminWelcomePanel);
	  adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  adminFrame.pack();
	  adminFrame.setVisible(true);
	
	  adminFunPanel.setLayout(new BoxLayout(adminFunPanel, BoxLayout.Y_AXIS));
	  adminFunPanel.add(adminFunPanelLabel);
	  adminFunPanel.add(adminUnofficialTallyButton);
	  adminFunPanel.add(adminOfficialTallyButton);
	  adminFunPanel.add(adminRecountButton);
	  adminFunPanel.add(startElectionButton);
	  adminFunPanel.add(adminLogoutButton);
	  
	  
	
	
	  //***************THE FOLLOWING IS WHERE THE LISTENERS ARE LOCATED*********************\\
	  int maxAdminID= 16;
	  adminIDTextBox.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
	    char c = e.getKeyChar();
	    int a = adminIDTextBox.getText().length();
	    if (a >= maxAdminID) {
	     e.consume();
	    }
	    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
	
	     e.consume();
	    }
	   }
	  });
	
	  int maxAdminPass =16;
	  passwordField.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
	    char c = e.getKeyChar();
	    int a = passwordField.getText().length();
	    if (a >= maxAdminPass) {
	     e.consume();
	    }
	    
	   }
	  });
	
	
	  
	
	  adminLoginButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent o) {
	
	    String adminID = adminIDTextBox.getText();
	    String adminPass = String.valueOf(passwordField.getPassword());
	    VotingServer VS = new VotingServer();
	   
	
	    
	     try {
			if (VS.validateAdminLogin(adminID, adminPass)) {
			  adminWelcomePanel.setVisible(false);
			  adminFunPanel.setVisible(true);
			  adminFrame.getContentPane().add(adminFunPanel);
			 } else {
			  adminIDTextBox.setText("");
			  passwordField.setText("");
			  JOptionPane.showMessageDialog(adminWelcomePanel, "Invalid Login Credentials.");
			 }
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     // TODO Auto-generated catch block
	     // TODO Auto-generated catch block
	    }
	   });
	
	  
	
	
	  homeButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent o) {
	    adminWelcomePanel.setVisible(false);
	    adminIDTextBox.setText("");
	    passwordField.setText("");
	    adminFrame.dispose();
	    VotingDriver GUI = new VotingDriver(); //createAndShowGUI(candidate1,candidate2);
	    GUI.createAndShowGUI();
	
	
	
	   }
	  });
	  
	  
	  adminOfficialTallyButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent o) {
			   //adminFunPanel.setVisible(true);

				 adminFunPanel.removeAll();

				 //JLabel tallyLabel = new JLabel(admin.getOfficialTally());
			 
			  //adminFunPanel.add(tallyLabel);
			  

			  
			  //adminFunPanel.revalidate();
			 // adminFunPanel.repaint();
			  adminFunPanel.add(endElectionButton);
			  adminFunPanel.add(back);
			 // endElection = true;
			  adminFunPanel.revalidate();
			  adminFunPanel.repaint();


		
		   }
		  });  
	  
	  
	  endElectionButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent o) {

			   adminFunPanel.removeAll();

			   JLabel tallyLabel = new JLabel(admin.getOfficialTally());
			
			  adminFunPanel.add(tallyLabel);
			  
			  
			  adminFunPanel.revalidate();
			  adminFunPanel.repaint();		
			  try {
				db.EncryptDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		  });  
	  
	  adminUnofficialTallyButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent o) {

			   adminFunPanel.removeAll();

			   JLabel tallyLabel = new JLabel(admin.getOfficialTally());
			
			  adminFunPanel.add(tallyLabel);
			  
			  adminFunPanel.add(back);
			  adminFunPanel.revalidate();
			  adminFunPanel.repaint();		
		   }
		  }); 
	  
	  
	  adminRecountButton.addActionListener(new ActionListener() {
		   @SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent o) {

			   adminFunPanel.removeAll();
			    @SuppressWarnings("rawtypes")
				DefaultListModel votersList = new DefaultListModel();

			    ArrayList<Voter> voterList = new ArrayList<Voter>();
			    
				   try {
						voterList = db.getList();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			    
			    
			   JList list = new JList(votersList);
			   
			   
			   
			   votersList.addElement("List of voter IDs and their candidate for recounting purposes");
			   votersList.addElement("----------------------------------------------------------------------------");

			   votersList.addElement("VOTER ID   -   CANDIDATE NAME");

			    for (int i = 0; i < voterList.size(); i++) {
			    
			    	
			    	String voterInfo = String.format("%s                 %s",voterList.get(i).getvoterID(),voterList.get(i).getVotedFor());
			    //            //System.out.println(voterList.get(0).getVotedFor());
			   

			    	
			        votersList.addElement(voterInfo);

			    	
			    }
			        
	
			  adminFunPanel.add(list);
			  adminFunPanel.add(back);
			  adminFunPanel.revalidate();
			  adminFunPanel.repaint();		
		   }
		  }); 
	  
	  startElectionButton.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent o){

			  adminFunPanel.removeAll();
			  adminFunPanel.add(electionStarted);
			  electionStarted.setVisible(true);
			  adminFunPanel.add(back);
			  adminFunPanel.revalidate();
			  adminFunPanel.repaint();
			  try {
				db.DecryptDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
		  
		 
		  
	  }
			  
			  );
	
	  adminLogoutButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent o) {
	    adminWelcomePanel.setVisible(true);
	    adminFunPanel.setVisible(false);
	    adminIDTextBox.setText("");
	    passwordField.setText("");
	
	
	   }
	  });
	  adminFunPanel.repaint();

	 
	 
	 
	 back.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent o) {
			   adminFunPanel.removeAll();
			   adminFunPanel.add(adminFunPanelLabel);
			   adminFunPanel.add(adminUnofficialTallyButton);
			   adminFunPanel.add(adminOfficialTallyButton);
			   adminFunPanel.add(adminRecountButton);
			   adminFunPanel.add(startElectionButton);
			   adminFunPanel.add(adminLogoutButton);
			   adminFunPanel.revalidate();
			   adminFunPanel.repaint();
			   
	}
	 });
	 }
	}
