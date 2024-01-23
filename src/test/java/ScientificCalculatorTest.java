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
        // List to store test data
        List<Object[]> data = new ArrayList<>();
        // CSV file containing test data
        String csvFile = "calculatorTestData.csv";
        String line;
        String[] headers = null;

        // Reading data from the CSV file
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
        // iterator is an object that allows you to iterate (loop) through a collection of elements, such as a list or a set, one element at a time. It provides a uniform way to access the elements of a collection without exposing the underlying implementation details.
        return data.iterator();
    }

    @Test(dataProvider = "calculatorDataProvider", groups = "basicOperations", priority = 0)
    public void testAddition(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String arg2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups) && !"advancedOperations".equals(groups)) {
            try {
                // Performing addition operation
                if ("addition".equals(operation.toLowerCase())) {
                    double result = calculator.add(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    double epsilon = 1e-10;
                    System.out.println("testAddition Executed");
                    // Verifying the result
                    Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: addition");
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }


    @Test(dataProvider = "calculatorDataProvider", groups = "basicOperations", priority = 1)
    public void testSubtraction(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String arg2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups) && !"advancedOperations".equals(groups)) {
            try {
                // Performing subtraction operation
                if ("subtraction".equals(operation.toLowerCase())) {
                    double result = calculator.subtract(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    double epsilon = 1e-10;
                    System.out.println("testSubtraction Executed");
                    // Verifying the result
                    Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: subtraction");
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }


    @Test(dataProvider = "calculatorDataProvider", groups = "basicOperations", priority = 2)
    public void testMultiplication(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String arg2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups) && !"advancedOperations".equals(groups)) {
            try {
                // Performing multiplication operation
                if ("multiplication".equals(operation.toLowerCase())) {
                    double result = calculator.multiply(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    double epsilon = 1e-10;
                    System.out.println("testMultiplication Executed");
                    // Verifying the result
                    Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: multiplication");
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }

    @Test(dataProvider = "calculatorDataProvider", groups = "basicOperations", priority = 3)
    public void testDivision(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String arg2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group
        if ("basicOperations".equals(groups) && !"advancedOperations".equals(groups)) {
            try {
                // Performing division operation
                if ("division".equals(operation.toLowerCase())) {
                    double result = calculator.divide(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    double epsilon = 1e-10;
                    System.out.println("testDivision Executed");
                    // Verifying the result
                    Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: division");
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }

    @Test(dataProvider = "calculatorDataProvider", groups = "advancedOperations", priority = 4)
    public void testSquareRoot(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group
        if ("advancedOperations".equals(groups)) {
            try {
                // Performing square root operation
                if ("squareroot".equals(operation.toLowerCase())) {
                    double result = calculator.squareRoot(Double.parseDouble(arg1));
                    double epsilon = 1e-10;
                    System.out.println("testSquareRoot Executed");
                    // Verifying the result
                    Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: squareroot");
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }


    @Test(dataProvider = "calculatorDataProvider", groups = "advancedOperations", priority = 5)
    public void testPower(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String arg2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group
        if ("advancedOperations".equals(groups)) {
            try {
                // Performing power operation
                if ("power".equals(operation.toLowerCase())) {
                    double result = calculator.power(Double.parseDouble(arg1), Double.parseDouble(arg2));
                    double epsilon = 1e-10;
                    System.out.println("testPower Executed");
                    // Verifying the result
                    Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: power");
                }
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }


    @Test(dataProvider = "calculatorDataProvider", groups = "advancedOperations", priority = 6)
    public void testSin(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group and operation is "sin"
        if ("advancedOperations".equals(groups) && "sin".equals(operation.toLowerCase())) {
            try {
                // Performing sin operation
                double result = calculator.sin(Double.parseDouble(arg1));
                double epsilon = 1e-10;
                System.out.println("testSin Executed");
                // Verifying the result
                Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: sin");
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }



    @Test(dataProvider = "calculatorDataProvider", groups = "advancedOperations", priority = 7)
    public void testCos(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group and operation is "cos"
        if ("advancedOperations".equals(groups) && "cos".equals(operation.toLowerCase())) {
            try {
                // Performing cos operation
                double result = calculator.cos(Double.parseDouble(arg1));
                double epsilon = 1e-10;
                System.out.println("testCos Executed");
                // Verifying the result
                Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: cos");
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }

    @Test(dataProvider = "calculatorDataProvider", groups = "advancedOperations", priority = 8)
    public void testTan(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String arg1 = values[1];
        String expectedResult = values[3];
        String groups = values[4];

        // Checking if the test belongs to the correct group and operation is "tan"
        if ("advancedOperations".equals(groups) && "tan".equals(operation.toLowerCase())) {
            try {
                // Performing tan operation
                double result = calculator.tan(Double.parseDouble(arg1));
                double epsilon = 1e-10;
                System.out.println("testTan Executed");
                // Verifying the result
                Assert.assertEquals(result, Double.parseDouble(expectedResult), epsilon, "Operation: tan");
            } catch (ArithmeticException | IllegalArgumentException e) {
                // Handling exceptions during the test execution
                handleException(e);
            }
        }
    }


    // Method to handle exceptions during test execution
    private void handleException(Exception e) {
        // Printing error message to standard error output
        System.err.println("Error during test execution: " + e.getMessage());

        // Failing the test with an assertion error and including exception information
        Assert.fail("Unexpected exception: " + e.getClass().getSimpleName());
    }

    @Test(dataProvider = "calculatorDataProvider", groups = "basicOperations", priority = 9)
    public void testInvalidAddition(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String num1 = values[1];
        String num2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        try {
            // Checking if the test belongs to the correct group and operation is "addition"
            if ("basicOperations".equals(groups) && "addition".equals(operation.toLowerCase())) {
                // Performing addition operation, expecting a NumberFormatException
                calculator.add(Double.parseDouble(num1), Double.parseDouble(num2));
                System.out.println("testInvalidAddition Executed");
                // Failing the test if NumberFormatException is not thrown
                Assert.fail("Expected NumberFormatException was not thrown.");
            }
        } catch (NumberFormatException e) {
            // Handling NumberFormatException by printing a message
            System.out.println("Invalid number format");
        }
    }

    @Test(dataProvider = "calculatorDataProvider", groups = "basicOperations", priority = 10)
    public void testInvalidDivision(String[] values) {
        // Extracting values from the test data array
        String operation = values[0];
        String num1 = values[1];
        String num2 = values[2];
        String expectedResult = values[3];
        String groups = values[4];

        try {
            // Checking if the test belongs to the correct group and operation is "division"
            if ("basicOperations".equals(groups) && "division".equals(operation.toLowerCase())) {
                // Performing division operation, expecting an ArithmeticException
                calculator.divide(Double.parseDouble(num1), Double.parseDouble(num2));
                System.out.println("testInvalidDivision Executed");
                // Failing the test if ArithmeticException is not thrown
                Assert.fail("DivisionByZeroException");
            }
        } catch (ArithmeticException e) {
            // Handling ArithmeticException and checking if it's a division by zero
            if (e.getMessage().toLowerCase().contains("zero")) {
                // Printing message for division by zero
                System.out.println("Division by zero");
            } else {
                // Rethrowing the exception if it's not a division by zero eception
                throw e;
            }
        }
    }

}
