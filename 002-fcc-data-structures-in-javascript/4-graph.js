class Graph {
  constructor() {
    this.adjacencyList = {};
  }

  isEmpty() {
    return Object.keys(this.adjacencyList).length === 0;
  }

  addNode(value) {
    this.adjacencyList[value] = [];
  }

  containsNode(value) {
    return this.adjacencyList[value] !== undefined;
  }
}

module.exports = Graph;
