package ua.com.zzz.dmytrokutko.pllug_calc;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calc {

    public static strictfp String eval(String expression) {
        double val;
        String res;
        try {
            Expression e = new ExpressionBuilder(expression).build();
            val = e.evaluate();
            res = String.format("%.2f", val);
        } catch (Exception e){
            res = "";
        }
        return res;
    }
}
