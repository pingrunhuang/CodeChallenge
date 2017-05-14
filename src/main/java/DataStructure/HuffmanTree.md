## Huffman Tree

记 WPL = w1*l1 + w2*l2 + w3*l3 ...... + wn*ln
其中wi是叶子结点i的权值
n表示叶子结点的数目
wi表示叶子结点到达根节点的分支数（路径长度）。

带权路径长度WPL最小的二叉树成为`哈夫曼树`也称为`最优二叉树`。

### Construction of Huffman Tree
假设有n个叶子节点，则构造的Huffman Tree一共有2n-1个节点。

### Huffman encoding
目的：将文字转换成长度最小化的0或1组成的二进制字符串
