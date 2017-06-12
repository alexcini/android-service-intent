package br.com.heiderlopes.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;

public class MinhaIntentService extends IntentService {
    public static final String PARAM_IN_MSG = "mensagem_entrada";
    public static final String PARAM_OUT_MSG = "mensagem_saida";

    public MinhaIntentService() {
        super("MinhaIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String msg = intent.getStringExtra(PARAM_IN_MSG);
        SystemClock.sleep(3000);
        String resultTxt = msg + " "
                + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.ResponseReceiver.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        broadcastIntent.putExtra(PARAM_OUT_MSG, resultTxt);
        sendBroadcast(broadcastIntent);
    }
}