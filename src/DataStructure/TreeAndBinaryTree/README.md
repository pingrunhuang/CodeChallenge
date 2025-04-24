## Huffman Tree

记 WPL = w1*l1 + w2*l2 + w3*l3 ...... + wn*ln
其中wi是叶子结点i的权值
n表示叶子结点的数目
wi表示叶子结点到达根节点的分支数（路径长度）。

带权路径长度WPL最小的二叉树成为`哈夫曼树`也称为`最优二叉树`。

#### use cases

#### Construction of Huffman Tree
假设有n个叶子节点，则构造的Huffman Tree一共有2n-1个节点。

#### Huffman encoding
* 目的：将文字转换成长度最小化的0或1组成的二进制字符串
* 作用：huffman编码可以用于构造使电文编码的代码长度最短的方案
* 实质：使用频率越高的采用越短的编码

## Threaded binary tree(线索二叉树)
对有n个节点的二叉树，采用链式存储结构，共有2n个指针域（每个节点有一个左孩子一个右孩子）。
只有根节点没有被指向，因此只有n-1个节点被有效指向。因此有2n-(n-1) = n+1 个空链域。
可以利用这些空链域存放指向节点的直接前驱和直接后继节点的指针。
左孩子为空，指向直接前驱节点；右孩子为空，指向直接后继节点。
* |ltag|lchild|data|rchild|rtag|
* 引入ltag, rtag来指示当前左指针或右指针是指向前驱还是后继
* if(lchild -> lchild) ltag = 0; else ltag = previous  

*按二叉树以某种方式遍历使其变为线索二叉树的过程称作按该方式`对二叉树进行线索化`。*

#### use cases

