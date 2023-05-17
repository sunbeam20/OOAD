import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;

public class HideFrame extends JFrame implements ActionListener{	//this takes input for the property id that need to hide
    OwnerView ov;
    private JLabel title;
    private JTextField hideText;
    private Boolean exist = true;
    private Boolean hiding = true;
    private JButton hideButton;
    private String own;

    public HideFrame(String owner){//enter the id of the property we user want to hide
        title = new JLabel("Please enter the ID of property you want to hide.",JLabel.CENTER);
        hideText = new JTextField(20);
        hideButton = new JButton("Enter");
        hideButton.addActionListener(this);
        JPanel p1 = new JPanel();
        p1.add(title);
        JPanel p2 = new JPanel();
        p2.add(hideText);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(p1);
        c.add(p2);
        c.add(hideButton);

        setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

        own = owner;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int hideId = Integer.parseInt(hideText.getText());
        if(e.getSource()==hideButton){
            for(int i=0; i<LoginFrame.propertyList.size(); i++){
                if(LoginFrame.propertyList.get(i).getPropertyID() == hideId){
                    exist = false;
                    if(LoginFrame.propertyList.get(i).getHiddentStatus() == false){
                        LoginFrame.propertyList.get(i).setHidden();
                        JOptionPane.showMessageDialog(rootPane,"The property is now hidding.");
                        hiding = false;
                        dispose();
                        ov = new OwnerView(own);//display ownerview again to see the update
                    }
                }
            }
            if(exist){
                    JOptionPane.showMessageDialog(rootPane,"The property doesn't exist.");dispose();ov = new OwnerView(own);
            }else if(hiding){
                JOptionPane.showMessageDialog(rootPane,"The property is already hidden.");dispose();ov = new OwnerView(own);
            }
        }
    }
}