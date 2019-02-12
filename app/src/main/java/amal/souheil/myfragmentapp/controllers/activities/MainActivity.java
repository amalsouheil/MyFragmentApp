package amal.souheil.myfragmentapp.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import amal.souheil.myfragmentapp.R;
import amal.souheil.myfragmentapp.controllers.fragments.DetailFragment;
import amal.souheil.myfragmentapp.controllers.fragments.MainFragment;


import butterknife.BindView;


public class MainActivity extends BaseActivity implements MainFragment.OnButtonClickedListener {

    // 1 - Declare main fragment
    private MainFragment mainFragment;
    private DetailFragment detailFragment;
    @BindView(R.id.frame_layout_detail) FrameLayout layoutDetail;
    public static final int PARAMS_ACTIVITY_REQUEST_CODE = 42;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 2 - Configure and show home fragment
        this.configureAndShowMainFragment();
//        this.configureAndShowDetailFragment();
        //1 - Configure Toolbar
        this.configureToolbar();
    }

    @Override
    public void onButtonClicked(View view) {
        Toast.makeText(this,"Bouton cliqué",Toast.LENGTH_LONG).show();
        //c'est un message d'ereur dans le but de tester le bon fonctionnement entre le fragment et son activité conteneur
        Log.e(getClass().getSimpleName(),"Button clicked !");
        // 1 - Retrieve button tag
        int buttonTag = Integer.parseInt(view.getTag().toString());
        // 2 - Check if DetailFragment is visible (Tablet)
        if (detailFragment != null && detailFragment.isVisible()) {
            // 2.1 - TABLET : Update directly TextView
            detailFragment.updateTextView(buttonTag);
        } else {
            // 2.2 - SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment)
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
            startActivity(i);
        }
    }

    protected void configureAndShowMainFragment() {
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);
        if (mainFragment == null) {
            // B - Create new main fragment
            mainFragment = new MainFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, mainFragment)
                    .commit();
        }
    }

    @Override
    protected void updateDetailFragmentTextViewWithIntentTag() {
    }

    @Override
    protected void configureAndShowParamsFragment() {
    }

    protected void configureAndShowDetailFragment(){
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
               //Toast.makeText(this, "Il n'y a rien à paramétrer ici, passez votre chemin...", Toast.LENGTH_LONG).show();

                Intent intent=new Intent(MainActivity.this, ParamActivity.class);
                startActivity(intent);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void configureToolbar() {
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }
}
