import java.util.*;

public class homeTask4 {

    static String To_OPZ(String [] expr) 
    {
        String expr1 = "";
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < expr.length; i ++)
        {
            if (expr[i].charAt(0) == '1' || 
                expr[i].charAt(0) == '2' || 
                expr[i].charAt(0) == '3' ||
                expr[i].charAt(0) == '4' ||
                expr[i].charAt(0) == '5' || 
                expr[i].charAt(0) == '6' ||
                expr[i].charAt(0) == '7' ||
                expr[i].charAt(0) == '8' ||
                expr[i].charAt(0) == '9' ||
                expr[i].charAt(0) == '0' ||
                expr[i].equals("Pi") )
                expr1 += expr[i] + " ";

            if (expr[i].equals("(")  || expr[i].equals("^") )
                stack.push(expr[i]);


            if (expr[i].equals("/")  || expr[i].equals("*") )
            {
                while (!stack.isEmpty() && (stack.peek().equals("^" ) || stack.peek().equals("/")  || stack.peek().equals("*") ))
                    {
                        expr1 += stack.pop() + " "; 
                        
                    }
                    stack.push(expr[i]);
            }

            if (expr[i].equals("+") || expr[i].equals("-") )
            {
                
                while (! stack.isEmpty() && (stack.peek().equals("^")  || stack.peek().equals("/")  || 
                    stack.peek().equals("*")  || stack.peek().equals("-") || stack.peek().equals("+") ))
                {
                    expr1 += stack.pop() + " "; 
                    
                }
                stack.push(expr[i]);
            }

            if (expr[i].equals(")") )
            {
                while (! stack.peek().equals("("))
                {
                    expr1 += stack.pop() + " ";
                }
                stack.pop();
            }

            if (expr[i].equals("sin") )
            {
                stack.push(expr[i]);
            }

        }

        int i = 0;
        while (i <= stack.size()) 
            {
                expr1 += stack.pop() + " ";
                i ++;
            }
        return expr1;
    }

    static Integer To_Number(String [] expr)
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expr.length; i ++)
        {
            if (expr[i].charAt(0) == '1' || 
                expr[i].charAt(0) == '2' || 
                expr[i].charAt(0) == '3' ||
                expr[i].charAt(0) == '4' ||
                expr[i].charAt(0) == '5' || 
                expr[i].charAt(0) == '6' ||
                expr[i].charAt(0) == '7' ||
                expr[i].charAt(0) == '8' ||
                expr[i].charAt(0) == '9' ||
                expr[i].charAt(0) == '0')
            {
                stack.push(Integer.parseInt(expr[i]));
            }

            if (expr[i].equals("Pi"))
             {
                 stack.push((int)Math.PI);
             }

             if (expr[i].equals("+"))
             {
                 stack.push(stack.pop() + stack.pop());
             }

             if (expr[i].equals("-"))
             {
                int a = stack.pop();
                stack.push(stack.pop() - a);
             }

             if (expr[i].equals("*"))
             {
                 stack.push(stack.pop() * stack.pop());
             }

             if (expr[i].equals("/"))
             {
                int a = stack.pop();
                stack.push(stack.pop() / a);

             }

             if (expr[i].equals("^"))
             {
                int a = stack.pop();
                stack.push((int)Math.pow(stack.pop(), a));
             }

             if (expr[i].equals("sin"))
             {
                stack.push((int)Math.sin(stack.pop()));
             }
 
        }
        return stack.pop();
    }

    public static void main(String [] args)
    {
        String str = "( 2 ^ 3 * ( 10 / ( 5 - 3 ) ) ) ^ ( sin ( Pi ) )";
        //String str = "5 - 3";
        String [] expr = str.split(" ");
        String [] expr1 = To_OPZ(expr).split(" ");

        System.out.println(To_OPZ(expr));

        System.out.println(To_Number(expr1));
    }

}