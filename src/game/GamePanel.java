/*
 * ��� ������ �� �г� �ȿ��� �׷��� ����!
 * �ƹ��� ������ ����� �پ��ϴ���, �г��� ���� 1���� ����!
 * 
 * ��� Object�� �ᱸ ���� �гο� �׷����� �ϹǷ�, �� �г��� paint �޼ҵ��� �μ��� ���޵Ǵ� Graphics ��ü��
 * ���ӿ� ������ ��� Object�� �����ؾ� ��(���޹޾ƾ� ��)!
 * */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

// ����) Panel�� ���� �� ũ�⸦ ������ ���� ����!
// GamePanel = ���� ���� ����
public class GamePanel extends JPanel implements Runnable{	// Runnable!=������, run()�� ������ �ִ� �������̽�
	// ��� ����
	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	// ���� �ٸ� ȭ�� ũ�⿡ ���� SCALE�� user�� ��翡 ���� �ٸ��� �� �� �ֵ���
	public static final int SCALE=2;
	
	// ������ ������ ������ ����(� ������)
	Thread thread; 
	
	// ���� ���� ���θ� �����ϴ� ����
	boolean flag=true;
	
	Player player;
	
	// ��ü ��� ������
	// ��ܿ� ����Ǿ��ִٸ� ������ ���X
	ObjectManager objectManager;
		
	public GamePanel() {
		// paint()���� ���� ������ ���� �� ����
		thread=new Thread(this);
		thread.start();
		init();
		
		// ũ�� ����
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		// �ȸ���
		//setBackground(Color.BLACK);
		
		// Ű���� �̺�Ʈ�� ��ü�� �г�
		// �гΰ� Ű���� �̺�Ʈ ������ ����
		this.addKeyListener(new KeyBoard(player));
		// �ٷ� �����Ű�� Ű���尡 �۵����� �ʴµ�, �̴� �����ϸ� focus�� Window�� �ֱ� ����!
		// -> focus�� �гη� �Űܾ� Ű���� �۵� ����
	}
	
	// ���� ����(�ʱ�ȭ)
	public void init(){
		// �����ͺ��̽�(��� ������)�� ������ ���۵� �� ���� ����
		objectManager=new ObjectManager();
		
		// ������ ���ӿ� ������ ��ü���� ������ ���� �ϱ� ���� ������ ���ÿ� objectManager�� �����Ű��!
		// player �����Ű��(����)
		player=new Player(objectManager, 100, 200, 50, 50);
		
		// ��ܿ� player �߰�
		objectManager.addObject(player);
	}
	
	// �г��� �׸��� ����
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//player.render(g);	// Graphics g�� �ִ� ������ player�� g�� �ѱ��
	
		// ObjectManager�� ����� ��� ��ü���� ������Ű��
		// objectManager�� ����Ǿ� �ִ� ��� ���ӿ� ������ ��ü���� render ȣ��
		for(int i=0; i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
		}
	}
	
	// ������ �����(������ ����Ǵ� ���� ������ ��ӵǾ�� ��)
	// ���ӿ� ������ ��� object�� tick, render�� ȣ���ؾ� ��
	// -> ����, panel�� ������ object ����� �˾ƾ� ��(Object manager)
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("���� ������!");
			
			// objectManager�� ��ϵ� ��� ��ü�Y ������� tick ȣ��
			/*
			 * ObjectManager list�� generic type�� �ֻ��� ��ü�� object�� ���������Ƿ� �� �� �ִ� ����� ���ѵǾ� ����
			 * -> Player, Bullet ���� ������ ��ü�� �θ� ��ü�� ����� ��ӹް�, generic type���� �θ� ��ü�� ������ ��!
			for(int i=0; i<objectManager.list.size(); i++){
				Object obj=objectManager.list.get(i);
			}
			*/
			
			// objectManager�� ����Ǿ� �ִ� ��� ���ӿ� ������ ��ü���� tick ȣ��
			for(int i=0; i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			// player.render();	�Ұ��� -> g�� ���� ���� �����Ƿ� �Ұ���
			
			// paint Component�� ���� ȣ��
			repaint();	// paint()�޼ҵ�� repaint()�� ȣ��Ǿ�� ���� ����
			
		}
		
	}
}
