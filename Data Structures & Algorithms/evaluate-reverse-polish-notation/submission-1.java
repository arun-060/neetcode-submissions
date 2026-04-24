class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1+num2);
            } else if (c.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            } else if (c.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1*num2);
            } else if (c.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.peek();
    }
}
