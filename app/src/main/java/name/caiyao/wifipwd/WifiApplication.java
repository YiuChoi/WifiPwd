package name.caiyao.wifipwd;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by xiaomu on 2017/4/1.
 */

public class WifiApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Logger.init();
  }
}
