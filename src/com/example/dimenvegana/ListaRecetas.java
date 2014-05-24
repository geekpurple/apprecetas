package com.example.dimenvegana;


import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class ListaRecetas extends Fragment implements Activity{

	
private String myfriends[];
	
	public ListaRecetas() {
		
		myfriends = new String[] {
				"Sandeep Pal",
				"Abhi Tripathi",
				"Amit Verma",
				"Awadhesh Diwakar",
				"Shishir Verma",
				"Ravi",
		};
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		/*setContentView(android.R.layout.simple_list_item_1);*/
		
		Thread th1 = new Thread(new Runnable() {
			
		}
		
		Thread tr = new Thread(){
			@Override
			public void run(){
				final String Resultado = leer();
				runOnUiThread(
						new Runnable() {
				
							@Override
							public void run() {
									cargaListado(obtDatosJSON(Resultado));
							}
						});
			}			
		};
		tr.start();
		
		/*ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Resultado);
		setListAdapter(listAdapter);*/
		
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_lista, container, false);
	}
	
	/*public void onListItemClick(ListView list, View v, int position, long id) {
		
		Toast.makeText(getActionBar(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
	}*/
	
	public void cargaListado(ArrayList<String> datos){
		ArrayAdapter<String> adaptador =
			new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,datos);
		ListView listado = (ListView) findViewById(R.id.listView1);
		
	
		
		listado.setAdapter(adaptador);
		/*ListAdapter listAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, datos);
		setListAdapter(listAdapter);*/
		
	}
	
	public String leer(){
		HttpClient cliente =new DefaultHttpClient();
		HttpContext contexto = new BasicHttpContext();
		HttpGet httpget = new HttpGet("http://geekpurple.com/pruebas/pruebaselect2.php?categoria=4");
		httpget.setHeader("content-type", "application/json");
		String resultado=null;
		try {
			HttpResponse response = cliente.execute(httpget,contexto);
			HttpEntity entity = response.getEntity();
			/*resultado = EntityUtils.toString(entity, "UTF-8");*/			
			resultado = EntityUtils.toString(entity);

			
		} catch (Exception e) {
			Log.e("YOUR ERROR TAG HERE", "Copying failed", e);
		}
		return resultado;
	}
	
	public ArrayList<String> obtDatosJSON(String response){
		ArrayList<String> listado= new ArrayList<String>();
		try {
			JSONArray json= new JSONArray(response);
			String texto="";
			for (int i=0; i<json.length();i++){
				texto = json.getJSONObject(i).getString("ID");
				/*texto = json.getJSONObject(i).getString("ID") +" - "+
						json.getJSONObject(i).getString("post_title") +" - "+
						json.getJSONObject(i).getString("GRUPO");*/
				listado.add(texto);
			}
		} catch (Exception e) {
			Log.e("YOUR ERROR TAG HERE", "Copying failed 2", e);
		}
		return listado;
	}
	
}
