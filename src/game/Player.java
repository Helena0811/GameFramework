/*
 * �� Ŭ������ Sun�翡�� ��ü ������ UI ������Ʈ�� �ƴϱ� ������,
 * ȭ�鿡 �׷��� �� ����! -> JPanel�� �׷������� JPanel�� Graphics�� ���۷���(g)�� �� ��ü�� �����ؾ� ��!
 * */
package game;

import java.awt.Color;
import java.awt.Graphics;
					/*Is a*/
public class Player extends GameObject{

	// float g;	// �߷�
	
	// ���� Player�� Ŭ����(��Ǫ��)�̹Ƿ�, ����ڰ� ���� ������ �� �ֵ��� �����ڿ��� ���� �Ѱܹ���!
	public Player(ObjectManager objectManager, int x, int y, int width, int height) {
		/*
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		*/
		// �� �ڵ�� �θ��� GameObject�� ���ǵǾ� �����Ƿ� �θ� Ŭ���� ���� �� �μ��� �־� �Ѱܹޱ�!
		super(objectManager, x,y,width,height);
		// �ӵ��� ������ ����
		velX=0;
		velY=0;
	}
	
	// �Ѿ� �߻� �޼ҵ�
	public void fire(){
		// player�� �Ѿ��� �߻��Ϸ��� �ϸ� �Ѿ��� ������ ��, ���� ���� ��ü ����� objectManager�� �����Ͽ�
		// ���� �����ϵ��� ����
		// ���� objectManager�� GameObject�� ��� ����
		Bullet bullet=new Bullet(objectManager, x, y, 10, 10);
		objectManager.addObject(bullet);
	}
	
	// x,y,width,height ���� ������ ��ȭ ����	ex) ��� ��ȭ
	public void tick(){
		x+=velX;
		y+=velY;
		//System.out.println("tick");
	}
	
	// ��ȭ�� ���� ȭ�鿡 �׸���
	public void render(Graphics g){
		// paint �� �ٲٱ�
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
		//System.out.println("render");
	}

}
