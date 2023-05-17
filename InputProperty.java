import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;
public class InputProperty extends JFrame implements ActionListener, ItemListener{	// takes all the necessary inputs for uploading property
	OwnerView ov;
	Condominium c;
	ServiceResidence sr;
	Apartment a;
	PropertyController pc;
	private JLabel intro;
	
	private JPanel panel;
	private JPanel panel2;
	
    private JTextField propertySize;
    private JTextField floor;
    private JTextField unit;
    private JTextField bedRoom;
    private JTextField bathRoom;
    private JTextField furnishing;
    private JTextField rent;
    private JTextField deposit;
    private JTextField address;
    private JTextField contactNum;
    private JTextField rentStatus;
	private JCheckBox cb1, cb2;
	private JRadioButton rb1, rb2, rb3, rb4, rb5;
	
    private JButton UploadBtn;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	
	private String own;
	private int pnum;
	
	public InputProperty(String owner, int num){
		dispose();
		own = owner;
		pnum = num;
		panel = new JPanel();
		panel2 = new JPanel();
		
		panel.setLayout(new GridLayout(15,1, 10,5));
		panel2.setLayout(new GridLayout(15,1, 10,5));
		
		intro = new JLabel("Enter Property details", JLabel.CENTER);
		label1 = new JLabel("Property Size ");				panel.add(label1);
		label2 = new JLabel("Floor No.");				panel.add(label2);
		label3 = new JLabel("Unit No.");				panel.add(label3);
		label4 = new JLabel("No. of Bedrooms");			panel.add(label4);
		label5 = new JLabel("No. of Bathrooms");		panel.add(label5);
		label7 = new JLabel("Monthly Rent");			panel.add(label7);
		label8 = new JLabel("Initial Deposit");			panel.add(label8);
		label9 = new JLabel("Address");					panel.add(label9);
		label10 = new JLabel("Contact No.");			panel.add(label10);
		label6 = new JLabel("Furnishing");				panel.add(label6);
		rb1 = new JRadioButton("Full Furnished");		panel.add(rb1);
		rb2 = new JRadioButton("Partially Furnished");	panel.add(rb2);
		rb3 = new JRadioButton("UnFurnished ");			panel.add(rb3);
		
		
		UploadBtn = new JButton("Publish Now");
		
		propertySize = new JTextField(30);		panel2.add(propertySize);
		floor = new JTextField(20);				panel2.add(floor);
		unit = new JTextField(20);				panel2.add(unit);
		bedRoom = new JTextField(20);			panel2.add(bedRoom);
		bathRoom = new JTextField(20);			panel2.add(bathRoom);
		rent = new JTextField(20);				panel2.add(rent);
		deposit = new JTextField(20);			panel2.add(deposit);
		address = new JTextField(20);			panel2.add(address);
		contactNum = new JTextField(20);		panel2.add(contactNum);
		label12 = new JLabel("Facilities");		panel2.add(label12);
		cb1 = new JCheckBox("Wifi");			panel2.add(cb1);
		cb2 = new JCheckBox("Swimming Pool");	panel2.add(cb2);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(13,1));
		c.add(intro, BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		c.add(panel2, BorderLayout.EAST);
		c.add(UploadBtn, BorderLayout.SOUTH);
		
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		
		UploadBtn.addActionListener(this);
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == UploadBtn){
			if(pnum == 1){	//(pnum == 1 ) is for entering condominium
				c=new Condominium();
				c.setPropertyID(LoginFrame.propertyList.size() + 101);	//use of delegation as the InputProperty is delegating its task to Condominium class
				c.setPropertySize(Double.parseDouble(propertySize.getText()));
				c.setRentPrice(Double.parseDouble(rent.getText()));
				c.setDeposit(Double.parseDouble(deposit.getText()));
				c.setFloorNum(Integer.parseInt(floor.getText()));
				c.setNumberOfBedrooms(Integer.parseInt(bedRoom.getText()));
				c.setNumberOfBathrooms(Integer.parseInt(bathRoom.getText()));
				c.setContactNum(Integer.parseInt(contactNum.getText()));
				c.setUnit(unit.getText());
				c.setAddress(address.getText());
				c.setRentStatus("Active");
				c.setUnHidden();
				c.setOwner(own);
				
				if(rb1.isSelected()){
					c.setFurnishing("Fully Furnished");
				}
				else if(rb2.isSelected()){
					c.setFurnishing("Partially Furnished");
				}
				else if(rb3.isSelected()){
					c.setFurnishing("UnFurnished");
				}
				
				if(cb1.isSelected() && cb2.isSelected()){
					c.setFacilities("Wifi & Swimming Pool");
				}
				else if(cb1.isSelected()){
					c.setFacilities("Wifi");
				}
				else if(cb2.isSelected()){
					c.setFacilities("Swimming Pool");
				}
				try{
					LoginFrame.propertyList.add(c);
					for(int i = 0; i<LoginFrame.propertyList.size(); i++){
						if(i==0){
							LoginFrame.callSavePropertyToFile(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),LoginFrame.propertyList.get(i).getPropertyType(), String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()), String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),String.valueOf(LoginFrame.propertyList.get(i).getDeposit()), String.valueOf(LoginFrame.propertyList.get(i).getContactNum()), LoginFrame.propertyList.get(i).getRentStatus(), LoginFrame.propertyList.get(i).getAddress(), LoginFrame.propertyList.get(i).getFurnishing(), LoginFrame.propertyList.get(i).getFacilities(), LoginFrame.propertyList.get(i).getOwner(), false); //erases the existing file and add the first element to file
						}
						else{
							LoginFrame.callSavePropertyToFile(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),LoginFrame.propertyList.get(i).getPropertyType(), String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()), String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),String.valueOf(LoginFrame.propertyList.get(i).getDeposit()), String.valueOf(LoginFrame.propertyList.get(i).getContactNum()), LoginFrame.propertyList.get(i).getRentStatus(), LoginFrame.propertyList.get(i).getAddress(), LoginFrame.propertyList.get(i).getFurnishing(), LoginFrame.propertyList.get(i).getFacilities(), LoginFrame.propertyList.get(i).getOwner(), true); //adds remainig element to the file
						}
							
					}	
				}
				catch(IOException f){
					
				}
				
				dispose();ov = new OwnerView(own); // calls view again
				
			}
			else if(pnum == 2){	// entering service residencee here
				sr = new ServiceResidence();
				sr.setPropertyID(LoginFrame.propertyList.size() + 101);//enter the property id with the arrangement in the arraylist
				sr.setPropertySize(Double.parseDouble(propertySize.getText()));
				sr.setRentPrice(Double.parseDouble(rent.getText()));
				sr.setDeposit(Double.parseDouble(deposit.getText()));
				sr.setFloorNum(Integer.parseInt(floor.getText()));
				sr.setNumberOfBedrooms(Integer.parseInt(bedRoom.getText()));
				sr.setNumberOfBathrooms(Integer.parseInt(bathRoom.getText()));
				sr.setContactNum(Integer.parseInt(contactNum.getText()));
				sr.setUnit(unit.getText());
				sr.setAddress(address.getText());
				sr.setRentStatus("Active");
				sr.setUnHidden();
				sr.setOwner(own);
				
				if(rb1.isSelected()){
					sr.setFurnishing("Fully Furnished");
				}
				else if(rb2.isSelected()){
					sr.setFurnishing("Partially Furnished");
				}
				else if(rb3.isSelected()){
					sr.setFurnishing("UnFurnished");
				}
				
				if(cb1.isSelected() && cb2.isSelected()){
					sr.setFacilities("Wifi & Swimming Pool");
				}
				else if(cb1.isSelected()){
					sr.setFacilities("Wifi");
				}
				else if(cb2.isSelected()){
					sr.setFacilities("Swimming Pool");
				}
				try{
					LoginFrame.propertyList.add(sr);
					for(int i = 0; i<LoginFrame.propertyList.size(); i++){
						if(i==0){
							LoginFrame.callSavePropertyToFile(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),LoginFrame.propertyList.get(i).getPropertyType(), String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()), String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),String.valueOf(LoginFrame.propertyList.get(i).getDeposit()), String.valueOf(LoginFrame.propertyList.get(i).getContactNum()), LoginFrame.propertyList.get(i).getRentStatus(), LoginFrame.propertyList.get(i).getAddress(), LoginFrame.propertyList.get(i).getFurnishing(), LoginFrame.propertyList.get(i).getFacilities(), LoginFrame.propertyList.get(i).getOwner(), false);
						}
						else{
							LoginFrame.callSavePropertyToFile(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),LoginFrame.propertyList.get(i).getPropertyType(), String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()), String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),String.valueOf(LoginFrame.propertyList.get(i).getDeposit()), String.valueOf(LoginFrame.propertyList.get(i).getContactNum()), LoginFrame.propertyList.get(i).getRentStatus(), LoginFrame.propertyList.get(i).getAddress(), LoginFrame.propertyList.get(i).getFurnishing(), LoginFrame.propertyList.get(i).getFacilities(), LoginFrame.propertyList.get(i).getOwner(), true);
						}
							
					}	
				}
				catch(IOException f){
					
				}
				dispose();ov = new OwnerView(own);
			}
			else if(pnum == 3){ // enter apartment  here
				a = new Apartment();
				a.setPropertyID(LoginFrame.propertyList.size() + 102);//enter the property id with the arrangement in the arraylist
				a.setPropertySize(Double.parseDouble(propertySize.getText()));
				a.setRentPrice(Double.parseDouble(rent.getText()));
				a.setDeposit(Double.parseDouble(deposit.getText()));
				a.setFloorNum(Integer.parseInt(floor.getText()));
				a.setNumberOfBedrooms(Integer.parseInt(bedRoom.getText()));
				a.setNumberOfBathrooms(Integer.parseInt(bathRoom.getText()));
				a.setContactNum(Integer.parseInt(contactNum.getText()));
				a.setUnit(unit.getText());
				a.setAddress(address.getText());
				a.setRentStatus("Active");
				a.setUnHidden();
				a.setOwner(own);
				
				if(rb1.isSelected()){
					a.setFurnishing("Fully Furnished");
				}
				else if(rb2.isSelected()){
					a.setFurnishing("Partially Furnished");
				}
				else if(rb3.isSelected()){
					a.setFurnishing("UnFurnished");
				}
				
				if(cb1.isSelected() && cb2.isSelected()){
					a.setFacilities("Wifi & Swimming Pool");
				}
				else if(cb1.isSelected()){
					a.setFacilities("Wifi");
				}
				else if(cb2.isSelected()){
					a.setFacilities("Swimming Pool");
				}
				try{
					LoginFrame.propertyList.add(a);
					for(int i = 0; i<LoginFrame.propertyList.size(); i++){
							if(i==0){
								LoginFrame.callSavePropertyToFile(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),LoginFrame.propertyList.get(i).getPropertyType(), String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()), String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),String.valueOf(LoginFrame.propertyList.get(i).getDeposit()), String.valueOf(LoginFrame.propertyList.get(i).getContactNum()), LoginFrame.propertyList.get(i).getRentStatus(), LoginFrame.propertyList.get(i).getAddress(), LoginFrame.propertyList.get(i).getFurnishing(), LoginFrame.propertyList.get(i).getFacilities(), LoginFrame.propertyList.get(i).getOwner(), false);	//erases the existing file and add the first element of array list
							}
							else{
								LoginFrame.callSavePropertyToFile(String.valueOf(LoginFrame.propertyList.get(i).getPropertyID()),LoginFrame.propertyList.get(i).getPropertyType(), String.valueOf(LoginFrame.propertyList.get(i).getPropertySize()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBedrooms()), String.valueOf(LoginFrame.propertyList.get(i).getNumberOfBathrooms()), String.valueOf(LoginFrame.propertyList.get(i).getRentPrice()),String.valueOf(LoginFrame.propertyList.get(i).getDeposit()), String.valueOf(LoginFrame.propertyList.get(i).getContactNum()), LoginFrame.propertyList.get(i).getRentStatus(), LoginFrame.propertyList.get(i).getAddress(), LoginFrame.propertyList.get(i).getFurnishing(), LoginFrame.propertyList.get(i).getFacilities(), LoginFrame.propertyList.get(i).getOwner(), true); //adds rest of the element afterwards
							}
								
					}	
				}
				catch(IOException f){
					
				}
				dispose();ov = new OwnerView(own);	//calls ownerview again to view it
			}
		}
			
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==rb1){	// this is used to check on buttons at a time
			rb2.setSelected(false);
			rb3.setSelected(false);
		}
		else if(e.getSource()==rb2){
			rb1.setSelected(false);
			rb3.setSelected(false);
		}
		else if(e.getSource()==rb3){
			rb2.setSelected(false);
			rb1.setSelected(false);
		}
	}
}