import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import temp.testng.methods.ScientificCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScientificCalculatorTest {

    private ScientificCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new ScientificCalculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "calculatorDataProvider")
    public Iterator<Object[]> calculatorDataProvider() throws IOException {
        List<Object[]> data = new ArrayList<>();
        String csvFile = "calculatorTestData.csv";
        String line;
        String[] headers = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (headers == null) {
                    headers = values;
                } else {
                    data.add(values);
                }
            }
        }

        return data.iterator();
    }

    @Test(dataProvider = "calculatorDataProvider", priority = 0)
    public void performOperation(String[] values) {
        String operation = values[0];
        String arg1 = values[1];
        String arg2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        try {
            double result = 0;

            switch (operation.toLowerCase()) {
                case "addition":
                    if ("basicOperations".equals(groups) || "advancedOperations".equals(groups)) {
                        result = calculator.add(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    }
                    break;
                case "subtraction":
                    if ("basicOperations".equals(groups) || "advancedOperations".equals(groups)) {
                        result = calculator.subtract(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    }
                    break;
                case "multiplication":
                    if ("basicOperations".equals(groups) || "advancedOperations".equals(groups)) {
                        result = calculator.multiply(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    }
                    break;
                case "division":
                    if ("basicOperations".equals(groups) || "advancedOperations".equals(groups)) {
                        result = calculator.divide(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    }
                    break;
                case "squareroot":
                    if ("advancedOperations".equals(groups)) {
                        result = calculator.squareRoot(Double.parseDouble(arg1));
                    }
                    break;
                case "power":
                    if ("advancedOperations".equals(groups)) {
                        result = calculator.power(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    }
                    break;
                case "sin":
                    if ("advancedOperations".equals(groups)) {
                        result = calculator.sin(Double.parseDouble(arg1));
                    }
                    break;
                case "cos":
                    if ("advancedOperations".equals(groups)) {
                        result = calculator.cos(Double.parseDouble(arg1));
                    }
                    break;
                case "tan":
                    if ("advancedOperations".equals(groups)) {
                        result = calculator.tan(Double.parseDouble(arg1));
                    }
                    break;
                default:
                    Assert.fail("Unsupported operation: " + operation);
            }

            double epsilon = 1e-10; // Set your desired epsilon value
            Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: " + operation);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.err.println("Error during test execution: " + e.getMessage());
            Assert.fail("Unexpected exception: " + e.getClass().getSimpleName());
        }
    }
}
