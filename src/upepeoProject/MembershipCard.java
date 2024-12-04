/* J17/0811/2019
 * KUNGU DANIEL KARONGO
 * MAY 2021
 */

package upepeoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MembershipCard {

	private JFrame frame;
	private JTextField txtMemberMembershipNo;
	private JLabel lblMemberFullName;
	private static JTextField txtMemberNameCard;
	private static JTextField txtIdNumberCard;
	private static JTextField txtEmailAddressCard;
	private static JTextField txtPhoneNumberCard;
	private static JTextField txtMemberResidentialAddressCard;
	private static JTextField txtMemberOccupationCard;
	private static JTextField txtMemberDateofJoiningCard;
	private static JTextField txtMemberPasswordCard;
	
	private JLabel lblMembershipCard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembershipCard window = new MembershipCard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MembershipCard() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		
		// To trigger the population of the membership card through data from the "UpepeoFinal" class. 
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				// To determine the system view that is carrying out the addition of the member.  
				String systemView = UpepeoFinal.systemView;
				
				// To store the various details that go into the membership Card. 
				String f_name = null;
				String l_name = null;
				String phoneNumber = null;
				String Email = null;
				String idNumber = null;
				String job = null;
				String place = null;
				Date dateofjoining = null;
				String membId = null;
				
				// When the member addition is by the user's view of the system.
				if(systemView.equals("User")) {
					
					// To get the necessary details from the user's input in the "UpepeoFinal" class.
					f_name = (UpepeoFinal.firstname.getText()).toUpperCase();
					l_name = (UpepeoFinal.lastname.getText()).toUpperCase();
					phoneNumber = (UpepeoFinal.phonenumber.getText()).toUpperCase();
					Email = UpepeoFinal.email.getText();
					idNumber = (UpepeoFinal.id.getText()).toUpperCase();
					job = (UpepeoFinal.occupation.getText()).toUpperCase();
					place = (UpepeoFinal.residential.getText()).toUpperCase();
					dateofjoining = UpepeoFinal.joiningdate.getDate();
					
					// SQL Code to obtain the member Id from the database then populate it on the membership card. 
					try {
						Connection conn = DriverManager.getConnection(UpepeoFinal.databaseURL);
						String query = "SELECT Membership_ID FROM Members WHERE Email_Address = '"+Email+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						while(rs1.next()) {
							membId = rs1.getString("Membership_ID");
						}
						
						// To convert the date obtained from the JDateChooser into a string.
						DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");  
				        String strDate = dateFormat.format(dateofjoining);
						
				        // To convert the password obtained from the JDateChooser into a string.
						char[] password = null;
						password = UpepeoFinal.confirmpass.getPassword();
						String passfinal = new String(password);
						
						// If the value of the membership Id of the member is greater than or equal to zero, assign "M0" as a prefix to it to get, say "M010".
						if((Integer.parseInt(membId)) >= 10) {
							
							// Set the text of the field meant to hold the membership Id to "M0" + (the value of the membership Id).
							txtMemberMembershipNo.setText("M0" + membId);
							
							/* Add the text "M0" + (the value of the membership Id) above to the Members' JComboBox
							 * on the Individual Expenses panel in the administrators view of the system.
							 */
							UpepeoFinal.IEMemberCombobox.addItem("M0" + membId);
							
							// Set the text of the hidden "Member Id" text boxes on the different movie genre panels to that of the value of the new member's membeship Id.
							UpepeoFinal.lblComedyMemberID.setText(membId);
							UpepeoFinal.lblGeneralMemberID.setText(membId);
							UpepeoFinal.lblHorrorMemberID.setText(membId);
							UpepeoFinal.lblThrillerMemberID.setText(membId);
							UpepeoFinal.lblCartoonMemberID.setText(membId);
							UpepeoFinal.lblUserMovieSearchMemberID.setText(membId);
						} 
						
						// If the value of the membership Id of the member is less than zero, assign "M00" as a prefix to it to get, say "M007".
						else {
							
							// Set the text of the field meant to hold the membership Id to "M0" + (the value of the membership Id).
							txtMemberMembershipNo.setText("M00" + membId);
							
							/* Add the text "M00" + (the value of the membership Id) above to the Members' JComboBox
							 * on the Individual Expenses panel in the administrators view of the system.
							 */
							UpepeoFinal.IEMemberCombobox.addItem("M00" + membId);
							
							// Set the text of the hidden "Member Id" text boxes on the different movie genre panels to that of the value of the new member's membeship Id.
							UpepeoFinal.lblComedyMemberID.setText(membId);
							UpepeoFinal.lblGeneralMemberID.setText(membId);
							UpepeoFinal.lblHorrorMemberID.setText(membId);
							UpepeoFinal.lblThrillerMemberID.setText(membId);
							UpepeoFinal.lblCartoonMemberID.setText(membId);
							UpepeoFinal.lblUserMovieSearchMemberID.setText(membId);
						}
						
						// Populate the other fields in the membership Card with provided details.
						txtMemberNameCard.setText(f_name + " " + l_name);
						txtIdNumberCard.setText(idNumber);
						txtEmailAddressCard.setText(Email);
						txtPhoneNumberCard.setText(phoneNumber);
						txtMemberResidentialAddressCard.setText(place);
						txtMemberOccupationCard.setText(job);
						txtMemberDateofJoiningCard.setText(strDate);
						txtMemberPasswordCard.setText(passfinal);
						
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				// When the member addition is by the user's view of the system.
				else {
					f_name = (UpepeoFinal.txtFirstNameAddMember.getText()).toUpperCase();
					l_name = (UpepeoFinal.txtLastNameAddMember.getText()).toUpperCase();
					phoneNumber = (UpepeoFinal.txtPhoneNumberAddMember.getText()).toUpperCase();
					Email = UpepeoFinal.txtEmailAddressAddMember.getText();
					idNumber = (UpepeoFinal.txtIDNumberAddMember.getText()).toUpperCase();
					job = (UpepeoFinal.txtOccupationAddMember.getText()).toUpperCase();
					place = (UpepeoFinal.txtResidentialAddressAddMember.getText()).toUpperCase();
					dateofjoining = UpepeoFinal.dateChooserDateofJoiningAddMember.getDate();
					
					// SQL Code to obtain the member Id from the database then populate it on the membership card.
					try {
						
						Connection conn = DriverManager.getConnection(UpepeoFinal.databaseURL);
						String query = "SELECT Membership_ID FROM Members WHERE Email_Address = '"+Email+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						while(rs1.next()) {
							membId = rs1.getString("Membership_ID");
							
							// To convert the date obtained from the JDateChooser into a string.
							DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");  
					        String strDate = dateFormat.format(dateofjoining);
							
							String password = UpepeoFinal.txtPasswordAddMember.getText();
							
							// If the value of the membership Id of the member is greater than or equal to zero, assign "M0" as a prefix to it to get, say "M010".
							if((Integer.parseInt(membId)) >= 10) {
								// Set the text of the field meant to hold the membership Id to "M0" + (the value of the membership Id).
								txtMemberMembershipNo.setText("M0" + membId);
								
								/* Add the text "M0" + (the value of the membership Id) above to the Members' JComboBox
								 * on the Individual Expenses panel in the administrators view of the system.
								 */
								UpepeoFinal.IEMemberCombobox.addItem("M0" + membId);
							} 
							
							// If the value of the membership Id of the member is less than zero, assign "M00" as a prefix to it to get, say "M007".
							else {
								
								// Set the text of the field meant to hold the membership Id to "M00" + (the value of the membership Id).
								txtMemberMembershipNo.setText("M00" + membId);
								
								/* Add the text "M00" + (the value of the membership Id) above to the Members' JComboBox
								 * on the Individual Expenses panel in the administrators view of the system.
								 */
								UpepeoFinal.IEMemberCombobox.addItem("M00" + membId);
							}
							
							// Populate the other fields in the membership Card with provided details.
							txtMemberNameCard.setText(f_name + " " + l_name);
							txtIdNumberCard.setText(idNumber);
							txtEmailAddressCard.setText(Email);
							txtPhoneNumberCard.setText(phoneNumber);
							txtMemberResidentialAddressCard.setText(place);
							txtMemberOccupationCard.setText(job);
							txtMemberDateofJoiningCard.setText(strDate);
							txtMemberPasswordCard.setText(password);
						}
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		frame.setBounds(100, 100, 622, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMembershipNo = new JLabel("Membership No:");
		lblMembershipNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembershipNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMembershipNo.setBounds(10, 43, 586, 21);
		frame.getContentPane().add(lblMembershipNo);
		
		txtMemberMembershipNo = new JTextField();
		txtMemberMembershipNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtMemberMembershipNo.setForeground(new Color(139, 0, 0));
		txtMemberMembershipNo.setBackground(Color.WHITE);
		txtMemberMembershipNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMemberMembershipNo.setEditable(false);
		txtMemberMembershipNo.setBounds(262, 65, 83, 21);
		frame.getContentPane().add(txtMemberMembershipNo);
		txtMemberMembershipNo.setColumns(10);
		
		lblMemberFullName = new JLabel("Full Name:");
		lblMemberFullName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberFullName.setBounds(20, 97, 91, 21);
		frame.getContentPane().add(lblMemberFullName);
		
		JLabel lblMemberIdNumber = new JLabel("ID Number:");
		lblMemberIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberIdNumber.setBounds(20, 129, 91, 21);
		frame.getContentPane().add(lblMemberIdNumber);
		
		JLabel lblMemberEmailAddress = new JLabel("Email Address:");
		lblMemberEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberEmailAddress.setBounds(20, 161, 91, 21);
		frame.getContentPane().add(lblMemberEmailAddress);
		
		JLabel lblMemberPhoneNumber = new JLabel("Phone Number:");
		lblMemberPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberPhoneNumber.setBounds(20, 193, 91, 21);
		frame.getContentPane().add(lblMemberPhoneNumber);
		
		txtMemberNameCard = new JTextField();
		txtMemberNameCard.setForeground(new Color(139, 0, 0));
		txtMemberNameCard.setBackground(Color.WHITE);
		txtMemberNameCard.setEditable(false);
		txtMemberNameCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMemberNameCard.setBounds(112, 97, 168, 22);
		frame.getContentPane().add(txtMemberNameCard);
		txtMemberNameCard.setColumns(10);
		
		txtIdNumberCard = new JTextField();
		txtIdNumberCard.setForeground(new Color(139, 0, 0));
		txtIdNumberCard.setBackground(Color.WHITE);
		txtIdNumberCard.setEditable(false);
		txtIdNumberCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIdNumberCard.setColumns(10);
		txtIdNumberCard.setBounds(112, 129, 168, 21);
		frame.getContentPane().add(txtIdNumberCard);
		
		txtEmailAddressCard = new JTextField();
		txtEmailAddressCard.setForeground(new Color(139, 0, 0));
		txtEmailAddressCard.setBackground(Color.WHITE);
		txtEmailAddressCard.setEditable(false);
		txtEmailAddressCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmailAddressCard.setColumns(10);
		txtEmailAddressCard.setBounds(112, 161, 168, 21);
		frame.getContentPane().add(txtEmailAddressCard);
		
		txtPhoneNumberCard = new JTextField();
		txtPhoneNumberCard.setForeground(new Color(139, 0, 0));
		txtPhoneNumberCard.setBackground(Color.WHITE);
		txtPhoneNumberCard.setEditable(false);
		txtPhoneNumberCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhoneNumberCard.setColumns(10);
		txtPhoneNumberCard.setBounds(112, 193, 168, 21);
		frame.getContentPane().add(txtPhoneNumberCard);
		
		JLabel lblMemberResidentialAddress = new JLabel("Residential Address:");
		lblMemberResidentialAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberResidentialAddress.setBounds(298, 97, 118, 21);
		frame.getContentPane().add(lblMemberResidentialAddress);
		
		txtMemberResidentialAddressCard = new JTextField();
		txtMemberResidentialAddressCard.setForeground(new Color(139, 0, 0));
		txtMemberResidentialAddressCard.setBackground(Color.WHITE);
		txtMemberResidentialAddressCard.setEditable(false);
		txtMemberResidentialAddressCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMemberResidentialAddressCard.setColumns(10);
		txtMemberResidentialAddressCard.setBounds(417, 97, 168, 22);
		frame.getContentPane().add(txtMemberResidentialAddressCard);
		
		JLabel lblMemberOccupationCard = new JLabel("Occupation:");
		lblMemberOccupationCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberOccupationCard.setBounds(298, 129, 118, 21);
		frame.getContentPane().add(lblMemberOccupationCard);
		
		txtMemberOccupationCard = new JTextField();
		txtMemberOccupationCard.setForeground(new Color(139, 0, 0));
		txtMemberOccupationCard.setBackground(Color.WHITE);
		txtMemberOccupationCard.setEditable(false);
		txtMemberOccupationCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMemberOccupationCard.setColumns(10);
		txtMemberOccupationCard.setBounds(417, 129, 168, 21);
		frame.getContentPane().add(txtMemberOccupationCard);
		
		txtMemberDateofJoiningCard = new JTextField();
		txtMemberDateofJoiningCard.setForeground(new Color(139, 0, 0));
		txtMemberDateofJoiningCard.setBackground(Color.WHITE);
		txtMemberDateofJoiningCard.setEditable(false);
		txtMemberDateofJoiningCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMemberDateofJoiningCard.setColumns(10);
		txtMemberDateofJoiningCard.setBounds(417, 161, 168, 21);
		frame.getContentPane().add(txtMemberDateofJoiningCard);
		
		JLabel lblMemberDateofJoiningCard = new JLabel("Date of Joining:");
		lblMemberDateofJoiningCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberDateofJoiningCard.setBounds(298, 161, 118, 21);
		frame.getContentPane().add(lblMemberDateofJoiningCard);
		
		JLabel lblMemberPasswordCard = new JLabel("Password:");
		lblMemberPasswordCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberPasswordCard.setBounds(298, 193, 118, 21);
		frame.getContentPane().add(lblMemberPasswordCard);
		
		txtMemberPasswordCard = new JTextField();
		txtMemberPasswordCard.setForeground(new Color(139, 0, 0));
		txtMemberPasswordCard.setBackground(Color.WHITE);
		txtMemberPasswordCard.setEditable(false);
		txtMemberPasswordCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMemberPasswordCard.setColumns(10);
		txtMemberPasswordCard.setBounds(417, 193, 168, 21);
		frame.getContentPane().add(txtMemberPasswordCard);
		
		JButton btnMemberConfirmCard = new JButton("Confirm");
		btnMemberConfirmCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// To determine the system view that is carrying out the addition of the member.
				String appView = UpepeoFinal.systemView;
				
				// When the member addition is by the user's view of the system.
				if(appView.equals("User")) {
					
					// Instructions to the new member concerning the well-keeping os the membership card.
					JOptionPane.showMessageDialog(null, "This is your Membership Card.\nPlease take good care of it");
					
					// To display the siteHome after a successful signing up 
					UpepeoFinal.TermsAndConditions.setVisible(false);
					UpepeoFinal.SiteHome.setVisible(true);	
					
					// To close the frame containing the membership card.
					frame.dispose();
					
				} 
				
				// When the member addition is by the administrator's view of the system.
				else {
					
					JOptionPane.showMessageDialog(null, "Give this card to the customer");
					
					// To close the frame containing the membership card.
					frame.dispose();
					
				}
			}

			});
		btnMemberConfirmCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMemberConfirmCard.setBounds(189, 237, 108, 23);
		frame.getContentPane().add(btnMemberConfirmCard);
		
		JButton btnMembersEditDetailsCard = new JButton("Edit Details");
		btnMembersEditDetailsCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMemberNameCard.setEditable(true);
				txtIdNumberCard.setEditable(true);
				txtEmailAddressCard.setEditable(true);
				txtPhoneNumberCard.setEditable(true);
				txtMemberResidentialAddressCard.setEditable(true);
				txtMemberOccupationCard.setEditable(true);
				txtMemberDateofJoiningCard.setEditable(true);
				txtMemberPasswordCard.setEditable(true);
			}
		});
		btnMembersEditDetailsCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMembersEditDetailsCard.setBounds(310, 237, 108, 23);
		frame.getContentPane().add(btnMembersEditDetailsCard);
		
		lblMembershipCard = new JLabel("Membership Card");
		lblMembershipCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembershipCard.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMembershipCard.setBounds(10, 11, 586, 21);
		frame.getContentPane().add(lblMembershipCard);
	}
}
