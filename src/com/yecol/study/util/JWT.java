package com.yecol.study.util;



import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.yecol.study.account.domain.Account;
 
/**
 * JWT工具类
 * @author wenber
 *
 */
public class JWT {  
	
	public static void main(String[] args) throws InterruptedException {
		
		Account account=new Account("wenber", "123456");
		//用jwt生成token
		String string=sign(account, 3000);
		System.out.println(string);
		
		//Thread.sleep(1000);
		//解开
		account=unsign(string+"sdf", Account.class);
		System.out.println(account);
	}
	
    private static final String SECRET = "wenberisgoodman";  
    
    private static final String EXP = "exp";  
      
    private static final String PAYLOAD = "payload";  
  
    /** 
     * get jwt String of object 取得签名
     * @param object 
     *            the POJO object 存放的对象
     * @param maxAge 
     *            the milliseconds of life time  生命周期
     * @return the jwt token 
     */  
    public static <T> String sign(T object, long maxAge) {  
        try {  
            final JWTSigner signer = new JWTSigner(SECRET);  
            final Map<String, Object> claims = new HashMap<String, Object>();  
            ObjectMapper mapper = new ObjectMapper();  
            String jsonString = mapper.writeValueAsString(object);  
            //载荷数据【存放我们需要的对象】
            claims.put(PAYLOAD, jsonString);  
            //有效期
            claims.put(EXP, System.currentTimeMillis() + maxAge);  
            return signer.sign(claims);  
        } catch(Exception e) {  
            return null;  
        }  
    }  
      
      
    /** 
     * 解开签名
     * get the object of jwt if not expired 
     * @param jwt 
     * @return POJO object 
     */  
    public static<T> T unsign(String jwt, Class<T> classT) {  
        final JWTVerifier verifier = new JWTVerifier(SECRET);  
        try {  
            final Map<String,Object> claims= verifier.verify(jwt);  
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {  
                long exp = (Long)claims.get(EXP);  
                long currentTimeMillis = System.currentTimeMillis();  
                //是否过期 如果大于当前时间则失效
                if (exp > currentTimeMillis) {  
                    String json = (String)claims.get(PAYLOAD);  
                    ObjectMapper objectMapper = new ObjectMapper();  
                    return objectMapper.readValue(json, classT);  
                } 
            }  
            return null;  
        } catch (Exception e) {  
            return null;  
        }  
    }  

}
