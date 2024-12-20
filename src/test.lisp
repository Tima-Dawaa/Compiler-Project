(
(defun my-func (a b c)
 (+ a b c))

(defun my-func (a &optional b c)
 (+ a b c))

(defun my-func (a &rest args)
 (apply '+ a args))

(defun my-func (&key x y)
 (+ x y))
(defparameter *basic-hash-table* (make-hash-table))

(defparameter *sized-hash-table* (make-hash-table :size 100))

(defparameter *eq-hash-table* (make-hash-table :test 'eq))

(defun custom-test-func (x y)
  (string= (symbol-name x) (symbol-name y)))

(defun custom-hash-func (x)
  (sxhash (symbol-name x)))

(defparameter *custom-hash-table*
  (make-hash-table :test #'custom-test-func :hash-function #'custom-hash-func))

(setf (gethash 'key5 *custom-hash-table*) 'value5)
(setf (gethash 'key4 *custom-hash-table*) 'value4)
(format t "Key5: ~a~%" (gethash 'key5 *custom-hash-table*))

(multiple-value-bind (value found) (gethash 'key5 *custom-hash-table*)
  (if found
      (format t "Key5 found with value: ~a~%" value)
      (format t "Key5 not found~%")))

(remhash 'key5 *custom-hash-table*)

(maphash (lambda (key value)
           (format t "Key: ~a, Value: ~a~%" key value))
         *custom-hash-table*)

(clrhash *custom-hash-table*)

;; Getting All Keys and Values
(defun hash-table-keys (hash-table)
  (let ((keys '()))
    (maphash (lambda (key value)
               (push key keys))
             hash-table)
    keys))

(defun hash-table-values (hash-table)
  (let ((values '()))
    (maphash (lambda (key value)
               (push value values))
             hash-table)
    values))

(format t "Keys: ~a~%" (hash-table-keys *sized-hash-table*))
(format t "Values: ~a~%" (hash-table-values *sized-hash-table*))

;; Create a hash table
(defparameter *my-hash-table* (make-hash-table))

;; Insert values
(setf (gethash 'key1 *my-hash-table*) 'value1)
(setf (gethash "string-key" *my-hash-table*) 'string-value)
(setf (gethash 42 *my-hash-table*) 'numeric-value)

;; Basic retrieval
(gethash 'key1 *my-hash-table*) ;; Returns 'value1'

;; Retrieval with default value
(gethash 'key2 *my-hash-table* 'default-value) ;; Returns 'default-value'

;; Check existence
(multiple-value-bind (value found) (gethash 'key1 *my-hash-table*)
  (if found
      (format t "Key found with value: ~a~%" value)
      (format t "Key not found~%")))

;; Different key types
(format t "String key: ~a~%" (gethash "string-key" *my-hash-table*))
(format t "Numeric key: ~a~%" (gethash 42 *my-hash-table*))

(defstruct person name age)
)