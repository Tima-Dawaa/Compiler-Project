(
;;format
(format t "Key5: ~a~%" (gethash 'key5 *custom-hash-table*))

;;defmethod
(defmethod describe-item ((i drink))
(format t "Drink with ~a ml." (drink-volume i)))

;;make-instance
(make-instance 'robot :name "Robo" :specs (list :height 6 :weight 200))

;; apply
(apply '+ a args)
)