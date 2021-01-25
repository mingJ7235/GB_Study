package day04;

import java.util.Scanner;

public class Road {
	Scanner sc = new Scanner(System.in);
	String choice = sc.next();
	
	public static void main(String[] args) {
		
		Starbucks kangnam = new Starbucks();
		System.out.println("<<<��������>>>");
		kangnam.register(new Cafe_adapter() {
			
			@Override
			public void sell(String menu) throws Exception {
				String [] arMenu = getMenu();
				boolean isOk = false;
				for (int i = 0; i < arMenu.length; i++) {
					if(arMenu[i].equals(menu)) {
						isOk = true;
					}
				}
				if (!isOk) {throw new Exception();}
			}
			
			@Override
			public int[] getPrice() {
				int [] arPrice = {3000, 5000, 8000};
				return arPrice;
			}
			
			@Override
			public String[] getMenu() {
				String [] arMenu = {"�Ƹ޸�ī��", "ī���", "�ݶ�"};
				return arMenu;
			}
		});
		
		Starbucks jamsil = new Starbucks();
		System.out.println("<<<��Ǹ���>>>");
		jamsil.register(new Cafe_adapter() {
			
			@Override
			public int[] getPrice() {
				int [] arPrice = {0,0};
				return arPrice;
			}
			
			@Override
			public String[] getMenu() {
				String [] arMenu = {"�����ֽ�", "�������ֽ�"};
				return arMenu;
			}
		});
		
		
	}
}
