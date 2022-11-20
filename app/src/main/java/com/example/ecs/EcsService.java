package com.example.ecs;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import kr.dpaper.api.client.ApiClient;
import kr.dpaper.api.client.ApiResponse;

public class EcsService implements Callable<Map> {

    private String api;
    private String method;
    private Map body;

    public EcsService(String api, String method, Map body) {
        this.api = api;
        this.method = method;
        this.body = body;

    }

    @Override
    public Map call() throws Exception {

        Map rtnMap = null;

        try {

            ApiClient apiClient = new ApiClient(EcsConfig.API_SERVER, this.api, this.method, EcsConfig.API_KEY);
            apiClient.applyApiPrivateKey(EcsConfig.API_PRIVATE_KEY);

            Map<String, Object> header = new HashMap<>();
            header.put("apiUtlInsttCode", EcsConfig.API_INSTT_CODE);
            header.put("apiUtlInsttTrnsmisNo", "");
            header.put("deviceId","");

            ApiResponse apiResponse = apiClient.sendJsonRequest(header, this.body);

            Log.d(EcsService.class.getName(), "HTTP_STATUS=" + apiResponse.getHttpStatusCode());
            Log.d(EcsService.class.getName(), "HTTP_STATUS_MESSAGE=" + apiResponse.getHttpStatusMessage());
            Log.d(EcsService.class.getName(), "RESPONSE_BODY=" + apiResponse.getResponseBody());

            rtnMap = new GsonBuilder().create().fromJson(apiResponse.getResponseBody(), Map.class);

        } catch (Exception e) {
            Log.e(EcsService.class.getName(), e.getClass().getName() + " -> " + e.getMessage());
            Log.e(EcsService.class.getName(), "API -> " + this.api);
            e.printStackTrace();
        }

        return rtnMap;
    }
}
