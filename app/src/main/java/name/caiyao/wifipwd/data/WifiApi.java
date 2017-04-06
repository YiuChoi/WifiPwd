package name.caiyao.wifipwd.data;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by xiaomu on 2017/4/6.
 */

public interface WifiApi {

  @POST("http://ap.51y5.net/ap/fa.sec")
  Observable<WifiResult> getPwd();
}
