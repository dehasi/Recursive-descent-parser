# Recursive-descent-parser

Calculate is realised by recursive descent parser.

expression ::= term [«+» or «-» term] *

term ::= multiplier [«*» or «/» or «^» multiplier] *

multiplier ::= ((number | applyFunction(expression) 

| (expression)) [«^» multiplier]*]) 
| +multiplier 
| -multiplier


