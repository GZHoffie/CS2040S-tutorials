class ExpEval {
    public static double performOp(Stack<Double> operands, char operator) { double result = 0.0;
        switch (operator){
            case '+': // 0.0 + opr1 + opr2 ... 
                result = 0.0;
                while (!operands.empty()) 
                    result += operands.pop(); 
                return result;
            case '-':
                if (operands.size() == 1) 
                    return -operands.pop(); // -opr1 
                result = operands.pop();
                while (!operands.empty()) 
                    result -= operands.pop(); 
                return result; // opr1 - opr2 - opr3 ...
            case '*': 
                result = 1.0;
            while (!operands.empty()) 
                result *= operands.pop(); 
                return result;
            default: // floating point division
                if (operands.size() == 1) 
                    return 1 / operands.pop(); // 1.0/opr1
                result = operands.pop();
                while (!operands.empty()) 
                    result /= operands.pop();
                return result; // opr1 / opr2 / opr3 ...
        } // switch-case: here returns; don't forget to break otherwise!
    } // unspecified behaviour if operator invalid

    public static void main(String[] args) {
        Stack<String> allTokens = new Stack<String>(); // outer stack 
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String currentToken = sc.next(); if (currentToken.equals(")")) {
            Stack<Double> operands = new Stack<Double>(); // inner stack 
            while ("+-*/".indexOf(allTokens.peek()) == -1) // while operand
                operands.push(Double.parseDouble(allTokens.pop())); 
            char operator = allTokens.pop().charAt(0); 
            allTokens.pop(); // remove "("
            allTokens.push("" + performOp(operands, operator));
            } else {
                allTokens.push(currentToken);
            }
        }
        System.out.println(allTokens.pop());
        sc.close();
    }
}