# Hash Table
哈希表又称散列表。

### 哈希函数(MD5和SHA1算法)
特点：
1. 拥有无限的输入域
2. 输入值相同，返回值一样
3. 输入值不同，返回值可能一样也可能不一样（哈希冲突）
4. 不同输入得到的哈希值，整体均匀分布在域上

构造方法：
1. 直接定址 h(k) = k + c
2. 除留余数法 h(k) = k mod p
3. 根据joshua bloch的effective java一书，h(k) = 31 * k + c. *( 31 * k == (k << 5))*

### 哈希冲突解决方法
考虑装填因子alpha = n/m (n是指哈希表中已经存入的记录数，m是指哈希表的长度)， 可分别选择以下方法：
1. 开放定址法（数据少，alpha<1）
    * 从发生冲突的地址d开始，依次寻找d的下一个地址直到找到空闲位置
    （d[0] = h(k); d[i] = (d[i-1] + 1) mod m）
    * 平方探查法，从发生冲突的地址d开始，d + i * i 逐步寻找下一个
     (d[0] = h(k); d[i] = (d[i-1] + i * i) mod m)
2. 拉链法（alpha>1）
    * 先构造哈希函数得到key的哈希地址
    * 再在该地址上建立链表存储
    
    
### Application

`Map reduce`
* map -> divide the large tasks into small tasks by hash function,
 tasks with same hash value will be assigned to the same node

`hashmap`  
`bitmap`