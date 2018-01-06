1.������ �� pom �ļ�����д�����е� dependency <br/>


<!--spring-mvc �� ������-->    

```xml
        <!--����ֻ��spring web  ������ jar   ���а�����pom.xml �ļ� -->
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-web</artifactId>  
            <version>${spring.version}</version>  
            <type>jar</type>  
            <scope>compile</scope>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-webmvc</artifactId>  
            <version>${spring.version}</version>  
            <type>jar</type> 
            <scope>compile</scope>  
        </dependency>  
```  
        
2.web.xml ���� spring-mvc �� ������servlet  class  <br/>

3. spring-mvc  ��servlet.xml �ļ��У�����  �Զ�ɨ���url  �Լ� ���� ��ͼ������ <br/>

4. post �ύ�����������  �޸���request �� charset û��Ч�� <ʵ���ϣ�ֻ����request���ʼ�ĵط����� charset����Ч ��><br/>

5. �� web.xml �ļ��� �����ַ�������  ʵ���Ͼ��ǰ���Դͷ�� request �� response �� charset ���ó� UTF-8 <br/>

```java
    <filter>                                                           
        <description>�ַ���������</description>                      
        <filter-name>encodingFilter</filter-name>                   
        <filter-class>                                             
          org.springframework.web.filter.CharacterEncodingFilter  
        </filter-class>                                       
        <init-param>                                                                      
            <description>�ַ�������</description>                    
            <param-name>encoding</param-name>                                            
            <param-value>UTF-8</param-value>                                     
        </init-param>                                                                 
    </filter>                                                              
    <filter-mapping>                                                     
        <filter-name>encodingFilter</filter-name>                      
        <url-pattern>/*</url-pattern>                               
    </filter-mapping>     
```    