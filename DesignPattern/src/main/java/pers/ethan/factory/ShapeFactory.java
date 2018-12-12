package pers.ethan.factory;

/**
 * desc:
 * Created by huangzhe on 2018/12/12.
 */
public class ShapeFactory {

    public enum ShapeType {
        CIRCLE(0),
        SQUARE(1),
        RECTANGLE(2);

        private int value;

        ShapeType(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    public Shape getShape(ShapeType shapeType) {
        if (ShapeType.CIRCLE.equals(shapeType)) {
            return new Circle();
        } else if (shapeType.SQUARE.equals(shapeType)) {
            return new Square();
        } else if (shapeType.RECTANGLE.equals(shapeType)) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
