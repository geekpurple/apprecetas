package com.example.dimenvegana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Tienda extends Fragment {

	private WebView mWebView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
       /* mWebView = (WebView) findViewById(R.id.activity_main_webview);
        
		// Enable Javascript
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		mWebView.loadUrl("http://google.com/");*/
		
	}
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View mainView = (View) inflater.inflate(R.layout.fragment_web, container, false);
	    WebView webView = (WebView) mainView.findViewById(R.id.activity_main_webview);
	    webView.loadUrl("http://www.google.com");
	    return mainView;
	}
	
	
	
}
