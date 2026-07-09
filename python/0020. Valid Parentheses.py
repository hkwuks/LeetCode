class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            match i:
                case ')':
                    if len(stack) and stack[-1]=='(':
                        stack.pop()
                    else:
                        return False
                case '}':
                    if len(stack) and stack[-1]=='{':
                        stack.pop()
                    else:
                        return False
                case ']':
                    if len(stack) and stack[-1]=='[':
                        stack.pop()
                    else:
                        return False
                case _:
                    stack.append(i)

        if len(stack):
            return False
        return True
