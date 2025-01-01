(
(defparameter *my_hash_table* (make-hash-table))
(setf (gethash 'key1 *my_hash_table*) 'value1)
(setf (gethash "string_key" *my_hash_table*) 'string_value)
(setf (gethash 42 *my_hash_table*) 'numeric_value)

(gethash 'key1 *my_hash_table*)
(defparameter *basic_hash_table* (make-hash-table))
(defparameter *sized_hash_table* (make-hash-table : size 100))
(defparameter *eq_hash_table* (make-hash-table : test 'eq))

(defun custom_test_func (x y)
  (string= (symbol_name x) (symbol_name y)))
(defun custom_hash_func (x)
  (sxhash (symbol_name x)))
(defparameter *custom_hash_table*
  (make-hash-table : test #'custom_test_func : hash-function #'custom_hash_func))

(setf (gethash 'key1 *basic_hash_table*) 'value1)
(setf (gethash 'key2 *basic_hash_table*) 'value2)
(setf (gethash 'key3 *sized_hash_table*) 'value3)
(setf (gethash 'key4 *eq_hash_table*) 'value4)
(setf (gethash 'key5 *custom_hash_table*) 'value5)

(format t "Key1: ~a~%" (gethash 'key1 *basic_hash_table*))
(format t "Key4: ~a~%" (gethash 'key4 *eq_hash_table*))

(remhash 'key1 *basic_hash_table*)

(maphash (lambda (key value)
           (format t "Key: ~a, Value: ~a~%" key value))
         *basic_hash_table*)

(clrhash *basic_hash_table*)
)