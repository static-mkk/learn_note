package kkcoder.myy.music;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class WangYi {

	
	/**
	 * request 信息
	 * 
	   'method'         => 'POST',
            'url'            => 'http://music.163.com/api/linux/forward',
            'referer'        => 'http://music.163.com/',
            'proxy'          => false,
	 *
	 * */
	String url1 = "http://music.163.com/api/linux/forward" ;
	URL url;
	String songName = "非酋" ;
	String referer = "http://music.163.com/" ;
	String user_agent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36" ;
	
	public void searchBuSongName(){

		try {
			url = new URL(url1);
		} catch (MalformedURLException e) {
			System.out.println("url = new URL(url1) 失败");
			e.printStackTrace();
		} 
		
		WebRequest request = new WebRequest(url);
		request.setSocksProxy(false);                            //不使用代理
		request.setHttpMethod(HttpMethod.POST);                  //post 提交
		request.setAdditionalHeader("Referer", referer);         //设置 referer头信息
		request.setAdditionalHeader("user-agent", user_agent);   //设置User-Agent字段
		
		/**获取加密后的body内容*/
		String body = getBody();
		request.setRequestBody(body);
		
		WebClient client = new WebClient();
		client.getCookieManager().setCookiesEnabled(true);//管理cookie
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(true);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setTimeout(1000 * 5);
		
		try {
			
			HtmlPage page = client.getPage(request);
			
			System.out.println(page.asXml());
			
		} catch (FailingHttpStatusCodeException | IOException e) {
			System.out.println("获取page 页面 失败！");
			e.printStackTrace();
		}
	}


	
	/**
	 * 返回加密后的  body 体
	 * */
	private String getBody() {

		/**
		 * body 体里面的内容
		 * */
		
		String method = "POST";
		String url = "http://music.163.com/api/cloudsearch/pc";
		
		Map<String,String> paramsMap = new HashMap<>();
		paramsMap.put("s", "非酋");
		paramsMap.put("type","1");
		paramsMap.put("offset","0");
		paramsMap.put("limit","10");
		
		Map<String,String> map = new HashMap<>();
		map.put("method", method);
		map.put("url",url);
		map.put("params",paramsMap.toString() );
		
		JSONObject  json  = new JSONObject(map);
		
		/**下面是加密处理*/
		String body = encode(json);
		return body;
	}

	/**
	 *  加密body 体里面的内容
	 * @param json body的json格式对象
	 * @return 返回加密后的 body String对象 , 例如  ( method=post&url=http://music.163.com/api/cloudsearch/pc& ...)  
	 */
	private String encode(JSONObject  json) {
		
		String key = "7246674226682325323F5E6544673A51";
		
		int pad = 16 - ( json.length() % 16 );	
		
		/**
		 *   这里的加密部分 不会写，
		 *   	
		 *   		实在是，菜。。。
		 *   
		 *   还是再学两年再来写吧！
		 * 
		 * 			2018/1/1
		 * */
		
		
		return null;
	}
	
	
}
