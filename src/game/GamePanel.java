/*
 * 모든 게임은 이 패널 안에서 그려질 예정!
 * 아무리 게임의 장면이 다양하더라도, 패널은 오직 1개만 사용됨!
 * 
 * 모든 Object는 결구 ㄱ이 패널에 그려져야 하므로, 이 패널의 paint 메소드의 인수로 전달되는 Graphics 객체를
 * 게임에 등장할 모든 Object가 공유해야 함(전달받아야 함)!
 * */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

// 참고) Panel은 따로 그 크기를 가지고 있지 않음!
// GamePanel = 게임 관제 센터
public class GamePanel extends JPanel implements Runnable{	// Runnable!=쓰레드, run()만 가지고 있는 인터페이스
	// 상수 지정
	public static final int WIDTH=400;
	public static final int HEIGHT=300;
	// 서로 다른 화면 크기에 따라 SCALE로 user의 사양에 따라 다르게 할 수 있도록
	public static final int SCALE=2;
	
	// 게임을 진행할 쓰레드 선언(운영 쓰레드)
	Thread thread; 
	
	// 게임 가동 여부를 결정하는 변수
	boolean flag=true;
	
	Player player;
	
	// 객체 명단 관리자
	// 명단에 저장되어있다면 접근은 상관X
	ObjectManager objectManager;
		
	public GamePanel() {
		// paint()보다 먼저 쓰레드 생성 및 시작
		thread=new Thread(this);
		thread.start();
		init();
		
		// 크기 지정
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		// 안먹힘
		//setBackground(Color.BLACK);
		
		// 키보드 이벤트의 주체는 패널
		// 패널과 키보드 이벤트 리스너 연결
		this.addKeyListener(new KeyBoard(player));
		// 바로 실행시키면 키보드가 작동되지 않는데, 이는 실행하면 focus가 Window에 있기 때문!
		// -> focus를 패널로 옮겨야 키보드 작동 가능
	}
	
	// 게임 시작(초기화)
	public void init(){
		// 데이터베이스(명단 관리자)는 게임이 시작될 때 먼저 생성
		objectManager=new ObjectManager();
		
		// 무조건 게임에 등장할 객체들은 접근을 쉽게 하기 위해 생성과 동시에 objectManager에 저장시키자!
		// player 등장시키기(생성)
		player=new Player(objectManager, 100, 200, 50, 50);
		
		// 명단에 player 추가
		objectManager.addObject(player);
	}
	
	// 패널의 그리기 설정
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//player.render(g);	// Graphics g가 있는 곳에서 player에 g를 넘기기
	
		// ObjectManager에 저장된 모든 객체들을 출현시키기
		// objectManager에 저장되어 있는 모든 게임에 등장할 객체들의 render 호출
		for(int i=0; i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
		}
	}
	
	// 게임의 실행부(게임이 진행되는 동안 동작이 계속되어야 함)
	// 게임에 출현할 모든 object의 tick, render를 호출해야 함
	// -> 따라서, panel은 출현할 object 명단을 알아야 함(Object manager)
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("게임 진행중!");
			
			// objectManager에 등록된 모든 객체륻 대상으로 tick 호출
			/*
			 * ObjectManager list의 generic type을 최상위 객체인 object로 지정했으므로 할 수 있는 기능이 제한되어 있음
			 * -> Player, Bullet 등의 출현할 객체의 부모 객체를 만들어 상속받고, generic type에는 부모 객체를 넣으면 됨!
			for(int i=0; i<objectManager.list.size(); i++){
				Object obj=objectManager.list.get(i);
			}
			*/
			
			// objectManager에 저장되어 있는 모든 게임에 등장할 객체들의 tick 호출
			for(int i=0; i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			// player.render();	불가능 -> g가 현재 여기 없으므로 불가능
			
			// paint Component를 간접 호출
			repaint();	// paint()메소드는 repaint()가 호출되어야 실행 가능
			
		}
		
	}
}
