var exec = require('cordova/exec');

var safesmsExport = {};

safesmsExport.getParams = function(options, successCallback, failureCallback) {
    if (typeof options === 'object') {
        cordova.exec(successCallback, failureCallback, 'CampaignController', 'getParams', options);
    } else {
        if (typeof failureCallback === 'function') {
            failureCallback('options should be specified.');
        }
    }
}
module.exports = safesmsExport;