import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Frame1 extends javax.swing.JFrame {

	private JFrame frame;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Cryptosystem");
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		text = new JTextField();
		frame.setTitle("Cryptosystem");
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		text.setBounds(174, 34, 143, 23);
		frame.getContentPane().add(text);
		text.setColumns(10);
		JTextArea pcText = new JTextArea();
		pcText.setBounds(174, 112, 143, 22); 
		
		JLabel lblNewLabel = new JLabel("Text");
		lblNewLabel.setBounds(10, 38, 31, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plaint Text/Cipher Text");
		lblNewLabel_1.setBounds(10, 117, 133, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton encrypt = new JButton("Encrypt");
		
		encrypt.setBounds(54, 219, 89, 23);
		frame.getContentPane().add(encrypt);
		
		JButton decrypt = new JButton("Decrypt");
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s="";
			try {
			pcText.setText("");
            s = text.getText();
			s= s.replaceAll("\\s+","");

			if((s.length()!=12)){
			JOptionPane.showMessageDialog(frame,"Invalid Input!\n you must enter 12 characters,please try again","Warning",JOptionPane.ERROR_MESSAGE);
			text.setText("");
			}else{
				Text t = new Text(s);
				String result = t.decryption();
				if(result == null) {
					JOptionPane.showMessageDialog(null,"Invalid Input, please try again");
					text.setText("");
				}else
					pcText.setText(result);
				
			}
				
		    }catch(Exception x){
					JOptionPane.showMessageDialog(null,"Invalid Input, please try again");
					text.setText("");
				}
			}
		});
		
		decrypt.setBounds(228, 219, 89, 23);
		frame.getContentPane().add(decrypt);
		
		
		frame.getContentPane().add(pcText);
		
		JLabel lblNoteYouMust = new JLabel("Note: you must enter 12 characters");
		lblNoteYouMust.setBounds(10, 68, 215, 14);
		frame.getContentPane().add(lblNoteYouMust);
		
		encrypt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String s="";
				try {
				pcText.setText("");
                s = text.getText().toLowerCase();
				s= s.replaceAll("\\s+","");

				if((s.length()!=12 || !Character.isLetter(s.charAt(0)) || !Character.isLetter(s.charAt(1))||!Character.isLetter(s.charAt(2))||!Character.isLetter(s.charAt(3))||!Character.isLetter(s.charAt(4))||!Character.isLetter(s.charAt(5))||!Character.isLetter(s.charAt(6))||!Character.isLetter(s.charAt(7))||!Character.isLetter(s.charAt(8))||!Character.isLetter(s.charAt(9))||!Character.isLetter(s.charAt(10))||!Character.isLetter(s.charAt(11)))){
				JOptionPane.showMessageDialog(frame,"Invalid Input!\n you must enter 12 letters,please try again","Warning",JOptionPane.ERROR_MESSAGE);
				text.setText("");
				}else {
					Text t = new Text(s);
					String result = t.encryption();
					if(result == null) {
						JOptionPane.showMessageDialog(null,"Invalid Input, please try again");
						text.setText("");
					}else
						pcText.setText(result);
					
				}
					
			    }catch(Exception x){
						JOptionPane.showMessageDialog(null,"Invalid Input, please try again");
						text.setText("");
					}
					
			}
		});

	}
}
