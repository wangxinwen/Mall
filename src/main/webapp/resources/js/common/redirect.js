$(document).ready(function() {

    // 點擊取消按鈕
    $('#btn-cancel').on('click', redirectToHomePage);

    // 點擊註冊按鈕
    $('#btn-register').on('click', redirectToRegisterPage);

}); // end ready

// 導向首頁
function redirectToHomePage() {
    window.location = '/';
};

// 導向註冊頁
function redirectToRegisterPage() {
    window.location = '/register';
};