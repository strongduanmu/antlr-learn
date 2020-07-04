package com.strongduanmu;

import com.strongduanmu.listener.Short2UnicodeListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Desc: 数组初始化Test类
 * Date: 2020/6/29
 *
 * @author duanzhengqiang
 */
public class ArrayInitTest {

    @Test
    public void testArrayInitParse() {
        // 已过时：ANTLRInputStream inputStream = new ANTLRInputStream();
        // 字符流
        CharStream charStream = CharStreams.fromString("{1, 2, 3, 19}");
        // 词法分析器拆分词法符号
        ArrayInitLexer lexer = new ArrayInitLexer(charStream);
        // 词法符号存储到tokenStream中
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        // 语法解析器接受词法符号，构建AST
        ArrayInitParser parser = new ArrayInitParser(tokenStream);
        // 语法解析
        ParseTree tree = parser.init();
        System.out.println(tree.toStringTree());
        // 创建语法树遍历器
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Short2UnicodeListener(), tree);
        System.out.println();
    }
}
