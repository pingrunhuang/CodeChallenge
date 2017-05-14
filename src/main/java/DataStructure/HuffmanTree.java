package DataStructure;

class HuffmanTree{
    static class HuffmanNode{
        public char data;
        public double weight;
        public HuffmanNode lNode;
        public HuffmanNode rNode;
        public HuffmanNode parent;
        public HuffmanNode(char data, double weight, HuffmanNode lNode, HuffmanNode rNode, HuffmanNode parent){
            this.data = data;
            this.weight = weight;
            this.lNode = lNode;
            this.rNode = rNode;
            this.parent = parent;
        }
    }

    static class HuffmanInt{
        public char data;
        public double weight;
        public int lNode;
        public int rNode;
        public int parent;
        public HuffmanInt(char data, double weight, int lNode, int rNode, int parent){
            this.data = data;
            this.weight = weight;
            this.lNode = lNode;
            this.rNode = rNode;
            this.parent = parent;
        }
    }

    // construct with an array of HuffmanNode
    public HuffmanTree(HuffmanNode[] ht, int n){
        for (int i = n; i < 2 * n - 1; i++) {
            // initialize all the parent node and child node to be null
            ht[i] = new HuffmanNode('a', -1.0, null, null, null);
        }

        for (int i = n; i < 2 * n -1; i++) {
            // let the 2 smalllest value to be initialized as the largest value of int
            double min1 = 32767;
            double min2 = 32767;
            HuffmanNode l = null;
            HuffmanNode r = null;
            for (int j=0; j<i-1; j++) {
                if (ht[j].parent == null) {
                    if (ht[j].weight < min1) {
                        min2 = min1;
                        r = l;
                        min1 = ht[j].weight;
                        l = ht[j];
                    }else if(ht[j].weight < min2){
                        min2 = ht[j].weight;
                        r = ht[j];
                    }
                }
            }
            ht[i].weight = l.weight + r.weight;
            ht[i].lNode = l;
            ht[i].rNode = r;
            l.parent = ht[i];
            r.parent = ht[i];
        }
    }

    // construct with an array of Integer
    public HuffmanTree(HuffmanInt[] ht, int n){
        double min1;
        double min2;
        int lNode;
        int rNode;
        int parent;

        // initialization
        for (int i=n; i< 2*n-1; i++) {
            ht[i] = new HuffmanInt('a', -1.0, -1, -1, -1);
        }

        // Construction
        // NOTICE: see how to traveral through the array and find the 2 smallest element
        for (int i=n; i<2*n-1; i++) {
            min1 = 32767;
            min2 = 32767;
            lNode = -1;
            rNode = -1;
            for (int j=0; j<i-1; j++) {
                if (ht[j].weight < min1) {
                    min2 = min1;
                    lNode = rNode;
                    min1 = ht[j].weight;
                    rNode = j;
                }else if(ht[j].weight < min2){
                    min2 = ht[j].weight;
                    lNode = j;
                }
            }
            ht[i].lNode = lNode;
            ht[i].rNode = rNode;
            ht[i].weight = ht[lNode].weight + ht[rNode].weight;
            ht[lNode].parent = i;
            ht[rNode].parent = i;
        }
    }

    // Huffman encoding
    public void huffmanEncode(){

    }

    public static void main(String[] agrs){
        int n = 4;
        // HuffmanNode[] n1 = new HuffmanNode[2*n-1];
        HuffmanInt[] n2 = new HuffmanInt[2*n-1];
        for (int i = 0; i<n; i++) {
            char x = 'a';
            // n1[i] = new HuffmanNode((char)(x+i), (char)(2*i+1), null, null, null);
            n2[i] = new HuffmanInt((char)(x+i), (char)(2*i+1), -1, -1, -1);
        }
        // HuffmanTree t1 = new HuffmanTree(n1, n);
        HuffmanTree t2 = new HuffmanTree(n2, n);
        for (int i = 0; i<n; i++) {
            System.out.println(n2[i].data);
        }
    }

}
