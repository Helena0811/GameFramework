package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	public GameWindow() {
		// FlowLayout���� �����ϸ� �׵θ� margin ����
		//setLayout(new FlowLayout());
		
		gamePanel=new GamePanel();
		add(gamePanel);
		
		// �гο� ���α׷��� ������ focus �ø���
		// Ű���� ������ gamePanel�� �����Ͽ����Ƿ� focus�� window�� �ִ� ���¿����� ���� �Ұ���
		gamePanel.setFocusable(true);
		
		// �������� ũ�⸦ ���뿡 ���� ����(���⼭�� gamePanel)
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new GameWindow();

	}

}
