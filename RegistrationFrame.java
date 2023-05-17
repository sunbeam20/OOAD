import java.util.*;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.*;
public class RegistrationFrame extends JFrame implements ActionListener, ItemListener{	//new user registration
	private AdminView av;
	private JLabel newUser, newPass, as;
	private JTextField username, password;
	private JButton signup;
	private JRadioButton rb1, rb2, rb3;

	public RegistrationFrame(){
		super("User Registration");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		rb1 = new JRadioButton("Admin");
		rb2 = new JRadioButton("Owner");
		rb3 = new JRadioButton("Tenant");
		
		as = new JLabel("Register as");
		newUser = new JLabel("Username: ");
		newPass = new JLabel("Password: ");
		username = new JTextField(15);
		password = new JTextField(15);
		
		p1.add(newUser);
		p1.add(username);
		p2.add(newPass);
		p2.add(password);
		p3.add(rb1);
		p3.add(rb2);
		p3.add(rb3);
		
		signup = new JButton("SignUp");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 15));
		c.add(as);
		c.add(p3);
		c.add(p1);
		c.add(p2);
		
		c.add(signup);
		
		signup.addActionListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==signup){	// takes input as username and password still needs approval by existing admin
			String user = String.valueOf(username.getText());
			String pass = password.getText();
			String type = "";
			if(rb1.isSelected()){
				type = "Admin";
				Admin a = new Admin(user, pass);
				LoginFrame.newUserList.add(a);	//object is passed to new users registration arraylist
			}
			else if(rb2.isSelected()){
				type = "Owner";
				Owner o = new Owner(user, pass);
				LoginFrame.newUserList.add(o);
			}
			else if(rb3.isSelected()){
				type = "Tenant";
				Tenant t = new Tenant(user, pass);
				LoginFrame.newUserList.add(t);
			}
			JOptionPane.showMessageDialog(rootPane,"Registration request sent to Admin for approval!");
			
			dispose();
			LoginFrame lf = new LoginFrame();// back to login option
			
		}
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==rb1){
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