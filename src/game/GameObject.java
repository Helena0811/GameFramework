/*
 * ���ӿ� ������ ��� ��ü���� �ֻ��� ��ü
 * ��, ���ӿ� ������ �� ��ü�� GameObject�� ��ӹ޴´�!
 * -> ����� �̿��ϸ� �ڵ� �ߺ��� ������ �� �ְ�, �ֻ��� Ŭ���� �ڷ������� �ڽĵ��� ����ų �� �����Ƿ� �ڵ尡 ��������
 * */
package game;

import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class GameObject {
	ObjectId id;	// ��� ���� ��ü�� �Ҵ�� id(�����ϱ� ����)
	
	// �θ� ������ ������ �ڽ��� �������� ���� ����
	// �� ��ü�� ���� ���ӿ� ������ ��� ��ü�� ����� objectManager�� ������ �� �ִٸ�, �ٸ� ��� ��ü�� ���� ���� ���� ����
	ObjectManager objectManager;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Rectangle rect;	// ���� �׽�Ʈ�� ����� �簢�� ��ü
	
	// �����Ǵ� ��� GameObject�� ������ �� ��ü ����� objectManager�� �Ѱܹޱ�!
	public GameObject(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.id=id;		// ��ü�� � �������� �����ϱ� ���� id
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		// Rectangle(int x, int y, int width, int height)
		// Rectangle Ŭ������ �޼ҵ� boolean	intersects(Rectangle r)�� �̿��Ͽ� �浹 �˻�
		rect=new Rectangle(x, y, width, height);
	}
	
	// ���ӿ� ������ �� ��ü���� override�� �� �ֵ��� �߻� �޼ҵ�ȭ
	abstract public void tick();
	
	abstract public void render(Graphics g);
}
