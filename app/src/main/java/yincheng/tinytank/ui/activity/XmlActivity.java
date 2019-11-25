package yincheng.tinytank.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import yincheng.tinytank.R;
import yincheng.tinytank.cornerstone.xml.PULLService;
import yincheng.tinytank.cornerstone.xml.Person;
import yincheng.tinytank.ui.activity.base.BaseActivity;

/**
 * Mail   : luoyincheng@gmail.com
 * Date   : 2018:06:09 13:58
 * Github : yincheng.luo
 */
public class XmlActivity extends BaseActivity {
	private TextView tv_show;
	private String string = "";

	@Override
	protected int getLayoutId() {
		return R.layout.activity_xml;
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initView() {
		tv_show = findViewById(R.id.tv_show);
	}

	public void startXML(View view) {
//        SAXService saxService = new SAXService();
//        DOMService domService = new DOMService();
		PULLService pullService = new PULLService();
		try {
			InputStream inputStream = getAssets().open("users.xml");
//            List<Goods> persons = saxService.getPerson(inputStream);
//            List<Goods> persons = domService.getPersons(inputStream);
			List<Person> persons = pullService.getPersons(inputStream);
			for (Person person : persons) {
				Log.e("TAG", person.toString());
				string += person.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tv_show.setText(string);
	}
}
