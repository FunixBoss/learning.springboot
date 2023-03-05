package com.learning.tags;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class HelloTag extends RequestContextAwareTag{

	@Override
	protected int doStartTagInternal() throws Exception {
		return 0;
	}

	@Override
	public void doFinally() {
		System.out.println("Hello");
	}

}
