# Data Structures in JavaScript
- a data structure is a format to organize, manage and store data in a way that allows efficient access and modification.
- a data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to that data.

## Arrays
```javascript
const arr = ['a', 'b', 'c', 'd']
```
- useful when we have to store individual values and add/delete values from the end of the data structure. 
- But when we need to add/delete from any part of it, there are other data structures that perform more efficiently.

https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array

## Objects (hash tables)
```javascript
const obj = {
    prop1: "I'm",
    prop2: "an",
    prop3: "object"
}
```
- collection of key-value pairs
- also called map, dictionary or hash-table in other languages

https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object

## Stacks
- a data structure that stores values in a LIFO (last in, first out) order.
- simplest solution: an array with its push and pop methods.

// todo continue in queues