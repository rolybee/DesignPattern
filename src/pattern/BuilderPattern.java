package pattern;

import sun.java2d.windows.GDIWindowSurfaceData;

/**
 * 建造模式：
 */
public class BuilderPattern {
}

class House {
    private Light lignt;
    private Door door;
    private Wall wall;

    public House(Light lignt, Door door, Wall wall) {
        this.lignt = lignt;
        this.door = door;
        this.wall = wall;
    }

}

class Light {

}

class Door {

}

class Wall {

}
