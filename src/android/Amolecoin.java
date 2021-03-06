package net.amolecoin.cordova.amolecoin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaArgs;
import org.json.JSONException;

import android.os.Environment;

import mobile.Mobile;

public class Amolecoin extends CordovaPlugin {
    @Override
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if ("GenerateAddresses".equals(action)) {
            try {
                String res = Mobile.generateAddresses(args.getString(0), args.getInt(1));
                System.out.println(res);
                callbackContext.success(res);
            } catch (Exception e) {
                e.printStackTrace();
                callbackContext.error("GetAddresses failed");
            };

            return true;
        } else if ("GenerateSeed".equals(action)) {
            try {
                String res = Mobile.getSeed();
                System.out.println(res);
                callbackContext.success(res);
            } catch (Exception e) {
                e.printStackTrace();
                callbackContext.error("GetSeed failed");
            };

            return true;
        } else if ("PrepareTransaction".equals(action)) {
            final String inputs = args.getString(0);
            final String outputs = args.getString(1);
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    try {
                        String res = null;
                        res = Mobile.prepareTransaction(inputs, outputs);
                        System.out.println(res);
                        callbackContext.success(res);
                    } catch (Exception e) {
                        e.printStackTrace();
                        callbackContext.error("PostTransaction failed");
                    }
                }
            });

            return true;
        }
        return super.execute(action, args, callbackContext);
    }
}
