package com.wk.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-06-11 11:34
 */
public class MyFragmentDialog extends DialogFragment {
    private String[] mColorItems = new String[]{"White", "Red", "Green", "Blue"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog);
//        setStyle(STYLE_NO_TITLE, 0);
        setStyle(STYLE_NO_FRAME, 0);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.layout_dialog, container, false);
//        return view;
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("aaaaa");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setNegativeButton("Negative" ,null);
        builder.setPositiveButton("Positive", null);
        builder.setNeutralButton("Neutral", null);
//        builder.setMessage("AAAA \n BBB");
//        builder.setItems(mColorItems, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(), mColorItems[which], Toast.LENGTH_SHORT).show();
//            }
//        });

//        builder.setView(R.layout.layout_dialog);
        View view = View.inflate(getActivity(), R.layout.layout_dialog, null);
        builder.setView(view);
//        builder.setSingleChoiceItems(mColorItems, 3, null);
        AlertDialog alertDialog = builder.create();

        int style = android.app.DialogFragment.STYLE_NORMAL, theme = 0;
        int mNum = 10;
        switch ((mNum-1)%6) {
            case 1: style = android.app.DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = android.app.DialogFragment.STYLE_NO_FRAME; break;
            case 3: style = android.app.DialogFragment.STYLE_NO_INPUT; break;
            case 4: style = android.app.DialogFragment.STYLE_NORMAL; break;
            case 5: style = android.app.DialogFragment.STYLE_NORMAL; break;
            case 6: style = android.app.DialogFragment.STYLE_NO_TITLE; break;
            case 7: style = android.app.DialogFragment.STYLE_NO_FRAME; break;
            case 8: style = android.app.DialogFragment.STYLE_NORMAL; break;
        }
        switch ((mNum-1)%6) {
            case 4: theme = android.R.style.Theme_Holo; break;
            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 6: theme = android.R.style.Theme_Holo_Light; break;
            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 8: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Light);
        Window window = alertDialog.getWindow();
        window.setWindowAnimations(R.style.dialogAnim);

        return alertDialog;
    }
}
