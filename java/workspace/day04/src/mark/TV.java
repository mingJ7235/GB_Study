package mark;

public class TV {
	
	//�ִϸ��̼��� "�ִϸ��̼��Դϴ�"
	//�ִϸ��̼��� �ƴϸ� "�ִϸ��̼��� �ƴմϴ�"
	//��� println���� ����ϴ� �޼ҵ�
	void checkAni(Video [] arVideo) {
		String msg = null;
		for (int i = 0; i < arVideo.length; i++) {
			if(arVideo[i] instanceof Animation) {
				msg = arVideo[i] + "��(��) �ִϸ��̼� �Դϴ�. ";
			}else {
				msg = arVideo[i] + "��(��) �ִϸ��̼��� �ƴմϴ�.";
			}
		}
	}
	
	public static void main(String[] args) {
		
		Video[] arVideo = {
				new Zzangu(),
				new Titanic(),
				new Ddolbee(),
				new Dooly()
				
		};
		
		new TV().checkAni(arVideo);
	}
}
