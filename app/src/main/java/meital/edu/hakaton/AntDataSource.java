package meital.edu.hakaton;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AntDataSource  extends AsyncTask<Void, Void, List<Podcast>>{
    private WeakReference<RecyclerView> rvPodcasts;

    public AntDataSource(RecyclerView rvPodcasts) {
        this.rvPodcasts = new WeakReference<>(rvPodcasts);
    }
    @Override
    protected List<Podcast> doInBackground(Void... voids) {
        List<Podcast> pods = new ArrayList<>();
        //init a list of songs (from json)
        String link = "http://be.repoai.com:5080/WebRTCAppEE/rest/broadcast/getVodList/0/100?fbclid=IwAR03u4bLugBZBGE0nZqLhl-GhUHHIeddeaWepux1iv69YD7x7Txn4SYXUH4";
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(link).build();

            Call call = client.newCall(request);
            /*try (*/Response response = call.execute();/*) {*/
                if (response.body() == null)
                    return pods;
                String json = response.body().string();
                System.out.println(json);
             /*   parseJson(pods, json);

            } catch (JSONException e) {
                e.printStackTrace();
            }*/


        } catch (IOException e) {
            e.printStackTrace();
        }

        return pods;
    }

    private void parseJson(List<Podcast> pods, String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject feed = jsonObject.getJSONObject("feed");
        JSONArray resultsArray = new JSONArray(json);
        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject podObject = resultsArray.getJSONObject(i);
            String streamName = podObject.getString("streamName");
            String vodName = podObject.getString("streamId");
            String creationDate = podObject.getString("creationDate");
            String duration = podObject.getString("duration");
            String fileSize = podObject.getString("fileSize");
            String filePath = podObject.getString("filePath");
            String vodId = podObject.getString("vodId");
            String type = podObject.getString("type");

            Podcast p = new Podcast(streamName, vodName, creationDate, duration, fileSize, filePath, vodId, type);
            pods.add(p);
        }

    }

    @Override
    protected void onPostExecute(List<Podcast> podcasts) {
        RecyclerView recycler = rvPodcasts.get();
        if (recycler == null) return;
        Context context = recycler.getContext();
        PodcastAdapter adapter = new PodcastAdapter(podcasts, context);

        //set the adapter on our recycler
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(context));
    }
}
