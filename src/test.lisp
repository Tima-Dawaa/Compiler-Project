(
    (defun even(num) (= (mod num 2) 0))
    (filter '(6 4 3 5 2) #'even)
    (6 4 2)

    (defun triple (X)
      (* 3 X))                  ; be placed here.

    (defun negate (X)
      (- X))

      (defun factorial (N)
        (if (= N 1)
          (* N (factorial (- N 1)))))

    (defun fibonacci (N)
      (if (or (zerop N) (= N 1))
        (+ (fibonacci (- N 1)) (fibonacci (- N 2)))))

    (let
    	((F1 (fibonacci (- N 1)))
    	 (F2 (fibonacci (- N 2))))
          (+ F1 F2))

    (let
        ((x 1)
         (y (* x 2)))
      (+ x y))
)