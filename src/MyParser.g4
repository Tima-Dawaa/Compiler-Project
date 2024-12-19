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
    | condition_expression
    | conses_expression
    | equality_expression
    | special_form_expressions
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

equality_expression
    : eq_expression
    | eql_expression
    | equal_expression
    | not_equal_expression;


eq_expression:
    S_LPARAN
        EQ
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
    S_RPARAN;

eql_expression:
    S_LPARAN
        EQL
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
    S_RPARAN;

equal_expression:
    S_LPARAN
        KEY_EQUAL
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
    S_RPARAN;

not_equal_expression:
    S_LPARAN
        NOT_EQUAL
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
        SINGLE_QUOTE?
        (ATOM | real_number | list_expression | STRING | T | NIL)
    S_RPARAN;

// Defining Expressions
defining_expressions
    : S_LPARAN (defvar | let | prog | setq_single_var | setq_multi_var | defconstant|defun_expression) S_RPARAN
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
    : PROG S_LPARAN ATOM* S_RPARAN expression*
    ;

let
    : LET S_LPARAN tuple_with_paran+ S_RPARAN expression*
    ;

defconstant
    : DEFCONSTANT tuple_without_paran
    ;

// Tuple Rules
tuple_with_paran
    : S_LPARAN tuple_without_paran S_RPARAN
    ;

tuple_without_paran
    : ATOM (STRING | real_number | T | NIL | expression | ATOM)
    ;

defun_expression
:DEFUN ATOM parameter_list? defun_body;

parameter_list
:S_LPARAN ( parameter |parameter_marker )* S_RPARAN;

 parameter
:ATOM;

 parameter_marker
 :OPTIONAL parameter*
 | KEY parameter*;

 defun_body
:expression+;

real_number
    : (INT_NUMBER | FLOAT_NUMBER | E_NUMBER)
    ;

// Arrays Expression
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

index_list
    : real_number+
    ;

aref_expression
    : S_LPARAN AREF ATOM (real_number | ATOM)+ S_RPARAN
    ;

list_expression
    : S_LPARAN LIST? (value | operators_expression)+ S_RPARAN
    ;

push_expression
    : S_LPARAN PUSH value (list_expression | ATOM) S_RPARAN
    ;

pop_expression
    : S_LPARAN POP (list_expression | ATOM) S_RPARAN
    ;


// Conditions Expressions
condition_expression
       : if_expression
       | when_expression
       | cond_expression
       | progn_expression
       | otherwise_expression
       | unless_expression
       ;

condition_clause
    : comparison_expression
    | logical_expression
    | bitwise_expression
    ;

if_expression
    : S_LPARAN IF condition_clause expression expression? S_RPARAN
    ;

when_expression
    : S_LPARAN WHEN condition_clause expression+ S_RPARAN
    ;

cond_expression
    : S_LPARAN COND cond_clause+ S_RPARAN
    ;

cond_clause
    : S_LPARAN condition_clause expression+ S_RPARAN
    ;

progn_expression
    : S_LPARAN PROGN expression+ S_RPARAN
    ;

otherwise_expression
    : OTHERWISE expression+
    ;

unless_expression
    : S_LPARAN UNLESS condition_clause expression+ S_RPARAN
    ;


// Coses Expressions
conses_expression
       : cons_expression
       | car_expression
       | cdr_expression
       ;

cons_expression
    : S_LPARAN CONS expression expression S_RPARAN
    ;

car_expression
    : S_LPARAN CAR cons_expression S_RPARAN
    ;

cdr_expression
    : S_LPARAN CDR cons_expression S_RPARAN
    ;

// Special form
special_form_expressions
        : quote_expression | single_quote_expression
        ;

quote_expression
        : S_LPARAN QUOTE (ATOM | list_expression) S_RPARAN
        ;

single_quote_expression
        : SINGLE_QUOTE (ATOM | list_expression)
        ;