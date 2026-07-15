package CreationalDesignPattern.FactoryDesignPattern;

interface Logistics {
    void send();
}
class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Road");
    }
}
class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Air");
    }
}
class Train implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by Train");
    }
}
class LogisticsFactory {
    public static Logistics getLogistics(String mode){
        if (mode.equalsIgnoreCase("road")) {
            return new Road();
        } else if (mode.equalsIgnoreCase("train")) {
            return new Train();
        }
        return new Air();
    }
}
class LogisticsService {
    public void send(String mode) {
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}
public class Main {
    public static void main(String[] args) {
        LogisticsService logisticsService = new LogisticsService();
        logisticsService.send("road");
        logisticsService.send("air");
    }
}
