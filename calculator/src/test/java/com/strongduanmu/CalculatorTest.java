package com.strongduanmu;

import com.strongduanmu.visitor.CalculatorEvalVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * Desc: 计算器程序测试类
 * Date: 2020/7/4
 *
 * @author duanzhengqiang
 */
public class CalculatorTest {

    @Test
    public void testCalculatorVisitor() throws IOException {
        InputStream inputStream = CalculatorTest.class.getClassLoader().getResourceAsStream("calculator_test.txt");
        // 字符流
        CharStream charStream = CharStreams.fromStream(Objects.requireNonNull(inputStream));
        // 词法分析器拆分词法符号
        CalculatorLexer lexer = new CalculatorLexer(charStream);
        // 词法符号存储到tokenStream中
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        // 语法解析器接受词法符号，构建AST
        CalculatorParser parser = new CalculatorParser(commonTokenStream);
        // 语法解析
        ParseTree parseTree = parser.prog();
        // 创建语法树访问器执行计算器逻辑
        CalculatorEvalVisitor visitor = new CalculatorEvalVisitor();
        visitor.visit(parseTree);
    }
}
