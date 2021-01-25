package exception;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		try {
//			System.out.println(10/0);
//		} catch (ArithmeticException e) {
////			System.out.println(e);
//			System.out.println("0���� ���� �� �����ϴ�.");
//		}
		
		//������ ������ �Է��� �� ������, 
		//5���� ������ �Է��ϴ� ���α׷�
		//q�� �Է��ϸ� ������ 
		
		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];
		
		int idx = 0;
		String temp = null;
		
		while(true) {
			
			System.out.println(++idx + "��° ���� �Է� [q: ������]");
			//����ڰ� �Է¹��� ���� �ӽ� ����ҿ� ��´�. 
			temp = sc.next();
			
			if(temp.equals("q")) {break;}
			
			try {
				//���ܰ� �߻��� �� �ִ� ������ �ۼ��Ѵ�. 
				arData[idx-1] = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				//temp�� q���ƴϰ� ������ �ƴ� ���� ������� �� ���� ����
				System.out.println("���� �Ǵ� \'q\'�� �Է����ּ���.");
				//idx�� ������Ų��. 
				idx --;
			} catch (ArrayIndexOutOfBoundsException e) {
				//�Է��� ������ 5���� �ʰ����� �� ������ ����
				System.out.println("�� �̻� ������ �Է��Ͻ� �� �����ϴ�. ");
				System.out.println(Arrays.toString(arData)); //�迭�� ��� ���� �����ִ�.
				//�� �̻��� �ݺ��� ���ǹ� �ϹǷ� �ٷ� �������ش�. 
				break;
			}
		}
		
		
		
		
		
		
		
		
	}
}
