package day04;

import java.util.Random;

public class Starbucks {
	//�޴��� �ޱ� 
	
	String [] arMenu;
	int [] arPrice;
	
	
	public void register(Cafe c) {
		arMenu = c.getMenu();
		arPrice = c.getPrice();
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
