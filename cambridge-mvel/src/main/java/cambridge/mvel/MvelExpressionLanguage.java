package cambridge.mvel;

import cambridge.ExpressionLanguage;
import cambridge.ExpressionParsingException;
import cambridge.Expressions;
import cambridge.model.Expression;
import org.mvel2.MVEL;

import java.io.Serializable;

/**
 * @author Erdinc YILMAZEL
 * @since 2/1/11
 */
public class MvelExpressionLanguage implements ExpressionLanguage {
   public static void register() {
      Expressions.registerExpressionLanguage("mvel", MvelExpressionLanguage.class);
   }

   public Expression parse(String value) throws ExpressionParsingException {
      Serializable compiledExpression = MVEL.compileExpression(value);

      return new MVELExpression(compiledExpression, value);
   }

   public String wrapExpressionAsList(String expr) {
      return "[" + expr + "]";
   }
}