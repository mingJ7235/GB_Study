package day04;

//ī�並 ����� �� �ݵ�� �����ؾ��ϴ� �޼ҵ尡 ���庰�� �ٸ� �� �ִ�. 
//���� ���� ���� ī���� ��� getMenu�� �����ؾ� �ϰ�, �̸� ���� 
//��� �޼ҵ忡 �������� �����ش�. 

public abstract class Cafe_adapter implements Cafe{
	@Override
	public void sell(String menu) throws Exception {
	}
	
	@Override
	public String[] getMenu() {
		return null;
	}
	
	@Override
	public int[] getPrice() {
		return null;
	}
}
