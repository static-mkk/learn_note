1.������ �� pom �ļ�����д�����е� dependency <br/>
<!--spring-mvc �� ������-->    <br/>                   
        <dependency>  <br/>
            <groupId>org.springframework</groupId>  <br/>
            <artifactId>spring-web</artifactId>  <br/>
            <version>${spring.version}</version>  <br/>
            <type>jar</type>  <br/>
            <scope>compile</scope>  <br/>
        </dependency>  <br/>
        <dependency>  <br/>
            <groupId>org.springframework</groupId>  <br/>
            <artifactId>spring-webmvc</artifactId>  <br/>
            <version>${spring.version}</version>  <br/>
            <type>jar</type>  <br/>
            <scope>compile</scope>  <br/>
        </dependency>  <br/>
        
2.web.xml ���� spring-mvc �� ������servlet  class  <br/>

3. spring-mvc  ��servlet.xml �ļ��У�����  �Զ�ɨ���url  �Լ� ���� ��ͼ������ <br/>

4. post �ύ�����������  �޸���request �� charset û��Ч�� <ʵ���ϣ�ֻ����request���ʼ�ĵط����� charset����Ч ��><br/>

5. �� web.xml �ļ��� �����ַ�������  ʵ���Ͼ��ǰ���Դͷ�� request �� response �� charset ���ó� UTF-8 <br/>
    <filter>                                                             <br/>
        <description>�ַ���������</description>                        <br/>
        <filter-name>encodingFilter</filter-name>                    <br/>
        <filter-class>                                              <br/>
          org.springframework.web.filter.CharacterEncodingFilter  <br/>
        </filter-class>                                         <br/>
        <init-param>                                               <br/>                             
            <description>�ַ�������</description>                     <br/>   
            <param-name>encoding</param-name>                           <br/>                    
            <param-value>UTF-8</param-value>                              <br/>          
        </init-param>                                                                   <br/>
    </filter>                                                               <br/>
    <filter-mapping>                                                     <br/>   
        <filter-name>encodingFilter</filter-name>                       <br/>
        <url-pattern>/*</url-pattern>                                 <br/>
    </filter-mapping>                                               <br/>