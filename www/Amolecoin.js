var exec = require('cordova/exec');

var Amolecoin = {
  generateAddresses: function(successCallback, errorCallback, args) {
    console.log('retrieving addresses');
    exec(successCallback, errorCallback, "Amolecoin", "GenerateAddresses", args);
  },
  generateSeed: function(successCallback, errorCallback, args) {
      console.log('retrieving new seed');
      exec(successCallback, errorCallback, "Amolecoin", "GenerateSeed", args);
  },
  prepareTransaction: function(successCallback, errorCallback, args) {
    console.log('creating transaction');
    exec(successCallback, errorCallback, "Amolecoin", "PrepareTransaction", args);
  },
};

module.exports = Amolecoin;
