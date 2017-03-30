/*
 * 이 클래스는 Sun사에서 자체 제작한 UI 컴포넌트가 아니기 떄문에,
 * 화면에 그려질 수 없다! -> JPanel에 그려지려면 JPanel의 Graphics의 레퍼런스(g)를 이 객체가 보유해야 함!
 * */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
					/*Is a*/
public class Player extends GameObject{

	// float g;	// 중력
	
	// 현재 Player는 클래스(거푸집)이므로, 사용자가 값을 정의할 수 있도록 생성자에서 값을 넘겨받자!
	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		/*
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		*/
		// 위 코드는 부모인 GameObject에 정의되어 있으므로 부모 클래스 생성 시 인수를 넣어 넘겨받기!
		super(objectManager, id, x, y, width, height);
		// 속도는 정해져 있음
		velX=0;
		velY=0;
	}
	
	// 총알 발사 메소드
	public void fire(){
		// player가 총알을 발사하려고 하면 총알을 생성한 후, 게임 등장 객체 명단인 objectManager에 저장하여
		// 접근 가능하도록 지정
		// 현재 objectManager는 GameObject의 멤버 변수
		Bullet bullet=new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);
		objectManager.addObject(bullet);
	}
	
	// x,y,width,height 등의 물리량 변화 제어	ex) 운동량 변화
	public void tick(){
		x+=velX;
		y+=velY;
		
		// 내가 재정의한 사각형의 좌표 설정(사각형이 나를 따라다니도록 값의 동기화)
		rect.setBounds(x, y, width, height);
		
		//System.out.println("tick");
	}
	
	// 변화된 값을 화면에 그리기
	public void render(Graphics g){
		// paint 색 바꾸기
		g.setColor(Color.WHITE);
		//g.drawRect(x, y, width, height);
		// Graphics에서 업그레이드 됨
		Graphics2D g2=(Graphics2D)g;
		
		// 전에 그렸던 그림은 단순한 그림이였기 때문에 충돌 테스트 불가, rect를 이용하여 사각형 객체로 비교
		// 나의 사각형 draw
		g2.draw(rect);
		// 현재 실행시키면 그려진 최초에 new한 사각형이라 키보드가 적용되지 않음
		// -> 키보드 값 또한 따라다녀야 함
		//System.out.println("render");
	}

}
