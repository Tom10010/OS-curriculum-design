package my_interface;

import javax.swing.JOptionPane;

public class Banker {
	//���弸������
	int[] Available = new int[3];
	int[][] Max = new int[5][3];
	int[][]Allocation = new int[5][3];
	int[][] Need = new int[5][4];  //����λΪ���λ��Ǹý����Ƿ񱻵���
	
	 //�����µ�����
	int[] NewAvailable = new int[3];
	int[][] NewMax = new int[5][3];
	int[][]NewAllocation = new int[5][3];
	int[][] NewNeed = new int[5][3];
	int[][] MaxAndAllocation = new int[5][3];
	
	//
	int[] sort = new int[5];
	Boolean[] finish = new Boolean[5];
	
	//��ʱ���Ժ���
	public void print(int[][] aaa, String bbb){
		for(int i = 0; i < 5; i++)
			for(int j = 0; j<3; j++)
			System.out.println(bbb + ":    " + aaa[i][j]);
	}
	
	public Banker(int[] Available, int[][] Max, int[][]Allocation, int[][] Need, int p){
		for(int i = 0; i < 5; i++)
			finish[i] = false;
		this.Available = Available;
		this.Max = Max;
		this.Allocation = Allocation;
		this.Need = Need;
		
		
		//���Դ��뿪ʼ
		for(int i = 0; i < 3; i++)
			System.out.println("Available:    " + Available[i]);
		
		/*
		print(Max, "Max");
		
		print(Allocation, "Allocation");
		
		print(Need, "Need");
		*/
//		for(int i = 0; i < 5; i++)
//			for(int j = 0; j < 3; j++)
//				System.out.println("Max:   "+Max[i][j]);
//		for(int i = 0; i < 5; i++)
//			for(int j = 0; j < 3; j++)
//				System.out.println("Allocation:    "+Allocation[i][j]);
//		for(int i = 0; i < 5; i++)
//			for(int j = 0; j < 3; j++)
//				System.out.println("Need:    "+Need[i][j]);
//		
//		
		for(int i = 0; i < 3; i++)
			System.out.println("Available:    " + Interface.Available[i]);
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 3; j++)
				System.out.println("Max:   "+Max[i][j]);
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 3; j++)
				System.out.println("Allocation:    "+Allocation[i][j]);
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 3; j++)
				System.out.println("Need:    "+Need[i][j]);
		
		int j = 0;
		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		for(int i = 0; i < 5; i++){
			if((Available[0] >= Need[i][0]) && (Available[1] >= Need[i][1]) && (Available[2] >= Need[i][2])){
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				sort[j] = i;   //��ȫ���м�¼����
				{   //������ֵ��������
					NewNeed[j][0] = Need[i][0];
					NewNeed[j][1] = Need[i][1];
					NewNeed[j][2] = Need[i][2];
					print(NewNeed, "Need");
					
					NewAllocation[j][0] = Allocation[i][0];
					NewAllocation[j][1] = Allocation[i][1];
					NewAllocation[j][2] = Allocation[i][2];
					print(NewAllocation, "Allocation");

				}
				MaxAndAllocation[j][0] = Available[0];
				MaxAndAllocation[j][1] = Available[1];
				MaxAndAllocation[j][2] = Available[2];
				print(MaxAndAllocation, "WorkAndAllocation");


				NewMax[j][0] = MaxAndAllocation[j][0];
				NewMax[j][1] = MaxAndAllocation[j][1];
				NewMax[j][2] = MaxAndAllocation[j][2];
				print(NewMax, "Max");

				MaxAndAllocation[j][0] = NewMax[j][0] + NewAllocation[j][0];
				MaxAndAllocation[j][1] = NewMax[j][1] + NewAllocation[j][1];
				MaxAndAllocation[j][2] = NewMax[j][2] + NewAllocation[j][2];
				print(MaxAndAllocation, "WorkAndAllocation");

				Available[0] = MaxAndAllocation[j][0];
				Available[1] = MaxAndAllocation[j][1];
				Available[2] = MaxAndAllocation[j][2];
				
				Need[i][0] = 999999;
				
				System.out.println("i:    "+i);
				System.out.println("Need�ı�Ǳ�����    " + Need[i][3]);
				i = 0;
				Need[i][3] = 1;
				finish[j] = true;
				j++;
				if(j == 5)
					break;
			}
		}
		for(int i = 0; i < 5; i++)
		{
			System.out.println(finish[i]);
		}
		if(p != 0){
			for(int i = 0; i < 5; i++){
				if(p == sort[i]){
					sort[0] = sort[i];
					sort[i] = 0;
				}
			}
		}
			if(finish[0] == false || finish[1] == false || finish[2] == false || finish[3] == false)
				JOptionPane.showMessageDialog(null, "������һ����ȫ���У�ϵͳ����ȫ��", "������ʾ��", JOptionPane.INFORMATION_MESSAGE);
		else{
			JOptionPane.showMessageDialog(null, "��������İ�ȫ����Ϊ��P" + sort[0] + " P" + sort[1] + " P" + sort[2] + " P" + sort[3] + " P" + sort[4] , "�ɹ���ʾ��", JOptionPane.INFORMATION_MESSAGE);

		}

	}

}
