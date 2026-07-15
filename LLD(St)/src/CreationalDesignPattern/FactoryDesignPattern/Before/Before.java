package CreationalDesignPattern.FactoryDesignPattern.Before;

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
class LogisticsService {
    public void send(String mode) {
        if (mode.equalsIgnoreCase("road")) {
            Logistics logistics = new Road();
            logistics.send();
        } else if (mode.equalsIgnoreCase("air")) {
            Logistics logistics = new Air();
            logistics.send();
        }
    }
}
public class Before {
    public static void main(String[] args) {
        LogisticsService logisticsService = new LogisticsService();
        logisticsService.send("road");
        logisticsService.send("air");
    }
}
