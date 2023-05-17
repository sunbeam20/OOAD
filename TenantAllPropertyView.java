import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import javax.swing.JScrollPane;

public class TenantAllPropertyView extends JFrame implements ActionListener{	//All propertyList
	private JButton logOut, editProfile, rent;
	private JPanel panel1;
	private JLabel iDLabel,typeLabel,sizeLabel,roomLabel,bathroomLabel,priceLabel,depositLabel,contactLabel,statusLabel,addressLabel,furnishingLabel, ownerLabel, facilitiesLabel;
	private String propertyListBy[] = {"Filter Property By","All Properties","Condominium", "Service Residence", "Apartment", "SwimmingPool", "Wifi"};
	private JComboBox<String> cb = new JComboBox<>(propertyListBy);
	private String t;
	public TenantAllPropertyView(String tenant){
		super("Tenant Viewing All Properties in the System");
		t=tenant;
		Container c = getContentPane();
		c.setLayout(new BorderLayout(8,6));
		cb.setSelectedIndex(1);
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
        roomLabel = new JLabel("Room",JLabel.CENTER); 				roomLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        bathroomLabel = new JLabel("Bathroom",JLabel.CENTER); 		bathroomLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        priceLabel = new JLabel("Price(RM)",JLabel.CENTER); 			priceLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		depositLabel = new JLabel("Deposit(RM)",JLabel.CENTER);			depositLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        contactLabel = new JLabel("Contact number",JLabel.CENTER); 		contactLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        statusLabel = new JLabel("Status",JLabel.CENTER); 				statusLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        addressLabel = new JLabel("Address",JLabel.CENTER); 			addressLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        furnishingLabel = new JLabel("Furnishing",JLabel.CENTER); 		furnishingLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		facilitiesLabel = new JLabel("Facilities", JLabel.CENTER); 		facilitiesLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		ownerLabel = new JLabel("Owner", JLabel.CENTER); 				ownerLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		
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
		
		/*JPanel temp = new JPanel();
		temp.add(propertyListBy); temp.add(top); 
		*/
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0,1,5,5));
		p2.add(title);
		
		for(int i = 0; i < LoginFrame.propertyList.size() ; i++ ){
			if(LoginFrame.propertyList.get(i).getHiddentStatus() == false && LoginFrame.propertyList.get(i).getRentStatus().equals("Active")){
				JPanel content = new JPanel();
				JLabel content1 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),JLabel.CENTER);
				JLabel content2 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getPropertyType()),JLabel.CENTER);
				JLabel content3 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()),JLabel.CENTER);
				JLabel content4 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()),JLabel.CENTER);
				JLabel content5 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()),JLabel.CENTER);
				JLabel content6 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),JLabel.CENTER);
				JLabel content7 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getContactNum()),JLabel.CENTER);
				JLabel content8 = new JLabel(LoginFrame.propertyList.get(i).getRentStatus(),JLabel.CENTER);
				JLabel content9 = new JLabel(LoginFrame.propertyList.get(i).getAddress(),JLabel.CENTER);
				JLabel content10 = new JLabel(LoginFrame.propertyList.get(i).getFurnishing(),JLabel.CENTER);
				JLabel content11 = new JLabel(LoginFrame.propertyList.get(i).getFacilities(),JLabel.CENTER);
				JLabel content12 = new JLabel(LoginFrame.propertyList.get(i).getOwner(),JLabel.CENTER);
				JLabel content13 = new JLabel(String.valueOf(LoginFrame.propertyList.get(i).getDeposit()),JLabel.CENTER);
				
				content1.setPreferredSize(new Dimension (50,20));
				content2.setPreferredSize(new Dimension (70,20));content3.setPreferredSize(new Dimension (70,20));
				content4.setPreferredSize(new Dimension (50,20));content5.setPreferredSize(new Dimension (60,20));
				content6.setPreferredSize(new Dimension (100,20));content7.setPreferredSize(new Dimension (120,20));
				content8.setPreferredSize(new Dimension (100,20));content9.setPreferredSize(new Dimension (250,20));
				content10.setPreferredSize(new Dimension (120,20));content11.setPreferredSize(new Dimension (130,20));
				content12.setPreferredSize(new Dimension (100,20));content13.setPreferredSize(new Dimension (100,20));
				
				
				content.add(content1);content.add(content2);content.add(content3);
				content.add(content4);content.add(content5);content.add(content10);content.add(content11);content.add(content8);content.add(content6);content.add(content13);
				content.add(content9);content.add(content7);
				content.add(content12);
				content.setVisible(true);

				p2.add(content);
			}
		}
		
        JScrollPane jScrollPane = new JScrollPane(p2);  
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setColumnHeaderView(title);
		c.add(jScrollPane);
		
		//c.add(p2, BorderLayout.WEST);
		
		
		setSize(1500, 700);
        setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==logOut){
			dispose();
			LoginFrame lf = new LoginFrame();
		}
		else if(e.getSource()==rent){
			dispose();RentProperty rp = new RentProperty(t);
			
		}else if(e.getSource()==editProfile){
			dispose(); EditProfile ep = new EditProfile(t);
		}
		else if(e.getSource()==cb){
			switch (cb.getSelectedIndex()){
			   case 0:
				break;
			   case 1:
					dispose();
					TenantAllPropertyView tavs = new TenantAllPropertyView(t);
				break;
			   case 2:
					dispose();
					TenantCondominiumView tcv = new TenantCondominiumView(t);
				break;
				case 3:
					dispose();
					TenantServiceView tsv = new TenantServiceView(t);
				break;
				case 4:
					dispose();
					TenantApartmentView tav = new TenantApartmentView(t);
				break;
				case 5:
					dispose();
					TenantSwimmingPoolView tspv = new TenantSwimmingPoolView(t);
				break;
				case 6:
					dispose();
					TenantWifiView twv = new TenantWifiView(t);
				break;
			}
		}
	}
}