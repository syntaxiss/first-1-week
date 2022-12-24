
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Definitive extends JFrame implements ActionListener, ChangeListener{
	JLabel nm, con, fns;
	JTextField name;
	JComboBox<String> cntry;
	JRadioButton n1,n2,n3,n4;
	JButton b;
	ButtonGroup bg;
	JMenuBar barr;
	JMenu mmn,cl,sz;
	JMenuItem cl1,cl2,cl3, sz1,sz2;
	JCheckBox cb;
	public void Menu() {
		setLayout(null);
		barr = new JMenuBar();
		setJMenuBar(barr);
		mmn = new JMenu("Options");
		barr.add(mmn);
		cl = new JMenu("Color");
		mmn.add(cl);
		sz = new JMenu("Size");
		mmn.add(sz);
		cl1 = new JMenuItem("Red");
		cl.add(cl1);
		cl2 = new JMenuItem("Blue");
		cl.add(cl2);
		cl3 = new JMenuItem("White");
		cl.add(cl3);
		sz1 = new JMenuItem("1080x720");
		sz.add(sz1);
		sz2 = new JMenuItem("800x560");
		sz.add(sz2);
		sz1.addActionListener(this);
		sz2.addActionListener(this);
		cl1.addActionListener(this);
		cl2.addActionListener(this);
		cl3.addActionListener(this);
		
	}
	public void inf() {
		nm = new JLabel("What's your name?");
		nm.setBounds(10, 10, 120, 25);
		add(nm);
		con = new JLabel("Where you from?");
		con.setBounds(10, 60, 120, 25);
		add(con);
		name = new JTextField();
		name.setBounds(130, 10, 120, 25);
		add(name);
		cntry = new JComboBox<String>();
		cntry.setBounds(130, 60, 120, 25);
		add(cntry);
		Cont c = new Cont();
		for(int f=0; f<193;f++) {
			cntry.addItem(c.con.get(f));
		}
		
	}
	public void slc() {
		bg = new ButtonGroup();
		n1 = new JRadioButton("Sleeps 4 hours");
		n1.setBounds(10, 90, 120, 25);
		add(n1);
		bg.add(n1);
		n2 = new JRadioButton("Sleeps 6 hours");
		n2.setBounds(10, 120, 120, 25);
		add(n2);
		bg.add(n2);
		n3 = new JRadioButton("Sleeps 8 hours");
		n3.setBounds(10, 150, 120, 25);
		add(n3);
		bg.add(n3);
		n4 = new JRadioButton("Sleeps 12 hours");
		n4.setBounds(10, 180, 180, 25);
		add(n4);
		bg.add(n4);
	}
	public void fn() {
		cb = new JCheckBox("You agree to the processing of your data");
		cb.setBounds(10,210,250,25);
		add(cb);
		cb.addChangeListener(this);
		b = new JButton("Accept");
		b.setBounds(50, 250, 80, 25);
		add(b);
		b.setEnabled(false);
		b.addActionListener(this);
		fns = new JLabel("");
		fns.setBounds(50, 300, 350, 25);
		fns.setVisible(false);
		add(fns);
	}
	public void stateChanged(ChangeEvent y) {
		if(cb.isSelected()==true) {
			b.setEnabled(true);
		}else {
			b.setEnabled(false);
		}
		
	}
	public void actionPerformed(ActionEvent u){
		if(u.getSource()==cl1) {
			getContentPane().setBackground(Color.RED);
		}
		if(u.getSource()==cl2) {
			getContentPane().setBackground(Color.BLUE);
		}
		if(u.getSource()==cl3) {
			getContentPane().setBackground(Color.WHITE);
		}
		if(u.getSource()==sz1) {
			setSize(1080, 720);
		}
		if(u.getSource()==sz2) {
			setSize(800, 560);
		}
		if(u.getSource()==b) {
			String tt = "";
			tt = tt+" "+name.getText();
			tt = tt+" from "+cntry.getSelectedItem();
			if(n1.isSelected()==true) {
				tt = tt+" is a zombie";
			}
			if(n2.isSelected()==true) {
				tt = tt+" is a semi-zombie";
			}
			if(n3.isSelected()==true) {
				tt = tt+" is normal";
			}
			if(n4.isSelected()==true) {
				tt = tt+" is a lazy";
			}
			fns.setText(tt);
			fns.setVisible(true);
		}
	}
	public static void main(String[] args) {
		Definitive d = new Definitive();
		d.Menu();
		d.inf();
		d.slc();
		d.fn();
		d.setBounds(10, 10, 500, 500);
		d.setVisible(true);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
