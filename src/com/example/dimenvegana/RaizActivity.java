package com.example.dimenvegana;


import com.example.dimenvegana.R;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class RaizActivity  extends FragmentActivity implements ActionBar.TabListener  {

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_ACTION_BAR);
	     setContentView(R.layout.raiz);

	     // Set up the action bar.
	     final ActionBar actionBar = getActionBar();
	     actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	   

        // For each of the sections in the app, add a tab to the action bar.
        actionBar.addTab(actionBar.newTab().setText(R.string.Recetas).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.Favoritas).setTabListener(this));      
        actionBar.addTab(actionBar.newTab().setText(R.string.ListaCompra).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.Tienda).setTabListener(this));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        
    	/**
    	 * On first tab we will show our list
    	 */
    	if (tab.getPosition() == 0) {
    		ListaRecetas activity = new ListaRecetas();
    		getSupportFragmentManager().beginTransaction().replace(R.id.container, activity).commit();
    	} 
    	else if (tab.getPosition() == 1) {
    		ListaFavoritas androidlidt = new ListaFavoritas();
    		getSupportFragmentManager().beginTransaction().replace(R.id.container, androidlidt).commit();
		}
    	else if (tab.getPosition() == 2) {
    		ListaCompra androidlidt = new ListaCompra();
    		getSupportFragmentManager().beginTransaction().replace(R.id.container, androidlidt).commit();
		}
    	
    	
    	else {
    		
    		Tienda activity = new Tienda();
    		getSupportFragmentManager().beginTransaction().replace(R.id.container, activity).commit();
    		
    		/*getSupportFragmentManager().beginTransaction().replace(R.id.container, viewIntent).commit();*/
            /*Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();*/
    	}
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        public DummySectionFragment() {
        }

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            Bundle args = getArguments();
            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
            return textView;
        }
    }
	
}
