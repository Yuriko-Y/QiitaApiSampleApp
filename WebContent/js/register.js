$(function() {
	 $('.js-modal-open').on('click',function(){
	        $('.js-modal').fadeIn();
	        return false;
	    });
	    $('.js-modal-close').on('click',function(){
	        $('.js-modal').fadeOut();
	        return false;
	    });
	// 送信ボタンをクリックすると処理
	$('#submit').click(function() {

		// 入力したURL
		var qiita = $('#quiitaurl').val();

		var array = qiita.split("/");

		// メソッドを呼ぶ
		getArticle(array);

	});

})

var no = 1
// キャッシュを無効にする
$.ajaxSetup({
	cache : false
});
// 記事をとってきて表示
var getArticle = function(array) {
	var api = 'http://qiita.com/api/v2/items/'
	var item_id = array[array.length - 1]

	$.get(api + item_id).done(function(data) {
		console.log(data);

		var title = data.title;
		var user = data.user.name;

		var datearray = data.created_at.split('T');

		$("#qiita__title").val(title);
		$("#qiita__name").val(user);
		$("#qiita__url").val(data.url);
		$("#qiita__date").val(datearray[0]);

		var tagLength = data.tags.length;
		var all_tags = "";
		for (let i = 0; i < tagLength; i++) {
			all_tags += data.tags[i].name + ",";

		}

		var cut_Last = all_tags.slice(0, -1);
		$("#qiita__tag").val(cut_Last);

	})

}
