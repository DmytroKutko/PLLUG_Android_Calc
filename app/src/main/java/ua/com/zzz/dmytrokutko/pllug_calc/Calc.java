package ua.com.zzz.dmytrokutko.pllug_calc;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calc {

    public static strictfp String eval(String expression) {
        double val;
        String res;
        try {
            Expression e = new ExpressionBuilder(expression).build();
            val = e.evaluate();
            val = new BigDecimal(val).setScale(2, RoundingMode.UP).doubleValue();
            res = String.valueOf(val);
        } catch (Exception e){
            res = "";
        }
        return res;
    }
}
