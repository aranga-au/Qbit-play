package org.oss.qbit.hello;

import io.advantageous.qbit.annotation.RequestMapping;

/**
 * Created by arang on 4/08/2016.
 */
@RequestMapping("/")
public class HelloWorld
{
    @RequestMapping("hello")
    public String sayHellow()
    {
        return "Hello "+System.currentTimeMillis();
    }
}
