import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import javax.swing.JScrollPane;

public class AdminView extends JFrame implements ActionListener{ // this functions doesnt show any property initially, need to use the filterby option
	private JButton logOut, deleteProperty, addComment, createNewAdmin, pendingRegistration ;
	private JPanel panel1;
	private JLabel iDLabel,typeLabel,sizeLabel,roomLabel,bathroomLabel,priceLabel,depositLabel,contactLabel,statusLabel,addressLabel,furnishingLabel, ownerLabel, facilitiesLabel;
	private String propertyListBy[] = {"Filter Property By","All Properties","Active Properties", "In-Active Properties","Condominium", "Service Residence", "Apartment"};
	private JComboBox<String> cb = new JComboBox<>(propertyListBy);

	public AdminView(){
		super("Admin Logged In");
		Container c = getContentPane();
		c.setLayout(new BorderLayout(8,6));
		JPanel title = new JPanel();
		panel1 = new JPanel();
		
		pendingRegistration = new JButton("Registration Requests");
		logOut = new JButton("LogOut");
		deleteProperty = new JButton("Remove Property");
		createNewAdmin = new JButton("Create Admin Account");
		panel1.add(logOut); panel1.add(deleteProperty);panel1.add(cb);panel1.add(pendingRegistration); panel1.add(createNewAdmin);
		c.add(panel1, BorderLayout.NORTH);

		logOut.addActionListener(this);	// for logout button
		deleteProperty.addActionListener(this); // for delete property button
		createNewAdmin.addActionListener(this); // this is not added as new user can send Admmin registration request to existing admin	 
		cb.addActionListener(this);		//this is for filtering property
		pendingRegistration.addActionListener(this); //for viewing any new user registration request
		
		iDLabel = new JLabel("ID",JLabel.CENTER);						iDLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		typeLabel = new JLabel("Type",JLabel.CENTER); 					typeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        sizeLabel = new JLabel("Size(m^2)",JLabel.CENTER); 				sizeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        roomLabel = new JLabel("Room",JLabel.CENTER); 				roomLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        bathroomLabel = new JLabel("Bathroom",JLabel.CENTER); 		bathroomLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        priceLabel = new JLabel("Price(RM)",JLabel.CENTER); 			priceLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		depositLabel = new JLabel("Deposit(RM)",JLabel.CENTER);			depositLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        contactLabel = new JLabel("Contact number",JLabel.CENTER); 		contactLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        statusLabel = new JLabel("Status",JLabel.CENTER); 				statusLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        addressLabel = new JLabel("Address",JLabel.CENTER); 			addressLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        furnishingLabel = new JLabel("Furnishing",JLabel.CENTER); 		furnishingLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		facilitiesLabel = new JLabel("Facilities", JLabel.CENTER); 		facilitiesLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		ownerLabel = new JLabel("Owner", JLabel.CENTER);				ownerLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		
        iDLabel.setPreferredSize(new Dimension (50,20));
		typeLabel.setPreferredSize(new Dimension (70,20));
        sizeLabel.setPreferredSize(new Dimension (70,20));
        roomLabel.setPreferredSize(new Dimension (50,20));
        bathroomLabel.setPreferredSize(new Dimension (70,20));
        priceLabel.setPreferredSize(new Dimension (100,20));
        depositLabel.setPreferredSize(new Dimension (100,20));
        contactLabel.setPreferredSize(new Dimension (120,20));
        statusLabel.setPreferredSize(new Dimension (100,20));
        addressLabel.setPreferredSize(new Dimension (250,20));
        furnishingLabel.setPreferredSize(new Dimension (120,20));
		facilitiesLabel.setPreferredSize(new Dimension (130,20));
		ownerLabel.setPreferredSize(new Dimension(100,20));

        title.add(iDLabel);
		title.add(typeLabel);
        title.add(sizeLabel);
        title.add(roomLabel);
        title.add(bathroomLabel);
		title.add(furnishingLabel);
        title.add(facilitiesLabel);
        title.add(statusLabel);
        title.add(priceLabel);
        title.add(depositLabel);
        title.add(addressLabel);
        title.add(contactLabel);
		title.add(ownerLabel);
        title.setVisible(true);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0,1,5,5));
		p2.add(title);
		
		
		
        JScrollPane jScrollPane = new JScrollPane(p2);  
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setColumnHeaderView(title);
		c.add(jScrollPane);
		
		
		setSize(1500, 700);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==logOut){	// logOut returns to home page
			dispose();
			LoginFrame lf = new LoginFrame();
		}
		else if(e.getSource()==deleteProperty){	// delete property by admin 
			dispose();
			DeleteProperty dp = new DeleteProperty();
		}
		else if(e.getSource()==pendingRegistration){	//for approving and deleting user registration request
			dispose();
			ApproveRegistration ar = new ApproveRegistration();
		}
		else if(e.getSource()==cb){	// for property filters
			switch (cb.getSelectedIndex()){
			   case 0:
				break;
			   case 1:
					dispose();
					AllPropertyView avs = new AllPropertyView();	//All property class is called
						
				break;
			   case 2:
					dispose();
					ActivePropertyView aps = new ActivePropertyView(); // Active Properties
				break;
			   case 3:
					dispose();
					InActivePropertyView iaps = new InActivePropertyView();	//In Active Properties or Properties that are Rented
				break;
				case 4:
					dispose();
					CondominiumView cv = new CondominiumView();	// All Condominium
				break;
				case 5:
					dispose();
					ServiceView sv = new ServiceView(); //All Service Residence
				break;
				case 6:
					dispose();
					ApartmentView av = new ApartmentView(); //All Apartments
				break;
		   }
		}
		
	}

}