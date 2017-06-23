package my_interface;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface extends JFrame{

	/**
	 * ���м��㷨��ʾ������ƽ���1
	 * date��2017.6.21
	 * author�� �ź���
	 */
	private static final long serialVersionUID = 1L;

	public static int[] Available = new int[3];
		
	private JLabel jl, jlA, jlB, jlC;  //����������ǩ
	public static JTextField SystemSoursesA, SystemSoursesB, SystemSoursesC;  // �������������
	private JButton cancel, ok;  //������ť
	private JPanel jp1, jp2, jp3;
	
	public Interface(){
		//��Դ�����ʼ��
		for(int i = 0; i<3; i++){
			Available[i] =0;
		}
		
		//��ʼ����ǩ��
		jl = new JLabel("��ʼ��ϵͳ��Դ");
		jlA = new JLabel("��ԴA��");
		jlB = new JLabel("��ԴB��");
		jlC = new JLabel("��ԴC��");
		
		//��ʼ����ť
		cancel = new JButton("ȡ��");
		ok = new JButton("ȷ��");
		
		//��ʼ�������
		SystemSoursesA = new JTextField(5);
		SystemSoursesB = new JTextField(5);
		SystemSoursesC = new JTextField(5);
		
		//��ʼ�����
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//ע�������
		cancel.addActionListener(new lis());
		ok.addActionListener(new lis());
	}
	
	//���ؽ���
	public void launchFrame() throws Exception{
		Container c = getContentPane();
		//��������Ԫ��
		jp1.add(jl);
		jp2.add(jlA);
		jp2.add(SystemSoursesA);
		jp2.add(jlB);
		jp2.add(SystemSoursesB);
		jp2.add(jlC);
		jp2.add(SystemSoursesC);
		jp3.add(cancel);
		jp3.add(ok);
		 
		//�������ӵ�����
		c.add(jp1, "North");
		c.add(jp2, "Center");
		c.add(jp3, "South");
		
		//��ʼ������
		setTitle("��ʾ����");
		setSize(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setResizable(false);
		setVisible(true);
	}
	class lis implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();  //���Դ
			if(source == cancel){
				System.exit(0);
			}
			else if(source == ok){
				
				//���Խ��������ַ���ת��Ϊ��������
				try{
					Interface.Available[0] = Integer.parseInt(SystemSoursesA.getText());
					Interface.Available[1] = Integer.parseInt(SystemSoursesB.getText());
					Interface.Available[2] = Integer.parseInt(SystemSoursesC.getText());
					setVisible(false);
					Interface02 Inte = new Interface02(Available);
					Inte.LaunchFrame();

				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "��������ָ�ʽ����ȷ�����������롣", "������ʾ��", JOptionPane.ERROR_MESSAGE);
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
