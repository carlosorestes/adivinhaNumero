package com.iftm.adivinhanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    private EditText mNumero;
    private TextView mMsg;
    private int numeroSorteado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumero = (EditText) findViewById(R.id.numero);
        mMsg = (TextView) findViewById(R.id.mensagem);
        mNumero.setOnKeyListener(this);
        numeroSorteado = (int) (Math.random() * 101);

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Log.d("teste",keyCode+"");
        if (keyCode == KeyEvent.KEYCODE_ENTER &&
                event.getAction() != KeyEvent.ACTION_DOWN) {
            verificaPalpite();
            return true;
        }
        return false;
    }

    private void verificaPalpite() {
        int palpite = Integer.parseInt(mNumero.getText().toString());
        if (palpite == numeroSorteado) {//acertou
            mMsg.setText("Acertou");
        } else if (palpite < numeroSorteado) {//palpite baixo
            mMsg.setText("Valor abaixo do alvo");
        } else {//palpite alto
            mMsg.setText("Valor acima do alvo");
        }
        mNumero.setText("");
    }
}

