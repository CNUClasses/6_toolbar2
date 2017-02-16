package com.library1.example.perkins.toolbar2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.settings:
                Toast.makeText(this, "settings goes here", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.reset:
                doReset();
                return true;
            case R.id.share:
                Toast.makeText(this, "share goes here", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                doHelp();
                return true;
        }

        //all else fails let super handle it
        return super.onOptionsItemSelected(item);
    }

    private void doHelp() {
        // Create out AlterDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This is where the help screen goes");
        //create an anonymous class that is listening for button click
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /**
             * This method will be invoked when a button in the dialog is clicked.
             * Note the @override
             * Note also that I have to scope the context in the toast below, thats because anonymous classes have a
             * reference to the class they were declared in accessed via Outerclassname.this
             *
             * @param dialog The dialog that received the click.
             * @param which  The button that was clicked (e.g.
             *               {@link DialogInterface#BUTTON1}) or the position
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "clicked OK in Help", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * findViewById(R.id.rel_lay2) is the viewgroup that will host the snackbar
     * If you click the Action button the onclick listener is called and the toast pops.
     */
    private void doReset() {
        Snackbar.make(findViewById(R.id.rel_lay2), "I'm a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
}
