function solve(arr) {
    let sum = 0, res = 0, map = new Map(), max = 0;
    arr.sort((a, b) => a - b);
    for (const num of arr) {
        if (map.has(num)) {
            map.set(num, map.get(num) + 1)
        } else map.set(num, 1)
        sum += num
        max = Math.max(max, num)
    }
    if (map.get(0) == 0) {
        console.log(-1)
    } else {
        let left = sum % 3
        let condition = true
        while (condition && left <= max) {
            if (map.has(left)) {
                map.set(left, map.get(left) - 1)
                sum -= left
                condition = false
            } else left += 3
        }
        if (sum == 0) return console.log(-1)
        for (let i = max; i >= 0; i--) {
            if (map.has(i)) {
                for (let j = 0; j < map.get(i); j++) {
                    res *= 10;
                    res += i;
                }
            }
        }
        console.log(res);
    }
}

solve([4,3,2,1,1,0])


// function solve(arr) {
//     let res = 0;
//     let map = new Map();
//     if (arr.length == 1) return console.log(1)
//     for (let i = 0; i < arr.length; i++) {
//         if (i == 0) {
//             map.set(arr[i], [1]);
//         } else {
//             res = 0;
//             for (let j = 1; j <= arr[i]; j++) {
//                 if (arr[i] % j == 0) {
//                     let crr = map.get(arr[i] / j);
//                     if (crr) {
//                         for (let item of crr) {
//                             res += item;
//                         }
//                     }
//                 }
//             }
//             if (map.has(arr[i])) {
//                 map.set(arr[i],[res,...map.get(arr[i])]);
//             } else {
//                 map.set(arr[i], [res]);
//             }
//         }
//     }
//     console.log(res);
// }
// solve([2])
// // 1 1 2 1 4 8