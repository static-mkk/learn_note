note  2017/12/29
<hr/>
<br/> 
note  2017/12/30
<hr/>

     1.今天看了一天的php的代码。<为了做一个在线搜索音乐的html>
          记录如下：    --> 网易云音乐为例
            i.获取音频接口地址<搜索的歌曲>
                'method'         => 'POST',
                'url'            => 'http://music.163.com/api/linux/forward',
                'referer'        => 'http://music.163.com/',
                'proxy'          => false,
                'body'           => encode_netease_data(array(//body里面内容需要加密 注①
                    'method'     => 'POST',
                    'url'        => 'http://music.163.com/api/cloudsearch/pc',
                    'params'     => array(
                        's'      => 查询的歌名,
                        'type'   => 1,
                        'offset' => 页码 * 10 - 10,
                        'limit'  => 10
                    )
                ))
        
            注① ；encode_netease_data
            function encode_netease_data($data)//mkk解密网易云音乐具体步骤
            {
            $_key     = '7246674226682325323F5E6544673A51';
            $data     = json_encode($data);//data为url的body参数的数组   json_encode（）返回json格式对象
            if (function_exists('openssl_encrypt')) {//mkkfunction_exists('openssl_encrypt')  判断函数openssl_encrypt是否存在  存在为true
            $data = openssl_encrypt($data, 'aes-128-ecb', pack('H*', $_key));
            } else {
            $_pad = 16 - (strlen($data) % 16); //mkk  strlen($data) 获取字符串长度
            $data = base64_encode(mcrypt_encrypt(//mkk  mcrypt_encrypt 方法 详解http://php.net/manual/zh/function.mcrypt-encrypt.php
                    //mkk base64_encode(data) 对data进行base64 编码
                MCRYPT_RIJNDAEL_128,//mkk mcrypt_encrypt() 加密数据并返回密文。
                hex2bin($_key),//mkk 转换十六进制字符串为二进制字符串
                $data.str_repeat(chr($_pad), $_pad),//mkk chr() 返回相应的字符
                //mkk str_repeat(char a, int b) 返回 char a 重复b次的字符串 b>=0  b==0,字符串为空
                //mkk php  字符串.字符串   ==  java  字符串+字符串  
                MCRYPT_MODE_ECB
            ));
            }
            $data     = strtoupper(bin2hex(base64_decode($data))); //mkk strtoupper（string） 返回string字符串大写
            return array('eparams' => $data);
            }
        
        ii.上面 i 的结果，是用来获取 指定歌名的歌曲的信息 查询的相关信息
           method，url，body等
           
            下面是，模拟浏览器来用发出请求，获取内容
            获取json内容  需要解析
            即可获取 搜索歌名的 id  ，再通过id，获取歌曲链接
            
            json_decode — 对 JSON 格式的字符串进行解码
            
            function mc_curl($args = array())//mkk2 根据 search来获取内容
            {
            $default      = array(
                'method'     => 'GET',
                'user-agent' => 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36',
                'url'        => null,
                'referer'    => 'https://www.google.co.uk',
                'headers'    => null,
                'body'       => null,
                'proxy'      => false
            );
            $args         = array_merge($default, $args);//合并数组，相同则后面数组内容覆盖前面
            $method       = mb_strtolower($args['method']);
            $method_allow = array('get', 'post');
            if (null === $args['url'] || !in_array($method, $method_allow, true)) {
                return;
            }
            $curl         = new Curl();
            $curl->setUserAgent($args['user-agent']);
            $curl->setReferrer($args['referer']);
            $curl->setTimeout(15);
            $curl->setHeader('X-Requested-With', 'XMLHttpRequest');
            $curl->setOpt(CURLOPT_FOLLOWLOCATION, true);
            if ($args['proxy'] && define('MC_PROXY')) {
                $curl->setOpt(CURLOPT_HTTPPROXYTUNNEL, 1);
                $curl->setOpt(CURLOPT_PROXY, MC_PROXY);
                $curl->setOpt(CURLOPT_PROXYUSERPWD, MC_PROXYUSERPWD);
            }
            if (!empty($args['headers'])) {
                $curl->setHeaders($args['headers']);
            }
            $curl->$method($args['url'], $args['body']);
            $curl->close();
            if (!$curl->error) {
                return $curl->rawResponse;
            }
            }
            
            