package day04;

public interface Cafe {
	//�޴�
	String [] getMenu ();
	//����
	int [] getPrice();
	//�ǸŹ��
	void sell (String menu) throws Exception;
}
