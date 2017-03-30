/*
 * 총알 클래스
 * */
package game;

import java.awt.Color;
import java.awt.Graphics;
					/*Is a*/
public class Bullet extends GameObject{
	
	public Bullet(ObjectManager objectManager, int x, int y, int width, int height) {
		/*
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		*/
		// 위 코드는 부모인 GameObject에 정의되어 있으므로 부모 클래스 생성 시 인수를 넣어 넘겨받기!
		super(objectManager, x,y,width,height);
		
		// player보다 총알 속도가 빠르게 지정
		velX=4;
	}
	
	// 생성된 이후에 어떤 변화를 가져야 하는지 설정
	public void tick(){
		x+=velX;
	}
	
	// 총알 그리기
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}
}
