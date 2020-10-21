package investment_app;
import java.util.Scanner;

public class Investment {

    private String instrument;
    private Double signalStrength;

    private Double entryPrice;
    private Double profitPrice;
    private Double riskPrice;

    private Double commission;
    private Double spread;

    private Double riskToReward;

    public Investment(String instrument, Double entryPrice, Double profitPrice, Double riskPrice, Double commission, Double spread) {
        this.instrument = instrument;

        this.entryPrice = entryPrice;
        this.profitPrice = profitPrice;
        this.riskPrice = riskPrice;
        this.commission = commission;
        this.spread = spread;

        this.riskToReward = setRiskToReward();
        this.signalStrength = setSignalStrngth();

    }

    private Double setRiskToReward() {
        riskToReward = (this.profitPrice - this.entryPrice - this.commission - this.spread) / (this.entryPrice - this.riskPrice);
        return riskToReward;
    }

    private Double setSignalStrngth() {
        System.out.print("Assess Signal Strength:\n 0.5 - very low,\n 1.0 - neutral,\n 1.5 - very strong\n");
        Scanner in = new Scanner(System.in);
        Double singalStrngth = in.nextDouble();
        return singalStrngth;
    }

    public String getDecision() {
        Double finalRatio = this.riskToReward * this.signalStrength;
        if (finalRatio < 3.0) { return "Final RR ratio is below 3! Do not take transaction!"; }
        if (finalRatio == 3.0) { return "RFinal RR ratio equals 3. You are free to take transaction!"; }
        if (finalRatio > 3.0) { return "Final RR ratio is greater than 3. You are free to take transaction!"; }
        return String.valueOf(finalRatio);
    }

    public String getRiskToReward() {
        return "Risk to Reward ratio is: " + this.riskToReward.toString();
    }

}