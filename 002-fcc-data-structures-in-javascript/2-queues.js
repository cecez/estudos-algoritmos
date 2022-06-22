// unshift and pop
const myQueue = [];
myQueue.unshift("first in line");
myQueue.unshift("second in line");
myQueue.unshift("third in line");
myQueue.unshift("fourth in line");

console.log(myQueue);

const nextInLine = myQueue.pop();
console.log(nextInLine);
console.log(myQueue);

// push and shift
console.log("push and shift")
const myOtherQueue = [];
myOtherQueue.push("first in line");
myOtherQueue.push("second in line");
myOtherQueue.push("third in line");
myOtherQueue.push("fourth in line");

console.log(myOtherQueue);
const nextInOtherLine = myOtherQueue.shift();
console.log(nextInOtherLine);
console.log(myOtherQueue);