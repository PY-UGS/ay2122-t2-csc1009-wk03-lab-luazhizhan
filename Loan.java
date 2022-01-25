import java.util.Date;
import java.lang.Math;
import java.util.Scanner;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Loan() {
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
        this.loanDate = new Date();
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getloanAmount() {
        return loanAmount;
    }

    public Date getloanDate() {
        return loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setloanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        double annualRate = getAnnualInterestRate() / 100;

        // Monthly interest rate
        // is the yearly rate divided by 12

        double monthlyInterestRate = annualRate / 12.0;

        // The length of the term in months
        // is the number of years times 12

        // int termInMonths = this.numberOfYears * 12;
        double loanAmount = this.loanAmount;
        int years = this.numberOfYears;
        // The Math.pow() method is used calculate values raised to a power

        double monthlyPayment = (loanAmount * monthlyInterestRate)
                / (1 - (Math.pow(1 + monthlyInterestRate, (years * -12))));

        return monthlyPayment;
    }

    public double getTotalPayment() {
        return this.getMonthlyPayment() * this.numberOfYears * 12;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter annual interest rate, for example, 8.25: ");
            double interestRate = input.nextDouble();
            System.out.print("Enter number of years as an integer: ");
            int years = input.nextInt();
            System.out.print("Enter loan amount, for example, 120000.95: ");
            double loanAmt = input.nextDouble();
            Loan loan = new Loan(interestRate, years, loanAmt);
            System.out.println(String.format("The loan was created on %s", loan.getloanDate().toString()));
            System.out.println(String.format("The monthly payment is %.2f", loan.getMonthlyPayment()));
            System.out.println(String.format("The total payment is  %.2f", loan.getTotalPayment()));
        }

    }
}
