package yincheng.tinytank.ui.activity;

import yincheng.tinytank.ui.activity.base.BaseActivity;

/**
 * Created by yincheng on 2018/6/26/10:24.
 * github:luoyincheng
 */
public class CodeViewerActivity extends BaseActivity {
	@Override
	protected int getLayoutId() {
		return 0;
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void initView() {

	}

//   String url;
//   String htmlUrl;
//
//   public static void startActivity(@NonNull Context context, @NonNull String url, @NonNull
//         String htmlUrl) {
//      if (!InputHelper.isEmpty(url)) {
//         Intent intent = ActivityHelper.editBundle(createIntent(context, url, htmlUrl),
//               LinkParserHelper.isEnterprise(htmlUrl));
//         context.startActivity(intent);
//      }
//   }
//
//   public static Intent createIntent(@NonNull Context context, @NonNull String url, @NonNull
//         String htmlUrl) {
//      Intent intent = new Intent(context, CodeViewerActivity.class);
//      boolean isEnterprise = LinkParserHelper.isEnterprise(htmlUrl);
//      url = LinkParserHelper.getEnterpriseGistUrl(url, isEnterprise);
//      intent.putExtras(Bundler.create()
//            .put(BundleConstant.EXTRA_TWO, htmlUrl)
//            .put(BundleConstant.EXTRA, url)
//            .put(BundleConstant.IS_ENTERPRISE, isEnterprise)
//            .end());
//      return intent;
//   }
//
//
//   @NonNull @Override public TiPresenter providePresenter() {
//      return new BasePresenter();
//   }
//
//   @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
//      super.onCreate(savedInstanceState);
//      if (savedInstanceState == null) {
//         Intent intent = Objects.requireNonNull(getIntent(), "Intent is null");
//         Bundle bundle = Objects.requireNonNull(intent.getExtras());
//         //noinspection ConstantConditions
//         url = Objects.requireNonNull(bundle.getString(BundleConstant.EXTRA), "Url is null");
//         htmlUrl = bundle.getString(BundleConstant.EXTRA_TWO);
//         getSupportFragmentManager()
//               .beginTransaction()
//               .replace(R.id.container, ViewerFragment.newInstance(url, htmlUrl), ViewerFragment
//                     .TAG)
//               .commit();
//      }
//      String title = Uri.parse(url).getLastPathSegment();
//      setTitle(title);
////      if (toolbar != null) toolbar.setSubtitle(MimeTypeMap.getFileExtensionFromUrl(url));
//      setTaskName(title);
//   }
//
//   @Override protected int getLayoutId() {
//      return R.layout.activity_view_code;
//   }
//
//   @Override protected void initData() {
//
//   }
//
//   @Override protected void initView() {
//
//   }

}

