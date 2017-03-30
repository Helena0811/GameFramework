package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	public GameWindow() {
		// FlowLayout으로 설정하면 테두리 margin 존재
		//setLayout(new FlowLayout());
		
		gamePanel=new GamePanel();
		add(gamePanel);
		
		// 패널에 프로그래밍 적으로 focus 올리기
		// 키보드 동작은 gamePanel에 구현하였으므로 focus가 window에 있는 상태에서는 동작 불가능
		gamePanel.setFocusable(true);
		
		// 윈도우의 크기를 내용에 따라 설정(여기서는 gamePanel)
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new GameWindow();

	}

}
