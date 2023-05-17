import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;

public class DeleteProperty extends JFrame implements ActionListener{	// delete property by admin
	private AdminView av;
	private JLabel title;
	private JTextField deleteId;
	private JButton delete;
	private boolean exist;
	
	public DeleteProperty(){
		title = new JLabel("Enter the ID of the property to delete", JLabel.CENTER);
		deleteId = new JTextField(10);
		delete = new JButton("Delete");
		delete.addActionListener(this);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add(title);
		p1.add(deleteId);
		p2.add(delete);
		
		Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(p1);
        c.add(p2);
        c.add(delete);

        setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==delete){
			int did = Integer.parseInt(deleteId.getText());
			for(int j=0; j<LoginFrame.propertyList.size(); j++){
                if(LoginFrame.propertyList.get(j).getPropertyID() == did){
                  
				try{
					exist = true;
					LoginFrame.propertyList.remove(j);
					//av.destroyFrame(); //Use Of DELEGATION
					dispose();JOptionPane.showMessageDialog(rootPane,"Property is Deleted!");
					av = new AdminView();
					

					for(int i = 0; i<LoginFrame.propertyList.size(); i++){	//updates to file
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
				JOptionPane.showMessageDialog(rootPane,"The property doesn't exist.");
				dispose();AdminView av = new AdminView();
				
			}
		}
	}
}