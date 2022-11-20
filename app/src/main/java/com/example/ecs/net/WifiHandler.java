package com.example.ecs.net;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import android.net.wifi.WifiNetworkSpecifier;
import android.util.Log;

import androidx.annotation.NonNull;


public class WifiHandler {

    public static final int WIFI_INTERNET = 0;
    public static final int WIFI_INEERAP = 1;

    public static final String WIFI_SSID_EGG = "ssid";
    public static final String WIFI_PSWD_EGG = "1234";

    public static final String WIFI_SSID_AP = "wldc04f";
    public static final String WIFI_PSWD_AP = "test0002";

    public static void specifyWifiNetwork(@NonNull Context context, @NonNull Intent intent) {

        final NetworkSpecifier specifier =
                new WifiNetworkSpecifier.Builder()
                        .setSsid("sunshine_5G")
                        .setWpa2Passphrase("peace2019")
                        .build();

        final NetworkRequest networkRequest =
                new NetworkRequest.Builder()
                        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                        .removeCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                        .setNetworkSpecifier(specifier)
                        .build();

        final ConnectivityManager manager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                Log.d(this.getClass().getName(), ".onAvailable Network=" + network);
                context.startActivity(intent);
            }
            @Override
            public void onUnavailable() {
                Log.d(this.getClass().getName(), ".onUnavailable ");
            }
        };

        manager.requestNetwork(networkRequest, networkCallback);

    }

    /*public void scanWifiNetwork(int wifiMode) {

        this.wifiManager = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);

        this.wifiScanReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                boolean success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false);

                if(success) {
                    scanSuccess();
                } else {
                    scanFailure();
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        context.registerReceiver(wifiScanReceiver, intentFilter);

        wifiManager.startScan();

    }

    private void scanSuccess() {
        List<ScanResult> scanResults = this.wifiManager.getScanResults();
        for(ScanResult scanResult : scanResults) {
            Log.d(this.getClass().getName(), "ScanResult=" + scanResult);
        }
    }

    private void scanFailure() {
        List<ScanResult> oldScanResults = this.wifiManager.getScanResults();
        for(ScanResult oldScanResult : oldScanResults) {
            Log.d(this.getClass().getName(), "oldScanResult=" + oldScanResult);
        }
    }*/

}
