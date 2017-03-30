package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends GameObject{

	// Java���� ����Ŭ������ ���� ����
	Random r=new Random();
	
	// random �Լ� ����
	int max=GamePanel.WIDTH*GamePanel.SCALE-50;
	int min=50;
	
	public Enemy(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
		velX=-4;	// ������ ������ �ٰ�������
	}

	public void tick() {
		x+=velX;
		// ȭ�� ���� ���� �����ϸ� �ٽ� �������� ����, ������ y�� ��ġ
		if(x<0){
			y=r.nextInt(max-min+1)+min;
			x=GamePanel.WIDTH*GamePanel.SCALE;
		}
		// �浹 �˻縦 ���� rect�� �׻� ����ٴ�
		rect.setBounds(x,y,width,height);
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		
		// Graphics 			vs 	Graphics2D
		// �ܼ��� ĵ������ �׸��� �׷���		ĵ������ �׸��� �׸���, ��ü ������ �Բ� ����
		// ���� �浹 �׽�Ʈ �� ��ü �׸���(rect)
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect);
		
		// ���� �׷ȴ� �׸��� �ܼ��� �׸��̿��� ������ �浹 �׽�Ʈ �Ұ�, rect�� �̿��Ͽ� �簢�� ��ü�� ��
	}
	
}
