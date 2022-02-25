package demo.structure.stack.linear;

/**
 * 右缀表达式计算
 */
public class RightExpressionTest {
    public static void main(String[] args) {
        // 2 9 2 + 5 - * 4 +
        // 2 11 5 - * 4 +
        // 2 6 * 4 +
        // 12 4 +
        final String expression = "2 9 6 3 / + 5 - * 4 +";
        final String number = "01234567890";
        final String operator = "+-*/";

        StackLinear<Double> stack = new StackLinear<>();
        for(int i=0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == ' ') continue;

            if(number.indexOf(ch) > -1) {
                stack.push(char2Double(ch));
                continue;
            }

            if(operator.indexOf(ch) > -1) {
                cal(stack, ch);
            }

        }

        Double result = stack.cetTop();
        System.out.println(result);

    }

    private static double char2Double(char c) {
        return c - 48;
    }

    private static void cal(StackLinear<Double> stack, char ch) {
        Double a = stack.pop();
        Double b = stack.pop();
        double result = switch (ch) {
            case '+' -> b+a;
            case '-' -> b-a;
            case '*' -> b*a;
            case '/' -> b/a;
            default -> 0;
        };
        System.out.println(b + " " + ch + " " + a + " = " + result);
        stack.push(result);
    }

}
