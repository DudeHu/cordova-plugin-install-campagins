var exec = require('cordova/exec');

var safesmsExport = {};

safesmsExport.get = function(options, successCallback, failureCallback) {
    if (typeof options === 'object') {
        cordova.exec(successCallback, failureCallback, 'CampaignController', 'get', options);
    } else {
        if (typeof failureCallback === 'function') {
            failureCallback('options should be specified.');
        }
    }
}
module.exports = safesmsExport;