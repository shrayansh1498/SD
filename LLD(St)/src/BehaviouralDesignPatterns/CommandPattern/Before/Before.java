package BehaviouralDesignPatterns.CommandPattern.Before;

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
class NaiveRemoteContol{
    private Light light;
    private AC ac;
    private String lastAction="";
    public NaiveRemoteContol(Light light, AC ac){
        this.light = light;
        this.ac = ac;
    }
    public void pressLighton(){
        light.on();
        lastAction = "Light_on";
    }
    public void pressLightoff(){
        light.off();
        lastAction = "Light_off";
    }
    public void pressACon(){
        ac.on();
        lastAction = "AC_on";
    }
    public void pressACoff(){
        ac.off();
        lastAction = "AC_off";
    }
    public void pressUndo(){
        switch(lastAction){
            case "Light_on": pressLightoff(); break;
            case "Light_off": pressLighton(); break;
            case "AC_on": pressACoff(); break;
            case "AC_off": pressACon(); break;
            default : System.out.println("Nothing to undo");
        }
    }
}
public class Before {
    public static void main(String[] args) {
        Light light = new Light();
        AC ac = new AC();
        
        NaiveRemoteContol remoteContol = new NaiveRemoteContol(light, ac);
        remoteContol.pressLighton();
        remoteContol.pressACon();
        remoteContol.pressLightoff();
        remoteContol.pressACoff();
        remoteContol.pressUndo();
    }
}
