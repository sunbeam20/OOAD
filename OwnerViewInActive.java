import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JScrollPane;

public class OwnerViewInActive extends JFrame implements ActionListener{ // Inactive property by owner
	PropertyController pc;
	ModifyFrame mf;
	HideFrame hf;
	UnHideFrame uhf;
	private String own;
	private JLabel ad, pv;
	private JButton modifyProperty, hide, unhide;
	private JButton logOutButton;
	private JButton uploadPropertyButton;
	private JLabel iDLabel,typeLabel,sizeLabel,roomLabel,bathroomLabel,priceLabel, depositLabel,contactLabel,statusLabel,addressLabel,furnishingLabel, facilitiesLabel, ownerLabel;
	private String propertyListBy[] = {"Filter Property By","All Properties","Active Properties", "In-Active Properties", "Hidden Properties"};
	private JComboBox<String> cb = new JComboBox<>(propertyListBy);
	
	public OwnerViewInActive(String owner){
		super("Owner Logged in");
		own = owner;
        JPanel title = new JPanel();
		cb.setSelectedIndex(3);
        
        iDLabel = new JLabel("ID",JLabel.CENTER);
		typeLabel = new JLabel("Type",JLabel.CENTER);
        sizeLabel = new JLabel("Size(m^2)",JLabel.CENTER);
        roomLabel = new JLabel("Room",JLabel.CENTER);
        bathroomLabel = new JLabel("Bathroom",JLabel.CENTER);
		furnishingLabel = new JLabel("Furnishing",JLabel.CENTER);
		facilitiesLabel = new JLabel("Facilities", JLabel.CENTER);
		statusLabel = new JLabel("Property status",JLabel.CENTER);
        priceLabel = new JLabel("Rent(RM)",JLabel.CENTER);
		depositLabel = new JLabel("Deposit(RM)",JLabel.CENTER);
        addressLabel = new JLabel("Address",JLabel.CENTER);
        contactLabel = new JLabel("Contact number",JLabel.CENTER);
		ownerLabel = new JLabel("Owner", JLabel.CENTER);

        iDLabel.setPreferredSize(new Dimension (50,15));
		typeLabel.setPreferredSize(new Dimension (70,15));
        sizeLabel.setPreferredSize(new Dimension (70,15));
        roomLabel.setPreferredSize(new Dimension (50,15));
        bathroomLabel.setPreferredSize(new Dimension (60,15));
        priceLabel.setPreferredSize(new Dimension (100,15));
        depositLabel.setPreferredSize(new Dimension (100,15));
        contactLabel.setPreferredSize(new Dimension (120,15));
        statusLabel.setPreferredSize(new Dimension (100,15));
        addressLabel.setPreferredSize(new Dimension (250,15));
        furnishingLabel.setPreferredSize(new Dimension (120,15));
		facilitiesLabel.setPreferredSize(new Dimension (200,15));
		ownerLabel.setPreferredSize(new Dimension(100,15));
		
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
        
		Container c = getContentPane();
		c.setLayout(new BorderLayout(8,6));
		c.setBackground(Color.CYAN);
		
		pv = new JLabel("Property View Board", JLabel.CENTER );
		modifyProperty = new JButton("Modify Property");
		hide = new JButton("Hide");
		unhide = new JButton("UnHide");
		logOutButton = new JButton("Logout");
		uploadPropertyButton = new JButton("Upload Property");
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(3));
		p1.add(pv);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0,1,5,5));
		p2.add(title);
		
        for(int i = 0; i < LoginFrame.propertyList.size() ; i++ ){
			if(LoginFrame.propertyList.get(i).getHiddentStatus() == false && LoginFrame.propertyList.get(i).getRentStatus().equals("InActive")){
				if(LoginFrame.propertyList.get(i).getOwner().equals(own)){
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
					
					content1.setPreferredSize(new Dimension (50,15));
					content2.setPreferredSize(new Dimension (70,15));content3.setPreferredSize(new Dimension (70,15));
					content4.setPreferredSize(new Dimension (50,15));content5.setPreferredSize(new Dimension (60,15));
					content6.setPreferredSize(new Dimension (100,15));content7.setPreferredSize(new Dimension (120,15));
					content8.setPreferredSize(new Dimension (100,15));content9.setPreferredSize(new Dimension (250,15));
					content10.setPreferredSize(new Dimension (120,15));content11.setPreferredSize(new Dimension (200,15));
					content12.setPreferredSize(new Dimension (100,15));content13.setPreferredSize(new Dimension (100,15));
					
					
					content.add(content1);content.add(content2);content.add(content3);
					content.add(content4);content.add(content5);content.add(content10);content.add(content11);content.add(content8);content.add(content6);content.add(content13);
					content.add(content9);content.add(content7);
					content.add(content12);
					content.setVisible(true);

					p2.add(content);
				}
			}
		}
		JScrollPane jScrollPane = new JScrollPane(p2);  
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setColumnHeaderView(title);
		c.add(jScrollPane);
		
		
		JPanel p3 = new JPanel();
		p3.add(logOutButton);
		p3.add(hide);
		p3.add(unhide);
		p3.add(cb);
		p3.add(modifyProperty);
		p3.add(uploadPropertyButton);
		
		c.add(p3, BorderLayout.NORTH);
		
		//JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, p1, p2);
		//sl.setOrientation(SwingConstants.VERTICAL);
		/*sl.setDividerLocation(450);
		f.add(sl);
  
        // set the size of frame
		*/
		setSize(1500, 700);
  
        setVisible(true);
        logOutButton.addActionListener(this);
        uploadPropertyButton.addActionListener(this);
		modifyProperty.addActionListener(this);
		hide.addActionListener(this);
		unhide.addActionListener(this);
		cb.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logOutButton){
			dispose();
			LoginFrame lf = new LoginFrame();
        }
        else if(e.getSource() == uploadPropertyButton){
			dispose();pc = new PropertyController(own);
			
			//pCatFrame = new PropertyCatFrame(this);
            //pCatFrame.setVisible(true);
        }
		else if(e.getSource() == modifyProperty){
			dispose();mf = new ModifyFrame(own);
			
		}
		else if(e.getSource() == hide){
			dispose();hf = new HideFrame(own);
			
		}
		else if(e.getSource() == unhide){
			dispose();uhf = new UnHideFrame(own);
			
		}
		else if(e.getSource() == cb){
			switch (cb.getSelectedIndex()){
			   case 0:
			   break;
			   case 1:
					dispose();
					OwnerView ov = new OwnerView(own);
				break;
				
				case 2:
					dispose();
					OwnerViewActive oav = new OwnerViewActive(own);
				break;
				case 3:
					dispose();
					OwnerViewInActive ovia = new OwnerViewInActive(own);
				break;
				case 4:
					dispose();
					OwnerViewHide ovh = new OwnerViewHide(own);
				break;
			}
		}
    }
}