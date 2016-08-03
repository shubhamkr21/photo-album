import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class photo_frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel label;
	private JLabel lblNewLabel;
	private JButton btnShowImage;
	private JButton btnExit;
	static DefaultTableModel model;
	static ArrayList <image> imagelist = new ArrayList <image> ();
	static display_photo dframe = new display_photo();
	private JButton btnShowAll;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					photo_frame frame = new photo_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		loadFromFile();
		model.setRowCount(0);
		for(int i=0; i<imagelist.size(); i++){
			Object [] p = {imagelist.get(i).getTitle()};
      	  	model.addRow(p);
		}
	}

	/**
	 * Create the frame.
	 */
	public photo_frame() {
		setTitle("Photo Album");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Shubham\\workspace\\Photo_Album\\src\\icon.jpg"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 328, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 68, 186, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = (new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title of Photo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setModel(model);
		scrollPane.setViewportView(table);
		//lblNewLabel.setBounds(10, 11, 555, 372);
		
		JButton btnAddPhoto = new JButton("Add Photo");
		btnAddPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add_image aiframe = new add_image();
				if(imagelist.size() < 10){
				aiframe.getTextField().setText(null);
				aiframe.getTextField_1().setText(null);
				aiframe.getLabel().setIcon(null);
				aiframe.setVisible(true); 
				}
				else {
					JOptionPane.showMessageDialog(null, "Image List is Full","Alert",JOptionPane.INFORMATION_MESSAGE);
				}
				aiframe.btnBrowse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String path;
						Image img,newImg;
						ImageIcon MyImage,image;
						int result;
						JFileChooser file = new JFileChooser();
						
						FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
						file.addChoosableFileFilter(filter);
				         result = file.showOpenDialog(null);
				        if(result == JFileChooser.APPROVE_OPTION){
				        	  File selectedFile = file.getSelectedFile();
				        	  path = selectedFile.getAbsolutePath();
				        	  MyImage = new ImageIcon(path);
				        	  img = MyImage.getImage();
				        	  newImg = img.getScaledInstance(aiframe.getLabel().getWidth(),
				        			  aiframe.getLabel().getHeight(),
				        			  Image.SCALE_SMOOTH);
				        	  image = new ImageIcon(newImg);
				        	  aiframe.getLabel().setIcon(image);
				        	 
				          }
					}
				});
				
				aiframe.btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(aiframe.getLabel().getIcon() == null) {
							JOptionPane.showMessageDialog(null, "Please Browse an Image to Save","warning",JOptionPane.WARNING_MESSAGE);
						}
						else{
						 image im = new image(aiframe.getTextField().getText(),aiframe.getTextField_1().getText(),aiframe.getLabel());
			        	  imagelist.add(im);
			        	  Object [] p = {aiframe.getTextField().getText()};
			        	  model.addRow(p);
			        	  aiframe.setVisible(false);
						}
					}
				});	
			}
		});
		btnAddPhoto.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnAddPhoto.setBounds(25, 11, 114, 35);
		contentPane.add(btnAddPhoto);
		
		btnShowImage = new JButton("Show Image");
		btnShowImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				int index = table.getSelectedRow();
				dframe.setTitle(imagelist.get(index).getTitle());
				dframe.getLabel().setIcon(imagelist.get(index).getLbl().getIcon());
				dframe.getLabel().setToolTipText(imagelist.get(index).getAnnotation());
				dframe.btnNext.setVisible(false);
				dframe.btnPrevious.setVisible(false);
				dframe.setVisible(true);
				} catch (Exception e ){
					JOptionPane.showMessageDialog(null, "No Photo Selected","Alert",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnShowImage.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnShowImage.setBounds(43, 390, 128, 35);
		contentPane.add(btnShowImage);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveToFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnExit.setBounds(209, 390, 93, 35);
		contentPane.add(btnExit);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			int index = 0;
			public void actionPerformed(ActionEvent arg0) {
				
				if(imagelist.size() > 0){
					dframe.setTitle(imagelist.get(index).getTitle());
					dframe.getLabel().setIcon(imagelist.get(index).getLbl().getIcon());
					dframe.getLabel().setToolTipText(imagelist.get(index).getAnnotation());
					dframe.btnNext.setVisible(true);
					dframe.btnPrevious.setVisible(true);
					dframe.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Photo Album is Empty", "message" , JOptionPane.INFORMATION_MESSAGE);
				}
				dframe.btnNext.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int size = imagelist.size();
						index++;
						if(index < size) {
							dframe.setTitle(imagelist.get(index).getTitle());
							dframe.getLabel().setIcon(imagelist.get(index).getLbl().getIcon());
							dframe.getLabel().setToolTipText(imagelist.get(index).getAnnotation());
						}
						else {
							index--;
							JOptionPane.showMessageDialog(null, "this is last image in list", "message" , JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				dframe.btnPrevious.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						index--;
						if(index >= 0) {
							dframe.setTitle(imagelist.get(index).getTitle());
							dframe.getLabel().setIcon(imagelist.get(index).getLbl().getIcon());
							dframe.getLabel().setToolTipText(imagelist.get(index).getAnnotation());
						}
						else {
							index++;
							JOptionPane.showMessageDialog(null, "this is first image in list", "message" , JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			}
		});
		btnShowAll.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		btnShowAll.setBounds(180, 11, 114, 35);
		contentPane.add(btnShowAll);
		
		
		
	}
	
	public static void saveToFile() throws FileNotFoundException, IOException {
        int c = imagelist.size();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/imagelist.txt"));
		os.writeInt(c);
		for(int i=0; i<c; i++){
			os.writeObject(imagelist.get(i));
		}
		os.close();
	}
	
	public static void loadFromFile() throws IOException, ClassNotFoundException {
        int c=0;
		ObjectInputStream is;
		try{
			is = new ObjectInputStream(new FileInputStream("src/imagelist.txt"));
		}catch(FileNotFoundException e){
			c = 0; return;
		}
		c = is.readInt();
		for(int i=0; i<c; i++){
			imagelist.add((image) is.readObject());
		}
		is.close();
	}
}
