/*
 * 각 GameObject에 구분 가능한 id값을 상수화
 * 
 * enum 객체 : java에서 지원되는 객체 중, 상수만을 모아놓은 집합
 * enum 객체는 상수를 모아놓기 때문에, 이 상수값들 사이에 index가 존재하며, 배열처럼 사용 가능
 * */
package game;
	
public enum ObjectId {
	// 영어 단어 자체를 상수로 사용 가능
	// 접근 방식 : 클래스명.상수
	Player, Enemy, Block, Bullet, Item
}


