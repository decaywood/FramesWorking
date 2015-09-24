package views.generalComponents;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DateTextField extends JTextField{
	
	private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder();
	private JTextField[] jtf_dateFields = new JTextField[3];

	
	public DateTextField(){
		
		super();								//创建一个父文本输入框
		setBounds(0, 0, 120, 30);				//设置默认大小
		setPreferredSize(new Dimension(120, 30));
		setEditable(false);						//设置主框不能编辑
		setLayout(new GridLayout(1, 3, 0, 0));	//采用网格布局，将父文本输入框分为三格

		JLabel[] minus = new JLabel[2];
		JPanel[] jpanelFields = new JPanel[3];
		
		for(int i=0; i<3; i++){
			jtf_dateFields[i] = new JTextField();							//创建三个子文本输入框
			jtf_dateFields[i].setBorder(EMPTY_BORDER);						//隐去子文本输入框的边框
			jtf_dateFields[i].setHorizontalAlignment(JTextField.CENTER);	//设置输入为居中
			jpanelFields[i] = new JPanel();									//创建用于存放子文本输入框的面板
			jpanelFields[i].setBorder(EMPTY_BORDER);						//隐去面板边框
			jpanelFields[i].setLayout(new BorderLayout(0, 0));				//面板使用边框布局，使得子框可以随父框大小而整体变化
			jpanelFields[i].add(BorderLayout.CENTER, jtf_dateFields[i]);	//使用边界布局，添加子文本输入框剧中放置
			//添加“冒号”
			if(i != 0){
				minus[i-1] = new JLabel("-");							
				minus[i-1].setBorder(EMPTY_BORDER);
				minus[i-1].setOpaque(true);
				minus[i-1].setBackground(jtf_dateFields[i].getBackground());
				jpanelFields[i].add(BorderLayout.WEST, minus[i-1]);
			}
			add(jpanelFields[i]);
		}
		
		jtf_dateFields[0].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
				} else {
					e.consume(); 
				}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				if(jtf_dateFields[0].getText().equals("") || jtf_dateFields[0].getText().length()>4)
					jtf_dateFields[0].setText("");
				else if(jtf_dateFields[0].getText().length() == 4) {
					if((Integer.parseInt(jtf_dateFields[0].getText())<=2100)&&(Integer.parseInt(jtf_dateFields[0].getText())>=1900))
						;
					else
						jtf_dateFields[0].setText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		jtf_dateFields[1].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
				} else {
					e.consume(); 
				}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				if(jtf_dateFields[1].getText().equals("") || jtf_dateFields[1].getText().length()>2)
					jtf_dateFields[1].setText("");
				else {
					if((Integer.parseInt(jtf_dateFields[1].getText())<=12)&&(Integer.parseInt(jtf_dateFields[1].getText())>=1))
						;
					else
						jtf_dateFields[1].setText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		jtf_dateFields[2].addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
				} else {
					e.consume(); 
				}
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				if(jtf_dateFields[2].getText().equals("") || jtf_dateFields[2].getText().length()>2)
					jtf_dateFields[2].setText("");
				else {
					if((Integer.parseInt(jtf_dateFields[2].getText())<=31)&&(Integer.parseInt(jtf_dateFields[2].getText())>=1))
						;
					else
						jtf_dateFields[2].setText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
	}
	
	public String getText_NoDelimiter() {
		String date, year, month, day;
		year = jtf_dateFields[0].getText();
		if(jtf_dateFields[1].getText().length() == 1)
			month = "0"+jtf_dateFields[1].getText();
		else
			month = jtf_dateFields[1].getText();
		if(jtf_dateFields[2].getText().length() == 1)
			day = "0"+jtf_dateFields[2].getText();
		else
			day = jtf_dateFields[2].getText();
		date = year+month+day;
		return date;
	}
	
	@Override
	public String getText() {
		String date, year, month, day;
		year = jtf_dateFields[0].getText();
		if(jtf_dateFields[1].getText().length() == 1)
			month = "0"+jtf_dateFields[1].getText();
		else
			month = jtf_dateFields[1].getText();
		if(jtf_dateFields[2].getText().length() == 1)
			day = "0"+jtf_dateFields[2].getText();
		else
			day = jtf_dateFields[2].getText();
		if(year.equals("")&&month.equals("")&&day.equals(""))
			date = "";
		else {
			if(year.equals(""))
				year = "00";
			if(month.equals(""))
				month = "00";
			if(day.equals(""))
				day = "00";
			date = year+"-"+month+"-"+day;
		}
		return date;
	}
	
	public void setNull() {
		jtf_dateFields[0].setText("");
		jtf_dateFields[2].setText("");
		jtf_dateFields[1].setText("");
	}
	
	public void setDate(Date date) {

		if (date == null) return;
		String y, m, d, str;
		str = new SimpleDateFormat("yyyy-MM-dd").format(date);
		y = str.substring(0, 4);
		m = str.substring(5, 7);
		d = str.substring(8);
		jtf_dateFields[0].setText(y);
		jtf_dateFields[1].setText(m);
		jtf_dateFields[2].setText(d);

	}
	
	public void setDate(String date) {
		if(date == null) return;
		Date d = new Date();
		if("".equals(date) || date == null) {
			setNull();
		} else {
			try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch(Exception e) {
				System.out.println("置入时间格式不正确, 请按格式'HH:mm:ss'置入.");
			}
			setDate(d);
		}
	}
	
	 

}
