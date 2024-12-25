(
(defclass person ()
  ((name : initarg :name :accessor person-name)
   (age : initarg :age :accessor person-age)))

(defclass student (person)
  ((student-id : initarg : student-id : accessor student-id)))

(defclass car ()
  ((make : initarg : make : initform "Unknown" : accessor car-make)
   (year : initarg : year : initform 2000 : accessor car-year)))

(format t "Name: ~a~%" (person-name *person-instance*))
(format t "Age: ~a~%" (person-age *person-instance*))


(defparameter *my-hash-table* (make-hash-table))
(setf (gethash 'key1 *my-hash-table*) 'value1)
(setf (gethash "string-key" *my-hash-table*) 'string-value)
(setf (gethash 42 *my-hash-table*) 'numeric-value)
(gethash 'key1 *my-hash-table*)

(defparameter *basic-hash-table* (make-hash-table))
(defparameter *sized-hash-table* (make-hash-table : size 100))
(defparameter *eq-hash-table* (make-hash-table : test 'eq))

(defun custom-test-func (x y)
  (string= (symbol-name x) (symbol-name y)))
(defun custom-hash-func (x)
  (sxhash (symbol-name x)))
(defparameter *custom-hash-table*
  (make-hash-table : test #'custom-test-func : hash-function #'custom-hash-func))

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