note  2017/12/30
<hr/>

     1.���쿴��һ���php�Ĵ��롣<Ϊ����һ�������������ֵ�html>
          ��¼���£�    --> ����������Ϊ��
            i.��ȡ��Ƶ�ӿڵ�ַ<�����ĸ���>
                'method'         => 'POST',
                'url'            => 'http://music.163.com/api/linux/forward',
                'referer'        => 'http://music.163.com/',
                'proxy'          => false,
                'body'           => encode_netease_data(array(//body����������Ҫ���� ע��
                    'method'     => 'POST',
                    'url'        => 'http://music.163.com/api/cloudsearch/pc',
                    'params'     => array(
                        's'      => ��ѯ�ĸ���,
                        'type'   => 1,
                        'offset' => ҳ�� * 10 - 10,
                        'limit'  => 10
                    )
                ))
        
            ע�� ��encode_netease_data
            function encode_netease_data($data)//mkk�������������־��岽��
            {
            $_key     = '7246674226682325323F5E6544673A51';
            $data     = json_encode($data);//dataΪurl��body����������   json_encode��������json��ʽ����
            if (function_exists('openssl_encrypt')) {//mkkfunction_exists('openssl_encrypt')  �жϺ���openssl_encrypt�Ƿ����  ����Ϊtrue
            $data = openssl_encrypt($data, 'aes-128-ecb', pack('H*', $_key));
            } else {
            $_pad = 16 - (strlen($data) % 16); //mkk  strlen($data) ��ȡ�ַ�������
            $data = base64_encode(mcrypt_encrypt(//mkk  mcrypt_encrypt ���� ���http://php.net/manual/zh/function.mcrypt-encrypt.php
                    //mkk base64_encode(data) ��data����base64 ����
                MCRYPT_RIJNDAEL_128,//mkk mcrypt_encrypt() �������ݲ��������ġ�
                hex2bin($_key),//mkk ת��ʮ�������ַ���Ϊ�������ַ���
                $data.str_repeat(chr($_pad), $_pad),//mkk chr() ������Ӧ���ַ�
                //mkk str_repeat(char a, int b) ���� char a �ظ�b�ε��ַ��� b>=0  b==0,�ַ���Ϊ��
                //mkk php  �ַ���.�ַ���   ==  java  �ַ���+�ַ���  
                MCRYPT_MODE_ECB
            ));
            }
            $data     = strtoupper(bin2hex(base64_decode($data))); //mkk strtoupper��string�� ����string�ַ�����д
            return array('eparams' => $data);
            }
        
        ii.���� i �Ľ������������ȡ ָ�������ĸ�������Ϣ ��ѯ�������Ϣ
           method��url��body��
           
            �����ǣ�ģ����������÷������󣬻�ȡ����
            ��ȡjson����  ��Ҫ����
            ���ɻ�ȡ ���������� id  ����ͨ��id����ȡ��������
            
            json_decode �� �� JSON ��ʽ���ַ������н���
            
            function mc_curl($args = array())//mkk2 ���� search����ȡ����
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
            $args         = array_merge($default, $args);//�ϲ����飬��ͬ������������ݸ���ǰ��
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
            
            