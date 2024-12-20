lexer grammar MyLexer;

// Basics
STRING: '"' (ESCAPE | ~["\\] )* '"';
ATOM: (ALPHA | DIGIT | SYMBOL)+;
WS: [ \t\r\n]+ -> skip;
SINGLE_LINE_COMMENT: ';'.*?[\r\n] -> skip;
MULTI_LINE_COMMENT: '#|'.*?'|#' -> skip;

// Numbers
NORMAL_NUMBER : POSITIVE;
INT_NUMBER: NUMBER;
E_NUMBER: (INT_NUMBER | FLOAT_NUMBER) 'e' NUMBER;
FLOAT_NUMBER: NUMBER'.'[0-9]+;
Complex: '#c';
//'(' WS? (E_NUMBER | FLOAT_NUMBER | INT_NUMBER) WS+ (E_NUMBER | FLOAT_NUMBER | INT_NUMBER) WS? ')';

// Defining
DEFUN   : 'defun';
DEFVAR  : 'defvar';
DEFCONSTANT: 'defconstant';
DEFSTRUCT : 'defstruct';
DEFMACRO: 'defmacro';
DEFPARAMETER: 'defparameter';
SETQ    : 'setq';
SETF: 'setf';
LET     : 'let';

// Symbols
S_LPARAN: '(';
S_RPARAN: ')';
SINGLE_QUOTE: ['];
COMMA : [,];
EQUAL                 : '=';
NOTEQUAL              : '/=';
GREATER_THAN          : '>';
LESS_THAN             : '<';
GREATER_THAN_OR_EQUAL : '>=';
LESS_THAN_OR_EQUAL    : '<=';
ADD: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
HASH       : '#';
COLON: ':';

// Conditions
IF      : 'if';
WHEN    : 'when';
COND    : 'cond';
OTHERWISE  : 'otherwise';
PROGN: 'progn';
UNLESS  : 'unless';

// Logical
AND     : 'and';
OR      : 'or';
NOT     : 'not';
T       : 't';
NIL     : 'nil';

// Loops
FROM : 'from';
TO : 'to';
COLLECT : 'collect';
DO : 'do';
DOTimes : 'dotimes';
DOLIST : 'dolist';
LOOP  : 'loop';
PROG : 'prog';
FOR : 'for';

// Keywords
BLOCK : 'block';
ERROR : 'error';
EXP : 'exp';
EXPT  : 'expt';
MAX : 'max';
MIN  : 'min';
MOD : 'mod';
REM : 'rem';
QUOTE: 'quote';

// Equality
EQ : 'eq';
EQL : 'eql';
KEY_EQUAL : 'equal';
NOT_EQUAL : 'not-equal';

// Arrays
MAKE_ARRAY: 'make-array';
AREF    : 'aref';
LIST:'list';
PUSH    : 'push';
POP     : 'pop';
SORT: 'sort';
INCF: 'incf';
DECF: 'decf';

// Hash Table
MAKE_HASH_TABLE: 'make-hash-table';
HASH_FUNCTION : 'hash-function';
TEST : 'test';
SIZE : 'size';
GETHASH:'gethash';
MAPHASH : 'maphash';
REMHASH : 'remhash';
CLRHASH : 'clrhash';

// Gates
LOGNOR: 'lognor';
LOGXOR: 'logxor';
LOGAND: 'logand';
LOGEQV: 'logeqv';
LOGIOR: 'logior';

// Args
OPTIONAL   : '&optional';
REST       : '&rest';
KEY: '&key';

// Functions
FUNCTION: 'function';
RETURN: 'return';
RETURN_FROM: 'return_from';
LAMBDA  : 'lambda';
MAPCAR     : 'mapcar';
APPLY   : 'apply';
FUNCALL: 'funcall';

// Conses
CONS    : 'cons';
CAR: 'car';
CDR: 'cdr';

// Fragment
fragment NUMBER: [-+]?[0-9]+;
fragment DIGIT: [0-9];
fragment POSITIVE : [1-9];
fragment ALPHA: [a-zA-Z];
fragment SYMBOL: [!#$%&*+/=?^_`'{|}~.-];
fragment ESCAPE: '\\' [bfnrt"'\\];

// Error
LEXER_ERROR: . -> channel(HIDDEN);

// Format
FORMAT: 'format' -> pushMode(FORMAT_MODE);

mode FORMAT_MODE;
FORMAT_DESTINATION: (T | NIL);
FORMAT_STRING_BEGIN: '"' -> pushMode(FORMAT_STRING_MODE);
FORMAT_WS: WS -> skip;

mode FORMAT_STRING_MODE;
FORMAT_OPTION: '~'[0-9]*[aAsSdDfFeE%&nNtT^];
FORMAT_STRING: (ESCAPE | ~["\\~])+;
FORMAT_STRING_END: '"' -> popMode, popMode;
FORMAT_STRING_WS: WS -> skip;