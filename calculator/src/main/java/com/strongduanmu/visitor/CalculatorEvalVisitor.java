package com.strongduanmu.visitor;

import com.strongduanmu.CalculatorBaseVisitor;
import com.strongduanmu.CalculatorParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: Calculator访问器
 * Date: 2020/7/4
 *
 * @author duanzhengqiang
 */
public class CalculatorEvalVisitor extends CalculatorBaseVisitor<Integer> {

    /**
     * 计算器程序中间变量存储
     */
    private final Map<String, Integer> calculatorMemory = new HashMap<>();

    /**
     * 解析 expr NEWLINE 规则
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitPrintExpr(CalculatorParser.PrintExprContext ctx) {
        // 解析expr子节点的值
        Integer value = visit(ctx.expr());
        // 打印结果并返回一个假值
        System.out.println(value);
        return 0;
    }

    /**
     * 解析 ID '=' expr NEWLINE 规则
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitAssign(CalculatorParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        // 解析expr子节点的值
        Integer value = visit(ctx.expr());
        calculatorMemory.put(id, value);
        return 0;
    }

    /**
     * 解析 NEWLINE
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitBlank(CalculatorParser.BlankContext ctx) {
        System.out.println();
        return 0;
    }

    /**
     * 解析 CLEAR
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitClear(CalculatorParser.ClearContext ctx) {
        calculatorMemory.clear();
        System.out.println("clear success!");
        return 0;
    }

    /**
     * 解析 expr ('*'|'/') expr 规则
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitMulDiv(CalculatorParser.MulDivContext ctx) {
        Integer leftValue = visit(ctx.expr(0));
        Integer rightValue = visit(ctx.expr(1));
        // 判断操作符控制乘除法
        if (ctx.op.getType() == CalculatorParser.MUL) {
            return leftValue * rightValue;
        }
        return leftValue / rightValue;
    }

    /**
     * 解析 expr op=('+'|'-') expr 规则
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitAddSub(CalculatorParser.AddSubContext ctx) {
        Integer leftValue = visit(ctx.expr(0));
        Integer rightValue = visit(ctx.expr(1));
        // 判断操作符控制加减法
        if (ctx.op.getType() == CalculatorParser.ADD) {
            return leftValue + rightValue;
        }
        return leftValue - rightValue;
    }

    /**
     * 解析 INT
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitInt(CalculatorParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    /**
     * 解析 ID
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitId(CalculatorParser.IdContext ctx) {
        // 获取中间存储的变量
        String id = ctx.ID().getText();
        return calculatorMemory.getOrDefault(id, 0);
    }

    /**
     * 解析 '(' expr ')' 规则
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitParens(CalculatorParser.ParensContext ctx) {
        // 返回子表达式的值
        return visit(ctx.expr());
    }
}
