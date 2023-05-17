import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;

public class UnHideFrame extends JFrame implements ActionListener{	// unihide property by owner
    OwnerView ov;
    private JLabel title;
    private JTextField unhideText;
    private Boolean exist = true;
    private Boolean hiding = true;
    private JButton unhideButton;
    private String own;

    public UnHideFrame(String owner){//enter the id of the property we user want to modify
        title = new JLabel("Please enter the ID of property you want to unhide.",JLabel.CENTER);
        unhideText = new JTextField(20);
        unhideButton = new JButton("Enter");
        unhideButton.addActionListener(this);
        JPanel p1 = new JPanel();
        p1.add(title);
        JPanel p2 = new JPanel();
        p2.add(unhideText);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(p1);
        c.add(p2);
        c.add(unhideButton);

        setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

        own = owner;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int unhideId = Integer.parseInt(unhideText.getText());
        if(e.getSource()==unhideButton){
            for(int i=0; i<LoginFrame.propertyList.size(); i++){
                if(LoginFrame.propertyList.get(i).getPropertyID() == unhideId){
                    exist = false;
                    if(LoginFrame.propertyList.get(i).getHiddentStatus() == true){
                        LoginFrame.propertyList.get(i).setUnHidden();
                        JOptionPane.showMessageDialog(rootPane,"The property is now unhidding.");
                        hiding = false;
                        dispose();
                        ov = new OwnerView(own);
                    }
                }
                }
                if(exist){
                    JOptionPane.showMessageDialog(rootPane,"The property doesn't exist.");
            }else if(hiding){
                JOptionPane.showMessageDialog(rootPane,"The property is already unhidden.");dispose();
				ov = new OwnerView(own);
            }
        }
    }
}