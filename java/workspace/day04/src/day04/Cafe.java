package day04;

//����ڰ� � ����� ������ �� �� �� �����Ƿ�
//�ݵ�� �����ؾ� �ϴ� Ʋ�� �����Ͽ� �������ش�.(������ �ο�)

public interface Cafe {
	//�޴�
	String [] getMenu ();
	//����
	int [] getPrice();
	//�ǸŹ��
	void sell (String menu) throws Exception;
}
