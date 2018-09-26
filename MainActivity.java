package com.gustavofonseca.tp1;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarContato(View view) {
        EditText getNome = findViewById(R.id.editText);
        EditText getNumero = findViewById(R.id.editText2);
        EditText getEmail = findViewById(R.id.editText3);

        String nome = getNome.getText().toString();
        String numero = getNumero.getText().toString();
        String email = getEmail.getText().toString();

        Pessoa pessoa = new Pessoa(nome, numero, email);

        insereContatos(pessoa);
        mandaEmail(pessoa);
        mandaWpp(pessoa);
    }

    public void insereContatos(Pessoa pessoa) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        intent.putExtra(ContactsContract.Intents.Insert.NAME, pessoa.getNome())
                .putExtra(ContactsContract.Intents.Insert.EMAIL, pessoa.getEmail())
                .putExtra(ContactsContract.Intents.Insert.PHONE, pessoa.getNum());
        //if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    //}

    }


    public void mandaEmail(Pessoa pessoa)
    {
        String[] email = {pessoa.getEmail()};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Confirmacao de Registro");
        intent.putExtra(Intent.EXTRA_TEXT, "Sucesso!!! Voce foi adicionado com sucesso na lista de contatos");
       // if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
       // }

    }


    public void mandaWpp(Pessoa pessoa)
    {
        try {
            String text = "Sucesso!!! Voce foi adicionado(a) aos contatos!!!";// Replace with your message.

            String toNumber = pessoa.getNum(); // Replace with mobile phone number without +Sign or leading zeros.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.whatsapp");
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
