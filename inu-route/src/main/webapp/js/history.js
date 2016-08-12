
(function () {

    var list = document.querySelector(".list");
    var item = list.querySelector(".item");

    var pair = document.location.search.match("openId[^&]*");
    var openId = pair[0].split("=")[1];
    var url = "http://iknowu.qaq.moe/history.html?openId=" + openId;
    XHR.get(url, function (event) {
        /* extract data */
        var resp = JSON.parse(event.target.responseText);
        for (var i = 0; i < resp.data.length; ++i) {
            var item = resp.data[i];
            appendItem(item.datetime, item.content);
        }

        /* update ui */
        document.title = "历史心情";
        list.classList.toggle("hide");

        var loadingToast = document.querySelector("#loadingToast");
        loadingToast.classList.toggle("hide");
    });

    function appendItem(datetime, content) {
        var newItem = item.cloneNode(true)
        newItem.classList.remove("hide");
        newItem.querySelector(".datetime").innerHTML = datetime;
        newItem.querySelector(".content p").innerHTML = content;
        list.appendChild(newItem);
    }

})();