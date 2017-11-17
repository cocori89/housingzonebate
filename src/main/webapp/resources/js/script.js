$(document).ready(function() {

  $(".home").hover(function() {
    $('.home a').text("홈").css('font-size','18px').css('line-height','38px');
  }, function() {
    $('.home a').text("HOME").css('font-size','16px').css('line-height','40px');
  });

  $(".about").hover(function() {
    $(".about a").text("회사소개").css('font-size','18px').css('line-height','38px');
  }, function() {
    $(".about a").text("ABOUT US").css('font-size','16px').css('line-height','40px');
  });

  $(".service").hover(function() {
    $(".service a").text("서비스").css('font-size','18px').css('line-height','38px');
  }, function() {
    $(".service a").text("SERVICE").css('font-size','16px').css('line-height','40px');
  });

  $(".gallery").hover(function() {
    $(".gallery a").text("사진첩").css('font-size','18px').css('line-height','38px');
  }, function() {
    $(".gallery a").text("GALLERY").css('font-size','16px').css('line-height','40px');
  });

  $(".contactus").hover(function() {
    $(".contactus a").text("견적문의").css('font-size','18px').css('line-height','38px');
  }, function() {
    $(".contactus a").text("CONTACT US").css('font-size','16px').css('line-height','40px');
  });

  $(".board").hover(function() {
    $(".board a").text("게시판").css('font-size','18px').css('line-height','38px');
  }, function() {
    $(".board a").text("BOARD").css('font-size','16px').css('line-height','40px');
  });

  $(".band").hover(function() {
    $(".band a").text("밴드").css('font-size','18px').css('line-height','38px');
  }, function() {
    $(".band a").text("BAND").css('font-size','16px').css('line-height','40px');
  });

})
