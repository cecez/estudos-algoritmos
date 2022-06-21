const plates = [];
plates.push("first");
plates.push("second");
plates.push("third");
plates.push("fourth");

let topPlate = plates.pop();
console.log(`The top plate is ${topPlate}`);
console.log(plates);

///

class Item {
  constructor(value) {
    this.value = value;
    this.nextItem = null;
  }
}

class Stack {
  constructor() {
    this.firstItem = null;
    this.size = 0;
  }

  push(newItem) {
    const emptyStack = this.firstItem === null;
    if (emptyStack) {
      this.firstItem = newItem;
    } else {
      const previousFirst = this.firstItem;
      this.firstItem = newItem;
      this.firstItem.next = previousFirst;
    }
    this.size++;
  }

  pop() {
    const emptyStack = this.firstItem === null;
    if (emptyStack) {
      console.error("An empty stack cannot be popped.");
      return;
    }
    const oneItemStack = this.size === 1;
    if (oneItemStack) {
      const removedItem = this.firstItem;
      this.firstItem = null;
      this.size = 0;
      return removedItem;
    }
    const removedItem = this.firstItem;
    this.firstItem = this.firstItem.next;
    this.size--;
    return removedItem;
  }
}

function stackTraversal(firstItem) {
  let current = firstItem;
  while (current != null) {
    console.log(`${current.value} -> `);
    current = current.next;
  }
}

const firstItem = new Item("first");
const secondItem = new Item("second");
const thirdItem = new Item("third");

const stack = new Stack();
stack.push(firstItem);
stack.push(secondItem);
stack.push(thirdItem);
console.log(stack.size);
stackTraversal(stack.firstItem);

const topItem = stack.pop();
console.log(`Popped the ${topItem.value} from the stack.`);
stackTraversal(stack.firstItem);
console.log(stack.size);
stack.pop();
stack.pop();
stack.pop();
