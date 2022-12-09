package it.unimol.intentsender;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Iterator;

@CapacitorPlugin(name = "IntentSender")
public class IntentSenderPlugin extends Plugin {

    @PluginMethod
    public void startActivity(PluginCall call) {
        try {
            this.getContext().startActivity(
                    IntentSenderPlugin.parseIntent(call.getData()));
        } catch (ActivityNotFoundException e) {
            call.reject("No activity found for the given intent");
        }
    }

    private static Intent parseIntent(JSObject data) {
        Intent intent = new Intent(data.getString("action"));

        String intentData = data.getString("data");

        if (intentData != null)
            intent.setData(Uri.parse(intentData));

        try {
            JSONArray categories = data.getJSONArray("categories");

            for (int i = 0; i < categories.length(); i++)
                intent.addCategory(categories.getString(i));
        } catch (JSONException ignored) {
        }

        String type = data.getString("type");

        if (type != null)
            intent.setTypeAndNormalize(type);

        JSObject component = data.getJSObject("component");

        if (component != null)
            intent.setClassName(
                    component.getString("package"),
                    component.getString("class"));

        JSObject extras = data.getJSObject("extras");

        if (extras != null) {
            Iterator<String> keys = extras.keys();

            while (keys.hasNext()) {
                String key = keys.next();

                intent.putExtra(key, extras.getString(key));
            }
        }

        intent.setFlags(data.getInteger("flags", 0));

        return intent;
    }
}
