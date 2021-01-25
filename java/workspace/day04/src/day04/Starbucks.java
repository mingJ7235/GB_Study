package day04;

import java.util.Random;

public class Starbucks {
	//�ű� ������ �޴���
	String [] arMenu;
	
	//�ű� ������ ����ǥ
	int [] arPrice;
	
	//�ű� ���� ����ϱ� 
	//Cafe�� �������̽� �̱� ������ �ܺο��� ���� ���� ��������
	//��� �߻�޼ҵ尡 ������ �Ǿ�� �Ѵ�.
	//�̸� �̿��Ͽ�, �ű� �����̶�� �ݵ�� Cafe�� ����� ��ɵ��� �����ؾ� �Ѵ�. 
	//�ܺο��� ����� ��� ������ �ʵ��� �ּҰ��� c��ü�� ���޵ǹǷ�, �ش� �ʵ忡 �����Ͽ�
	//������ �޼ҵ带 ������ش�. 
	public void register(Cafe c) {
		arMenu = c.getMenu();
		arPrice = c.getPrice();
		
		//���� ���� �κ��� �������� ���� �����̶�� ���� ���� ���� 
		if(arPrice == null) {
			System.out.println("���� ���� Ȯ�� �Ϸ�");
			return;
		}
		
		System.out.println("=======Ȯ����========");
		for (int i = 0; i < arMenu.length; i++) {
			System.out.println(arMenu[i] + " : " + arPrice[i]+"��");
			
		}
		System.out.println("�޴�/���� �̻� ����");
		try {
			c.sell(arMenu[new Random().nextInt(arMenu.length)]);
			System.out.println("�Ǹ� ��� �̻� ����");
		} catch (Exception e) {
			System.out.println("��� ����. ���翡 �������ּ���");
			return;
		}
		System.out.println("���� ��� �Ǿ����ϴ�. ");
	}
}
