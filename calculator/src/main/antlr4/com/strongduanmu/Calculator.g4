grammar Calculator;
// 引入Literals词法规则
import Literals;

// 起始规则
prog
    : stat+
    ;

stat
    : CLEAR NEWLINE             # clear
    | NEWLINE                   # blank
    | expr NEWLINE              # printExpr
    | ID '=' expr NEWLINE       # assign
    ;

expr
    : expr op=('*'|'/') expr    # mulDiv
    | expr op=('+'|'-') expr    # addSub
    | INT                       # int
    | ID                        # id
    | '(' expr ')'              # parens
    ;