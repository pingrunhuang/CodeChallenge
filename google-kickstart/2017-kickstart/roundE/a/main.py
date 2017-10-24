from math import factorial

# this will lead to too many iteration
def product(n):
    if n> 1:
        return n * product(n-1)
    else:
        return n

t = int(input())  # read a line with a single integer
output = ''
for i in range(1, t+1):
    A, N, P = input().split(" ")
    A = int(A)
    N = int(N)
    P = int(P)
    # result = int((A**product(N))%P)
    result = int((A**factorial(N))%P)
    output += 'Case #' +str(i) + ': ' +str(result) +'\n'

with open('output', 'w') as file:
    file.write(output)
