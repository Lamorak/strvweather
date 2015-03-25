package cz.lamorak.weather.android.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;

import cz.lamorak.weather.android.R;

public class AboutDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new MaterialDialog.Builder(getActivity())
            .title(R.string.title_about)
            .content(R.string.about_text)
            .positiveText(R.string.about_dismiss)
            .build();
    }
}
