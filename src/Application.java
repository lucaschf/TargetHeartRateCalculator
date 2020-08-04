import tsi.too.TargetHeartRatesCalculator;

public class Application {
    public static void main(String[] args) {
        TargetHeartRatesCalculator targetHeartRatesCalculator = new TargetHeartRatesCalculator();
        targetHeartRatesCalculator.readData();
        targetHeartRatesCalculator.showResult();
        System.exit(0);
    }
}
