// binary search tree
class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    constructor(node) {
        this.root = node;
    }
}

let root = new Node(10);
let tree = new BinarySearchTree(root);

