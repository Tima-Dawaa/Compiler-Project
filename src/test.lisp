(
(defparameter *my-hash-table* (make-hash-table))
(setf (gethash 'key1 *my-hash-table*) 'value1)
(setf (gethash "string-key" *my-hash-table*) 'string-value)
(setf (gethash 42 *my-hash-table*) 'numeric-value)
(gethash 'key1 *my-hash-table*) ;; Returns 'value1'

(defparameter *basic-hash-table* (make-hash-table))
(defparameter *sized-hash-table* (make-hash-table :size 100))
(defparameter *eq-hash-table* (make-hash-table :test 'eq))

(defun custom-test-func (x y)
  (string= (symbol-name x) (symbol-name y)))
(defun custom-hash-func (x)
  (sxhash (symbol-name x)))
(defparameter *custom-hash-table*
  (make-hash-table :test #'custom-test-func :hash-function #'custom-hash-func))

(setf (gethash 'key1 *basic-hash-table*) 'value1)
(setf (gethash 'key2 *basic-hash-table*) 'value2)
(setf (gethash 'key3 *sized-hash-table*) 'value3)
(setf (gethash 'key4 *eq-hash-table*) 'value4)
(setf (gethash 'key5 *custom-hash-table*) 'value5)

(format t "Key1: ~a~%" (gethash 'key1 *basic-hash-table*))
(format t "Key4: ~a~%" (gethash 'key4 *eq-hash-table*))

(remhash 'key1 *basic-hash-table*)

(maphash (lambda (key value)
           (format t "Key: ~a, Value: ~a~%" key value))
         *basic-hash-table*)

(clrhash *basic-hash-table*)
)