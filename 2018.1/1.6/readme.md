1.首先是 在 pom 文件里面写上所有的 dependency <br/>


<!--spring-mvc 的 依赖包-->    

```xml
        <!--这里只是spring web  的两个 jar   所有包，看pom.xml 文件 -->
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
        
2.web.xml 配置 spring-mvc 的 分派器servlet  class  <br/>

3. spring-mvc  的servlet.xml 文件中，加上  自动扫描包url  以及 配置 视图解析器 <br/>

4. post 提交表格中文乱码  修改了request 的 charset 没有效果 <实际上，只能在request的最开始的地方设置 charset才有效 。><br/>

5. 在 web.xml 文件中 配置字符集编码  实际上就是把最源头的 request 和 response 的 charset 设置成 UTF-8 <br/>

```java
    <filter>                                                           
        <description>字符集过滤器</description>                      
        <filter-name>encodingFilter</filter-name>                   
        <filter-class>                                             
          org.springframework.web.filter.CharacterEncodingFilter  
        </filter-class>                                       
        <init-param>                                                                      
            <description>字符集编码</description>                    
            <param-name>encoding</param-name>                                            
            <param-value>UTF-8</param-value>                                     
        </init-param>                                                                 
    </filter>                                                              
    <filter-mapping>                                                     
        <filter-name>encodingFilter</filter-name>                      
        <url-pattern>/*</url-pattern>                               
    </filter-mapping>     
```    