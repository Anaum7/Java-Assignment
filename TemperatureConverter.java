import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("Enter the temperature followed by the scale (C for Celsius, F for Fahrenheit, K for Kelvin):");
        
        // Loop to allow multiple conversions
        for (int i = 0; i < 3; i++) {
            System.out.print("Input " + (i + 1) + ": ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter in the format: <temperature> <scale>");
                continue;
            }
            
            try {
                double temperature = Double.parseDouble(parts[0]);
                String scale = parts[1].toUpperCase();
                
                switch (scale) {
                    case "C":
                        convertFromCelsius(temperature);
                        break;
                    case "F":
                        convertFromFahrenheit(temperature);
                        break;
                    case "K":
                        convertFromKelvin(temperature);
                        break;
                    default:
                        System.out.println("Invalid scale. Please use C, F, or K.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature value. Please enter a valid number.");
            }
        }
        
        scanner.close();
    }

    private static void convertFromCelsius(double celsius) {
        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;
        System.out.printf("%.2f °C = %.2f °F = %.2f K%n", celsius, fahrenheit, kelvin);
    }

    private static void convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = celsius + 273.15;
        System.out.printf("%.2f °F = %.2f °C = %.2f K%n", fahrenheit, celsius, kelvin);
    }

    private static void convertFromKelvin(double kelvin) {
        if (kelvin < 0) {
            System.out.println("Invalid temperature. Kelvin cannot be negative.");
            return;
        }
        double celsius = kelvin - 273.15;
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.printf("%.2f K = %.2f °C = %.2f °F%n", kelvin, celsius, fahrenheit);
    }
}