package com.example.message;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private EditText numtext;
	private EditText contenText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        numtext =(EditText)this.findViewById(R.id.number);
        contenText=(EditText)this.findViewById(R.id.content);
        Button button =(Button)this.findViewById(R.id.button);
        button.setOnClickListener(new Buttonlistener());

    }

    public final class Buttonlistener implements View.OnClickListener{

		@Override
		public void onClick(View V) {
			// TODO Auto-generated method stub
			String num = numtext.getText().toString();
			String content =contenText.getText().toString();
			SmsManager manager = SmsManager.getDefault();
			ArrayList <String> texts=manager.divideMessage(content);
			for(String text: texts){
			manager.sendTextMessage(num, null, text, null, null);
			
			}
			Toast.makeText(getApplicationContext(), R.string.success, 1).show();
		}
    	
    	
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
