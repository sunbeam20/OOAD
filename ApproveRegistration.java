import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;

public class ApproveRegistration extends JFrame implements ActionListener{	//approve pending registration requests
	private JLabel title, usernameLabel, typeLabel;
	private JButton approve, delete, back;
	private boolean exist;
	private String username, type;
	
	public ApproveRegistration(){
		
		title = new JLabel("Registration Requests", JLabel.CENTER);
		approve = new JButton("Approve Now");
		delete = new JButton("Delete");
		back = new JButton("Back");
		approve.addActionListener(this);
		delete.addActionListener(this);
		back.addActionListener(this);
		if(LoginFrame.newUserList.size()<1){
			usernameLabel = new JLabel("No Registration");
			typeLabel = new JLabel("Requests");
		}
		
		if(LoginFrame.newUserList.size()>0){
			usernameLabel = new JLabel(LoginFrame.newUserList.get(0).getUserName());
			typeLabel = new JLabel(LoginFrame.newUserList.get(0).getUserType());
		}
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p1.add(title);
		p2.add(usernameLabel);
		p2.add(typeLabel);
		p3.add(delete);
		p3.add(approve);
		p3.add(back);
		
		Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
        c.add(p3, BorderLayout.SOUTH);

        setSize(350,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==approve){	// approve registration request and update to file
			if(LoginFrame.newUserList.size()>0){
			if(LoginFrame.newUserList.get(0).getUserType().equals("Admin")){
				Admin a = new Admin(LoginFrame.newUserList.get(0).getUserName(),LoginFrame.newUserList.get(0).getPassword());
				try{
					dispose();AdminView av = new AdminView();
					
					LoginFrame.userList.add(a);
					JOptionPane.showMessageDialog(rootPane,"Registration Request APPROVED!");
					LoginFrame.newUserList.remove(0);
					for(int i=0; i<LoginFrame.userList.size(); i++){
						if(i==0){
							String fileText = LoginFrame.userList.get(i).getUserName() + "|" + LoginFrame.userList.get(i).getPassword() ;
							LoginFrame.saveUserToFile("UserList.txt", fileText, false);
						}
						else{
							String fileText = LoginFrame.userList.get(i).getUserName() + "|" + LoginFrame.userList.get(i).getPassword() ;
							LoginFrame.saveUserToFile("UserList.txt", fileText, true);
						}
						
					}
				}catch(IOException f){
					
				}
			}

			else if(LoginFrame.newUserList.get(0).getUserType().equals("Owner")){
				Owner o = new Owner(LoginFrame.newUserList.get(0).getUserName(),LoginFrame.newUserList.get(0).getPassword());
				try{
					dispose();AdminView av = new AdminView();
					
					LoginFrame.userList.add(o);
					JOptionPane.showMessageDialog(rootPane,"Registration Request APPROVED!");
					LoginFrame.newUserList.remove(0);
					for(int i=0; i<LoginFrame.userList.size(); i++){
						if(i==0){
							String fileText = LoginFrame.userList.get(i).getUserName() + "|" + LoginFrame.userList.get(i).getPassword() ;
							LoginFrame.saveUserToFile("UserList.txt", fileText, false);
						}
						else{
							String fileText = LoginFrame.userList.get(i).getUserName() + "|" + LoginFrame.userList.get(i).getPassword() ;
							LoginFrame.saveUserToFile("UserList.txt", fileText, true);
						}
						
					}
				}catch(IOException f){
					
				}
			}

			else if(LoginFrame.newUserList.get(0).getUserType().equals("Tenant")){
				Tenant t = new Tenant(LoginFrame.newUserList.get(0).getUserName(),LoginFrame.newUserList.get(0).getPassword());
				try{
					dispose();AdminView av = new AdminView();
					
					LoginFrame.userList.add(t);
					JOptionPane.showMessageDialog(rootPane,"Registration Request APPROVED!");
					LoginFrame.newUserList.remove(0);
					for(int i=0; i<LoginFrame.userList.size(); i++){
						if(i==0){
							String fileText = LoginFrame.userList.get(i).getUserName() + "|" + LoginFrame.userList.get(i).getPassword() ;
							LoginFrame.saveUserToFile("UserList.txt", fileText, false);
						}
						else{
							String fileText = LoginFrame.userList.get(i).getUserName() + "|" + LoginFrame.userList.get(i).getPassword() ;
							LoginFrame.saveUserToFile("UserList.txt", fileText, true);
						}
						
					}
				}catch(IOException f){
					
				}
			}}
			else if(LoginFrame.newUserList.size()<1){
				
				JOptionPane.showMessageDialog(rootPane,"No registration requests for approval");
				dispose();AdminView av = new AdminView();
			}
		}
		else if(e.getSource()==delete){	// delete registration request
			if(LoginFrame.newUserList.size()>0){
				LoginFrame.newUserList.remove(0);
				
				JOptionPane.showMessageDialog(rootPane,"Registration request is REJECTED!");
				dispose();AdminView av = new AdminView();
			}
			else{
				
				JOptionPane.showMessageDialog(rootPane,"No registration requests for Rejecting");
				dispose();AdminView av = new AdminView();
			}
		}
		else if(e.getSource()==back){
			dispose();
			AdminView av = new AdminView();
		}
	}
}