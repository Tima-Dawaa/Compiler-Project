(
;; Test for arithmetic expression
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

;; Test for aref expression
(aref myArray 0)
(aref myArray 1)

;; Test for setf expression
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

;; Test for if expression
(if (> 2 1)
        (print "2 is greater than 1")
        (print "2 is not greater than 1"))
(if (and (> 3 2) (< 5 10))
    (print "Both conditions are true")
    (print "One or both conditions are false"))
(if (> 3 2)
    (progn
      (print "Condition is true")
      (print "Doing more work..."))
    (progn
      (print "Condition is false")
      (print "Exiting...")))

;; Test for when expression
(when (> 3 2)
  (when (and (> 3 2) (< 5 10))
    (print "Both conditions are true")
    (print "This will also execute if the condition is true")))
(when (> 3 2)
  (progn
    (print "Condition is true")
    (print "Executing multiple statements...")))

;; Test for cond expression
(cond
  ((> 3 2)
   (cond
     ((> 5 4) (print "3 > 2 and 5 > 4"))
     ((< 5 4) (print "3 > 2 and 5 < 4"))))
  (t
   (print "This is the default case")
   (print "Executing multiple statements..."))
  (otherwise (print "This is the default case")))

;; Test for conses expression
(cons 'x 'y)
(cons 1 2)
(cons 1 '(2 3 4))
(cons 'a '(b c))
(cons 'x (cons 'y 'z))
(cons 1 (cons 2 (cons 3 4)))
(car (cons 1 2))
(cdr (cons 1 2))
(cons 'a (append '(b c) '(d e)))

)