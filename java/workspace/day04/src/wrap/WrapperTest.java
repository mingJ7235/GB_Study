package wrap;

public class WrapperTest {
	public static void main(String[] args) {
		//1, 5.6, 'a', "ABC", false
		//���� 5���� ���� �ϳ��� �迭�� �ְ� ����ϱ�
		
		//1.5�������ķδ� ���� �ڽ��� �Ǿ �ȰŴ�. 
		
		//���ۼ��� : ����ҵ��� �Ϲ� Ÿ���̴�.
		//������ Ŭ���� Ÿ�Կ� ���� ���ؼ���
		//Ŭ���� Ÿ������ ��ȯ�Ǿ�� �ϰ� auto boxing�� �ȴ�.
		//�� ��Ұ� Ŭ���� Ÿ������ ���� �� ��� Ŭ������ �θ��� ObjectŸ������
		//Up casting�Ǿ� ����. 
	
		Object [] arObj = {1, 5.6, 'a', "ABC", false};
		
		for (int i = 0; i < arObj.length; i++) {
			System.out.print(arObj[i] + " ");
		}
		
		
		
	}
}
