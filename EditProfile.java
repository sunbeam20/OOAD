import java.util.*;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.*;
import java.io.IOException;
public class EditProfile extends JFrame implements ActionListener{	// only enters new username and password for editing
	private AdminView av;
	private JLabel newUser, newPass, as;
	private JTextField username, password;
	private JButton update;
	private String ten;
	public EditProfile(String tenant){
		super("User Registration");
		ten=tenant;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		as = new JLabel("Edit Profile");
		newUser = new JLabel("Username: ");
		newPass = new JLabel("Password: ");
		username = new JTextField(15);
		password = new JTextField(15);
		
		p1.add(newUser);
		p1.add(username);
		p2.add(newPass);
		p2.add(password);

		
		update = new JButton("Update");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 15));
		c.add(as);
		c.add(p1);
		c.add(p2);
		c.add(update);
		
		update.addActionListener(this);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==update){
			String user = String.valueOf(username.getText());
			String pass = password.getText();
			String type = "Tenant";
			Tenant t = new Tenant(user, pass);
			for(int i=0; i<LoginFrame.userList.size(); i++){
				if(ten.equals(LoginFrame.userList.get(i).getUserName())){
					try{
						LoginFrame.userList.set(i,t);
				
						for(int j = 0; j<LoginFrame.userList.size(); j++){
							if(j==0){
								LoginFrame.callSaveUserToFile(LoginFrame.userList.get(j).getUserName(), LoginFrame.userList.get(j).getPassword(), false);
							}
							else{
								LoginFrame.callSaveUserToFile(LoginFrame.userList.get(j).getUserName(), LoginFrame.userList.get(j).getPassword(), true);
							}
						}
					}catch(IOException f){
						
					}
					
				}
			}
			
			
			JOptionPane.showMessageDialog(rootPane,"Profile Edited");
			
			dispose();
			PropertyView pv = new PropertyView(ten);
			
		}
	}
}