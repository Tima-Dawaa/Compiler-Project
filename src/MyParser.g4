parser grammar MyParser;

options { tokenVocab=MyLexer; }

program
    : S_LPARAN expression+ S_RPARAN <EOF>
    ;

// Expressions
expression
    : operators_expression
    | defining_expressions
    | setf_expression
    | push_expression
    | pop_expression
    ;

// Operator Expressions
operators_expression
    : arithmetic_expression
    | comparison_expression
    | logical_expression
    | bitwise_expression
    | make_array_expression
    | aref_expression
    | list_expression
    ;

arithmetic_expression
    : S_LPARAN
        (MULTIPLY | ADD | SUBTRACT | DIVIDE | MOD | REM | INCF | DECF)
        (INT_NUMBER | FLOAT_NUMBER | E_NUMBER | ATOM | operators_expression)+
      S_RPARAN
    ;

comparison_expression
    : S_LPARAN
        (EQUAL | NOTEQUAL | GREATER_THAN | LESS_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN_OR_EQUAL | MAX | MIN)
        (INT_NUMBER | FLOAT_NUMBER | E_NUMBER | ATOM | operators_expression)+
      S_RPARAN
    ;

logical_expression
    : S_LPARAN (not_expression | and_or_expression)+ S_RPARAN
    ;

and_or_expression
    : (AND | OR) (INT_NUMBER | T | NIL | ATOM | operators_expression)+
    ;

not_expression
    : NOT (INT_NUMBER | T | NIL | ATOM | operators_expression)
    ;

bitwise_expression
    : S_LPARAN
        (LOGNOR | LOGXOR | LOGAND | LOGEQV | LOGIOR)
        (INT_NUMBER | ATOM | operators_expression)*
      S_RPARAN
    ;

// Defining Expressions
defining_expressions
    : S_LPARAN (defvar | let | prog | setq_single_var | setq_multi_var | defconstant) S_RPARAN
    ;

defvar
    : DEFVAR tuple_without_paran
    ;

setq_single_var
    : SETQ tuple_without_paran
    ;

setq_multi_var
    : SETQ tuple_without_paran+
    ;

prog
    : PROG S_LPARAN ATOM+ S_RPARAN operators_expression*
    ;

let
    : LET S_LPARAN tuple_with_paran+ S_RPARAN operators_expression*
    ;

defconstant
    : DEFCONSTANT tuple_without_paran
    ;

// Tuple Rules
tuple_with_paran
    : S_LPARAN tuple_without_paran S_RPARAN
    ;

tuple_without_paran
    : ATOM (STRING | real_number | T | NIL | operators_expression | ATOM)
    ;

real_number
    : (INT_NUMBER | FLOAT_NUMBER | E_NUMBER)
    ;

// Setf Expression
setf_expression
    :S_LPARAN SETF place value S_RPARAN
    ;

place
    : ATOM
    | S_LPARAN CAR ATOM S_RPARAN
    | S_LPARAN CDR ATOM S_RPARAN
    | S_LPARAN AREF ATOM (real_number | ATOM)+ S_RPARAN
    | S_LPARAN GETHASH ATOM ATOM S_RPARAN
    ;

value
    : STRING
    | real_number
    | T
    | NIL
    | operators_expression
    | ATOM
    | list_expression
    ;

make_array_expression
    : S_LPARAN MAKE_ARRAY (index_list | S_LPARAN index_list S_RPARAN) S_RPARAN
    ;

aref_expression
    : S_LPARAN AREF ATOM (real_number | ATOM)+ S_RPARAN
    ;

list_expression
    : S_LPARAN LIST (value | operators_expression)+ S_RPARAN
    ;

index_list
    : real_number+
    ;

push_expression
    : S_LPARAN PUSH value (list_expression | ATOM) S_RPARAN
    ;

pop_expression
    : S_LPARAN POP (list_expression | ATOM) S_RPARAN
    ;