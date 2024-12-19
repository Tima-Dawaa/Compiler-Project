(
(defun my-func (a b c)
  (+ a b c))

(defun my-func (a &optional b c)
  (+ a b c))

(defun my-func (a &rest args)
  (apply '+ a args))

(defun my-func (&key x y)
  (+ x y))




)