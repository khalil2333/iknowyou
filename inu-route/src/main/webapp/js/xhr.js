
XHR = (function() {
    var obj = {};

    obj.get = function(url, callback) {
        var xhr = new XMLHttpRequest();
        xhr.onload = callback;
        xhr.open("GET", url);
        xhr.send(null);
    };

    return obj;
})();