// 语法文件通常以grammar开头，名称必须和文件名一致
grammar ArrayInit;

// init规格，匹配一对花括号，以及其中逗号分隔的value
init
    : '{' value (',' value)* '}'
    ;

// value可以嵌套的花括号结构，也可以是简单的整数，即INT词法符号
value
    : init
    | INT
    ;

// 整数词法符号
INT
    : [0-9]+
    ;

// 忽略空白符
WS
    : [ \t\r\n]+ -> skip
    ;