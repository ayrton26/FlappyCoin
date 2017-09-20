package com.example.ayrton.flappycoin.engine.net;

import android.util.Log;

import com.example.ayrton.flappycoin.engine.elements.Score;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ayrton on 20/09/17.
 */

public class ScoreDispatcher implements Runnable{
    private static final String URL = "http://wildfly-bct.a3c1.starter-us-west-1.openshiftapps.com/rest/score/";
    private Score score;


    public void send(Score s){
        this.score = s;
        new Thread(this).start();
    }

    public void run() {
        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        try {
            String json = getScoreJSON(score);

            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(URL)
                    .put(body)
                    .build();
            Response response = client.newCall(request).execute();
        } catch (Exception e){
            Log.e("Score Dispatcher", "Erro de envio", e);
        }

    }
    private String getScoreJSON(Score score) throws JSONException{
        JSONObject scoreJSON = new JSONObject();
        scoreJSON.put("id", score.getId());
        JSONObject usuarioJSON = new JSONObject();
        usuarioJSON.put("id", score.getUsuario().getId());
        usuarioJSON.put("nome", score.getUsuario().getNome());
        usuarioJSON.put("email", score.getUsuario().getEmail());
        scoreJSON.put("usuario", usuarioJSON);
        scoreJSON.put("pontos", score.getPontos());

        return scoreJSON.toString();
    }
}
