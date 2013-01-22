package com.luzi82.shameimaruboard.model;

import java.awt.Color;
import java.io.Serializable;

public class SbMessage implements Serializable, Comparable<SbMessage> {

	private static final long serialVersionUID = 1908008103094875195L;

	public static class Text implements Serializable, Comparable<Text> {
		private static final long serialVersionUID = 2393743104931837871L;
		String mText;
		Color mColor;

		@Override
		public int compareTo(Text o) {
			int ret;
			ret = mText.compareTo(o.mText);
			if (ret != 0)
				return ret;
			ret = compareColor(mColor, o.mColor);
			if (ret != 0)
				return ret;
			return ret;
		}
	}

	long mTime;
	public Text[] mText;
	Color mBackgroundColor;

	@Override
	public int compareTo(SbMessage arg0) {
		int ret;
		ret = Long.compare(mTime, arg0.mTime);
		if (ret != 0)
			return ret;
		ret = Integer.compare(mText.length, arg0.mText.length);
		if (ret != 0)
			return ret;
		for (int i = 0; i < mText.length; ++i) {
			ret = mText[i].compareTo(arg0.mText[i]);
			if (ret != 0)
				return ret;
		}
		ret = compareColor(mBackgroundColor, arg0.mBackgroundColor);
		if (ret != 0)
			return ret;
		return 0;
	}

	static int compareColor(Color c0, Color c1) {
		return Integer.compare(c0.getRGB(), c1.getRGB());
	}

}
