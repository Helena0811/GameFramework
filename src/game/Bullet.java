/*
 * �Ѿ� Ŭ����
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
		// �� �ڵ�� �θ��� GameObject�� ���ǵǾ� �����Ƿ� �θ� Ŭ���� ���� �� �μ��� �־� �Ѱܹޱ�!
		super(objectManager, x,y,width,height);
		
		// player���� �Ѿ� �ӵ��� ������ ����
		velX=4;
	}
	
	// ������ ���Ŀ� � ��ȭ�� ������ �ϴ��� ����
	public void tick(){
		x+=velX;
	}
	
	// �Ѿ� �׸���
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}
}
