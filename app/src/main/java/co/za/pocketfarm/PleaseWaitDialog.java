package co.za.pocketfarm;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PleaseWaitDialog {
    private Dialog dialog;

    public void show(Context context, String message) {
        // Create the custom dialog
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Inflate the layout for the dialog
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_please_wait, null);

        // Set the message
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        tvMessage.setText(message);

        dialog.setContentView(view);
        dialog.show();
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void performBackgroundTask(final OnBackgroundTaskCompleteListener listener) {
        // Simulating a background task with a delay of 10 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Task completed, notify the listener
                listener.onTaskComplete();
            }
        }, 10000);
    }

    public interface OnBackgroundTaskCompleteListener {
        void onTaskComplete();
    }
}
