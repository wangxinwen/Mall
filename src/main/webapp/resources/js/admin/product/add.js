$(document).ready(function() {
    // 傾聽父類別下拉式選單的更換事件
    $('#parentCategory').on('change', parentCategoryChangeHandler);
});

/**
 * 處理父類別下拉式選單的更換事件
 */
var parentCategoryChangeHandler = function() {
    // 將子類別的內容清除
    $('#childCategory').children().remove();
    // 子類別加入預設內容
    $('#childCategory').append('<option value="-1">請選擇子類別</option>');
    // 取得父類別的值
    var parentCategory = $('#parentCategory').val();
    // 如果父類別選擇預設的「請選擇父類別」, 離開方法不繼續執行
    if (parentCategory == -1) {
        return false;
    }
    
    // 使用ajax, 根據父類別取得子類別
    $.ajax({
        url : '/admin/categorys/parents/' + parentCategory,
        type : 'POST',
        dataType : 'json',
        success : function(data) {
            // 取得子類別下拉選單Tag
            var $selectTag = $("#childCategory");
            // 逐一取出資料
            $.each(data, function(i) {
                // 將資料組合成option tag
                var id = data[i]['id'];
                var name = data[i]['name'];
                var tag = '<option value="' + id + '">' + name + '</option>';
                // 將option tag加到子類別的下拉式選單
                $selectTag.append(tag);
            }); // end each
        },
        error : function() {
            alert('伺服器錯誤');
        }
    }); // end ajax
};