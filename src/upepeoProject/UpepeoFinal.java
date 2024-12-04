/*	J17/0811/2019
 * 	KUNGU DANIEL KARONGO
 * 	MAY 2021
 */

package upepeoProject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import net.proteanit.sql.DbUtils;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UpepeoFinal {

	private JFrame frmUpepeoVideoLending;
	private JTextField useremail;
	private JPasswordField userpass;
	private JTextField adminid;
	private JPasswordField adminpass;
	
	// A Collection of the objects that are to be accessed by the "MembershipCard" class.
	protected static JTextField firstname;
	protected static JTextField lastname;
	protected static JTextField phonenumber;
	protected static JTextField email;
	protected static JTextField id;
	protected static JTextField residential;
	protected static JTextField occupation;
	protected static JPanel TermsAndConditions;
	protected static JPanel SiteHome;
	protected static JPasswordField confirmpass;
	protected static JDateChooser joiningdate;
	protected static JComboBox<String> comboGender;
	protected static JTextField txtFirstNameAddMember;
	protected static JTextField txtEmailAddressAddMember;
	protected static JTextField txtIDNumberAddMember;
	protected static JTextField txtLastNameAddMember;
	protected static JTextField txtOccupationAddMember;
	protected static JTextField txtPhoneNumberAddMember;
	protected static JTextField txtResidentialAddressAddMember;
	protected static JDateChooser dateChooserDateofJoiningAddMember;
	protected static JTextField txtPasswordAddMember;
	protected static String systemView = null;
	protected static JLabel lblComedyMemberID;
	protected static JLabel lblGeneralMemberID;
	protected static JLabel lblHorrorMemberID;
	protected static JLabel lblThrillerMemberID;
	protected static JLabel lblCartoonMemberID;
	protected static JLabel lblUserMovieSearchMemberID;
	
	// The jdbc driver instantiation + (the file path of the new database file created).
	protected static String databaseURL = "jdbc:ucanaccess://" + dbExtractor();
	final protected static JComboBox<String> IEMemberCombobox = new JComboBox<String>();
	
	private JPasswordField pass;
	private JTextField txtSiteHomeSearch;
	private JTextField txtGENERAL_SEARCH;
	private JTextField txtHORROR_SEARCH;
	private JTextField txtTHRILLER_SEARCH;
	private JTextField txtCARTOON_SEARCH;
	private JTable ComedyTable;
	private JTable GeneralTable;
	private JTable HorrorTable;
	private JTable ThrillerTable;
	private JTable CartoonTable;
	private JLabel lblErrors;
	private JTable AdminMovieCatalog;
	private JTable MembersTable;
	private JTextField txtMovieName;
	private JTextField txtProductionCompany;
	private JTextField txtReleaseYear;
	private JTextField txtRating;
	private JTextField txtStock;
	private JTextField txtMovieID;
	private JTextField txtMovieName2;
	private JComboBox<String> MovieGenre2;
	private JButton btnDeleteMovie2;
	private JButton btnClear3;
	private JButton btnBackDeleteMovie;
	private JLabel lblGenre2;
	private JLabel lblGenre1;
	private JLabel lblMovieID;
	private JLabel lblMovieName2;
	private JButton btnAddMovie2;
	private JButton btnClear2;
	private JButton btnBackMovieAdder;
	private JComboBox<String> MovieGenre1;
	private JLabel lblStock;
	private JLabel lblRating;
	private JLabel lblReleaseYear;
	private JLabel lblProductionCompany;
	private JLabel lblMovieName;
	private JLabel lblAddMovie;
	private JLabel lblDeleteMovie;
	private JTextField txtMovieIDComedy;
	private JTextField txtMovieNameComedy;
	private JTextField txtMovieIDHorror;
	private JTextField txtMovieNameHorror;
	private JTextField txtMovieIDThriller;
	private JTextField txtMovieNameThriller;
	private JTextField txtMovieNameCartoon;
	private JLabel lblMovieCatalog;
	private JTable BorrowedMoviesTable;
	private JTextField BorrowedMovieMovieIDtxt;
	private JTextField BorrowedMovieMovieNametxt;
	private JTextField BorrowedMovieLentTotxt;
	private JTextField BorrowedMovieDaysOverduetxt;
	private JTextField OverdueMovieMovieIDtxt;
	private JTextField OverdueMovieDaysOverduetxt;
	private JTextField OverdueMovieChargetxt;
	private JTextField OverdueMovieLentTotxt;
	private JTextField OverdueMovieMovieNametxt;
	private JTable OverDueMoviesTable;
	private JTextField DamagedMovieMovieIDtxt;
	private JTextField DamagedMovieMovieNametxt;
	private JTextField DamagedMovieLentTotxt;
	private JTextField DamagedMovieChargetxt;
	private JTable DamagedMoviesTable;
	private JPanel MembersTablePanel;
	private JScrollPane MembersTablescrollPane;
	private JTextField txtMemberIDRemoveMember;
	private JTextField txtMemberEmailAddressRemoveMember;
	private JPanel RemoveMember;
	private JPanel AddorRemoveMember;
	private JPanel AddMember;
	private JButton btnShowMembers;
	private JButton btnAddorRemoveMember;
	private JTable searchMovieTable;
	private JTextField txtMovieIDsearchMoviePanel;
	private JTextField txtMovieNamesearchMoviePanel;
	private JPanel UserMovieSearch;
	private JLabel lblSearchMovie;
	private JPanel Horror;
	private JPanel Thriller;
	private JPanel Cartoon;
	private JDateChooser BorrowComedydateChooser;
	private JTextField txtMovieNameGeneral;
	private JDateChooser BorrowGeneraldateChooser;
	private JTextField txtMovieIDGeneral;
	private JDateChooser BorrowHorrordateChooser;
	private JDateChooser BorrowThrillerdateChooser;
	private JDateChooser BorrowCartoondateChooser;
	private JTextField txtMovieIDCartoon;
	private JTextField txtMovieIDAddMovie;
	private JLabel lblErrorsDeleteMovie;
	private JLabel lblErrorsAddMovie;
	private JDateChooser txtBorrowingDatesearchMoviePaneldateChooser;
	private JLabel lblErrorsUserMovieSearch;
	private JLabel lblErrorsComedyBorrowMovie;
	private JLabel lblErrorsGeneralBorrowMovie;
	private JLabel lblErrorsHorrorBorrowMovie;
	private JLabel lblErrorsThrillerBorrowMovie;
	private JLabel lblErrorsCartoonBorrowMovie;
	private JComboBox<String> comboBoxGenderAddMember;
	private JLabel lblErrorsAddMember;
	private JLabel lblErrorsRemoveMember;
	private JTextField txtCharge;
	private JLabel lblErrorsBorrowedMoviesPanel;
	private JLabel lblOverdueMoviesErrors;
	private JLabel DamagedMoviesErrorslbl;
	private JTextField txtStockGeneralTable;
	private JTextField txtStockComedyTable;
	private JTextField txtStockHorrorTable;
	private JTextField txtStockThrillerTable;
	private JTextField txtStockCartoonTable;
	private JTextField txtStockEntireCatalog;
	private JLabel BorrowedMovieDateBorrowedlbl;
	private JComboBox<String> BorrowedMovieOverduecomboBox;
	private JLabel BorrowedMovieDaysOverduelbl;
	private JLabel BorrowedMovieConditionlbl;
	private JComboBox<String> BorrowedMovieConditioncomboBox;
	private JTable IETable;
	private JLabel IECategorylbl;
	private JLabel IEConditionlbl;
	private JLabel IECategoryTitlelbl;
	private JLabel lblMovieIDAddMovie;
	private JTextField IncomeandAllocationsTotalIncometxt;
	private JTextField IncomeandAllocationsSalariestxt;
	private JTextField IncomeandAllocationsClubDevelopmenttxt;
	private JTextField IncomeandAllocationsAdministrationtxt;
	private JTextField IncomeandAllocationsMiscellaneoustxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpepeoFinal window = new UpepeoFinal();
					window.frmUpepeoVideoLending.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public UpepeoFinal() {

		initialize();
	}
	
	//Code to create a new database file from the original. The new database file is what is read from and written to. 
	public static String dbExtractor() {
		
		// Directory of the folder that will hold the new database file.
		String newDirectory = "db//";
		
		// Folder that will hold the new database file.
		File f = new File(newDirectory);
		if(!f.exists()) {
			f.mkdir();
		}
		
		// The name of the new file.
		String newDbName = "UpepeoVideoLendingClub.accdb";
		
		// File path of the new database file.
		String newDbFile = newDirectory + "/" + newDbName;
		
		// The new database file.
		File f2 = new File(newDbFile);
		if(!f2.exists()) {
			InputStream iStream = UpepeoFinal.class.getResourceAsStream("Folder/" + newDbName);
			try {
				Files.copy(iStream, f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		// To return the file path of new database file.
		return newDbFile;
	}
	
	// Code for the Clear Button on the Create Account Page.
	public void clearAll() {
		firstname.setText(null);
		lastname.setText(null);
		phonenumber.setText(null);
		email.setText(null);
		id.setText(null);
		occupation.setText(null);
		residential.setText(null);
		joiningdate.setDate(null);
		pass.setText(null);
		confirmpass.setText(null);
		comboGender.setSelectedItem(null);
	}
	
	// Code to display all the records into a specific table and from the database.
	public void btnDatabaseViewer(JTable x, String tablefrom) {

		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			String query = "SELECT * FROM "+tablefrom+"";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs1 = pst.executeQuery();
			x.setModel(DbUtils.resultSetToTableModel(rs1));
			conn.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	// Code to display specific records into a specific table and from the database.
	public void dbTableViewerwithCondition(JTable x, String tablefrom, String field, String clause) {
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			String query = "SELECT * FROM "+tablefrom+" WHERE "+field+" = '"+clause+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs1 = pst.executeQuery();
			x.setModel(DbUtils.resultSetToTableModel(rs1));
			conn.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	// Code for the mouse colour change when the mouse pointer is hovered over each label. 
	public void mouseColour(JLabel x){
		x.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				x.setForeground(Color.BLUE);
			}
			public void mouseExited(MouseEvent e) {
				x.setForeground(Color.BLACK);
			}
		});
	}	
	
	// Code to validate the passwords typed in the "password" and "confirm password" password fields.
	public boolean passwordChecker(JPasswordField x, JPasswordField y) {
		boolean same = false;
		char[] a = x.getPassword();
		char[] b = y.getPassword();
		if(Arrays.equals(a, b)) {
			same = true;
		} else {
			same = false;
		}
		return same;
	}
	
	
	// Code to set a limit to the number of characters that can be inputed into a text field or password field.
	@SuppressWarnings("serial")
	class JTextFieldLimit extends PlainDocument{
		
		private int limit;
		
		public JTextFieldLimit(int limitation) {
			this.limit = limitation;
		}
		public void insertString(int offset, String str, AttributeSet set) throws BadLocationException{
			if(str == null)
				return;
			else if((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, set);
			}
		}
	}
	
	// Code to insert a new member into the "Members" table in the database. For both the user's and the administrator's view.
	public void insertIntoMembers(String email, String idNumber, String firstName, String lastName, String phoneNumber, String occupation, String place, String password, String gender, JDateChooser x, JLabel y, String view) {
		
		// To differentiate the views.
		systemView = view;
		
		// To ensure that all the necessary details are provided.
		if((email.isBlank() == false) && (idNumber.isBlank() == false) && (firstName.isBlank() == false) && (lastName.isBlank() == false)
			&& (phoneNumber.isBlank() == false) && (occupation.isBlank() == false) && (place.isBlank() == false) 
			&&(password.isBlank() == false) && (gender != null)) {
			
			// To clear the Jlabel meant to warn the user in the event of errors. 
			y.setText("");
			
			if((x.getDate()) != null) {
				
				y.setText("");
				
				// To convert the date capture into a String so that it can be added to the database.
				Date z = x.getDate();
				DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");  
	            String strDate = dateFormat.format(z);
	            
	            try {
	    			Connection conn = DriverManager.getConnection(databaseURL);
	    			String query = "INSERT INTO Members (Email_Address, ID_Number, First_Name, Last_Name, Phone_Number, Occupation,"
	    											 + " Residential_Address, Password, Gender, DateofJoining) "
	    						 + "VALUES ('"+email+"', '"+idNumber+"', '"+firstName+"', '"+lastName+"', '"+phoneNumber+"', '"+occupation+"', "
	    						 		 + "'"+place+"', '"+password+"', '"+gender+"', '"+strDate+"')";
	    			PreparedStatement pst = conn.prepareStatement(query);
	    			pst.executeUpdate();
	    			
	    			// In the event of a successful member addition.
	    			JOptionPane.showMessageDialog(null, "Member Added");
	    			MembershipCard.main(null);
	    			pst.close();
	    			conn.close();
	    		} catch (SQLException e1) {
	    			
	    			// In the event of an error in member addition.
	    			JOptionPane.showMessageDialog(null, "Account not Created. Please re-enter the credentials");
	    		}
				
			} else {
				// In the event the date is not chosen or some other invalid text has been written in the JDateChooser.
				y.setText("Please select a date from the date chooser");
			}
		
		} else {
			// In the event that some required data has not been given.	
			y.setText("Please fill in all the details");
		}	
		
	}
	
	// Code to insert a borrowed into the "Borrowed_Movies" table in the database.
	public void insertToBorrowedMovies(int charge, int stock4, int lentTo, String movieId, String moviename, Date borrowingdate, JPanel x, JTextField q, JTextField w, JDateChooser e, JLabel r, String table1) {
		
		// To store the number of borrowed movies for the members.
		int currentMovies;
		
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			
			// SQL codes to obtain the sums of all the charges for the specific member.
			String query1 = "SELECT sum(Charge) AS Total_Charge FROM Borrowed_Movies WHERE Lent_To = '"+lentTo+"'";
			String query2 = "SELECT sum(Charge) AS Total_Charge FROM Overdue_Movies WHERE Lent_To = '"+lentTo+"'";
			String query3 = "SELECT sum(Charge) AS Total_Charge FROM Damaged_Movies WHERE Lent_To = '"+lentTo+"'";
			
			PreparedStatement pst1 = conn.prepareStatement(query1);
			PreparedStatement pst2 = conn.prepareStatement(query2);
			PreparedStatement pst3 = conn.prepareStatement(query3);
			
			
			ResultSet rs1 = pst1.executeQuery();
			ResultSet rs2 = pst2.executeQuery();
			ResultSet rs3 = pst3.executeQuery();
			
			while(rs1.next()) {
				
				// To store the charge that is as a result of simply borrowing movies.
				String borrowedMoviesCharge = rs1.getString("Total_Charge");
				int borrowedMoviesTotalCharge = (borrowedMoviesCharge != null) ? Integer.parseInt(borrowedMoviesCharge) : 0;
				
				while(rs2.next()) {
					
					// To store the charge that is as a result of having overdue movies.
					String overdueMoviesCharge = rs2.getString("Total_Charge");
					int overdueMoviesTotalCharge = (overdueMoviesCharge != null) ? Integer.parseInt(overdueMoviesCharge) : 0;
					
					while(rs3.next()) {
						
						// To store the charge that is as a result of damaging movies.
						String damagedMoviesCharge = rs3.getString("Total_Charge");
						int damagedMoviesTotalCharge = (damagedMoviesCharge != null) ? Integer.parseInt(damagedMoviesCharge) : 0;
						
						// The total charge for the member.
						int totalBill = borrowedMoviesTotalCharge + overdueMoviesTotalCharge + damagedMoviesTotalCharge;
						
						// To ensure that all neccessary details have been given.
						if((movieId.isBlank() == false) && (moviename.isBlank() == false) && (borrowingdate != null) && (stock4 != 0)) {
			            	
							// To clear the JLabel that directs the user in the event of an error.
			            	r.setText("");
			            	
			            	try {
								
			            		// SQL code to find the number of movies that heve been issued to the member.
								String query4 = "SELECT count(*) AS Times FROM Borrowed_Movies WHERE Lent_To = "+lentTo+"";
								PreparedStatement pst4 = conn.prepareStatement(query4);
								ResultSet rs4 = pst4.executeQuery();
								while(rs4.next()) {
									
									// To store the number of borrowed movies for the members.
									currentMovies = Integer.parseInt(String.valueOf(rs4.getString("Times")));
									
									// To determine whether the member's debt is too large to borrow another movie.   
									if(totalBill < 2500) {
										
										// To determine whether there are any copies of the specific movie remaining.  
										if(stock4 > 0) {
											
											// To determine whether the member has already borrowed 5 (the maximum number of) movies (allowed for one member). 
											if(currentMovies < 5) {
												
												// To convert the Date into a String.
												DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");  
									            String strDate = dateFormat.format(borrowingdate);  
								            	
									            int allowedtime = 3;

									        	// To convert the "Date" String into a character array. 
									            char[] a = strDate.toCharArray();
									    		
									            // To separate the days, month and year of the date into individual character arrays.
									    		char[] month = {a[0],a[1],a[2]};
									    		char[] day = {a[4], a[5]};
									    		char[] year = {a[7], a[8], a[9], a[10]};
									    		
									    		// To store the "days" part of the date for later calculation.
									    		int daysinMonth = Integer.parseInt(String.valueOf(day));
									    		
									    		// To store the "month" part of the date for later manipulation.
									    		String monthA = String.valueOf(month);
									    		
									    		// To store the "years" part of the date for later calculation.
									    		int yearsA = Integer.parseInt(String.valueOf(year));
									    		
									    		// To declare and instantiate a variable that will hold the "day" in the date of when the movie is to be returned.
									    		int datedue = 0;
									    		
									    		/* To work with all the months except "February" 
									    		 * because "February" is the only month whose date is affected by whether the year is a leap year or not.
									    		 */ 
									    		if((monthA.equals("Feb") == false)) {
									    			// If the month is "January".
									    			if(monthA.equals("Jan")) {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of January" are the "3rd of February". 
									    					datedue = 3;
									    					monthA = "Feb";
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30th of January" are the "2nd of February". 
									    					datedue = 2;
									    					monthA = "Feb";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of January" are the "1st of February".
									    					datedue = 1;
									    					monthA = "Feb";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    					
									    			} // If the month is "March".
									    			else if (monthA.equals("Mar")) {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of March" are the "3rd of April".
									    					datedue = 3;
									    					monthA = "Apr";
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30th of March" are the "2nd of April".
									    					datedue = 2;
									    					monthA = "Apr";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of March" are the "1st of April".
									    					datedue = 1;
									    					monthA = "Apr";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "April".
									    			else if (monthA.equals("Apr")) {
									    				// If the "days" in the date are 30.
									    				if(daysinMonth == 30) {
									    					// 3 days from the "30th of April" are the "3rd of May".
									    					datedue = 3;
									    					monthA = "May";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of April" are the "2nd of May".
									    					datedue = 2;
									    					monthA = "May";
									    				} // If the "days" in the date are 28.
									    				else if(daysinMonth == 28) {
									    					// 3 days from the "28th of April" are the "1st of May".
									    					datedue = 1;
									    					monthA = "May";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "May".
									    			else if (monthA.equals("May")) {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of May" are the "3rd of June".
									    					datedue = 3;
									    					monthA = "Jun";
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30th of May" are the "2nd of June".
									    					datedue = 2;
									    					monthA = "Jun";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of May" are the "1st of June".
									    					datedue = 1;
									    					monthA = "Jun";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "June".
									    			else if (monthA.equals("Jun")) {
									    				// If the "days" in the date are 30.
									    				if(daysinMonth == 30) {
									    					// 3 days from the "30th of June" are the "3rd of July".
									    					datedue = 3;
									    					monthA = "Jul";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of June" are the "2nd of July".
									    					datedue = 2;
									    					monthA = "Jul";
									    				} // If the "days" in the date are 28.
									    				else if(daysinMonth == 28) {
									    					/// 3 days from the "28th of June" are the "1st of July".
									    					datedue = 1;
									    					monthA = "Jul";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "July".
									    			else if (monthA.equals("Jul")) {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of June" are the "3rd of August".
									    					datedue = 3;
									    					monthA = "Aug";
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30th of June" are the "2nd of August".
									    					datedue = 2;
									    					monthA = "Aug";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of June" are the "1st of August".
									    					datedue = 1;
									    					monthA = "Aug";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "August".
									    			else if (monthA.equals("Aug")) {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of August" are the "3rd of September".
									    					datedue = 3;
									    					monthA = "Sep";
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30th of August" are the "2nd of September".
									    					datedue = 2;
									    					monthA = "Sep";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of August" are the "1st of September".
									    					datedue = 1;
									    					monthA = "Sep";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "September".
									    			else if (monthA.equals("Sep")) {
									    				// If the "days" in the date are 30.
									    				if(daysinMonth == 30) {
									    					// 3 days from the "30th of September" are the "3rd of October".
									    					datedue = 3;
									    					monthA = "Oct";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of September" are the "2nd of October".
									    					datedue = 2;
									    					monthA = "Oct";
									    				} // If the "days" in the date are 28.
									    				else if(daysinMonth == 28) {
									    					// 3 days from the "28th of September" are the "1st of October".
									    					datedue = 1;
									    					monthA = "Oct";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "October".
									    			else if (monthA.equals("Oct")) {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of October" are the "3rd of November".
									    					datedue = 3;
									    					monthA = "Nov";
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30rd of October" are the "2nd of November".
									    					datedue = 2;
									    					monthA = "Nov";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of October" are the "1st of November".
									    					datedue = 1;
									    					monthA = "Nov";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "November".
									    			else if (monthA.equals("Nov")) {
									    				// If the "days" in the date are 30.
									    				if(daysinMonth == 30) {
									    					// 3 days from the "30th of November" are the "3rd of December".
									    					datedue = 3;
									    					monthA = "Dec";
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of November" are the "2nd of December".
									    					datedue = 2;
									    					monthA = "Dec";
									    				} // If the "days" in the date are 28.
									    				else if(daysinMonth == 28) {
									    					// 3 days from the "28th of November" are the "1st of December".
									    					datedue = 1;
									    					monthA = "Dec";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the month is "December".
									    			else {
									    				// If the "days" in the date are 31.
									    				if(daysinMonth == 31) {
									    					// 3 days from the "31st of December" are the "3rd of January" the following year.
									    					datedue = 3;
									    					monthA = "Jan";
									    					yearsA = yearsA + 1; 
									    				} // If the "days" in the date are 30.
									    				else if(daysinMonth == 30) {
									    					// 3 days from the "30th of December" are the "2nd of January" the following year.
									    					datedue = 2;
									    					monthA = "Jan";
									    					yearsA = yearsA + 1; 
									    				} // If the "days" in the date are 29.
									    				else if(daysinMonth == 29) {
									    					// 3 days from the "29th of December" are the "1st of January" the following year.
									    					datedue = 1;
									    					monthA = "Jan";
									    					yearsA = yearsA + 1; 
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			}
									    		} // If the month is "February". 
									    		else {
									    			// If the year is a leap year.
									    			if((yearsA % 4) == 0) {
									    				// If the "days" in the date are 29.
									    				if(daysinMonth == 29) {
									    					// 3 days from the "29th of February" are the "3rd of March".
									    					datedue = 3;
									    					monthA = "Mar";
									    				} // If the "days" in the date are 28.
									    				else if(daysinMonth == 28) {
									    					// 3 days from the "28th of February" are the "2nd of March".
									    					datedue = 2;
									    					monthA = "Mar";
									    				} // If the "days" in the date are 27. 
									    				else if(daysinMonth == 27) {
									    					// 3 days from the "27th of February" are the "1st of March".
									    					datedue = 1;
									    					monthA = "Mar";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}
									    			} // If the year is not a leap year.
									    			else {
									    				// If the "days" in the date are 28.
									    				if(daysinMonth == 28) {
									    					// 3 days from the "28th of February" are the "3rd of March".
									    					datedue = 3;
									    					monthA = "Mar";
									    				} // If the "days" in the date are 27.
									    				else if(daysinMonth == 27) {
									    					// 3 days from the "27th of February" are the "2nd of March".
									    					datedue = 2;
									    					monthA = "Mar";
									    				} // If the "days" in the date are 26.
									    				else if(daysinMonth == 26) {
									    					// 3 days from the "26th of February" are the "1st of March".
									    					datedue = 1;
									    					monthA = "Mar";
									    				} // If the "days" in the date are any other besides 31, 30 or 29.
									    				else {
									    					// The "days" of the due date from any of the borrowing dates will simply be + 3.
									    					datedue = daysinMonth + allowedtime;
									    				}			
									    			}
									    		}
									    		
									    		// To store the due Month, Day and Year respectively. 
									    		String monthfinal = String.valueOf(monthA);
									    		String dateduefinal = String.valueOf(datedue);
									    		String yearfinal = String.valueOf(yearsA);
									    		
									    		// To merge the month, day and year respectively into a single date.
									    		String finalduedate = monthfinal + " " + dateduefinal + ", " + yearfinal;
												
												// To reduce the number of available movies by 1 then convert the new stock into a String.
												int stock1 = stock4 - 1;
												String stock2 = String.valueOf(stock1);
												
												try {
													
													// SQL code to insert a borrowed movie and the borrower into the "Borrowed_Movies" table in the database.
													String query5 = "INSERT INTO Borrowed_Movies (Movie_ID, Lent_To, Movie_Name, Date_Lent, Date_Due, Charge) "
																  + "VALUES ('"+movieId+"', '"+lentTo+"', '"+moviename+"', ? , '"+finalduedate+"' , '"+charge+"')";
													
													// SQL code to update the stock of the movie in the table containing the specific genre of movies.
													String query6 = "UPDATE "+table1+" SET Stock = "+stock2+" WHERE Movie_ID = '"+movieId+"'";
													
													// SQL code to update the stock of the movie in the table containing all the movies in the database.
													String query7 = "UPDATE EntireMovieDatabase SET Stock = "+stock2+" WHERE Movie_ID = '"+movieId+"'";
													
													PreparedStatement pst5 = conn.prepareStatement(query5);
													PreparedStatement pst6 = conn.prepareStatement(query6);
													PreparedStatement pst7 = conn.prepareStatement(query7);
																					
													pst5.setString(1, ((JTextField)e.getDateEditor().getUiComponent()).getText());
													
													pst5.executeUpdate();
													pst6.executeUpdate();
													pst7.executeUpdate();
													
													// System feedback as a result of a successful transaction
													JOptionPane.showMessageDialog(null, "Please give "+charge+" shillings at the counter to proceed with the borrowing process.");
													JOptionPane.showMessageDialog(null, "Movie Borrowed Successfully. You are required to return it on "+finalduedate+".");
													
													pst5.close();
													pst6.close();
													pst7.close();
																						
													x.setVisible(false);
													q.setText("");
													w.setText("");
													e.setDate(null);
													SiteHome.setVisible(true);
														
												} catch (SQLException e1) {
													
													// In the event that the member has already borrowed the particular movie.
													JOptionPane.showMessageDialog(null, "You have already borrowed this movie");
												}
											} else {
												
												// In the event that the member has already borrowed a total of 5 movies.
												JOptionPane.showMessageDialog(null, "You cannot have more than 5 movies at a time");
											}
										} else {
											
											// In the event that the number of available copies of the movie is 0.
											JOptionPane.showMessageDialog(null, "Movie Unavailable at the moment");
										}
									} else {
										
										// In the event that the members' outstanding debt is too large.
										JOptionPane.showMessageDialog(null, "Your outstanding bills are too large");
									}
		
							}
								
								rs4.close();						
								pst4.close();
			            } catch (SQLException e1) {
								e1.printStackTrace();
						}
				} else {
					
					// Prompt the member to select a movie from the table of movies shown.
					r.setText("Please fill in all the details");
		        }
						
				}
			}
		}
			
			rs1.close();
			rs2.close();
			rs3.close();
			
			pst1.close();
			pst2.close();
			pst3.close();
			conn.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	// Code to clear a member after returning a borrowed movie.
	public void deleteFromBorrowedMovie(String movieId, String lentTo, JTable table1) {
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			
			/* SQL code to remove a record from the "Borrowed_Movies" table
			 * where the "Lent_To" and "Movie_Id" fields match those of the member's membership Id and the movie's Id respectively.
			 */
			String query = "DELETE FROM Borrowed_Movies "
						 + "WHERE Movie_ID = '"+movieId+"' AND Lent_To = '"+lentTo+"'";
						
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			pst.close();
			conn.close();
			
			// System feedback in the event of a successful clearance.
			JOptionPane.showMessageDialog(null, "Customer Cleared");
			
			// To refresh the table being displayed to show the remaining records in the "Borrowed_Movies" table in the database.
			String tablefrom = "Borrowed_Movies";
			btnDatabaseViewer(table1, tablefrom);
			
		} catch (SQLException e1) {
			
			// System feedback in the event of an unsuccessful clearance.
			JOptionPane.showMessageDialog(null, "Customer not Cleared");
		}
	}
	
	// Code to penalise a member for damaging a borrowed movie.
	public void insertToDamagedMovies(String movieId, String lentTo, String moviename) {
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			
			// SQL code to insert a record into the "Damaged_Movies" table with the damaged movie's Id and member's, responsible for the damage, membership Id.
			String query = "INSERT INTO Damaged_Movies (Movie_ID, Lent_To, Movie_Name, Charge) "
						 + "VALUES ('"+movieId+"', '"+lentTo+"', '"+moviename+"', 700)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			
			// System feedback in the event of a successful penalisation.
			JOptionPane.showMessageDialog(null, "Movie Added to the list of Damaged Movies");
			pst.close();
			conn.close();
		} catch (SQLException e1) {
			// System feedback in the event of an unsuccessful penalisation.
			JOptionPane.showMessageDialog(null, "Customer not Cleared");
		}
	}
	
	// Code to clear a member after paying the derived charge from the number of days that the movie is overdue.
	public void returnOverdueMovie(String charge, String movieId, String lentTo, JTable table1) {
		 
		// To prompt the customer to pay the derived amount of charges in order to be cleared.
		JOptionPane.showMessageDialog(null, "Demand Ksh "+charge+" from the customer");
		
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			
			/* SQL code to remove a record from the "Overdue_Movies" table
			 * where the "Lent_To" and "Movie_Id" fields match those of the member's membership Id and the movie's Id respectively.
			 */
			String query = "DELETE FROM Overdue_Movies "
						 + "WHERE Movie_ID = '"+movieId+"' AND Lent_To = '"+lentTo+"'";
							
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			pst.close();
			conn.close();
 			
			// System feedback in the event of a successful penalisation.
 			JOptionPane.showMessageDialog(null, "Customer Cleared");
 			
 			// To refresh the table being displayed to show the remaining records in the "Borrowed_Movies" table in the database.
 			String tablefrom = "Overdue_Movies";
			btnDatabaseViewer(table1, tablefrom);
				
		} catch (SQLException e1) {
			
			// System feedback in the event of an unsuccessful penalisation.
			JOptionPane.showMessageDialog(null, "Customer not cleared");
		}
	}
	
	// Code to clear a member after paying the 700 shillings for damaging a movie.
	public void removefromDamagedMovies(String movieId, String lentTo, JTable table1) {
		// To prompt the customer to pay the 700 shillings..
		JOptionPane.showMessageDialog(null, "Demand Kshs.700 from the customer ");
		
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			
			/* SQL code to remove a record from the "Damaged_Movies" table
			 * where the "Lent_To" and "Movie_Id" fields match those of the member's membership Id and the movie's Id respectively.
			 */
			String query = "DELETE FROM Damaged_Movies "
						 + "WHERE Movie_ID = '"+movieId+"' AND Lent_To = '"+lentTo+"'";
							
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			pst.close();
	   		conn.close();
	   		
	   		// System feedback in the event of a successful penalisation.
	   		JOptionPane.showMessageDialog(null, "Customer Cleared");
	   		
	   		// To refresh the table being displayed to show the remaining records in the "Damaged_Movies" table in the database.
	   		String tablefrom = "Damaged_Movies";
			btnDatabaseViewer(table1, tablefrom);
			
		} catch (SQLException e1) {
			// System feedback in the event of an unsuccessful penalisation.
			JOptionPane.showMessageDialog(null, "Customer not Cleared");
		}
	}
	
	// Code to add a member-movie combination to the "Overdue_Movies" table if the returning of the movie was done after the due date. 
	public void insertToOverdueMovies(String movieId, String lentTo, String moviename, String daysOverdue1, String chargeFinal) {
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			
			// SQL code to insert a record to the "Overdue_Movies" table with a member-movie combination primary key.
			String query = "INSERT INTO Overdue_Movies (Movie_ID, Lent_To, Movie_Name, Days_Overdue, Charge) "
						 + "VALUES('"+movieId+"', '"+lentTo+"', '"+moviename+"', '"+daysOverdue1+"', '"+chargeFinal+"')";
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			pst.close();
			conn.close();
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	// Method for the "Borrowed Movies" panel custom table layout.  
	public void borrowedMoviesTableLayout() {
		BorrowedMoviesTable.getColumnModel().getColumn(0).setPreferredWidth(67);
		BorrowedMoviesTable.getColumnModel().getColumn(1).setPreferredWidth(53);
		BorrowedMoviesTable.getColumnModel().getColumn(2).setPreferredWidth(207);
		BorrowedMoviesTable.getColumnModel().getColumn(3).setPreferredWidth(103);
		BorrowedMoviesTable.getColumnModel().getColumn(4).setPreferredWidth(98);
		BorrowedMoviesTable.getColumnModel().getColumn(5).setPreferredWidth(51);
		BorrowedMoviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Overdue Movies" panel custom table layout.
	public void overdueMoviesTableLayout() {
		OverDueMoviesTable.getColumnModel().getColumn(0).setPreferredWidth(66);
		OverDueMoviesTable.getColumnModel().getColumn(1).setPreferredWidth(52);
		OverDueMoviesTable.getColumnModel().getColumn(2).setPreferredWidth(139);
		OverDueMoviesTable.getColumnModel().getColumn(3).setPreferredWidth(87);
		OverDueMoviesTable.getColumnModel().getColumn(4).setPreferredWidth(51);
		OverDueMoviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Damaged Movies" panel custom table layout.
	public void damagedMoviesTableLayout() {
		DamagedMoviesTable.getColumnModel().getColumn(0).setPreferredWidth(66);
		DamagedMoviesTable.getColumnModel().getColumn(1).setPreferredWidth(55);
		DamagedMoviesTable.getColumnModel().getColumn(2).setPreferredWidth(121);
		DamagedMoviesTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		DamagedMoviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the custom table layout of the table that displays the Entire Movie Catalogue.
	public void searchMovieTableLayout() {
		searchMovieTable.getColumnModel().getColumn(0).setPreferredWidth(65);
		searchMovieTable.getColumnModel().getColumn(1).setPreferredWidth(194);
		searchMovieTable.getColumnModel().getColumn(2).setPreferredWidth(192);
		searchMovieTable.getColumnModel().getColumn(3).setPreferredWidth(85);
		searchMovieTable.getColumnModel().getColumn(4).setPreferredWidth(44);
		searchMovieTable.getColumnModel().getColumn(5).setPreferredWidth(40);
		searchMovieTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Comedy" panel custom table layout.
	public void comedyTableLayout() {
		ComedyTable.getColumnModel().getColumn(0).setPreferredWidth(61);
		ComedyTable.getColumnModel().getColumn(1).setPreferredWidth(142);
		ComedyTable.getColumnModel().getColumn(2).setPreferredWidth(196);
		ComedyTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ComedyTable.getColumnModel().getColumn(4).setPreferredWidth(57);
		ComedyTable.getColumnModel().getColumn(5).setPreferredWidth(52);
		ComedyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "General" panel custom table layout.
	public void generalTableLayout() {
		GeneralTable.getColumnModel().getColumn(1).setPreferredWidth(148);
		GeneralTable.getColumnModel().getColumn(2).setPreferredWidth(176);
		GeneralTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		GeneralTable.getColumnModel().getColumn(4).setPreferredWidth(51);
		GeneralTable.getColumnModel().getColumn(5).setPreferredWidth(47);
		GeneralTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Horror" panel custom table layout.
	public void horrorTableLayout() {
		HorrorTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		HorrorTable.getColumnModel().getColumn(1).setPreferredWidth(140);
		HorrorTable.getColumnModel().getColumn(2).setPreferredWidth(155);
		HorrorTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		HorrorTable.getColumnModel().getColumn(4).setPreferredWidth(55);
		HorrorTable.getColumnModel().getColumn(5).setPreferredWidth(54);
		HorrorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Thriller" panel custom table layout.
	public void thrillerTableLayout() {
		ThrillerTable.getColumnModel().getColumn(0).setPreferredWidth(67);
		ThrillerTable.getColumnModel().getColumn(1).setPreferredWidth(195);
		ThrillerTable.getColumnModel().getColumn(2).setPreferredWidth(160);
		ThrillerTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ThrillerTable.getColumnModel().getColumn(4).setPreferredWidth(46);
		ThrillerTable.getColumnModel().getColumn(5).setPreferredWidth(51);
		ThrillerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Cartoon" panel custom table layout.
	public void cartoonTableLayout() {
		CartoonTable.getColumnModel().getColumn(0).setPreferredWidth(67);
		CartoonTable.getColumnModel().getColumn(1).setPreferredWidth(133);
		CartoonTable.getColumnModel().getColumn(2).setPreferredWidth(163);
		CartoonTable.getColumnModel().getColumn(3).setPreferredWidth(95);
		CartoonTable.getColumnModel().getColumn(4).setPreferredWidth(54);
		CartoonTable.getColumnModel().getColumn(5).setPreferredWidth(51);
		CartoonTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Members" panel custom table layout.
	public void membersTableLayout() {
		MembersTable.getColumnModel().getColumn(0).setPreferredWidth(95);
		MembersTable.getColumnModel().getColumn(1).setPreferredWidth(178);
		MembersTable.getColumnModel().getColumn(2).setPreferredWidth(87);
		MembersTable.getColumnModel().getColumn(3).setPreferredWidth(95);
		MembersTable.getColumnModel().getColumn(4).setPreferredWidth(83);
		MembersTable.getColumnModel().getColumn(5).setPreferredWidth(97);
		MembersTable.getColumnModel().getColumn(6).setPreferredWidth(73);
		MembersTable.getColumnModel().getColumn(7).setPreferredWidth(130);
		MembersTable.getColumnModel().getColumn(8).setPreferredWidth(80);
		MembersTable.getColumnModel().getColumn(9).setPreferredWidth(57);
		MembersTable.getColumnModel().getColumn(10).setPreferredWidth(92);
		MembersTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "Movie Catalogue" tab custom table layout.
	public void adminMovieCatalogLayout() {
		AdminMovieCatalog.getColumnModel().getColumn(0).setPreferredWidth(80);
		AdminMovieCatalog.getColumnModel().getColumn(1).setPreferredWidth(219);
		AdminMovieCatalog.getColumnModel().getColumn(2).setPreferredWidth(174);
		AdminMovieCatalog.getColumnModel().getColumn(3).setPreferredWidth(93);
		AdminMovieCatalog.getColumnModel().getColumn(4).setPreferredWidth(58);
		AdminMovieCatalog.getColumnModel().getColumn(5).setPreferredWidth(55);
		AdminMovieCatalog.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "IETable" on the individual expenses panel on the administrators's view of the system when displaying an individual's "Borrowed movies".
	public void ieBorrowedMoviesTableLayout() {
		IETable.getColumnModel().getColumn(0).setPreferredWidth(71);
		IETable.getColumnModel().getColumn(1).setPreferredWidth(59);
		IETable.getColumnModel().getColumn(2).setPreferredWidth(131);
		IETable.getColumnModel().getColumn(3).setPreferredWidth(88);
		IETable.getColumnModel().getColumn(4).setPreferredWidth(88);
		IETable.getColumnModel().getColumn(5).setPreferredWidth(47);
		IETable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	// Method for the "IETable" on the individual expenses panel on the administrators's view of the system when displaying an individual's "Overdue movies".
	public void ieOverdueMoviesTableLayout() {
		IETable.getColumnModel().getColumn(0).setPreferredWidth(71);
		IETable.getColumnModel().getColumn(1).setPreferredWidth(59);
		IETable.getColumnModel().getColumn(2).setPreferredWidth(131);
		IETable.getColumnModel().getColumn(3).setPreferredWidth(88);
		IETable.getColumnModel().getColumn(4).setPreferredWidth(50);
		IETable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	// Method for the "IETable" on the individual expenses panel on the administrators's view of the system when displaying an individual's "Damaged" movies.
	public void ieDamagedMoviesTableLayout() {
		IETable.getColumnModel().getColumn(0).setPreferredWidth(71);
		IETable.getColumnModel().getColumn(1).setPreferredWidth(59);
		IETable.getColumnModel().getColumn(2).setPreferredWidth(131);
		IETable.getColumnModel().getColumn(3).setPreferredWidth(51);
		IETable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	
	//program start
	private void initialize() {
		
		//Overall form structure 
		
		frmUpepeoVideoLending = new JFrame();
		frmUpepeoVideoLending.setResizable(false);
		frmUpepeoVideoLending.setTitle("UPEPEO VIDEO LENDING SYSTEM");
		frmUpepeoVideoLending.setBounds(100, 100, 871, 539);
		frmUpepeoVideoLending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpepeoVideoLending.getContentPane().setLayout(new CardLayout(0, 0));
		
		//Panels
		final JPanel HomePage = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(HomePage, "name_42532569734100");
		HomePage.setLayout(null);
		HomePage.setVisible(true);
		
		TermsAndConditions = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(TermsAndConditions, "name_42569796481100");
		TermsAndConditions.setLayout(null);
		TermsAndConditions.setVisible(false);
		
		final JPanel CreateAccount = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(CreateAccount, "name_42573275640600");
		CreateAccount.setLayout(null);
		CreateAccount.setVisible(false);
				
		SiteHome = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(SiteHome, "name_56949863459300");
		SiteHome.setLayout(null);
		SiteHome.setVisible(false);
		
		final JPanel Comedy = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(Comedy, "name_1121299287100");
		Comedy.setVisible(false);
		
		final JPanel General = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(General, "name_1133445178800");
		General.setVisible(false);
		
		Horror = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(Horror, "name_1137845800200");
		Horror.setLayout(null);
		Horror.setVisible(false);
		
		Thriller = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(Thriller, "name_1146651091600");
		Thriller.setLayout(null);
		Thriller.setVisible(false);
		
		Cartoon = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(Cartoon, "name_1151197811300");
		Cartoon.setLayout(null);
		Cartoon.setVisible(false);
		
		final JPanel Admin = new JPanel();
		Admin.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				String tablefrom = "Borrowed_Movies";
				btnDatabaseViewer(BorrowedMoviesTable, tablefrom);
				borrowedMoviesTableLayout();	
				
				String tablefrom1 = "Members";
				btnDatabaseViewer(MembersTable, tablefrom1);
				membersTableLayout();
			}
		});
		frmUpepeoVideoLending.getContentPane().add(Admin, "name_658526286658900");
		Admin.setLayout(null);
		Admin.setVisible(false);
		
		final JPanel MovieManager = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(MovieManager, "name_1914122780200");
		MovieManager.setLayout(null);
		MovieManager.setLayout(null);
		MovieManager.setVisible(false);
		
		final JPanel AddMovie = new JPanel();
		AddMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AddMovie.setBounds(10, 74, 414, 415);
		MovieManager.add(AddMovie);
		AddMovie.setLayout(null);
		AddMovie.setVisible(false);
		
		final JPanel DeleteMovie = new JPanel();
		DeleteMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		DeleteMovie.setBounds(431, 74, 414, 415);
		MovieManager.add(DeleteMovie);
		DeleteMovie.setLayout(null);
		DeleteMovie.setVisible(false);
		
		final JTabbedPane tabAdmin = new JTabbedPane(JTabbedPane.TOP);
		
		final JPanel MovieCatalog = new JPanel();
		tabAdmin.addTab("Movie Catalog", null, MovieCatalog, null);
		MovieCatalog.setLayout(null);
		
		final JPanel Members = new JPanel();
		tabAdmin.addTab("Members", null, Members, null);
		Members.setLayout(null);
				
		final JPanel Finances = new JPanel();
		tabAdmin.addTab("Finances", null, Finances, null);
		Finances.setLayout(null);
		
		final JPanel BorrowedMoviesPanel = new JPanel();
		BorrowedMoviesPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		BorrowedMoviesPanel.setBounds(10, 11, 629, 379);
		Finances.add(BorrowedMoviesPanel);
		BorrowedMoviesPanel.setLayout(null);
		
		final JPanel OverdueMoviesPanel = new JPanel();
		OverdueMoviesPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		OverdueMoviesPanel.setBounds(10, 11, 629, 379);
		Finances.add(OverdueMoviesPanel);
		OverdueMoviesPanel.setVisible(false);
		OverdueMoviesPanel.setLayout(null);
		
		final JPanel DamagedMoviesPanel = new JPanel();
		DamagedMoviesPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		DamagedMoviesPanel.setBounds(10, 11, 629, 379);
		Finances.add(DamagedMoviesPanel);
		DamagedMoviesPanel.setVisible(false);
		DamagedMoviesPanel.setLayout(null);
		
		final JPanel IE = new JPanel();
		IE.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		IE.setBounds(10, 11, 629, 379);
		Finances.add(IE);
		IE.setLayout(null);
		IE.setVisible(false);
		
		final JPanel IncomeandAllocationsPanel = new JPanel();
		IncomeandAllocationsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		IncomeandAllocationsPanel.setBounds(10, 11, 629, 379);
		Finances.add(IncomeandAllocationsPanel);
		IncomeandAllocationsPanel.setLayout(null);
		IncomeandAllocationsPanel.setVisible(false);
		
		JScrollPane BorrowedMoviesscrollPane = new JScrollPane();
		BorrowedMoviesscrollPane.setBounds(10, 32, 609, 167);
		BorrowedMoviesPanel.add(BorrowedMoviesscrollPane);
			
		BorrowedMoviesTable = new JTable();
		BorrowedMoviesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		BorrowedMoviesTable.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int row = BorrowedMoviesTable.getSelectedRow();
			String movieId = String.valueOf(BorrowedMoviesTable.getValueAt(row, 0));
			String lentTo = String.valueOf(BorrowedMoviesTable.getValueAt(row, 1));
			String moviename = String.valueOf(BorrowedMoviesTable.getValueAt(row, 2));
			int charge = Integer.parseInt(String.valueOf(BorrowedMoviesTable.getValueAt(row, 5)));
			String charge1 = String.valueOf(charge);
						
			BorrowedMovieMovieIDtxt.setText(movieId);
			BorrowedMovieLentTotxt.setText(lentTo);
			BorrowedMovieMovieNametxt.setText(moviename);
			txtCharge.setText(charge1);
						
			BorrowedMovieDateBorrowedlbl.setEnabled(true);
			BorrowedMovieOverduecomboBox.setEnabled(true);
			BorrowedMovieConditionlbl.setEnabled(true);
			BorrowedMovieConditioncomboBox.setEnabled(true);
		}
		});
		BorrowedMoviesTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Movie_ID", "Lent_To", "Movie_Name", "Date_Lent", "Date_Due", "Charge"
					}
				));
		BorrowedMoviesTable.getColumnModel().getColumn(0).setPreferredWidth(67);
		BorrowedMoviesTable.getColumnModel().getColumn(1).setPreferredWidth(53);
		BorrowedMoviesTable.getColumnModel().getColumn(2).setPreferredWidth(207);
		BorrowedMoviesTable.getColumnModel().getColumn(3).setPreferredWidth(103);
		BorrowedMoviesTable.getColumnModel().getColumn(4).setPreferredWidth(98);
		BorrowedMoviesTable.getColumnModel().getColumn(5).setPreferredWidth(51);
		BorrowedMoviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		BorrowedMoviesTable.setRowHeight(20);
		BorrowedMoviesscrollPane.setViewportView(BorrowedMoviesTable);
		BorrowedMoviesTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel lblNewLabel = new JLabel("Return Movie");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 202, 609, 24);
				BorrowedMoviesPanel.add(lblNewLabel);
				
				JLabel BorrowedMovieMovieIDlbl = new JLabel("Movie ID:");
				BorrowedMovieMovieIDlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieMovieIDlbl.setBounds(20, 234, 71, 24);
				BorrowedMoviesPanel.add(BorrowedMovieMovieIDlbl);
				
				JLabel BorrowedMovieMovieNamelbl = new JLabel("Movie Name:");
				BorrowedMovieMovieNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieMovieNamelbl.setBounds(20, 259, 71, 24);
				BorrowedMoviesPanel.add(BorrowedMovieMovieNamelbl);
				
				JLabel BorrwedMovieLentTolbl = new JLabel("Lent To:");
				BorrwedMovieLentTolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrwedMovieLentTolbl.setBounds(20, 284, 71, 24);
				BorrowedMoviesPanel.add(BorrwedMovieLentTolbl);
				
				BorrowedMovieMovieIDtxt = new JTextField();
				BorrowedMovieMovieIDtxt.setEditable(false);
				BorrowedMovieMovieIDtxt.setBackground(Color.WHITE);
				BorrowedMovieMovieIDtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieMovieIDtxt.setBounds(101, 237, 190, 21);
				BorrowedMoviesPanel.add(BorrowedMovieMovieIDtxt);
				BorrowedMovieMovieIDtxt.setColumns(10);
				
				BorrowedMovieMovieNametxt = new JTextField();
				BorrowedMovieMovieNametxt.setEditable(false);
				BorrowedMovieMovieNametxt.setBackground(Color.WHITE);
				BorrowedMovieMovieNametxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieMovieNametxt.setColumns(10);
				BorrowedMovieMovieNametxt.setBounds(101, 262, 190, 21);
				BorrowedMoviesPanel.add(BorrowedMovieMovieNametxt);
				
				BorrowedMovieLentTotxt = new JTextField();
				BorrowedMovieLentTotxt.setEditable(false);
				BorrowedMovieLentTotxt.setBackground(Color.WHITE);
				BorrowedMovieLentTotxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieLentTotxt.setColumns(10);
				BorrowedMovieLentTotxt.setBounds(101, 287, 190, 21);
				BorrowedMoviesPanel.add(BorrowedMovieLentTotxt);
				
				BorrowedMovieDateBorrowedlbl = new JLabel("Overdue?:");
				BorrowedMovieDateBorrowedlbl.setEnabled(false);
				BorrowedMovieDateBorrowedlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieDateBorrowedlbl.setBounds(321, 234, 98, 24);
				BorrowedMoviesPanel.add(BorrowedMovieDateBorrowedlbl);
				
				BorrowedMovieDaysOverduelbl = new JLabel("Days Overdue");
				BorrowedMovieDaysOverduelbl.setEnabled(false);
				BorrowedMovieDaysOverduelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieDaysOverduelbl.setBounds(321, 259, 98, 24);
				BorrowedMoviesPanel.add(BorrowedMovieDaysOverduelbl);
				
				BorrowedMovieDaysOverduetxt = new JTextField();
				BorrowedMovieDaysOverduetxt.setEnabled(false);
				BorrowedMovieDaysOverduetxt.setBackground(Color.WHITE);
				BorrowedMovieDaysOverduetxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieDaysOverduetxt.setColumns(10);
				BorrowedMovieDaysOverduetxt.setBounds(418, 262, 190, 21);
				BorrowedMoviesPanel.add(BorrowedMovieDaysOverduetxt);
				
				BorrowedMovieConditionlbl = new JLabel("Condition:");
				BorrowedMovieConditionlbl.setEnabled(false);
				BorrowedMovieConditionlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieConditionlbl.setBounds(321, 284, 98, 24);
				BorrowedMoviesPanel.add(BorrowedMovieConditionlbl);
				
				BorrowedMovieConditioncomboBox = new JComboBox<String>();
				BorrowedMovieConditioncomboBox.setEnabled(false);
				BorrowedMovieConditioncomboBox.setBackground(Color.WHITE);
				BorrowedMovieConditioncomboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieConditioncomboBox.setBounds(418, 286, 189, 22);
				BorrowedMoviesPanel.add(BorrowedMovieConditioncomboBox);
				BorrowedMovieConditioncomboBox.addItem("Good");
				BorrowedMovieConditioncomboBox.addItem("Damaged");
				BorrowedMovieConditioncomboBox.setSelectedItem(null);
				
				
				JButton BorrowedMoviesClearbtn = new JButton("Clear");
				BorrowedMoviesClearbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						BorrowedMovieMovieIDtxt.setText("");
						BorrowedMovieLentTotxt.setText("");
						BorrowedMovieMovieNametxt.setText("");
						BorrowedMovieDaysOverduetxt.setText("");
						BorrowedMovieConditioncomboBox.setSelectedItem(null);
						BorrowedMovieOverduecomboBox.setSelectedItem(null);
						txtCharge.setText("");
					}
				});
				BorrowedMoviesClearbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMoviesClearbtn.setBounds(211, 319, 89, 23);
				BorrowedMoviesPanel.add(BorrowedMoviesClearbtn);
				
				JButton BorrowedMoviesReturnbtn = new JButton("Return");
				BorrowedMoviesReturnbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String movieId = BorrowedMovieMovieIDtxt.getText();
						String lentTo = BorrowedMovieLentTotxt.getText();
						String moviename = BorrowedMovieMovieNametxt.getText();
						
						String daysOverdueInput = BorrowedMovieDaysOverduetxt.getText();
						String condition = (String)BorrowedMovieConditioncomboBox.getSelectedItem();
						String charge = txtCharge.getText();
						String overdue = (String)BorrowedMovieOverduecomboBox.getSelectedItem();
									
						if((movieId.isBlank() == false) && (lentTo.isBlank() == false) && (moviename.isBlank() == false)
							&& (charge.isBlank() == false) && (condition != null) && (overdue != null)) {
							
							lblErrorsBorrowedMoviesPanel.setText("");
							
							if(overdue.equals("Yes")) {
								
								if((daysOverdueInput.isBlank()) == false) {
									
									int daysOverdue = Integer.parseInt(BorrowedMovieDaysOverduetxt.getText());
									int chargeOverdue;
								
									if(movieId.contains("COM")) {
										chargeOverdue = 42;
									} else if(movieId.contains("GEN")) {
										chargeOverdue = 30;
									} else if(movieId.contains("HOR")) {
										chargeOverdue = 24;
									} else if(movieId.contains("THR")) {
										chargeOverdue = 36;
									} else {
										chargeOverdue = 48;
									}
									
									String daysOverdue1 = String.valueOf(daysOverdue);
									String chargeFinal = String.valueOf(chargeOverdue * daysOverdue);
									
									if(condition.equals("Good")) {
										insertToOverdueMovies(movieId, lentTo, moviename, daysOverdue1, chargeFinal);
										deleteFromBorrowedMovie(movieId, lentTo, BorrowedMoviesTable);
										borrowedMoviesTableLayout();
									} else {
										insertToOverdueMovies(movieId, lentTo, moviename, daysOverdue1, chargeFinal);
										insertToDamagedMovies(movieId, lentTo, moviename);
										deleteFromBorrowedMovie(movieId, lentTo, BorrowedMoviesTable);
										borrowedMoviesTableLayout();
									}
								
								} else {
									lblErrorsBorrowedMoviesPanel.setText("Specify the days overdue");
								}
								
							} else {
								if(condition.equals("Good")) {
									deleteFromBorrowedMovie(movieId, lentTo, BorrowedMoviesTable);
									borrowedMoviesTableLayout();
								} else {
									insertToDamagedMovies(movieId, lentTo, moviename); 
									deleteFromBorrowedMovie(movieId, lentTo, BorrowedMoviesTable);
									borrowedMoviesTableLayout();
								}
							}
								
						} else {
							lblErrorsBorrowedMoviesPanel.setText("Please select a record from the table and choose it's condition");
						}
					}
				});
				BorrowedMoviesReturnbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMoviesReturnbtn.setBounds(330, 319, 89, 23);
				BorrowedMoviesPanel.add(BorrowedMoviesReturnbtn);
				
				JLabel lblBorrowedMovies = new JLabel("Borrowed Movies");
				lblBorrowedMovies.setForeground(Color.RED);
				lblBorrowedMovies.setHorizontalAlignment(SwingConstants.CENTER);
				lblBorrowedMovies.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblBorrowedMovies.setBounds(10, 11, 609, 19);
				BorrowedMoviesPanel.add(lblBorrowedMovies);
				
				txtCharge = new JTextField();
				txtCharge.setEditable(false);
				txtCharge.setVisible(false);
				txtCharge.setBounds(522, 322, 86, 20);
				BorrowedMoviesPanel.add(txtCharge);
				txtCharge.setColumns(10);
				
				lblErrorsBorrowedMoviesPanel = new JLabel("");
				lblErrorsBorrowedMoviesPanel.setForeground(Color.RED);
				lblErrorsBorrowedMoviesPanel.setHorizontalAlignment(SwingConstants.CENTER);
				lblErrorsBorrowedMoviesPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblErrorsBorrowedMoviesPanel.setBounds(10, 347, 609, 21);
				BorrowedMoviesPanel.add(lblErrorsBorrowedMoviesPanel);
				
				BorrowedMovieOverduecomboBox = new JComboBox<String>();
				BorrowedMovieOverduecomboBox.setEnabled(false);
				BorrowedMovieOverduecomboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						String overdue = (String)BorrowedMovieOverduecomboBox.getSelectedItem();
						if(overdue == "Yes") {
							BorrowedMovieDaysOverduetxt.setEnabled(true);
							BorrowedMovieDaysOverduelbl.setEnabled(true);
						} else {
							BorrowedMovieDaysOverduetxt.setEnabled(false);
							BorrowedMovieDaysOverduelbl.setEnabled(false);
						}
					}
				});
				BorrowedMovieOverduecomboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BorrowedMovieOverduecomboBox.setBackground(Color.WHITE);
				BorrowedMovieOverduecomboBox.setBounds(418, 236, 189, 22);
				BorrowedMoviesPanel.add(BorrowedMovieOverduecomboBox);
				BorrowedMovieOverduecomboBox.addItem("Yes");
				BorrowedMovieOverduecomboBox.addItem("No");
				BorrowedMovieOverduecomboBox.setSelectedItem(null);
		
		JScrollPane OverdueMoviesscrollPane = new JScrollPane();
		OverdueMoviesscrollPane.setBounds(10, 34, 609, 165);
		OverdueMoviesPanel.add(OverdueMoviesscrollPane);
		
		OverDueMoviesTable = new JTable();
		OverDueMoviesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		OverDueMoviesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = OverDueMoviesTable.getSelectedRow();
				String movieId = String.valueOf(OverDueMoviesTable.getValueAt(row, 0));
				String lentTo = String.valueOf(OverDueMoviesTable.getValueAt(row, 1));
				String moviename = String.valueOf(OverDueMoviesTable.getValueAt(row, 2));
				String daysOverdue = String.valueOf(OverDueMoviesTable.getValueAt(row, 3));
				int charge = Integer.parseInt(String.valueOf(OverDueMoviesTable.getValueAt(row, 4)));
				String charge1 = String.valueOf(charge);
				
				OverdueMovieMovieIDtxt.setText(movieId);
				OverdueMovieLentTotxt.setText(lentTo);
				OverdueMovieMovieNametxt.setText(moviename);
				OverdueMovieDaysOverduetxt.setText(daysOverdue);
				OverdueMovieChargetxt.setText(charge1);
			}
		});
		OverDueMoviesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie_ID", "Lent_To", "Movie_Name", "Days_Overdue", "Charge"
			}
		));
		OverDueMoviesTable.getColumnModel().getColumn(0).setPreferredWidth(66);
		OverDueMoviesTable.getColumnModel().getColumn(1).setPreferredWidth(52);
		OverDueMoviesTable.getColumnModel().getColumn(2).setPreferredWidth(139);
		OverDueMoviesTable.getColumnModel().getColumn(3).setPreferredWidth(87);
		OverDueMoviesTable.getColumnModel().getColumn(4).setPreferredWidth(51);
		OverDueMoviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		OverDueMoviesTable.setRowHeight(20);
		OverDueMoviesTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMoviesscrollPane.setViewportView(OverDueMoviesTable);
		
		JLabel OverdueMoviesClearDebtlbl = new JLabel("Clear Debt");
		OverdueMoviesClearDebtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		OverdueMoviesClearDebtlbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		OverdueMoviesClearDebtlbl.setBounds(10, 202, 609, 24);
		OverdueMoviesPanel.add(OverdueMoviesClearDebtlbl);
		
		JLabel OverdueMovieMovieIDlbl = new JLabel("Movie ID:");
		OverdueMovieMovieIDlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieMovieIDlbl.setBounds(20, 234, 71, 24);
		OverdueMoviesPanel.add(OverdueMovieMovieIDlbl);
		
		OverdueMovieMovieIDtxt = new JTextField();
		OverdueMovieMovieIDtxt.setBackground(Color.WHITE);
		OverdueMovieMovieIDtxt.setEditable(false);
		OverdueMovieMovieIDtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieMovieIDtxt.setColumns(10);
		OverdueMovieMovieIDtxt.setBounds(101, 237, 190, 21);
		OverdueMoviesPanel.add(OverdueMovieMovieIDtxt);
		
		JLabel OverdueMovieDaysOverduelbl = new JLabel("Days Overdue:");
		OverdueMovieDaysOverduelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieDaysOverduelbl.setBounds(321, 234, 98, 24);
		OverdueMoviesPanel.add(OverdueMovieDaysOverduelbl);
		
		OverdueMovieDaysOverduetxt = new JTextField();
		OverdueMovieDaysOverduetxt.setBackground(Color.WHITE);
		OverdueMovieDaysOverduetxt.setEditable(false);
		OverdueMovieDaysOverduetxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieDaysOverduetxt.setColumns(10);
		OverdueMovieDaysOverduetxt.setBounds(418, 237, 190, 21);
		OverdueMoviesPanel.add(OverdueMovieDaysOverduetxt);
		
		OverdueMovieChargetxt = new JTextField();
		OverdueMovieChargetxt.setBackground(Color.WHITE);
		OverdueMovieChargetxt.setEditable(false);
		OverdueMovieChargetxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieChargetxt.setColumns(10);
		OverdueMovieChargetxt.setBounds(418, 262, 190, 21);
		OverdueMoviesPanel.add(OverdueMovieChargetxt);
		
		JLabel OverdueMovieChargelbl = new JLabel("Charge:");
		OverdueMovieChargelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieChargelbl.setBounds(321, 259, 98, 24);
		OverdueMoviesPanel.add(OverdueMovieChargelbl);
		
		JLabel OverdueMovieLentTolbl = new JLabel("Lent To:");
		OverdueMovieLentTolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieLentTolbl.setBounds(20, 284, 71, 24);
		OverdueMoviesPanel.add(OverdueMovieLentTolbl);
		
		OverdueMovieLentTotxt = new JTextField();
		OverdueMovieLentTotxt.setBackground(Color.WHITE);
		OverdueMovieLentTotxt.setEditable(false);
		OverdueMovieLentTotxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieLentTotxt.setColumns(10);
		OverdueMovieLentTotxt.setBounds(101, 287, 190, 21);
		OverdueMoviesPanel.add(OverdueMovieLentTotxt);
		
		OverdueMovieMovieNametxt = new JTextField();
		OverdueMovieMovieNametxt.setBackground(Color.WHITE);
		OverdueMovieMovieNametxt.setEditable(false);
		OverdueMovieMovieNametxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieMovieNametxt.setColumns(10);
		OverdueMovieMovieNametxt.setBounds(101, 262, 190, 21);
		OverdueMoviesPanel.add(OverdueMovieMovieNametxt);
		
		JButton OverdueMoviesClearbtn = new JButton("Clear");
		OverdueMoviesClearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String movieId = OverdueMovieMovieIDtxt.getText();
				String lentTo = OverdueMovieLentTotxt.getText();
				String moviename = OverdueMovieMovieNametxt.getText();
				String daysOverdue = OverdueMovieDaysOverduetxt.getText();
				String charge = OverdueMovieChargetxt.getText();
				
				if((movieId.isBlank() == false) && (lentTo.isBlank() == false) && (moviename.isBlank() == false)
						&& (daysOverdue.isBlank() == false) && (charge.isBlank() == false)) {
					
					lblOverdueMoviesErrors.setText("");
					JOptionPane.showMessageDialog(null, "Demand Ksh "+charge+" from the customer");
					
					if((daysOverdue.equals("14"))){
						 try {
				    			Connection conn = DriverManager.getConnection(databaseURL);
				    			String query = "INSERT INTO Damaged_Movies (Movie_ID, Lent_To, Movie_Name, Charge) "
				    						 + "VALUES ('"+movieId+"', '"+lentTo+"', '"+moviename+"', 700)";
				    			PreparedStatement pst = conn.prepareStatement(query);
				    			pst.executeUpdate();
				    			JOptionPane.showMessageDialog(null, "Movie Added to the list of Damaged Movies");
				    			pst.close();
				    			conn.close();
				    		} catch (SQLException e1) {
				    			JOptionPane.showMessageDialog(null, "Customer not Cleared");
				    		}
						 try {
								Connection conn = DriverManager.getConnection(databaseURL);
								
								String query = "DELETE FROM Overdue_Movies "
											 + "WHERE Movie_ID = '"+movieId+"' AND Lent_To = '"+lentTo+"'";
											
								PreparedStatement pst = conn.prepareStatement(query);
								pst.executeUpdate();
								pst.close();
				    			conn.close();
				    			
				    			JOptionPane.showMessageDialog(null, "Customer Cleared");
				    			String tablefrom = "Overdue_Movies";
								btnDatabaseViewer(OverDueMoviesTable, tablefrom);
								overdueMoviesTableLayout();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Customer not Cleared");
							}
					} else {
						try {
							Connection conn = DriverManager.getConnection(databaseURL);
							
							String query = "DELETE FROM Overdue_Movies "
										 + "WHERE Movie_ID = '"+movieId+"' AND Lent_To = '"+lentTo+"'";
										
							PreparedStatement pst = conn.prepareStatement(query);
							pst.executeUpdate();
							pst.close();
			    			conn.close();
			    			
			    			JOptionPane.showMessageDialog(null, "Customer Cleared");
			    			String tablefrom = "Overdue_Movies";
							btnDatabaseViewer(OverDueMoviesTable, tablefrom);
							overdueMoviesTableLayout();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Customer not Cleared");
						}
					}	
				} else {
					lblOverdueMoviesErrors.setText("Please select a record from the table");
				}
			}
		});
		OverdueMoviesClearbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMoviesClearbtn.setBounds(265, 319, 98, 23);
		OverdueMoviesPanel.add(OverdueMoviesClearbtn);
		
		JLabel OverdueMovieMovieNamelbl = new JLabel("Movie Name:");
		OverdueMovieMovieNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		OverdueMovieMovieNamelbl.setBounds(20, 259, 71, 24);
		OverdueMoviesPanel.add(OverdueMovieMovieNamelbl);
		
		JLabel lblOverdueMovies = new JLabel("Overdue Movies");
		lblOverdueMovies.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverdueMovies.setForeground(Color.RED);
		lblOverdueMovies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOverdueMovies.setBounds(10, 11, 609, 21);
		OverdueMoviesPanel.add(lblOverdueMovies);
		
		lblOverdueMoviesErrors = new JLabel("");
		lblOverdueMoviesErrors.setForeground(Color.RED);
		lblOverdueMoviesErrors.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverdueMoviesErrors.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOverdueMoviesErrors.setBounds(10, 344, 609, 24);
		OverdueMoviesPanel.add(lblOverdueMoviesErrors);
		
		JScrollPane DamagedMoviesscrollPane = new JScrollPane();
		DamagedMoviesscrollPane.setBounds(10, 33, 609, 158);
		DamagedMoviesPanel.add(DamagedMoviesscrollPane);
		
		DamagedMoviesTable = new JTable();
		DamagedMoviesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DamagedMoviesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = DamagedMoviesTable.getSelectedRow();
				String movieId = String.valueOf(DamagedMoviesTable.getValueAt(row, 0));
				String lentTo = String.valueOf(DamagedMoviesTable.getValueAt(row, 1));
				String moviename = String.valueOf(DamagedMoviesTable.getValueAt(row, 2));
				int charge = Integer.parseInt(String.valueOf(DamagedMoviesTable.getValueAt(row, 3)));
				String charge1 = String.valueOf(charge);
				
				DamagedMovieMovieIDtxt.setText(movieId);
				DamagedMovieMovieNametxt.setText(lentTo);
				DamagedMovieLentTotxt.setText(moviename);
				DamagedMovieChargetxt.setText(charge1);
			}
		});
		DamagedMoviesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie_ID", "Lent_To", "Movie_Name", "Charge"
			}
		));
		DamagedMoviesTable.getColumnModel().getColumn(0).setPreferredWidth(66);
		DamagedMoviesTable.getColumnModel().getColumn(1).setPreferredWidth(55);
		DamagedMoviesTable.getColumnModel().getColumn(2).setPreferredWidth(121);
		DamagedMoviesTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		DamagedMoviesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DamagedMoviesTable.setRowHeight(20);
		DamagedMoviesscrollPane.setViewportView(DamagedMoviesTable);
		DamagedMoviesTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel DamagedMoviesClearDebtlbl = new JLabel("Clear Debt");
		DamagedMoviesClearDebtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		DamagedMoviesClearDebtlbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		DamagedMoviesClearDebtlbl.setBounds(10, 202, 609, 24);
		DamagedMoviesPanel.add(DamagedMoviesClearDebtlbl);
		
		JLabel DamagedMovieMovieIDlbl = new JLabel("Movie ID:");
		DamagedMovieMovieIDlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieMovieIDlbl.setBounds(20, 237, 71, 24);
		DamagedMoviesPanel.add(DamagedMovieMovieIDlbl);
		
		DamagedMovieMovieIDtxt = new JTextField();
		DamagedMovieMovieIDtxt.setBackground(Color.WHITE);
		DamagedMovieMovieIDtxt.setEditable(false);
		DamagedMovieMovieIDtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieMovieIDtxt.setColumns(10);
		DamagedMovieMovieIDtxt.setBounds(101, 240, 190, 21);
		DamagedMoviesPanel.add(DamagedMovieMovieIDtxt);
		
		JLabel DamagedMovieMovieNamelbl = new JLabel("Movie Name:");
		DamagedMovieMovieNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieMovieNamelbl.setBounds(20, 262, 71, 24);
		DamagedMoviesPanel.add(DamagedMovieMovieNamelbl);
		
		DamagedMovieMovieNametxt = new JTextField();
		DamagedMovieMovieNametxt.setBackground(Color.WHITE);
		DamagedMovieMovieNametxt.setEditable(false);
		DamagedMovieMovieNametxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieMovieNametxt.setColumns(10);
		DamagedMovieMovieNametxt.setBounds(101, 265, 190, 21);
		DamagedMoviesPanel.add(DamagedMovieMovieNametxt);
		
		JLabel DamagedMovieLentTolbl = new JLabel("Lent To:");
		DamagedMovieLentTolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieLentTolbl.setBounds(321, 237, 78, 24);
		DamagedMoviesPanel.add(DamagedMovieLentTolbl);
		
		DamagedMovieLentTotxt = new JTextField();
		DamagedMovieLentTotxt.setBackground(Color.WHITE);
		DamagedMovieLentTotxt.setEditable(false);
		DamagedMovieLentTotxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieLentTotxt.setColumns(10);
		DamagedMovieLentTotxt.setBounds(399, 239, 209, 21);
		DamagedMoviesPanel.add(DamagedMovieLentTotxt);
		
		JButton DamagedMoviesClearChargebtn = new JButton("Clear Charge");
		DamagedMoviesClearChargebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String movieId = DamagedMovieMovieIDtxt.getText();
				String lentTo = DamagedMovieMovieNametxt.getText();
				String moviename = DamagedMovieLentTotxt.getText();
				String charge = DamagedMovieChargetxt.getText();
				
				if((movieId.isBlank() == false) && (lentTo.isBlank() == false) && (moviename.isBlank() == false) && (charge.isBlank() == false)) {
					
					DamagedMoviesErrorslbl.setText("");
					JOptionPane.showMessageDialog(null, "Demand Ksh "+charge+" from the customer");
					
					try {
						Connection conn = DriverManager.getConnection(databaseURL);
						
						String query = "DELETE FROM Damaged_Movies "
									 + "WHERE Movie_ID = '"+movieId+"' AND Lent_To = '"+lentTo+"'";
										
						PreparedStatement pst = conn.prepareStatement(query);
						pst.executeUpdate();
						pst.close();
			    		conn.close();
			    		JOptionPane.showMessageDialog(null, "Customer Cleared");
			    		
			    		String tablefrom = "Damaged_Movies";
						btnDatabaseViewer(DamagedMoviesTable, tablefrom);
						damagedMoviesTableLayout();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Customer not Cleared");
					}
				} else {
					DamagedMoviesErrorslbl.setText("Please select a record from the table");
				}
			}
		});
		DamagedMoviesClearChargebtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMoviesClearChargebtn.setBounds(253, 297, 122, 23);
		DamagedMoviesPanel.add(DamagedMoviesClearChargebtn);
		
		JLabel DamagedMovieChargelbl = new JLabel("Charge:");
		DamagedMovieChargelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieChargelbl.setBounds(321, 262, 78, 24);
		DamagedMoviesPanel.add(DamagedMovieChargelbl);
		
		DamagedMovieChargetxt = new JTextField();
		DamagedMovieChargetxt.setBackground(Color.WHITE);
		DamagedMovieChargetxt.setEditable(false);
		DamagedMovieChargetxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DamagedMovieChargetxt.setColumns(10);
		DamagedMovieChargetxt.setBounds(399, 265, 209, 21);
		DamagedMoviesPanel.add(DamagedMovieChargetxt);
		
		JLabel lblDamagedMovies = new JLabel("Damaged Movies");
		lblDamagedMovies.setForeground(Color.RED);
		lblDamagedMovies.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamagedMovies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDamagedMovies.setBounds(10, 11, 609, 21);
		DamagedMoviesPanel.add(lblDamagedMovies);
		
		DamagedMoviesErrorslbl = new JLabel("");
		DamagedMoviesErrorslbl.setForeground(Color.RED);
		DamagedMoviesErrorslbl.setHorizontalAlignment(SwingConstants.CENTER);
		DamagedMoviesErrorslbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DamagedMoviesErrorslbl.setBounds(10, 331, 609, 21);
		DamagedMoviesPanel.add(DamagedMoviesErrorslbl);
		
		//Home page
		
		//Sign Up button on the Home Page
		JButton btnLoginSignUp = new JButton("Sign Up");
		btnLoginSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(false);
				CreateAccount.setVisible(true);
			}
		});
		btnLoginSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLoginSignUp.setBounds(688, 36, 100, 23);
		HomePage.add(btnLoginSignUp);
		
		JLabel lblUpepeo = new JLabel("UPEPEO VIDEO LENDING CLUB");
		lblUpepeo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpepeo.setBounds(10, 11, 260, 23);
		HomePage.add(lblUpepeo);
		
		JLabel lblLogin = new JLabel("Login ");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(391, 220, 73, 28);
		HomePage.add(lblLogin);
		
		JLabel lblSignUpIndicator = new JLabel("Don't Have an Account Yet?");
		lblSignUpIndicator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSignUpIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpIndicator.setBounds(616, 11, 229, 23);
		HomePage.add(lblSignUpIndicator);
		
		JTabbedPane tabSignIn = new JTabbedPane(JTabbedPane.TOP);
		tabSignIn.setBorder(null);
		tabSignIn.setBounds(191, 248, 473, 163);
		HomePage.add(tabSignIn);
		
		JPanel User = new JPanel();
		User.setBorder(null);
		tabSignIn.addTab("User", null, User, null);
		User.setLayout(null);
		
		JLabel lblUserEmail = new JLabel("Email Address:");
		lblUserEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserEmail.setBounds(35, 23, 81, 23);
		User.add(lblUserEmail);
		
		useremail = new JTextField();
		useremail.setDocument(new JTextFieldLimit(30));
		useremail.setColumns(10);
		useremail.setBounds(126, 21, 287, 25);
		User.add(useremail);
		
		JLabel lblUserPassword = new JLabel("Password:");
		lblUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserPassword.setBounds(35, 57, 81, 23);
		User.add(lblUserPassword);
		
		userpass = new JPasswordField();
		userpass.setDocument(new JTextFieldLimit(20));
		userpass.setBounds(126, 55, 287, 25);
		User.add(userpass);
		
		JButton btnUserSignIn = new JButton("Sign In");
		btnUserSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(databaseURL);
					String query = "SELECT Membership_ID, Email_Address, Password FROM Members";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.executeQuery();
					ResultSet rs1  = pst.executeQuery();
					
					while(rs1.next()){ 
						
						//Obtain email address and password from the database
						String email = useremail.getText();
						String Email_Address = rs1.getString("Email_Address"); 
						String password = rs1.getString("Password");
						String memberId = rs1.getString("Membership_ID");
						
						//assignment of the passwords into arrays
						char[] a = userpass.getPassword();
						char[] b = password.toCharArray();
						
						//if the arrays containing the passwords are equal and is the email typed and that in the database are equal
						if((Arrays.equals(a, b)) && (email.equals(Email_Address))){
							HomePage.setVisible(false);
							SiteHome.setVisible(true);
							useremail.setText("");
							userpass.setText("");
							lblComedyMemberID.setText(memberId);
							lblGeneralMemberID.setText(memberId);
							lblHorrorMemberID.setText(memberId);
							lblThrillerMemberID.setText(memberId);
							lblCartoonMemberID.setText(memberId);
							lblUserMovieSearchMemberID.setText(memberId);
							break;
						} else if (rs1.isLast()){
							JOptionPane.showMessageDialog(null, "Invalid Email Address or Password");
						}
					
					}
					rs1.close();
					conn.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnUserSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUserSignIn.setBounds(199, 91, 89, 28);
		User.add(btnUserSignIn);
		
		JPanel Administrator = new JPanel();
		Administrator.setBorder(null);
		tabSignIn.addTab("Administrator", null, Administrator, null);
		Administrator.setLayout(null);
		
		JLabel lblAdminID = new JLabel("ID Number:");
		lblAdminID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdminID.setBounds(34, 23, 81, 23);
		Administrator.add(lblAdminID);
		
		adminid = new JTextField();
		adminid.setDocument(new JTextFieldLimit(8));
		adminid.setColumns(10);
		adminid.setBounds(125, 21, 287, 25);
		Administrator.add(adminid);
		
		JLabel lblAdminPassword = new JLabel("Password:");
		lblAdminPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdminPassword.setBounds(34, 57, 81, 23);
		Administrator.add(lblAdminPassword);
		
		adminpass = new JPasswordField();
		adminpass.setDocument(new JTextFieldLimit(20));
		adminpass.setBounds(125, 57, 287, 23);
		Administrator.add(adminpass);
		
		JButton btnAdminSignIn = new JButton("Sign In");
		btnAdminSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(databaseURL);
					String query = "SELECT ID_Number, Password FROM Administrators";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.executeQuery();
					ResultSet rs1  = pst.executeQuery();
					
					while(rs1.next()){ 
						
						//Obtain email address and password from the database
						String ID = adminid.getText();
						String IDNumber = rs1.getString("ID_Number"); 
						String password = rs1.getString("Password");
						
						//assignment of the passwords into arrays
						char[] a = adminpass.getPassword();
						char[] b = password.toCharArray();
						
						//if the arrays containing the passwords are equal and is the email typed and that in the database are equal
						if((Arrays.equals(a, b)) && (ID.equals(IDNumber))){
							HomePage.setVisible(false);
							Admin.setVisible(true);
							String tablefrom = "EntireMovieDatabase";
							btnDatabaseViewer(AdminMovieCatalog, tablefrom);
							lblMovieCatalog.setText("Entire Movie Catalog");
							AdminMovieCatalog.getColumnModel().getColumn(0).setPreferredWidth(80);
							AdminMovieCatalog.getColumnModel().getColumn(1).setPreferredWidth(219);
							AdminMovieCatalog.getColumnModel().getColumn(2).setPreferredWidth(174);
							AdminMovieCatalog.getColumnModel().getColumn(3).setPreferredWidth(93);
							AdminMovieCatalog.getColumnModel().getColumn(4).setPreferredWidth(58);
							AdminMovieCatalog.getColumnModel().getColumn(5).setPreferredWidth(55);
							AdminMovieCatalog.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							adminid.setText("");
							adminpass.setText("");
							break;
						} else if (rs1.isLast()){
							JOptionPane.showMessageDialog(null, "Invalid ID Number or Password");
						}
					
					}
					rs1.close();
					conn.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnAdminSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdminSignIn.setBounds(199, 91, 89, 28);
		Administrator.add(btnAdminSignIn);
		
		//"CREATEACCOUNT" Panel
		
		//Labels
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(49, 137, 101, 26);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(49, 175, 101, 26);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(49, 214, 101, 26);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblPhoneNumber);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setBounds(49, 257, 101, 26);
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblEmailAddress);
		
		JLabel lbl_ID_Number = new JLabel("ID Number:");
		lbl_ID_Number.setBounds(49, 300, 101, 26);
		lbl_ID_Number.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lbl_ID_Number);
		
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setBounds(49, 341, 101, 26);
		lblOccupation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblOccupation);
		
		JLabel lblResidentialAddress = new JLabel("Residential Address:");
		lblResidentialAddress.setBounds(415, 174, 122, 26);
		lblResidentialAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblResidentialAddress);
		
		JLabel lblJoiningDate = new JLabel("Date of Joining:");
		lblJoiningDate.setBounds(415, 213, 122, 26);
		lblJoiningDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblJoiningDate);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(415, 257, 122, 26);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateAccount.add(lblPassword);
		
		JLabel lblCreateAccount = new JLabel("CREATE ACCOUNT");
		lblCreateAccount.setBounds(301, 21, 209, 28);
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		CreateAccount.add(lblCreateAccount);
		
		//Text Fields in the "CreateAccount" Panel
		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstname.setDocument(new JTextFieldLimit(20));
		firstname.setBounds(153, 137, 241, 26);
		CreateAccount.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastname.setDocument(new JTextFieldLimit(20));
		lastname.setBounds(153, 175, 241, 26);
		lastname.setColumns(10);
		CreateAccount.add(lastname);
		
		phonenumber = new JTextField();
		phonenumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phonenumber.setDocument(new JTextFieldLimit(10));
		phonenumber.setBounds(153, 214, 241, 26);
		phonenumber.setColumns(10);
		CreateAccount.add(phonenumber);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setDocument(new JTextFieldLimit(30));
		email.setBounds(153, 257, 241, 26);
		email.setColumns(10);
		CreateAccount.add(email);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id.setDocument(new JTextFieldLimit(8));
		id.setBounds(153, 300, 241, 26);
		id.setColumns(10);
		CreateAccount.add(id);
		
		residential = new JTextField();
		residential.setFont(new Font("Tahoma", Font.PLAIN, 12));
		residential.setDocument(new JTextFieldLimit(20));
		residential.setBounds(541, 174, 231, 26);
		residential.setColumns(10);
		CreateAccount.add(residential);
		
		occupation = new JTextField();
		occupation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		occupation.setDocument(new JTextFieldLimit(20));
		occupation.setBounds(154, 341, 240, 26);
		occupation.setColumns(10);
		CreateAccount.add(occupation);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass.setDocument(new JTextFieldLimit(20));
		pass.setBounds(541, 257, 231, 26);
		CreateAccount.add(pass);
		
		confirmpass = new JPasswordField();
		confirmpass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		confirmpass.setDocument(new JTextFieldLimit(20));
		confirmpass.setBounds(541, 300, 231, 26);
		CreateAccount.add(confirmpass);
		
		//Buttons in the "CreateAccount" Panel
		final JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get user input
				String f_name = firstname.getText();
				String l_name = lastname.getText();
				String phoneNumber = phonenumber.getText();
				String Email = email.getText();
				String idNumber = id.getText();
				String gender = (String)comboGender.getSelectedItem();
				String job = occupation.getText();
				String place = residential.getText();
				Date dateofjoining = joiningdate.getDate();
				
				//If all fields are filled but final password is not yet assigned
				if((f_name.isBlank() == false) && (l_name.isBlank() == false) && (phoneNumber.isBlank() == false) && (Email.isBlank() == false)
					&& (idNumber.isBlank() == false) && (job.isBlank() == false) && (gender != null) && (place.isBlank() == false)
					&& (((pass.getPassword()).length) != 0) && (((confirmpass.getPassword()).length) != 0) && (dateofjoining != null)) {
						
						//Check that the passwords in "password"and "confirm password" are the same
						if(passwordChecker(pass, confirmpass) == true) {
							lblErrors.setText("");
							TermsAndConditions.setVisible(true);
							CreateAccount.setVisible(false);
																					
						} else {
							
							//If passwords are not the same
							lblErrors.setText("Contrasting password entries!");
							pass.setText(null);
							confirmpass.setText(null);
						}
						} 
				else {
					lblErrors.setText("Please fill in all the fields!");
				}
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateAccount.setBounds(238, 448, 166, 29);
		CreateAccount.add(btnCreateAccount);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
				lblErrors.setText("");
				HomePage.setVisible(true);
				CreateAccount.setVisible(false);
			}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnback.setBounds(414, 448, 166, 29);
		CreateAccount.add(btnback);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(366, 408, 89, 29);
		CreateAccount.add(btnClear);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(415, 300, 122, 26);
		CreateAccount.add(lblConfirmPassword);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(415, 137, 122, 26);
		CreateAccount.add(lblGender);
		
		lblErrors = new JLabel("");
		lblErrors.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrors.setForeground(Color.RED);
		lblErrors.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrors.setBackground(SystemColor.menu);
		lblErrors.setBounds(415, 341, 357, 26);
		CreateAccount.add(lblErrors);
		
		comboGender = new JComboBox<String>();
		comboGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboGender.setForeground(Color.BLACK);
		comboGender.setBackground(Color.WHITE);
		comboGender.setBounds(541, 137, 231, 26);
		CreateAccount.add(comboGender);
		comboGender.addItem("Male");
		comboGender.addItem("Female");
		comboGender.setSelectedItem(null);
		
		joiningdate = new JDateChooser();
		joiningdate.setBounds(541, 214, 231, 26);
		CreateAccount.add(joiningdate);
		long currentTime = System.currentTimeMillis();
		Date currentDate = new Date(currentTime);
		joiningdate.setMaxSelectableDate(currentDate);
		joiningdate.setMinSelectableDate(currentDate);
		joiningdate.setDate(currentDate);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) joiningdate.getDateEditor();
		editor.setEditable(false);
		editor.setBackground(Color.WHITE);
		
		JLabel lblWarning = new JLabel("* To Register, you must pay a registration fee of 5000 shillings");
		lblWarning.setForeground(Color.BLUE);
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWarning.setBounds(171, 60, 468, 26);
		CreateAccount.add(lblWarning);
		
		//"Terms and Conditions" Panel
		
		JLabel lblTerms_And_Conditions = new JLabel("Terms And Conditions");
		lblTerms_And_Conditions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTerms_And_Conditions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerms_And_Conditions.setBounds(10, 11, 197, 25);
		TermsAndConditions.add(lblTerms_And_Conditions);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount.setVisible(true);
				TermsAndConditions.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(752, 464, 93, 25);
		TermsAndConditions.add(btnBack);
		
		
		JButton btnIAgree = new JButton("I Agree");
		btnIAgree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get user input
				String firstName = firstname.getText();
				String lastName = lastname.getText();
				String phoneNumber = phonenumber.getText();
				String Email = email.getText();
				String idNumber = id.getText();
				String gender = (String)comboGender.getSelectedItem();
				String job = occupation.getText();
				String place = residential.getText();
				String view = "User";				
				char[] password = null;
				
				password = confirmpass.getPassword();
				String passfinal = new String(password);
				lblErrors.setText("");
				TermsAndConditions.setVisible(true);
				CreateAccount.setVisible(false);
				
				insertIntoMembers(Email, idNumber, firstName, lastName, phoneNumber, job, place, passfinal, gender, joiningdate, lblErrors, view);
			
			}
		});
		btnIAgree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIAgree.setBounds(649, 464, 93, 25);
		TermsAndConditions.add(btnIAgree);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 835, 406);
		TermsAndConditions.add(scrollPane);
		
		JTextPane txtpnPleaseReadThese = new JTextPane();
		txtpnPleaseReadThese.setEditable(false);
		scrollPane.setViewportView(txtpnPleaseReadThese);
		txtpnPleaseReadThese.setText("Please read these terms and conditions carefully before using Our Service.\r\n\r\nInterpretation and Definitions\r\n\r\nInterpretation\r\nThe words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.\r\nDefinitions\r\nFor the purposes of these Terms and Conditions:\r\n\u2022    Affiliate means an entity that controls, is controlled by or is under common control with a party, where \"control\" means ownership of 50% or more of the shares, equity interest or ther securities entitled to vote for election of directors or other managing authority.\r\n\u2022    Country refers to: Kenya\r\n\u2022    Company (referred to as either \"the Company\", \"We\", \"Us\" or \"Our\" in this agreement) refers to UpepeoVideoLending.com.\r\n\u2022    Device means any device that can access the Service such as a computer, a cellphone or a digital tablet.\r\n\u2022    Service refers to the Website.\r\n\u2022    Terms and Conditions (also referred as \"Terms\") mean these Terms and Conditions that form the entire agreement between You and the Company regarding the use of the \tService. This Terms and Conditions agreement has been created with the help of the Terms and Conditions Generator.\r\n\u2022    Third-party Social Media Service means any services or content (including data, information, products or services) provided by a third-party that may be displayed, included or made available by the Service.\r\n\u2022    Website refers to UpepeoVideoLending.com, accessible from http://www.UpepeoVideoLending.com\r\n\u2022    You means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.\r\n\r\nAcknowledgment\r\nThese are the Terms and Conditions governing the use of this Service and the agreement that operates between You and the Company. These Terms and Conditions \tset out the rights and obligations of all users regarding the use of the Service.\r\nYour access to and use of the Service is conditioned on Your acceptance of and compliance with these Terms and Conditions. These Terms and Conditions apply to all visitors, users and others who access or use the Service.\r\nBy accessing or using the Service You agree to be bound by these Terms and Conditions. If You disagree with any part of these Terms and Conditions then You may not access the Service.\r\nYou represent that you are over the age of 18. The Company does not permit those under 18 to use the Service.\r\nYour access to and use of the Service is also conditioned on Your acceptance of and compliance with the Privacy Policy of the Company. Our Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your personal information when You use the Application or the Website and tells You about Your privacy rights and how the law protects You. Please read Our Privacy Policy carefully before using Our Service.\r\n\r\nLinks to Other Websites\r\nOur Service may contain links to third-party web sites or services that are not owned or controlled by the Company.\r\nThe Company has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that the Company shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with the use of or reliance on any such content, goods or services available on or through any such web sites or services.\r\nWe strongly advise You to read the terms and conditions and privacy policies of any third-party web sites or services that You visit.\r\n\r\nTermination\r\nWe may terminate or suspend Your access immediately, without prior notice or liability, for any reason whatsoever, including without limitation if You breach these Terms and Conditions.\r\nUpon termination, Your right to use the Service will cease immediately.\r\n\r\nLimitation of Liability\r\nNotwithstanding any damages that You might incur, the entire liability of the Company and any of its suppliers under any provision of this Terms and Your exclusive remedy for all of the foregoing shall be limited to the amount actually paid by You through the Service or 100 USD if You haven't purchased anything through the Service.\r\nTo the maximum extent permitted by applicable law, in no event shall the Company or its suppliers be liable for any special, incidental, indirect, or consequential damages whatsoever (including, but not limited to, damages for loss of profits, loss of data or other information, for business interruption, for personal injury, loss of privacy arising out of or in any way related to the use of or inability to use the Service, third-party software and/or third-party hardware used with the Service, or otherwise in connection with any provision of this Terms), even if the Company or any supplier has been advised of the possibility of such damages and even if the remedy fails of its essential purpose.\r\nSome states do not allow the exclusion of implied warranties or limitation of liability for incidental or consequential damages, which means that some of the above limitations may not apply. In these states, each party's liability will be limited to the greatest extent permitted by law.\r\n\r\n\"AS IS\" and \"AS AVAILABLE\" Disclaimer\r\nThe Service is provided to You \"AS IS\" and \"AS AVAILABLE\" and with all faults and defects without warranty of any kind. To the maximum extent permitted under applicable law, the Company, on its own behalf and on behalf of its Affiliates and its and their respective licensors and service providers, expressly disclaims all warranties, whether express, implied, statutory or otherwise, with respect to the Service, including all implied warranties of merchantability, fitness for a particular purpose, title and non-infringement, and warranties that may arise out of course of dealing, course of performance, usage or trade practice. Without limitation to the foregoing, the Company provides no warranty or undertaking, and makes no representation of any kind that the Service will meet Your requirements, achieve any intended results, be compatible or work with any other software, applications, systems or services, operate without interruption, meet any performance or reliability standards or be error free or that any errors or defects can or will be corrected.\r\nWithout limiting the foregoing, neither the Company nor any of the company's provider makes any representation or warranty of any kind, express or implied: (i) as to the operation or availability of the Service, or the information, content, and materials or products included thereon; (ii) that the Service will be uninterrupted or error-free; (iii) as to the accuracy, reliability, or currency of any information or content provided through the Service; or (iv) that the Service, its servers, the content, or e-mails sent from or on behalf of the Company are free of viruses, scripts, trojan horses, worms, malware, timebombs or other harmful components.\r\nSome jurisdictions do not allow the exclusion of certain types of warranties or limitations on applicable statutory rights of a consumer, so some or all of the above exclusions and limitations may not apply to You. But in such a case the exclusions and limitations set forth in this section shall be applied to the greatest extent enforceable under applicable law.\r\n\r\nGoverning Law\r\nThe laws of the Country, excluding its conflicts of law rules, shall govern this Terms and Your use of the Service. Your use of the Application may also be subject to other local, state, national, or international laws.\r\n\r\nDisputes Resolution\r\nIf You have any concern or dispute about the Service, You agree to first try to resolve the dispute informally by contacting the Company.\r\n\r\nFor European Union (EU) Users\r\nIf You are a European Union consumer, you will benefit from any mandatory provisions of the law of the country in which you are resident in.\r\n\r\nUnited States Legal Compliance\r\nYou represent and warrant that (i) You are not located in a country that is subject to the United States government embargo, or that has been designated by the United States government as a \"terrorist supporting\" country, and (ii) You are not listed on any United States government list of prohibited or restricted parties.\r\n\r\nSeverability and Waiver\r\n\r\nSeverability\r\nIf any provision of these Terms is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.\r\n\r\nWaiver\r\nExcept as provided herein, the failure to exercise a right or to require performance of an obligation under this Terms shall not effect a party's ability to exercise such right or require such performance at any time thereafter nor shall be the waiver of a breach constitute a waiver of any subsequent breach.\r\n\r\nTranslation Interpretation\r\nThese Terms and Conditions may have been translated if We have made them available to You on our Service. You agree that the original English text shall prevail in the case of a dispute.\r\n\r\nChanges to These Terms and Conditions\r\nWe reserve the right, at Our sole discretion, to modify or replace these Terms at any time. If a revision is material We will make reasonable efforts to provide at least 30 days' notice prior to any new terms taking effect. What constitutes a material change will be determined at Our sole discretion.\r\nBy continuing to access or use Our Service after those revisions become effective, You agree to be bound by the revised terms. If You do not agree to the new terms, in whole or in part, please stop using the website and the Service.\r\nContact Us\r\nIf you have any questions about these Terms and Conditions, You can contact us:\r\n\u2022    By email: UpepeoVideoLending@gmail.com\r\n\r\n");
		txtpnPleaseReadThese.setFont(new Font("Tahoma", Font.PLAIN, 13));
		

		//"SiteHome" Panel
		
		//Back button from the Site home to  the Home-page 
		JButton btnSiteHome_Back = new JButton("Back");
		btnSiteHome_Back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			HomePage.setVisible(true);
			SiteHome.setVisible(false);
		}
		});
		btnSiteHome_Back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSiteHome_Back.setBounds(379, 446, 89, 30);
		SiteHome.add(btnSiteHome_Back);
		Comedy.setLayout(null);
				
		JLabel lblUPEPEO = new JLabel("UPEPEO");
		lblUPEPEO.setBounds(185, 45, 471, 146);
		lblUPEPEO.setFont(new Font("Old English Text MT", Font.BOLD, 90));
		lblUPEPEO.setHorizontalAlignment(SwingConstants.CENTER);
		SiteHome.add(lblUPEPEO);
		
		//"search" Text field on the Site Home
		txtSiteHomeSearch = new JTextField();
		txtSiteHomeSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSiteHomeSearch.setBounds(158, 218, 446, 30);
		SiteHome.add(txtSiteHomeSearch);
		txtSiteHomeSearch.setColumns(10);
		
		JButton btnSiteHomeSearch = new JButton("Search");
		btnSiteHomeSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String searchHome = txtSiteHomeSearch.getText();
				if(searchHome.isBlank() == true) {
					txtSiteHomeSearch.setForeground(Color.LIGHT_GRAY);
					txtSiteHomeSearch.setText("Entire Movie Catalogue");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String searchHome = txtSiteHomeSearch.getText();
				if(searchHome.contains("Entire Movie Catalogue")) {
					txtSiteHomeSearch.setForeground(Color.BLACK);
					txtSiteHomeSearch.setText("");
				}	
			}
		});
		btnSiteHomeSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String searchHome = txtSiteHomeSearch.getText();
					
					if((searchHome.contains("Entire Movie Catalogue")) == false) {
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM EntireMovieDatabase WHERE Movie_Name = '"+searchHome+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						lblSearchMovie.setText(searchHome);
						SiteHome.setVisible(false);
						UserMovieSearch.setVisible(true);
										
						searchMovieTable.setModel(DbUtils.resultSetToTableModel(rs1));
								
						searchMovieTableLayout();
						
						rs1.close();
						conn.close();
					} else {
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM EntireMovieDatabase";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						lblSearchMovie.setText(searchHome);
						SiteHome.setVisible(false);
						UserMovieSearch.setVisible(true);
										
						searchMovieTable.setModel(DbUtils.resultSetToTableModel(rs1));
						
						searchMovieTableLayout();		
						rs1.close();
						conn.close();
					}
			} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSiteHomeSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSiteHomeSearch.setBounds(601, 215, 89, 35);
		SiteHome.add(btnSiteHomeSearch);
		
		//Links for the Comedy Movie Category 
		JButton btnCOMEDY = new JButton("");
		btnCOMEDY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Comedy";
				btnDatabaseViewer(ComedyTable, tablefrom);
				Comedy.setVisible(true);
				SiteHome.setVisible(false);
				comedyTableLayout();
			}
		});
		Image img = new ImageIcon(getClass().getClassLoader().getResource("Comedy.png")).getImage();
		btnCOMEDY.setIcon(new ImageIcon(img));
		btnCOMEDY.setBounds(39, 299, 89, 91);
		SiteHome.add(btnCOMEDY);
		
		//Click-able label for the Comedy movie category 
				JLabel lblCOMEDY = new JLabel("Comedy");
				lblCOMEDY.setForeground(Color.BLACK);
				lblCOMEDY.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String tablefrom = "Comedy";
						btnDatabaseViewer(ComedyTable, tablefrom);
						Comedy.setVisible(true);
						SiteHome.setVisible(false);
						comedyTableLayout();
					}
					{
						mouseColour(lblCOMEDY);
					}
				});
				lblCOMEDY.setHorizontalAlignment(SwingConstants.CENTER);
				lblCOMEDY.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCOMEDY.setBounds(39, 390, 89, 28);
				SiteHome.add(lblCOMEDY);
		
				
		//Links for the General Movie Category 
		JButton btnGENERAL = new JButton("");
		btnGENERAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "General";
				btnDatabaseViewer(GeneralTable, tablefrom);
				General.setVisible(true);
				SiteHome.setVisible(false);
				generalTableLayout();
			}
		});
		Image gen = new ImageIcon(getClass().getClassLoader().getResource("General.png")).getImage();
		btnGENERAL.setIcon(new ImageIcon(gen));
		btnGENERAL.setBounds(205, 299, 89, 91);
		SiteHome.add(btnGENERAL);
		
		//Click-able label for the general movie category
				JLabel lblGENERAL = new JLabel("General");
				lblGENERAL.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String tablefrom = "General";
						btnDatabaseViewer(GeneralTable, tablefrom);
						General.setVisible(true);
						SiteHome.setVisible(false);
						generalTableLayout();
					}
					{ mouseColour(lblGENERAL); }
				});
				lblGENERAL.setHorizontalAlignment(SwingConstants.CENTER);
				lblGENERAL.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblGENERAL.setBounds(205, 390, 89, 28);
				SiteHome.add(lblGENERAL);
		
				
		//Links for the Horror Movie Category 
		JButton btnHORROR = new JButton("");
		btnHORROR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Horror";
				btnDatabaseViewer(HorrorTable, tablefrom);
				Horror.setVisible(true);
				SiteHome.setVisible(false);
				horrorTableLayout();
			}
		});
		Image hor = new ImageIcon(getClass().getClassLoader().getResource("Horror.png")).getImage();
		btnHORROR.setIcon(new ImageIcon(hor));
		btnHORROR.setBounds(379, 299, 89, 91);
		SiteHome.add(btnHORROR);
		
		//Click-able label for the Horror movie category
				JLabel lblHORROR = new JLabel("Horror");
				lblHORROR.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String tablefrom = "Horror";
						btnDatabaseViewer(HorrorTable, tablefrom);
						Horror.setVisible(true);
						SiteHome.setVisible(false);
						horrorTableLayout();
					}
					{ mouseColour(lblHORROR); }
				});
				lblHORROR.setHorizontalAlignment(SwingConstants.CENTER);
				lblHORROR.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblHORROR.setBounds(379, 390, 89, 28);
				SiteHome.add(lblHORROR);
		
				
		//Links for the Thriller Movie Category 
		JButton btnTHRILLER = new JButton("");
		btnTHRILLER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Thriller";
				btnDatabaseViewer(ThrillerTable, tablefrom);
				Thriller.setVisible(true);
				SiteHome.setVisible(false);
				thrillerTableLayout();
			}
		});
		Image thr = new ImageIcon(getClass().getClassLoader().getResource("Thriller.png")).getImage();
		btnTHRILLER.setIcon(new ImageIcon(thr));
		btnTHRILLER.setBounds(556, 299, 89, 91);
		SiteHome.add(btnTHRILLER);
		
		//Click-able label for the Thriller movie category
				JLabel lblTHRILLER = new JLabel("Thriller");
				lblTHRILLER.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String tablefrom = "Thriller";
						btnDatabaseViewer(ThrillerTable, tablefrom);
						Thriller.setVisible(true);
						SiteHome.setVisible(false);
						thrillerTableLayout();
					}
					{ mouseColour(lblTHRILLER); }
				});
				lblTHRILLER.setHorizontalAlignment(SwingConstants.CENTER);
				lblTHRILLER.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTHRILLER.setBounds(556, 390, 89, 28);
				SiteHome.add(lblTHRILLER);
		
				
		//Links for the Cartoon Movie Category 
		JButton btnCARTOON = new JButton("");
		btnCARTOON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Cartoon";
				btnDatabaseViewer(CartoonTable, tablefrom);
				Cartoon.setVisible(true);
				SiteHome.setVisible(false);
				cartoonTableLayout();
			}
		});
		Image cart = new ImageIcon(getClass().getClassLoader().getResource("Cartoon.png")).getImage();
		btnCARTOON.setIcon(new ImageIcon(cart));
		btnCARTOON.setBounds(724, 299, 89, 91);
		SiteHome.add(btnCARTOON);
		
		//Click-able label for the Cartoon movie category
				JLabel lblCARTOON = new JLabel("Cartoon");
				lblCARTOON.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String tablefrom = "Cartoon";
						btnDatabaseViewer(CartoonTable, tablefrom);
						Cartoon.setVisible(true);
						SiteHome.setVisible(false);
						cartoonTableLayout();
					}
					{ mouseColour(lblCARTOON); }
				});
				lblCARTOON.setHorizontalAlignment(SwingConstants.CENTER);
				lblCARTOON.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCARTOON.setBounds(724, 390, 89, 28);
				SiteHome.add(lblCARTOON);
			
		
		
		
		//Comedy Movie Category Layout
		JLabel lblUPEPEO_COMEDY = new JLabel("UPEPEO");
		lblUPEPEO_COMEDY.setBounds(10, 11, 162, 42);
		lblUPEPEO_COMEDY.setHorizontalAlignment(SwingConstants.LEFT);
		lblUPEPEO_COMEDY.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		Comedy.add(lblUPEPEO_COMEDY);
		
		JTextField txtCOMEDY_SEARCH = new JTextField();
		txtCOMEDY_SEARCH.setForeground(Color.BLACK);
		txtCOMEDY_SEARCH.setBounds(496, 24, 278, 26);
		txtCOMEDY_SEARCH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCOMEDY_SEARCH.setColumns(10);
		Comedy.add(txtCOMEDY_SEARCH);
		
		JButton btnSearchComedy = new JButton("Search");
		btnSearchComedy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String searchHome = txtCOMEDY_SEARCH.getText();
				if(searchHome.isBlank() == true) {
					txtCOMEDY_SEARCH.setForeground(Color.LIGHT_GRAY);
					txtCOMEDY_SEARCH.setText("Entire Comedy Catalogue");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String searchHome = txtCOMEDY_SEARCH.getText();
				if(searchHome.contains("Entire Comedy Catalogue")) {
					txtCOMEDY_SEARCH.setForeground(Color.BLACK);
					txtCOMEDY_SEARCH.setText("");
				}	
			}
		});
		btnSearchComedy.setBounds(773, 22, 72, 30);
		btnSearchComedy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String searchHome = txtCOMEDY_SEARCH.getText();
				if((searchHome.contains("Entire Comedy Catalogue")) == false) {
					try {	
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM Comedy WHERE Movie_Name = '"+searchHome+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						SiteHome.setVisible(false);
						Comedy.setVisible(true);
										
						ComedyTable.setModel(DbUtils.resultSetToTableModel(rs1));
								
						comedyTableLayout();
						rs1.close();
						conn.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				} else {
						String tablefrom = "Comedy";
						btnDatabaseViewer(ComedyTable, tablefrom);
						Comedy.setVisible(true);
						SiteHome.setVisible(false);
						comedyTableLayout();
				}
			}
		});
		btnSearchComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Comedy.add(btnSearchComedy);
		
		JLabel lblCOMEDY_PAGE = new JLabel("Borrow the latest Comedies");
		lblCOMEDY_PAGE.setBounds(238, 69, 386, 26);
		lblCOMEDY_PAGE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCOMEDY_PAGE.setFont(new Font("Tahoma", Font.BOLD, 16));
		Comedy.add(lblCOMEDY_PAGE);
		
		//Back button from the Comedy Movie Category to the Site-Home
		JButton btnBackComedy = new JButton("Back");
		btnBackComedy.setBounds(773, 459, 72, 30);
		btnBackComedy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorsComedyBorrowMovie.setText("");
				SiteHome.setVisible(true);
				Comedy.setVisible(false);
			}
		});
		btnBackComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Comedy.add(btnBackComedy);
		
		JScrollPane ComedyscrollPane = new JScrollPane();
		ComedyscrollPane.setBounds(10, 103, 604, 345);
		Comedy.add(ComedyscrollPane);
		
		ComedyTable = new JTable();
		ComedyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ComedyTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = ComedyTable.getSelectedRow();
				String movieId = String.valueOf(ComedyTable.getValueAt(row, 0));
				String moviename = String.valueOf(ComedyTable.getValueAt(row, 1));
				String stock = String.valueOf(ComedyTable.getValueAt(row, 5));
								
				txtMovieIDComedy.setText(movieId);
				txtMovieNameComedy.setText(moviename);
				txtStockComedyTable.setText(stock);
				
			}
		});
		ComedyTable.setBackground(Color.WHITE);
		ComedyTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ComedyTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Movie ID", "Movie Name", "Production Company", "Release Date", "Rating", "Stock"
			}
		));
		ComedyTable.getColumnModel().getColumn(0).setPreferredWidth(61);
		ComedyTable.getColumnModel().getColumn(1).setPreferredWidth(142);
		ComedyTable.getColumnModel().getColumn(2).setPreferredWidth(196);
		ComedyTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ComedyTable.getColumnModel().getColumn(4).setPreferredWidth(57);
		ComedyTable.getColumnModel().getColumn(5).setPreferredWidth(52);
		ComedyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ComedyTable.setBorder(null);
		ComedyTable.setRowHeight(20);
		ComedyscrollPane.setViewportView(ComedyTable);
		
		JPanel ComedyBorrowMovie = new JPanel();
		ComedyBorrowMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ComedyBorrowMovie.setBounds(624, 101, 221, 347);
		Comedy.add(ComedyBorrowMovie);
		ComedyBorrowMovie.setLayout(null);
		
		JLabel lblBorrowComedy = new JLabel("Borrow Comedy");
		lblBorrowComedy.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowComedy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowComedy.setBounds(10, 33, 201, 26);
		ComedyBorrowMovie.add(lblBorrowComedy);
		
		JLabel lblMovieIDComedy = new JLabel("Movie ID:");
		lblMovieIDComedy.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieIDComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDComedy.setBounds(10, 70, 201, 20);
		ComedyBorrowMovie.add(lblMovieIDComedy);
		
		JLabel lblMovieNameComedy = new JLabel("Movie Name:");
		lblMovieNameComedy.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieNameComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieNameComedy.setBounds(10, 126, 201, 20);
		ComedyBorrowMovie.add(lblMovieNameComedy);
		
		txtMovieIDComedy = new JTextField();
		txtMovieIDComedy.setBackground(Color.WHITE);
		txtMovieIDComedy.setEditable(false);
		txtMovieIDComedy.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieIDComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDComedy.setBounds(10, 91, 201, 24);
		ComedyBorrowMovie.add(txtMovieIDComedy);
		txtMovieIDComedy.setColumns(10);
		
		txtMovieNameComedy = new JTextField();
		txtMovieNameComedy.setBackground(Color.WHITE);
		txtMovieNameComedy.setEditable(false);
		txtMovieNameComedy.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieNameComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieNameComedy.setColumns(10);
		txtMovieNameComedy.setBounds(10, 146, 201, 26);
		ComedyBorrowMovie.add(txtMovieNameComedy);
		
		JButton btnBorrowComedy = new JButton(" Borrow");
		btnBorrowComedy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String movieId = txtMovieIDComedy.getText();
				int lentTo = Integer.parseInt(lblComedyMemberID.getText());
				String moviename = txtMovieNameComedy.getText();
				int charge = 70;
				String table1 = "Comedy";
				String stock = txtStockComedyTable.getText();
				int stock4 = (stock.isBlank() == true) ? 0 : (Integer.parseInt(stock));
				Date borrowingdate = BorrowComedydateChooser.getDate();
				
				insertToBorrowedMovies(charge, stock4, lentTo, movieId, moviename, borrowingdate, Comedy, txtMovieIDComedy, txtMovieNameComedy, BorrowComedydateChooser, lblErrorsComedyBorrowMovie, table1);
			}
		});
		btnBorrowComedy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowComedy.setBounds(57, 254, 113, 26);
		Image downComedy = new ImageIcon(getClass().getClassLoader().getResource("Download.png")).getImage();
		btnBorrowComedy.setIcon(new ImageIcon(downComedy));
		ComedyBorrowMovie.add(btnBorrowComedy);
		
		lblComedyMemberID = new JLabel("");
		lblComedyMemberID.setVisible(false);
		lblComedyMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		lblComedyMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComedyMemberID.setBounds(10, 11, 201, 20);
		ComedyBorrowMovie.add(lblComedyMemberID);
		
		JLabel lblComedyBorrowingDate = new JLabel("Borrowing Date:");
		lblComedyBorrowingDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblComedyBorrowingDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComedyBorrowingDate.setBounds(10, 185, 201, 20);
		ComedyBorrowMovie.add(lblComedyBorrowingDate);
		
		BorrowComedydateChooser = new JDateChooser();
		BorrowComedydateChooser.setBounds(10, 206, 201, 26);
		ComedyBorrowMovie.add(BorrowComedydateChooser);
		BorrowComedydateChooser.setMaxSelectableDate(currentDate);
		BorrowComedydateChooser.setMinSelectableDate(currentDate);
		BorrowComedydateChooser.setDate(currentDate);
		JTextFieldDateEditor editorComedy = (JTextFieldDateEditor) BorrowComedydateChooser.getDateEditor();
		editorComedy.setEditable(false);
		editorComedy.setBackground(Color.WHITE);
		
		lblErrorsComedyBorrowMovie = new JLabel("");
		lblErrorsComedyBorrowMovie.setForeground(Color.RED);
		lblErrorsComedyBorrowMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsComedyBorrowMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsComedyBorrowMovie.setBounds(10, 291, 201, 20);
		ComedyBorrowMovie.add(lblErrorsComedyBorrowMovie);
		
		txtStockComedyTable = new JTextField();
		txtStockComedyTable.setVisible(false);
		txtStockComedyTable.setEditable(false);
		txtStockComedyTable.setBounds(113, 316, 86, 20);
		ComedyBorrowMovie.add(txtStockComedyTable);
		txtStockComedyTable.setColumns(10);
		
		//General Movie Category Layout
		//Back button from the General Movie Category to the Site-Home
		JButton btnBackGeneral = new JButton("Back");
		btnBackGeneral.setBounds(773, 459, 72, 30);
		btnBackGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorsGeneralBorrowMovie.setText("");
				SiteHome.setVisible(true);
				General.setVisible(false);
			}
		});
		General.setLayout(null);
		btnBackGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		General.add(btnBackGeneral);
		
		JLabel lblUPEPEO_GENERAL = new JLabel("UPEPEO");
		lblUPEPEO_GENERAL.setBounds(10, 11, 159, 40);
		lblUPEPEO_GENERAL.setHorizontalAlignment(SwingConstants.LEFT);
		lblUPEPEO_GENERAL.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		General.add(lblUPEPEO_GENERAL);
		
		JLabel lblGENERAL_PAGE = new JLabel("Borrow the latest General Movies");
		lblGENERAL_PAGE.setBounds(258, 73, 333, 26);
		lblGENERAL_PAGE.setHorizontalAlignment(SwingConstants.CENTER);
		lblGENERAL_PAGE.setFont(new Font("Tahoma", Font.BOLD, 16));
		General.add(lblGENERAL_PAGE);
		
		txtGENERAL_SEARCH = new JTextField();
		txtGENERAL_SEARCH.setBounds(496, 23, 278, 26);
		txtGENERAL_SEARCH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGENERAL_SEARCH.setColumns(10);
		General.add(txtGENERAL_SEARCH);
		
		JButton btnSearchGeneral = new JButton("Search");
		btnSearchGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String searchHome = txtSiteHomeSearch.getText();
				if(searchHome.isBlank() == true) {
					txtGENERAL_SEARCH.setForeground(Color.LIGHT_GRAY);
					txtGENERAL_SEARCH.setText("Entire General Movies Catalogue");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String searchHome = txtGENERAL_SEARCH.getText();
				if(searchHome.contains("Entire General Movies Catalogue")) {
					txtGENERAL_SEARCH.setForeground(Color.BLACK);
					txtGENERAL_SEARCH.setText("");
				}	
			}
		});
		btnSearchGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchHome = txtGENERAL_SEARCH.getText();
				if((searchHome.contains("Entire General Movies Catalogue")) == false) {
					try {	
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM General WHERE Movie_Name = '"+searchHome+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						SiteHome.setVisible(false);
						General.setVisible(true);
										
						GeneralTable.setModel(DbUtils.resultSetToTableModel(rs1));
								
						generalTableLayout();
						rs1.close();
						conn.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				} else {
						String tablefrom = "General";
						btnDatabaseViewer(GeneralTable, tablefrom);
						General.setVisible(true);
						SiteHome.setVisible(false);
						generalTableLayout();
				}
			}
		});
		btnSearchGeneral.setBounds(773, 21, 72, 30);
		btnSearchGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		General.add(btnSearchGeneral);
		
		JScrollPane GeneralscrollPane = new JScrollPane();
		GeneralscrollPane.setBounds(10, 103, 604, 345);
		General.add(GeneralscrollPane);
		
		GeneralTable = new JTable();
		GeneralTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GeneralTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = GeneralTable.getSelectedRow();
				String movieId = String.valueOf(GeneralTable.getValueAt(row, 0));
				String moviename = String.valueOf(GeneralTable.getValueAt(row, 1));
				String stock = String.valueOf(GeneralTable.getValueAt(row, 5));	
				
				txtMovieIDGeneral.setText(movieId);
				txtMovieNameGeneral.setText(moviename);
				txtStockGeneralTable.setText(stock);
			}
		});
		GeneralTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GeneralTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Movie ID", "Movie Name", "Production Company", "Release Date", "Rating", "Stock"
			}
		));
		GeneralTable.getColumnModel().getColumn(0).setPreferredWidth(72);
		GeneralTable.getColumnModel().getColumn(1).setPreferredWidth(148);
		GeneralTable.getColumnModel().getColumn(2).setPreferredWidth(176);
		GeneralTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		GeneralTable.getColumnModel().getColumn(4).setPreferredWidth(51);
		GeneralTable.getColumnModel().getColumn(5).setPreferredWidth(47);
		GeneralTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		GeneralTable.setBorder(null);
		GeneralTable.setRowHeight(20);
		GeneralscrollPane.setViewportView(GeneralTable);
		
		JPanel GeneralBorrowMovie = new JPanel();
		GeneralBorrowMovie.setLayout(null);
		GeneralBorrowMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GeneralBorrowMovie.setBounds(624, 101, 221, 347);
		General.add(GeneralBorrowMovie);
		
		JLabel lblBorrowGeneral = new JLabel("Borrow General");
		lblBorrowGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowGeneral.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowGeneral.setBounds(10, 31, 201, 26);
		GeneralBorrowMovie.add(lblBorrowGeneral);
		
		JLabel lblMovieIDGeneral = new JLabel("Movie ID:");
		lblMovieIDGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieIDGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDGeneral.setBounds(10, 68, 201, 20);
		GeneralBorrowMovie.add(lblMovieIDGeneral);
		
		JLabel lblMovieNameGeneral = new JLabel("Movie Name:");
		lblMovieNameGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieNameGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieNameGeneral.setBounds(10, 124, 201, 20);
		GeneralBorrowMovie.add(lblMovieNameGeneral);
		
		txtMovieIDGeneral = new JTextField();
		txtMovieIDGeneral.setBackground(Color.WHITE);
		txtMovieIDGeneral.setEditable(false);
		txtMovieIDGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieIDGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDGeneral.setColumns(10);
		txtMovieIDGeneral.setBounds(10, 89, 201, 24);
		GeneralBorrowMovie.add(txtMovieIDGeneral);
		
		txtMovieNameGeneral = new JTextField();
		txtMovieNameGeneral.setBackground(Color.WHITE);
		txtMovieNameGeneral.setEditable(false);
		txtMovieNameGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieNameGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieNameGeneral.setColumns(10);
		txtMovieNameGeneral.setBounds(10, 144, 201, 26);
		GeneralBorrowMovie.add(txtMovieNameGeneral);
		
		JButton btnBorrowGeneral = new JButton(" Borrow");
		btnBorrowGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String movieId = txtMovieIDGeneral.getText();
				int lentTo = Integer.parseInt(lblGeneralMemberID.getText());
				String moviename = txtMovieNameGeneral.getText();
				int charge = 50;
				String table1 = "General";
				String stock = txtStockGeneralTable.getText();
				int stock4 = (stock.isBlank() == true) ? 0 : (Integer.parseInt(stock));
				Date borrowingdate = BorrowGeneraldateChooser.getDate();
				
				insertToBorrowedMovies(charge, stock4, lentTo, movieId, moviename, borrowingdate, General, txtMovieIDGeneral, txtMovieNameGeneral, BorrowGeneraldateChooser, lblErrorsGeneralBorrowMovie, table1);
			}
		});
		btnBorrowGeneral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowGeneral.setBounds(46, 244, 132, 26);
		Image downGeneral = new ImageIcon(getClass().getClassLoader().getResource("Download.png")).getImage();
		btnBorrowGeneral.setIcon(new ImageIcon(downGeneral));
		GeneralBorrowMovie.add(btnBorrowGeneral);
		
		lblGeneralMemberID = new JLabel("");
		lblGeneralMemberID.setVisible(false);
		lblGeneralMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneralMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGeneralMemberID.setBounds(10, 11, 201, 20);
		GeneralBorrowMovie.add(lblGeneralMemberID);
		
		JLabel lblGeneralBorrowingDate = new JLabel("Borrowing Date:");
		lblGeneralBorrowingDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneralBorrowingDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGeneralBorrowingDate.setBounds(10, 175, 201, 20);
		GeneralBorrowMovie.add(lblGeneralBorrowingDate);
		
		BorrowGeneraldateChooser = new JDateChooser();
		BorrowGeneraldateChooser.setBounds(10, 196, 201, 26);
		GeneralBorrowMovie.add(BorrowGeneraldateChooser);
		BorrowGeneraldateChooser.setMaxSelectableDate(currentDate);
		BorrowGeneraldateChooser.setMinSelectableDate(currentDate);
		BorrowGeneraldateChooser.setDate(currentDate);
		BorrowGeneraldateChooser.setDate(currentDate);
		JTextFieldDateEditor editorGeneral = (JTextFieldDateEditor) BorrowGeneraldateChooser.getDateEditor();
		editorGeneral.setEditable(false);
		editorGeneral.setBackground(Color.WHITE);
		
		lblErrorsGeneralBorrowMovie = new JLabel("");
		lblErrorsGeneralBorrowMovie.setForeground(Color.RED);
		lblErrorsGeneralBorrowMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsGeneralBorrowMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsGeneralBorrowMovie.setBounds(10, 281, 201, 20);
		GeneralBorrowMovie.add(lblErrorsGeneralBorrowMovie);
		
		txtStockGeneralTable = new JTextField();
		txtStockGeneralTable.setVisible(false);
		txtStockGeneralTable.setEditable(false);
		txtStockGeneralTable.setBounds(125, 316, 86, 20);
		GeneralBorrowMovie.add(txtStockGeneralTable);
		txtStockGeneralTable.setColumns(10);
		
		//Horror Movie Category Layout
		//Back button from the Horror Movie Category to the Site-Home
		JButton btnBackHorror = new JButton("Back");
		btnBackHorror.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorsHorrorBorrowMovie.setText("");
				SiteHome.setVisible(true);
				Horror.setVisible(false);
			}
		});
		btnBackHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackHorror.setBounds(773, 459, 72, 30);
		Horror.add(btnBackHorror);
		
		JLabel lblUPEPEO_HORROR = new JLabel("UPEPEO");
		lblUPEPEO_HORROR.setHorizontalAlignment(SwingConstants.LEFT);
		lblUPEPEO_HORROR.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		lblUPEPEO_HORROR.setBounds(10, 11, 159, 42);
		Horror.add(lblUPEPEO_HORROR);
		
		JLabel lblHORROR_PAGE = new JLabel("Borrow the latest Horror Movies");
		lblHORROR_PAGE.setHorizontalAlignment(SwingConstants.CENTER);
		lblHORROR_PAGE.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHORROR_PAGE.setBounds(263, 71, 330, 26);
		Horror.add(lblHORROR_PAGE);
		
		txtHORROR_SEARCH = new JTextField();
		txtHORROR_SEARCH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHORROR_SEARCH.setColumns(10);
		txtHORROR_SEARCH.setBounds(496, 25, 278, 26);
		Horror.add(txtHORROR_SEARCH);
		
		JButton btnSearchHorror = new JButton("Search");
		btnSearchHorror.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String searchHome = txtHORROR_SEARCH.getText();
				if(searchHome.isBlank() == true) {
					txtHORROR_SEARCH.setForeground(Color.LIGHT_GRAY);
					txtHORROR_SEARCH.setText("Entire Horror Catalogue");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String searchHome = txtHORROR_SEARCH.getText();
				if(searchHome.contains("Entire Horror Catalogue")) {
					txtHORROR_SEARCH.setForeground(Color.BLACK);
					txtHORROR_SEARCH.setText("");
				}	
			}
		});
		btnSearchHorror.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchHome = txtHORROR_SEARCH.getText();
				if((searchHome.contains("Entire Horror Catalogue")) == false) {
					try {	
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM Horror WHERE Movie_Name = '"+searchHome+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						SiteHome.setVisible(false);
						Horror.setVisible(true);
										
						HorrorTable.setModel(DbUtils.resultSetToTableModel(rs1));
								
						horrorTableLayout();
						rs1.close();
						conn.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				} else {
						String tablefrom = "Horror";
						btnDatabaseViewer(HorrorTable, tablefrom);
						Horror.setVisible(true);
						SiteHome.setVisible(false);
						horrorTableLayout();
				}
			}
		});
		btnSearchHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearchHorror.setBounds(773, 23, 72, 30);
		Horror.add(btnSearchHorror);
		
		JScrollPane HorrorScrollPane = new JScrollPane();
		HorrorScrollPane.setBounds(10, 103, 604, 345);
		Horror.add(HorrorScrollPane);
		
		HorrorTable = new JTable();
		HorrorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		HorrorTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = HorrorTable.getSelectedRow();
				String movieId = String.valueOf(HorrorTable.getValueAt(row, 0));
				String moviename = String.valueOf(HorrorTable.getValueAt(row, 1));
				String stock = String.valueOf(HorrorTable.getValueAt(row, 5));
								
				txtMovieIDHorror.setText(movieId);
				txtMovieNameHorror.setText(moviename);
				txtStockHorrorTable.setText(stock);
			}
		});
		HorrorTable.setBackground(Color.WHITE);
		HorrorTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		HorrorTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Movie ID", "Movie Name", "Production Company", "Release Date", "Rating", "Stock"
			}
		));
		HorrorTable.getColumnModel().getColumn(0).setPreferredWidth(71);
		HorrorTable.getColumnModel().getColumn(1).setPreferredWidth(140);
		HorrorTable.getColumnModel().getColumn(2).setPreferredWidth(155);
		HorrorTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		HorrorTable.getColumnModel().getColumn(4).setPreferredWidth(55);
		HorrorTable.getColumnModel().getColumn(5).setPreferredWidth(54);
		HorrorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		HorrorTable.setRowHeight(20);
		HorrorScrollPane.setViewportView(HorrorTable);
		
		JPanel HorrorBorrowMovie = new JPanel();
		HorrorBorrowMovie.setLayout(null);
		HorrorBorrowMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		HorrorBorrowMovie.setBounds(624, 101, 221, 347);
		Horror.add(HorrorBorrowMovie);
		
		JLabel lblBorrowHorror = new JLabel("Borrow Horror");
		lblBorrowHorror.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowHorror.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowHorror.setBounds(10, 30, 201, 26);
		HorrorBorrowMovie.add(lblBorrowHorror);
		
		JLabel lblMovieIDHorror = new JLabel("Movie ID:");
		lblMovieIDHorror.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieIDHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDHorror.setBounds(10, 67, 201, 20);
		HorrorBorrowMovie.add(lblMovieIDHorror);
		
		JLabel lblMovieNameHorror = new JLabel("Movie Name:");
		lblMovieNameHorror.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieNameHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieNameHorror.setBounds(10, 123, 201, 20);
		HorrorBorrowMovie.add(lblMovieNameHorror);
		
		txtMovieIDHorror = new JTextField();
		txtMovieIDHorror.setBackground(Color.WHITE);
		txtMovieIDHorror.setEditable(false);
		txtMovieIDHorror.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieIDHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDHorror.setColumns(10);
		txtMovieIDHorror.setBounds(10, 88, 201, 26);
		HorrorBorrowMovie.add(txtMovieIDHorror);
		
		txtMovieNameHorror = new JTextField();
		txtMovieNameHorror.setBackground(Color.WHITE);
		txtMovieNameHorror.setEditable(false);
		txtMovieNameHorror.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieNameHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieNameHorror.setColumns(10);
		txtMovieNameHorror.setBounds(10, 143, 201, 26);
		HorrorBorrowMovie.add(txtMovieNameHorror);
		
		JButton btnBorrowHorror = new JButton(" Borrow");
		btnBorrowHorror.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String movieId = txtMovieIDHorror.getText();
				int lentTo = Integer.parseInt(lblHorrorMemberID.getText());
				String moviename = txtMovieNameHorror.getText();
				int charge = 40;
				String table1 = "Horror";
				String stock = txtStockHorrorTable.getText();
				int stock4 = (stock.isBlank() == true) ? 0 : (Integer.parseInt(stock));
				Date borrowingdate = BorrowHorrordateChooser.getDate();
				
				insertToBorrowedMovies(charge, stock4, lentTo, movieId, moviename, borrowingdate, Horror, txtMovieIDHorror, txtMovieNameHorror, BorrowHorrordateChooser, lblErrorsHorrorBorrowMovie, table1);
			}
		});
		btnBorrowHorror.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowHorror.setBounds(49, 243, 128, 26);
		Image downHorror = new ImageIcon(getClass().getClassLoader().getResource("Download.png")).getImage();
		btnBorrowHorror.setIcon(new ImageIcon(downHorror));
		HorrorBorrowMovie.add(btnBorrowHorror);
		
		lblHorrorMemberID = new JLabel("");
		lblHorrorMemberID.setVisible(false);
		lblHorrorMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorrorMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHorrorMemberID.setBounds(10, 11, 201, 20);
		HorrorBorrowMovie.add(lblHorrorMemberID);
		
		JLabel lblHorrorBorrowingDate = new JLabel("Borrowing Date:");
		lblHorrorBorrowingDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorrorBorrowingDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHorrorBorrowingDate.setBounds(10, 180, 201, 20);
		HorrorBorrowMovie.add(lblHorrorBorrowingDate);
		
		BorrowHorrordateChooser = new JDateChooser();
		BorrowHorrordateChooser.setBounds(10, 201, 201, 26);
		HorrorBorrowMovie.add(BorrowHorrordateChooser);
		BorrowHorrordateChooser.setMaxSelectableDate(currentDate);
		BorrowHorrordateChooser.setMinSelectableDate(currentDate);
		BorrowHorrordateChooser.setDate(currentDate);
		JTextFieldDateEditor editorHorror = (JTextFieldDateEditor) BorrowHorrordateChooser.getDateEditor();
		editorHorror.setEditable(false);
		editorHorror.setBackground(Color.WHITE);
		
		lblErrorsHorrorBorrowMovie = new JLabel("");
		lblErrorsHorrorBorrowMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsHorrorBorrowMovie.setForeground(Color.RED);
		lblErrorsHorrorBorrowMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsHorrorBorrowMovie.setBounds(10, 280, 201, 20);
		HorrorBorrowMovie.add(lblErrorsHorrorBorrowMovie);
		
		txtStockHorrorTable = new JTextField();
		txtStockHorrorTable.setVisible(false);
		txtStockHorrorTable.setBounds(125, 316, 86, 20);
		HorrorBorrowMovie.add(txtStockHorrorTable);
		txtStockHorrorTable.setColumns(10);
		
		//Thriller Movie Category Layout
		//Back button from the Thriller Movie Category to the Site-Home
		JButton btnBackThriller = new JButton("Back");
		btnBackThriller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorsThrillerBorrowMovie.setText("");
				SiteHome.setVisible(true);
				Thriller.setVisible(false);
			}
		});
		btnBackThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackThriller.setBounds(773, 459, 72, 30);
		Thriller.add(btnBackThriller);
		
		JLabel lblUPEPEO_THRILLER = new JLabel("UPEPEO");
		lblUPEPEO_THRILLER.setHorizontalAlignment(SwingConstants.LEFT);
		lblUPEPEO_THRILLER.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		lblUPEPEO_THRILLER.setBounds(10, 11, 159, 41);
		Thriller.add(lblUPEPEO_THRILLER);
		
		JLabel lblTHRILLER_PAGE = new JLabel("Borrow the latest Thriller Movies");
		lblTHRILLER_PAGE.setHorizontalAlignment(SwingConstants.CENTER);
		lblTHRILLER_PAGE.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTHRILLER_PAGE.setBounds(256, 66, 341, 26);
		Thriller.add(lblTHRILLER_PAGE);
		
		txtTHRILLER_SEARCH = new JTextField();
		txtTHRILLER_SEARCH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTHRILLER_SEARCH.setColumns(10);
		txtTHRILLER_SEARCH.setBounds(496, 24, 278, 26);
		Thriller.add(txtTHRILLER_SEARCH);
		
		JButton btnSearchThriller = new JButton("Search");
		btnSearchThriller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String searchHome = txtTHRILLER_SEARCH.getText();
				if(searchHome.isBlank() == true) {
					txtTHRILLER_SEARCH.setForeground(Color.LIGHT_GRAY);
					txtTHRILLER_SEARCH.setText("Entire Thriller Movies Catalogue");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String searchHome = txtTHRILLER_SEARCH.getText();
				if(searchHome.contains("Entire Thriller Movies Catalogue")) {
					txtTHRILLER_SEARCH.setForeground(Color.BLACK);
					txtTHRILLER_SEARCH.setText("");
				}	
			}
		});
		btnSearchThriller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchHome = txtTHRILLER_SEARCH.getText();
				if((searchHome.contains("Entire Thriller Movies Catalogue")) == false) {
					try {	
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM Thriller WHERE Movie_Name = '"+searchHome+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						SiteHome.setVisible(false);
						Thriller.setVisible(true);
										
						ThrillerTable.setModel(DbUtils.resultSetToTableModel(rs1));
								
						thrillerTableLayout();
						rs1.close();
						conn.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				} else {
						String tablefrom = "Thriller";
						btnDatabaseViewer(ThrillerTable, tablefrom);
						Thriller.setVisible(true);
						SiteHome.setVisible(false);
						thrillerTableLayout();
				}
			}
		});
		btnSearchThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearchThriller.setBounds(773, 22, 72, 30);
		Thriller.add(btnSearchThriller);
		
		JScrollPane ThrillerScrollPane = new JScrollPane();
		ThrillerScrollPane.setBounds(10, 103, 604, 345);
		Thriller.add(ThrillerScrollPane);
		
		ThrillerTable = new JTable();
		ThrillerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ThrillerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = ThrillerTable.getSelectedRow();
				String movieId = String.valueOf(ThrillerTable.getValueAt(row, 0));
				String moviename = String.valueOf(ThrillerTable.getValueAt(row, 1));
				String stock = String.valueOf(ThrillerTable.getValueAt(row, 5));
				
				txtMovieIDThriller.setText(movieId);
				txtMovieNameThriller.setText(moviename);
				txtStockThrillerTable.setText(stock);
			}
		});
		ThrillerTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Movie ID", "Movie Name", "Production Company", "Release Date", "Rating", "Stock"
			}
		));
		ThrillerTable.getColumnModel().getColumn(0).setPreferredWidth(67);
		ThrillerTable.getColumnModel().getColumn(1).setPreferredWidth(195);
		ThrillerTable.getColumnModel().getColumn(2).setPreferredWidth(160);
		ThrillerTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ThrillerTable.getColumnModel().getColumn(4).setPreferredWidth(46);
		ThrillerTable.getColumnModel().getColumn(5).setPreferredWidth(51);
		ThrillerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ThrillerTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ThrillerTable.setRowHeight(20);
		ThrillerScrollPane.setViewportView(ThrillerTable);
		
		JPanel ThrillerBorrowMovie = new JPanel();
		ThrillerBorrowMovie.setLayout(null);
		ThrillerBorrowMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ThrillerBorrowMovie.setBounds(624, 103, 221, 347);
		Thriller.add(ThrillerBorrowMovie);
		
		JLabel lblBorrowThriller = new JLabel("Borrow Thriller");
		lblBorrowThriller.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowThriller.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowThriller.setBounds(10, 31, 201, 26);
		ThrillerBorrowMovie.add(lblBorrowThriller);
		
		JLabel lblMovieIDThriller = new JLabel("Movie ID:");
		lblMovieIDThriller.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieIDThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDThriller.setBounds(10, 68, 201, 20);
		ThrillerBorrowMovie.add(lblMovieIDThriller);
		
		JLabel lblMovieNameThriller = new JLabel("Movie Name:");
		lblMovieNameThriller.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieNameThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieNameThriller.setBounds(10, 124, 201, 20);
		ThrillerBorrowMovie.add(lblMovieNameThriller);
		
		txtMovieIDThriller = new JTextField();
		txtMovieIDThriller.setBackground(Color.WHITE);
		txtMovieIDThriller.setEditable(false);
		txtMovieIDThriller.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieIDThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDThriller.setColumns(10);
		txtMovieIDThriller.setBounds(10, 89, 201, 24);
		ThrillerBorrowMovie.add(txtMovieIDThriller);
		
		txtMovieNameThriller = new JTextField();
		txtMovieNameThriller.setBackground(Color.WHITE);
		txtMovieNameThriller.setEditable(false);
		txtMovieNameThriller.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieNameThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieNameThriller.setColumns(10);
		txtMovieNameThriller.setBounds(10, 144, 201, 26);
		ThrillerBorrowMovie.add(txtMovieNameThriller);
		
		JButton btnBorrowThriller = new JButton(" Borrow");
		btnBorrowThriller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String movieId = txtMovieIDThriller.getText();
				int lentTo = Integer.parseInt(lblThrillerMemberID.getText());
				String moviename = txtMovieNameThriller.getText();
				int charge = 60;
				String table1 = "Thriller";
				String stock = txtStockThrillerTable.getText();
				int stock4 = (stock.isBlank() == true) ? 0 : (Integer.parseInt(stock));
				Date borrowingdate = BorrowThrillerdateChooser.getDate();
				
				insertToBorrowedMovies(charge, stock4, lentTo, movieId, moviename, borrowingdate, Thriller, txtMovieIDThriller, txtMovieNameThriller, BorrowThrillerdateChooser, lblErrorsThrillerBorrowMovie, table1);
			}
		});
		btnBorrowThriller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowThriller.setBounds(48, 248, 129, 26);
		Image downThriller = new ImageIcon(getClass().getClassLoader().getResource("Download.png")).getImage();
		btnBorrowThriller.setIcon(new ImageIcon(downThriller));
		ThrillerBorrowMovie.add(btnBorrowThriller);
		
		lblThrillerMemberID = new JLabel("");
		lblThrillerMemberID.setVisible(false);
		lblThrillerMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrillerMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThrillerMemberID.setBounds(10, 11, 201, 20);
		ThrillerBorrowMovie.add(lblThrillerMemberID);
		
		JLabel lblThrillerBorrowingDate = new JLabel("Borrowing Date:");
		lblThrillerBorrowingDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblThrillerBorrowingDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThrillerBorrowingDate.setBounds(10, 181, 201, 20);
		ThrillerBorrowMovie.add(lblThrillerBorrowingDate);
		
		BorrowThrillerdateChooser = new JDateChooser();
		BorrowThrillerdateChooser.setBounds(10, 202, 201, 26);
		ThrillerBorrowMovie.add(BorrowThrillerdateChooser);
		BorrowThrillerdateChooser.setMaxSelectableDate(currentDate);
		BorrowThrillerdateChooser.setMinSelectableDate(currentDate);
		BorrowThrillerdateChooser.setDate(currentDate);
		JTextFieldDateEditor editorThriller = (JTextFieldDateEditor) BorrowThrillerdateChooser.getDateEditor();
		editorThriller.setEditable(false);
		editorThriller.setBackground(Color.WHITE);
		
		lblErrorsThrillerBorrowMovie = new JLabel("");
		lblErrorsThrillerBorrowMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsThrillerBorrowMovie.setForeground(Color.RED);
		lblErrorsThrillerBorrowMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsThrillerBorrowMovie.setBounds(10, 285, 201, 20);
		ThrillerBorrowMovie.add(lblErrorsThrillerBorrowMovie);
		
		txtStockThrillerTable = new JTextField();
		txtStockThrillerTable.setEditable(false);
		txtStockThrillerTable.setVisible(false);
		txtStockThrillerTable.setBounds(125, 316, 86, 20);
		ThrillerBorrowMovie.add(txtStockThrillerTable);
		txtStockThrillerTable.setColumns(10);
		
		//Cartoon Movie Category Layout
		//Back button from the Cartoon Movie Category to the Site-Home
		JButton btnBackCartoon = new JButton("Back");
		btnBackCartoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorsCartoonBorrowMovie.setText("");
				SiteHome.setVisible(true);
				Cartoon.setVisible(false);
			}
		});
		btnBackCartoon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackCartoon.setBounds(773, 459, 72, 30);
		Cartoon.add(btnBackCartoon);
		
		JLabel lblUPEPEO_CARTOON = new JLabel("UPEPEO");
		lblUPEPEO_CARTOON.setHorizontalAlignment(SwingConstants.LEFT);
		lblUPEPEO_CARTOON.setFont(new Font("Old English Text MT", Font.BOLD, 30));
		lblUPEPEO_CARTOON.setBounds(10, 11, 159, 40);
		Cartoon.add(lblUPEPEO_CARTOON);
		
		JLabel lblCARTOON_PAGE = new JLabel("Borrow the latest Cartoons");
		lblCARTOON_PAGE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCARTOON_PAGE.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCARTOON_PAGE.setBounds(262, 71, 324, 26);
		Cartoon.add(lblCARTOON_PAGE);
		
		txtCARTOON_SEARCH = new JTextField();
		txtCARTOON_SEARCH.setForeground(Color.BLACK);
		txtCARTOON_SEARCH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCARTOON_SEARCH.setColumns(10);
		txtCARTOON_SEARCH.setBounds(496, 23, 278, 26);
		Cartoon.add(txtCARTOON_SEARCH);
		
		JButton btnSearchCartoon = new JButton("Search");
		btnSearchCartoon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String searchHome = txtCARTOON_SEARCH.getText();
				if(searchHome.isBlank() == true) {
					txtCARTOON_SEARCH.setForeground(Color.LIGHT_GRAY);
					txtCARTOON_SEARCH.setText("Entire Cartoons Catalogue");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String searchHome = txtCARTOON_SEARCH.getText();
				if(searchHome.contains("Entire Cartoons Catalogue")) {
					txtCARTOON_SEARCH.setForeground(Color.BLACK);
					txtCARTOON_SEARCH.setText("");
				}	
			}
		});
		btnSearchCartoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchHome = txtCARTOON_SEARCH.getText();
				if((searchHome.contains("Entire Cartoons Catalogue")) == false) {
					try {	
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM Cartoon WHERE Movie_Name = '"+searchHome+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						SiteHome.setVisible(false);
						Cartoon.setVisible(true);
										
						CartoonTable.setModel(DbUtils.resultSetToTableModel(rs1));
								
						cartoonTableLayout();
						rs1.close();
						conn.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				} else {
						String tablefrom = "Cartoon";
						btnDatabaseViewer(CartoonTable, tablefrom);
						Cartoon.setVisible(true);
						SiteHome.setVisible(false);
						cartoonTableLayout();
				}
			}
		});
		btnSearchCartoon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearchCartoon.setBounds(773, 21, 72, 30);
		Cartoon.add(btnSearchCartoon);
				
		JScrollPane CartoonScrollPane = new JScrollPane();
		CartoonScrollPane.setBounds(10, 103, 604, 345);
		Cartoon.add(CartoonScrollPane);
		
		CartoonTable = new JTable();
		CartoonTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CartoonTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = CartoonTable.getSelectedRow();
				String movieId = String.valueOf(CartoonTable.getValueAt(row, 0));
				String moviename = String.valueOf(CartoonTable.getValueAt(row, 1));
				String stock = String.valueOf(CartoonTable.getValueAt(row, 5));
								
				txtMovieIDCartoon.setText(movieId);
				txtMovieNameCartoon.setText(moviename);
				txtStockCartoonTable.setText(stock);
			}
		});
		CartoonTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Movie ID", "Movie Name", "Production Company", "Release Year", "Rating", "Stock"
			}
		));
		CartoonTable.getColumnModel().getColumn(0).setPreferredWidth(67);
		CartoonTable.getColumnModel().getColumn(1).setPreferredWidth(133);
		CartoonTable.getColumnModel().getColumn(2).setPreferredWidth(163);
		CartoonTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		CartoonTable.getColumnModel().getColumn(4).setPreferredWidth(54);
		CartoonTable.getColumnModel().getColumn(5).setPreferredWidth(51);
		CartoonTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		CartoonTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CartoonTable.setRowHeight(20);
		CartoonScrollPane.setViewportView(CartoonTable);
		
		JPanel CartoonBorrowMovie = new JPanel();
		CartoonBorrowMovie.setLayout(null);
		CartoonBorrowMovie.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CartoonBorrowMovie.setBounds(624, 101, 221, 347);
		Cartoon.add(CartoonBorrowMovie);
		
		JLabel lblBorrowCartoon = new JLabel("Borrow Cartoon");
		lblBorrowCartoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowCartoon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowCartoon.setBounds(10, 32, 201, 26);
		CartoonBorrowMovie.add(lblBorrowCartoon);
		
		JLabel lblMovieIDCartooon = new JLabel("Movie ID:");
		lblMovieIDCartooon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieIDCartooon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDCartooon.setBounds(10, 69, 201, 20);
		CartoonBorrowMovie.add(lblMovieIDCartooon);
		
		JLabel lblMovieNameCartoon = new JLabel("Movie Name:");
		lblMovieNameCartoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieNameCartoon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieNameCartoon.setBounds(10, 125, 201, 20);
		CartoonBorrowMovie.add(lblMovieNameCartoon);
		
		txtMovieIDCartoon = new JTextField();
		txtMovieIDCartoon.setBackground(Color.WHITE);
		txtMovieIDCartoon.setEditable(false);
		txtMovieIDCartoon.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieIDCartoon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDCartoon.setColumns(10);
		txtMovieIDCartoon.setBounds(10, 90, 201, 26);
		CartoonBorrowMovie.add(txtMovieIDCartoon);
		
		txtMovieNameCartoon = new JTextField();
		txtMovieNameCartoon.setBackground(Color.WHITE);
		txtMovieNameCartoon.setEditable(false);
		txtMovieNameCartoon.setHorizontalAlignment(SwingConstants.CENTER);
		txtMovieNameCartoon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieNameCartoon.setColumns(10);
		txtMovieNameCartoon.setBounds(10, 145, 201, 26);
		CartoonBorrowMovie.add(txtMovieNameCartoon);
		
		JButton btnBorrowCartoon = new JButton(" Borrow");
		btnBorrowCartoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String movieId = txtMovieIDCartoon.getText();
				int lentTo = Integer.parseInt(lblCartoonMemberID.getText());
				String moviename = txtMovieNameCartoon.getText();
				int charge = 80;
				String table1 = "Cartoon";
				String stock = txtStockCartoonTable.getText();
				int stock4 = (stock.isBlank() == true) ? 0 : (Integer.parseInt(stock));
				Date borrowingdate = BorrowCartoondateChooser.getDate();
				
				insertToBorrowedMovies(charge, stock4, lentTo, movieId, moviename, borrowingdate, Cartoon, txtMovieIDCartoon, txtMovieNameCartoon, BorrowCartoondateChooser, lblErrorsCartoonBorrowMovie, table1);
			}
		});
		btnBorrowCartoon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowCartoon.setBounds(51, 240, 128, 26);
		Image downCartoon = new ImageIcon(getClass().getClassLoader().getResource("Download.png")).getImage();
		btnBorrowCartoon.setIcon(new ImageIcon(downCartoon));
		CartoonBorrowMovie.add(btnBorrowCartoon);
		
		lblCartoonMemberID = new JLabel("");
		lblCartoonMemberID.setVisible(false);
		lblCartoonMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartoonMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCartoonMemberID.setBounds(10, 11, 201, 20);
		CartoonBorrowMovie.add(lblCartoonMemberID);
		
		JLabel lblCartoonBorrowingDate = new JLabel("Borrowing Date:");
		lblCartoonBorrowingDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartoonBorrowingDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCartoonBorrowingDate.setBounds(10, 182, 201, 20);
		CartoonBorrowMovie.add(lblCartoonBorrowingDate);
		
		BorrowCartoondateChooser = new JDateChooser();
		BorrowCartoondateChooser.setBounds(10, 203, 201, 26);
		CartoonBorrowMovie.add(BorrowCartoondateChooser);
		BorrowCartoondateChooser.setMaxSelectableDate(currentDate);
		BorrowCartoondateChooser.setMinSelectableDate(currentDate);
		BorrowCartoondateChooser.setDate(currentDate);
		JTextFieldDateEditor editorCartoon = (JTextFieldDateEditor) BorrowCartoondateChooser.getDateEditor();
		editorCartoon.setEditable(false);
		editorCartoon.setBackground(Color.WHITE);
		
		lblErrorsCartoonBorrowMovie = new JLabel("");
		lblErrorsCartoonBorrowMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsCartoonBorrowMovie.setForeground(Color.RED);
		lblErrorsCartoonBorrowMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsCartoonBorrowMovie.setBounds(10, 277, 201, 20);
		CartoonBorrowMovie.add(lblErrorsCartoonBorrowMovie);
		
		txtStockCartoonTable = new JTextField();
		txtStockCartoonTable.setVisible(false);
		txtStockCartoonTable.setEditable(false);
		txtStockCartoonTable.setBounds(125, 316, 86, 20);
		CartoonBorrowMovie.add(txtStockCartoonTable);
		txtStockCartoonTable.setColumns(10);
		Admin.setLayout(null);
		
		
		//Administrator Panel
		JLabel lblAdminPage = new JLabel("UPEPEO");
		lblAdminPage.setBounds(10, 11, 835, 49);
		lblAdminPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPage.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		Admin.add(lblAdminPage);
		
		tabAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabAdmin.setBounds(10, 60, 835, 429);
		Admin.add(tabAdmin);
		
		JButton btnComedyAdmin = new JButton("Comedy");
		btnComedyAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnComedyAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Comedy";
				btnDatabaseViewer(AdminMovieCatalog, tablefrom);
				lblMovieCatalog.setText("Comedy");
				adminMovieCatalogLayout();
			}
		});
		btnComedyAdmin.setBounds(731, 11, 89, 23);
		MovieCatalog.add(btnComedyAdmin);
		
		JButton btnGeneralAdmin = new JButton("General");
		btnGeneralAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGeneralAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "General";
				btnDatabaseViewer(AdminMovieCatalog, tablefrom);
				lblMovieCatalog.setText("General");
				adminMovieCatalogLayout();
			}
		});
		btnGeneralAdmin.setBounds(731, 43, 89, 23);
		MovieCatalog.add(btnGeneralAdmin);
		
		JButton btnHorrorAdmin = new JButton("Horror");
		btnHorrorAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHorrorAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Horror";
				btnDatabaseViewer(AdminMovieCatalog, tablefrom);
				lblMovieCatalog.setText("Horror");
				adminMovieCatalogLayout();
			}
		});
		btnHorrorAdmin.setBounds(731, 74, 89, 23);
		MovieCatalog.add(btnHorrorAdmin);
		
		JButton btnThrillerAdmin = new JButton("Thriller");
		btnThrillerAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThrillerAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Thriller";
				btnDatabaseViewer(AdminMovieCatalog, tablefrom);
				lblMovieCatalog.setText("Thriller");
				adminMovieCatalogLayout();
			}
		});
		btnThrillerAdmin.setBounds(731, 108, 89, 23);
		MovieCatalog.add(btnThrillerAdmin);
		
		JButton btnCartoonAdmin = new JButton("Cartoon");
		btnCartoonAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCartoonAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Cartoon";
				btnDatabaseViewer(AdminMovieCatalog, tablefrom);
				lblMovieCatalog.setText("Cartoon");
				adminMovieCatalogLayout();
			}
		});
		btnCartoonAdmin.setBounds(731, 142, 89, 23);
		MovieCatalog.add(btnCartoonAdmin);
		
		JButton btnAddMovie = new JButton("Add Movie");
		btnAddMovie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddMovie.setActionCommand("btnAddMovie");
		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setVisible(false);
				MovieManager.setVisible(true);
				AddMovie.setVisible(true);
				DeleteMovie.setVisible(true);
				
				lblErrorsAddMovie.setEnabled(true);
				lblAddMovie.setEnabled(true);
				lblGenre1.setEnabled(true);
				MovieGenre1.setEnabled(true);
				lblMovieIDAddMovie.setEnabled(true);
				txtMovieIDAddMovie.setEnabled(true);
				lblMovieName.setEnabled(true);
				txtMovieName.setEnabled(true);
				lblProductionCompany.setEnabled(true);
				txtProductionCompany.setEnabled(true);
				lblReleaseYear.setEnabled(true);
				txtReleaseYear.setEnabled(true);
				lblRating.setEnabled(true);
				txtRating.setEnabled(true);
				lblStock.setEnabled(true);
				txtStock.setEnabled(true);
				btnAddMovie2.setEnabled(true);
				btnClear2.setEnabled(true);
				btnBackMovieAdder.setEnabled(true);
				
				lblDeleteMovie.setEnabled(false);
				lblGenre2.setEnabled(false);
				MovieGenre2.setEnabled(false);
				lblMovieID.setEnabled(false);
				txtMovieID.setEnabled(false);
				lblMovieName2.setEnabled(false);
				txtMovieName2.setEnabled(false);
				btnDeleteMovie2.setEnabled(false);
				btnClear3.setEnabled(false);
				btnBackDeleteMovie.setEnabled(false);
				lblErrorsDeleteMovie.setEnabled(false);
			}
		});
		btnAddMovie.setBounds(329, 367, 133, 23);
		MovieCatalog.add(btnAddMovie);
		
		JButton btnDeleteMovie = new JButton("Delete Movie");
		btnDeleteMovie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setVisible(false);
				MovieManager.setVisible(true);
				AddMovie.setVisible(true);
				DeleteMovie.setVisible(true);
				
				lblDeleteMovie.setEnabled(true);
				lblGenre2.setEnabled(true);
				MovieGenre2.setEnabled(true);
				MovieGenre2.setSelectedItem(lblMovieCatalog.getText());
				lblMovieID.setEnabled(true);
				txtMovieID.setEnabled(true);
				lblMovieName2.setEnabled(true);
				txtMovieName2.setEnabled(true);
				btnDeleteMovie2.setEnabled(true);
				btnClear3.setEnabled(true);
				btnBackDeleteMovie.setEnabled(true);
				lblErrorsDeleteMovie.setEnabled(true);
				
				lblErrorsAddMovie.setEnabled(false);
				lblAddMovie.setEnabled(false);
				lblGenre1.setEnabled(false);
				MovieGenre1.setEnabled(false);
				lblMovieIDAddMovie.setEnabled(false);
				txtMovieIDAddMovie.setEnabled(false);
				lblMovieName.setEnabled(false);
				txtMovieName.setEnabled(false);
				lblProductionCompany.setEnabled(false);
				txtProductionCompany.setEnabled(false);
				lblReleaseYear.setEnabled(false);
				txtReleaseYear.setEnabled(false);
				lblRating.setEnabled(false);
				txtRating.setEnabled(false);
				lblStock.setEnabled(false);
				txtStock.setEnabled(false);
				btnAddMovie2.setEnabled(false);
				btnClear2.setEnabled(false);
				btnBackMovieAdder.setEnabled(false);

			}
		});
		btnDeleteMovie.setBounds(490, 366, 133, 23);
		MovieCatalog.add(btnDeleteMovie);
		
		JScrollPane scrollPanecatalog = new JScrollPane();
		scrollPanecatalog.setBounds(0, 29, 721, 327);
		MovieCatalog.add(scrollPanecatalog);
		
		AdminMovieCatalog = new JTable();
		AdminMovieCatalog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AdminMovieCatalog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = AdminMovieCatalog.getSelectedRow();
				String movieId = String.valueOf(AdminMovieCatalog.getValueAt(row, 0));
				String moviename = String.valueOf(AdminMovieCatalog.getValueAt(row, 1));
				String genre = null;
				
				if(movieId.contains("COM")) {
					genre = "Comedy";
				} else if(movieId.contains("GEN")) {
					genre = "General";
				} else if(movieId.contains("HOR")) {
					genre = "Horror";
				} else if(movieId.contains("THR")) {
					genre = "Thriller";
				} else {
					genre = "Cartoon";
				}
			
				txtMovieID.setText(movieId);
				txtMovieName2.setText(moviename);
				MovieGenre2.setSelectedItem(genre);
			}
		});
		AdminMovieCatalog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPanecatalog.setViewportView(AdminMovieCatalog);
		AdminMovieCatalog.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie_ID", "Movie_Name", "Production_Company", "Release Year", "Rating", "Stock"
			}
		));
		AdminMovieCatalog.getColumnModel().getColumn(0).setPreferredWidth(80);
		AdminMovieCatalog.getColumnModel().getColumn(1).setPreferredWidth(219);
		AdminMovieCatalog.getColumnModel().getColumn(2).setPreferredWidth(174);
		AdminMovieCatalog.getColumnModel().getColumn(3).setPreferredWidth(93);
		AdminMovieCatalog.getColumnModel().getColumn(4).setPreferredWidth(58);
		AdminMovieCatalog.getColumnModel().getColumn(5).setPreferredWidth(55);
		AdminMovieCatalog.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		AdminMovieCatalog.setRowHeight(20);
		
		lblMovieCatalog = new JLabel("");
		lblMovieCatalog.setForeground(Color.RED);
		lblMovieCatalog.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieCatalog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMovieCatalog.setBounds(0, 4, 721, 23);
		MovieCatalog.add(lblMovieCatalog);
		
		JButton btnBackMovieCatalog = new JButton("Back");
		btnBackMovieCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.setVisible(false);
				HomePage.setVisible(true);
			}
		});
		btnBackMovieCatalog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackMovieCatalog.setBounds(752, 367, 68, 23);
		MovieCatalog.add(btnBackMovieCatalog);
		
		JButton btnEntirecatalog = new JButton("EntireCatalog");
		btnEntirecatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tablefrom = "EntireMovieDatabase";
				btnDatabaseViewer(AdminMovieCatalog, tablefrom);
				lblMovieCatalog.setText("Entire Movie Catalog");
				adminMovieCatalogLayout();
			}
		});
		btnEntirecatalog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntirecatalog.setBounds(10, 367, 133, 23);
		MovieCatalog.add(btnEntirecatalog);
		
		AddorRemoveMember = new JPanel();
		AddorRemoveMember.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AddorRemoveMember.setBounds(10, 11, 670, 379);
		Members.add(AddorRemoveMember);
		AddorRemoveMember.setLayout(null);
		AddorRemoveMember.setVisible(false);
		
		RemoveMember = new JPanel();
		RemoveMember.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		RemoveMember.setBounds(446, 11, 214, 357);
		AddorRemoveMember.add(RemoveMember);
		RemoveMember.setLayout(null);
		RemoveMember.setVisible(false);
		
		JLabel lblRemoveMember = new JLabel("Remove Member");
		lblRemoveMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveMember.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRemoveMember.setBounds(13, 58, 191, 25);
		RemoveMember.add(lblRemoveMember);
		
		JLabel lblMemberIDRemoveMember = new JLabel("Member ID:");
		lblMemberIDRemoveMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberIDRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberIDRemoveMember.setBounds(13, 94, 191, 19);
		RemoveMember.add(lblMemberIDRemoveMember);
		
		txtMemberIDRemoveMember = new JTextField();
		txtMemberIDRemoveMember.setBackground(Color.WHITE);
		txtMemberIDRemoveMember.setEditable(false);
		txtMemberIDRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMemberIDRemoveMember.setColumns(10);
		txtMemberIDRemoveMember.setBounds(13, 116, 191, 19);
		RemoveMember.add(txtMemberIDRemoveMember);
		
		JLabel lblMemberNameRemoveMember = new JLabel("Member Email Address:");
		lblMemberNameRemoveMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberNameRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMemberNameRemoveMember.setBounds(13, 144, 191, 19);
		RemoveMember.add(lblMemberNameRemoveMember);
		
		txtMemberEmailAddressRemoveMember = new JTextField();
		txtMemberEmailAddressRemoveMember.setBackground(Color.WHITE);
		txtMemberEmailAddressRemoveMember.setEditable(false);
		txtMemberEmailAddressRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMemberEmailAddressRemoveMember.setColumns(10);
		txtMemberEmailAddressRemoveMember.setBounds(13, 166, 191, 19);
		RemoveMember.add(txtMemberEmailAddressRemoveMember);
		
		JButton btnRemoveRemoveMember = new JButton("Remove");
		btnRemoveRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String memberId = txtMemberIDRemoveMember.getText();
				String memberemail= txtMemberEmailAddressRemoveMember.getText();
				
				if((memberId.isBlank() == false) && (memberemail.isBlank() == false)) {
					lblErrorsDeleteMovie.setText("");
					
					try {
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "DELETE FROM Members "
									 + "WHERE Membership_ID = '"+memberId+"' AND Email_Address = '"+memberemail+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.executeUpdate();						
						JOptionPane.showMessageDialog(null, "Member Removed from the Database");
						pst.close();
						conn.close();
						
						IEMemberCombobox.removeItem((Integer.parseInt(memberId)) < 10 ? ("M00" + memberId) : ("M0" + memberId));
						IEMemberCombobox.setSelectedItem(null);
						txtMemberIDRemoveMember.setText("");
						txtMemberEmailAddressRemoveMember.setText("");
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Removal Unsuccessful.");
					}
				}else {
					lblErrorsRemoveMember.setText("Please fill in all the entries");
				}
			}
		});
		btnRemoveRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemoveRemoveMember.setBounds(113, 196, 79, 23);
		RemoveMember.add(btnRemoveRemoveMember);
		
		lblErrorsRemoveMember = new JLabel("");
		lblErrorsRemoveMember.setForeground(Color.RED);
		lblErrorsRemoveMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsRemoveMember.setBounds(13, 230, 191, 19);
		RemoveMember.add(lblErrorsRemoveMember);
		
		JButton btnClearRemoveMember = new JButton("Clear");
		btnClearRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMemberIDRemoveMember.setText("");
				txtMemberEmailAddressRemoveMember.setText("");
				lblErrorsRemoveMember.setText("");
			}
		});
		btnClearRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClearRemoveMember.setBounds(23, 196, 79, 23);
		RemoveMember.add(btnClearRemoveMember);
		
		AddMember = new JPanel();
		AddMember.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AddMember.setBounds(10, 11, 426, 357);
		AddorRemoveMember.add(AddMember);
		AddMember.setLayout(null);
		AddMember.setVisible(false);
		
		JLabel lblAddMember = new JLabel("Add Member");
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddMember.setBounds(10, 11, 406, 25);
		AddMember.add(lblAddMember);
		
		JLabel lblEmailAddressAddMember = new JLabel("Email Address:");
		lblEmailAddressAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAddressAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailAddressAddMember.setBounds(34, 40, 164, 19);
		AddMember.add(lblEmailAddressAddMember);
		
		JLabel lblIDNumberAddMember = new JLabel("ID Number:");
		lblIDNumberAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDNumberAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIDNumberAddMember.setBounds(225, 40, 164, 19);
		AddMember.add(lblIDNumberAddMember);
		
		txtEmailAddressAddMember = new JTextField();
		txtEmailAddressAddMember.setDocument(new JTextFieldLimit(30));
		txtEmailAddressAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmailAddressAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmailAddressAddMember.setColumns(10);
		txtEmailAddressAddMember.setBounds(34, 61, 164, 19);
		AddMember.add(txtEmailAddressAddMember);
		
		txtIDNumberAddMember = new JTextField();
		txtIDNumberAddMember.setDocument(new JTextFieldLimit(8));
		txtIDNumberAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDNumberAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIDNumberAddMember.setColumns(10);
		txtIDNumberAddMember.setBounds(225, 61, 164, 19);
		AddMember.add(txtIDNumberAddMember);
		
		JLabel lblLastNameAddMember = new JLabel("Last Name:");
		lblLastNameAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastNameAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastNameAddMember.setBounds(225, 91, 164, 19);
		AddMember.add(lblLastNameAddMember);
		
		JLabel lblFirstNameAddMember = new JLabel("First Name:");
		lblFirstNameAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstNameAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstNameAddMember.setBounds(34, 91, 164, 19);
		AddMember.add(lblFirstNameAddMember);
		
		txtFirstNameAddMember = new JTextField();
		txtFirstNameAddMember.setDocument(new JTextFieldLimit(20));
		txtFirstNameAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstNameAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFirstNameAddMember.setColumns(10);
		txtFirstNameAddMember.setBounds(34, 112, 164, 19);
		AddMember.add(txtFirstNameAddMember);
		
		txtLastNameAddMember = new JTextField();
		txtLastNameAddMember.setDocument(new JTextFieldLimit(20));
		txtLastNameAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastNameAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLastNameAddMember.setColumns(10);
		txtLastNameAddMember.setBounds(225, 112, 164, 19);
		AddMember.add(txtLastNameAddMember);
		
		JLabel lblOccupationAddMember = new JLabel("Occupation:");
		lblOccupationAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblOccupationAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOccupationAddMember.setBounds(225, 142, 164, 19);
		AddMember.add(lblOccupationAddMember);
		
		txtOccupationAddMember = new JTextField();
		txtOccupationAddMember.setDocument(new JTextFieldLimit(20));
		txtOccupationAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtOccupationAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtOccupationAddMember.setColumns(10);
		txtOccupationAddMember.setBounds(225, 163, 164, 19);
		AddMember.add(txtOccupationAddMember);
		
		JLabel lblPhoneNumberAddMember = new JLabel("Phone Number:");
		lblPhoneNumberAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumberAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumberAddMember.setBounds(34, 142, 164, 19);
		AddMember.add(lblPhoneNumberAddMember);
		
		txtPhoneNumberAddMember = new JTextField();
		txtPhoneNumberAddMember.setDocument(new JTextFieldLimit(10));
		txtPhoneNumberAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumberAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPhoneNumberAddMember.setColumns(10);
		txtPhoneNumberAddMember.setBounds(34, 163, 164, 19);
		AddMember.add(txtPhoneNumberAddMember);
		
		JLabel lblDateofJoiningAddMember = new JLabel("Date of Joining");
		lblDateofJoiningAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateofJoiningAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateofJoiningAddMember.setBounds(34, 193, 164, 19);
		AddMember.add(lblDateofJoiningAddMember);
		
		JLabel lblPasswordAddMember = new JLabel("Password:");
		lblPasswordAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasswordAddMember.setBounds(34, 244, 164, 19);
		AddMember.add(lblPasswordAddMember);
		
		dateChooserDateofJoiningAddMember = new JDateChooser();
		dateChooserDateofJoiningAddMember.setBounds(34, 214, 164, 20);
		AddMember.add(dateChooserDateofJoiningAddMember);
		dateChooserDateofJoiningAddMember.setMaxSelectableDate(currentDate);
		dateChooserDateofJoiningAddMember.setMinSelectableDate(currentDate);
		dateChooserDateofJoiningAddMember.setDate(currentDate);
		JTextFieldDateEditor editorAdmin = (JTextFieldDateEditor) dateChooserDateofJoiningAddMember.getDateEditor();
		editorAdmin.setEditable(false);
		editorAdmin.setBackground(Color.WHITE);
				
		txtResidentialAddressAddMember = new JTextField();
		txtResidentialAddressAddMember.setDocument(new JTextFieldLimit(20));
		txtResidentialAddressAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtResidentialAddressAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtResidentialAddressAddMember.setColumns(10);
		txtResidentialAddressAddMember.setBounds(225, 214, 164, 19);
		AddMember.add(txtResidentialAddressAddMember);
		
		JLabel lblResidentialAddressAddMember = new JLabel("Residential Address:");
		lblResidentialAddressAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblResidentialAddressAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResidentialAddressAddMember.setBounds(225, 193, 164, 19);
		AddMember.add(lblResidentialAddressAddMember);
		
		JLabel lblGenderAddMember = new JLabel("Gender:");
		lblGenderAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenderAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenderAddMember.setBounds(225, 244, 164, 19);
		AddMember.add(lblGenderAddMember);
		
		JButton btnClearAddMember = new JButton("Clear");
		btnClearAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEmailAddressAddMember.setText("");
				txtIDNumberAddMember.setText("");
				txtFirstNameAddMember.setText("");
				txtLastNameAddMember.setText("");
				txtPhoneNumberAddMember.setText("");
				txtOccupationAddMember.setText("");
				dateChooserDateofJoiningAddMember.setDate(null);
				txtResidentialAddressAddMember.setText("");
				txtPasswordAddMember.setText("");
				comboBoxGenderAddMember.setSelectedItem(null);
				lblErrorsAddMember.setText("");
				
			}
		});
		btnClearAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClearAddMember.setBounds(90, 295, 117, 25);
		AddMember.add(btnClearAddMember);
		
		JButton btnAddMemberAddMember = new JButton("Add Member");
		btnAddMemberAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = txtEmailAddressAddMember.getText();
				String idNumber = txtIDNumberAddMember.getText();
				String firstName = txtFirstNameAddMember.getText();
				String lastName= txtLastNameAddMember.getText();
				String phoneNumber = txtPhoneNumberAddMember.getText();
				String occupation = txtOccupationAddMember.getText();
				String place = txtResidentialAddressAddMember.getText();
				String password = txtPasswordAddMember.getText();
				String gender = (String)comboBoxGenderAddMember.getSelectedItem();
				String view = "Admin";
				
				insertIntoMembers(email, idNumber, firstName, lastName, phoneNumber, occupation, place, password, gender, dateChooserDateofJoiningAddMember, lblErrorsAddMember, view);
			
			}
		});
		btnAddMemberAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddMemberAddMember.setBounds(217, 296, 117, 24);
		AddMember.add(btnAddMemberAddMember);
		
		txtPasswordAddMember = new JTextField();
		txtPasswordAddMember.setDocument(new JTextFieldLimit(20));
		txtPasswordAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPasswordAddMember.setColumns(10);
		txtPasswordAddMember.setBounds(34, 265, 164, 19);
		AddMember.add(txtPasswordAddMember);
		
		comboBoxGenderAddMember = new JComboBox<String>();
		comboBoxGenderAddMember.setBackground(Color.WHITE);
		comboBoxGenderAddMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxGenderAddMember.setBounds(225, 264, 164, 20);
		AddMember.add(comboBoxGenderAddMember);
		comboBoxGenderAddMember.addItem("Male");
		comboBoxGenderAddMember.addItem("Female");
		comboBoxGenderAddMember.setSelectedItem(null);
		
		lblErrorsAddMember = new JLabel("");
		lblErrorsAddMember.setForeground(Color.RED);
		lblErrorsAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsAddMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsAddMember.setBounds(10, 321, 406, 25);
		AddMember.add(lblErrorsAddMember);
		
		MembersTablePanel = new JPanel();
		MembersTablePanel.setLayout(null);
		MembersTablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		MembersTablePanel.setBounds(10, 11, 670, 379);
		Members.add(MembersTablePanel);
		
		MembersTablescrollPane = new JScrollPane();
		MembersTablescrollPane.setBounds(10, 11, 650, 357);
		MembersTablePanel.add(MembersTablescrollPane);
		
		MembersTable = new JTable();
		MembersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MembersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = MembersTable.getSelectedRow();
				String memberId = String.valueOf(MembersTable.getValueAt(row, 0));
				String memberEmail = String.valueOf(MembersTable.getValueAt(row, 1));
				
				txtMemberIDRemoveMember.setText(memberId);
				txtMemberEmailAddressRemoveMember.setText(memberEmail);
			}
		});
		MembersTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Membership_ID", "Email_Address", "ID_Number", "First_Name", "Last_Name", "Phone_Number", "Occupation", "Residential_Address", "Password", "Gender", "DateofJoining"
			}
		));
		MembersTable.getColumnModel().getColumn(0).setPreferredWidth(95);
		MembersTable.getColumnModel().getColumn(1).setPreferredWidth(178);
		MembersTable.getColumnModel().getColumn(2).setPreferredWidth(87);
		MembersTable.getColumnModel().getColumn(3).setPreferredWidth(95);
		MembersTable.getColumnModel().getColumn(4).setPreferredWidth(83);
		MembersTable.getColumnModel().getColumn(5).setPreferredWidth(97);
		MembersTable.getColumnModel().getColumn(6).setPreferredWidth(73);
		MembersTable.getColumnModel().getColumn(7).setPreferredWidth(130);
		MembersTable.getColumnModel().getColumn(8).setPreferredWidth(80);
		MembersTable.getColumnModel().getColumn(9).setPreferredWidth(57);
		MembersTable.getColumnModel().getColumn(10).setPreferredWidth(92);
		MembersTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		MembersTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MembersTablescrollPane.setViewportView(MembersTable);
		MembersTable.setRowHeight(20);
		
		btnAddorRemoveMember = new JButton("Add or Remove");
		btnAddorRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddorRemoveMember.setVisible(true);
				RemoveMember.setVisible(true);
				AddMember.setVisible(true);
				MembersTablePanel.setVisible(false);
			}
		});
		btnAddorRemoveMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddorRemoveMember.setBounds(690, 45, 130, 23);
		Members.add(btnAddorRemoveMember);
		
		btnShowMembers = new JButton("Show Members");
		btnShowMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tablefrom = "Members";
				btnDatabaseViewer(MembersTable, tablefrom);
				membersTableLayout();
				MembersTablePanel.setVisible(true);
				AddorRemoveMember.setVisible(false);
				RemoveMember.setVisible(false);
				AddMember.setVisible(false);
			}
		});
		btnShowMembers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShowMembers.setBounds(690, 11, 130, 23);
		Members.add(btnShowMembers);
		
		final JTextField IEChargetxt;
		IEChargetxt = new JTextField();
		IEChargetxt.setBackground(Color.WHITE);
		IEChargetxt.setEditable(false);
		IEChargetxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEChargetxt.setBounds(116, 279, 174, 20);
		IEChargetxt.setColumns(10);
		
		final JTextField IEDaysOverduetxt;
		IEDaysOverduetxt = new JTextField();
		IEDaysOverduetxt.setEnabled(false);
		IEDaysOverduetxt.setBounds(414, 253, 174, 20);
		IEDaysOverduetxt.setColumns(10);
		
		final JComboBox<String> IEConditionCombobox;
		IEConditionCombobox = new JComboBox<String>();
		IEConditionCombobox.setEnabled(false);
		IEConditionCombobox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEConditionCombobox.setBounds(414, 277, 174, 22);
		IEConditionCombobox.addItem("Good");
		IEConditionCombobox.addItem("Damaged");
		IEConditionCombobox.setSelectedItem(null);
		
		final JLabel IEErrorslbl;
		IEErrorslbl = new JLabel("");
		IEErrorslbl.setForeground(Color.RED);
		IEErrorslbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IEErrorslbl.setHorizontalAlignment(SwingConstants.CENTER);
		IEErrorslbl.setBounds(10, 344, 609, 24);
		
		JButton btnBorrowedMoviesFinances = new JButton("Borrowed Movies");
		btnBorrowedMoviesFinances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Borrowed_Movies";
				btnDatabaseViewer(BorrowedMoviesTable, tablefrom);
				borrowedMoviesTableLayout();
				BorrowedMoviesPanel.setVisible(true);
				OverdueMoviesPanel.setVisible(false);
				DamagedMoviesPanel.setVisible(false);
				IE.setVisible(false);
				IncomeandAllocationsPanel.setVisible(false);
			}
		});
		btnBorrowedMoviesFinances.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowedMoviesFinances.setBounds(649, 64, 171, 28);
		Finances.add(btnBorrowedMoviesFinances);
		
		JButton btnOverdueMoviesFinances = new JButton("Overdue Movies");
		btnOverdueMoviesFinances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Overdue_Movies";
				btnDatabaseViewer(OverDueMoviesTable, tablefrom);
				overdueMoviesTableLayout();
				OverdueMoviesPanel.setVisible(true);
				BorrowedMoviesPanel.setVisible(false);
				DamagedMoviesPanel.setVisible(false);
				IE.setVisible(false);
				IncomeandAllocationsPanel.setVisible(false);
			}
		});
		btnOverdueMoviesFinances.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOverdueMoviesFinances.setBounds(649, 103, 171, 28);
		Finances.add(btnOverdueMoviesFinances);
		
		JButton btnDamagedMoviesFinances = new JButton("Damaged Movies");
		btnDamagedMoviesFinances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablefrom = "Damaged_Movies";
				btnDatabaseViewer(DamagedMoviesTable, tablefrom);
				damagedMoviesTableLayout();
				DamagedMoviesPanel.setVisible(true);
				OverdueMoviesPanel.setVisible(false);
				BorrowedMoviesPanel.setVisible(false);
				IE.setVisible(false);
				IncomeandAllocationsPanel.setVisible(false);
			}
		});
		btnDamagedMoviesFinances.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDamagedMoviesFinances.setBounds(649, 142, 171, 28);
		Finances.add(btnDamagedMoviesFinances);
		
		JButton btnIndividualExpensesFinances = new JButton("Individual Expenses");
		btnIndividualExpensesFinances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IE.setVisible(true);
				DamagedMoviesPanel.setVisible(false);
				OverdueMoviesPanel.setVisible(false);
				BorrowedMoviesPanel.setVisible(false);
				IncomeandAllocationsPanel.setVisible(false);
			}
		});
		btnIndividualExpensesFinances.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIndividualExpensesFinances.setBounds(649, 181, 171, 28);
		Finances.add(btnIndividualExpensesFinances);
		
		JButton btnTotalIncomeandAllocationsFinances = new JButton("Income and Allocations");
		btnTotalIncomeandAllocationsFinances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(databaseURL);
					String query1 = "SELECT sum(Charge) AS Total_Charge FROM Borrowed_Movies";
					String query2 = "SELECT sum(Charge) AS Total_Charge FROM Overdue_Movies";
					String query3 = "SELECT sum(Charge) AS Total_Charge FROM Damaged_Movies";
					String query4 = "SELECT count(*) AS No_of_Members FROM Members";
					
					PreparedStatement pst1 = conn.prepareStatement(query1);
					PreparedStatement pst2 = conn.prepareStatement(query2);
					PreparedStatement pst3 = conn.prepareStatement(query3);
					PreparedStatement pst4 = conn.prepareStatement(query4);
					
					ResultSet rs1 = pst1.executeQuery();
					ResultSet rs2 = pst2.executeQuery();
					ResultSet rs3 = pst3.executeQuery();
					ResultSet rs4 = pst4.executeQuery();
					
					while(rs1.next()) {
						String borrowedMoviesCharge = rs1.getString("Total_Charge");
						int borrowedMoviesTotalCharge = (borrowedMoviesCharge != null) ? Integer.parseInt(borrowedMoviesCharge) : 0;
						
						while(rs2.next()) {
							String overdueMoviesCharge = rs2.getString("Total_Charge");
							int overdueMoviesTotalCharge = (overdueMoviesCharge != null) ? Integer.parseInt(overdueMoviesCharge) : 0;
														
							while(rs3.next()) {
								String damagedMoviesCharge = rs3.getString("Total_Charge");
								int damagedMoviesTotalCharge = (damagedMoviesCharge != null) ? Integer.parseInt(damagedMoviesCharge) : 0;
																
								while(rs4.next()) {
									String numberOfMembers = rs4.getString("No_of_Members");
									int totalNumberofMembers = (numberOfMembers != null) ? Integer.parseInt(numberOfMembers) : 0;
									int totalRegFees = totalNumberofMembers * 5000;
									
									int totalIncome = borrowedMoviesTotalCharge + overdueMoviesTotalCharge + damagedMoviesTotalCharge + totalRegFees;
									
									int administrationRevenue = (int) (0.27 * totalIncome);
									int salariesRevenue = (int) (0.54 * totalIncome);
									int miscellaneousRevenue = (int) (0.07 * totalIncome);
									int clubdevelopmentRevenue = (int) (0.12 * totalIncome);
									
									String finalIncome = String.valueOf(totalIncome);
									String administrationRevenueTotal = String.valueOf(administrationRevenue);
									String salariesRevenueTotal = String.valueOf(salariesRevenue);
									String miscellaneousRevenueTotal = String.valueOf(miscellaneousRevenue);
									String clubdevelopmentRevenueTotal = String.valueOf(clubdevelopmentRevenue);
									
									IncomeandAllocationsTotalIncometxt.setText(finalIncome);
									IncomeandAllocationsAdministrationtxt.setText(administrationRevenueTotal);
									IncomeandAllocationsSalariestxt.setText(salariesRevenueTotal);
									IncomeandAllocationsMiscellaneoustxt.setText(miscellaneousRevenueTotal);
									IncomeandAllocationsClubDevelopmenttxt.setText(clubdevelopmentRevenueTotal);
									
								}
							}
						}
					}
					
					rs1.close();
					rs2.close();
					rs3.close();
					rs4.close();
					pst1.close();
					pst2.close();
					pst3.close();
					pst4.close();
					conn.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				IncomeandAllocationsPanel.setVisible(true);
				IE.setVisible(false);
				DamagedMoviesPanel.setVisible(false);
				OverdueMoviesPanel.setVisible(false);
				BorrowedMoviesPanel.setVisible(false);
			}
		});
		btnTotalIncomeandAllocationsFinances.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTotalIncomeandAllocationsFinances.setBounds(649, 11, 171, 28);
		Finances.add(btnTotalIncomeandAllocationsFinances);
		
		final JTextField IEMovieIDtxt = new JTextField();
		IEMovieIDtxt.setBackground(Color.WHITE);
		IEMovieIDtxt.setEditable(false);
		IEMovieIDtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEMovieIDtxt.setBounds(116, 229, 174, 20);
		IE.add(IEMovieIDtxt);
		IEMovieIDtxt.setColumns(10);
		
		final JTextField IEMemberIDtxt = new JTextField();
		IEMemberIDtxt.setEditable(false);
		IEMemberIDtxt.setVisible(false);
		IEMemberIDtxt.setBounds(43, 306, 86, 20);
		IE.add(IEMemberIDtxt);
		IEMemberIDtxt.setColumns(10);
		
		JLabel IETitlelbl = new JLabel("Individual Expenses");
		IETitlelbl.setForeground(Color.RED);
		IETitlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		IETitlelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IETitlelbl.setBounds(10, 11, 609, 24);
		IE.add(IETitlelbl);
		
		JLabel IEMemberlbl = new JLabel("Member:");
		IEMemberlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEMemberlbl.setBounds(10, 46, 55, 14);
		IE.add(IEMemberlbl);
		
		IECategorylbl = new JLabel("Category:");
		IECategorylbl.setEnabled(false);
		IECategorylbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IECategorylbl.setBounds(399, 46, 62, 14);
		IE.add(IECategorylbl);
		
		final JTextField IEMovieNametxt = new JTextField();
		IEMovieNametxt.setBackground(Color.WHITE);
		IEMovieNametxt.setEditable(false);
		IEMovieNametxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEMovieNametxt.setBounds(116, 254, 174, 20);
		IE.add(IEMovieNametxt);
		IEMovieNametxt.setColumns(10);
		IE.add(IEChargetxt);
		IE.add(IEDaysOverduetxt);
		IE.add(IEConditionCombobox);
		IE.add(IEErrorslbl);
		
		final JLabel IEOverduelbl = new JLabel("Overdue?");
		IEOverduelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEOverduelbl.setEnabled(false);
		IEOverduelbl.setBounds(318, 232, 94, 14);
		IE.add(IEOverduelbl);
		
		final JLabel IEDaysOverduelbl = new JLabel("Days Overdue:");
		IEDaysOverduelbl.setEnabled(false);
		IEDaysOverduelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEDaysOverduelbl.setBounds(318, 256, 94, 14);
		IE.add(IEDaysOverduelbl);
		
		final JComboBox<String> IEOverdueCombobox = new JComboBox<String>();
		IEOverdueCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String overdue = (String)IEOverdueCombobox.getSelectedItem();
				
				if(overdue == "Yes") {
					IEDaysOverduelbl.setEnabled(true);
					IEDaysOverduetxt.setEnabled(true);
					IEDaysOverduetxt.setEditable(true);
				} else {
					IEDaysOverduelbl.setEnabled(false);
					IEDaysOverduetxt.setEnabled(false);
				}
			}
		});
		IEOverdueCombobox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEOverdueCombobox.setEnabled(false);
		IEOverdueCombobox.setBounds(414, 229, 174, 22);
		IEOverdueCombobox.addItem("Yes");
		IEOverdueCombobox.addItem("No");
		IEOverdueCombobox.setSelectedItem(null);
		IE.add(IEOverdueCombobox);
		
		final JComboBox<String> IECategoryCombobox = new JComboBox<String>();
		IECategoryCombobox.setBackground(Color.WHITE);
		IECategoryCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String member = (String)IEMemberCombobox.getSelectedItem();
				if(member != null) {
					try {
						
						char[] a = member.toCharArray();
						char[] b = {a[2],a[3]};
						String memberfinal = String.valueOf(b);
						String movieCategory = (String)IECategoryCombobox.getSelectedItem();
						
						Connection conn = DriverManager.getConnection(databaseURL);
						String query = "SELECT * FROM "+movieCategory+" WHERE Lent_To = '"+memberfinal+"'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs1 = pst.executeQuery();
						
						IETable.setModel(DbUtils.resultSetToTableModel(rs1));
						if(movieCategory == "Borrowed_Movies") {
							IEMovieIDtxt.setText("");
							IEMovieNametxt.setText("");
							IEChargetxt.setText("");
							IEDaysOverduetxt.setText("");
							IEConditionCombobox.setSelectedItem(null);
							IEErrorslbl.setText("");
							IEMemberIDtxt.setText(null);
							IEOverdueCombobox.setSelectedItem(null);
							
							IEOverduelbl.setEnabled(true);
							IEOverdueCombobox.setEnabled(true);
							IEConditionlbl.setEnabled(true);
							IEConditionCombobox.setEnabled(true);
							IEDaysOverduelbl.setEnabled(false);
							IEDaysOverduetxt.setEnabled(false);
							
							ieBorrowedMoviesTableLayout();

							IECategoryTitlelbl.setText("Borrowed Movies");
						} else if(movieCategory == "Overdue_Movies") {
							IEMovieIDtxt.setText("");
							IEMovieNametxt.setText("");
							IEChargetxt.setText("");
							IEDaysOverduetxt.setText("");
							IEConditionCombobox.setSelectedItem(null);
							IEErrorslbl.setText("");
							IEOverdueCombobox.setSelectedItem(null);
													
							IEConditionlbl.setEnabled(false);
							IEConditionCombobox.setEnabled(false);
							IEDaysOverduelbl.setEnabled(true);
							IEDaysOverduetxt.setEnabled(true);
							IEDaysOverduetxt.setEditable(false);
							IEDaysOverduetxt.setBackground(Color.WHITE);
							IEOverduelbl.setEnabled(false);
							IEOverdueCombobox.setEnabled(false);
							
							ieOverdueMoviesTableLayout();
							IECategoryTitlelbl.setText("Overdue Movies");
						} else {
							IEMovieIDtxt.setText("");
							IEMovieNametxt.setText("");
							IEChargetxt.setText("");
							IEDaysOverduetxt.setText("");
							IEConditionCombobox.setSelectedItem(null);
							IEErrorslbl.setText("");
							IEOverdueCombobox.setSelectedItem(null);
						
							IEConditionlbl.setEnabled(false);
							IEConditionCombobox.setEnabled(false);
							IEDaysOverduelbl.setEnabled(false);
							IEDaysOverduetxt.setEnabled(false);
							IEOverduelbl.setEnabled(false);
							IEOverdueCombobox.setEnabled(false);
							
							ieDamagedMoviesTableLayout();
							IECategoryTitlelbl.setText("Damaged Movies");
						}
						
						rs1.close();
						conn.close();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		IECategoryCombobox.setEnabled(false);
		IECategoryCombobox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IECategoryCombobox.setBounds(460, 43, 159, 22);
		IECategoryCombobox.addItem("Borrowed_Movies");
		IECategoryCombobox.addItem("Overdue_Movies");
		IECategoryCombobox.addItem("Damaged_Movies");
		IECategoryCombobox.setSelectedItem(null);
		IE.add(IECategoryCombobox);
		IEMemberCombobox.setBackground(Color.WHITE);
		
		
		IEMemberCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String member = (String)IEMemberCombobox.getSelectedItem();
				String category = (String)IECategoryCombobox.getSelectedItem();
				
				if(member != null) {
					IECategoryCombobox.setEnabled(true);
					IECategorylbl.setEnabled(true);
					if(category != null) {
						try {
							
							char[] a = member.toCharArray();
							char[] b = {a[2],a[3]};
							String memberfinal = String.valueOf(b);
							String movieCategory = (String)IECategoryCombobox.getSelectedItem();
							
							Connection conn = DriverManager.getConnection(databaseURL);
							String query = "SELECT * FROM "+movieCategory+" WHERE Lent_To = '"+memberfinal+"'";
							PreparedStatement pst = conn.prepareStatement(query);
							ResultSet rs1 = pst.executeQuery();
							
							IETable.setModel(DbUtils.resultSetToTableModel(rs1));
							if(movieCategory == "Borrowed_Movies") {
								IEMovieIDtxt.setText("");
								IEMovieNametxt.setText("");
								IEChargetxt.setText("");
								IEDaysOverduetxt.setText("");
								IEConditionCombobox.setSelectedItem(null);
								IEErrorslbl.setText("");
								IEMemberIDtxt.setText(null);
								IEOverdueCombobox.setSelectedItem(null);
								
								IEOverduelbl.setEnabled(true);
								IEOverdueCombobox.setEnabled(true);
								IEConditionlbl.setEnabled(true);
								IEConditionCombobox.setEnabled(true);
								IEDaysOverduelbl.setEnabled(false);
								IEDaysOverduetxt.setEnabled(false);
								
								ieBorrowedMoviesTableLayout();

								IECategoryTitlelbl.setText("Borrowed Movies");
							} else if(movieCategory == "Overdue_Movies") {
								IEMovieIDtxt.setText("");
								IEMovieNametxt.setText("");
								IEChargetxt.setText("");
								IEDaysOverduetxt.setText("");
								IEConditionCombobox.setSelectedItem(null);
								IEErrorslbl.setText("");
								IEOverdueCombobox.setSelectedItem(null);
														
								IEConditionlbl.setEnabled(false);
								IEConditionCombobox.setEnabled(false);
								IEDaysOverduelbl.setEnabled(true);
								IEDaysOverduetxt.setEnabled(true);
								IEDaysOverduetxt.setEditable(false);
								IEDaysOverduetxt.setBackground(Color.WHITE);
								IEOverduelbl.setEnabled(false);
								IEOverdueCombobox.setEnabled(false);
								
								ieOverdueMoviesTableLayout();
								IECategoryTitlelbl.setText("Overdue Movies");
							} else {
								IEMovieIDtxt.setText("");
								IEMovieNametxt.setText("");
								IEChargetxt.setText("");
								IEDaysOverduetxt.setText("");
								IEConditionCombobox.setSelectedItem(null);
								IEErrorslbl.setText("");
								IEOverdueCombobox.setSelectedItem(null);
							
								IEConditionlbl.setEnabled(false);
								IEConditionCombobox.setEnabled(false);
								IEDaysOverduelbl.setEnabled(false);
								IEDaysOverduetxt.setEnabled(false);
								IEOverduelbl.setEnabled(false);
								IEOverdueCombobox.setEnabled(false);
								
								ieDamagedMoviesTableLayout();
								IECategoryTitlelbl.setText("Damaged Movies");
							}
							
							rs1.close();
							conn.close();
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				} else {
					IECategoryCombobox.setEnabled(false);
					IECategorylbl.setEnabled(false);
				}
			}
		});
		IEMemberCombobox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEMemberCombobox.setBounds(64, 43, 81, 22);
		IEMemberCombobox.setSelectedItem(null);
		IE.add(IEMemberCombobox);
		
		IECategoryTitlelbl = new JLabel("");
		IECategoryTitlelbl.setForeground(Color.RED);
		IECategoryTitlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		IECategoryTitlelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IECategoryTitlelbl.setBounds(224, 47, 181, 14);
		IE.add(IECategoryTitlelbl);
		
		JScrollPane IETableScrollpane = new JScrollPane();
		IETableScrollpane.setBounds(10, 71, 609, 122);
		IE.add(IETableScrollpane);
		
		IETable = new JTable();
		IETable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		IETable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String category = (String)IECategoryCombobox.getSelectedItem();
				
				if(category.equals("Borrowed_Movies")) {
					IEConditionlbl.setEnabled(true);
					IEConditionCombobox.setEnabled(true);
					IEDaysOverduelbl.setEnabled(false);
					IEDaysOverduetxt.setEnabled(false);
					IEOverdueCombobox.setSelectedItem(null);
					
					IEOverduelbl.setEnabled(true);
					IEOverdueCombobox.setEnabled(true);
					int row = IETable.getSelectedRow();
					String movieId = String.valueOf(IETable.getValueAt(row, 0));
					String lentTo = String.valueOf(IETable.getValueAt(row, 1));
					String moviename = String.valueOf(IETable.getValueAt(row, 2));
					int charge = Integer.parseInt(String.valueOf(IETable.getValueAt(row, 5)));
					String charge1 = String.valueOf(charge);
					
					IEMovieIDtxt.setText(movieId);
					IEMovieNametxt.setText(moviename);
					IEChargetxt.setText(charge1);
					IEMemberIDtxt.setText(lentTo);
				} else if(category.equals("Overdue_Movies")) {
					
					IEDaysOverduelbl.setEnabled(true);
					IEDaysOverduetxt.setEnabled(true);
					IEDaysOverduetxt.setEditable(false);
					IEDaysOverduetxt.setBackground(Color.WHITE);
					IEConditionlbl.setEnabled(false);
					IEConditionCombobox.setEnabled(false);
					IEOverdueCombobox.setSelectedItem(null);
					
					IEOverduelbl.setEnabled(false);
					IEOverdueCombobox.setEnabled(false);
					int row = IETable.getSelectedRow();
					String movieId = String.valueOf(IETable.getValueAt(row, 0));
					String lentTo = String.valueOf(IETable.getValueAt(row, 1));
					String moviename = String.valueOf(IETable.getValueAt(row, 2));
					String daysOverdue = String.valueOf(IETable.getValueAt(row, 3));
					int charge = Integer.parseInt(String.valueOf(IETable.getValueAt(row, 4)));
					String charge1 = String.valueOf(charge);
					
					IEMovieIDtxt.setText(movieId);
					IEMovieNametxt.setText(moviename);
					IEChargetxt.setText(charge1);
					IEMemberIDtxt.setText(lentTo);
					IEDaysOverduetxt.setText(daysOverdue);
				} else {
					
					IEDaysOverduelbl.setEnabled(false);
					IEDaysOverduetxt.setEnabled(false);
					IEConditionlbl.setEnabled(false);
					IEConditionCombobox.setEnabled(false);
					IEOverdueCombobox.setSelectedItem(null);
					
					IEOverduelbl.setEnabled(false);
					IEOverdueCombobox.setEnabled(false);
					int row = IETable.getSelectedRow();
					String movieId = String.valueOf(IETable.getValueAt(row, 0));
					String lentTo = String.valueOf(IETable.getValueAt(row, 1));
					String moviename = String.valueOf(IETable.getValueAt(row, 2));
					int charge = Integer.parseInt(String.valueOf(IETable.getValueAt(row, 3)));
					String charge1 = String.valueOf(charge);
					
					IEMovieIDtxt.setText(movieId);
					IEMovieNametxt.setText(moviename);
					IEChargetxt.setText(charge1);
					IEMemberIDtxt.setText(lentTo);
				}
		
			}
		});
		IETableScrollpane.setViewportView(IETable);
		IETable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Movie_ID", "Lent_To", "Movie_Name", "Date_Lent", "Date_Due", "Charge"
			}
		));
		IETable.getColumnModel().getColumn(0).setPreferredWidth(67);
		IETable.getColumnModel().getColumn(1).setPreferredWidth(55);
		IETable.getColumnModel().getColumn(2).setPreferredWidth(157);
		IETable.getColumnModel().getColumn(3).setPreferredWidth(83);
		IETable.getColumnModel().getColumn(4).setPreferredWidth(78);
		IETable.getColumnModel().getColumn(5).setPreferredWidth(54);
		IETable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IETable.setRowHeight(20);
		
		JLabel IEClearDebtlbl = new JLabel("Clear Debt");
		IEClearDebtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		IEClearDebtlbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		IEClearDebtlbl.setBounds(10, 195, 609, 24);
		IE.add(IEClearDebtlbl);
		
		JLabel IEMovieIDlbl = new JLabel("Movie ID:");
		IEMovieIDlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEMovieIDlbl.setBounds(43, 231, 75, 14);
		IE.add(IEMovieIDlbl);
		
		JLabel IEMovieNamelbl = new JLabel("Movie Name:");
		IEMovieNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEMovieNamelbl.setBounds(43, 256, 75, 14);
		IE.add(IEMovieNamelbl);
		
		JLabel IEChargelbl = new JLabel("Charge:");
		IEChargelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEChargelbl.setBounds(43, 281, 75, 14);
		IE.add(IEChargelbl);
		
		IEConditionlbl = new JLabel("Condition:");
		IEConditionlbl.setEnabled(false);
		IEConditionlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEConditionlbl.setBounds(318, 281, 94, 14);
		IE.add(IEConditionlbl);
		
		JButton IEClearbtn = new JButton("Remove from Charge Sheet");
		IEClearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = (String)IECategoryCombobox.getSelectedItem();
				String movieId = IEMovieIDtxt.getText();
				String lentTo = IEMemberIDtxt.getText();
				String moviename = IEMovieNametxt.getText();
				String charge = IEChargetxt.getText();
				String daysOverdueInput = IEDaysOverduetxt.getText();
				String condition = (String)IEConditionCombobox.getSelectedItem();
				String overdue = (String)IEOverdueCombobox.getSelectedItem();
				
				if(category.equals("Borrowed_Movies")) {
					if((movieId.isBlank() == false) && (lentTo.isBlank() == false) && (moviename.isBlank() == false)
							&& (charge.isBlank() == false) && (condition != null) && (overdue != null)) {
						
						IEErrorslbl.setText("");
						
						if(overdue.equals("Yes")) {
							
							if((daysOverdueInput.isBlank()) == false) {
								
								int chargeOverdue;
								if(movieId.contains("COM")) {
									chargeOverdue = 42;
								} else if(movieId.contains("GEN")) {
									chargeOverdue = 30;
								} else if(movieId.contains("HOR")) {
									chargeOverdue = 24;
								} else if(movieId.contains("THR")) {
									chargeOverdue = 36;
								} else {
									chargeOverdue = 48;
								}
								
								int overdueDays = Integer.parseInt(daysOverdueInput);
								int daysOverdue = (overdueDays >= 14) ? 14 : overdueDays;
								String chargeFinal = String.valueOf(chargeOverdue * daysOverdue);
								
								if(condition.equals("Good")) {
									insertToOverdueMovies(movieId, lentTo, moviename, daysOverdueInput, chargeFinal);
									deleteFromBorrowedMovie(movieId, lentTo, IETable);
									dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
									ieBorrowedMoviesTableLayout();
								} else {
									insertToOverdueMovies(movieId, lentTo, moviename, daysOverdueInput, chargeFinal);
									insertToDamagedMovies(movieId, lentTo, moviename);
									deleteFromBorrowedMovie(movieId, lentTo, IETable);
									dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
									ieBorrowedMoviesTableLayout();
								}
							} else {
								IEErrorslbl.setText("Specify the days overdue");
							}
							
						} else {
							if(condition.equals("Good")) {
								deleteFromBorrowedMovie(movieId, lentTo, IETable);
								dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
								ieBorrowedMoviesTableLayout();
							} else {
								insertToDamagedMovies(movieId, lentTo, moviename); 
								deleteFromBorrowedMovie(movieId, lentTo, IETable);
								dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
								ieBorrowedMoviesTableLayout();
							}
						}
					} else {
						IEErrorslbl.setText("Please select a record from the table, choose it's condition and if it is Overdue");
					}
				} else if(category.equals("Overdue_Movies")) {
					if((movieId.isBlank() == false) && (lentTo.isBlank() == false) && (moviename.isBlank() == false) 
							&& (charge.isBlank() == false) && (daysOverdueInput.isBlank() == false)) {	
						IEErrorslbl.setText("");
						int daysOverdue = Integer.parseInt(daysOverdueInput);
						if(daysOverdue >= 14){
							insertToDamagedMovies(movieId, lentTo, moviename);
							returnOverdueMovie(charge, movieId, lentTo, IETable);
							dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
							ieOverdueMoviesTableLayout();
						} else {
							returnOverdueMovie(charge, movieId, lentTo, IETable);
							dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
							ieOverdueMoviesTableLayout();
						}
					} else {
						IEErrorslbl.setText("Please select a record from the table");
					}
				} else {
					if((movieId.isBlank() == false) && (lentTo.isBlank() == false) && (moviename.isBlank() == false) && (charge.isBlank() == false)) {
						IEErrorslbl.setText("");
						removefromDamagedMovies(movieId, lentTo, IETable);
						dbTableViewerwithCondition(IETable, category, "Movie_ID", movieId);
						ieDamagedMoviesTableLayout();
					} else {
						IEErrorslbl.setText("Please select a record from the table");
					}
				}
			}
		});
		IEClearbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IEClearbtn.setBounds(211, 310, 206, 23);
		IE.add(IEClearbtn);
		
		JLabel IncomeandAllocationsTotalIncomelbl = new JLabel("Total Income");
		IncomeandAllocationsTotalIncomelbl.setHorizontalAlignment(SwingConstants.CENTER);
		IncomeandAllocationsTotalIncomelbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		IncomeandAllocationsTotalIncomelbl.setBounds(10, 71, 609, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsTotalIncomelbl);
		
		IncomeandAllocationsTotalIncometxt = new JTextField();
		IncomeandAllocationsTotalIncometxt.setHorizontalAlignment(SwingConstants.CENTER);
		IncomeandAllocationsTotalIncometxt.setForeground(Color.RED);
		IncomeandAllocationsTotalIncometxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IncomeandAllocationsTotalIncometxt.setEditable(false);
		IncomeandAllocationsTotalIncometxt.setColumns(10);
		IncomeandAllocationsTotalIncometxt.setBackground(Color.WHITE);
		IncomeandAllocationsTotalIncometxt.setBounds(272, 98, 85, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsTotalIncometxt);
		
		JLabel IncomeandAllocationsAllocationslbl = new JLabel("Allocations");
		IncomeandAllocationsAllocationslbl.setHorizontalAlignment(SwingConstants.CENTER);
		IncomeandAllocationsAllocationslbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		IncomeandAllocationsAllocationslbl.setBounds(10, 149, 609, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsAllocationslbl);
		
		JLabel IncomeandAllocationsSalarieslbl = new JLabel("Salaries:");
		IncomeandAllocationsSalarieslbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IncomeandAllocationsSalarieslbl.setBounds(32, 196, 117, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsSalarieslbl);
		
		IncomeandAllocationsSalariestxt = new JTextField();
		IncomeandAllocationsSalariestxt.setForeground(Color.BLUE);
		IncomeandAllocationsSalariestxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IncomeandAllocationsSalariestxt.setEditable(false);
		IncomeandAllocationsSalariestxt.setColumns(10);
		IncomeandAllocationsSalariestxt.setBackground(Color.WHITE);
		IncomeandAllocationsSalariestxt.setBounds(148, 196, 136, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsSalariestxt);
		
		JLabel IncomeandAllocationsClubDevelopmentlbl = new JLabel("Club Development:");
		IncomeandAllocationsClubDevelopmentlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IncomeandAllocationsClubDevelopmentlbl.setBounds(313, 196, 136, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsClubDevelopmentlbl);
		
		IncomeandAllocationsClubDevelopmenttxt = new JTextField();
		IncomeandAllocationsClubDevelopmenttxt.setForeground(Color.BLUE);
		IncomeandAllocationsClubDevelopmenttxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IncomeandAllocationsClubDevelopmenttxt.setEditable(false);
		IncomeandAllocationsClubDevelopmenttxt.setColumns(10);
		IncomeandAllocationsClubDevelopmenttxt.setBackground(Color.WHITE);
		IncomeandAllocationsClubDevelopmenttxt.setBounds(459, 196, 136, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsClubDevelopmenttxt);
		
		IncomeandAllocationsAdministrationtxt = new JTextField();
		IncomeandAllocationsAdministrationtxt.setForeground(Color.BLUE);
		IncomeandAllocationsAdministrationtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IncomeandAllocationsAdministrationtxt.setEditable(false);
		IncomeandAllocationsAdministrationtxt.setColumns(10);
		IncomeandAllocationsAdministrationtxt.setBackground(Color.WHITE);
		IncomeandAllocationsAdministrationtxt.setBounds(148, 233, 136, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsAdministrationtxt);
		
		JLabel IncomeandAllocationsAdministrationlbl = new JLabel("Administration:");
		IncomeandAllocationsAdministrationlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IncomeandAllocationsAdministrationlbl.setBounds(32, 233, 117, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsAdministrationlbl);
		
		JLabel IncomeandAllocationsMiscellaneouslbl = new JLabel("Miscellaneous:");
		IncomeandAllocationsMiscellaneouslbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IncomeandAllocationsMiscellaneouslbl.setBounds(32, 270, 117, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsMiscellaneouslbl);
		
		IncomeandAllocationsMiscellaneoustxt = new JTextField();
		IncomeandAllocationsMiscellaneoustxt.setForeground(Color.BLUE);
		IncomeandAllocationsMiscellaneoustxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IncomeandAllocationsMiscellaneoustxt.setEditable(false);
		IncomeandAllocationsMiscellaneoustxt.setColumns(10);
		IncomeandAllocationsMiscellaneoustxt.setBackground(Color.WHITE);
		IncomeandAllocationsMiscellaneoustxt.setBounds(148, 270, 136, 26);
		IncomeandAllocationsPanel.add(IncomeandAllocationsMiscellaneoustxt);
		
		lblMovieName = new JLabel("Movie Name:");
		lblMovieName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieName.setBounds(29, 168, 118, 26);
		AddMovie.add(lblMovieName);
		
		txtMovieName = new JTextField();
		txtMovieName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieName.setColumns(10);
		txtMovieName.setBounds(152, 172, 237, 22);
		txtMovieName.setDocument(new JTextFieldLimit(40));
		AddMovie.add(txtMovieName);
		
		lblProductionCompany = new JLabel("Production Company:");
		lblProductionCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductionCompany.setBounds(29, 202, 118, 22);
		AddMovie.add(lblProductionCompany);
		
		txtProductionCompany = new JTextField();
		txtProductionCompany.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtProductionCompany.setColumns(10);
		txtProductionCompany.setBounds(152, 202, 237, 22);
		txtProductionCompany.setDocument(new JTextFieldLimit(30));
		AddMovie.add(txtProductionCompany);
		
		lblReleaseYear = new JLabel("Release Year:");
		lblReleaseYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReleaseYear.setBounds(29, 227, 118, 26);
		AddMovie.add(lblReleaseYear);
		
		txtReleaseYear = new JTextField();
		txtReleaseYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblErrorsAddMovie.setText("Enter a number");
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblErrorsAddMovie.setText("");
			}
		});
		txtReleaseYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtReleaseYear.setColumns(10);
		txtReleaseYear.setBounds(152, 231, 237, 22);
		txtReleaseYear.setDocument(new JTextFieldLimit(4));
		AddMovie.add(txtReleaseYear);
		
		lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRating.setBounds(29, 256, 118, 26);
		AddMovie.add(lblRating);
		
		txtRating = new JTextField();
		txtRating.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblErrorsAddMovie.setText("Enter a decimal number, say, 9.0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblErrorsAddMovie.setText("");
			}
		});
		txtRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRating.setColumns(10);
		txtRating.setBounds(152, 260, 237, 22);
		txtRating.setDocument(new JTextFieldLimit(3));
		AddMovie.add(txtRating);
		
		lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStock.setBounds(29, 285, 118, 26);
		AddMovie.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblErrorsAddMovie.setText("Enter a number");
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblErrorsAddMovie.setText("Enter a number");
			}
		});
		txtStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtStock.setColumns(10);
		txtStock.setBounds(152, 289, 237, 22);
		txtStock.setDocument(new JTextFieldLimit(2));
		AddMovie.add(txtStock);
		
		lblGenre1 = new JLabel("Genre");
		lblGenre1.setBackground(Color.LIGHT_GRAY);
		lblGenre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenre1.setBounds(10, 78, 394, 20);
		AddMovie.add(lblGenre1);
		
		MovieGenre1 = new JComboBox<String>();
		MovieGenre1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MovieGenre1.setBounds(152, 98, 106, 22);
		AddMovie.add(MovieGenre1);
		MovieGenre1.addItem("Comedy");
		MovieGenre1.addItem("General");
		MovieGenre1.addItem("Horror");
		MovieGenre1.addItem("Thriller");
		MovieGenre1.addItem("Cartoon");
		MovieGenre1.setSelectedItem("Comedy");
		
		btnAddMovie2 = new JButton("Add Movie");
		btnAddMovie2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String moviename = txtMovieName.getText();
				String productioncompany = txtProductionCompany.getText();
				String releaseyear = txtReleaseYear.getText();
				String movierating = txtRating.getText();
				String moviestock = txtStock.getText();
				String genre = (String) MovieGenre1.getSelectedItem();
				
				if((moviename.isBlank() == false) && (productioncompany.isBlank() == false) && (releaseyear.isBlank() == false) && (movierating.isBlank() == false)
					&& (moviestock.isBlank() == false) && (genre != null)) {
					try {
						Connection conn = DriverManager.getConnection(databaseURL);
						String query1 = "INSERT INTO "+genre+" (Movie_ID, Movie_Name, Production_Company, Release_Year, Rating, Stock) "
									 + "VALUES ('"+moviename+"', '"+productioncompany+"', '"+releaseyear+"', '"+movierating+"', '"+moviestock+"', '"+moviestock+"')";
						String query2 = "INSERT INTO EntireMovieDatabase (Movie_ID, Movie_Name, Production_Company, Release_Year, Rating, Stock) "
								 	  + "VALUES ('"+moviename+"', '"+productioncompany+"', '"+releaseyear+"', '"+movierating+"', '"+moviestock+"', '"+moviestock+"')";
														
						PreparedStatement pst1 = conn.prepareStatement(query1);
						PreparedStatement pst2 = conn.prepareStatement(query2);
						pst1.executeUpdate();
						pst2.executeUpdate();	
						JOptionPane.showMessageDialog(null, "Movie Added Successfully");
						btnDatabaseViewer(AdminMovieCatalog, genre);
						adminMovieCatalogLayout();
						
						txtMovieIDAddMovie.setText(null);
						txtMovieName.setText(null);
						txtProductionCompany.setText(null);
						txtReleaseYear.setText(null);
						txtRating.setText(null);
						txtStock.setText(null);
						MovieGenre1.setSelectedItem(null);
						lblErrorsAddMovie.setText(null);
												
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"Movie Addition Unsuccessful");
					}
				} else {
					lblErrorsAddMovie.setText("Please chooose a genre and fill in all other entries");
				}
				
			}
		});
		btnAddMovie2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddMovie2.setBounds(110, 334, 99, 26);
		AddMovie.add(btnAddMovie2);
		
		btnClear2 = new JButton("Clear");
		btnClear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMovieName.setText("");
				txtProductionCompany.setText("");
				txtReleaseYear.setText("");
				txtRating.setText("");
				txtStock.setText("");
				lblErrorsAddMovie.setText("");
				MovieGenre1.setSelectedItem(null);
			}
		});
		btnClear2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear2.setBounds(209, 334, 99, 26);
		AddMovie.add(btnClear2);
		
		btnBackMovieAdder = new JButton("Back");
		btnBackMovieAdder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setVisible(true);
				MovieManager.setVisible(false);
				AddMovie.setVisible(false);
				DeleteMovie.setVisible(false);
			}
		});
		btnBackMovieAdder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackMovieAdder.setBounds(165, 362, 89, 26);
		AddMovie.add(btnBackMovieAdder);
		
		lblAddMovie = new JLabel("Add Movie");
		lblAddMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMovie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddMovie.setBounds(10, 41, 394, 26);
		AddMovie.add(lblAddMovie);
		
		txtMovieIDAddMovie = new JTextField();
		txtMovieIDAddMovie.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblErrorsAddMovie.setText("Enter a number");
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblErrorsAddMovie.setText("");
			}
		});
		txtMovieIDAddMovie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDAddMovie.setColumns(10);
		txtMovieIDAddMovie.setBounds(152, 141, 237, 22);
		txtMovieIDAddMovie.setDocument(new JTextFieldLimit(3));
		AddMovie.add(txtMovieIDAddMovie);
		
		lblErrorsAddMovie = new JLabel("");
		lblErrorsAddMovie.setForeground(Color.RED);
		lblErrorsAddMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsAddMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsAddMovie.setBounds(10, 11, 394, 26);
		AddMovie.add(lblErrorsAddMovie);
		
		lblMovieIDAddMovie = new JLabel("Movie ID:");
		lblMovieIDAddMovie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDAddMovie.setBounds(29, 138, 118, 26);
		AddMovie.add(lblMovieIDAddMovie);
		
		
		
		MovieGenre2 = new JComboBox<String>();
		MovieGenre2.setBackground(Color.WHITE);
		MovieGenre2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MovieGenre2.setBounds(157, 143, 106, 22);
		DeleteMovie.add(MovieGenre2);
		MovieGenre2.addItem("Comedy");
		MovieGenre2.addItem("General");
		MovieGenre2.addItem("Horror");
		MovieGenre2.addItem("Thriller");
		MovieGenre2.addItem("Cartoon");
		MovieGenre2.setSelectedItem("Comedy");
		
		lblMovieID = new JLabel("Movie ID:");
		lblMovieID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieID.setBounds(41, 188, 75, 21);
		DeleteMovie.add(lblMovieID);
		
		txtMovieID = new JTextField();
		txtMovieID.setBackground(Color.WHITE);
		txtMovieID.setEditable(false);
		txtMovieID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieID.setColumns(10);
		txtMovieID.setBounds(118, 187, 257, 22);
		DeleteMovie.add(txtMovieID);
		
		lblMovieName2 = new JLabel("Movie Name:");
		lblMovieName2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieName2.setBounds(41, 215, 75, 21);
		DeleteMovie.add(lblMovieName2);
		
		txtMovieName2 = new JTextField();
		txtMovieName2.setBackground(Color.WHITE);
		txtMovieName2.setEditable(false);
		txtMovieName2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieName2.setColumns(10);
		txtMovieName2.setBounds(118, 214, 257, 22);
		DeleteMovie.add(txtMovieName2);
		
		btnDeleteMovie2 = new JButton("Delete Movie");
		btnDeleteMovie2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String movieId = txtMovieID.getText();
				String moviename = txtMovieName2.getText();
				String genre = (String)MovieGenre2.getSelectedItem();
				
				if((movieId.isBlank() == false) && (moviename.isBlank() == false) && (genre != null)) {
					try {
						Connection conn = DriverManager.getConnection(databaseURL);
						String query1 = "DELETE FROM "+genre+" "
									  + "WHERE Movie_ID = '"+movieId+"' AND Movie_Name = '"+moviename+"'";
						String query2 = "DELETE FROM EntireMovieDatabase "
								 + "WHERE Movie_ID = '"+movieId+"' AND Movie_Name = '"+moviename+"'";
						PreparedStatement pst1 = conn.prepareStatement(query1);
						PreparedStatement pst2 = conn.prepareStatement(query2);
						
						pst1.executeUpdate();
						pst2.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Movie Removed from the Catalog");
						btnDatabaseViewer(AdminMovieCatalog, genre);
						adminMovieCatalogLayout();
						
						MovieGenre2.setSelectedItem(null);
						txtMovieID.setText(null);
						txtMovieName2.setText(null);
						lblErrorsDeleteMovie.setText("");
						
						pst1.close();
						pst2.close();
						conn.close();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Removal Unsuccessful.");
					}
				}else {
					lblErrorsDeleteMovie.setText("Please choose a genre and fill in all other entries");
				}
				
			}
		});
		btnDeleteMovie2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteMovie2.setBounds(102, 259, 106, 26);
		DeleteMovie.add(btnDeleteMovie2);
		
		btnClear3 = new JButton("Clear");
		btnClear3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMovieID.setText("");
				txtMovieName2.setText("");
				MovieGenre2.setSelectedItem(null);
				lblErrorsDeleteMovie.setText("");
			}
		});
		btnClear3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear3.setBounds(210, 259, 106, 26);
		DeleteMovie.add(btnClear3);
		
		btnBackDeleteMovie = new JButton("Back");
		btnBackDeleteMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setVisible(true);
				MovieManager.setVisible(false);
				AddMovie.setVisible(false);
				DeleteMovie.setVisible(false);
			}
		});
		btnBackDeleteMovie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBackDeleteMovie.setBounds(165, 285, 89, 26);
		DeleteMovie.add(btnBackDeleteMovie);
		
		lblGenre2 = new JLabel("Genre");
		lblGenre2.setBackground(Color.LIGHT_GRAY);
		lblGenre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenre2.setBounds(10, 120, 394, 20);
		DeleteMovie.add(lblGenre2);
		
		lblDeleteMovie = new JLabel("Delete Movie");
		lblDeleteMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteMovie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeleteMovie.setBounds(10, 84, 394, 26);
		DeleteMovie.add(lblDeleteMovie);
		
		lblErrorsDeleteMovie = new JLabel("");
		lblErrorsDeleteMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsDeleteMovie.setForeground(Color.RED);
		lblErrorsDeleteMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsDeleteMovie.setBounds(20, 322, 394, 26);
		DeleteMovie.add(lblErrorsDeleteMovie);
		
		JLabel lblMovieManagerPanel = new JLabel("UPEPEO");
		lblMovieManagerPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieManagerPanel.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		lblMovieManagerPanel.setBounds(10, 11, 835, 49);
		MovieManager.add(lblMovieManagerPanel);
		
		UserMovieSearch = new JPanel();
		frmUpepeoVideoLending.getContentPane().add(UserMovieSearch, "name_183884840352300");
		UserMovieSearch.setLayout(null);
		
		JLabel lblUPEPEOSearchPanel = new JLabel("UPEPEO");
		lblUPEPEOSearchPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblUPEPEOSearchPanel.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		lblUPEPEOSearchPanel.setBounds(10, 11, 835, 49);
		UserMovieSearch.add(lblUPEPEOSearchPanel);
		
		JLabel lblShowingResultsFor = new JLabel("Showing Search Results for:");
		lblShowingResultsFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowingResultsFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblShowingResultsFor.setBounds(10, 60, 835, 24);
		UserMovieSearch.add(lblShowingResultsFor);
		
		lblSearchMovie = new JLabel("");
		lblSearchMovie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMovie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMovie.setBounds(10, 84, 835, 24);
		UserMovieSearch.add(lblSearchMovie);
		
		JPanel BorrowMovieSearchpanel = new JPanel();
		BorrowMovieSearchpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		BorrowMovieSearchpanel.setBounds(586, 119, 259, 336);
		UserMovieSearch.add(BorrowMovieSearchpanel);
		BorrowMovieSearchpanel.setLayout(null);
		
		JLabel lblBorrowMoviesearchMoviepanel = new JLabel("Borrow Movie");
		lblBorrowMoviesearchMoviepanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowMoviesearchMoviepanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBorrowMoviesearchMoviepanel.setBounds(10, 45, 239, 26);
		BorrowMovieSearchpanel.add(lblBorrowMoviesearchMoviepanel);
		
		JLabel lblMovieIDsearchMoviePanel = new JLabel("Movie ID:");
		lblMovieIDsearchMoviePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieIDsearchMoviePanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieIDsearchMoviePanel.setBounds(10, 82, 239, 20);
		BorrowMovieSearchpanel.add(lblMovieIDsearchMoviePanel);
		
		txtMovieIDsearchMoviePanel = new JTextField();
		txtMovieIDsearchMoviePanel.setBackground(Color.WHITE);
		txtMovieIDsearchMoviePanel.setEditable(false);
		txtMovieIDsearchMoviePanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieIDsearchMoviePanel.setColumns(10);
		txtMovieIDsearchMoviePanel.setBounds(10, 103, 239, 26);
		BorrowMovieSearchpanel.add(txtMovieIDsearchMoviePanel);
		
		JLabel lblMovieNamesearchMoviePanel = new JLabel("Movie Name:");
		lblMovieNamesearchMoviePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieNamesearchMoviePanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMovieNamesearchMoviePanel.setBounds(10, 138, 239, 20);
		BorrowMovieSearchpanel.add(lblMovieNamesearchMoviePanel);
		
		txtMovieNamesearchMoviePanel = new JTextField();
		txtMovieNamesearchMoviePanel.setBackground(Color.WHITE);
		txtMovieNamesearchMoviePanel.setEditable(false);
		txtMovieNamesearchMoviePanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMovieNamesearchMoviePanel.setColumns(10);
		txtMovieNamesearchMoviePanel.setBounds(10, 158, 239, 26);
		BorrowMovieSearchpanel.add(txtMovieNamesearchMoviePanel);
		
		JButton btnBorrowsearchMoviepanel = new JButton(" Borrow");
		btnBorrowsearchMoviepanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String movieId = txtMovieIDsearchMoviePanel.getText();
				int lentTo = Integer.parseInt(lblUserMovieSearchMemberID.getText());
				String moviename = txtMovieNamesearchMoviePanel.getText();
				int charge = 0;
				String stock = txtStockEntireCatalog.getText();
				String table1 = null;
				int stock4 = (stock.isBlank() == true) ? 0 : (Integer.parseInt(stock));
				Date borrowingdate = txtBorrowingDatesearchMoviePaneldateChooser.getDate();
				
				if(movieId.contains("COM")) {
					charge = 70;
					table1 = "Comedy";
				} else if(movieId.contains("GEN")) {
					charge = 50;
					table1 = "General";
				} else if(movieId.contains("HOR")) {
					charge = 40;
					table1 = "Horror";
				} else if(movieId.contains("THR")) {
					charge = 60;
					table1 = "Thriller";
				} else {
					charge = 80;
					table1 = "Cartoon";
				}
				
				insertToBorrowedMovies(charge, stock4, lentTo, movieId, moviename, borrowingdate, BorrowMovieSearchpanel, txtMovieIDsearchMoviePanel, txtMovieNamesearchMoviePanel, txtBorrowingDatesearchMoviePaneldateChooser, lblErrorsUserMovieSearch, table1);
			
			}
		});
		btnBorrowsearchMoviepanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrowsearchMoviepanel.setBounds(74, 258, 113, 30);
		BorrowMovieSearchpanel.add(btnBorrowsearchMoviepanel);
		Image imgsearchMoviepanel = new ImageIcon(getClass().getClassLoader().getResource("Download.png")).getImage();
		btnBorrowsearchMoviepanel.setIcon(new ImageIcon(imgsearchMoviepanel));
		
		lblUserMovieSearchMemberID = new JLabel("");
		lblUserMovieSearchMemberID.setVisible(false);
		lblUserMovieSearchMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserMovieSearchMemberID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserMovieSearchMemberID.setBounds(10, 11, 239, 25);
		BorrowMovieSearchpanel.add(lblUserMovieSearchMemberID);
		
		JLabel lblBorrowingDatesearchMoviePanel = new JLabel("Borrowing Date:");
		lblBorrowingDatesearchMoviePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowingDatesearchMoviePanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBorrowingDatesearchMoviePanel.setBounds(10, 195, 239, 20);
		BorrowMovieSearchpanel.add(lblBorrowingDatesearchMoviePanel);
		
		txtBorrowingDatesearchMoviePaneldateChooser = new JDateChooser();
		txtBorrowingDatesearchMoviePaneldateChooser.setBounds(10, 216, 239, 26);
		BorrowMovieSearchpanel.add(txtBorrowingDatesearchMoviePaneldateChooser);
		txtBorrowingDatesearchMoviePaneldateChooser.setMaxSelectableDate(currentDate);
		txtBorrowingDatesearchMoviePaneldateChooser.setMinSelectableDate(currentDate);
		txtBorrowingDatesearchMoviePaneldateChooser.setDate(currentDate);
		JTextFieldDateEditor editorsearchMoviePanel = (JTextFieldDateEditor) txtBorrowingDatesearchMoviePaneldateChooser.getDateEditor();
		editorsearchMoviePanel.setEditable(false);
		editorsearchMoviePanel.setBackground(Color.WHITE);
		
		lblErrorsUserMovieSearch = new JLabel("");
		lblErrorsUserMovieSearch.setForeground(Color.RED);
		lblErrorsUserMovieSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorsUserMovieSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblErrorsUserMovieSearch.setBounds(10, 299, 239, 25);
		BorrowMovieSearchpanel.add(lblErrorsUserMovieSearch);
		
		txtStockEntireCatalog = new JTextField();
		txtStockEntireCatalog.setVisible(false);
		txtStockEntireCatalog.setEditable(false);
		txtStockEntireCatalog.setBounds(163, 304, 86, 20);
		BorrowMovieSearchpanel.add(txtStockEntireCatalog);
		txtStockEntireCatalog.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErrorsUserMovieSearch.setText("");
				UserMovieSearch.setVisible(false);
				SiteHome.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(782, 466, 63, 23);
		UserMovieSearch.add(btnNewButton);
		
		JScrollPane searchMovieScrollPane = new JScrollPane();
		searchMovieScrollPane.setBounds(10, 119, 571, 336);
		UserMovieSearch.add(searchMovieScrollPane);
		
		searchMovieTable = new JTable();
		searchMovieTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchMovieTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = searchMovieTable.getSelectedRow();
				String movieId = String.valueOf(searchMovieTable.getValueAt(row, 0));
				String moviename = String.valueOf(searchMovieTable.getValueAt(row, 1));
				String stock = String.valueOf(searchMovieTable.getValueAt(row, 5));
								
				txtMovieIDsearchMoviePanel.setText(movieId);
				txtMovieNamesearchMoviePanel.setText(moviename);
				txtStockEntireCatalog.setText(stock);
			}
		});
		searchMovieTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Movie_ID", "Movie_Name", "Production_Company", "Release_Year", "Rating", "Stock"
			}
		));
		searchMovieTable.getColumnModel().getColumn(0).setPreferredWidth(65);
		searchMovieTable.getColumnModel().getColumn(1).setPreferredWidth(194);
		searchMovieTable.getColumnModel().getColumn(2).setPreferredWidth(192);
		searchMovieTable.getColumnModel().getColumn(3).setPreferredWidth(85);
		searchMovieTable.getColumnModel().getColumn(4).setPreferredWidth(44);
		searchMovieTable.getColumnModel().getColumn(5).setPreferredWidth(40);
		searchMovieTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		searchMovieTable.setRowHeight(20);
		searchMovieScrollPane.setViewportView(searchMovieTable);
		searchMovieTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		String memberId;
		try {
			Connection conn = DriverManager.getConnection(databaseURL);
			String query = "SELECT * FROM Members";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs1 = pst.executeQuery();
			while(rs1.next()) {
				IEMemberCombobox.setSelectedItem(null);
				if(((rs1.isAfterLast()) == false) && ((rs1.isBeforeFirst()) == false)) {
					memberId = rs1.getString("Membership_ID");
					int membId = Integer.parseInt(memberId);
					if(membId<10) {
						String finalmember = String.valueOf(membId);
						IEMemberCombobox.addItem("M00" + finalmember);
					}else {
						String finalmember = String.valueOf(membId);
						IEMemberCombobox.addItem("M0" + finalmember);
					}
				}
				
			}
			pst.close();
			rs1.close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
