class FinancialForecast {

    static double predictFutureValue(double amount,
                                     double growthRate,
                                     int years) {

        if (years == 0) {
            return amount;
        }

    
        return predictFutureValue(amount,
                                  growthRate,
                                  years - 1)
                                  * (1 + growthRate);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue =
            predictFutureValue(presentValue,
                               growthRate,
                               years);

        System.out.println("Present Value : ₹" +
                            presentValue);

        System.out.println("Growth Rate : " +
                            (growthRate * 100) + "%");

        System.out.println("Years : " + years);

        System.out.println("Future Value : ₹" +
                            futureValue);
    }
}