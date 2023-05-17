import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;

public class RentProperty extends JFrame implements ActionListener{	//tenant need to enter id to be rented
	private JLabel title;
	private JTextField rentID;
	private JButton rent;
	private boolean exist;
	private String t;
	public RentProperty(String tenant){
		t=tenant;
		title = new JLabel("Enter the ID of the property to rent", JLabel.CENTER);
		rentID = new JTextField(10);
		rent = new JButton("Rent Now");
		rent.addActionListener(this);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add(title);
		p1.add(rentID);
		p2.add(rent);
		
		Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(p1);
        c.add(p2);
        c.add(rent);

        setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==rent){
			int rid = Integer.parseInt(rentID.getText());
			for(int j=0; j<LoginFrame.propertyList.size(); j++){
                if(LoginFrame.propertyList.get(j).getPropertyID() == rid){
                  
				try{
					exist = true;
					LoginFrame.propertyList.get(j).setRentStatus("InActive");dispose();
					JOptionPane.showMessageDialog(rootPane,"Property is Rented to you!");PropertyView pv = new PropertyView(t);
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
                }
            }
			if(!exist){
				dispose();JOptionPane.showMessageDialog(rootPane,"The property doesn't exist.");dispose();PropertyView pv = new PropertyView(t);
			}
		}
	}
}