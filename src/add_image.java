import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class add_image extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JButton btnBrowse;
	JLabel label;
	JButton btnSave;

	public add_image() {
		setTitle("Add Image");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitleOfImage = new JLabel("Title of image (upto 20 chars) :");
		lblTitleOfImage.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblTitleOfImage.setBounds(40, 32, 236, 27);
		contentPane.add(lblTitleOfImage);
		
		textField = new JTextField();
		textField.setBounds(306, 33, 273, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAnnotation = new JLabel("Annotation (upto 100 chars) :");
		lblAnnotation.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblAnnotation.setBounds(40, 85, 236, 34);
		contentPane.add(lblAnnotation);
		
		textField_1 = new JTextField();
		textField_1.setBounds(308, 90, 451, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		label = new JLabel("");
		label.setBounds(62, 155, 770, 400);
		contentPane.add(label);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		
		btnBrowse.setBounds(240, 578, 136, 46);
		contentPane.add(btnBrowse);
		
		btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		btnSave.setBounds(533, 581, 109, 43);
		contentPane.add(btnSave);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JLabel getLabel() {
		return label;
	}
}
