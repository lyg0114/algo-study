package etc;

/**
 * @author : iyeong-gyo
 * @package : etc
 * @since : 13.11.23
 */

// 기존의 인터페이스
interface MyInterface {

  void existingMethod();

  // Java 8에서 도입된 Default Method
  default void newAddMethod(String input) {
    System.out.println("input = " + input);
    System.out.println("Default implementation of newMethod");
  }

}

class MyClassV1 implements MyInterface {

  @Override
  public void existingMethod() {
    System.out.println("Implementation of existingMethod - V1");
  }
}

class MyClassV2 implements MyInterface {

  @Override
  public void existingMethod() {
    System.out.println("Implementation of existingMethod - V2");
  }
}

public class InterfaceStudy {

  public static void main(String[] args) {
    MyInterface myClass = new MyClassV2();
    myClass.existingMethod();  // 기존 메서드 호출
    myClass.newAddMethod("TEST");
  }
}
