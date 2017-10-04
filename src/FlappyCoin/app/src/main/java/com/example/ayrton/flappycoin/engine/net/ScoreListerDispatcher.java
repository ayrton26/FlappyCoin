package com.example.ayrton.flappycoin.engine.net;

import android.util.Log;

import com.example.ayrton.flappycoin.engine.elements.Score;
import com.example.ayrton.flappycoin.engine.elements.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ayrton on 04/10/17.
 */

public class ScoreListerDispatcher implements Runnable{
    private static final String URL = "http://wildfly-bct.a3c1.starter-us-west-1.openshiftapps.com/rest/score/";
    private ScoreListerDispatcherListener scoreListerDispatcherListener;
    private ArrayList<Score> retorno;

    public ScoreListerDispatcher(ScoreListerDispatcherListener scoreListerDispatcherListener){
        this.scoreListerDispatcherListener = scoreListerDispatcherListener;
        retorno = new ArrayList<>();
    }

    public List<Score> getRetorno(){
        return this.retorno;
    }

    public void receive(){
        new Thread(this).start();
    }

    public void run() {
        OkHttpClient client = new OkHttpClient();

        try {
            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();
            fillRetorno(response.body().string());
            this.scoreListerDispatcherListener.notifyListerSuccess(this.retorno);
        } catch (Exception e){
            this.scoreListerDispatcherListener.notifyListerError();
            Log.e("Score Dispatcher", "Erro de envio", e);
        }

    }
    private void fillRetorno (String json) throws Exception{
        JSONArray retornoJson = new JSONArray(json);
        for (int i = 0; i < retornoJson.length(); i++){
            JSONObject elemento = retornoJson.getJSONObject(i);
            int id = elemento.getInt("id");
            JSONObject usuario = elemento.getJSONObject("usuario");
            int idUsuario = usuario.getInt("id");
            String nome = usuario.getString("nome");
            String email = usuario.getString("email");
            int pontos = elemento.getInt("pontos");
            this.retorno.add(new Score(id, new User(idUsuario, nome,email), pontos));
        }
    }

}
