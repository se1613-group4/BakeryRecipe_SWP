/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('a.upload-window').click(function() {
        //lấy giá trị thuộc tính href - chính là phần tử "#login-box"
        var uploadBox = $(this).attr('href');
 
        //cho hiện hộp đăng nhập trong 300ms
        $(uploadBox).fadeIn(300);
 
        // thêm phần tử id="over" vào sau body
        $('body').append('<div id="over">');
        $('#over').fadeIn(300);
 
        return false;
 });
 
 // khi click đóng hộp thoại
 $(document).on('click', "a.close, #over", function() {
       $('#over, .login').fadeOut(300 , function() {
           $('#over').remove();
       });
      return false;
 });
});


