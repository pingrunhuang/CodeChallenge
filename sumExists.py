
'''
This is an interview question asked by an interviewer in EA which I did not think it through during the interview in the situation where I don't have access to pen.
But later I figured it out when I got back to my computer and make a note on it.
Description:
given a target value, determine if the target array contains 2 integers that sum up to the target value  
'''

def isExists(arr, target):
    left_ptr = 0
    right_ptr = len(arr)-1
    while left_ptr < right_ptr:
        if arr[left_ptr]+arr[right_ptr]==target:
            return True
        if arr[left_ptr]+arr[right_ptr]<target:
            left_ptr+=1
        if arr[left_ptr]+arr[right_ptr]>target:
            right_ptr-=1
    return False

if __name__ == "__main__":
    target=3
    t1 = [-19,-2,-2,5,14,25,36,47,58]
    print(isExists(t1, target))