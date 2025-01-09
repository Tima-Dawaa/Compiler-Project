(
    ;; arithmetic_expression
    (+ 4 5)
    (- 9 0)
    (* x 10)
    (/ 9.5 2)
    (mod 33 10e5)
    (rem 7.44 y)
    (incf x 1)
    (decf y 2)

    ;; comparison_expression
    (= 10 20)
    (/= 10 10)
    (< 12 10)
    (> 3e5 10)
    (<= x 109)
    (>= y z)
    (max 10e4 -199.4)
    (min -5.7 10)

    ;; logical_expression
    (and 10 20)
    (or x y)
    (and 3 t)
    (or nil -4)
    (not 1)
    (not t)
    (not x)

    ;; bitwise_expression
    (logor x 3)
    (logxor x y)
    (logand 5 3)
    (logeqv -2 4)
    (logior 5 z)

    ;; make_array_expression
    (make-array 5 3 2 1)
    (make-array (5 3 2 1))

    ;; aref_expression
    (aref x 4 5 6 q w e)

    ;; list_expression
    (list x y z)
    (x y z)

    ;; push_expression & pop_expression
    (push 5 (3 4 6 7))
    (pop x)

    ;; if_expression
    (if (= 5 10) x y)
    (if (= 5 10) x)

    ;; when_expression
    (when (>= 4 4)
        (and 10 20)
        (or x y)
        (and 3 t)
    )

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
     (T
       (print "This is the default case")
       (print "Executing multiple statements..."))
     (otherwise (print "This is the default case"))
   )


    (aref myArray 0)
    (aref myArray 1)

    (setf x 100)
    (setf (car x) 10)

    (push 42 myList)
    (push "hello" myList)

    (pop myList)
    (pop myList)

    (make-array 10)
    (make-array (1 2 3))


    (list 1 2 3 4)
    (list "a" "b" "c")

    (+ (* 2 3) (- 10 5))

    ; testing defvar
        (defvar x 42)
        (defvar y t)
        (defvar z nil)
        (defvar float_number 34.45)
        (defvar e_number 13e18)
        (defvar add_number (+ 5 8))
        (defvar sub_number (- 5.5 8e10))
        (defvar or_number (or 4 10))
        (defvar mult_number (* 5 6))
        (defvar log_num (logand 10 12))
        (defvar greeting "Hello, World!")

        ; testing setq_single_var
        (setq my-string "Hello, World!")
        (setq my-number 42)
        (setq my-float 3.14)
        (setq my-boolean t)
        (setq my-null nil)
        (setq my-constant 6.626e-34)
        (setq z (+ 3 12))
        (setq greet "Hello All")
        (setq my-variable (+ my-variable 5))
        (setq my-list (1 2 3 4 5))
        (setq my-variable (* 2 3))

        ; testing setq_multi_var
        (setq x 42
              y 10
              z 18)
        (setq greet "hello"
                  how "good"
                  end "bye")
        (setq a 5
              b 10
              c (+ a b))
        (setq first-name "John"
              last-name "Doe"
              full-name ("John Doe"))  ; full-name is "John Doe"

        ; testing prog

        ; testing let
        (let ((x 10)
              (y 20))
          (+ x y))
        (let ((a 3)) (+ a 1))
        (let ((a 2))
          (let ((b 3))
            (+ a b)))
        (let ((a 1)
              (b 2)
              (c 3))
          (+ a b c))  ; This will return 6
        (let ((x (+ 1 2))
              (y (* 3 4)))
          (* x y))  ; This will return 60

        ; testing defconstant
        (defconstant +pi+ 3.141592653589793)
        (defconstant *max-connection-attempts* 5)
        (defconstant *default-timeout* 30.0)
        (defconstant *welcome-message* "Welcome to the application!")

    (defun my-func (a b &optional c &key d e) (+ a b c d e))
    (defun my-func (a b c)
      (+ a b c))

    (defun my-func (a &optional b c)
      (+ a b c))

    (defun my-func (&key x y)
      (+ x y))

;; Test Hash
(defparameter *my-hash-table* (make-hash-table))
(setf (gethash 'key1 *my-hash-table*) 'value1)
(setf (gethash "string-key" *my-hash-table*) 'string-value)
(setf (gethash 42 *my-hash-table*) 'numeric-value)
(gethash 'key1 *my-hash-table*)

(defparameter *basic-hash-table* (make-hash-table))
(defparameter *sized-hash-table* (make-hash-table : size 100))
(defparameter *eq-hash-table* (make-hash-table : test 'eq))

(setf (gethash 'key1 *basic-hash-table*) 'value1)
(setf (gethash 'key2 *basic-hash-table*) 'value2)
(setf (gethash 'key3 *sized-hash-table*) 'value3)
(setf (gethash 'key4 *eq-hash-table*) 'value4)

(remhash 'key1 *basic-hash-table*)
(maphash (lambda (key value)
           (format t "Key: ~a, Value: ~a~%" key value))
         *basic-hash-table*)
(clrhash *basic-hash-table*)

(defun custom-test-func (x y)
  (string= (symbol-name x) (symbol-name y)))
(defun custom-hash-func (x)
  (sxhash (symbol-name x)))

(setf (gethash 'key5 *custom-hash-table*) 'value5)
(setf (gethash 'key4 *custom-hash-table*) 'value4)

(format t "Keys: ~a~%" (hash-table-keys *sized-hash-table*))
(format t "Values: ~a~%" (hash-table-values *sized-hash-table*))

(defstruct person name age)

    (make-instance 'my-class :slot1 "value1" :slot2 42)
    ;; Example: Create an instance of the class 'person' with specific initialization arguments
    (make-instance 'person :name "John Doe" :age 30 :address "123 Elm Street")

    ;; Another example: Create an instance of the class 'vehicle' with fewer arguments
    (make-instance 'vehicle :type "Car" :model "Toyota")

    ;; Example with no initialization arguments
    (make-instance 'empty-class)

    (defclass person ()
      ((name : initarg :name :accessor person-name)
       (age : initarg :age :accessor person-age)))

    (defclass student (person)
      ((student-id : initarg : student-id : accessor student-id)))

    (format t "Name: ~a~%" (person-name *person-instance*))
    (format t "Age: ~a~%" (person-age *person-instance*))


    (format t "The number is ~d." 42)  ; Outputs: The number is 42.
    (format t "Hello,~%World!")  ; Outputs: Hello, World!
    (format t "Hello, World!")  ; Outputs: Hello, World!
    (format t "Pi is approximately ~f." 3.14159)  ; Outputs: Pi is approximately 3.141590.
    (format t "The result is ~a." (* 3 14))  ; Outputs: The result is 42.
    (format t "Name: ~a, Age: ~d" "Alice" 30)  ; Outputs: Name: Alice, Age: 30
    (format t "Line 1~%Line 2~%Line 3")  ; Outputs:
                                            ; Line 1
                                            ; Line 2
                                            ; Line 3
    (format t "The list is ~s." '(1 2 3))  ; Outputs: The list is (1 2 3).
    (format t "Hello,~TWorld!") ; Outputs: "Hello, World!"
    (format t "~A" 'example) ; Outputs: "example"
    (format t "~S" "example") ; Outputs: "\"example\""
    (format t "~D" 42) ; Outputs: "42"
    (format t "~F" 3.14159) ; Outputs: "3.141590"
    (format t "Line 1~%Line 2") ; Outputs: "Line 1" followed by "Line 2" on a new line.
    (format t "~E" 12345.6789) ; Outputs: "1.234568E+4"
    (format t "Hello,~&World!") ; Outputs: "Hello,World!"
    (format t "~10A" 'example) ; Outputs: "   example"
    (format t "Hello,~^ World!") ; Outputs: "Hello,"
    (format t "~10D" 42) ; Outputs: "        42"
    (format t "The value of ~A is ~D and ~F.~%" 'pi 3 3.14159); Outputs: "The value of pi is 3 and 3.141590."

    ;; Let
        (let ((keys '()))
                (maphash (lambda (key value)
                           (push key keys))
                         hash-table)
                keys)

        (defun hash-table-values (hash-table)
              (let ((values '()))
                (maphash (lambda (key value)
                           (push value values))
                         hash-table)
                values))

    ;;format
    (format t "Key5: ~a~%" (gethash 'key5 *custom-hash-table*))
    (list :height 6 :weight 200)
)