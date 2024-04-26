package com.ict.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxTestController {
	
	// servlet-context.xml(디스패터서블릿)로 리턴되지 않고 브라우저에 출력
	// 반환형이 String 인 경우 문서타입이 contentType="text/html" 타입으로 알라서 처리 됨
	@RequestMapping(value = "test01.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String Text_Exam01() {
		String msg = "<h2>Hello World Spring Ajax !! <br>환영합니다.</h2>";
		return msg ;
	}
	
	@RequestMapping(value = "test02.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String Xml_Exam02() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product>");
		sb.append("<name>흰우유</name>");
		sb.append("<price>950</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>딸기우유</name>");
		sb.append("<price>1050</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>초코우유</name>");
		sb.append("<price>1100</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>바나나우유</name>");
		sb.append("<price>1550</price>");
		sb.append("</product>");
		sb.append("</products>");
		return sb.toString();
	}
	
	@RequestMapping(value = "test03.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String Xml_Exam03() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product count=\"5\" name=\"제너시스\" />");
		sb.append("<product count=\"7\" name=\"카렌스\" />");
		sb.append("<product count=\"9\" name=\"카니발\" />");
		sb.append("<product count=\"5\" name=\"카스타\" />");
		sb.append("<product count=\"2\" name=\"트위치\" />");
		sb.append("</products>");
		return sb.toString();
	}
	
	@RequestMapping(value = "test04.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String Xml_Exam04() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product count=\"5\" name=\"제너시스\">현대자동차</product>");
		sb.append("<product count=\"7\" name=\"카렌스\">기아자동차</product>");
		sb.append("<product count=\"9\" name=\"카니발\">기아자동차</product>");
		sb.append("<product count=\"5\" name=\"카스타\">기아자동차</product>");
		sb.append("<product count=\"2\" name=\"트위치\">르노자동차</product> ");
		sb.append("</products>");
		return sb.toString();
	}
	
	@RequestMapping(value = "test05.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String Xml_Exam05() {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String msg = null;
			while((msg=br.readLine()) != null) {
				sb.append(msg);
			}
			return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping(value = "test06.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String Json_Exam06() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(" {\"name\" : \"HTML\", \"scope\" : \"15\"},");
		sb.append(" {\"name\" : \"CSS\", \"scope\" : \"10\"},");
		sb.append(" {\"name\" : \"JavaScript\", \"scope\" : \"17\"},");
		sb.append(" {\"name\" : \"JSP\", \"scope\" : \"13\"}");
		sb.append("]");
		return sb.toString();
	}
	
	@RequestMapping(value = "test07.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String Json_Exam07() {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL url = new URL("https://raw.githubusercontent.com/paullabkorea/coronaVaccinationStatus/main/data/data.json");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String msg = null;
			while((msg=br.readLine()) != null) {
				sb.append(msg);
			}
			return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@RequestMapping(value = "dustdata.do", produces="text/xml; charset=utf-8")
	@ResponseBody
	public String dustData() {
	    BufferedReader rd = null;
	    HttpURLConnection conn = null;
		try {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "serviceKey"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode("서울", "UTF-8")); /*시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)*/
        urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8") + "=" + URLEncoder.encode("1.0", "UTF-8")); /*버전별 상세 결과 참고*/
        URL url = new URL(urlBuilder.toString());
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
    
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			  try {
				rd.close();
				conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return null;
	}
	
	@RequestMapping(value = "dustdata2.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String dustData2() {
	    BufferedReader rd = null;
	    HttpURLConnection conn = null;
		try {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "serviceKey"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode("서울", "UTF-8")); /*시도 이름(전국, 서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)*/
        urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8") + "=" + URLEncoder.encode("1.0", "UTF-8")); /*버전별 상세 결과 참고*/
        URL url = new URL(urlBuilder.toString());
        conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestMethod("GET");
        // 생략가능
        //conn.setRequestProperty("Content-type", "application/json");
        
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			  try {
				rd.close();
				conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return null;
	}
}










