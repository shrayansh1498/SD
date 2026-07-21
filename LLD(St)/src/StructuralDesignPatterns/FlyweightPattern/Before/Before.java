package StructuralDesignPatterns.FlyweightPattern.Before;
import java.util.*;
class Tree{
    private int x;
    private int y;
    private String name;
    private String color;
    private String texture;
    public Tree(int x, int y, String name, String color, String texture){
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(){
        System.out.println("Drawing tree " + name + " at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}

class Forest{
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture){
        Tree tree = new Tree(x, y, name, color, texture);
        trees.add(tree);
    }

    public void draw(){
        for(Tree tree : trees){
            tree.draw();
        }
    }
}
public class Before {
    public static void main(String[] args) {
        Forest forest = new Forest();
        for(int i = 0; i < 100000; i++){
            forest.plantTree(i, i, "Oak" + i, "Green", "Rough");
        }
        forest.draw();
    }
}
