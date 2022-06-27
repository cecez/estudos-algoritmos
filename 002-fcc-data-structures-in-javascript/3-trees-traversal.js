function treeTraversal(node) {
  if (node === null) return "";
  let resultTree = treeTraversal(node.left);
  resultTree += `${node.value}-`;
  resultTree += treeTraversal(node.right);
  return resultTree;
}

module.exports = treeTraversal;
