package com.fire.back.util;

import com.alibaba.fastjson.JSONObject;
import com.fire.back.constant.WxConstant;
import com.fire.back.controller.app.UserController;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.*;

/**
 * 微信工具类
 * create by gao
 */
public class WxUtils {
    /**
     * 使用用户code从微信换取sessionKey和openid
     * 返回结果组装成map
     * @param code
     * @return
     */
    public Map<String,Object> getSessionKey(String code){
        if(!StringUtils.isNullOrEmpty(code)){
            String loginUrl = WxConstant.loginUrl;
            loginUrl = loginUrl + code;
            //返回结果map
            Map<String,Object> resultMap = null;
            try{
                //构建client
                HttpClient client = HttpClientBuilder.create().build();
                //构建一个get请求
                HttpGet get = new HttpGet(loginUrl.toString());
                //发送get请求
                HttpResponse res = client.execute(get);
                //获取返回entity
                HttpEntity resEntity = res.getEntity();
                String resContent = EntityUtils.toString(resEntity);
                System.out.println(resContent);
                //把信息封装成JSON
                JSONObject resJson = JSONObject.parseObject(resContent);
                //把信息封装成map
                resultMap = JsonUtils.parseJSON2Map(resJson);
            }catch (Exception e){
                e.printStackTrace();
            }
            return resultMap;
        }else{
            return null;
        }
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilder documentBuilder = WXPayXmlUtil.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 获取指定长度的随机字符串 范围："a-z"+"0-9"
     * @param length 指定字符串长度
     * @return
     */
    public static String getRandomStringByLength(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取真实ip的值
     * @param request
     * @return
     */
    public static String getLocalIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isNullOrEmpty(ip) && !"unKnow".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个才是真实ip地址
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(!StringUtils.isNullOrEmpty(ip) && !"unKown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }

    //获取本机ip地址
    public static String getLocalIp(){
        InetAddress ia = null;
        String localIp = null;
        try {
            ia = ia.getLocalHost();
            localIp = ia.getHostAddress();
        }catch (Exception e){
            e.printStackTrace();
        }
        return localIp;
    }
    /**
     * 创建32位订单号
     * @return
     */
    public static String createOrderNo(){
        String orderNo = UUID.randomUUID().toString();
        orderNo = orderNo.replace("-","");
        return orderNo;
    }

    /**
     * 除去参数中的空参数和签名参数
     * @param param
     * @return
     */
    public static Map<String,String> paramFilter(Map<String,String> param){
        Map<String,String> result = new HashMap<>();
        if(param == null || result.size() <= 0){
            return result;
        }
        for(String key:param.keySet()){
            String value = param.get(key);
            if(StringUtils.isNullOrEmpty(value) || "sign".equalsIgnoreCase(key) || "sign_type".equalsIgnoreCase(key)){
                continue;
            }
            result.put(key,value);
        }
        return result;
    }

    /**
     * 发送http请求
     * @param requestUrl        url
     * @param requestMethod     type
     * @param outputStr         参数
     * @return
     */
    public static String httpRequest(String requestUrl,String requestMethod,String outputStr){
        //创建SSLContext
        StringBuffer buffer = null;
        try{
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //向服务器写入参数
            if(null != outputStr){
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }
            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while((line = br.readLine()) != null){
                buffer.append(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String sign(String text,String key,String inputCharset){
        text = text + "&key=" + key;
        return DigestUtils.md5Hex(getContentBytes(text,inputCharset));
    }

    /**
     *
     * @param content   主体
     * @param charset   编码格式
     * @return
     */
    public static byte[] getContentBytes(String content,String charset){
        if(StringUtils.isNullOrEmpty(charset)){
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        }catch (UnsupportedEncodingException e){
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 将Map类型的params组装成 key=value&key=value形式的字符串
     * @param params
     * @return
     */
    public static String createLinkString(Map<String,String> params){
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        String preStr = "";
        for(int i = 0; i < keys.size(); i++){
            String key = keys.get(i);
            String value = params.get(key);
            if(i == keys.size() - 1){
                //最后一个参数不需要加&
                preStr = preStr + key + "=" + value;
            }else{
                preStr = preStr + key + "=" + value + "&";
            }
        }
        return preStr;
    }

    /**
     * 转换金额单位  元 -> 分
     * @param amount
     * @return
     */
    public static String changeY2F(String amount){
        return new BigDecimal(amount).multiply(new BigDecimal(100)).setScale(0).toString();
    }

    /**
     * map转换成xml
     * @param map
     * @return
     * @throws Exception
     */
    public static String mapToXml(SortedMap<String,String> map) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //防止XXE攻击
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: map.keySet()) {
            String value = map.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString();
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }

    /**
     * 创建签名Sign
     *
     * @param key
     * @param parameters
     * @return
     */
    public static String createSign(SortedMap<String,String> parameters,String key){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator<?> it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            if(entry.getValue() != null || !"".equals(entry.getValue())) {
                String v = String.valueOf(entry.getValue());
                if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                    sb.append(k + "=" + v + "&");
                }
            }
        }
        sb.append("key=" + key);
        String sign = DigestUtils.md5Hex(sb.toString()).toUpperCase();
        return sign;
    }
}
