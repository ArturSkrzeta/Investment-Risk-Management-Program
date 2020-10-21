package investment_app;

public class InvestmentApp {

    public static void main(String[] args) {
        Investment in1 = new Investment("Apple", 100.0, 115.0, 95.0, 1.0,2.0 );
        System.out.print(in1.getRiskToReward());
        System.out.print("\n");
        System.out.print(in1.getDecision());
    }
}
