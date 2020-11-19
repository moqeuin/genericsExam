package genericsExam;

import java.util.ArrayList;
import java.util.List;

public class GenericsExam2 {

	public static void main(String[] args) {
		// 목적 : 타입변수에 대한 범위를 상속관계에서 지정한다, 그리고 다양한 타입변수를 지정할 수 있게 다형성을 구현
		
		// lower bound < ? super T> : T와 T를 상속시킨 모클래스들만 사용가능
		// higher bound < ? extends T> : T와 T를 상속받은 자식클래스만 사용가능
		// <?> (== <? extends Object)  : 모든타입가능
		
		// 클래스 선언 시에는 사용하지 못한다.
		
		List<String> list = new ArrayList<String>();
		GenericsClass.method(list);
		
		GenericsClass<String> gc = new GenericsClass<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		//System.out.println(gc.method2(list2));
		// List<Object>와 List<Integer>는 Object클래스와 상속관계지만 제너릭스는 상속 관계가 적용이 안된다.
		
		List<Integer> list3 = new ArrayList<>();
		gc.wildMethod(list);
		
		Person<Object> p1 = new Person<Object>();
		Person<String> p2 = new Person<String>();
		
		//p1 = (Person<Object>)p2; // 마찬가지로 제너릭은 상속관계를 적용할 수 없어서 형변환이 불가능하다
		
		Person<? extends Object> p3 = new Person<String>();
		
		p1 = (Person<Object>)p3; // 와일드카드로 지정한 범위에 제너릭을 가진 참조변수는 형변환이 가능하다
		
		
	}

}

// 클래스의 인스턴스를 생성할 때 T라는 타입변수는 지정하면서 생성이 된다. 
// 그래서 클래스의 제너릭은 인스턴스 변수와 같고 static 변수나 static 메서드 내에서 사용하지 못한다. 
class GenericsClass<T>{
	
	static int number = 9;
	
	// List에 제너릭스는 메서드의 T로 타입이 결정이 되기 때문에 사용이 가능하다. 반면에 List의 제너릭스만 설정하면
	// 클래스의 제너릭스로 적용이 되기 때문에 클래스가 생성되는 시점을 알 수 없으니 사용할 수 없다.
	public static <T> void method(List<T> list) {
		
		
	}
	public void method2(List<Object> list) {
		System.out.println("test");
	}
	
	// <?> : list에서 원소를 저장하거나 삭제하는 add(),remove() 같은 것들 사용하지 않을 때 사용
	
	// 인스턴스 생성 시 T를 상속받은 자식클래스와 T로 제너릭을 지정한다.
	public void wildMethod(List<? extends T> list) {}
	// 인스턴스 생성 시 T를 상속시킨 부모클래스와 T로 제너릭을 지정한다.
	public void wildMethod2(List<? super T> list) {}
}

class Person<T>{
	
}
