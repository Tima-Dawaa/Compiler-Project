# Lisp Compiler Project

## Overview
This project is a **compiler for Lisp language**, developed in Java using **ANTLR4**.  
The work focuses on the first three stages of the compiler workflow:

1. **Lexical Analysis** – tokenizing source code using ANTLR lexer rules.  
2. **Parsing** – generating a parse tree with ANTLR parser rules.  
3. **AST Construction & Semantic Checks** – building an **Abstract Syntax Tree (AST)** and performing basic semantic validation.  

This implementation does **not** include code generation or optimization, since the project scope was limited to the initial phases of compilation.

---

## Features
- **Language constructs supported**:
  - Definitions: `defun`, `defvar`, `defconstant`, `defstruct`, `defclass`, `defmethod`, `setq`, `setf`, `let`, etc.  
  - Control flow: `if`, `cond`, `when`, `unless`, `progn`, `loop`, `dotimes`, `dolist`, `do`.  
  - Operators: arithmetic (`+`, `-`, `*`, `/`, `mod`, `rem`), comparisons (`=`, `<`, `>`, `<=`, `>=`), logical (`and`, `or`, `not`), bitwise (`logand`, `logxor`, etc.).  
  - Data structures: lists, arrays (`make-array`, `aref`), hash tables (`make-hash-table`, `gethash`, `maphash`, etc.).  
  - Functions: lambdas, higher-order calls (`funcall`, `apply`, `mapcar`).  
  - Object system: `defclass`, `make-instance`, accessors, initialization arguments.  
  - Special forms: quoting (`quote`, `'expr`), formatted printing with `format`.  

- **AST Representation**:
  - Each language construct is represented as a dedicated AST node class (e.g., `DefunNode`, `IfNode`, `LoopNode`, `FuncallNode`).  
  - The visitor pattern (`ASTBuilder`) maps parse tree nodes into AST nodes.  
  - The AST can be pretty-printed for inspection.  

- **Semantic Checks**:
  - Basic checks on function definitions, variable usage, and expressions.  
  - Reports semantic errors (if found) after AST construction.

---

## Project Structure
```
Compiler-Project/
├── gen/                 # ANTLR-generated lexer & parser classes
├── src/
│   ├── expression/      # AST node classes (IfNode, DefunNode, LoopNode, etc.)
│   ├── ASTBuilder.java  # Visitor for building AST
│   ├── LexerTest.java   # Entry point (parses file & builds AST)
│   ├── MyLexer.g4       # Lexer grammar
│   ├── MyParser.g4      # Parser grammar
│   └── TreePrinter.java # Parse tree printer utility
└── README.md
```

---

## Scope and Limitations
- Implements **lexical analysis**, **parsing**, and **AST construction with semantic checks**.  
- Does not include **code generation** or **optimization** phases.  
- Designed primarily as a **college project** to demonstrate understanding of compiler design using ANTLR.  

---

## license
- MIT License
