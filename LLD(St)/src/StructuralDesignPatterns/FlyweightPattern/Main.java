package StructuralDesignPatterns.FlyweightPattern;

import java.util.*;
class Treetype{
    private String name;
    private String color;
    private String texture;
    public Treetype(String name, String color, String texture){
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y){
        System.out.println("Drawing tree " + name + " at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}
class Tree{
    private int x;
    private int y;
    private Treetype treeType;
    public Tree(int x, int y, Treetype treetype){
        this.x = x;
        this.y = y;
        this.treeType = treetype;
    }

    public void draw(){
        treeType.draw(x, y);
    }
}

class TreeFactory{
    static Map<String, Treetype> treeTypeMap = new HashMap<>();
    public static Treetype getTreetype(String name, String color, String texture){
        String key = name + "_" +color + "_" + texture;
        if(!treeTypeMap.containsKey(key)){
            treeTypeMap.put(key, new Treetype(name, color, texture));
        }
        return treeTypeMap.get(key);
    }
}

class Forest{
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture){
        Tree tree = new Tree(x, y, TreeFactory.getTreetype(name, color, texture));
        trees.add(tree);
    }

    public void draw(){
        for(Tree tree : trees){
            tree.draw();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        for(int i = 0; i < 100000; i++){
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }
        forest.draw();
    }
}
