package genericsExam;

import java.util.ArrayList;

public class GenericsExam {

	public static void main(String[] args) {
		
		// 제너릭스는 메서드나 컬렉션클래스를 컴파일할 때 객체타입을 체크해주는 역할을 한다.
		// 1. 타입을 지정하기 때문에 다른 타입이 대입되는 것을 방지해서 안정성을 높인다.
		// 2. 다루는 데이터의 객체타입의 형변환을 생략할 수 있어 간결한 코드를 작성할 수 있다.
		
		// 참조변수의 제너릭과 new연산자의 제너릭은 동일해야한다.
		// 만약 데이터를 제너릭타입으로 넣을 때 참조변수의 제너릭으로 들어오는 데이터를 인스턴스로 넣을 때 데이터가 서로 불일치하기 때문에 방지시킨다. 
		FruitBox<Fruit> fb1 = new FruitBox<Fruit>();
		FruitBox<Apple> fb2 = new FruitBox<Apple>();
		FruitBox<Grape> fb3 = new FruitBox<Grape>();
		//FruitBox<Toy> fb4 = new FruitBox<Toy>(); // 에러, 상속받지 못해서Toy는 제너릭스로 사용할 수 없다
		
		fb1.add(new Fruit());
		fb1.add(new Apple());
		fb1.add(new Grape());
		
		for (int i = 0; i < fb1.list.size(); i++) {
			System.out.println(fb1.get(i));
		}
		/*
			Fruit
			apple
			grape
		*/
	}//main

}

class Fruit implements Eatable{
	public String toString() {return "Fruit";}
}//Fruit

class Apple extends Fruit{public String toString() { return "apple";}} //Apple
class Grape extends Fruit{public String toString() { return "grape";}} //Grape
class Toy {public String toString() { return "toy";}} //Toy

interface Eatable{} //Eatable

// bound타입, 범위를 지정한다.
class FruitBox<T extends Fruit & Eatable> extends Box<T>{} //FruitBox
// T는 Fruit을 상속받고 Eatable을 구현한 객체만 제너릭스을 사용, 상속받으면서 구현한 객체도 가능, 모클래스 객체도 가능
//class FruitBox2<T[]>{} // 타입변수를 배열로 사용하는 것은 불가능하다


class Box<T>{
	static String str; // 타입변수는 일종의 인스턴스변수로 취급이 되기 떄문에 클래스멤버들은 사용할 수 없다(타입변수는 메인에서 인스턴스를 생성할 때 생성) 
	ArrayList<T> list = new ArrayList<T>();
	T[] num; // 타입변수를 클래스 내부에서 배열로 사용하는 것은 가능하다.
	
	
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	public String toString() {return list.toString();}
} // Box

