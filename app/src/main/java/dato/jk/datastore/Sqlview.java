package dato.jk.datastore;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sqlview extends AppCompatActivity {
    ListView tvresult;
    SqLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);

        
        db = new SqLiteDB(this);
        //String data = db.getData();
        // tvresult.setText(data);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.getListContents ();

        if ( data.getCount() == 0){
            Toast.makeText(Sqlview.this,"empty database : (,",Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()){
                theList.add(data.getString(1));
                theList.add(data.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                tvresult.setAdapter(listAdapter);
            }
        }
    }
}
