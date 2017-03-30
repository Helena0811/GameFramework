/*
 * �÷��̾��� ������ ����
 * GamePanel ��ü�� Ű���� �����ؾ� ��!(������ ����)
 * */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	Player player;
	Bullet bullet;
	
	// �����ڸ� �̿��ؼ� player �Ѱܹޱ�
	public KeyBoard(Player player) {
		this.player=player;
	}
	
	// Ű���带 ������ ������
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		// switch : �Ұ�ȣ ���� ���� ���� ������ ������
		switch(key){
			case KeyEvent.VK_LEFT:
				player.velX=-2;
				break;
			case KeyEvent.VK_RIGHT:
				player.velX=2;
				break;
			
			case KeyEvent.VK_UP:
				player.velY=-2;
				break;
				
			case KeyEvent.VK_DOWN:
				player.velY=2;
				break;
				
			case KeyEvent.VK_SPACE:
				// �Ѿ� ����
				// �Ѿ� �߻�� �÷��̾��� ���� -> �÷��̾ �޼ҵ� �����ؼ� ���� ����
				// objectManager ��ܿ� bullet�� ����Ǿ� �����Ƿ� ���� ���� ����
				player.fire();
				// Bullet bullet=new Bullet();	���� Bullet�� ���� �Ұ���
				break;
				
		}
	}
	
	// Ű���带 ����
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		// switch : �Ұ�ȣ ���� ���� ���� ������ ������
		switch(key){
			case KeyEvent.VK_LEFT:
				player.velX=0;
				break;
			case KeyEvent.VK_RIGHT:
				player.velX=0;
				break;
			
			case KeyEvent.VK_UP:
				player.velY=0;
				break;
				
			case KeyEvent.VK_DOWN:
				player.velY=0;
				break;
				
		}
	}
}
