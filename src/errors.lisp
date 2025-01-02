(
    ;; cond
        (cond
          ((> 3 2)
           (cond
             ((> 5 4) (print "3 > 2 and 5 > 4"))
             ((< 5 4) (print "3 > 2 and 5 < 4"))))
          (t
           (print "This is the default case")
           (print "Executing multiple statements..."))
          (otherwise (print "This is the default case")))

    (format t "Key5: ~a~%" (gethash 'key5 *custom-hash-table*))

    ;;
    (defparameter *custom-hash-table*
        (make-hash-table :test #'custom-test-func :hash-function #'custom-hash-func))

    ;; gethash
    (multiple-value-bind (value found) (gethash 'key5 *custom-hash-table*)
          (if found
              (format t "Key5 found with value: ~a~%" value)
              (format t "Key5 not found~%")))

    (multiple-value-bind (value found) (gethash 'key1 *my-hash-table*)
          (if found
              (format t "Key found with value: ~a~%" value)
              (format t "Key not found~%")))

    ;; Retrieval with default value
        (gethash 'key2 *my-hash-table* 'default-value) ;; Returns 'default-value'

    (format t "String key: ~a~%" (gethash "string-key" *my-hash-table*))
        (format t "Numeric key: ~a~%" (gethash 42 *my-hash-table*))

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

    ;; defmethod
    (defmethod describe-item ((i drink))
              (format t "Drink with ~a ml." (drink-volume i)))

    ;; make-instance
        (make-instance 'robot :name "Robo" :specs (list :height 6 :weight 200))

    ;; defclass
    (defclass car ()
          ((make : initarg : make : initform "Unknown" : accessor car-make)
           (year : initarg : year : initform 2000 : accessor car-year)))

    ;; apply
          (apply '+ a args)
)