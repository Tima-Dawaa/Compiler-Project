parser grammar MyParser;

options { tokenVocab=MyLexer; }

// Code
program
    : S_LPARAN expression+ S_RPARAN <EOF>
    ;


// All Expressions
expression
    : operators_expression
    | defining_expressions
    | push_expression
    | pop_expression
    | condition_expression
    | conses_expression
    | equality_expression
    | special_form_expressions
    | funcall_expression
    | apply_expression
    | mapcar_expression
    | function_call_expression
    | hash_table_expressions
    | format_expression
    | defclass_expression
    | make_instance_expression
    | defmethod_expression
    | loop_expression
    ;



// Loop Expressions
loop_expression
    : loop_simple
    | loop_for
    | do_expression
    | dotimes_expression
    | dolist_expression
    ;

loop_simple
    : S_LPARAN LOOP (loop_body)? S_RPARAN
    ;

loop_for
    : S_LPARAN LOOP FOR variable from_to_clause (loop_body)? S_RPARAN
    ;

do_expression
    : S_LPARAN DO S_LPARAN variable_definitions S_RPARAN condition_clause loop_body? S_RPARAN
    ;

dotimes_expression
    : S_LPARAN DOTIMES S_LPARAN variable real_number S_RPARAN loop_body? S_RPARAN
    ;

dolist_expression
    : S_LPARAN DOLIST S_LPARAN variable list_expression S_RPARAN loop_body? S_RPARAN
    ;

variable
    : atom
    ;

variable_definitions
    : (S_LPARAN variable init_value? step_value? S_RPARAN)+
    ;

from_to_clause
    : FROM init_value TO limit_value
    ;

init_value
    : string
    | atom
    | t
    | nil
    | real_number
    | operators_expression
    | single_quote_expression
    ;

step_value
    : string
    | atom
    | t
    | nil
    | real_number
    | operators_expression
    | single_quote_expression
    ;

limit_value
    : string
    | atom
    | t
    | nil
    | real_number
    | operators_expression
    | single_quote_expression
    ;

loop_body
    : expression+
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
        (real_number | atom | operators_expression)+
      S_RPARAN
    ;

comparison_expression
    : S_LPARAN
        (EQUAL | NOTEQUAL | GREATER_THAN | LESS_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN_OR_EQUAL | MAX | MIN)
        (real_number | atom | operators_expression)+
      S_RPARAN
    ;

logical_expression
    : S_LPARAN (not_expression | and_or_expression)+ S_RPARAN
    ;

and_or_expression
    : (AND | OR) (int_number | t | nil | atom | operators_expression)+
    ;

not_expression
    : NOT (int_number | t | nil | atom | operators_expression)
    ;

bitwise_expression
    : S_LPARAN
        (LOGNOR | LOGXOR | LOGAND | LOGEQV | LOGIOR)
        (int_number | atom | operators_expression)+
      S_RPARAN
    ;


// Comparing Expressions
equality_expression
    : eq_expression
    | eql_expression
    | equal_expression
    | not_equal_expression;

eq_expression:
    S_LPARAN
        EQ
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
    S_RPARAN;

eql_expression:
    S_LPARAN
        EQL
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
    S_RPARAN;

equal_expression:
    S_LPARAN
        KEY_EQUAL
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
    S_RPARAN;

not_equal_expression:
    S_LPARAN
        NOT_EQUAL
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
        (atom | real_number | list_expression | string | t | nil | single_quote_expression)
    S_RPARAN;


// Defining Expressions
defining_expressions
    : S_LPARAN
    (
    defvar
    | let
    | prog
    | setq_single_var
    | setq_multi_var
    | setf_expression
    | defconstant
    | defun_expression
    | lambda_expression
    | defstruct_expression
    | defparameter_expression
    ) S_RPARAN
    ;

defvar
    : DEFVAR tuple_without_paran
    ;

defconstant
    : DEFCONSTANT tuple_without_paran
    ;

defstruct_expression
    : DEFSTRUCT atom+ ;

defun_expression
    : DEFUN atom parameter_list defun_body
    ;

defun_body
    : expression+
    ;

defparameter_expression
    : DEFPARAMETER atom (expression | .) string?
    ;

setf_expression
    : SETF place value
    ;

place
    : atom
    | S_LPARAN CAR atom S_RPARAN
    | S_LPARAN CDR atom S_RPARAN
    | aref_expression
    | gethash_expression
    ;

value
    : string
    | atom
    | t
    | nil
    |keyword
    | operators_expression
    | real_number
    | list_expression
    | single_quote_expression
    ;

keyword
    : COLON atom
    ;

setq_single_var
    : SETQ tuple_without_paran
    ;

setq_multi_var
    : SETQ tuple_without_paran+
    ;

prog
    : PROG S_LPARAN atom* S_RPARAN expression*
    ;

let
    : LET S_LPARAN tuple_with_paran+ S_RPARAN (expression | atom)*
    ;

// Functions Expressions
lambda_expression
    : LAMBDA parameter_list defun_body ;

parameter_list
    : S_LPARAN (atom | parameter_marker)* S_RPARAN
    ;

parameter_marker
    : optional_parameter
    | rest_parameter
    | key_parameter
    ;

optional_parameter
    : OPTIONAL (atom | S_LPARAN atom value S_RPARAN)*
    ;

rest_parameter
    : REST atom
    ;

key_parameter
    : KEY (atom | S_LPARAN atom value S_RPARAN)+
    ;


// Arrays Expression
make_array_expression
    : S_LPARAN MAKE_ARRAY ( (real_number)+ | S_LPARAN (real_number)+ S_RPARAN) S_RPARAN
    ;


aref_expression
    : S_LPARAN AREF atom (real_number | atom)+ S_RPARAN
    ;

list_expression
    : S_LPARAN LIST? (value | operators_expression)* S_RPARAN
    ;

push_expression
    : S_LPARAN PUSH value (list_expression | atom) S_RPARAN
    ;

pop_expression
    : S_LPARAN POP (list_expression | atom) S_RPARAN
    ;


// Conditions Expressions
condition_expression
       : if_expression
       | when_expression
       | cond_expression
       | progn_expression
       | unless_expression
       ;

condition_clause
    : comparison_expression
    | logical_expression
    | bitwise_expression
    | OTHERWISE
    | string
    | atom
    ;

if_expression
    : S_LPARAN IF condition_clause (atom | expression) (atom | expression)? S_RPARAN
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


// Special form Expressions
special_form_expressions
        : quote_expression | single_quote_expression
        ;

quote_expression
        : S_LPARAN QUOTE (atom | list_expression) S_RPARAN
        ;

single_quote_expression
        : SINGLE_QUOTE (atom | list_expression |  S_LPARAN lambda_expression S_RPARAN)
        ;


// Funcall, Apply, Mapcar Expressions
funcall_expression
    : S_LPARAN FUNCALL function_name function_call_parameter* S_RPARAN ;

apply_expression
    : S_LPARAN APPLY function_name (SINGLE_QUOTE list_expression | atom+) S_RPARAN;

mapcar_expression
    : S_LPARAN MAPCAR function_name (SINGLE_QUOTE list_expression | function_call_parameter)+ S_RPARAN;

function_name
    : (
    atom
    | HASH SINGLE_QUOTE built_in_functions
    | function_call_expression
    | S_LPARAN lambda_expression S_RPARAN
    );

function_call_expression
    : S_LPARAN atom function_call_parameter* S_RPARAN;

function_call_parameter
    : string
    | COLON atom
    | atom
    | t
    | nil
    | single_quote_expression
    | S_LPARAN lambda_expression S_RPARAN
    | real_number
    ;

built_in_functions
    : ~(STRING | OPTIONAL | KEY | REST | HASH | SINGLE_QUOTE | QUOTE
    | COMMA | T | NIL | S_LPARAN | S_RPARAN | INT_NUMBER | FLOAT_NUMBER | E_NUMBER);


// Hash Table Experssions
hash_table_expressions
    : make_hash_table_expression
    | gethash_expression
    | remhash_expression
    | clrhash_expression
    | maphash_expression
    ;

make_hash_table_expression
    : S_LPARAN MAKE_HASH_TABLE (key_argument | size_function | test_function | hash_function)* S_RPARAN ;

key_argument
    : KEY key value ;

size_function
    : COLON SIZE real_number ;

test_function
    : COLON TEST
    ( QUOTE_EQ
    | QUOTE_EQL
    | QUOTE_EQUAL
    | S_LPARAN lambda_expression S_RPARAN
    | atom )
    ;

hash_function
    : COLON HASH_FUNCTION (S_LPARAN lambda_expression S_RPARAN | atom)
    ;

gethash_expression
    : S_LPARAN GETHASH key atom S_RPARAN
    ;

remhash_expression
    : S_LPARAN REMHASH key atom S_RPARAN
    ;

clrhash_expression
    : S_LPARAN CLRHASH atom S_RPARAN
    ;

maphash_expression
    : S_LPARAN MAPHASH S_LPARAN lambda_expression S_RPARAN atom S_RPARAN
    ;

key
    : atom | string | real_number | operators_expression ;


// Format expression
format_expression
        : S_LPARAN
            FORMAT FORMAT_DESTINATION FORMAT_STRING_BEGIN (FORMAT_STRING | FORMAT_OPTION)* FORMAT_STRING_END (value | expression)*
          S_RPARAN
        ;


// Class Expression
defclass_expression
    : S_LPARAN DEFCLASS class_name parameters* S_RPARAN ;

class_name
    : atom S_LPARAN (atom)* S_RPARAN ;

parameters
    : S_LPARAN parameters_options+ S_RPARAN ;

parameters_options
    : S_LPARAN atom (initarg_expression)? (initform_expression)? (accessor_expression)? S_RPARAN
    ;
initform_expression
    : COLON INITFORM (string|real_number) ;

initarg_expression
    : COLON INITARG COLON atom ;

accessor_expression
    : COLON ACCESSOR atom ;

defmethod_expression
    : S_LPARAN
      DEFMETHOD atom
      S_LPARAN defmethod_parameters+ S_RPARAN
      expression
      S_RPARAN;

defmethod_parameters
    : S_LPARAN
      (atom atom | )
      S_RPARAN;


// Make-Instance Expression
make_instance_expression
     : S_LPARAN MAKE_INSTANCE atom (initialization_argument)* S_RPARAN
     ;

initialization_argument
     : COLON atom value
     ;

// Helpers
tuple_with_paran
    : S_LPARAN tuple_without_paran S_RPARAN
    ;

tuple_without_paran
    : atom (HASH SINGLE_QUOTE built_in_functions | string | real_number | t | nil | expression | atom)
    ;

real_number
    : (int_number | float_number | e_number)
    ;
    
atom : ATOM;
string: STRING;
int_number: INT_NUMBER;
float_number: FLOAT_NUMBER;
e_number: E_NUMBER;
t: T;
nil: NIL;
