const Graph = require("./4-graph");

it("creates an empty graph", () => {
  let emptyGraph = new Graph();

  expect(emptyGraph.isEmpty()).toBe(true);
});

it("add nodes", () => {
    let myGraph = new Graph();

    myGraph.addNode("A");
    myGraph.addNode("B");

    expect(myGraph.containsNode("A")).toBe(true);
    expect(myGraph.containsNode("B")).toBe(true);
    expect(myGraph.containsNode("C")).toBe(false);
})
