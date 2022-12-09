package it.unimol.intentsender;

import android.util.Log;

public class IntentSender {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
