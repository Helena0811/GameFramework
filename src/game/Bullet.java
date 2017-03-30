/*
 * 총알 클래스
 *
 * 충돌 검사 - Rectangle boolean intersects(Rectangle r)
 * Rectangle(int x, int y, int width, int height)
 * -> tick()에서 위 인수 값들을 계속 적용시키면서 bullet이 움직일 때 같이 따라다니면 충돌 검사 가능
 * */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
					/*Is a*/
public class Bullet extends GameObject{
	
	// 여기에 두어도 되지만, 어차피 모든 객체간 충돌 테스트가 가능하려면 GameObject에 위치시키기!
	// Rectangle rectangle=new Rectangle();
	public Bullet(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		/*
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		*/
		// 위 코드는 부모인 GameObject에 정의되어 있으므로 부모 클래스 생성 시 인수를 넣어 넘겨받기!
		super(objectManager, id, x, y, width, height);
		
		// player보다 총알 속도가 빠르게 지정
		velX=4;
	}
	
	// 생성된 이후에 어떤 변화를 가져야 하는지 설정
	// + 총알이 움직이면서 적군과 충돌했는지 검사(교차 검사)
	public void tick(){
		x+=velX;
		
		// 충돌 검사를 위한 rect는 항상 따라다님
		rect.setBounds(x, y, width, height);
		
		// 적군과 내가 교차하면 둘다 죽기!
		//if(rect.intersects(적군의 사각형))
		for(int i=0; i<objectManager.list.size(); i++){
			// 현재 objectManager에 여러 객체가 섞여있기 때문에 적군만 골라내야 함
			// 해결책 : 각 GameObject에 구분 가능한 id값을 상수로 두자!
			GameObject obj=objectManager.list.get(i);
			
			if(obj.id==ObjectId.Enemy){
				// 적군의 rect와 총알(나)의 rect가 충돌하면
				if(obj.rect.intersects(this.rect)){
					// 적군과 총알 없애기
					objectManager.list.remove(obj);		// 적군
					objectManager.list.remove(this);	// 나(총알)
				}
			}
		}
	}
	
	// 총알 그리기
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		/*
		g.fillOval(x, y, width, height);
		*/
		
		// 어차피 사각형은 따라다니면서 충돌검사 해줌
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height);
	}
}
