package com.green.common.util;

import org.springframework.lang.Nullable;

public class StringUtils {

	public static boolean isEmpty(@Nullable Object str) {
		return (str == null || "".equals(str));
	}

	public static boolean hasLength(@Nullable CharSequence str) {
		return (str != null && str.length() > 0);
	}
}
