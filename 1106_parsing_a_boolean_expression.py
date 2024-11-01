# 1106. Parsing A Boolean Expression
# Difficulty: Hard
# Topics: String, Stack, Recursion

class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        stk = []
        
        for c in expression:
            if c != ')' and c != ',':
                stk.append(c)
            elif c == ')':
                exp = []
                
                while stk and stk[-1] != '(':
                    t = stk.pop()
                    exp.append(True if t == 't' else False)
                
                stk.pop()
                
                if stk:
                    t = stk.pop()
                    v = exp[0]
                    
                    if t == '&':
                        for b in exp:
                            v &= b
                    elif t == '|':
                        for b in exp:
                            v |= b
                    else:
                        v = not v
                    
                    stk.append('t' if v else 'f')
        
        return stk[-1] == 't'