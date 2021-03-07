package pattern;

/**
 * 原型模型：
 */
public class PrototypePattern {
    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println("name:" + plane.getName() + ", type:" + plane.getType());
        Plane plane1 = (Plane) plane.pClone();
        System.out.println("name:" + plane1.getName() + ", type:" + plane1.getType());
    }
}

interface Prototype {
    Object pClone();
}

class Plane implements Prototype {
    private String name;
    private String type;

    public Plane() {
        name = "name" + Math.random();
        type = "type" + Math.random();
    }

    public Plane(Plane plane) {
        this.name = plane.name;
        this.type = plane.type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object pClone() {
        return new Plane(this);
    }
}
