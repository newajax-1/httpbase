package com.fq.httpbase;

import com.fq.httpbase.exception.HttpBaseException;
import com.fq.httpbase.processer.ResponseProcessor;
import com.google.common.io.Resources;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author jifang
 * @since 16/1/22下午5:10.
 */
public class HttpBaseTest {

    private HttpBase<Date> httpBase;

    @Before
    public void setUp() {
        httpBase = new HttpBase<Date>();
    }

    @Test
    public void client() {

        String url = "www.baidu.com";

        ResponseProcessor<String, Date> processor = new ResponseProcessor<String, Date>() {
            @Override
            public Date handle(String s) throws HttpBaseException {
                return new Date();
            }
        };

        httpBase.submit(url);
        Date date = httpBase.get(url, processor);
        System.out.println(date);
    }

    @Test
    public void stringClient() {
        StringHttpBase base = new StringHttpBase();
        base.submit("www.baidu.com/", "abs");
        System.out.println(base.get("www.baidu.com/", "abs"));
    }
    
    public static void main(String[] args) throws Exception {
		
    	
    	 String result = Resources.toString(new URL("http://www.baidu.com"), StandardCharsets.UTF_8);
    	
    	 System.out.println(result);
	}
}
