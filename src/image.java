import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class image implements Serializable{
	private String title;
	private String annotation;
	private JLabel lbl;

	public image(String title, String annotation, JLabel lbl) {
		this.title = title;
		this.annotation = annotation;
		this.lbl = lbl;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public JLabel getLbl() {
		return lbl;
	}
	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

}
