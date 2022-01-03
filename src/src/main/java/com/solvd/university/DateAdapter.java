package src.main.java.com.solvd.university;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	@Override
	public String marshal(Date value) throws Exception {
		return new SimpleDateFormat("MM/dd/yyyy").format(value);
	}

	@Override
	public Date unmarshal(String value) throws Exception {
		return new SimpleDateFormat("MM/dd/yyyy").parse(value);
	}

}
