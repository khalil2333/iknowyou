
(function () {

    var list = document.querySelector(".list");
    var item = list.querySelector(".item");

    var pair = document.location.search.match("openId[^&]*");
    var openId = pair[0].split("=")[1];
    var url = "http://iknowu.qaq.moe/HistoryChatServlet?openId=" + openId;
    XHR.get(url, function (event) {
        /* extract data */
        var resp = JSON.parse(event.target.responseText);
        for (var i = 0; i < resp.data.length; ++i) {
            var item = resp.data[i];
            appendItem(item.datetime, item.content);
        }

    });

    function appendItem(datetime, content) {
        var newItem = item.cloneNode(true)
        newItem.classList.remove("hide");
        newItem.querySelector(".datetime").innerHTML = datetime;
        newItem.querySelector(".content p").innerHTML = content;
        list.appendChild(newItem);
    }

})();