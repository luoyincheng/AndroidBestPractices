package yincheng.tinytank.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.OnClick;
import yincheng.tinytank.R;
import yincheng.tinytank.provider.BundleConstant;
import yincheng.tinytank.provider.helper.Bundler;
import yincheng.tinytank.provider.helper.InputHelper;
import yincheng.tinytank.ui.dialogfragment.BaseBottomSheetDialogFragment;
import yincheng.tinytank.view.FontTextView;
import yincheng.tinytank.view.widget.FontButton;

/**
 * Created by yincheng on 2018/5/31/15:07.
 * github:luoyincheng
 */
public class MessageDialogView extends BaseBottomSheetDialogFragment {

	public static final String TAG = MessageDialogView.class.getSimpleName();
	@BindView(R.id.title)
	FontTextView title;
	@BindView(R.id.datasource_title)
	FontTextView datasourceTitle;
	@BindView(R.id.datasource_content)
	FontTextView datasourceContent;
	@BindView(R.id.message_title)
	FontTextView messageTitle;
	@BindView(R.id.message_content)
	FontTextView messageContent;
	@BindView(R.id.result_title)
	FontTextView resultTitle;
	@BindView(R.id.result_content)
	FontTextView resultContent;
	@BindView(R.id.cancel)
	FontButton cancel;
	@BindView(R.id.ok)
	FontButton ok;
	@Nullable
	private MessageDialogViewActionCallback callback;

	@NonNull
	public static MessageDialogView newInstance(@NonNull String bundleTitle, @NonNull
			String bundleMsg) {
		return newInstance(bundleTitle, bundleMsg, null);
	}

	@NonNull
	public static MessageDialogView newInstance(@NonNull String bundleTitle, @NonNull
			String bundleMsg, boolean isMarkDown) {
		return newInstance(bundleTitle, bundleMsg, isMarkDown, null);
	}

	@NonNull
	public static MessageDialogView newInstance(@NonNull String bundleTitle, @NonNull
			String bundleMsg,
	                                            boolean isMarkDown, boolean hideCancel) {
		return newInstance(bundleTitle, "", bundleMsg, "", isMarkDown, null, hideCancel);
	}

	@NonNull
	public static MessageDialogView newInstance(@NonNull String title,
	                                            @NonNull String msg,
	                                            boolean isMarkDown,
	                                            @Nullable Bundle bundle) {
		MessageDialogView messageDialogView = new MessageDialogView();
		messageDialogView.setArguments(getBundle(title, "", msg, "", isMarkDown, bundle,
				false));
		return messageDialogView;
	}

	@NonNull
	public static MessageDialogView newInstance(String bundleTitle,
	                                            String bundleData,
	                                            String bundleMsg,
	                                            String bundleResult,
	                                            boolean isMarkDown,
	                                            Bundle bundle,
	                                            boolean hideCancel) {
		MessageDialogView messageDialogView = new MessageDialogView();
		messageDialogView.setArguments(getBundle(bundleTitle,
				bundleData,
				bundleMsg,
				bundleResult,
				isMarkDown,
				bundle,
				hideCancel));
		return messageDialogView;
	}

	@NonNull
	public static MessageDialogView newInstance(@NonNull String title,
	                                            @NonNull String msg,
	                                            @Nullable Bundle bundle) {
		return newInstance(title, msg, false, bundle);
	}

	private static Bundle getBundle(String bundleTitle,
	                                String bundleData,
	                                String bundleMsg,
	                                String bundleResult,
	                                boolean isMarkDown,
	                                Bundle bundle,
	                                boolean hideCancel) {
		return Bundler.create()
				.put("title", bundleTitle)
				.put("data", bundleData)
				.put("msg", bundleMsg)
				.put("result", bundleResult)
				.put("bundle", bundle)
				.put("isMarkDown", isMarkDown)
				.put("hideCancel", hideCancel)
				.end();
	}

	@NonNull
	public static Bundle getYesNoBundle(@NonNull Context context) {
		return Bundler.create()
				.put("primary_extra", context.getString(R.string.yes))
				.put("secondary_extra", context.getString(R.string.no))
				.end();
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (getParentFragment() != null && getParentFragment() instanceof
				MessageDialogViewActionCallback) {
			callback = (MessageDialogViewActionCallback) getParentFragment();
		} else if (context instanceof MessageDialogViewActionCallback) {
			callback = (MessageDialogViewActionCallback) context;
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		callback = null;
	}

	@OnClick({R.id.cancel, R.id.ok})
	public void onClick(@NonNull View view) {
		if (callback != null) {
			isAlreadyHidden = true;
			callback.onMessageDialogActionClicked(view.getId() == R.id.ok, getArguments()
					.getBundle("bundle"));
		}
		dismiss();
	}

	@Override
	protected int layoutRes() {
		return R.layout.message_dialog;
	}

	@SuppressWarnings("ConstantConditions")
	@Override
	public void onViewCreated(@NonNull View
			                          view,
	                          @Nullable Bundle
			                          savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Bundle bundle = getArguments();
		title.setText(bundle != null ? bundle.getString("title") : "null");
		String data = bundle != null ? bundle.getString("data") : "null";
		String msg = bundle != null ? bundle.getString("msg") : "null";
		String result = bundle != null ? bundle.getString("result") : "null";
		if (bundle != null && bundle.getBoolean("isMarkDown")) {
			if (data == null) datasourceContent.setVisibility(View.GONE);
			if (msg == null) messageContent.setVisibility(View.GONE);
			if (result == null) resultContent.setVisibility(View.GONE);
		} else {
			datasourceContent.setText(data);
			messageContent.setText(msg);
			resultContent.setText(result);
		}
		if (bundle != null) {
			boolean hideCancel = bundle.getBoolean("hideCancel");
			if (hideCancel) cancel.setVisibility(View.GONE);
			initButton(bundle);
		}
	}

	private void initButton(@NonNull Bundle bundle) {
		Bundle extra = bundle.getBundle("bundle");
		if (extra != null) {
			boolean yesNo = extra.getBoolean(BundleConstant.YES_NO_EXTRA);
			if (yesNo) {
				ok.setText(R.string.yes);
				cancel.setText(R.string.no);
			} else {
				boolean hideButtons = extra.getBoolean("hide_buttons");
				String primaryExtra = extra.getString("primary_extra");
				String secondaryExtra = extra.getString("secondary_extra");
				if (hideButtons) {
					ok.setVisibility(View.GONE);
					cancel.setVisibility(View.GONE);
				} else if (!InputHelper.isEmpty(primaryExtra)) {
					ok.setText(primaryExtra);
					if (!InputHelper.isEmpty(secondaryExtra)) cancel.setText(secondaryExtra);
					ok.setVisibility(View.VISIBLE);
					cancel.setVisibility(View.VISIBLE);
				}
			}
		}
	}

	@Override
	protected void onDismissedByScrolling() {
		super.onDismissedByScrolling();
		if (callback != null) callback.onDialogDismissed();
	}

	@Override
	protected void onHidden() {
		if (callback != null) callback.onDialogDismissed();
		super.onHidden();
	}

	public interface MessageDialogViewActionCallback {

		void onMessageDialogActionClicked(boolean isOk, @Nullable Bundle bundle);

		void onDialogDismissed();
	}
}
