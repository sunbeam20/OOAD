import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.*;

public class PropertyController extends JFrame implements ActionListener{	//controller of mvc
	private OwnerView ov;
	StringBuilder sb = new StringBuilder();
	String category[] = {"Property Type: ","Condominium", "Service Residence","Apartment"};
	JComboBox<String> cb = new JComboBox<>(category);
	JButton next = new JButton("Next");
	private String own;
	
	public PropertyController(String owner){
		super("Upload by Category");
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JLabel l = new JLabel("Choose Property Category", JLabel.CENTER);
		own = owner;
		
		p.add(l);
		p1.add(cb);
		p1.add(next);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(3,1));
		c.add(p, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);
		
		setSize(300,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		next.addActionListener(this);
		setLocationRelativeTo(null);
		setResizable(false);
	}
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == next) {
           switch (cb.getSelectedIndex()){
			   case 0:
			   break;
			   case 1:dispose();
					InputProperty ip = new InputProperty(own, cb.getSelectedIndex()); //calls this class for inputting new property data, paramenter of owner name and property type
				break;
				case 2:dispose();
					InputProperty ip2 = new InputProperty(own, cb.getSelectedIndex()); 
				break;
				case 3:dispose();
					InputProperty ip3 = new InputProperty(own, cb.getSelectedIndex()); 
				break;
		   }
        }
	}
		
}