package etc;

/**
 * @author : iyeong-gyo
 * @package : etc
 * @since : 13.11.23
 */
// 도형을 나타내는 인터페이스
interface Shape {
  void draw();
}

// 도형의 색상을 다루는 인터페이스
interface Colorable {
  void applyColor();
}

// 추상 클래스를 활용하여 공통 기능을 제공
abstract class AbstractShape implements Shape {
  // 공통 기능을 제공하는 추상 메서드나 구현된 메서드 추가 가능
}

// 구체적인 도형 클래스
class Circle extends AbstractShape implements Colorable {
  @Override
  public void draw() {
    System.out.println("Drawing a Circle");
  }

  @Override
  public void applyColor() {
    System.out.println("Applying color to a Circle");
  }
}

class Square extends AbstractShape implements Colorable {
  @Override
  public void draw() {
    System.out.println("Drawing a Square");
  }

  @Override
  public void applyColor() {
    System.out.println("Applying color to a Square");
  }
}
public class AbstractInterfaceStudy {

  public static void main(String[] args) {
    Shape circle = new Circle();
    circle.draw();

    Colorable square = new Square();
    square.applyColor();
  }
}
