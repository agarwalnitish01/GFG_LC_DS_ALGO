package pattern;

interface Shape {
    // Method inside interface
    void draw();
}


class Rectangle implements Shape {
    // Overriding the method
    @Override
    public void draw() {
        // /Print statement to execute when
        // draw() method of this class is called
        // later on in the main() method
        System.out.println("Shape: Rectangle");
    }
}


class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}


abstract class ShapeDecorator implements Shape {
    // Protected variable
    protected Shape decoratedShape;

    // Method 1
    // Abstract class method
    public ShapeDecorator(Shape decoratedShape) {
        // This keywordd refers to current object itself
        this.decoratedShape = decoratedShape;
    }

    // Method 2 - draw()
    // Outside abstract class
    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}


public class DecoratorPattern {
    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        // Call 1
        circle.draw();
        redCircle.draw();
        redRectangle.draw();
    }
}