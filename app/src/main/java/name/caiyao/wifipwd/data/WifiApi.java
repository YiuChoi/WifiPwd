package name.caiyao.wifipwd.data;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xiaomu on 2017/4/6.
 */

public interface WifiApi {

  @FormUrlEncoded
  @POST("http://ap.51y5.net/ap/fa.sec")
  Observable<WifiResult> getPwd(@Field("appId") String appId, @Field("pid") String pid,
                                @Field("ed") String ed, @Field("st") String st, @Field("et") String et,
                                @Field("sign") String sign);

  @FormUrlEncoded
  @POST("http://wifiapi02.51y5.net/wifiapi/fa.cmd")
  Observable<WifiResult> getDhid(@Field("appId") String appId, @Field("pid") String pid,
                                @Field("ed") String ed, @Field("st") String st, @Field("et") String et,
                                @Field("sign") String sign);
}
