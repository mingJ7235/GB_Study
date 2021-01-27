package snailFrame;

import java.util.Random;

public class Snail2 implements Runnable{
	Random r = new Random();

	@Override
	public void run() {
		for (int j = 0; j < 20; j++) {
			long time = r.nextInt(901) + 100;
			String text = "";
			text += "��" + "2�� ������";
			for (int l = 0; l < j; l++) {
				text += "  ";
			}
			text += "@_���ը�";
			for (int m = 0; m < 20 - j; m++) {
				text += ("  ");
			}
			text += "��";
			SnailMain.snail2.setText(text);
			SnailMain.sv.revalidate();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
			}
		}
	}
}
