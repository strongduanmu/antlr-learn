lexer grammar Literals;
import Alphabet;

// 清除中间变量
CLEAR
    : C L E A R
    ;

// 整数词法符号
INT
    : [0-9]+
    ;

// ID词法符号
ID
    : [a-zA-Z]+
    ;

// 换行符
NEWLINE
    : '\r'? '\n'
    ;

// 忽略空白符
WS
    : [ \t\r\n]+ -> skip
    ;

// 乘法
MUL
    : '*'
    ;

// 除法
DIV
    : '/'
    ;

// 加法
ADD
    : '+'
    ;

// 减法
SUB
    : '-'
    ;
