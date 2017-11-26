jQuery(document).ready(function () {
  //回车事件绑定
  document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 13) {
      $('#login').click();
    }
  };

  //登录操作
  $('#login').click(function () {
    var username = $('.username').val();
    var password = $('.password').val();
    if (username == '') {
      $('.error').fadeIn('fast', function () {
        $('.username').focus();
      });
      return false;
    }
    if (password == '') {
      $(this).find('.error').fadeIn('fast', function () {
        $('.password').focus();
      });
      return false;
    }

    $.ajax({
      url: "/login/submit",
      data: {'username': username, 'password': MD5(password)},
      type: "post",
      dataType: "json",
      success: function (result) {
        if (result.message != null) {
          $('.password').val('');
          $('.error').text(result.message);
          return;
        } else {
          setTimeout(function () {
            //登录返回
            window.location.href = result.url;
          }, 1000)
        }
      },
      error: function (e) {
        console.log(e, e.message);
      }
    });
  });
});