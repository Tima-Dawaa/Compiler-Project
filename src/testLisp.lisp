(;; Test for arithmetic expression
(* 2 3)
(+ 5 10)
(- 8 2)
(/ 9 3)
(mod 10 3)

;; Test for comparison expression
(equal 5 5)
(not-equal 3 4)
(> 10 5)
(< 2 8)
(>= 7 7)
(<= 3 3)

;; Test for logical expressions
(and t nil)
(or t nil)
(not t)

;; Test for bitwise operations
(lognor 2 3)
(logxor 1 0)
(logand 4 5)
(logeqv 1 1)
(logior 1 0)

;; Test for defining expressions
(defvar x 10)
(setq y 20)
(setq z 30 40)

;; Test for let binding
(let (x 5 y 10) (+ x y))

;; Test for prog expression
(prog (x y) (+ x y) (* x y))

;; Test for setf expression

;; Test for aref expression
(aref myArray 0)
(aref myArray 1)

(setf x 100)
(setf (car x) 10)

;; Test for push expression
(push 42 myList)
(push "hello" myList)

;; Test for pop expression
(pop myList)
(pop myList)

;; Test for make-array expression
(make-array 10)
(make-array (1 2 3))


;; Test for list expression
(list 1 2 3 4)
(list "a" "b" "c")

;; Test for nested expressions
(+ (* 2 3) (- 10 5))
)