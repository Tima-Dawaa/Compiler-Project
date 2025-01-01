(
(defmethod describe-item ((i drink))
  (format t "Drink with ~a ml." (drink-volume i)))
)