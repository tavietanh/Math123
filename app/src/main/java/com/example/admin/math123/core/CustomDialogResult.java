package com.example.admin.math123.core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.math123.R;

public class CustomDialogResult extends AlertDialog {
    AlertDialog Dialog;

    public CustomDialogResult(@NonNull Context context, boolean result) {
        super(context);
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        View view = getLayoutInflater().inflate(R.layout.dialog_result,null);
        TextView textDialog = (TextView)view.findViewById(R.id.textResultdialog);
        ImageView imageDiaglog = (ImageView)view.findViewById(R.id.imageDialog);
        Button btnDialog = (Button)view.findViewById(R.id.btnDialog);
        if(result)
        {
            textDialog.setText("Đúng rồi + 10 điểm");
            textDialog.setTextColor(view.getResources().getColor(R.color.colorWhite));
            imageDiaglog.setImageDrawable(view.getResources().getDrawable(R.drawable.simba_fun));
        }
        else
        {
            textDialog.setText("Sai rồi");
            textDialog.setTextColor(view.getResources().getColor(R.color.colorBrown));
            imageDiaglog.setImageDrawable(view.getResources().getDrawable(R.drawable.simba_sad));
        }
        dialog.setView(view);
        Dialog = dialog.create();

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.dismiss();
            }
        });
    }
    public void showdialog()
    {
        Dialog.show();
    }
}
