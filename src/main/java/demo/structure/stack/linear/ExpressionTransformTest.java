package demo.structure.stack.linear;

/**
 * 中缀表达式转后缀表达式
 */
public class ExpressionTransformTest {
    public static void main(String[] args) {
        final String formula = "2 * (9 + 6/3-5) + 4";
//        final String formula = "a + b*c + (d * e + f) * g";
        final String number = "0123456789abcdefg";
        final String operator = "+-*/()";
        final StringBuilder result = new StringBuilder();

        StackLinear<Character> stack = new StackLinear<>();
        for(int i=0; i<formula.length(); i++) {
            char ch = formula.charAt(i);
            if(ch == ' ') {
                continue;
            }
            if(number.indexOf(ch) > -1) {
                append(result, ch);
                continue;
            }
            if(operator.indexOf(ch) > -1) {
                switch (ch) {
                    case '(' -> {
                        stack.push(ch);
                    }
                    case ')' -> {
                        Character oper = stack.pop();
                        while (oper!=null && oper!='(') {
                            append(result, oper);
                            oper = stack.pop();
                        }
                    }
                    default -> {
                        dealOperator(stack, ch, result);
                    }
                }
            }

        }

        while (!stack.isEmpty()) {
            append(result, stack.pop());
        }

        System.out.println(result);
    }

    private static void dealOperator(StackLinear<Character> stack, Character character, StringBuilder sb) {
        if(stack.isEmpty()) {
            stack.push(character);
        } else {
            Character cetTop = stack.cetTop();
            if(getPriority(character) > getPriority(cetTop)) {
                stack.push(character);
            } else {
                Character c = stack.pop();
                append(sb, c);
                dealOperator(stack, character, sb);
            }
        }
    }

    private static int getPriority(char ch) {
        return switch (ch) {
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 2;
            case '(' -> 0;
            case ')' -> 3;
            default -> 0;
        };
    }

    private static void append(StringBuilder sb, Character c) {
        if(c == 'e') {
            System.out.println();
        }
        sb.append(c).append(" ");
    }

}
