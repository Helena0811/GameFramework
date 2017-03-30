package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends GameObject{

	// Java에는 랜덤클래스가 따로 있음
	Random r=new Random();
	
	// random 함수 범위
	int max=GamePanel.WIDTH*GamePanel.SCALE-50;
	int min=50;
	
	public Enemy(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
		velX=-4;	// 적군이 나에게 다가오도록
	}

	public void tick() {
		x+=velX;
		// 화면 좌측 끝에 도달하면 다시 우측부터 시작, 랜덤한 y축 위치
		if(x<0){
			y=r.nextInt(max-min+1)+min;
			x=GamePanel.WIDTH*GamePanel.SCALE;
		}
		// 충돌 검사를 위한 rect는 항상 따라다님
		rect.setBounds(x,y,width,height);
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		
		// Graphics 			vs 	Graphics2D
		// 단순히 캔버스에 그림만 그려줌		캔버스에 그림도 그리고, 객체 생성도 함께 수행
		// 실제 충돌 테스트 할 객체 그리기(rect)
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect);
		
		// 전에 그렸던 그림은 단순한 그림이였기 때문에 충돌 테스트 불가, rect를 이용하여 사각형 객체로 비교
	}
	
}
