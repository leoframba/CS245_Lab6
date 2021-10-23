import java.util.ArrayList;
import java.util.List;

public class Lab06 {
    public int evalRPN(List<String> tokens) {
        //Operation variables
        int a, b;
        Stack<Integer> ms = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> ms.push(ms.pop() + ms.pop());
                case "/" -> {
                    b = ms.pop();
                    a = ms.pop();
                    ms.push(a / b);
                }
                case "*" -> ms.push(ms.pop() * ms.pop());
                case "-" -> {
                    b = ms.pop();
                    a = ms.pop();
                    ms.push(a - b);
                }
                //If the token is an int at it to the stack
                default -> ms.push(Integer.parseInt(s));
            }
        }
        return ms.pop();
    }


    public ArrayList<String> getList(int example) throws Exception {
        if (example < 0 || example > 2)
            throw new Exception("Three examples only!");
        ArrayList<String> list = new ArrayList<>();
        if (example == 0)
            list.addAll(List.of(new String[]{"2", "1", "+", "3", "*"}));
        else if (example == 2)
            list.addAll(List.of(new String[] {"4","13","5","/","+"}));
        else
            list.addAll(List.of(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        return list;
    }


    public static void main (String [] args) {
        Lab06 lab = new Lab06();
        ArrayList<String> tokens = new ArrayList<>();
        try {
            for (int example = 0; example < 3; example++)
                System.out.println("Example " + (example + 1) + " evaluates to " + lab.evalRPN(lab.getList(example)));
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}