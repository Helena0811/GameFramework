/*
 * 플레이어의 움직임 제어
 * GamePanel 전체에 키보드 적용해야 함!(리스너 연결)
 * */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	Player player;
	Bullet bullet;
	
	// 생성자를 이용해서 player 넘겨받기
	public KeyBoard(Player player) {
		this.player=player;
	}
	
	// 키보드를 누르고 있으면
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		// switch : 소괄호 안의 값에 대해 조건을 따져봄
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
				// 총알 생성
				// 총알 발사는 플레이어의 동작 -> 플레이어에 메소드 생성해서 동작 가능
				// objectManager 명단에 bullet이 저장되어 있으므로 이제 접근 가능
				player.fire();
				// Bullet bullet=new Bullet();	현재 Bullet은 접근 불가능
				break;
				
		}
	}
	
	// 키보드를 떼면
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		// switch : 소괄호 안의 값에 대해 조건을 따져봄
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
