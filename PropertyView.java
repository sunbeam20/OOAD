import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;

public class PropertyView extends JFrame implements ActionListener{		//view of mvc
	private JButton logOut, editProfile, rent;
	private JPanel panel1;
	private JLabel iDLabel,typeLabel,sizeLabel,roomLabel,bathroomLabel,priceLabel,depositLabel,contactLabel,statusLabel,addressLabel,furnishingLabel, ownerLabel, facilitiesLabel;
	private String propertyListBy[] = {"Filter Property By","All Properties","Condominium", "Service Residence", "Apartment", "SwimmingPool", "Wifi"};
	private JComboBox<String> cb = new JComboBox<>(propertyListBy);
	private String t;
	
	public PropertyView(String tenant){
		super("Tenant Logged In");
		t=tenant;
		Container c = getContentPane();
		c.setLayout(new BorderLayout(8,6));
		cb.setSelectedIndex(0);
		JPanel title = new JPanel();
		panel1 = new JPanel();
		

		logOut = new JButton("LogOut");
		rent = new JButton("Rent");
		editProfile = new JButton("Edit Profile");
		
		panel1.add(logOut); panel1.add(cb);panel1.add(editProfile);panel1.add(rent);
		c.add(panel1, BorderLayout.NORTH);

		logOut.addActionListener(this);
		editProfile.addActionListener(this);
		cb.addActionListener(this);
		rent.addActionListener(this);
		
		iDLabel = new JLabel("ID",JLabel.CENTER);						iDLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		typeLabel = new JLabel("Type",JLabel.CENTER); 					typeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        sizeLabel = new JLabel("Size(m^2)",JLabel.CENTER); 				sizeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        roomLabel = new JLabel("Room",JLabel.CENTER); 					roomLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        bathroomLabel = new JLabel("Bathroom",JLabel.CENTER); 			bathroomLabel.setFont(new Font("Calibri", Font.BOLD, 16));
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
		if(e.getSource()==logOut){	//logout button returns to loginpage
			dispose();LoginFrame lf = new LoginFrame();
		}
		else if(e.getSource()==rent){	// calls rent property class for entering the id of the property to be rented
			dispose();RentProperty rp = new RentProperty(t);
			
		}
		else if(e.getSource()==editProfile){	//edit profile
			dispose(); EditProfile ep = new EditProfile(t);
		}
		else if(e.getSource()==cb){
			switch (cb.getSelectedIndex()){
			   case 0:
				break;
			   case 1:
					dispose();
					TenantAllPropertyView tavs = new TenantAllPropertyView(t);	//view property All
				break;
			   case 2:
					dispose();
					TenantCondominiumView tcv = new TenantCondominiumView(t);	//view property by condominium
				break;
				case 3:
					dispose();
					TenantServiceView tsv = new TenantServiceView(t);	//view property by service residence
				break;
				case 4:
					dispose();
					TenantApartmentView tav = new TenantApartmentView(t); //view property by apartments
				break;
				case 5:
					dispose();
					TenantSwimmingPoolView tspv = new TenantSwimmingPoolView(t); //view property having swimming pool
				break;
				case 6:
					dispose();
					TenantWifiView twv = new TenantWifiView(t); //view property having wifi
				break;
			}
		}
		
	}

}