package br.com.lucasfsilva.exemplonotifications;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static br.com.lucasfsilva.exemplonotifications.App.CHANNEL_ID_01;
import static br.com.lucasfsilva.exemplonotifications.App.CHANNEL_ID_02;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText edtTitulo, edtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtMensagem = (EditText) findViewById(R.id.edtMensagem);

    }

    public void enviarNoChannel01(View view) {
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_01)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void enviarNoChannel02(View view) {
        String titulo = edtTitulo.getText().toString();
        String mensagem = edtMensagem.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_02)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}
