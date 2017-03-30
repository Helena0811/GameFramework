/*
 * 제작중인 게임은 겡ㅁ 루프가 오직 1개만 존재하기 때문에,
 * while 내에서 게임에 등장할 모든 object의 Tick, render 호출해야 할 의무가 있음
 * 하지만, 게임에 등자할 객체들이 너무나 여러 크래스에 걸쳐 복잡하게 등장하기 때문에,
 * 게임 루프인 while 문내에서 모든 객체들의 레퍼런스를 접근하기란 쉽지 않음
 * 해결책
 * 게임에 등장할 모든 객체들을 관리해주는 존재가 필요! - Object Manager
 * */
package game;

import java.util.ArrayList;

public class ObjectManager {
	// 데이터베이스 역할을 할 존재
	ArrayList<GameObject> list=new ArrayList<GameObject>();
	
	// 객체 등록
	// 게임에 등장할 모든 객체는 생성될 때 아래의 메소드에 의해 데이터베이스에 등록됨
	public void addObject(GameObject obj){
		list.add(obj);
	}
}
