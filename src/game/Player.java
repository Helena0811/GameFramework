/*
 * 이 클래스는 Sun사에서 자체 제작한 UI 컴포넌트가 아니기 떄문에,
 * 화면에 그려질 수 없다! -> JPanel에 그려지려면 JPanel의 Graphics의 레퍼런스(g)를 이 객체가 보유해야 함!
 * */
package game;

import java.awt.Color;
import java.awt.Graphics;
					/*Is a*/
public class Player extends GameObject{

	// float g;	// 중력
	
	// 현재 Player는 클래스(거푸집)이므로, 사용자가 값을 정의할 수 있도록 생성자에서 값을 넘겨받자!
	public Player(ObjectManager objectManager, int x, int y, int width, int height) {
		/*
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		*/
		// 위 코드는 부모인 GameObject에 정의되어 있으므로 부모 클래스 생성 시 인수를 넣어 넘겨받기!
		super(objectManager, x,y,width,height);
		// 속도는 정해져 있음
		velX=0;
		velY=0;
	}
	
	// 총알 발사 메소드
	public void fire(){
		// player가 총알을 발사하려고 하면 총알을 생성한 후, 게임 등장 객체 명단인 objectManager에 저장하여
		// 접근 가능하도록 지정
		// 현재 objectManager는 GameObject의 멤버 변수
		Bullet bullet=new Bullet(objectManager, x, y, 10, 10);
		objectManager.addObject(bullet);
	}
	
	// x,y,width,height 등의 물리량 변화 제어	ex) 운동량 변화
	public void tick(){
		x+=velX;
		y+=velY;
		//System.out.println("tick");
	}
	
	// 변화된 값을 화면에 그리기
	public void render(Graphics g){
		// paint 색 바꾸기
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
		//System.out.println("render");
	}

}
