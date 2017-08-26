# Shift operators
Shift operators are used for operating binary value.
Basic principle:
* 1 & 1 -> 1 
* 1 & 0 -> 0
* 1 | 1 -> 1
* 1 | 0 -> 1
* 0 | 0 -> 0
* 1 << n -> shift left for n bit and insert 0 for lower order bits
* 1 >> n -> shift right for n bits. 
If the value is positive, zeroes are inserted at the higher-order bits; 
if the value is negative, ones are inserted at the higher-order bits
* 1 >>> n -> shift right for n bits regardless of the sign. Zero are inserted at the higher order bits.(only java has it, c/c++ do not)


### The execution sequence for different operators
1. (+ - x /) 
2. shift operators