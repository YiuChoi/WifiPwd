package name.caiyao.wifipwd.ui;

import dagger.Component;

/**
 * Created by xiaomu on 2017/4/6.
 */
@Component(modules = MainPresenterModule.class)
public interface MainComponent {
  void inject(MainActivity activity);
}
