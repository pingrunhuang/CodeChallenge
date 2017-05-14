# Problem description
给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。

# Solution
```python
# /bin/usr/python
target = raw_input()
result = ''
count = 1

if len(target) == 1:
    result = str(count) + target
else:
    for i in range(0,len(target)-1):

        if target[i] == target[i+1] and i != len(target) -2:
            count += 1
        elif target[i] == target[i+1] and i == len(target) -2:
            count += 1
            result = result + str(count) +target[i]
        elif target[i] != target[i+1] and i == len(target) -2:
            result = result + str(count) + target[i]
            count = 1
            result = result + str(count) + target[i+1]
        else:
            result = result + str(count) + target[i]
            count = 1


print result
```
```java

```
