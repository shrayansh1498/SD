package BehaviouralDesignPatterns.CommandPattern;
import java.util.*;
class Light{
    public void on(){
        System.out.println("Light turned on");
    }
    public void off(){
        System.out.println("Light turned off");
    }
}
class AC{
    public void on(){
        System.out.println("AC turned on");
    }
    public void off(){
        System.out.println("AC turned off");
    }
}

//Commands
interface Command{
    void execute();
    void undo();
}
class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }
}
class LightOffCommand implements Command{
    private Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.off();
    }
    public void undo(){
        light.on();
    }
}

class ACOnCommand implements Command{
    private AC ac;
    public ACOnCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
        ac.on();
    }
    public void undo(){
        ac.off();
    }
}
class ACOffCommand implements Command{
    private AC ac;
    public ACOffCommand(AC ac){
        this.ac = ac;
    }
    public void execute(){
        ac.off();
    }
    public void undo(){
        ac.on();
    }
}

//Invoker
//Has 4 commands, but can be extended to have more
class RemoteContol{
    private Command[] buttons = new Command[4];
    private Stack<Command> commandHistory = new Stack<>();
    public void setCommand(int index, Command command){
        buttons[index] = command;
    }
    public void pressButton(int index){
        if(buttons[index] != null){
            buttons[index].execute();
            commandHistory.push(buttons[index]);
        }
        else
            System.out.println("No command");
    }
    public void pressUndo(){
        if(!commandHistory.isEmpty())
            commandHistory.pop().undo();
        else
            System.out.println("Nothing to undo");
    }
}
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        AC ac = new AC();
        RemoteContol remoteContol = new RemoteContol();
        remoteContol.setCommand(0, new LightOnCommand(light));
        remoteContol.setCommand(1, new LightOffCommand(light));
        remoteContol.setCommand(2, new ACOnCommand(ac));
        remoteContol.setCommand(3, new ACOffCommand(ac));
        remoteContol.pressButton(0);
        remoteContol.pressButton(1);
        remoteContol.pressButton(2);
        remoteContol.pressButton(3);
        remoteContol.pressUndo();
    }   
}
