const Node = require("./3-trees-node");
const BinarySearchTree = require("./3-trees-binary-tree");
const treeTraversal = require("./3-trees-traversal");

// Node
test("creates a node", () => {
  const newNode = new Node(100);
  expect(newNode.value).toBe(100);
});

test("creates a node that has two subnodes", () => {
  const newNode = new Node(100);
  const leftNode = new Node(10);
  const rightNode = new Node(120);
  newNode.left = leftNode;
  newNode.right = rightNode;

  expect(newNode.value).toBe(100);
  expect(newNode.left.value).toBe(10);
  expect(newNode.right.value).toBe(120);
});

// Binary Tree
test("creates an empty tree", () => {
  const newBinaryTree = new BinarySearchTree();
  const newBinaryTree2 = new BinarySearchTree(null);

  expect(newBinaryTree.root).toBe(null);
  expect(newBinaryTree2.root).toBe(null);
});

test("creates a tree with a node", () => {
  const rootNode = new Node(10);
  const newBinaryTree = new BinarySearchTree(rootNode);

  expect(newBinaryTree.root.value).toBe(10);
});

test("inserts nodes in a binary tree", () => {
  const newBinaryTree = new BinarySearchTree(new Node(50));
  newBinaryTree.insert(new Node(25));
  newBinaryTree.insert(new Node(10));
  newBinaryTree.insert(new Node(15));
  newBinaryTree.insert(new Node(55));
  newBinaryTree.insert(new Node(52));

  expect(treeTraversal(newBinaryTree.root)).toBe("10-15-25-50-52-55-");
});

test("deleting nodes", () => {
  const newBinaryTree = new BinarySearchTree(new Node(50));
  newBinaryTree.insert(new Node(25));
  newBinaryTree.insert(new Node(10));
  newBinaryTree.insert(new Node(15));
  newBinaryTree.insert(new Node(55));
  newBinaryTree.insert(new Node(52));

  newBinaryTree.delete(new Node(11)); // inexistent node
  newBinaryTree.delete(new Node(50)); // root node, both sides
  newBinaryTree.delete(new Node(10)); // one children
  newBinaryTree.delete(new Node(52)); // without children

  expect(treeTraversal(newBinaryTree.root)).toBe("15-25-55-");
});
