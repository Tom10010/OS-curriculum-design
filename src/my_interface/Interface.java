package my_interface;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface extends JFrame{

	/**
	 * 银行家算法演示程序设计界面1
	 * date：2017.6.21
	 * author： 张洪涛
	 */
	private static final long serialVersionUID = 1L;

	public static int[] Available = new int[3];
		
	private JLabel jl, jlA, jlB, jlC;  //创建几个标签
	public static JTextField SystemSoursesA, SystemSoursesB, SystemSoursesC;  // 创建几个输入框
	private JButton cancel, ok;  //创建按钮
	private JPanel jp1, jp2, jp3;
	
	public Interface(){
		//资源数组初始化
		for(int i = 0; i<3; i++){
			Available[i] =0;
		}
		
		//初始化标签。
		jl = new JLabel("初始化系统资源");
		jlA = new JLabel("资源A：");
		jlB = new JLabel("资源B：");
		jlC = new JLabel("资源C：");
		
		//初始化按钮
		cancel = new JButton("取消");
		ok = new JButton("确定");
		
		//初始化输入框
		SystemSoursesA = new JTextField(5);
		SystemSoursesB = new JTextField(5);
		SystemSoursesC = new JTextField(5);
		
		//初始化面板
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//注册监听器
		cancel.addActionListener(new lis());
		ok.addActionListener(new lis());
	}
	
	//加载界面
	public void launchFrame() throws Exception{
		Container c = getContentPane();
		//向面板添加元素
		jp1.add(jl);
		jp2.add(jlA);
		jp2.add(SystemSoursesA);
		jp2.add(jlB);
		jp2.add(SystemSoursesB);
		jp2.add(jlC);
		jp2.add(SystemSoursesC);
		jp3.add(cancel);
		jp3.add(ok);
		 
		//将面板添加到窗口
		c.add(jp1, "North");
		c.add(jp2, "Center");
		c.add(jp3, "South");
		
		//初始化窗口
		setTitle("演示程序");
		setSize(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setResizable(false);
		setVisible(true);
	}
	class lis implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();  //获得源
			if(source == cancel){
				System.exit(0);
			}
			else if(source == ok){
				
				//尝试将输入框的字符串转化为整形数据
				try{
					Interface.Available[0] = Integer.parseInt(SystemSoursesA.getText());
					Interface.Available[1] = Integer.parseInt(SystemSoursesB.getText());
					Interface.Available[2] = Integer.parseInt(SystemSoursesC.getText());
					setVisible(false);
					Interface02 Inte = new Interface02(Available);
					Inte.LaunchFrame();

				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "输入的数字格式不正确，请重新输入。", "错误提示！", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Interface inte = new Interface();
		inte.launchFrame();
	}

}
