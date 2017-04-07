package name.caiyao.wifipwd.data;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaomu on 2017/4/6.
 */

public class WifiRequest {

  private static WifiApi wifiApi = null;


  public static WifiApi getWifiApi() {
    synchronized (WifiRequest.class) {
      if (wifiApi == null) {
        wifiApi = new Retrofit.Builder()
            .baseUrl("http://www.google.com")
            .client(new OkHttpClient().newBuilder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WifiApi.class);
      }
      return wifiApi;
    }
  }
}
