// 初始化input特效
function initMaterialInput() {
    $('form input[type="text"]').each(function () {
        if ($(this).val() != '') {
            $(this).parent().find('label').addClass('active');
        }
    });
}