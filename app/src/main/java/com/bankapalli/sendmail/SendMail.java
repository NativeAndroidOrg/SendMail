package com.bankapalli.sendmail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

public class SendMail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
    }

    public void sendMail(View view) {
        EditText txtToAddress = (EditText)findViewById(R.id.txtToAddress);
        String toAddress = String.valueOf(txtToAddress.getText());

        EditText txtSubject = (EditText)findViewById(R.id.txtSubject);
        String subject = String.valueOf(txtSubject.getText());

        EditText txtMessage = (EditText)findViewById(R.id.txtMessage);
        String message = String.valueOf(txtMessage.getText());

        Intent sendMail = new Intent(Intent.ACTION_SENDTO);
        sendMail.setData(Uri.parse("mailto:"+toAddress));
        sendMail.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendMail.putExtra(Intent.EXTRA_TEXT, message);

        Intent chooseFromMultipleApps = Intent.createChooser(sendMail, getString(R.string.chooserTitle));
        startActivity(chooseFromMultipleApps);
    }
}
