package views.generalComponents;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Please choose Text File Coding with UTF-8 to read Chinese annotation.
 * @author 钱睿
 * @since 2015/7/5 13:47
 * @version 2.1
 * @see java.util.Date, javax.swing
 * @名称  时间输入框 (JTextField的继承类).
 * @描述  时间输入专用框, 提供限制输入内容, 获取输入内容等方法.
 */
@SuppressWarnings("serial")
public class TimeTextField extends JTextField {
	private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder();
	private JTextField[] jtf_timeFields= new JTextField[3];
	
	/**
	 * @方法名 构造方法
	 * @描述 创建一个时间输入框
	 * @since 2015/08/12
	 */
	public TimeTextField(){
		
		super();								//创建一个父文本输入框
		setBounds(0, 0, 120, 30);				//设置默认大小
		setPreferredSize(new Dimension(120, 30));
		setLayout(new GridLayout(1, 3, 0, 0));	//采用网格布局，将父文本输入框分为三格
		setEditable(false);

		JLabel[] jl_colons = new JLabel[2];
		JPanel[] jpanelFieldPanels = new JPanel[3];
		
		for(int i=0; i<3; i++){
			jtf_timeFields[i] = new JTextField();								//创建子文本输入框
			jtf_timeFields[i].setBorder(EMPTY_BORDER);							//隐去子文本输入框的边框
			jtf_timeFields[i].setHorizontalAlignment(JTextField.CENTER);		//设置输入为居中
			jtf_timeFields[i].setText("");
			jpanelFieldPanels[i] = new JPanel();								//创建用于存放子文本输入框的面板
			jpanelFieldPanels[i].setBorder(EMPTY_BORDER);						//隐去面板边框
			jpanelFieldPanels[i].setLayout(new BorderLayout(0, 0));				//面板使用边框布局，使得子框可以随父框大小而整体变化
			jpanelFieldPanels[i].add(BorderLayout.CENTER, jtf_timeFields[i]);	//使用边界布局，添加子文本输入框剧中放置
			//添加“冒号”
			if(i != 2){
				jl_colons[i] = new JLabel(":");									//创建“冒号”分隔符
				jl_colons[i].setBorder(EMPTY_BORDER);							//隐去分隔符边框
				jl_colons[i].setOpaque(true);									//设置控件透明
				jl_colons[i].setBackground(jtf_timeFields[i].getBackground());	//设置底色与存放面板底色相同
				jpanelFieldPanels[i].add(BorderLayout.EAST, jl_colons[i]);		//使用边界布局，添加分隔符在存放面板的右边
			}
			add(jpanelFieldPanels[i]);
		}
		
		//添加输入事件监听器
		/*
		 * 功能：
		 * 1.只能输入数字
		 * 2.时必须在[0,24)之间，分必须在[0,60)之间，秒必须在[0,60)之间
		 */
		jtf_timeFields[0].addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
				} else {
					e.consume(); 
				}
			}
			public void keyReleased(KeyEvent e) {
				if(jtf_timeFields[0].getText().equals("") || jtf_timeFields[0].getText().length()>=3)
					jtf_timeFields[0].setText("");
				else {
					if((Integer.parseInt(jtf_timeFields[0].getText())<24)&&(Integer.parseInt(jtf_timeFields[0].getText())>=0))
						;
					else
						jtf_timeFields[0].setText("");
				}
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		jtf_timeFields[1].addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
				} else {
					e.consume(); 
				}
			}
			public void keyReleased(KeyEvent e) {
				if(jtf_timeFields[1].getText().equals("") || jtf_timeFields[1].getText().length()>=3)
					jtf_timeFields[1].setText("");
				else {
					if((Integer.parseInt(jtf_timeFields[1].getText())<60)&&(Integer.parseInt(jtf_timeFields[1].getText())>=0))
						;
					else
						jtf_timeFields[1].setText("");
				}
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		jtf_timeFields[2].addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
				} else {
					e.consume(); 
				}
			}
			public void keyReleased(KeyEvent e) {
				if(jtf_timeFields[2].getText().equals("") || jtf_timeFields[2].getText().length()>=3)
					jtf_timeFields[2].setText("");
				else {
					if((Integer.parseInt(jtf_timeFields[2].getText())<60)&&(Integer.parseInt(jtf_timeFields[2].getText())>=0))
						;
					else
						jtf_timeFields[2].setText("");
				}
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		
	}
	
	//获得无分割符的时间字符串
	public String getText_NoDelimiter(){
		
		String date,hour,minute,second;
		if(jtf_timeFields[0].getText().length() == 1)
			hour = "0"+jtf_timeFields[0].getText();
		else
			hour = jtf_timeFields[0].getText();
		if(jtf_timeFields[1].getText().length() == 1)
			minute = "0"+jtf_timeFields[1].getText();
		else
			minute = jtf_timeFields[1].getText();
		if(jtf_timeFields[2].getText().length() == 1)
			second = "0"+jtf_timeFields[2].getText();
		else
			second = jtf_timeFields[2].getText();
		date = hour+minute+second;
		return date;
	}
	
	//获得自定义符号作为分隔符的时间字符串
	public String getText(char delimiter){
		
		String date,hour,minute,second;
		if(jtf_timeFields[0].getText().length() == 1)
			hour = "0"+jtf_timeFields[0].getText();
		else
			hour = jtf_timeFields[0].getText();
		if(jtf_timeFields[1].getText().length() == 1)
			minute = "0"+jtf_timeFields[1].getText();
		else
			minute = jtf_timeFields[1].getText();
		if(jtf_timeFields[2].getText().length() == 1)
			second = "0"+jtf_timeFields[2].getText();
		else
			second = jtf_timeFields[2].getText();
		date = hour+ delimiter +minute+ delimiter +second;
		return date;
	}
	
	//得到完整的字符串，与“冒号分隔符的字符串”相同
	@Override
	public String getText(){
		String time,hour,minute,second;
		if(jtf_timeFields[0].getText().length() == 1)
			hour = "0"+jtf_timeFields[0].getText();
		else
			hour = jtf_timeFields[0].getText();
		if(jtf_timeFields[1].getText().length() == 1)
			minute = "0"+jtf_timeFields[1].getText();
		else
			minute = jtf_timeFields[1].getText();
		if(jtf_timeFields[2].getText().length() == 1)
			second = "0"+jtf_timeFields[2].getText();
		else
			second = jtf_timeFields[2].getText();
		if(hour.equals("")&&minute.equals("")&&second.equals(""))
			time = "";
		else {
			if(hour.equals(""))
				hour = "00";
			if(minute.equals(""))
				minute = "00";
			if(second.equals(""))
				second = "00";
			time = hour+":"+minute+":"+second;
		}
		
		return time;
	}
	
	//获得输入时间为时间的Date, 以系统日期为日期.
	public Date getTime(){
		Date date = new Date();
		Date datetime = new Date();
		String tempdate,temptime,hour,minute,second;
		if(jtf_timeFields[0].getText().length() == 1)
			hour = "0"+jtf_timeFields[0].getText();
		else
			hour = jtf_timeFields[0].getText();
		if(jtf_timeFields[1].getText().length() == 1)
			minute = "0"+jtf_timeFields[1].getText();
		else
			minute = jtf_timeFields[1].getText();
		if(jtf_timeFields[2].getText().length() == 1)
			second = "0"+jtf_timeFields[2].getText();
		else
			second = jtf_timeFields[2].getText();
		temptime = hour+":"+minute+":"+second;
		try {
			tempdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			datetime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(tempdate+temptime);
		}
		catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return datetime;
	}
	
	//预置时间，提取Date参数中的时间，置入输入框，舍去日期项
	public void setTime(Date date){
		
		String d, h, m, s;
		d = new SimpleDateFormat("HH:mm:ss").format(date);
		h = d.substring(0, 2);
		m = d.substring(3, 5);
		s = d.substring(6);
		jtf_timeFields[0].setText(h);
		jtf_timeFields[1].setText(m);
		jtf_timeFields[2].setText(s);
		
	}
	
	//预置时间
	public void setTime(int hour, int minute, int second){
		
		String h = "", m = "", s = "";
		
		if(hour >= 0 && hour <= 9) {
			h = "0" + Integer.toString(hour);
		} else if(hour >= 10 && hour <= 23) {
			h = Integer.toString(hour);
		}
		
		if(minute >= 0 && hour <= 9) {
			m = "0" + Integer.toString(minute);
		} else if(minute >= 10 && minute <= 59) {
			m = Integer.toString(minute);
		}
		
		if(second >= 0 && second <= 9) {
			s = "0" + Integer.toString(second);
		} else if(second >= 10 && second <= 59) {
			s = Integer.toString(hour);
		}
		
		jtf_timeFields[0].setText(h);
		jtf_timeFields[1].setText(m);
		jtf_timeFields[2].setText(s);
		
	}
	
	public void setTime(String time) {
		Date date = new Date();
		if("".equals(time) || time == null) {
			setNull();
		} else {
			try {
				date = new SimpleDateFormat("HH:mm:ss").parse(time);
				setTime(date);
			} catch(Exception e) {
				setNull();
				System.out.println("置入时间格式不正确, 请按格式'HH:mm:ss'置入.");
			}
		}
	}
	
	//预置时间
	public void setTime(String hour, String minute, String second){
		
		try{
			if(Integer.parseInt(hour) >= 0 && Integer.parseInt(hour) <= 9) {
				if(hour.length() == 1)
					jtf_timeFields[0].setText("0" + hour);
				else if(hour.length() == 2)
					jtf_timeFields[0].setText(hour);
			} else if(Integer.parseInt(hour) >= 10 && Integer.parseInt(hour) <= 23) {
				if(hour.length() == 2)
					jtf_timeFields[0].setText(hour);
			}
			
			if(Integer.parseInt(minute) >= 0 && Integer.parseInt(minute) <= 9) {
				if(second.length() == 1)
					jtf_timeFields[1].setText("0" + minute);
				else if(second.length() == 2)
					jtf_timeFields[1].setText(minute);
			} else if(Integer.parseInt(minute) >= 10 && Integer.parseInt(minute) <= 59) {
				if(hour.length() == 2)
					jtf_timeFields[1].setText(minute);
			}
			
			if(Integer.parseInt(second) >= 0 && Integer.parseInt(second) <= 9) {
				if(second.length() == 1)
					jtf_timeFields[2].setText("0" + second);
				else if(second.length() == 2)
					jtf_timeFields[2].setText(second);
			} else if(Integer.parseInt(second) >= 10 && Integer.parseInt(second) <= 59) {
				if(second.length() == 2)
					jtf_timeFields[2].setText(second);
			}
		} catch(Exception e) {
			
		}
	}
	
	//置空，重置
	public void setNull(){
		
		String h = "", m = "", s = "";
		jtf_timeFields[0].setText(h);
		jtf_timeFields[1].setText(m);
		jtf_timeFields[2].setText(s);
		
	}

	
}
