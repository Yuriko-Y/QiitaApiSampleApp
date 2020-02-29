$(function () {
    //送信ボタンをクリックすると処理
    $('#submit').click(function () {

        //入力したURL
        var qiita = $('#quiitaurl').val();


        var array = qiita.split("/");

        console.log("qiita" + qiita);
        console.log("array" + array);
        console.log(array[array.length - 1]);

        //メソッドを呼ぶ
        getArticle(array);

    });



})


var no = 1
// キャッシュを無効にする
$.ajaxSetup({
    cache: false
});
// 記事をとってきて表示
var getArticle = function (array) {
    var api = 'http://qiita.com/api/v2/items/'
    var item_id=array[array.length-1]

    $.get(api+item_id).done(function (data) {
        console.log(data);
        // aタグオブジェクトをつくってhrefにv.urlをセット
        // var title = $("<a>").attr("href", data.title).text(data.title);
        var url = $("<a>").attr("href", data.url).text(data.url);

        // $.each(data, function (i, v) {
        // liタグオブジェクトをつくって先程作ったaをappend
        // それを#js_append_areaに追加
        var title=data.title;
        var user=data.user.name;


        var datearray=data.created_at.split('T');


        $("#qiita__title").val(title);
        $("#qiita__name").val(user);
        $("#qiita__url").val(data.url);
        $("#qiita__date").val(datearray[0]);


        var tagLength=data.tags.length;
        var all_tags="";
       for (let i = 0; i < tagLength; i++) {
            all_tags+=data.tags[i].name+",";

       }



    //    $("#js_append_area").append($("<p>").append(data.tags[i].name).append(","));
    var cut_Last=all_tags.slice(0,-1);
       $("#qiita__tag").val(cut_Last);


    })
    // });
}
// // 最初の20件を初期表示
// getArticle();
// ボタンを押すごとに次の20件を表示
$("#next").click(function () {
    // ++no;
    getArticle();
});
