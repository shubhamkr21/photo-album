import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class display_photo extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private Icon ic;
	JButton btnNext;
	JButton btnPrevious;

	public Icon getIc() {
		return ic;
	}

	public void setIc(Icon ic) {
		this.ic = ic;
	}

	/**
	 * Launch the application.
	 */
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	/**
	 * Create the frame.
	 */
	public display_photo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Shubham\\workspace\\Photo_Album\\src\\icon.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(10, 11, 770, 400);
		contentPane.add(label);
		
		btnNext = new JButton("Next");
		
		btnNext.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		btnNext.setBounds(611, 422, 89, 24);
		contentPane.add(btnNext);
		
		btnPrevious = new JButton("Previous");
		
		btnPrevious.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		btnPrevious.setBounds(141, 422, 111, 23);
		contentPane.add(btnPrevious);
	}
}
