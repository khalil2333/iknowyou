
function loadArticle(articleId) {
    var url = "http://iknowu.qaq.moe/ArticleServlet?articleId=" + encodeURIComponent(articleId); 
    XHR.get(url, function(event){
        /* extract data */
        var resp = JSON.parse(event.target.responseText);
        document.querySelector("article h1").innerHTML = resp.data.title;
        document.querySelector("article img").src = resp.data.pic;
        document.querySelector("article section p").innerHTML = resp.data.content;

        /* update ui */
        var article = document.querySelector("article");
        article.classList.remove("hide");
        var loadingToast = document.querySelector("#loadingToast");
        loadingToast.classList.toggle("hide");

        document.title = "article";
    });
}

var pair = document.location.search.match("articleId[^&]*");
var articleId = pair[0].split("=")[1];
// console.log(articleId);
loadArticle(articleId);

// function test() {
//     XHR.get("http://iknowu.qaq.moe/", "ab", "小鸟", "name", "whinc wu");
//     XHR.post("http://iknowu.qaq.moe/", "id", "小鸟", "name", "whinc wu");
// }

// setTimeout(function() {
//     var article = document.querySelector("article");
//     article.classList.remove("hide");

//     var loadingToast = document.querySelector("#loadingToast");
//     loadingToast.classList.toggle("hide");

//     document.title = "article";
// }, 2000);