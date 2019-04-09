import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TEST {
	public static void main (String[] args) {

		JFrame f = new JFrame("My Window");
		f.setSize(400,100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setLayout(new FlowLayout());

		JLabel l = new JLabel("What is your name?");
		JTextField t = new JTextField(20);
		
		JButton b = new JButton("OK");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a){
				System.out.println(t.getText());
			}
		});

		f.add(l);
		f.add(t);
		f.add(b);

		f.setVisible(true);
	}
} 