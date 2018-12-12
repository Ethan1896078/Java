package pers.ethan.factory;

/**
 * desc:
 * Created by huangzhe on 2018/12/12.
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(ShapeFactory.ShapeType.CIRCLE);
        circle.draw();

        Shape square = shapeFactory.getShape(ShapeFactory.ShapeType.SQUARE);
        square.draw();

        Shape rectangle = shapeFactory.getShape(ShapeFactory.ShapeType.RECTANGLE);
        rectangle.draw();
    }
}
