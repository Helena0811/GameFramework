/*
 * �Ѿ� Ŭ����
 *
 * �浹 �˻� - Rectangle boolean intersects(Rectangle r)
 * Rectangle(int x, int y, int width, int height)
 * -> tick()���� �� �μ� ������ ��� �����Ű�鼭 bullet�� ������ �� ���� ����ٴϸ� �浹 �˻� ����
 * */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
					/*Is a*/
public class Bullet extends GameObject{
	
	// ���⿡ �ξ ������, ������ ��� ��ü�� �浹 �׽�Ʈ�� �����Ϸ��� GameObject�� ��ġ��Ű��!
	// Rectangle rectangle=new Rectangle();
	public Bullet(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		/*
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		*/
		// �� �ڵ�� �θ��� GameObject�� ���ǵǾ� �����Ƿ� �θ� Ŭ���� ���� �� �μ��� �־� �Ѱܹޱ�!
		super(objectManager, id, x, y, width, height);
		
		// player���� �Ѿ� �ӵ��� ������ ����
		velX=4;
	}
	
	// ������ ���Ŀ� � ��ȭ�� ������ �ϴ��� ����
	// + �Ѿ��� �����̸鼭 ������ �浹�ߴ��� �˻�(���� �˻�)
	public void tick(){
		x+=velX;
		
		// �浹 �˻縦 ���� rect�� �׻� ����ٴ�
		rect.setBounds(x, y, width, height);
		
		// ������ ���� �����ϸ� �Ѵ� �ױ�!
		//if(rect.intersects(������ �簢��))
		for(int i=0; i<objectManager.list.size(); i++){
			// ���� objectManager�� ���� ��ü�� �����ֱ� ������ ������ ��󳻾� ��
			// �ذ�å : �� GameObject�� ���� ������ id���� ����� ����!
			GameObject obj=objectManager.list.get(i);
			
			if(obj.id==ObjectId.Enemy){
				// ������ rect�� �Ѿ�(��)�� rect�� �浹�ϸ�
				if(obj.rect.intersects(this.rect)){
					// ������ �Ѿ� ���ֱ�
					objectManager.list.remove(obj);		// ����
					objectManager.list.remove(this);	// ��(�Ѿ�)
				}
			}
		}
	}
	
	// �Ѿ� �׸���
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		/*
		g.fillOval(x, y, width, height);
		*/
		
		// ������ �簢���� ����ٴϸ鼭 �浹�˻� ����
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height);
	}
}
