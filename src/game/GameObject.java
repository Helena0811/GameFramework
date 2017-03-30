/*
 * ���ӿ� ������ ��� ��ü���� �ֻ��� ��ü
 * ��, ���ӿ� ������ �� ��ü�� GameObject�� ��ӹ޴´�!
 * -> ����� �̿��ϸ� �ڵ� �ߺ��� ������ �� �ְ�, �ֻ��� Ŭ���� �ڷ������� �ڽĵ��� ����ų �� �����Ƿ� �ڵ尡 ��������
 * */
package game;

import java.awt.Graphics;

abstract public class GameObject {
	// �θ� ������ ������ �ڽ��� �������� ���� ����
	// �� ��ü�� ���� ���ӿ� ������ ��� ��ü�� ����� objectManager�� ������ �� �ִٸ�, �ٸ� ��� ��ü�� ���� ���� ���� ����
	ObjectManager objectManager;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	// �����Ǵ� ��� GameObject�� ������ �� ��ü ����� objectManager�� �Ѱܹޱ�!
	public GameObject(ObjectManager objectManager, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	// ���ӿ� ������ �� ��ü���� override�� �� �ֵ��� �߻� �޼ҵ�ȭ
	abstract public void tick();
	
	abstract public void render(Graphics g);
}
