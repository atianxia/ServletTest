package com.study.servlet;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//ʵ�� Filter ��
public class LogFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {
		// ��ȡ��ʼ������
		String testParam = config.getInitParameter("test-param");

		// �����ʼ������
		System.out.println("Test Param: " + testParam);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {

		// ��ȡ�ͻ����� IP ��ַ
		String ipAddress = request.getRemoteAddr();

		// ��¼ IP ��ַ�͵�ǰʱ���
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());

		// �����󴫻ع�����
		chain.doFilter(request, response);
	}

	public void destroy() {
		/* �� Filter ʵ���� Web �����ӷ����Ƴ�֮ǰ���� */
	}
}
