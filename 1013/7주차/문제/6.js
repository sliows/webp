function big(str1, str2) {
    let n1 = parseInt(str1);
    let n2 = parseInt(str2);
    if (n1 >= n2) {
        return str1;
    } else {
        return str2;
    }
}

function pr(msg, count) {
    for (let i = 0; i < count; i++) {
        document.write(msg);
    }
}