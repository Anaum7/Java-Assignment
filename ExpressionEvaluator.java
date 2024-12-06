import java.util.Stack;

public class ExpressionEvaluator {

    // Method to evaluate an expression
    public static double evaluate(String expression) {
        return evaluatePostfix(infixToPostfix(expression));
    }

    // Method to convert infix expression to postfix
    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char token = infix.charAt(i);

            // If the token is a digit or a decimal point, append it to the output
            if (Character.isDigit(token) || token == '.') {
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    postfix.append(infix.charAt(i));
                    i++;
                }
                postfix.append(' '); // Add space to separate numbers
                i--; // Adjust index since the for loop will increment it
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop(); // Remove '(' from stack
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim(); // Trim to remove trailing space
    }

    // Method to evaluate postfix expression
    private static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) continue; // Skip empty tokens
            if (Character.isDigit(token.charAt(0)) || (token.length() > 1 && token.charAt(0) == '-')) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    // Method to determine precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // Method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        String[] expressions = {
            "3 + 4 * 2",
            "(1 + 2) * (3 + 4)",
            "10 + 2 * 6",
            "100 * 2 + 12",
            "100 * (2 + 12)",
            "100 * (2 + 12) / 14"
        };

        for (String expression : expressions) {
            try {
                double result = evaluate(expression);
                System.out.println("Expression: " + expression + " = " + result);
            } catch (Exception e) {
                System.out.println("Error evaluating expression: " + expression + " - " + e.getMessage());
            }
        }
    }
}