package ast;

public class UnaryExpr extends Expr {

    public static final int MINUS = 1;

    final Expr expr;
    final int operator;


    public UnaryExpr(Expr expr, int operator, Location loc) {
        super(loc);
        this.expr = expr;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
        String s = null;
        switch (operator) {
            case MINUS:  s = "-"; break;

        }
        return s + " " + expr;
    }

    @Override
    Object eval() {
        return doOperation(expr.eval(), operator);
    }

    static Object doOperation(Object value, int operator) {
        switch (operator) {
            case MINUS:  return -(long)value;
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
