layui.define(['jquery', 'layer', 'util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        util = layui.util;

    $(document).ready(function () {
        if ($.isEmptyObject(layui.data('user_data'))) {
            window.location.href = '/toError';
        }
    });

    util.fixbar({
        bgcolor: "#1E9FFF",
        css: {right: 50, bottom: 150},
        showHeight: 100
    });

    const common = {
        deepSquatSubjectId: 1,
        pullUpSubjectId: 2,
        DynamometerId: 3,
        RopeClimbId: 4,
        // api_uri: 'http://62.234.56.107:9999/swagger-ui/',
        api_uri: 'http://127.0.0.1:9999/swagger-ui/',

        errorRedirect: function () {
            window.location.href = '/toError';
        }
    };

    exports('common', common);
});