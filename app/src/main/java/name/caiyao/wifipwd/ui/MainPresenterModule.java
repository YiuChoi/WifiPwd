package name.caiyao.wifipwd.ui;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiaomu on 2017/4/6.
 */
@Module
public class MainPresenterModule {
  private final MainContract.View view;
  private final Context context;

  public MainPresenterModule(MainContract.View view, Context context) {
    this.view = view;
    this.context = context;
  }

  @Provides
  MainContract.View provideMainContractView() {
    return view;
  }

  @Provides
  Context provideContext(){
    return context;
  }
}
