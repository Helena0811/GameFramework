/*
 * 게임에 등장할 모든 객체들의 최상위 객체
 * 즉, 게임에 등장할 각 객체는 GameObject를 상속받는다!
 * -> 상속을 이용하면 코드 중복을 방지할 수 있고, 최상위 클래스 자료형으로 자식들을 가리킬 수 있으므로 코드가 유연해짐
 * */
package game;

import java.awt.Graphics;

abstract public class GameObject {
	// 부모가 가지고 있으면 자식은 언제든지 접근 가능
	// 각 객체가 현재 게임에 등장할 모든 객체의 명단인 objectManager을 접근할 수 있다면, 다른 모든 객체를 제한 없이 접근 가능
	ObjectManager objectManager;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	// 생성되는 모든 GameObject는 생성될 때 객체 명단인 objectManager를 넘겨받기!
	public GameObject(ObjectManager objectManager, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	// 게임에 출현할 각 객체들이 override할 수 있도록 추상 메소드화
	abstract public void tick();
	
	abstract public void render(Graphics g);
}
