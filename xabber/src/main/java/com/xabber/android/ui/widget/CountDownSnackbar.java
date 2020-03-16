package com.xabber.android.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.xabber.android.R;

public class CountDownSnackbar extends BaseTransientBottomBar<CountDownSnackbar> {

    protected CountDownSnackbar(@NonNull ViewGroup parent, @NonNull View content,
                                @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        super(parent, content, contentViewCallback);
    }

    public static CountDownSnackbar make(ViewGroup parent, @Duration int duration) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View content = inflater.inflate(R.layout.snackbar_countdown, parent, false);

        ContentViewCallback callback = new ContentViewCallback(content);
        CountDownSnackbar snackbar = new CountDownSnackbar(parent, content, callback);
        snackbar.getView().setPadding(0,0,0,0);
        snackbar.setDuration(duration);
        return snackbar;
    }

    private static class ContentViewCallback implements
            BaseTransientBottomBar.ContentViewCallback {

        private View content;

        public ContentViewCallback(View content) {
            this.content = content;
        }

        @Override
        public void animateContentIn(int delay, int duration) {
            ViewCompat.setAlpha(content, 0f);
            ViewCompat.animate(content)
                    .alpha(1f)
                    .setDuration(duration)
                    .setStartDelay(delay);
        }

        @Override
        public void animateContentOut(int delay, int duration) {
            ViewCompat.setAlpha(content, 1f);
            ViewCompat.animate(content)
                    .alpha(0f)
                    .setDuration(duration)
                    .setStartDelay(delay);
        }
    }
}
