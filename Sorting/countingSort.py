"""
log(N)

when k is not that large and stability does not matter
"""
def counting_sort(arr):
    """
    k = max element of the arr 
    Time complexity: O(k) + O(n) + O( sum(1+counting_arr[i]) for i in range(k) == k + n )= O(n+k)
    
    basic counting sort: stability not guaranteed
    """
    if len(arr) <= 1:
        return arr
    max_element = arr[0]
    for x in arr[1:]:
        if x >= max_element:
            max_element = x
    print(f"Max: {max_element}")
    counting_arr = [0 for _ in range(max_element)]
    for x in arr:
        counting_arr[x-1] += 1
    result = []
    for i,v in enumerate(counting_arr):
        if v != 0:
            result += [i] * v
    # TODO: trying to figure out a way to be more pythonic way
    # result = [ *([x[0]]*x[1]) for x in enumerate(counting_arr) if x[1] != 0]
    return result