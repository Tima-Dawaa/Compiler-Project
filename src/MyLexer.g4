lexer grammar MyLexer;

OPTIONAL   : '&optional';
REST       : '&rest';
OTHERWISE  : 'otherwise';
BLOCK      : 'block';
ERROR	   : 'error';
MAPCAR     : 'mapcar';
HASH       : '#';
EQL        : 'eql';
DEFPARAMETER: 'defparameter';
//
RETURN: 'return';
RETURN_FROM: 'return_from';
FUNCALL: 'funcall';
KEY_EQUAL: 'equal';
PROGN: 'progn';
KEY: '&key';

//
CAR: 'car';
CDR: 'cdr';
SETF: 'setf';
INCF: 'incf';
DECF: 'decf';
DEFMACRO: 'defmacro';
MAKE_HASH_TABLE: 'make-hash-table';
GETHASH:'gethash';

//
EXP     : 'exp';
EXPT    : 'expt';
CONS    : 'cons';
PUSH    : 'push';
POP     : 'pop';
AREF    : 'aref';
APPLY   : 'apply';
UNLESS  : 'unless';

//
SORT: 'sort';
FUNCTION: 'function';
QUOTE: 'quote';
COLON: ':';
EQ: 'eq';
DOLIST: 'dolist';
MAKE_ARRAY: 'make-array';
FORMAT: 'format' -> pushMode(FORMAT_MODE);
//Keywords and operators
DO                    : 'do';
DOTimes               : 'dotimes';
EQUAL                 : '=';
NOTEQUAL              : '/=';
GREATER_THAN          : '>';
LESS_THAN             : '<';
GREATER_THAN_OR_EQUAL : '>=';
LESS_THAN_OR_EQUAL    : '<=';
MAX                   : 'max';
MIN                   : 'min';

ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';

IF      : 'if';
WHEN    : 'when';
COND    : 'cond';
AND     : 'and';
OR      : 'or';
NOT     : 'not';
T       : 't';
NIL     : 'nil';

DEFUN   : 'defun';
DEFVAR  : 'defvar';
SETQ    : 'setq';
LET     : 'let';
LOOP    : 'loop';
PROG    : 'prog';
FOR     : 'for';
DEFCONSTANT: 'defconstant';
LAMBDA  : 'lambda';
LIST:'list';

//keyword gor for loop work
FROM    : 'from';
TO      : 'to';
COLLECT : 'collect';

S_LPARAN: '(';
S_RPARAN: ')';
SINGLE_QUOTE: ['];
COMMA : [,];

MOD: 'mod';
REM: 'rem';


LOGNOR: 'lognor';
LOGXOR: 'logxor';
LOGAND: 'logand';
LOGEQV: 'logeqv';
LOGIOR: 'logior';

//Number
INT_NUMBER: NUMBER;
E_NUMBER: (INT_NUMBER | FLOAT_NUMBER) 'e' NUMBER;
FLOAT_NUMBER: NUMBER'.'[0-9]+;

//Complex: '#c' '(' WS? (E_NUMBER | FLOAT_NUMBER | INT_NUMBER) WS+ (E_NUMBER | FLOAT_NUMBER | INT_NUMBER) WS? ')';
Complex: '#c';

//Comments
SINGLE_LINE_COMMENT: ';'.*?[\r\n] -> skip;
MULTI_LINE_COMMENT: '#|'.*?'|#' -> skip;

//Identifiers
//String literals
STRING: '"' (ESCAPE | ~["\\] )* '"';

ATOM: (ALPHA | DIGIT | SYMBOL)+;
//WhiteSpace
WS: [ \t\r\n]+ -> skip;

//Fragment
fragment NUMBER: [-+]?[0-9]+;
fragment DIGIT: [0-9];
fragment ALPHA: [a-zA-Z];
fragment SYMBOL: [!#$%&*+/=?^_`{|}~.-];
fragment ESCAPE: '\\' [bfnrt"'\\];

//Identifiers

LEXER_ERROR: . -> channel(HIDDEN);

mode FORMAT_MODE;
FORMAT_DESTINATION: (T | NIL);
FORMAT_STRING_BEGIN: '"' -> pushMode(FORMAT_STRING_MODE);
FORMAT_WS: WS -> skip;

mode FORMAT_STRING_MODE;
FORMAT_OPTION: '~'[asdfe%&n];
FORMAT_STRING: (ESCAPE | ~["\\~])+;
FORMAT_STRING_END: '"' -> popMode, popMode;
FORMAT_STRING_WS: WS -> skip;