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
	public int[][] Max = new int[5][3];
	public int[][] Allocation = new int[5][3];
	public int[][] Need = new int[5][3];
	public int[] request = new int[3];
	//���弸����ǩ
	private JLabel JLMax, JLAllocation, JLNeed, JLAvailable, JLBlank1, JLBlank2;
	private JLabel[] JLP;
	private JLabel JLsystemSource;
	
	//���弸�������
	private JTextField[] JTMaxSourceNum;
	private JTextField[] JTAllocationSourceNum;
	private JTextField[] JTNeedSourceNum;
	private JTextField[] JTRequestSourceNum;
	
	//���弸����ť
	private JButton T0Button, RequestButton;
	
	//���弸�����
	private JPanel jpEast, jpNorth, jpCenter, jpSouth, jp1, jp2, jp3, jp4; 
	
	public void LoopDefenition(){
		
	}
	public Interface02(int[] available2){
		//��ʼ�����
		this.Available = available2;
		
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
		JLP = new JLabel[5];
		for(int i = 0; i<5; i++){
			JLP[i] = new JLabel("  P" + i);
		}
		JLBlank1 = new JLabel("   ");
		JLBlank2 = new JLabel("   ");
		
		//��ʼ�������·���Ԫ��
		T0Button = new JButton("T0ʱ�̵İ�ȫ��");
		RequestButton = new JButton("request");
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
			jpEast.add(JLP[i]);
		}
		jpEast.add(JLBlank2);
		
		//�������·���Ԫ����ӵ����
		jpSouth.add(T0Button);
		jpSouth.add(JTRequestSourceNum[0]);
		jpSouth.add(JTRequestSourceNum[1]);
		jpSouth.add(JTRequestSourceNum[2]);
		jpSouth.add(RequestButton);
		/*��Ӽ�����*/
		T0Button.addActionListener(new lis());
		RequestButton.addActionListener(new lis());
		
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
		setTitle("��ʾ����");
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
					int k = 0;
						try{
							
							//���Դ�������л�ȡ����Ԫ��
							for(int i = 0; i < 5; i++){
								for(int j = 0; j < 3; j++){
								Max[i][j] = Integer.parseInt(JTMaxSourceNum[k].getText());
								k++;
							}
						}
						k = 0;
						//���Դ�������л�ȡ����Ԫ��
						for(int i = 0; i < 5; i++){
							for(int j = 0; j < 3; j++){
								Allocation[i][j] = Integer.parseInt(JTAllocationSourceNum[k].getText());
								k++;
							}
						}
						k = 0;
						//���Դ�������л�ȡ����Ԫ��
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
					
					/*������Ӧ�ĺ���*/
				}
				else if(source == RequestButton){
					for(int i = 0; i < 3; i++){
						request[i] = Integer.parseInt(JTRequestSourceNum[i].getText());
					}
					/*������Ӧ�ĺ���*/
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
