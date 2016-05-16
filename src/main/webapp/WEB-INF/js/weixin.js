//入口函数。
$(function(){
    $("#quick-add").click(function(){
        ajax4Add();
    })
    bundleActionForRow();
    $("#show-all").click(function(){
        refresh();
    })
    $("[title]").tooltip({
          content: function () {
              return $(this).prop('title');
          }
      });

});