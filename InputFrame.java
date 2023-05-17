import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;

public class InputFrame extends JFrame implements ActionListener{
	private JLabel user, pass;
	private JTextField userText, passText;
	private JButton loginButton, back;
	private Boolean thanos = true;
	private OwnerView ov; //use of Aggregation
	private AdminView av; //use of Aggregation
	
	public InputFrame(){
		super("Login as " + User.getX());
		user = new JLabel("Username", JLabel.CENTER);
		userText = new JTextField(20);
		pass = new JLabel("Password", JLabel.CENTER);
		passText = new JTextField(20);
		
		JPanel p1 = new JPanel();
		p1.add(user);
		p1.add(userText);
		JPanel p2 = new JPanel();
		p2.add(pass);
		p2.add(passText);
		
		loginButton = new JButton("Login->");	
		loginButton.addActionListener(this);
		back = new JButton("<-Back");
		back.addActionListener(this);
		
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); 
		c.add(p1);
		c.add(p2);
		c.add(back);
		c.add(loginButton);
		
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		String username = String.valueOf(userText.getText());	//takes the input from textfield to String
		String password = String.valueOf(passText.getText());
		if(e.getSource()==loginButton){
			for(int i=0; i<LoginFrame.userList.size(); i++){
			  if(User.getX() == "Admin"){	// checks for login options
				if(username.equals(LoginFrame.userList.get(i).getUserName()) && password.equals(LoginFrame.userList.get(i).getPassword())){	//checks with existing username and password
					JOptionPane.showMessageDialog(rootPane,"Login Successfull");
					dispose();av = new AdminView();
					
					thanos = false;
				}
			  }
			  else if(User.getX() == "Owner"){
				if(username.equals(LoginFrame.userList.get(i).getUserName()) && password.equals(LoginFrame.userList.get(i).getPassword())){
					JOptionPane.showMessageDialog(rootPane,"Login Successfull");
					String own = username;
					System.out.print(own);
					dispose();ov = new OwnerView(own);
					//PropertyController pc = new PropertyController(ov);
					thanos = false;
					
				}
			  }
			  else if(User.getX() == "Tenant"){
				if(username.equals(LoginFrame.userList.get(i).getUserName()) && password.equals(LoginFrame.userList.get(i).getPassword())){
					JOptionPane.showMessageDialog(rootPane,"Login Successfull");
					String ten = username;
					dispose();
					PropertyView pv = new PropertyView(ten);
					thanos = false;
				}	
			  }
			}
			if(thanos){
					JOptionPane.showMessageDialog(rootPane,"Incorrect Username Or Password!");//if username or password doesnt matches
			  }
		}
		else if(e.getSource()==back){//go back to loginas options
			dispose();
			LoginFrame lf = new LoginFrame();
		}
	}
}