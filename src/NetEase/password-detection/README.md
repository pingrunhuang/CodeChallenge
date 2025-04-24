# Problem description
对用户输入的密码进行安全性识别，需满足一下三点：
1. 长度为6～20位
2. 必须包含至少一个大写字母，一个小写字母和一个数字
3. 不能超过三个重复的连续字符，如'rrr'
打印需要进行的最少改动次数（增，删，改）

```python
import sys

if __name__ == "__main__":
    code = str(sys.stdin.readline().strip())
    numOfChange = 0
    hasUpper = False
    hasLower = False
    hasNum = False
    if len(code) < 6:
        # add
        numOfChange = 6 - len(code)
    if len(code) > 20:
        # delete
        numOfChange = len(code) - 20
    for c in code:
        if c.isupper():
            hasUpper = True
        if c.islower():
            hasLower = True
        if c.isdigit():
            hasNum = True
    if not hasUpper:
        numOfChange += 1
    if not hasLower:
        numOfChange += 1
    if not hasNum:
        numOfChange += 1

    for i in range(len(code)-2):
        if code[i] == code[i+1] and code[i+1] == code[i+2]:
            numOfChange += 1

print numOfChange

```
