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
	 * ���м��㷨��ʾ�������2
	 * date:2017.6.21
	 * author: �ź���
	 */
	private static final long serialVersionUID = 1L;
	public static int[] Available = new int[3];
	public static int[][] Max = new int[5][3];
	public static int[][] Allocation = new int[5][3];
	public static int[][] Need = new int[5][4];
	public static int[] request = new int[3];  //���������Դ������
	//���弸����ǩ
	private JLabel JLMax, JLAllocation, JLNeed, JLAvailable, JLBlank1, JLBlank2;
	private JLabel JLsystemSource,JLrequest;
	
	//���弸�������
	private JTextField[] JTMaxSourceNum;
	private JTextField[] JTAllocationSourceNum;
	private JTextField[] JTNeedSourceNum;
	private JTextField[] JTRequestSourceNum;
	
	//���弸����ť
	private JButton[] JbP;
	private JButton T0Button;
	
	//���弸�����
	private JPanel jpEast, jpNorth, jpCenter, jpSouth, jp1, jp2, jp3, jp4; 
	
	public void LoopDefenition(){
		
	}
	public Interface02(int[] available2){
		//��ʼ�����
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
		//��ʼ�������Ϸ���Ԫ��
		JLMax = new JLabel("   Max");
		JLAllocation = new JLabel("       Allocation    ");
		JLNeed = new JLabel("               Need");
		JLAvailable = new JLabel("    Available");
		 
		//��ʼ��������ߵ�Ԫ��
		JbP = new JButton[5];
		for(int i = 0; i<5; i++){
			JbP[i] = new JButton("P" + i);
		}
		JLBlank1 = new JLabel("   ");
		JLBlank2 = new JLabel("   ");
		
		//��ʼ�������·���Ԫ��
		JLrequest = new JLabel("����д��Դ��������");
		T0Button = new JButton("T0ʱ�̵İ�ȫ��");
		JTRequestSourceNum = new JTextField[3];
		for(int i = 0; i < 3; i++){
			JTRequestSourceNum[i] = new JTextField(3);
		}
		
		//��ʼ�������м��Ԫ��
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
		
		//�������Ϸ���Ԫ����ӵ����
		GridLayout glNorth = new GridLayout(1, 4, 2, 2);
		jpNorth.setLayout(glNorth);
		jpNorth.add(JLBlank1);
		jpNorth.add(JLMax);
		jpNorth.add(JLAllocation);
		jpNorth.add(JLNeed);
		jpNorth.add(JLAvailable);
		
		//�������󷽵�Ԫ����ӵ����
		GridLayout glEast = new GridLayout(7, 1, 1, 1);
		jpEast.setLayout(glEast);
		for(int i = 0; i < 5; i++){
			jpEast.add(JbP[i]);
		}
		jpEast.add(JLBlank2);
		
		//�������·���Ԫ����ӵ����
		jpSouth.add(JLrequest);
		jpSouth.add(JTRequestSourceNum[0]);
		jpSouth.add(JTRequestSourceNum[1]);
		jpSouth.add(JTRequestSourceNum[2]);
		jpSouth.add(T0Button);
		/*��Ӽ�����*/
		T0Button.addActionListener(new lis());
		for(int i = 0; i < 5; i++){
			JbP[i].addActionListener(new lis());
		}
		
		//�������м��Ԫ����ӵ����
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
		//�������ӵ�����
		jpCenter.add(jp1);
		jpCenter.add(jp2);
		jpCenter.add(jp3);
		jpCenter.add(jp4);
		c.add(jpCenter,"Center");
		c.add(jpEast, "West");
		c.add(jpNorth, "North");
		c.add(jpSouth, "South");
		
		//��ʼ������
		setTitle("������Ӧ����Դ��Ŀ");
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
//						JOptionPane.showMessageDialog(null, "�����ڴ����·���д��Ӧ����Դ��������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
//					else
//					try{
//					for(int i = 0; i < 3; i++){
//						request[i] = Integer.parseInt(JTRequestSourceNum[i].getText());
//						}
//					/**������Ӧ�ĺ���*/
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
//						JOptionPane.showMessageDialog(null, "��������ָ�ʽ����ȷ�����������롣", "������ʾ��", JOptionPane.ERROR_MESSAGE);
//					}
				}
				else if(source == JbP[1]){
					//�õ�ԭʼ����
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//���ݴ���
					requestRepeat(1);

				}
				
				else if(source == JbP[2]){
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//���ݴ���
					requestRepeat(2);		
					
				}

				else if(source == JbP[3]){
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//���ݴ���
					requestRepeat(3);

				}

				else if(source == JbP[4]){
					getSourceNum();
					Available[0] = Integer.parseInt(Interface.SystemSoursesA.getText());
					Available[1] = Integer.parseInt(Interface.SystemSoursesB.getText());
					Available[2] = Integer.parseInt(Interface.SystemSoursesC.getText());
					
					//���ݴ���
					requestRepeat(4);			
					
				}

			}
			
			private void getSourceNum() {
				// TODO Auto-generated method stub
				int k = 0;
				try{					
					//���Դ�������л�ȡ����Ԫ��
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 3; j++){
						Max[i][j] = Integer.parseInt(JTMaxSourceNum[k].getText());
						k++;
						}
					}
					//���Դ�������л�ȡ����Ԫ��
					k = 0;
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 3; j++){
							Allocation[i][j] = Integer.parseInt(JTAllocationSourceNum[k].getText());
							k++;
						}
					}
					//���Դ�������л�ȡ����Ԫ��
					k = 0;
					for(int i = 0; i < 5; i++){
						for(int j = 0; j < 3; j++){
							Need[i][j] = Integer.parseInt(JTNeedSourceNum[k].getText());
							k++;
						}
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "��������ָ�ʽ����ȷ�����������롣", "������ʾ��", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			private void requestRepeat(int p) {
				// TODO Auto-generated method stub
				if(JTRequestSourceNum[0].getText() == null || JTRequestSourceNum[1].getText() == null || JTRequestSourceNum[2].getText() == null)
					JOptionPane.showMessageDialog(null, "�����ڴ����·���д��Ӧ����Դ��������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				else
				try{
				for(int i = 0; i < 3; i++){
					request[i] = Integer.parseInt(JTRequestSourceNum[i].getText());
					}
				/**������Ӧ�ĺ���*/
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
					JOptionPane.showMessageDialog(null, "�������"+p+"������Ϊ"+request[0]+" "+request[1]+" "+request[2]+"ʱϵͳ����ȫ��", "������ʾ��", JOptionPane.ERROR_MESSAGE);

				}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "��������ָ�ʽ����ȷ�����������롣", "������ʾ��", JOptionPane.ERROR_MESSAGE);
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
