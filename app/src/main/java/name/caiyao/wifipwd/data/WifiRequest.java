package name.caiyao.wifipwd.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by xiaomu on 2017/4/6.
 */

public class WifiRequest {

  private static WifiApi wifiApi = null;

  public static WifiApi getWifiApi() {
    synchronized (WifiRequest.class) {
      if (wifiApi == null) {
        wifiApi = new Retrofit.Builder()
            .baseUrl("http://www.guokr.com")
            .client(new OkHttpClient())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WifiApi.class);
      }
      return wifiApi;
    }
  }
}
