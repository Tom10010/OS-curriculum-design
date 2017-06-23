package my_interface;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface02 extends JFrame{

	/**
	 * 银行家算法演示程序界面2
	 * date:2017.6.21
	 * author: 张洪涛
	 */
	private static final long serialVersionUID = 1L;
	public static int[] Available = new int[3];
	public static int[][] Max = new int[5][3];
	public static int[][] Allocation = new int[5][3];
	public static int[][] Need = new int[5][4];
	public static int[] request = new int[3];  //存放请求资源量数组
	//定义几个标签
	private JLabel JLMax, JLAllocation, JLNeed, JLAvailable, JLBlank1, JLBlank2;
	private JLabel JLsystemSource,JLrequest;
	
	//定义几个输入框
	private JTextField[] JTMaxSourceNum;
	private JTextField[] JTAllocationSourceNum;
	private JTextField[] JTNeedSourceNum;
	private JTextField[] JTRequestSourceNum;
	
	//定义几个按钮
	private JButton[] JbP;
	private JButton T0Button;
	
	//定义几个面板
	private JPanel jpEast, jpNorth, jpCenter, jpSouth, jp1, jp2, jp3, jp4; 
	
	public void LoopDefenition(){
		
	}
	public Interface02(int[] available2){
		//初始化面板
		this.Available = available2;
		
		for(int i = 0; i < 5; i++){
			Need[i][3] = 0;
		}
		
		jpSouth = new JPanel();
		jpNorth = new JPanel();
		jpCenter = new JPanel();
		jpEast = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		//初始化界面上方的元素
		JLMax = new JLabel("   Max");
		JLAllocation = new JLabel("       Allocation    ");
		JLNeed = new JLabel("               Need");
		JLAvailable = new JLabel("    Available");
		 
		//初始化界面左边的元素
		JbP = new JButton[5];
		for(int i = 0; i<5; i++){
			JbP[i] = new JButton("P" + i);
		}
		JLBlank1 = new JLabel("   ");
		JLBlank2 = new JLabel("   ");
		
		//初始化界面下方的元素
		JLrequest = new JLabel("请填写资源请求量：");
		T0Button = new JButton("T0时刻的安全性");
		JTRequestSourceNum = new JTextField[3];
		for(int i = 0; i < 3; i++){
			JTRequestSourceNum[i] = new JTextField(3);
		}
		
		//初始化界面中间的元素
		JTMaxSourceNum = new JTextField[15];
		JTAllocationSourceNum = new JTextField[15];
		JTNeedSourceNum = new JTextField[15];
		for(int i = 0; i < 15; i++){
			JTMaxSourceNum[i] = new JTextField(4);
			JTAllocationSourceNum[i] = new JTextField(4);
			JTNeedSourceNum[i] = new JTextField(4);
		} 
		JLsystemSource = new JLabel("     " + Available[0] + "     " + Available[1] + "      " + Available[2]);
	}
	public void LaunchFrame() throws Exception{
		Container c = getContentPane();
		
		//将界面上方的元素添加到面板
		GridLayout glNorth = new GridLayout(1, 4, 2, 2);
		jpNorth.setLayout(glNorth);
		jpNorth.add(JLBlank1);
		jpNorth.add(JLMax);
		jpNorth.add(JLAllocation);
		jpNorth.add(JLNeed);
		jpNorth.add(JLAvailable);
		
		//将界面左方的元素添加到面板
		GridLayout glEast = new GridLayout(7, 1, 1, 1);
		jpEast.setLayout(glEast);
		for(int i = 0; i < 5; i++){
			jpEast.add(JbP[i]);
		}
		jpEast.add(JLBlank2);
		
		//将界面下方的元素添加到面板
		jpSouth.add(JLrequest);
		jpSouth.add(JTRequestSourceNum[0]);
		jpSouth.add(JTRequestSourceNum[1]);
		jpSouth.add(JTRequestSourceNum[2]);
		jpSouth.add(T0Button);
		/*添加监听器*/
		T0Button.addActionListener(new lis());
		for(int i = 0; i < 5; i++){
			JbP[i].addActionListener(new lis());
		}
		
		//将界面中间的元素添加到面板
		GridLayout gl1 = new GridLayout(5, 3, 1, 1);
		jp1.setLayout(gl1);
		jp2.setLayout(gl1);
		jp3.setLayout(gl1);
		for(int i = 0; i < 15; i++){
			jp1.add(JTMaxSourceNum[i]);
			jp2.add(JTAllocationSourceNum[i]);
			jp3.add(JTNeedSourceNum[i]);
		}
		jp4.add(JLsystemSource);
		//将面板添加到窗口
		jpCenter.add(jp1);
		jpCenter.add(jp2);
		jpCenter.add(jp3);
		jpCenter.add(jp4);
		c.add(jpCenter,"Center");
		c.add(jpEast, "West");
		c.add(jpNorth, "North");
		c.add(jpSouth, "South");
		
		//初始化窗口
		setTitle("填入相应的资源数目");
		setSize(700,270);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setVisible(true);
		
		}
	
		class lis implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == T0Button){
					getSourceNum();
					Banker banker = new Banker(Available, Max, Allocation, Need, 0);
				}
				else if(source == JbP[0]){
//					if(JTRequestSourceNum[0].getText() == null || JTRequestSourceNum[1].getText() == null || JTRequestSourceNum[2].getText() == null)
//						JOptionPane.showMessageDialog(null, "请先在窗口下方填写相应的资源请求量。", "提示！", JOptionPane.ERROR_MESSAGE);
//					else
//					try{
//					for(int i = 0; i < 3; i++){
//						request[i] = Integer.parseInt(JTRequestSourceNum[i].getText());
//						}
//					/**调用相应的函数*/
//					if((request[0] <= Need[0][0]) && (request[1] <= Need[0][1]) && (request[2] <= Need[0][2])){
//						if(request[0] <= Available[0] && request[1] <= Available[1] && request[2] <= Available[2]){
					getSourceNum();
					for(int i = 0; i < 3; i++){
						Available[0] = Interface.Available[0];
						Available[1] = Interface.Available[2];
						Available[2] = Interface.Available[2];
					}
					for(int i = 0; i < 3; i++)
						System.out.println("Available:    " + Available[i]);
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 3; j++)
							System.out.println("Max:   "+Max[i][j]);
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 3; j++)
							System.out.println("Allocation:    "+Allocation[i][j]);
					for(int i = 0; i < 5; i++)
						for(int j = 0; j < 3; j++)
							System.out.println("Need:    "+Need[i][j]);
					requestRepeat(0);
							//Banker Bank = new Banker();
//						}
//					}
//					}
//					catch(Exception ex){
//						JOptionPane.showMessageDialog(null, "输入的数字格式不正确，请重新输入。", "错误提示！", JOptionPane.ERROR_MESSAGE);
//					}
				}
				else if(source == JbP[1]){
					//得到原始数据
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//数据处理
					requestRepeat(1);

				}
				
				else if(source == JbP[2]){
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//数据处理
					requestRepeat(2);		
					
				}

				else if(source == JbP[3]){
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//数据处理
					requestRepeat(3);

				}

				else if(source == JbP[4]){
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//数据处理
					requestRepeat(4);			
					
				}

			}
			
			private void getSourceNum() {
				// TODO Auto-generated method stub
				int k = 0;
				try{					
					//尝试从输入框中获取数组元素
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 3; j++){
						Max[i][j] = Integer.parseInt(JTMaxSourceNum[k].getText());
						k++;
						}
					}
					//尝试从输入框中获取数组元素
					k = 0;
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 3; j++){
							Allocation[i][j] = Integer.parseInt(JTAllocationSourceNum[k].getText());
							k++;
						}
					}
					//尝试从输入框中获取数组元素
					k = 0;
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 3; j++){
							Need[i][j] = Integer.parseInt(JTNeedSourceNum[k].getText());
							k++;
						}
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "输入的数字格式不正确，请重新输入。", "错误提示！", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			private void requestRepeat(int p) {
				// TODO Auto-generated method stub
				if(JTRequestSourceNum[0].getText() == null || JTRequestSourceNum[1].getText() == null || JTRequestSourceNum[2].getText() == null)
					JOptionPane.showMessageDialog(null, "请先在窗口下方填写相应的资源请求量。", "提示！", JOptionPane.ERROR_MESSAGE);
				else
				try{
				for(int i = 0; i < 3; i++){
					request[i] = Integer.parseInt(JTRequestSourceNum[i].getText());
					}
				/**调用相应的函数*/
				if((request[0] <= Need[p][0]) && (request[1] <= Need[p][1]) && (request[2] <= Need[p][2]) && (request[0] <= Available[0]) && (request[1] <= Available[1]) && (request[2] <= Available[2])){
						int temp = 0;
						temp = Max[p][0];
						Max[p][0] = Max[0][0];
						Max[0][0] = temp;
						
						temp = Max[p][1];
						Max[p][1] = Max[0][1];
						Max[0][1] = temp;
						
						temp = Max[p][2];
						Max[p][2] = Max[0][2];
						Max[0][2] = temp;
						
						temp = Allocation[p][0] + request[0];
						Allocation[p][0] = Allocation[0][0];
						Allocation[0][0] = temp;
						
						temp = Allocation[p][1] + request[1] ;
						Allocation[p][1] = Allocation[0][1];
						Allocation[0][1] = temp;
						
						temp = Allocation[p][2] + request[2];
						Allocation[p][2] = Allocation[0][2];
						Allocation[0][2] = temp;
						
						temp = Need[p][0] - request[0];
						Need[p][0] = Need[0][0];
						Need[0][0] = temp;
						
						temp = Need[p][1] - request[1] ;
						Need[p][1] = Need[0][1];
						Need[0][1] = temp;
						
						temp =Need[p][2] - request[2];
						Need[p][2] = Need[0][2];
						Need[0][2] = temp;
						
						Available[0] = Available[0] - request[0];
						Available[1] = Available[1] - request[1];
						Available[2] = Available[2] - request[2];	
						Banker banker = new Banker(Available, Max, Allocation, Need, p);
					}
				else{
					JOptionPane.showMessageDialog(null, "如果进程"+p+"请求量为"+request[0]+" "+request[1]+" "+request[2]+"时系统不安全！", "错误提示！", JOptionPane.ERROR_MESSAGE);

				}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "输入的数字格式不正确，请重新输入。", "错误提示！", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Interface02 inte = new Interface02();
		//System.out.println(Interface.Available[1]);
		//inte.LaunchFrame();
	}

}
