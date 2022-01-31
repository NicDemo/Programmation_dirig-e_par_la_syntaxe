lexer grammar VSLLexer;

options {
  language = Java;
}

@header {
  package TP2;
}

WS : (' '|'\n'|'\t') -> skip
   ;

COMMENT : '//' (~'\n')* -> skip
        ;

fragment LETTER : 'a'..'z' ;
fragment DIGIT  : '0'..'9' ;
fragment ASCII  : ~('\n'|'"');

// keywords
LP    : '(' ; // Left parenthesis
RP    : ')' ;
PLUS      : '+'      ;
VIRGULE : ',';

// TODO : other keywords
SUB : '-' ;
MUL :'*';
DIV :'/';
IF : 'IF';
ELSE : 'ELSE';
FI:'FI';
THEN : 'THEN';

AFFECT : ':=';
ACCOLADE_OUVERT : '{';
ACCOLADE_FERME : '}';
WHILE : 'WHILE';
DO : 'DO';
DONE : 'DONE';


// other tokens (no conflict with keywords in VSL)
IDENT   : LETTER (LETTER|DIGIT)*;
TEXT    : '"' (ASCII)* '"' { setText(getText().substring(1, getText().length() - 1)); };
INTEGER : (DIGIT)+ ;
INT_DECLARATION : 'INT';
