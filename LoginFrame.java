import java.util.*;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LoginFrame extends JFrame implements ActionListener{
	private JLabel logInAs, registration;
	private JButton administrator, owner, tenant, register;
	
	
	public LoginFrame(){
		super("Cyberjaya Online Rental Management ");
		
		logInAs = new JLabel("Log In As", JLabel.CENTER);
		registration = new JLabel("New User?", JLabel.CENTER);
		logInAs.setFont(new Font("Calibri", Font.BOLD, 20));
		logInAs.setPreferredSize(new Dimension(450,100));
		
		administrator = new JButton("Admin");
		owner = new JButton("Owner");
		tenant = new JButton("Tenant");
		register = new JButton("Register");
		
		administrator.setBounds(10,10,20,20);
		
		administrator.addActionListener(this);
		owner.addActionListener(this);
		tenant.addActionListener(this);
		register.addActionListener(this);
		
		JPanel p2 = new JPanel();
		JPanel p1 = new JPanel();
		p1.add(administrator);
		p1.add(owner);
		p1.add(tenant);
		p2.add(registration);
		p2.add(register);
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(4,2)); 
		c.add(logInAs);
		c.add(p1);
		c.add(p2);
	
		
		setSize(450,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==administrator){	//options for login 
			dispose();
			User.setX("");
			User.setX("Admin");
			InputFrame iFrame = new InputFrame();
		}
		else if(e.getSource()==owner){ //options for login 
			dispose();
			User.setX("");
			User.setX("Owner");
			InputFrame iFrame = new InputFrame(); 
		}
		else if(e.getSource()==tenant){ //options for login 
			dispose();
			User.setX("");
			User.setX("Tenant");
			InputFrame iFrame = new InputFrame();
		}
		else if(e.getSource()==register){ //options for login 
			dispose();
			RegistrationFrame rf = new RegistrationFrame(); //calls the registration frame for new registration
		}
	}

	public static ArrayList <Property> propertyList = new ArrayList<>(); //holds all property objects
	public static ArrayList <User> userList = new ArrayList<>(); //holds all user objects
	public static ArrayList <User> newUserList = new ArrayList<>();	// hold registered user objects
	
	public static void main(String args[]) throws IOException{
		
		
		userList = readUserFromFile("UserList.txt"); // load registered user from file
		propertyList = readPropertyFromFile("PropertyList.txt"); // load pre inserted property from file
		LoginFrame l = new LoginFrame(); 
	
	}
	public static void callSaveUserToFile(String user, String pass, boolean i)throws IOException{ // this is used to call the next function for edit profile of user
		String fileText =  user + "|" + pass ; 
		saveUserToFile("UserList.txt", fileText, i);
	}
	public static void saveUserToFile(String filename, String text, boolean append) throws IOException{// filename = name of file, text = username&pass -> method used to save user info to file
		File file1 = new File(filename);
		FileWriter fw = new FileWriter(file1, append);
		PrintWriter write_File1 = new PrintWriter(fw);
		
		write_File1.println(text);
		
		write_File1.close();
	}
	public static ArrayList<User> readUserFromFile(String filename) throws IOException{ //function to read registered user lists from file
		
		File file2 = new File(filename);	
		Scanner s = new Scanner(file2);
		
		ArrayList<User>  userListInFile = new ArrayList<User>(); // initially holds user list from file to copy to static arraylist
		
		while(s.hasNextLine()){
			String line = s.nextLine(); // separtes lines from file
			String[] items = line.split("\\|"); //separtes items in lines at | operator
			
			String username = items[0];
			String password = items[1];
			
			if(password.equals("1234")){
				Admin a = new Admin(username, password);
				System.out.print("Admin ID - ");
				System.out.println("User Name: "+username +" Password: "+ password);
				userListInFile.add(a);	// puts the object in this list
			}
			else if(password.equals("2345")){
				Owner o = new Owner(username, password);
				System.out.print("Owner ID - ");
				System.out.println("User Name: "+username +" Password: "+ password);
				userListInFile.add(o);
			}
			else if(password.equals("4567")){
				Tenant t = new Tenant(username, password);
				System.out.print("Tenant ID - ");
				System.out.println("User Name: "+username +" Password: "+ password);
				userListInFile.add(t);
			}
		}
		return userListInFile; // returns arraylist
	}
	public static void callSavePropertyToFile(String id, String type, String size, String bed, String bath, String rent, String deposit, String contact, String status, String address, String furnishing, String facilities, String owner, boolean i) throws IOException{ //used for modifying property to file
		String fileText = 
				id + "|" + type + "|" + size + "|"
				+ bed + "|" + bath + "|" + rent + "|" 
				+ deposit + "|" + contact + "|" + status + "|" 
				+ address + "|" + furnishing + "|" + facilities + "|" 
				+ owner;
				
		savePropertyToFile("PropertyList.txt", fileText, i); //puts into destined file
	}
	public static void savePropertyToFile(String filename, String text, boolean append) throws IOException{	// places uploaded/modified property to file
		File file1 = 	new File(filename);
		FileWriter fw = new FileWriter(file1, append);
		PrintWriter write_File1 = new PrintWriter(fw);
		
		write_File1.println(text);
		
		write_File1.close();
	}
	public static ArrayList<Property> readPropertyFromFile(String filename) throws IOException{	//reads properties from file
		File file2 = new File(filename);
		Scanner s = new Scanner(file2);
		
		ArrayList<Property>  propertyListInFile = new ArrayList<Property>();	//initially holds the properties
		
		while(s.hasNextLine()){
			String line = s.nextLine();
			String[] items = line.split("\\|");
		
			int propertyId = Integer.parseInt(items[0]);
			String propertyType = items[1]; 
			double propertySize = Double.parseDouble(items[2]); 
			int bedroom = Integer.parseInt(items[3]); 
			int bathroom = Integer.parseInt(items[4]); 
			double rent = Double.parseDouble(items[5]); 
			double deposit = Double.parseDouble(items[6]); 
			int contact = Integer.parseInt(items[7]); 
			String status = items[8];			 
			String address = items[9];			 
			String furnishing = items[10]; 
			String facilities = items[11];
			String owner = items[12];			
			
			if(propertyType.equals("Condo")){
				Condominium c = new Condominium();
				// missing setters to object
				c.setPropertyID(propertyId);//enter the property id with the arrangement in the arraylist
				c.setPropertySize(propertySize);
				c.setRentPrice(rent);c.setDeposit(deposit);
				//c.setFloorNum(6);s10.setUnit("3");
				c.setNumberOfBedrooms(bedroom);c.setNumberOfBathrooms(bathroom);
				c.setContactNum(contact);
				c.setFurnishing(furnishing);
				c.setFacilities(facilities);
				c.setAddress(address);
				c.setRentStatus(status);
				c.setUnHidden();
				c.setOwner(owner);
				propertyListInFile.add(c);
				
			}
			else if(propertyType.equals("Commercial")){
				ServiceResidence sr = new ServiceResidence();
				// missing setters to object
				sr.setPropertyID(propertyId);//enter the property id with the arrangement in the arraylist
				sr.setPropertySize(propertySize);
				sr.setRentPrice(rent);sr.setDeposit(deposit);
				//c.setFloorNum(6);s10.setUnit("3");
				sr.setNumberOfBedrooms(bedroom);sr.setNumberOfBathrooms(bathroom);
				sr.setContactNum(contact);
				sr.setFurnishing(furnishing);
				sr.setFacilities(facilities);
				sr.setAddress(address);
				sr.setRentStatus(status);
				sr.setUnHidden();
				sr.setOwner(owner);
				propertyListInFile.add(sr);
			}
			else if(propertyType.equals("Apartment")){
				Apartment a = new Apartment();
				// missing setters to object
				a.setPropertyID(propertyId);//enter the property id with the arrangement in the arraylist
				a.setPropertySize(propertySize);
				a.setRentPrice(rent);a.setDeposit(deposit);
				//c.setFloorNum(6);s10.setUnit("3");
				a.setNumberOfBedrooms(bedroom);a.setNumberOfBathrooms(bathroom);
				a.setContactNum(contact);
				a.setFurnishing(furnishing);
				a.setFacilities(facilities);
				a.setAddress(address);
				a.setRentStatus(status);
				a.setUnHidden();
				a.setOwner(owner);
				propertyListInFile.add(a);
			}
		}
		return propertyListInFile;	//returns to static arraylist 
	}
}


