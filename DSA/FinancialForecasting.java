package DSA;

public class FinancialForecasting {

    static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return forecast(currentValue, growthRate, years - 1)
                * (1 + growthRate);
    }

    static double forecastOptimized(double currentValue, double growthRate, int years) {
        double result = currentValue;

        for (int i = 1; i <= years; i++) {
            result = result * (1 + growthRate);
        }

        return result;
    }

    static double forecastMath(double value, double rate, int years) {
        return value * Math.pow(1 + rate, years);
    }

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double result1 = forecast(currentValue, growthRate, years);
        double result2 = forecastOptimized(currentValue, growthRate, years);
        double result3 = forecastMath(currentValue, growthRate, years);

        System.out.println(currentValue);
        System.out.println(growthRate);
        System.out.println(years);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
