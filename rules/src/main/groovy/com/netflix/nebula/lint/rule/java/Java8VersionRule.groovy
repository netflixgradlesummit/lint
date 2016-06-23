package com.netflix.nebula.lint.rule.java

import com.netflix.nebula.lint.rule.GradleLintRule
import org.codehaus.groovy.ast.expr.BinaryExpression
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.expr.VariableExpression

class Java8VersionRule extends GradleLintRule {
    String description = 'upgrade to Java 8'

    @Override
    void visitBinaryExpression(BinaryExpression expression) {
        if(expression.leftExpression instanceof VariableExpression && expression.rightExpression instanceof ConstantExpression) {
            def variable = expression.leftExpression.text
            if(variable == 'sourceCompatibility' || variable == 'targetCompatibility') {
                if(expression.rightExpression.text != '1.8') {
                    addBuildLintViolation('upgrade to java 8', expression)
                        .replaceWith(expression, "$variable = '1.8'")
                }
            }
        }
    }
}
