(
(format t "The number is ~d." 42)  ; Outputs: The number is 42.
(format t "Hello,~%World!")  ; Outputs: Hello, World!
(format t "Hello, World!")  ; Outputs: Hello, World!
(format t "Pi is approximately ~f." 3.14159)  ; Outputs: Pi is approximately 3.141590.
(format t "The result is ~a." (* 3 14))  ; Outputs: The result is 42.
(format t "Name: ~a, Age: ~d" "Alice" 30)  ; Outputs: Name: Alice, Age: 30
(format t "Line 1~%Line 2~%Line 3")  ; Outputs:
                                        ; Line 1
                                        ; Line 2
                                        ; Line 3
(format t "The list is ~s." '(1 2 3))  ; Outputs: The list is (1 2 3).
(format t "Hello,~TWorld!") ; Outputs: "Hello, World!"
(format t "~A" 'example) ; Outputs: "example"
(format t "~S" "example") ; Outputs: "\"example\""
(format t "~D" 42) ; Outputs: "42"
(format t "~F" 3.14159) ; Outputs: "3.141590"
(format t "Line 1~%Line 2") ; Outputs: "Line 1" followed by "Line 2" on a new line.
(format t "~E" 12345.6789) ; Outputs: "1.234568E+4"
(format t "Hello,~&World!") ; Outputs: "Hello,World!"
(format t "~10A" 'example) ; Outputs: "   example"
(format t "Hello,~^ World!") ; Outputs: "Hello,"
(format t "~10D" 42) ; Outputs: "        42"
(format t "The value of ~A is ~D and ~F.~%" 'pi 3 3.14159); Outputs: "The value of pi is 3 and 3.141590."

)