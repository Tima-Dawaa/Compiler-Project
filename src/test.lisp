(
(defun my-function (x y &optional (z 10) &rest args &key (key1 20) key2)
  (+ x y z)
  (print args)
)
)