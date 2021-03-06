const Node = require("./3-trees-node");

class BinarySearchTree {
  constructor(node = null) {
    this.root = node;
  }

  insert(node) {
    let current = this.root;
    if (current == null) {
      this.root = node;
      return;
    }

    let previous = null;
    let isLeft;
    while (current != null) {
      previous = current;
      if (node.value < current.value) {
        isLeft = true;
        current = current.left;
      } else if (node.value === current.value) {
        // node already exists
        return;
      } else {
        isLeft = false;
        current = current.right;
      }
    }

    if (isLeft) {
      previous.left = node;
    } else {
      previous.right = node;
    }
  }

  insertNodes(node) {
    if (node === null) return;
    this.insertNodes(node.left);
    this.insert(new Node(node.value));
    this.insertNodes(node.right);
  }

  delete(node) {
    if (this.root === null) {
      return;
    }

    let previous = null;
    let current = this.root;
    let isLeft;
    while (current != null) {
      let nodeToBeRemovedFound = current.value === node.value;
      if (nodeToBeRemovedFound) {
        let isRoot = current === this.root;
        let doesntHaveLeftChildren = current.left === null;
        let doesntHaveRightChildren = current.right === null;
        // easiest case, node without children
        if (doesntHaveLeftChildren && doesntHaveRightChildren) {
          if (isRoot) {
            this.root = null;
            return;
          }

          if (isLeft) {
            previous.left = null;
          } else {
            previous.right = null;
          }
          return;
        }

        // semi-easist case, node with one side null
        if (doesntHaveLeftChildren || doesntHaveRightChildren) {
          if (isRoot) {
            if (doesntHaveLeftChildren) {
              this.root = current.right;
              return;
            }
            this.root = current.left;
            return;
          }

          if (doesntHaveLeftChildren) {
            if (isLeft) {
              previous.left = current.right;
            } else {
              previous.right = current.right;
            }
            return;
          }
          if (isLeft) {
            previous.left = current.left;
          } else {
            previous.right = current.left;
          }
          return;
        }

        // hard case, both sides not null (choose left and re-insert its children)
        let newNode = new Node(current.left.value);
        newNode.right = current.right;
        if (isRoot) {
          this.root = newNode;
        } else {
          if (isLeft) {
            previous.left = newNode;
          } else {
            previous.right = newNode;
          }
        }
        this.insertNodes(current.left.left);
        this.insertNodes(current.left.right);
        return;
      }

      previous = current;
      if (node.value < current.value) {
        current = current.left;
        isLeft = true;
      } else {
        current = current.right;
        isLeft = false;
      }
    }
  }
}

module.exports = BinarySearchTree;
