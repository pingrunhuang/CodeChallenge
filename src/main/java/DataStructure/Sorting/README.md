Some sorting algorithms are stable by nature like Insertion sort, Merge Sort, Bubble Sort, etc.
And some sorting algorithms are not, like Heap Sort, Quick Sort, etc. 

[stability](http://homepages.math.uic.edu/~leon/cs-mcs401-s08/handouts/stability.pdf)

排序算法是否稳定，取决于相同元素在排序的时候是否有被移动
如果相同的元素仍然被调整，则该排序不稳定
否则为稳定。

桶排序：
桶排序是一种思想，桶排序是先创建一定容量的桶（容量为该数组中最大的元素的值），
再根据待排序的数组中的元素的值作为index放入该桶对应index的位置，然后依次倒出桶中的元素则得到排序后的数组。
可以看出桶排序的空间复杂度是该数组中最大元素的值，时间复杂度为O(N)

