package cz.lamorak.weather.android.preference;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.afollestad.materialdialogs.prefs.MaterialListPreference;

/*
* This class fixed the bug on pre-KitKat devices where the
* preference summary field does not update automatically
*/
public class CustomListPreference extends MaterialListPreference {
    public CustomListPreference(Context context) {
        super(context);
    }

    public CustomListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setValue(String value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            super.setValue(value);
        } else {
            String oldValue = getValue();
            super.setValue(value);
            if (!TextUtils.equals(value, oldValue)) {
                notifyChanged();
            }
        }
    }
}
