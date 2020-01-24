//task#0
let name = prompt('Enter your name: ', name);
confirm('New window has created!') ? alert(name) : alert('Could not show name!');

//task#1
var group = [

    {
        name: "John",
        lastName: "Connor",
        age: 20,
        laptop: false,
        gender: "male"
    },
    {
        name: "Anna",
        lastName: "Smith",
        age: 22,
        laptop: true,
        gender: "female"
    },
    {
        name: "Eugene",
        lastName: "Butthead",
        age: 19,
        laptop: false,
        gender: "male"
    }
];

function getStudentList(arrayOfStudent) {
    for (let i = 0; i < arrayOfStudent.length; i++) {
        console.log(arrayOfStudent[i].name + " " + arrayOfStudent[i].lastName + " " + arrayOfStudent[i].age +
            " years old" + ", laptop " + arrayOfStudent[i].laptop + ", gender " + arrayOfStudent[i].gender);
    }
}

getStudentList(group);

//task#2
function addNewStudent(arrayOfStudent, name, lastName, age, laptop, gender) {
    arrayOfStudent.push({name, lastName, age, laptop, gender});
}

addNewStudent(group, "Michael", "Jordan", 23, true, "male");
getStudentList(group);

//task#3
function parseString(inputString) {
    let outputString = "";
    for (let i = 0; i < inputString.length; i++) {
        if (inputString.charCodeAt(i) >= 1040 && inputString.charCodeAt(i) <= 1103) {
            outputString += inputString[i];
        }
    }
    return outputString;
}

let initialString = "Вчbvnера 789 был home work наiuyстоtящий + празrorднgfdик";
console.log(initialString);
let finalString = parseString(initialString);
console.log(finalString);

//task#4
initialArray = [1, 5, 28, 365, 78, 15];
console.log(initialArray);

var mergeSort = function (array) {

    function merge(left, right) {
        let result = []; //array for result storing
        let iLeft = 0; //counter for left element
        let iRight = 0; //counter for right element
        while (iLeft < left.length && iRight < right.length) {
            if (left[iLeft] < right[iRight]) {
                result.push(left[iLeft++]);
            } else {
                result.push(right[iRight++]);
            }
        }

        //merge what is left
        return result.concat(left.slice(iLeft)).concat(right.slice(iRight));
    }

    function merge_sort(items) {
        // in case, when array contains only 1 element return this element
        if (items.length < 2) {
            return items;
        }
        //finding for the middle of array and divides it into two arrays 'left' and 'right'
        let middle = Math.floor(items.length / 2);
        let left = items.slice(0, middle);
        let right = items.slice(middle);
        //for new arrays run recursive sorting, merge it and returns common array
        return merge(merge_sort(left), merge_sort(right));
    }

    return merge_sort(array);
};
sortedArray = mergeSort(initialArray);
console.log(sortedArray);

//task5
names = ["Adam", "Nick", "Alicia"];
lastNames = ["Smith", "Simpson", "Brown"];
let newArray = [];
for (let i = 0; i < names.length; i++) {
    newArray.push(names[i] + " " + lastNames[i]);
}
console.log(newArray);
