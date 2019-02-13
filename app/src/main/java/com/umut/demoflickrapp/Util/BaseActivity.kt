package com.umut.demoflickrapp.Util

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.umut.demoflickrapp.ui.Activity.PhotoGalery


abstract class BaseActivity : AppCompatActivity() {

    protected var TAG = "BaseActivity"
    protected lateinit var app: PhotoGalery
    //protected DataSaver ds;

    protected abstract fun setTag()

    override fun onCreate(savedInstanceState: Bundle?) {
        //requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState)
        app = application as PhotoGalery
        //ds = app.getDataSaver();
        setTag()
        //setContentView(R.layout.activity_base);
        //initActionBar(TAG);
    }

    //Should be called after setContentView so each activity shoudl call this seperatly
    //    public void initActionBar(String title){
    //        ActionBar mActionBar = getSupportActionBar();
    ////        if(support == null){
    ////            Log.d(TAG, "SUPPORT ACTIONBAR NULL");
    ////        }
    //        if(mActionBar != null){
    //            mActionBar.setDisplayShowHomeEnabled(false);
    //            mActionBar.setDisplayShowTitleEnabled(false);
    //            LayoutInflater mInflater = LayoutInflater.from(this);
    //            View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
    //            TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.toolbar_title);
    //            mTitleTextView.setText(title);
    //            mActionBar.setCustomView(mCustomView);
    //            mActionBar.setDisplayShowCustomEnabled(true);
    //        }else{
    //            Log.d(TAG, "ACTIONBAR NULL");
    //        }
    //    }

    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        // Inflate the menu; this adds items to the action bar if it is present.
    //        getMenuInflater().inflate(R.menu.menu_main, menu);
    //        return true;
    //    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    //    public static void setTranslateAnimation(Activity activity) {
    //        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_left);
    //    }
    //
    //    public static void setBackwardsTranslateAnimation(Activity activity) {
    //        activity.overridePendingTransition(R.anim.enter_from_left, R.anim.exit_from_right);
    //    }

    override fun onBackPressed() {
        //super.onBackPressed();
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
            //setBackwardsTranslateAnimation(this);
        }
    }
}
