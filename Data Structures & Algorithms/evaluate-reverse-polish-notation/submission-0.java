class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(doOperation(op1, op2, token));
            }
        }
        return stack.pop();
    }

    private int doOperation(int op1, int op2, String operation) {
        return switch (operation) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "/" -> op1 / op2;
            default -> op1 * op2;
        };
    }
}
