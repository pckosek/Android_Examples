package com.example.pckosek.volley_06;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class MyDialogFragment extends DialogFragment {


        public MyDialogFragment() {}

        public static MyDialogFragment newInstance() {
            MyDialogFragment frag = new MyDialogFragment();
            return frag;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_my_dialog, container);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            WebView webView = view.findViewById(R.id.webview_dialog);
            webView.loadUrl("file:///android_asset/webview.html");
        }
    }