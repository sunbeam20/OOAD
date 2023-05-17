import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;

public class ModifyFrame extends JFrame implements ActionListener{
    ModifyProperty mp;
    private JLabel title;
    private JTextField modifyText;
    private Boolean exist = true;
    private JButton modifyButton;
    private String own;

    public ModifyFrame(String owner){//enter the id of the property we user want to modify
        own = owner;
        title = new JLabel("Please enter the ID of property you want to modify.",JLabel.CENTER);
        modifyText = new JTextField(20);
        modifyButton = new JButton("Enter");
        modifyButton.addActionListener(this);
        JPanel p1 = new JPanel();
        p1.add(title);
        JPanel p2= new JPanel();
        p2.add(modifyText);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(p1);
        c.add(p2);
        c.add(modifyButton);

        setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        int modifyId = Integer.parseInt(modifyText.getText());
        if(e.getSource()==modifyButton){
            for(int i=0; i<LoginFrame.propertyList.size(); i++){
                if(LoginFrame.propertyList.get(i).getPropertyID() == modifyId){	// checks if inputted id exist in system for this owner
                    if(LoginFrame.propertyList.get(i).getHiddentStatus() == false){
                    int m = i;
                    exist = false;
                    dispose();mp = new ModifyProperty(m,own);	// call the modify property class to edit
                    
                    }
                }
            }
            if(exist){
                JOptionPane.showMessageDialog(rootPane,"The property doesn't exist.");
            }
        }
    }
}
