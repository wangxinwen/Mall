$(document).ready(function() {
    // 傾聽加入購物車按鈕點擊事件
    $('#saveInCart').on('click', saveInCartButtonChickHandler);
});

/**
 * 處理加入購物車按鈕點擊事件
 */
var saveInCartButtonChickHandler = function() {
    var productId = $('#productId').val();
    
    // 新增商品至購物車
    $.ajax({
        url : '/carts/add/' + productId,
        type : 'POST',
        dataType : 'json',
        success : function(data) {
            if (data.state !== 'success') {
                if (data.msg === 'no login') {
                    alert('請先登入哦！');
                } else {
                    alert('系統錯誤');
                }
                return false;
            }
            // 新增成功後重新整理頁面
            location.reload();
        },
        error : function() {
            alert('伺服器錯誤');
        }
    }); // end ajax
};