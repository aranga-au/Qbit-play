package org.oss.qbit.hello;

import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by arang on 4/08/2016.
 */
@RequestMapping("/")
public class GoodMorning
{


    @RequestMapping("morning")
    public String sayMorning()
    {
        return "Good Morning";
    }
    @RequestMapping("morning/{id}")
    public String sayMorning1(@PathVariable("id") Long id)
    {
        return "Good Morning "+id;
    }
}
