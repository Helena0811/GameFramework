/*
 * �������� ������ �ۤ� ������ ���� 1���� �����ϱ� ������,
 * while ������ ���ӿ� ������ ��� object�� Tick, render ȣ���ؾ� �� �ǹ��� ����
 * ������, ���ӿ� ������ ��ü���� �ʹ��� ���� ũ������ ���� �����ϰ� �����ϱ� ������,
 * ���� ������ while �������� ��� ��ü���� ���۷����� �����ϱ�� ���� ����
 * �ذ�å
 * ���ӿ� ������ ��� ��ü���� �������ִ� ���簡 �ʿ�! - Object Manager
 * */
package game;

import java.util.ArrayList;

public class ObjectManager {
	// �����ͺ��̽� ������ �� ����
	ArrayList<GameObject> list=new ArrayList<GameObject>();
	
	// ��ü ���
	// ���ӿ� ������ ��� ��ü�� ������ �� �Ʒ��� �޼ҵ忡 ���� �����ͺ��̽��� ��ϵ�
	public void addObject(GameObject obj){
		list.add(obj);
	}
}
